package com.vilin.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.util.HibernateUtil;

public class CriteriaQuery {

	public static void main(String[] args) {
		test03();
	}
	
	//查询所有实体
	public static void test01() {
		Session session = HibernateUtil.getSession();
		Criteria createCriteria = session.createCriteria(User.class);
		List list = createCriteria.list();
		System.out.println(list);
		HibernateUtil.close();
	}
	
	//限定查询
	public static void test02() {
		Session session = HibernateUtil.getSession();
		Criteria createCriteria = session.createCriteria(User.class);
		//调用add方法添加条件，默认是and的关系
		//createCriteria.add(Restrictions.eq("username", "张三丰"));
		//createCriteria.add(Restrictions.between("id", 2, 8));
		createCriteria.add(Restrictions.in("username", new Object[] {"张三丰","张翠山","张无忌"}));
		List list = createCriteria.list();
		System.out.println(list);
		HibernateUtil.close();
	}
	
	//原生SQL查询通过SQL Query来支持原生SQL查询
	public static void test03() {
		Session session = HibernateUtil.getSession();
		String sql = "select * from user where username='张三丰'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);//将查询结果集中的关系数据映射成对象的属性
		List list = query.list();
		System.out.println(list);
		HibernateUtil.close();
	}
}
