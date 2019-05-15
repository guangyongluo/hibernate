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

public class TeacherStudentTest {
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
	 * 在保存时先保存1的一方，减少update语句
	 * 维护关联关系的时候，建议让N的一方来维护关联关系，减少update语句
	 * 在1的一方设置mappedBy属性，就不要使用@JoinColumn了
	 */
	@Ignore
	@Test
	public void addTeacher() {
		Teacher teacher = new Teacher();
		teacher.setName("太上老君");
		teacher.setMail("taishanglaojun@163.com");
		
		Student student1 = new Student();
		student1.setName("杨戬");
		student1.setMail("yangjian@163.com");
		student1.setBirthday(new Date());
		
		Student student2 = new Student();
		student2.setName("天兵");
		student2.setMail("tianbing@163.com");
		student2.setBirthday(new Date());
		
		teacher.getStudents().add(student1);
		teacher.getStudents().add(student2);
		student1.setTeacher(teacher);
		student2.setTeacher(teacher);
		
		createEntityManager.persist(teacher);
		createEntityManager.persist(student1);
		createEntityManager.persist(student2);
	}
	
	@After
	public void close() {
		transaction.commit();
		createEntityManager.close();
		createEntityManagerFactory.close();
	}
}
