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
	@Ignore
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
	
	/*
	 * 如果EntityManager缓存中没有该对象，而且数据表中也没有对应的记录
	 * JPA会创建新对象，然后把游离对象的属性复制到新对象中，再对新对象
	 * 执行insert操作。
	 * 
	 */
	@Ignore
	@Test
	public void mergeStudentWithId1() {
		Student student = new Student();
		student.setName("沙悟净");
		student.setMail("shawujing@163.com");
		student.setBirthday(new Date());
		student.setId(100);
		Student mergeResult = createEntityManager.merge(student);
		System.out.println("student id = " + student.getId());
		System.out.println("mergeResult id = " + mergeResult.getId());
	}
	
	/*
	 * 如果EntityManager缓存中没有该对象，但数据表中有对应的记录
	 * JPA会查询新对象，然后把游离对象的属性复制到查询对象中，再
	 * 对查询对象执行update操作。
	 * 
	 */
	@Ignore
	@Test
	public void mergeStudentWithId2() {
		Student student = new Student();
		student.setName("猪八戒");
		student.setMail("zhubajie@163.com");
		student.setBirthday(new Date());
		student.setId(5);
		Student mergeResult = createEntityManager.merge(student);
		System.out.println("mergeResult id = " + student.getId());
		System.out.println(student == mergeResult);
	}
	
	/*
	 * 如果EntityManager缓存中有该对象，JPA会把游离对象复制到缓存对象
	 * 再对缓存对象执行update，注意：hibernate session中的saveOrUpdate
	 * 的方法不同，不能两个ID同时关联
	 * 
	 */
	@Ignore
	@Test
	public void mergeStudentWithId3() {
		Student student = new Student();
		student.setName("沙悟净");
		student.setMail("shawujing@163.com");
		student.setBirthday(new Date());
		student.setId(5);
		
		Student findResult = createEntityManager.find(Student.class, 5);
		
		Student mergeResult = createEntityManager.merge(student);
		System.out.println("mergeResult id = " + student.getId());
		System.out.println(findResult == mergeResult);
	}
	
	@Ignore
	@Test
	public void flush() {
		Student student = createEntityManager.find(Student.class, 5);
		System.out.println("find student >> " + student);
		student.setName("猴子");
		System.out.println("find student >> " + student);
		createEntityManager.flush();
	}
	
	@Ignore
	@Test
	public void refresh() {
		Student student = createEntityManager.find(Student.class, 4);
		student = createEntityManager.find(Student.class, 4);
		createEntityManager.refresh(student);
	}
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
