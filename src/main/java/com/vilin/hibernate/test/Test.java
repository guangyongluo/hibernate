package com.vilin.hibernate.test;

import org.hibernate.Session;

import com.vilin.hibernate.domain.Dept;
import com.vilin.hibernate.domain.Emp;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.TransactionManager;

public class Test {

	public static void main(String[] args) {
//		selectHQL2();
//		save();
//		update();
		delete();
	}
	
	public static void select() {
		Emp emp = null;
		
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();
			
			emp = (Emp)session.load(Emp.class, 1);
			System.out.println(emp.getName());
			System.out.println("-----------");
			
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
		System.out.println(emp.getDept().getName());
	}
	
	public static void selectHQL1() {
	    Emp emp = null;
		
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();
            
			String hql = "from Emp e where e.id=:id";
			emp = (Emp)session.createQuery(hql).setParameter("id", 1).uniqueResult();
			System.out.println(emp.getName());
			System.out.println("-----------");
			
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
		
		System.out.println(emp.getDept().getName());
	}
	
	//HQL连接查询
	public static void selectHQL2() {
	    Emp emp = null;
		
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();
            
			/*
			 * 1.HQL中的连接查询与SQL在写法上有所不同，连接的是类的属性，是不类；
			 * 2.select部分不能省略；
			 * 3.left join只做连接操作不查关联数据。
			 * 4.left join fetch即做连接又查关联数据。
			 */
			String hql = "select e from Emp e left join fetch e.dept d where e.id=:id";
			emp = (Emp)session.createQuery(hql).setParameter("id", 1).uniqueResult();
			System.out.println(emp.getName());
			System.out.println("-----------");
			
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
		
		System.out.println(emp.getDept().getName());
	}
	
	public static void save() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

//			Emp emp = new Emp(null, "e9");
//			session.save(emp);
			
//			Dept dept = new Dept();
//			dept.setId(1);//游离态
//			Emp emp = new Emp(null, "e10", dept);
//			session.save(emp);
			
//			Dept dept = new Dept();
//			dept.setId(4);//瞬时态
//			Emp emp = new Emp(null, "e11", dept);
//			session.save(emp);
			
//			Dept dept = session.load(Dept.class, 2);//持久态
//			Emp emp = new Emp(null, "e11", dept);
//			session.save(emp);
			
			Dept dept = new Dept();
			dept.setName("d5");
			Emp emp = new Emp(null, "e13", dept);
			session.save(emp);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	public static void update() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			Emp emp = session.load(Emp.class, 1);
//			Dept dept = session.load(Dept.class, 2);//持久态对象
//			emp.setDept(dept);
//			session.update(emp);//不需要update语句，对于持久化对象会进行脏检查同步更新到数据库中
			
//			Dept dept = new Dept();//游离态对象
//			dept.setId(3);
//			emp.setDept(dept);
			
			Dept dept = new Dept();//瞬时态对象
			dept.setName("d6");
			emp.setDept(dept);
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
	
	public static void delete() {
		try {
			Session session = HibernateUtil.getSession();
			TransactionManager.beginTransaction();

			//级联删除员工所属的部门，如果该部门没有其他的员工则正常删除，否则会保存原因在与会有外键的约束
			Emp emp = session.load(Emp.class, 12);
			session.delete(emp);
			
			
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
