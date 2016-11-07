package com.chatapp;

import java.util.List;

public interface Persistance {

	void addChatRoom(String name);
	void addUser(User u,String chatroomname);
	void addMessage(Message m, String logged_in_email);
	
	boolean login(String u_name ,String u_password);
	
	void deleteChatRoom(String name);
	void deleteUser(String email);
	void deleteMessage(Long id);
	
	List<Chatroom> displayAllChatRoom();
	List<User> displayAllUser();
	void displayAllMessage();
	
	void endPersistance();
	
}
