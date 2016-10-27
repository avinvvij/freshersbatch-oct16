package com.collectionex;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		ListIterator<Integer> itr = list.listIterator(list.size());
		while(itr.hasPrevious()){
			System.out.println(itr.previous());
		}
	}

}
