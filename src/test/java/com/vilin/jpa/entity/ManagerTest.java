package com.vilin.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ManagerTest {
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
	
	/*
	 * 双向1...1在保存的时候，建议先保存不维护关联关系的一个，不然多出update语句
	 */
	@Ignore
	@Test
	public void addManager() {
	    Manager manager = new Manager();
	    manager.setName("小张");
	    
	    Department department = new Department();
	    department.setName("销售部门");
	    
	    manager.setDepartment(department);
	    department.setManager(manager);
	    
	    createEntityManager.persist(manager);
	    createEntityManager.persist(department);
	}
	
	/*
	 * 在默认情况下如果获取不维护关联关系的一方会使用左外链接
	 * 在维护关联关系的一方设置lazy fetch。
	 */
	@Ignore
	@Test
	public void getDepartment() {
		Department department = createEntityManager.find(Department.class, 1);
		System.out.println("find department >> " + department.getName());
		System.out.println("find department >> " + department.getManager().getName());
	}
	
	/*
	 * 在默认情况下如果获取维护关联关系的一方使用左外链接可以通过设置fetch=FetchType.LAZY加载策略
	 * 会发送两条SQL语句，不建议使用，还不如默认的一条左外链接语句
	 */
	@Ignore
	@Test
	public void getManager() {
		Manager manager = createEntityManager.find(Manager.class, 1);
		System.out.println("find manager >> " + manager.getName());
		System.out.println("find manager >> " + manager.getDepartment().getName());
	}
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
	
}
