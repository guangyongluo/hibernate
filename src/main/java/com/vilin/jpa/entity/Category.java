package com.vilin.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name="JPA_CATEGORY")
@Entity
public class Category {

	private Integer id;
	private String name;
	private Set<Item> items = new HashSet<Item>();
	@TableGenerator(name="CATEGORY_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_CATEGORY_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CATEGORY_ID_GENERATOR")
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
	@ManyToMany(mappedBy="categories")
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
