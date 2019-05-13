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

public class StudentTest {

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
		student.setName("孙悟空");
		student.setMail("sunwukong@163.com");
		student.setBirthday(new Date());
		createEntityManager.persist(student);
		//System.out.println(student.getId());
	}
	
	@Ignore
	@Test
	public void findStudent() {
		Student student = createEntityManager.find(Student.class, 2);
		System.out.println("========");
		System.out.println("find() >>" + student);
	}
	
	@Ignore
	@Test
	public void getReference() {
		/**
		 * JPA getReference方法相当于Hibernate session 中的load方法，返回代理对象
		 */
		Student reference = createEntityManager.getReference(Student.class, 3);
		System.out.println("========");
		System.out.println("getReference() >>" + reference);
	}
	
	@Ignore
	@Test
	public void removeStudent() {
		Student student = createEntityManager.find(Student.class, 3);
		createEntityManager.remove(student);
	}
	
	/**
	 * 临时对象会创建一个新对象，把临时对象中的属性复制到
	 * 新对象中，再对新对象进行持久化操作
	 */
	@Test
	public void mergeStudentWithOutId() {
		Student student = new Student();
		student.setName("唐僧");
		student.setBirthday(new Date());
		student.setMail("tangseng@163.com");
		Student mergeResult = createEntityManager.merge(student);
		System.out.println(student.getId());
		System.out.println(mergeResult.getId());
	}
	
	@Test
	public void mergeStudentWithId() {
		new Student();
	}
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
