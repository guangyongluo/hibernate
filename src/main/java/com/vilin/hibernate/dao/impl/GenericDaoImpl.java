package com.vilin.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vilin.hibernate.dao.GenericDao;
import com.vilin.hibernate.util.HibernateUtil;
import com.vilin.hibernate.util.PageResult;

public class GenericDaoImpl<T extends Serializable, PK extends Serializable> implements GenericDao<T, PK> {

	//Dao的泛型类，子类泛型类T所指定的具体类型
	private Class<T> entityClass;
	
	//通过反射来查找子类泛型类T的具体类型
	public GenericDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType) {
			entityClass = (Class)((ParameterizedType)type).getActualTypeArguments()[0];
		}
	}
	
	@Override
	public void insert(T t) {
		HibernateUtil.getSession().save(t);
	}

	@Override
	public void delete(T t) {
		HibernateUtil.getSession().delete(t);
	}

	@Override
	public void deleteById(PK id) {
		Session session = HibernateUtil.getSession();
		session.delete(session.get(entityClass, id));
	}

	@Override
	public void update(T t) {
		HibernateUtil.getSession().update(t);		
	}

	@Override
	public T get(PK id) {
		return HibernateUtil.getSession().get(entityClass, id);
	}

	@Override
	public T load(PK id) {
		return HibernateUtil.getSession().load(entityClass, id);
	}

	@Override
	public List<T> selectAll() {
		return HibernateUtil.getSession().createCriteria(entityClass).list();
	}

	@Override
	public List<T> selectByHQL(String hql, Object... params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, params);
		return query.list();
	}

	@Override
	public List<T> selectByHQL(String hql, Map<String, Object> params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, params);
		return query.list();
	}

	@Override
	public List<T> selectBySQL(String sql, Object... params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery(sql).addEntity(entityClass);
		setParameter(query, params);
		return query.list();
	}

	@Override
	public List<T> selectBySQL(String sql, Map<String, Object> params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery(sql).addEntity(entityClass);
		setParameter(query, params);
		return query.list();
	}

	@Override
	public PageResult<T> selectByPage(int pageSize, int pageNo, String hql, Object... params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, params);
		//获取总记录数
		int totalSize = query.scroll().getRowNumber();
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		List data = query.list();
		
		PageResult<T> page = new PageResult(pageSize, pageNo, totalSize);
		page.setList(data);
		return page;
	}

	@Override
	public PageResult<T> selectByPage(int pageSize, int pageNo, String hql, Map<String, Object> params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, params);
		//获取总记录数
		int totalSize = query.scroll().getRowNumber();
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		List data = query.list();
		
		PageResult<T> page = new PageResult(pageSize, pageNo, totalSize);
		page.setList(data);
		return page;
	}

	@Override
	public T selectObject(String hql, Object... params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, params);
		return (T) query.uniqueResult();
	}

	@Override
	public T selectObject(String sql, Map<String, Object> params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery(sql);
		setParameter(query, params);
		return (T) query.uniqueResult();
	}

	@Override
	public int executeByHQL(String hql, Object... params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		setParameter(query, params);
		return query.executeUpdate();
	}

	@Override
	public int executeBySQL(String sql, Map<String, Object> params) {
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery(sql);
		setParameter(query, params);
		return query.executeUpdate();
	}

	public void setParameter(Query query, Object param) {
		if(param.getClass().isArray()) {
			Object[] params = (Object[])param;
			for(int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		if(param instanceof Map) {
			Map map = (Map) param;
			for(Object key : map.keySet()) {
				query.setParameter(key.toString(), map.get(key));
			}
		}
	}
}
