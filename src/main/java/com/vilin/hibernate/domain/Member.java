package com.vilin.hibernate.domain;

public class Member extends SYSUser {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString() + "Member [address=" + address + "]";
	}
	
}
