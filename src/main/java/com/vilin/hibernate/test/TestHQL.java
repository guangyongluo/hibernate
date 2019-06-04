package com.vilin.hibernate.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.util.HibernateUtil;

public class TestHQL {

	public static void main(String[] args) {
//		test09(new UserBean("%张%", 10, 30, 1, 20));
//		test10(3, 2);
		test15();
	}
	
	//实体查询
	public static void test01() {
		Session session = HibernateUtil.getSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		System.out.println(list);
		HibernateUtil.close();
	}
	
	//条件查询
	public static void test02() {
		Session session = HibernateUtil.getSession();
		String hql = "select u from User u where id>2";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		System.out.println(list);
		HibernateUtil.close();
	}
	
	//单实体查询
	public static void test03() {
		Session session = HibernateUtil.getSession();
		String hql = "select u from User u where u.id=2";
		Query query = session.createQuery(hql);
		User user = (User)query.uniqueResult();
		System.out.println(user);
		HibernateUtil.close();
	}
	
	//查询多个属性
	public static void test04() {
		Session session = HibernateUtil.getSession();
		String hql = "select u.username, u.password from User u where u.id>1";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object[] columns : list) {
			for(Object column : columns) {
				System.out.println(column);
			}
			System.out.println();
		}
		HibernateUtil.close();
	}
	
	//查询多个属性-将每条查询结果封装成Map集合
	public static void test05() {
		Session session = HibernateUtil.getSession();
		//别名作为map里的key
		String hql = "select new Map(u.username as name, u.age as age) from User u where u.id>1";
		Query query = session.createQuery(hql);
		List<Map<String, Object>> list = query.list();
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}
		HibernateUtil.close();
	}
	
	//查询多个属性-通过构造函数封装成对象
	public static void test06() {
		Session session = HibernateUtil.getSession();
		//别名作为map里的key
		String hql = "select new User(u.username, u.age) from User u where u.id>1";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		for(User user : list) {
			System.out.println(user);
		}
		HibernateUtil.close();
	}
	
	//使用?号进行参数绑定
	public static void test07() {
		Session session = HibernateUtil.getSession();
		//别名作为map里的key
		String hql = "from User where id>?0 and username like ?1";
		Query query = session.createQuery(hql).setParameter(0, 1).setParameter(1, "%张%");
//		query.setInteger(0, 1);
//		query.setString(1, "%张%");
		List<User> list = query.list();
		System.out.println(list);
		HibernateUtil.close();
	}
	
	//使用命名参数占位符绑定参数
	public static void test08() {
		Session session = HibernateUtil.getSession();
		//别名作为map里的key
		String hql = "from User where id>:id and username like :username";
		Query query = session.createQuery(hql).setParameter("id", 1).setParameter("username", "%张%");
		List<User> list = query.list();
		System.out.println(list);
		HibernateUtil.close();
	}
	
	//通过Java Bean封装参数，进行参数绑定
	public static void test09(UserBean userBean) {
		Session session = HibernateUtil.getSession();
		String hql = "from User u where u.username like :username and u.age between :minAge and :maxAge and id between :minId and :maxId";
		Query query = session.createQuery(hql);
		query.setProperties(userBean);
		List<User> list = query.list();
		System.out.println(list);
		HibernateUtil.close();
	}
	
	//分页
	public static void test10(int pageSize, int pageNo) {
		Session session = HibernateUtil.getSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		
		List list = query.list();
		int count = list.size();
		int pages = count % pageSize == 0 ? (count / pageSize) : (count / pageSize + 1);
		
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<User> users = query.list();
		System.out.println(users);
		
		HibernateUtil.close();
	}
	
	//聚合函数
	public static void test11() {
		Session session = HibernateUtil.getSession();
		String hql = "select count(u.id) from User u";
		Query query = session.createQuery(hql);
		long count = (Long)query.uniqueResult();
		System.out.println(count);
		HibernateUtil.close();
	}
	
	public static void test12() {
		Session session = HibernateUtil.getSession();
		String hql = "select max(u.id) from User u";
		Query query = session.createQuery(hql);
		int count = (Integer)query.uniqueResult();
		System.out.println(count);
		HibernateUtil.close();
	}
	
	public static void test13() {
		Session session = HibernateUtil.getSession();
		String hql = "select avg(u.age) from User u";
		Query query = session.createQuery(hql);
		double count = (Double)query.uniqueResult();
		System.out.println(count);
		HibernateUtil.close();
	}
	
	//group by查询
	public static void test14() {
		Session session = HibernateUtil.getSession();
		String hql = "select count(user), user.age from User user group by user.age having count(user) > 0";
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.println(list.size());
		for(Object object : list) {
			System.out.println(Arrays.toString((Object[])object));
		}
		HibernateUtil.close();
	}
	
	//子查询
	public static void test15() {
		Session session = HibernateUtil.getSession();
		String hql = "from User u1 where u1.age > (select u2.age from User u2 where u2.username = '张无忌')";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		System.out.println(list);
		HibernateUtil.close();
	}
}
