package com.vilin.spring.jpa.hibernate.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name="JPA_PRODUCT")
@Entity
public class Product {
	private Integer id;
	private String name;
	private Date time;
	private Integer warranty;
	@TableGenerator(name="PRODUCT_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_PRODUCT_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PRODUCT_ID_GENERATOR")
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getWarranty() {
		return warranty;
	}
	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}
}
