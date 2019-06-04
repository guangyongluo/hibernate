package com.vilin.hibernate.test;

/*
 * 封装查询参数的Java Bean
 */
public class UserBean {
	private String username;
	private Integer minAge;
	private Integer maxAge;
	private Integer minId;
	private Integer maxId;

	public UserBean() {
		super();
	}

	public UserBean(String username, Integer minAge, Integer maxAge,
			Integer minId, Integer maxId) {
		super();
		this.username = username;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.minId = minId;
		this.maxId = maxId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Integer getMinId() {
		return minId;
	}

	public void setMinId(Integer minId) {
		this.minId = minId;
	}

	public Integer getMaxId() {
		return maxId;
	}

	public void setMaxId(Integer maxId) {
		this.maxId = maxId;
	}

}
