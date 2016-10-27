package com.collectionex;

import java.util.List;
import java.util.Set;

class ChatRoom {
	private String name;
	private Set<User> user_list;
	private List<Message> message_list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUser_list() {
		return user_list;
	}
	public void setUser_list(Set<User> user_list) {
		this.user_list = user_list;
	}
	public List<Message> getMessage_list() {
		return message_list;
	}
	public void setMessage_list(List<Message> message_list) {
		this.message_list = message_list;
	}
	
	
	
}


class User{
	private String email_id;
	private String name;
	private String password;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}


class Message{
	private String body;
	private long time_stamp;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public long getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(long time_stamp) {
		this.time_stamp = time_stamp;
	}
	
	
	
}

public class ChatApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
