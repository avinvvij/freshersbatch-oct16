package com.collectionex;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


class Person implements Comparable<Person>{
	private int weight;
	private int height;
	private String name;
	
	public Person(int height,int weight , String name){
		this.height = height;
		this.weight = weight;
		this.name = name;
	}
	
	public String toString(){
		return this.name+" "+this.weight+" "+this.height;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if(this.weight < o.weight){
			return -1;
		}else if(this.weight > o.weight){
			return 1;
		}else if(this.weight == o.weight){
			if(this.height < o.height){
				return -1;
			}else if(this.height > o.height){
				return 1;
			}else{
				return 0;
			}
		}
		return 0;
	}

	
	
}

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Person> treeset = new TreeSet<Person>();
		Person p1 = new Person(25, 75, "ABC");
		Person p2 = new Person(30, 85, "DEF");
		Person p3 = new Person(45, 75, "GHI");
		treeset.add(p1);
		treeset.add(p2);
		treeset.add(p3);
		Iterator<Person> itr = treeset.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
