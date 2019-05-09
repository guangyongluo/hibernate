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

@Table(name="JPA_STUDENT")
@Entity
public class Student {
    private Integer id;
    private String name;
    private Date birthday;
    private String mail;
    @TableGenerator(name="STUDENT_ID_GENERATOR", table = "jpa_tables_id", pkColumnName = "jpa_id_name", pkColumnValue = "JPA_STUDENT_ID", valueColumnName = "jpa_id_value", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "STUDENT_ID_GENERATOR")
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
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Column(length = 50)
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
    
}
