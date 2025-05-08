package com.example.rest.domain;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "content", "creationTime" })
public class Message {

	private int id;
	private String content;
	
	@XmlElement(name="crTime")
	// @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="GMT+9")
	private Date creationTime;
	
	public Message() { }

	public Message(Integer id, String content, Date creationTime) {
		this.id = id;
		this.content = content;
		this.creationTime = creationTime;
	}

	public Integer getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", creationTime=" + creationTime + "]";
	}

}
