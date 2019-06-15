package com.vilin.hibernate.service;

import java.util.List;

import com.vilin.hibernate.domain.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int id);
	
	public User login(User user);
	
	public void register(User user);
	
}
