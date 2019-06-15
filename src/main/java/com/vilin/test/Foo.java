package com.vilin.test;

public class Foo<T> {
 
	private T attr;

	public Foo() {
		super();
	}

	public Foo(T attr) {
		super();
		this.attr = attr;
	}

	public T getAttr() {
		return attr;
	}

	public void setAttr(T attr) {
		this.attr = attr;
	}
	
}
