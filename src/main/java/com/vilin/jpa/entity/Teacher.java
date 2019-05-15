package com.vilin.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name = "JPA_TEACHER")
@Entity
public class Teacher {

	private Integer id;
	private String name;
	private String mail;
	private List<Student> students = new ArrayList<Student>();
	@TableGenerator(name="TEACHER_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_TEACHER_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TEACHER_ID_GENERATOR")
	@Id
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	/*
	 * 关联关系1...N使用@OneToMany注解，映射关联外键名称@JoinColumn
	 */
	//@JoinColumn(name="teacher_id")
	@OneToMany(mappedBy="teacher")
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
