package com.vilin.jpa.entity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
