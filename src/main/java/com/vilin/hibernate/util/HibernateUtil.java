package com.vilin.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> local = new ThreadLocal<Session>();
	
	static {
		serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session = local.get();
		if(session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
			local.set(session);
		}
		return session;
	}
	
	public static void close() {
		Session session = local.get();
		if(session != null) {
			session.close();
			local.remove();
//			sessionFactory.close();
//			serviceRegistry.close();
		}
	
	}
}
