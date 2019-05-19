package com.vilin.spring.jpa.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.vilin.spring.jpa.hibernate.entity.Product;

@Repository
public class ProductDao {

	//@PersistenceContext表示成员变量
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(Product product) {
		entityManager.persist(product);
	}
}
