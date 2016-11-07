package com.sample.assignment2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_master")
public class Customer {
	
	public Customer() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public Customer(String name){
		this.cust_name = name;
	}
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Long cust_id;
	
	@Column(name = "name")
	private String cust_name;

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	
	
	public String toString(){
		return this.cust_id+" "+this.cust_name;
	}
	
}
