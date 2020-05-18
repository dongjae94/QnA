package com.signUp.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDateTime createDate;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
	private User writer;

	
	private String title;
	
	private String contents;
	
	public Question() {} // jpa에서는 default 생성자 필수 
	public Question(User writer, String title, String contents) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createDate=LocalDateTime.now();
	}
	public String getFormattedCreateDate() {
		if(createDate==null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}
}
