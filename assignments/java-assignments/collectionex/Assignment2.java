package com.collectionex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> hset = new HashSet<Integer>();
		hset.add(1);
		hset.add(2);
		hset.add(3);
		hset.add(4);
		Iterator<Integer> itr = hset.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		Set<Integer> lset = new LinkedHashSet<Integer>();
		lset.add(1);
		lset.add(2);
		lset.add(3);
		lset.add(4);
		itr = lset.iterator();
		while(itr.hasNext()){
			System.out.println("\t"+itr.next());
		}
	}

}
