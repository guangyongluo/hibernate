package com.vilin.hibernate.test;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.util.HibernateUtil;

public class NamedQuery {

	public static void main(String[] args) {
		test02();
	}
	
	//HQL语句的命名查询
	public static void test01() {
		Session session = HibernateUtil.getSession();
		//获取名称为login的查询语句
		Query query = session.getNamedQuery("login");
		query.setString("username", "张三丰");
		query.setString("password", "123456");
		User user = (User)query.uniqueResult();
		System.out.println(user);
		HibernateUtil.close();
	}
	
	//SQL语句的命名查询
	public static void test02() {
		Session session = HibernateUtil.getSession();
		//获取名称为login的查询语句
		Query query = session.getNamedSQLQuery("login2");
		query.setString("name", "张三丰");
		query.setString("pwd", "123456");
		
		User user = (User)query.uniqueResult();
		System.out.println(user);
		HibernateUtil.close();
	}
}
