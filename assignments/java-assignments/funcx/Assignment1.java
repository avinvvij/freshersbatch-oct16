package com.funcx;

@FunctionalInterface
interface Arithmatic<T extends Number>{
	T operation(T t , T t1);
}

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arithmatic<Integer> a = (Integer i , Integer i1)->{return (i+i1);};
		System.out.println(a.operation(2, 3));
		a = (Integer i , Integer i1)->{return (i-i1);};
		System.out.println(a.operation(5, 3));
		a = (Integer i , Integer i1)->{return (i*i1);};
		System.out.println(a.operation(5, 4));
		Arithmatic<Float> a1 = (Float i , Float i1)->{return (i/i1);};
		System.out.println(a1.operation(5f, 2f));
	}

}
