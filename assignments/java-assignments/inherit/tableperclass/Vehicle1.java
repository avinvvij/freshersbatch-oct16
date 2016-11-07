package com.inherit.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE_MASTER")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Vehicle1{
	
	public Vehicle1() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle1(String brand){
		this.brand = brand;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name = "brand")
	private String brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
