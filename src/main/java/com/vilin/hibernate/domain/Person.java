package com.vilin.hibernate.domain;

import java.io.Serializable;

public class Person implements Serializable {

	private Integer id;
	
	private String name;
	
	private Card card;

	public Person() {
		super();
	}

	public Person(Integer id, String name, Card card) {
		super();
		this.id = id;
		this.name = name;
		this.card = card;
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}
