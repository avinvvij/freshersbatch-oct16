package com.sample.assignment2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry_master")
public class Enquiry {

	public Enquiry() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Enquiry(String message,Customer cust){
		this.enq_message = message;
		this.cust = cust;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	private Long enq_id;
	
	@Column(name = "body")
	private String enq_message;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private Customer cust;

	public Long getEnq_id() {
		return enq_id;
	}

	public void setEnq_id(Long enq_id) {
		this.enq_id = enq_id;
	}

	public String getEnq_message() {
		return enq_message;
	}

	public void setEnq_message(String enq_message) {
		this.enq_message = enq_message;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	@Override
	public String toString(){
		return this.enq_id+" "+this.cust+" raised an enquiry about: "+this.enq_message;
	}
	
}
