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

public class TeacherTest {

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
	public void addTeacher() {
		Student student1 = new Student();
		student1.setName("猪八戒");
		student1.setMail("zhubajie@163.com");
		student1.setBirthday(new Date());
		
		Student student2 = new Student();
		student2.setName("嫦娥");
		student2.setMail("change@163.com");
		student2.setBirthday(new Date());
		
		Teacher teacher = new Teacher();
		teacher.setName("玉帝");
		teacher.setMail("yudi@163.com");
		
		teacher.getStudents().add(student1);
		teacher.getStudents().add(student2);
		
		
		createEntityManager.persist(student1);
		createEntityManager.persist(student2);
		createEntityManager.persist(teacher);
		
	}
	
	/*
	 * 查询默认是lazy加载，可以修改加载策略
	 */
	@Ignore
	@Test
	public void findTeacher() {
		Teacher teacher = createEntityManager.find(Teacher.class, 1);
		System.out.println(teacher.getName());
		System.out.println(teacher.getStudents().size());
	}
	
	/*
	 * 默认情况下，是把N方的外键修改为空，在进行删除1方一行操作
	 */
	@Ignore
	@Test
	public void removeTeacher() {
		Teacher teacher = createEntityManager.find(Teacher.class, 2);
		createEntityManager.remove(teacher);
	}
	
	@Ignore
	@Test
	public void updateTeacher() {
		Teacher teacher = createEntityManager.find(Teacher.class, 3);
		teacher.setName("王母娘娘");
		teacher.getStudents().iterator().next().setName("玉兔");
	}
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
