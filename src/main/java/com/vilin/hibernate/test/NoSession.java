package com.vilin.hibernate.test;

import org.hibernate.Session;

import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class NoSession {

	public static User dao() {
		Session session = HibernateUtil.getSession();
		User user = session.get(User.class, 3);
		return user;
	}
	
	public static User service() {
		TransactionManager.beginTransaction();
		User user = dao();
		TransactionManager.commit();
		return user;
	}
	
	public static void action() {
		User user = service();
		System.out.println(user);
	}
	
	public static void main(String[] args) {
		action();
	}
	
}
