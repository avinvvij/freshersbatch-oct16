package com.inherit.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "bike")
public class Bike extends Vehicle{
	
	public Bike(String brand , Double litres){
		super(brand);
		this.litres = litres;
	}
	
	@Column(name = "litres")
	private Double litres;

	public Double getLitres() {
		return litres;
	}

	public void setLitres(Double litres) {
		this.litres = litres;
	}
	
	
	
}
