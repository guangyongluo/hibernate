package com.vilin.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.util.HibernateUtil;

public class SessionAPI {

	public static void main(String[] agrs) {
		insert();
	}
	
	public static void insert() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User user = new User(null, "莫声谷", "123456", 28);
		session.save(user);
		tx.commit();
		HibernateUtil.close();
	}
	
	public static void delete() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User user = new User(null, "abc", "654321", 88);
		session.delete(user);
		tx.commit();
		HibernateUtil.close();
	}
	
	public static void load() {
		Session session = HibernateUtil.getSession();
		User user = session.load(User.class, 3);
		System.out.println(user);
		HibernateUtil.close();
	}
	
	public static void get() {
		Session session = HibernateUtil.getSession();
		//User user = (User)session.get("com.vilin.hibernate.domain.User", 2);
		User user = (User)session.get(User.class, 3);
		System.out.println(user);
		HibernateUtil.close();
	}
	
	public static void update() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
//		User user = new User(2, "abc", "654321", 88);
		User user = new User();
		user.setId(2);
		user.setUsername("张三丰");
		session.update(user);
		tx.commit();
		HibernateUtil.close();
	}
	
	public static void saveOrUpdate() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User user = new User(2, "张无忌", "123456", 18);
		session.saveOrUpdate(user);
		tx.commit();
		HibernateUtil.close();
	}
	
	public static void merge() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		User user = new User(2, "张无忌", "123456", 18);
		User mUser = (User) session.merge(user);
		tx.commit();
		HibernateUtil.close();
	}
}
