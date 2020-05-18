package com.signUp.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	

	@Column(nullable=false, unique=true)
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
//	
//	public String getPassword() {
//		return password;
//	}
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

	public boolean matchPassword(String newPassword) {
		if(newPassword==null) {
			return false;
		}
		return password.equals(newPassword);
	}
	public boolean matchId(Long newId) {
		if(newId==null) {
			return false;
		}
		return id.equals(newId);
		
	}
	
	public void update(User updateUser) {
		setUserId(updateUser.userId);
		setPassword(updateUser.password);
		setname(updateUser.name);
		setEmail(updateUser.email);
	}

	public Long getId() {
		return id;
	}
	
}
