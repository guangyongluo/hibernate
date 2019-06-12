package com.vilin.hibernate.domain;

public class Manager extends SYSUser {

	private String tel;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return super.toString() + "Manager [tel=" + tel + "]";
	}
	
}
