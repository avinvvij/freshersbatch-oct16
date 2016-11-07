package com.chatapp;

import java.util.List;

import javax.transaction.UserTransaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernatePersistance implements Persistance{

	Configuration config;
	SessionFactory sf;
	
	public HibernatePersistance(){
		config = new Configuration();
		config.configure("hibernate.cfg.xml");
		sf = config.buildSessionFactory();
	}
	
	public void addChatRoom(String name) {
		// TODO Auto-generated method stub
		Chatroom cr = new Chatroom(name);
		Session session_chat = sf.openSession();
		Transaction cr_tran = session_chat.beginTransaction();
		session_chat.save(cr);
		cr_tran.commit();
		session_chat.close();
		
	}

	public void addUser(User u,String chatroomname) {
		// TODO Auto-generated method stub
		Session session_user = sf.openSession();
		Transaction user_transaction = session_user.beginTransaction();
		session_user.save(u);
		user_transaction.commit();
		session_user.close();
		session_user = sf.openSession();
		user_transaction = session_user.beginTransaction();
		Query q = session_user.createQuery("from Chatroom where name = '"+chatroomname+"'");
		List<Chatroom> c_list = q.list();
		if(c_list.size()==0){
		user_transaction.rollback();	
		}else{
		Long id = c_list.get(0).getId();
		Chatroom c = session_user.load(Chatroom.class, id);
		User u1 = session_user.load(User.class, u.getId());
		c.getUserset().add(u);
		u.getChatroomset().add(c);
		user_transaction.commit();
		}
		session_user.close();
	}

	public void addMessage(Message m ,String logged_in_email) {
		// TODO Auto-generated method stub
		Session add_message = sf.openSession();
		Transaction add_message_transaction = add_message.beginTransaction();
		add_message.save(m);
		Query q = add_message.createQuery("from User where email='"+logged_in_email+"'");
		List<User> u_list = q.list();
		Long id = u_list.get(0).getId();
		User u = add_message.load(User.class, id);
		u.getMessages().add(m);
		m.setUser(u);
		add_message_transaction.commit();
		add_message.close();
	}

	public void deleteChatRoom(String name) {
		// TODO Auto-generated method stub
		Session delete_chatroom = sf.openSession();
		Transaction delete_chatroom_tran = delete_chatroom.beginTransaction();
		Query q = delete_chatroom.createQuery("delete from Chatroom");
		int updates = q.executeUpdate();
		System.out.println(updates+" Rows deleted");
		delete_chatroom_tran.commit();
		delete_chatroom.close();
	}

	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		Session delete_user = sf.openSession();
		Transaction delete_user_transaction = delete_user.beginTransaction();
		Query q = delete_user.createQuery("delete from User");
		int updates = q.executeUpdate();
		System.out.println(updates+" Rows deleted");
		delete_user_transaction.commit();
		delete_user.close();
	}

	public void deleteMessage(Long id) {
		// TODO Auto-generated method stub
		
	}

	public List<Chatroom> displayAllChatRoom() {
		Session disp_chatroom = sf.openSession();
		Query q = disp_chatroom.createQuery("from Chatroom");
		List<Chatroom> chat_list = q.list();
		disp_chatroom.close();
		return chat_list;
	}

	public List<User> displayAllUser() {
		// TODO Auto-generated method stub
		Session disp_chatroom = sf.openSession();
		Query q = disp_chatroom.createQuery("from User");
		List<User> user_list = q.list();
		disp_chatroom.close();
		return user_list;
	}

	public void displayAllMessage() {
		// TODO Auto-generated method stub
		
	}

	public void endPersistance() {
		// TODO Auto-generated method stub
		sf.close();
	}

	public boolean login(String u_name, String u_password) {
		// TODO Auto-generated method stub
		Session login_session = sf.openSession();
		Query q = login_session.createQuery("from User where email='"+u_name+"' AND password='"+u_password+"'");
		List<User> u_list = q.list();
		login_session.close();
		if(u_list.size() == 0){
			return false;
		}else{
			return true;
		}
	}

	
	

}
