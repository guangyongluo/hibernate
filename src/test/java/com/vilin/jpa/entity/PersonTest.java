package com.vilin.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Ignore;
import org.junit.Test;

public class PersonTest {
    
	@Ignore
	@Test
	public void test() {
		//1.获取EntityManagerFactory对象
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		//2.获取EntityManager对象
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		//3.开启事务
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		//4.进行持久化
		Person person = new Person();
		person.setName("猪八戒");
		person.setDate(new Date());
		person.setBirth(new Date());
		person.setSex("男");
		createEntityManager.persist(person);
		//5.提交事务
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
	
	@Ignore
	@Test
	public void testJPQL() {
		//1.获取EntityManagerFactory对象
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		//2.获取EntityManager对象
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		//3.开启事务
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		//4.进行持久化
		
		String jpql = "SELECT new Person(P.id, P.name) FROM Person P WHERE P.id=?1";
		Query createQuery = createEntityManager.createQuery(jpql);
		createQuery.setParameter(1, 1);
		List resultList = createQuery.getResultList();
		System.out.println(resultList.size());
		System.out.println(resultList);
		
		//5.提交事务
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
	
	@Ignore
	@Test
	public void testNamedQuery() {
		//1.获取EntityManagerFactory对象
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		//2.获取EntityManager对象
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		//3.开启事务
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		//4.进行持久化
		
		List resultList = createEntityManager.createNamedQuery("nameQuery").setParameter(1, 1).getResultList();
		System.out.println(resultList);
		
		//5.提交事务
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
	
	@Ignore
	@Test
	public void testNativeQuery() {
		//1.获取EntityManagerFactory对象
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		//2.获取EntityManager对象
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		//3.开启事务
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		//4.进行持久化
		String sql = "SELECT P.name FROM JPA_PERSON P WHERE P.id=?";
		Object resultList = createEntityManager.createNativeQuery(sql).setParameter(1, 1).getSingleResult();
		System.out.println(resultList);
		
		//5.提交事务
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
