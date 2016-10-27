package com.genx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Assignment2 {

	public static void print_num(List<? extends Number> list ){
		Iterator<? extends Number> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numlist = new ArrayList<Integer>();
		for(int i=0;i<10;i++)
			numlist.add(i);
		print_num(numlist);
	}

}
