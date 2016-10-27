package com.funcx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> mylist = new ArrayList<String>();
		mylist.add("Hello");
		mylist.add("World");
		mylist.add("Xoriant");
		
		Consumer<ArrayList<String>> c = (ArrayList<String> alist)->{
			StringBuilder sb = new StringBuilder("");
			Iterator<String> itr = alist.iterator();
			while(itr.hasNext()){
				sb.append(itr.next().charAt(0)+" ");
			}
			System.out.println(sb);
		};
		
		c.accept(mylist);
		
	}

}
