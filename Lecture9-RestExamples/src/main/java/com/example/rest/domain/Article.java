package com.example.rest.domain;

import java.time.LocalDateTime;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;

public class Article {
	private int id;
	private String content;
	//@JsonIgnore
	//@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	//@JsonFormat(shape = JsonFormat.Shape.STRING) 
	//@JsonFormat(shape = JsonFormat.Shape.STRING,
	//			pattern = "yyyy.MM.dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime creationTime;
	
	public Article() { }

	public Article(int id, String content, LocalDateTime creationTime) {
		this.id = id;
		this.content = content;
		this.creationTime = creationTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", content=" + content + ", creationTime=" + creationTime + "]";
	}
}
