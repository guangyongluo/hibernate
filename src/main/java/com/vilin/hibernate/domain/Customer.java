package com.vilin.hibernate.domain;

import java.io.Serializable;

public class Customer implements Serializable {

	private Integer id;
	
	private Name name;
	
	private Integer age;

	public Customer() {
		super();
	}

	public Customer(Integer id, Name name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
