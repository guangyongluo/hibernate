package com.vilin.hibernate.domain;

import java.io.Serializable;

public class Dept implements Serializable {

	private Integer id;
	
	private String name;
	
	public Dept() {
		super();
	}

	public Dept(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
