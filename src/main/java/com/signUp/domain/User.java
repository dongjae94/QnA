package com.signUp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String userId;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	
	public String getUserId() {
		return userId;
	}
	

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}


	public void update(User updateUser) {
		setUserId(updateUser.userId);
		setPassword(updateUser.password);
		setname(updateUser.name);
		setEmail(updateUser.email);
	}
	
}
