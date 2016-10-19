package com.avi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Sample{
	public int message(int x){
		if(x==0)
		return 0;
		else 
		return 1;
	}
}

class MyMiddleWare{
	public Object invoke(String classname , String methodname , Class argtypes[] , Object argvalues[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Class c = Class.forName(classname);
		Method m = c.getMethod(methodname, argtypes);
		return m.invoke(c.newInstance(), argvalues);
	
	}
}

public class MiddleWareExample {
	public static void main(String args[]){
		String classname = "com.avi.Sample";
		String methodname = "message";
		Class argtypes[] = new Class[1];
		argtypes[0] = int.class;
		Object argvalues[] = new Object[1];
		argvalues[0] = 1;
		MyMiddleWare mm = new MyMiddleWare();
		try {
			System.out.println(mm.invoke(classname, methodname, argtypes, argvalues));
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
