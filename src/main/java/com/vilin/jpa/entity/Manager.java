package com.vilin.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name="JPA_MANAGER")
@Entity
public class Manager {
    private Integer id;
    private String name;
    private Department department;
    @TableGenerator(name="MANAGER_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_MANAGER_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MANAGER_ID_GENERATOR")
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
	 * 对于不维护关联关系，没有外键的一方使用mappedBy属性
	 * 如不设置，两边都维护就会出现多余的update语句
	 */
	@OneToOne(mappedBy="manager", fetch=FetchType.LAZY)
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
    
}
