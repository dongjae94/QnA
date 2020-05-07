package com.signUp;

public class User {
	private String userId;
	private String userPw;
	private String userName;
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
