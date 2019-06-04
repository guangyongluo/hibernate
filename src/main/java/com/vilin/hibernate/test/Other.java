package com.vilin.hibernate.test;

import javax.persistence.Query;

import org.hibernate.Session;

import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Other {

	public static void main(String[] args) {
		test02();
	}
	
	public static void test01() {
		Session session = HibernateUtil.getSession();
		TransactionManager.beginTransaction();
//		String hql = "delete from User where id in (3,5,7) and password='123456'";
		String hql = "update User u set u.password='666666' where u.username='张三丰'";
		Query query = session.createQuery(hql);
		int count = query.executeUpdate();
		System.out.println(count);
		TransactionManager.commit();
		System.out.println("更新成功");
		HibernateUtil.close();
	}
	
	public static void test02() {
		Session session = HibernateUtil.getSession();
		User user = (User)session.get(User.class, 2);
		System.out.println(user);
		HibernateUtil.close();
	}
}
