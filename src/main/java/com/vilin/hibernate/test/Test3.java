package com.vilin.hibernate.test;

import org.hibernate.Session;

import com.vilin.hibernate.domain.Course;
import com.vilin.hibernate.domain.Stu;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test3 {

	public static void main(String[] args) {
		save();
	}
	
	public static void select() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Stu stu = session.get(Stu.class, 1);
			System.out.println(stu.getName());
			System.out.println("-----------");
			for(Course course : stu.getCourses()) {
			    System.out.println(course.getName());
			}
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}

    public static void save() {
    	try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Stu s1 = new Stu(null, "tom");
			Stu s2 = new Stu(null, "jack");
			Course c1 = new Course(null, "hibernate");
			Course c2 = new Course(null, "oracle");
			//Tom、Jack同时选择了hibernate课程
			c1.getStu().add(s1);
			c1.getStu().add(s2);
			s1.getCourses().add(c1);
			s2.getCourses().add(c1);
			//Jack选择了oracle
			c2.getStu().add(s2);
			s2.getCourses().add(c2);
			//保存课程时级联保存学生
			session.save(c1);
			session.save(c2);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
    }

}
