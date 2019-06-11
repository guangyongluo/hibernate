package com.vilin.hibernate.test;

import org.hibernate.Session;

import com.vilin.hibernate.domain.Customer;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test5 {

	public static void main(String[] args) {
		select();
	}
	
	public static void select() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Customer customer = session.get(Customer.class, 1);
			System.out.println(customer.getName());
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
