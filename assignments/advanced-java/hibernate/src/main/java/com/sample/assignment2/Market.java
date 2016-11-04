package com.sample.assignment2;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "market_master")
public class Market {
	
	
	public Market(){
		
	}
	
	public Market(String name){
		this.market_name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String market_name;
	
	
	@OneToMany(mappedBy = "market" , cascade={CascadeType.ALL}, fetch=FetchType.EAGER, orphanRemoval=true)
	private Set<Stock> stockset;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMarket_name() {
		return market_name;
	}


	public void setMarket_name(String market_name) {
		this.market_name = market_name;
	}


	public Set<Stock> getStockset() {
		return stockset;
	}


	public void setStockset(Set<Stock> stockset) {
		this.stockset = stockset;
	}
	
	@Override
	public String toString(){
		return this.market_name+" "+this.stockset;
	}
	
	
}
