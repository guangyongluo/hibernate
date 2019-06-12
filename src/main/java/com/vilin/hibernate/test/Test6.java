package com.vilin.hibernate.test;

import org.hibernate.Session;

import com.vilin.hibernate.domain.Manager;
import com.vilin.hibernate.domain.Member;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test6 {

	public static void main(String[] args) {
		select();
	}
	
	public static void select() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Manager manager = session.get(Manager.class, 1);
			System.out.println(manager);
			
			Member member = session.get(Member.class, 2);
			System.out.println(member);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	public static void select2() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Manager manager = session.get(Manager.class, 1);
			System.out.println(manager);
			
			Member member = session.get(Member.class, 1);
			System.out.println(member);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
