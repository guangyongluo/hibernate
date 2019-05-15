package com.vilin.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name="JPA_ITEM")
@Entity
public class Item {

	private Integer id;
	private String name;
	private Set<Category> categories = new HashSet<Category>();
	@TableGenerator(name="ITEM_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_ITEM_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ITEM_ID_GENERATOR")
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
	 * 多对多使用@ManyToMany
	 * @JoinTable name是中间表的表名
	 * joinColumns指向外键
	 *     @JoinColumn(name="",referencedColumnName="") name外键名称 referencedColumnName 当前主键对象的ID
	 *     inverseJoinColumns={
		   @JoinColumn(name="category_id",referencedColumnName="id") name是关联表的对象外键的名称， referencedColumnName关联对象的ID
	 */
	@JoinTable(name="jpa_item_category", joinColumns={
			@JoinColumn(name="item_id", referencedColumnName="id")}, 
			                             inverseJoinColumns={
			@JoinColumn(name="category_id",referencedColumnName="id")
	})
	@ManyToMany
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
