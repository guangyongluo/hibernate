package com.vilin.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Course implements Serializable {

	private Integer id;
	
	private String name;
	
	private Set<Stu> stu = new HashSet<Stu>();

	public Course() {
		super();
	}

	public Course(Integer id, String name) {
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

	public Set<Stu> getStu() {
		return stu;
	}

	public void setStu(Set<Stu> stu) {
		this.stu = stu;
	}
	
}
