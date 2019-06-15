package com.vilin.hibernate.domain.annotation;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test {

	public static void main(String[] args) {
		test03();
	}
	
	public static void test01() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Dept dept = new Dept();
			dept.setName("d4");
			
			session.save(dept);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	public static void test02() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Dept dept = new Dept();
			dept.setName("开发部门");
			Emp emp1 = new Emp("张三");
			Emp emp2 = new Emp("李四");	
			dept.getEmps().add(emp1);
			dept.getEmps().add(emp2);
			emp1.setDept(dept);
			emp2.setDept(dept);
			session.save(dept);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	public static void test03() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Query query = session.getNamedQuery("findById");
			Emp emp = (Emp)query.setParameter("id", 1).uniqueResult();
			System.out.println(emp);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
