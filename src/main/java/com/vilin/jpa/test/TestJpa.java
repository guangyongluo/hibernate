package com.vilin.jpa.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vilin.spring.jpa.hibernate.entity.Product;
import com.vilin.spring.jpa.hibernate.service.ProductService;

public class TestJpa {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
//		DataSource dataSource = context.getBean(DataSource.class);
//		try {
//			Connection connection = dataSource.getConnection();
//			System.out.println(connection);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Product product1 = new Product();
		product1.setName("iphone xs");
		try {
			product1.setTime(bf.parse("2018-10-15"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product1.setWarranty(1);
		
		Product product2 = new Product();
		product2.setName("huawei P30");
		try {
			product2.setTime(bf.parse("2019-03-20"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product2.setWarranty(1);
		
		ProductService productService = context.getBean(ProductService.class);
		
		productService.addProduct(product1, product2);
		
		
		
	}
	
}
