package com.collectionex;

import java.util.HashMap;
import java.util.Map;

class MyDate{
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day , int month , int year){
		this.day=day;
		this.month = month;
		this.year = year;
	}
	
	public String toString(){
		return this.day+"/"+this.month+"/"+this.year;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.day+this.month;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		MyDate d= (MyDate)obj;
		if(this.day == d.day && this.month == d.month)
		return true;
		else{
			return false;
		}
	}
	
}

class MyPerson{
	private String name;
	private MyDate dob;
	
	public MyPerson(String name , MyDate dob){
		this.name = name;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getDob() {
		return dob;
	}

	public void setDob(MyDate dob) {
		this.dob = dob;
	}
	
	public String toString(){
		return this.name+" dob: "+this.dob;
	}
	
}

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyPerson p1 = new MyPerson("ABC",new MyDate(26, 6, 1994));
		MyPerson p2 = new MyPerson("DEF",new MyDate(26, 7, 2000));
		Map<MyDate, String> hmap = new HashMap<MyDate , String>();
		hmap.put(p1.getDob(),p1.getName());
		hmap.put(p2.getDob(),p2.getName());
		
		System.out.println(hmap.get(p1.getDob()));
		System.out.println(hmap.get(p2.getDob()));
	}

}
