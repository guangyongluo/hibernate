package com.vilin.hibernate.test;

import org.hibernate.Session;

import com.vilin.hibernate.domain.Card;
import com.vilin.hibernate.domain.Person;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test4 {

	public static void main(String[] args) {
		select();
	}
	
	public static void save() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Card c = new Card();
			c.setName("张三的card");
			Person p = new Person();
			p.setName("张三");
			c.setPerson(p);
			p.setCard(c);
			
			session.save(p);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	public static void select() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Person p = session.get(Person.class, 1);
			System.out.println(p.getName());
			System.out.println("---------");
			System.out.println(p.getCard().getName());
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
}
