package com.vilin.jpa.entity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

public class PersonTest {
    
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
}
