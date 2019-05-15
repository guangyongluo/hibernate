package com.vilin.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ManyToManyTest {
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
	public void addItem() {
		Item item1 = new Item();
		item1.setName("I001");
		
		Item item2 = new Item();
		item2.setName("I002");
		
		Category category1 = new Category();
		category1.setName("G001");
		
		Category category2 = new Category();
		category2.setName("G001");
		
		item1.getCategories().add(category1);
		item1.getCategories().add(category2);
		
		item2.getCategories().add(category1);
		item2.getCategories().add(category2);
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		
		category2.getItems().add(item1);
		category2.getItems().add(item2);
		
		createEntityManager.persist(item1);
		createEntityManager.persist(item2);
		createEntityManager.persist(category1);
		createEntityManager.persist(category2);
	}
	
	/*
	 * 无论是查询关联对象还是非关联对象都是使用lazy方式加载
	 */
	@Ignore
	@Test
	public void findItem() {
		Item item = createEntityManager.find(Item.class, 1);
		System.out.println("find item >> " + item.getName());
		System.out.println("find item >> " + item.getCategories().iterator().next().getName());
	}
	
	@Test
	public void findCategory() {
		Category category = createEntityManager.find(Category.class, 1);
		System.out.println("find category >> " + category.getName());
		System.out.println("find category >> " + category.getItems().iterator().next().getName());
	}
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
