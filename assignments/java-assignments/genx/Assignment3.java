package com.genx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Assignment3 {

	public static void print_hash(HashMap<? extends Number, ?> hm){
		Iterator<? extends Number> itr_key = hm.keySet().iterator();
		while(itr_key.hasNext()){
			Object mykey = itr_key.next();
			System.out.println(mykey+" "+hm.get(mykey));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Number, String> hm = new HashMap<Number,String>();
		hm.put(1.2, "ABC");
		hm.put(2.5, "DEF");
		hm.put(3.8, "FGI");
		print_hash(hm);
	}

}
