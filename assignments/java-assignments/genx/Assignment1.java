package com.genx;


class GenericWrapper<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
	
}

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericWrapper<String> str = new GenericWrapper<String>();
		str.setT("Hello world");
		System.out.println(str.getT());
	}

}
