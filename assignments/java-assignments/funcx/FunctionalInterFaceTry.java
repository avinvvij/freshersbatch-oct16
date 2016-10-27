package com.funcx;

@FunctionalInterface
interface MyFunctionalInterface<T>{
	void print(T t);
	
	
	default void hello(){
		System.out.println("This is my world");
	}
	
	static void hellox(){
		System.out.println("Heelooo xxxx");
	}
}


public class FunctionalInterFaceTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFunctionalInterface<String> mfi = (String str)->System.out.println(str);
		mfi.print("Hello");
		mfi.hello();
		MyFunctionalInterface.hellox();
	}

}
