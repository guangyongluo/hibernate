package com.vilin.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.LazyCollection;

@Table(name="JPA_ORDER")
@Entity
public class Order {
	private Integer id;
	private String name;
	private Student student;
	public Order() {}
	public Order(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@TableGenerator(name="ORDER_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_ORDER_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ORDER_ID_GENERATOR")
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
	@JoinColumn(name="student_id")
	@ManyToOne(fetch=FetchType.EAGER)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", student=" + student + "]";
	}
	
}
