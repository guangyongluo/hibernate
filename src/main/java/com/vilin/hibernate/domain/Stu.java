package com.vilin.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Stu implements Serializable{

	private Integer id;
	
	private String name;
	
	private Set<Course> courses = new HashSet<Course>();

	public Stu() {
		super();
	}

	public Stu(Integer id, String name) {
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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
