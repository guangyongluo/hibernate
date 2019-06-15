package com.vilin.hibernate.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.vilin.hibernate.util.PageResult;

public interface GenericDao<T extends Serializable, PK extends Serializable> {

	public void insert(T t);
	
	public void delete(T t);
	
	public void deleteById(PK id);
	
	public void update(T t);
	
	public T get(PK id);
	
	public T load(PK id);
	
	public List<T> selectAll();
	
	//HQL查询，使用?占位符
	public List<T> selectByHQL(String hql, Object...params);
	
	//HQL查询，使用命名占位符
	public List<T> selectByHQL(String hql, Map<String, Object> params);
	
	//SQL查询，使用?占位符
	public List<T> selectBySQL(String sql, Object...params);
	
	//SQL查询，使用命名占位符
	public List<T> selectBySQL(String sql, Map<String, Object> params);
	
	public PageResult<T> selectByPage(int pageSize, int pageNo, String hql, Object...params);
	
	public PageResult<T> selectByPage(int pageSize, int pageNo, String hql, Map<String, Object> params);

	public T selectObject(String hql, Object...params);
	
	public T selectObject(String sql, Map<String, Object> params);
	
	public int executeByHQL(String hql, Object...params);
	
	public int executeBySQL(String sql, Map<String, Object> params);
}
