package com.signUp.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String writer;
	
	private String title;
	
	private String contents;
	
	public Question() {} // jpa에서는 default 생성자 필수 
	public Question(String writer, String title, String contents) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
	}
}
