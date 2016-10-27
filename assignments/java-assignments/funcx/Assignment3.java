package com.funcx;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;


public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Integer> p = (Integer i)->i>5?true:false;
		System.out.println("Predicate test");
		if(p.test(8)){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
		System.out.println("consumer test");
		Consumer<Integer> c = (Integer x)->{
			if(x>7){
				System.out.println("greater than 7");
			}else{
				System.out.println("less than 7");
			}};
		c.accept(8);
		
		System.out.println("Supplier Test");
		Supplier<String> s = ()->{return "Im supplier";};
		System.out.println(s.get());
		
		System.out.println("Function test");
		Function<Integer, String> func = (Integer i)->{return "You passed number: "+i;};
		System.out.println(func.apply(7));
	}

}
