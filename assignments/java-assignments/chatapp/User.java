package com.chatapp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Users_master")
public class User {
	
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<Chatroom> getChatroomset() {
		return chatroomset;
	}

	public void setChatroomset(Set<Chatroom> chatroomset) {
		this.chatroomset = chatroomset;
	}

	public User(){
		
	}
	

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "user" )
	private Set<Message> messages = new HashSet<Message>();
	
	@ManyToMany(mappedBy = "userset" , cascade = CascadeType.ALL)
	private Set<Chatroom> chatroomset = new HashSet<Chatroom>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
		return this.username+" "+this.email+" ";
	}
	
	
}
