package com.vilin.hibernate.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Clazz implements Serializable {

	private Integer id;
	
	private String name;
	
	private Set<Student> students = new HashSet<Student>();

	public Clazz() {
		super();
	}

	public Clazz(Integer id, String name) {
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
	
}
