package com.funcx;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wordlist = new LinkedList<String>();
		wordlist.add("Hello");
		wordlist.add("World");
		wordlist.add("Entr");
		wordlist.add("Appy");
		
		Predicate<String> p = (String str)->str.length()%2!=0?true:false;
		wordlist.removeIf(p);
		Iterator<String> itr = wordlist.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
