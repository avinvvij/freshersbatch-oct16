package com.chatapp;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "chatroom_master")
public class Chatroom {

	public Set<User> getUserset() {
		return userset;
	}

	public void setUserset(Set<User> userset) {
		this.userset = userset;
	}

	public Chatroom() {
		// TODO Auto-generated constructor stub

	}
	
	public Chatroom(String name){
		this.name = name;
	}
	
	@Id
	@GeneratedValue
	@Column(name="chatroom_id")
	private Long id;
	
	@Column(name = "name")
	private String name;

	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
			name="ChatRoom_User",
			joinColumns = {@JoinColumn(name="chatroom_id")},
			inverseJoinColumns = {@JoinColumn(name = "user_id")}
			)
	private Set<User> userset = new HashSet<User>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
}
