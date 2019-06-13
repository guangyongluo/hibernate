package com.vilin.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vilin.hibernate.domain.Account;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test {

	public static void main(String[] args) {
		test03();
	}
	
	//一级缓存
	public static void test01() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Account account = (Account)session.get(Account.class, 1);
			System.out.println(account);
			
//			session.clear();
			session.evict(account);
			
			Account account2 = (Account)session.get(Account.class, 1);
			System.out.println(account2);
			System.out.println(account == account2);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	//二级缓存
	public static void test02() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Account account1 = (Account)session.get(Account.class, 1);
			System.out.println(account1);
			
			TransactionManager.commit();
			
			session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Account account2 = (Account)session.get(Account.class, 1);
			System.out.println(account2);
			System.out.println(account1 == account2);
			
			TransactionManager.commit();
			
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}

    //查询缓存
	public static void test03() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

//			String hql = "from Account a where a.id=1";
			String hql = "from Account a where a.username like :name";
//			Account account1 = (Account)session.createQuery(hql).uniqueResult();
			Query query = session.createQuery(hql).setParameter("name", "%m%");
			query.setCacheable(true);
			System.out.println(query.list());
			TransactionManager.commit();
			
			HibernateUtil.close();
			
			session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

//			Account account2 = (Account)session.createQuery(hql).uniqueResult();
			query = session.createQuery(hql).setParameter("name", "%m%").setCacheable(true);
			System.out.println(query.list());
			TransactionManager.commit();
			
			HibernateUtil.close();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
