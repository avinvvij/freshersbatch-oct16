package com.collectionex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List<String> a_list = new ArrayList<String>();
		CopyOnWriteArrayList<String> a_list = new CopyOnWriteArrayList<String>();
		
		
		Thread read_thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
				Iterator<String> itr = a_list.iterator();
				while(itr.hasNext()){
					System.out.println(itr.next());
				}
				}
			}
		});
		
		
		Thread write_thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					a_list.add("Hello");
				}
			}
		});
		
		write_thread.start();
		read_thread.start();
	}

}
