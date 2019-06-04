package com.vilin.hibernate.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String username;
	
	private String password;
	
	private Integer age;

	//对应user表中的记录数，但数据库中没有对应的列，由SQL动态生成的。
	private Long count;
	
	public User() {}
	
	public User(Integer id, String username, String password, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
	}

	public User(String username, Integer age) {
		super();
		this.username = username;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", count="
				+ count + "]";
	}
	
}
