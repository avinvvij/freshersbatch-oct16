package com.inherit.tableperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Car_Master")
@AttributeOverrides({
	@AttributeOverride(name = "id" , column=@Column(name="id")),
	@AttributeOverride(name = "brand" , column =@Column(name = "brand"))
})
public class Car extends Vehicle1{

	public Car(){
		
	}
	
	public Car(String brand , Double mielage){
		super(brand);
		this.mielage = mielage;
	}
	
	
	
	@Column(name = "mielage")
	private Double mielage;

	

	public Double getMielage() {
		return mielage;
	}

	public void setMielage(Double mielage) {
		this.mielage = mielage;
	}
	
	
	
}
