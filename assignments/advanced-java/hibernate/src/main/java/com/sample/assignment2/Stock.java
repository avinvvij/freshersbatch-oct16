package com.sample.assignment2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_master")
public class Stock {

	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	public Stock(String comp_name , Double stock_price , Market market){
		this.comp_name = comp_name;
		this.stock_price = stock_price;
		this.market = market;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long stock_id;
	
	@Column(name = "company_name")
	private String comp_name;
	
	@Column(name = "stock_price")
	private Double stock_price;
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name = "market_id")
	private Market market;

	public Long getStock_id() {
		return stock_id;
	}

	public void setStock_id(Long stock_id) {
		this.stock_id = stock_id;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public Double getStock_price() {
		return stock_price;
	}

	public void setStock_price(Double stock_price) {
		this.stock_price = stock_price;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}
	
	
	public String toString(){
		return this.comp_name+" "+this.stock_price+"Rs";
	}
	
}
