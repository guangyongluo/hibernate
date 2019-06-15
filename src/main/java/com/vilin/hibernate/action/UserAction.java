package com.vilin.hibernate.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.service.UserService;
import com.vilin.hibernate.service.impl.UserServiceImpl;
import com.vilin.hibernate.util.HibernateUtil;

public class UserAction {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserServiceImpl) context.getBean("userService");
        List<User> list = userService.findAll();
        System.out.println(list);
        HibernateUtil.close();
        User user = userService.findById(8);
        System.out.println(user);
        HibernateUtil.close();
	}

}
