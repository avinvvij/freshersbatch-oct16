package com.avi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDetails {
	public static void main(String args[]) throws NoSuchMethodException, SecurityException{
		Class c = String.class;
		Constructor cc[] = c.getDeclaredConstructors();
		for(Constructor constructor : cc)
		System.out.println(constructor);
		Method m[] = c.getMethods();
		for(Method mm : m){
			System.out.println(mm);
		}
		Field ff[] = c.getDeclaredFields();
		for(Field f : ff){
			System.out.println(f);
		}
	}
}
