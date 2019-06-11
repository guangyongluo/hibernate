package com.vilin.hibernate.domain;

import java.io.Serializable;

public class Emp implements Serializable {

	private Integer id;
	
	private String name;
	//在多方去定义一方的引用
	private Dept dept;
	
	public Emp() {
		super();
	}

	public Emp(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Emp(Integer id, String name, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
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
	
	public Dept getDept() {
		return dept;
	}
	
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
}
