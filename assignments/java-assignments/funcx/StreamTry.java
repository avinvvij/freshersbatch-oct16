package com.funcx;

import java.util.ArrayList;
import java.util.function.Predicate;

public class StreamTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(7);
		list.add(4);
		System.out.println(list.stream().filter((Integer i)->i>2?true:false).count());
	}

}
