/*package com.collectionex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class ChatRoom{
	int room_id;
	TreeSet<User> user_list;
	ArrayList<Message> message_list;
	private String name;
	
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public TreeSet<User> getUser_list() {
		return user_list;
	}
	public void setUser_list(TreeSet<User> user_list) {
		this.user_list = user_list;
	}
	public ArrayList<Message> getMessage_list() {
		return message_list;
	}
	public void setMessage_list(ArrayList<Message> message_list) {
		this.message_list = message_list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


class User implements Comparable<User>{
	private String email_id;
	private String user_name;
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		if(o.getEmail_id().equals(email_id))
		return 0;
		else
		return 1;
	}
	
	
	@Override
	public String toString(){
		return this.email_id+" name: "+this.user_name;
	}
}


class Message{
	
	private String body;
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String toString(){
		return this.body;
	}
	
}

public class Assignment6_copy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		//Valuable data types
		
		String logged_in_email = "";
		boolean logged_in = false;
		int chatroom_id = 1;
		List<ChatRoom> chatroom_list = new ArrayList<ChatRoom>();
		//
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("\nWELCOME TO ABC CHAT:\n1)NEW CHATROOM\n2)NEW USER\n3)USER LOGIN\n4)SEND MESSAGE\n5)DISPLAY MESSAGES OF A CHATROOM\n6)USERS OF A CHATROOM\n7)LOGOUT\n8)DELETE USER");
			int user_choice;
			user_choice = Integer.parseInt(br.readLine());
			switch(user_choice){
			case 1:
				//code to create new chatroom
				ChatRoom cr = new ChatRoom();
				cr.setRoom_id(chatroom_id);
				System.out.println("Enter name for chat room: ");
				cr.setName(br.readLine());
				chatroom_list.add(cr);
				System.out.println("\tChatroom created successfully..");
				
				break;
			case 2:
				//code to create new user
				User u = new User();
				System.out.println("Enter email of the user: ");
				u.setEmail_id(br.readLine());
				System.out.println("Enter password: ");
				u.setPassword(br.readLine());
				System.out.println("Enter User name: ");
				u.setUser_name(br.readLine());
				System.out.println("Enter room id for user: ");
				ChatRoom c = chatroom_list.get(Integer.parseInt(br.readLine()));
				c.getUser_list().add(u);
				System.out.println("User added successfully...");
				break;
			case 6:
				//code to display users
				System.out.println("Enter id of chatroom: ");
				c = chatroom_list.get(Integer.parseInt(br.readLine()));
				Iterator<User> usr_itr = c.getUser_list().iterator();
				while(usr_itr.hasNext()){
					System.out.println(usr_itr.next());
				}
				break;
				/*User u = new User();
				System.out.println("Enter email of the user: ");
				u.setEmail_id(br.readLine());
				System.out.println("Enter password: ");
				u.setPassword(br.readLine());
				System.out.println("Enter User name: ");
				u.setUser_name(br.readLine());
				System.out.println("Entr room id for user: ");
				user_list.put(u.getEmail_id(), u);
				System.out.println("User added successfully...");
				break;
			case 3:
				//code for loging in user
				if(logged_in == false){
				System.out.println("Enter email id: ");
				String useremail = br.readLine();
				System.out.println("Enter password: ");
				String password = br.readLine();
				User u1 = (User)user_list.get(useremail);
				if(u1!=null){
					if(u1.getPassword().equals(password)){
						System.out.println("Successfully logged in");
						logged_in_email = useremail;
						logged_in = true;
					}else{
						System.out.println("Wrong password");
					}
				}else{
					System.out.println("No such user");
				}
				}else{
					System.out.println("You are alerady logged in as "+ logged_in_email);
				}
				break;
			case 4:
				//code for sending a message
				if(logged_in == true){
					System.out.println("Enter message body: ");
					String message_body = br.readLine();
					Message m = new Message();
					m.setSender_email(logged_in_email);
					m.setBody(message_body);
					m.setChatroom_id(user_list.get(logged_in_email).getRoom_id());
					message_list.add(m);
				}else{
					System.out.println("You must be logged in");
				}
				break;
			case 5:
				//code for displaying message of particular chatroom
				System.out.println("Enter Chat room id : ");
				int myroomid = Integer.parseInt(br.readLine());
				Iterator<Message> itr_message = message_list.iterator();
				while (itr_message.hasNext()) {
					Message message = (Message) itr_message.next();
					if(message.getChatroom_id() == myroomid)
					System.out.println(message);
					
				}
				
				break;
			case 6:
				System.out.println("Enter chatroom id: ");
				int roomid = Integer.parseInt(br.readLine());
				Iterator<String> itr_user = user_list.keySet().iterator();
				while(itr_user.hasNext()){
					System.out.println(itr_user.next());
				}
				break;
			case 7:
				//functionality of logout
				logged_in = false;
				logged_in_email = "";
				
				break;
			case 8:
				//functionality to delete a user
				System.out.println("Enter user email_id: ");
				String delmail_id = br.readLine();
				if(logged_in == true && logged_in_email.equals(delmail_id)){
					System.out.println("You are logged in as current user... Cannot delete...");
				}else{
					user_list.remove(delmail_id);
				}*/
				
			}
		}
	}
	
}
*/