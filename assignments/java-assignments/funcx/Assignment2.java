package com.funcx;

import java.util.function.Predicate;


class Order{
	private int id;
	private Integer price;
	private Integer order_status;
	
	public Order(int id , int price){
		this.id = id;
		this.price = price;
		this.order_status = 1;
	}
	
	public void update_order(){
		this.order_status = 2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	
	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String toString(){
		return this.id+" "+this.price+" "+this.order_status;
	}
	
	
}

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order o[] = new Order[3];
		o[0] = new Order(1, 20000);
		o[1] = new Order(2, 4000);
		o[2] = new Order(3, 50000);
		o[0].update_order();
		o[1].update_order();
		Predicate<Order> p = (Order price)->price.getPrice()>10000?true:false;
		System.out.println("Filtering based on price");
		Filter(o, p);
		System.out.println("Filtering based on status");
		Predicate<Order> p1 = (Order status)->{if(status.getOrder_status() == 2 || status.getOrder_status() == 3) return true; else return false;};
		Filter(o, p1);
	}
	
	public static void Filter(Order[] o , Predicate<Order> p){
		for(int i = 0 ;i< o.length;i++){
			if(p.test(o[i])){
				System.out.println(o[i]);
			}
		}
	}

}
