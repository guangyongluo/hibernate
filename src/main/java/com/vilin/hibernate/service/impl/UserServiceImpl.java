package com.vilin.hibernate.service.impl;

import java.util.List;

import com.vilin.hibernate.dao.UserDao;
import com.vilin.hibernate.domain.User;
import com.vilin.hibernate.service.UserService;
import com.vilin.hibernate.util.TransactionManager;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findAll() {
		return userDao.selectAll();
	}

	@Override
	public User findById(int id) {
		return userDao.get(id);
	}

	@Override
	public User login(User user) {
        String hql = "from User u where u.username=? and u.password=?";
		return userDao.selectObject(hql, user.getUsername(), user.getPassword());
	}

	@Override
	public void register(User user) {
        try {
			TransactionManager.beginTransaction();
			userDao.insert(user);
			TransactionManager.commit();
		} catch (Exception e) {
            TransactionManager.rollback();
            e.printStackTrace();
		}
	}

}
