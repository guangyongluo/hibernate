package com.vilin.hibernate.util;

public class TransactionManager {

	public static void beginTransaction() {
		HibernateUtil.getSession().beginTransaction();
	}
	
	public static void commit() {
		HibernateUtil.getSession().getTransaction().commit();
		HibernateUtil.close();
	}
	
	public static void rollback() {
		HibernateUtil.getSession().getTransaction().rollback();
		HibernateUtil.close();
	}
}
