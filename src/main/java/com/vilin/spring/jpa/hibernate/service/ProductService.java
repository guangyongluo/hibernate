package com.vilin.spring.jpa.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vilin.spring.jpa.hibernate.dao.ProductDao;
import com.vilin.spring.jpa.hibernate.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public void addProduct(Product product1, Product product2) {
		productDao.save(product1);
		productDao.save(product2);
	}
}
