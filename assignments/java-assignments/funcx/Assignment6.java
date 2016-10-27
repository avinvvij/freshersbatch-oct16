package com.funcx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.UnaryOperator;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> mylist = new ArrayList<String>();
		mylist.add("abc");
		mylist.add("bgh");
		UnaryOperator<ArrayList<String>> u = (ArrayList<String>  alist)->{
			ArrayList<String> a1 = new ArrayList<String>();
			Iterator<String> itr = alist.iterator();
			while (itr.hasNext()) {
				String string = (String) itr.next();
				string = string.toUpperCase();
				a1.add(string);
			}
			
			return a1;
		};
			ArrayList<String> al = u.apply(mylist);
			Iterator<String> itr_str = al.iterator();
			while (itr_str.hasNext()) {
				String string = (String) itr_str.next();
				System.out.println(string);
			}
	}

}
