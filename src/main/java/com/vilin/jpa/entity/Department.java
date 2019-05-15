package com.vilin.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name="JPA_DEPARTMENT")
@Entity
public class Department {

	private Integer id;
	private String name;
	private Manager manager;
	@TableGenerator(name="DEPARTMENT_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_DEPARTMENT_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "DEPARTMENT_ID_GENERATOR")
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
	/*
	 * 双向1...1添加外键使用@JoinColumn
	 * 因为是1...1关联关系所以使用unique属性
	 */
	@JoinColumn(name="manager_id", unique=true)
	@OneToOne(fetch = FetchType.LAZY)
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
}
