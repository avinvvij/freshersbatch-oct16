package com.chatapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ChatAppMain {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		PersistanceFactory pf = PersistanceFactory.getInstance();
		Persistance p = pf.getPersistance();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int user_choice;
		int logged_in=0;
		String logged_in_email = "";
		outer:
		while(true){
		System.out.println("Welcome\n1)New ChatRoom\n2)New User\n3)Send Message\n4)Login\n"
				+ "5)View All Chatrooms"
				+ "\n6)View All Users"
				+ "\n7)Delete a chatroom"
				+ "\n8)Delete a user"
				+ "\n9)Logout"
				+ "\n10)Exit");
		user_choice = Integer.parseInt(br.readLine());
		switch(user_choice){
		case 1:
			System.out.println("Enter chatroom name: ");
			String chatroom_name = br.readLine();
			p.addChatRoom(chatroom_name);
			break;
		case 2:
			User u = new User();
			System.out.println("Enter username: ");
			String user_name = br.readLine();
			u.setUsername(user_name);
			System.out.println("Enter email id: ");
			String email_id = br.readLine();
			u.setEmail(email_id);
			System.out.println("Enter password: ");
			u.setPassword(br.readLine());
			System.out.println("Enter Chatroom name: ");
			String chatroomname = br.readLine();
			p.addUser(u,chatroomname);
			break;
		case 3:
			if(logged_in==1){
				//logic to send a message
				System.out.println("Enter message body: ");
				String message_body = br.readLine();
				Message m = new Message();
				m.setBody(message_body);
				p.addMessage(m,logged_in_email);
			}else{
				System.out.println("please login to send a message");
			}
			break;
		case 4:
			if(logged_in==1){
				System.out.println("You are alerady logged in");
			}else{
				System.out.println("Enter email id:");
				String email_id1= br.readLine();
				System.out.println("Enter password");
				String password1 = br.readLine();
				boolean log_result = p.login(email_id1, password1);
				if(log_result==true){
					logged_in = 1;
					logged_in_email = email_id1;
					System.out.println("You are successfully logged in as"+logged_in_email);
				}else{
					logged_in = 0;
					logged_in_email="";
					System.out.println("No such user");
				}
			}
			break;
		case 5:
			//logic to view all chatrooms
			List<Chatroom> chatroom_list= p.displayAllChatRoom();
			for(Chatroom cc : chatroom_list){
				System.out.println(cc);
			}
			break;
		case 6:
			//logic to view all users
			List<User> user_list = p.displayAllUser();
			for(User u1 : user_list){
				System.out.println(u1);
			}
			break;
		case 7:
			if(logged_in == 0){
				System.out.println("Enter chatroom to delete");
				String ch_chat_name = br.readLine();
				p.deleteChatRoom(ch_chat_name);
			}
			break;
		case 8:
			if(logged_in == 0){
				System.out.println("Enter email to delete");
				String ch_email = br.readLine();
				p.deleteUser(ch_email);
			}else{
				System.out.println("logout to delete");
			}
			break;
		case 9:
			if(logged_in == 1){
				logged_in=0;
				logged_in_email = "";
			}else{
				System.out.println("You are not logged in");
			}
			break;
		case 10:
			p.endPersistance();
			break outer;
		}
	}
		
	}

}
