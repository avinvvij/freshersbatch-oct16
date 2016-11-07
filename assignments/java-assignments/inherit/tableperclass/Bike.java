package com.inherit.tableperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Bike_Master")
@AttributeOverrides({
	@AttributeOverride(name = "id" , column=@Column(name="id")),
	@AttributeOverride(name = "brand" , column =@Column(name = "brand"))
})
public class Bike extends Vehicle1{
	
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
