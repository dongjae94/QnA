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
	
	@Column(nullable=false, length=20)
	private String userId;
	@Column(nullable=false, length=20)
	private String userPw;
	@Column(nullable=false, length=20)
	private String userName;
	@Column(nullable=false, length=20)
	private String userEmail;
	

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setuserPw(String userPw) {
		this.userPw = userPw;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public void setuserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + userPw + ", name=" + userName + ", email=" + userEmail + "]";
	}
	
}
