package com.funcx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hmap = new HashMap<String , Integer>();
		hmap.put("One", 1);
		hmap.put("Two",	2);
		hmap.put("Three", 3);
		
		Function<HashMap<String, Integer>,StringBuilder> func = (HashMap<String,Integer> hashmap)->{
			StringBuilder sb = new StringBuilder("");
			Iterator<Entry<String, Integer>> itr = hashmap.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry<java.lang.String, java.lang.Integer> entry = (Map.Entry<java.lang.String, java.lang.Integer>) itr
						.next();
				sb.append(entry.getKey()+" "+entry.getValue()+"\n");
			}
			return sb;
		};
	
		System.out.println(func.apply(hmap));
	}

}
