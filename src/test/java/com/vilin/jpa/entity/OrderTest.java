package com.vilin.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.jpa.QueryHints;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OrderTest {

	private EntityManagerFactory createEntityManagerFactory;
	private EntityManager createEntityManager;
	private EntityTransaction transaction;
	
	@Before
	public void init() {
		createEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		createEntityManager = createEntityManagerFactory.createEntityManager();
		transaction = createEntityManager.getTransaction();
		transaction.begin();
	}
	
	@Ignore
	@Test
	public void addStudent() {
		Student student = new Student();
		student.setName("哪吒");
		student.setMail("nezha@163.com");
		student.setBirthday(new Date());
		
		Order order1 = new Order();
		order1.setName("N-S-7");
		
		Order order2 = new Order();
		order2.setName("N-S-8");
		
		order1.setStudent(student);
		order2.setStudent(student);
		
		createEntityManager.persist(student);
		createEntityManager.persist(order1);
		createEntityManager.persist(order2);
	}
	
	/*
	 * 在默认的情况下，使用的是做外连接的方式获取数据
	 * 可以使用懒加载
	 */
	@Ignore
	@Test
	public void findOrder() {
		Order order = createEntityManager.find(Order.class, 6);
		
		System.out.println("find order name >> " + order.getName());
		
		System.out.println("find order student >> " + order.getStudent());
	}
	
	/*
	 * 不能删除1的一端，可以删除N端
	 */
	@Ignore
	@Test
	public void removeOrder() {
		Order order = createEntityManager.find(Order.class, 10);
		createEntityManager.remove(order);
	}
	
	/*
	 * 持久态的数据的修改在提交后会被报存在数据库中
	 */
	@Ignore
	@Test
	public void updateOrder() {
		Order order = createEntityManager.find(Order.class, 5);
		order.setName("N-S-0");
		order.getStudent().setName("李天王");
		order.getStudent().setMail("litianwang@163.com");
	}
	
	@Ignore
	@Test
	public void JPQLselect() {
		String jpql = "FROM Order o WHERE o.id>?0";
		Query query = createEntityManager.createQuery(jpql);
		query.setParameter(0, 2);
		List resultList = query.getResultList();
		System.out.println(resultList.size());
		System.out.println(resultList.get(0));
	}
	
	@Ignore
	@Test
	public void JPQLselect2() {
		String jpql = "SELECT o.id, o.name FROM Order o WHERE o.id>?0";
		Query query = createEntityManager.createQuery(jpql);
		query.setParameter(0, 2);
		List resultList = query.getResultList();
		System.out.println(resultList.size());
	}
	
	@Ignore
	@Test
	public void JPQLSetHint() {
		String JPQL = "FROM Order O WHERE O.id>?1";
		Query createQuery = createEntityManager.createQuery(JPQL).setHint(QueryHints.HINT_CACHEABLE, true);
		createQuery.setParameter(1, 3);
		List resultList = createQuery.getResultList();
		System.out.println(">>>>" + resultList.size());
		
		System.out.println("====================");
		createQuery = createEntityManager.createQuery(JPQL).setHint(QueryHints.HINT_CACHEABLE, true);
		createQuery.setParameter(1, 4);
		resultList = createQuery.getResultList();
		System.out.println(">>>>" + resultList.size());
	}
	
	@Ignore
	@Test
	public void testOrderBy() {
		String jpql = "FROM Order o where o.id > ?0 Order By o.id desc";
		List resultList = createEntityManager.createQuery(jpql).setParameter(0, 3).getResultList();
		System.out.println("resultList >> " + resultList.size());
		System.out.println("resultList >> " + resultList);
	}
	
	@Ignore
	@Test
	public void testGroupByAndHaving() {
		String jpql = "SELECT new com.vilin.jpa.entity."
				+ "Order(O.id, O.name) FROM Order O GROUP BY O.name HAVING O.id>?0";
		List resultList = createEntityManager.createQuery(jpql).setParameter(0, 5).getResultList();
		System.out.println("resultList >> " + resultList.size());
		System.out.println("resultList >> " + resultList);
	}
	
	@Ignore
	@Test
	public void testJPQLJoin() {
		String jpql = "FROM Order O Left OUTER Join FETCH O.student WHERE O.id=?0";
		List resultList = createEntityManager.createQuery(jpql).setParameter(0, 1).getResultList();
		System.out.println("resultList >> " + resultList);
	}
	
	@Ignore
	@Test
	public void testSubJPQL() {
		String jpql = "FROM Order O where O.student = (SELECT S FROM Student S WHERE S.id=?0)";
		List resultList = createEntityManager.createQuery(jpql).setParameter(0, 11).getResultList();
		System.out.println("resultList >> " + resultList.size());
		System.out.println("resultList >> " + resultList);
	}
	
	@Ignore
	@Test
	public void testfunJPQL() {
		String jpql = "SELECT upper(O.name) FROM Order O";
		List resultList = createEntityManager.createQuery(jpql).getResultList();
		System.out.println("resultList >> " + resultList.size());
		System.out.println("resultList >> " + resultList);
		
	}
	
	@Ignore
	@Test
	public void testUpdateJPQL() {
		String jpql = "UPDATE Order O SET O.name=?0 WHERE O.id=?1";
		createEntityManager.createQuery(jpql).setParameter(0, "order1").setParameter(1, 1).executeUpdate();
	    
	}
	
	@Ignore
	@Test
	public void testDeleteJPQL() {
		String jpql = "DELETE Order O WHERE O.id=?0";
	    createEntityManager.createQuery(jpql).setParameter(0, 9).executeUpdate();
	}
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
