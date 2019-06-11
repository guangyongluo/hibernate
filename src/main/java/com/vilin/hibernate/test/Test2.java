package com.vilin.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.vilin.hibernate.domain.Clazz;
import com.vilin.hibernate.domain.Student;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test2 {

	public static void main(String[] args) {
		inverse();
	}
	
	public static void select() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Clazz clazz = session.load(Clazz.class, 1);
			System.out.println(clazz.getName());
			System.out.println("-------------");
			for(Student student : clazz.getStudents()) {
				System.out.println(student.getName());
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

			Clazz c = new Clazz(null, "cls4");
			Set<Student> students = new HashSet<Student>();
			students.add(new Student(null, "tom"));
			students.add(new Student(null, "jack"));
			c.setStudents(students);
			session.save(c);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	public static void delete() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();
            //持久态对象级联删除班级中的所有学生
			Clazz c = session.load(Clazz.class, 2);
			
			//游离态对象只删除班级，班级中所有学生外键设置为null
//			Clazz c = new Clazz();
//			c.setId(1);
			
			
//			Clazz c = new Clazz();
//			c.setId(2);
//			Student s = new Student();
//			s.setId(2);
//			Set<Student> students = new HashSet<Student>();
//			students.add(s);
//			c.setStudents(students);
			session.delete(c);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}

    public static void inverse() {
    	try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Clazz c = session.load(Clazz.class, 2);
//			session.delete(c);
			System.out.println(c);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
    }
}
