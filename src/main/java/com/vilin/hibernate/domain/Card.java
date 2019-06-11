package com.vilin.hibernate.domain;

import java.io.Serializable;

public class Card implements Serializable {

	private Integer id;
	
	private String name;
	
	private Person person;

	public Card() {
		super();
	}

	public Card(Integer id, String name, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.person = person;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
