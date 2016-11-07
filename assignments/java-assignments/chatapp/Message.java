package com.chatapp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message_master")
public class Message {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name = "body")
	private String body;
	
	@Column(name = "timestamp")
	private Long timestamp;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_id")
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setUser(User u){
		this.user = u;
	}
	public User getUser(){
		return this.user;
	}
}
