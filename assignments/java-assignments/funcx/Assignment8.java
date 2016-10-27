package com.funcx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			mylist.add(i);
		}
		
		
		Runnable r = ()->{
			Consumer<ArrayList<Integer>> c = (ArrayList<Integer> alist)->{
				Iterator<Integer> itr = alist.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next());
				}
			};
			c.accept(mylist);
			};	
			
			Thread t = new Thread(r);
			t.start();
			
	}
}