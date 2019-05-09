package com.vilin.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="JPA_PERSON")
@Entity
public class Person {
    private Integer id;
    private String name;
    private Date date;
    private Date birth;
    private String sex;
    @TableGenerator(name="PRESON_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_NAME", valueColumnName = "jpa_id_value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PRESON_ID_GENERATOR")
    @Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Column(length = 1)
    public String getSex() {
    	return this.sex;
    }
    public void setSex(String sex) {
    	this.sex = sex;
    }
}
