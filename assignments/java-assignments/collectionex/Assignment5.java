package com.collectionex;

import java.util.HashMap;
import java.util.Map;

class MyCustom{
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<MyCustom, Integer> hmap= new HashMap<MyCustom,Integer>(); 
		MyCustom cust1 = new MyCustom();
		MyCustom cust2 = new MyCustom();
		MyCustom cust3 = new MyCustom();
		hmap.put(cust1, 2);
		hmap.put(cust2, 5);
		hmap.put(cust3,7);
		System.out.println(hmap.get(cust1)+" "+hmap.get(cust2)+" "+hmap.get(cust3));
	}

}
