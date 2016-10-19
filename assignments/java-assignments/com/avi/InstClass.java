package com.avi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MySample{
	int id;
	public MySample(int id){
		this.id = id;
		System.out.println("New Object made with id: "+id);
	}
}

class MyClassSample{
	public MyClassSample(){
		System.out.println("Constructor with no parameter");
	}
}

public class InstClass {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class c = Class.forName(args[0]);
		Class argtypes[]=null;
		Object argvalues[] = null;
		Constructor[] cc = c.getDeclaredConstructors();
		for(Constructor constructor : cc){
			argtypes = constructor.getParameterTypes();
			System.out.println(argtypes.length);
			if(argtypes.length==0){
				c.newInstance();
				break;
			}else{
				argvalues = new Object[argtypes.length];
				for(int i = 0;i<argtypes.length;i++){
					argvalues[i] = 1; 
				}
				c.getDeclaredConstructor(argtypes).newInstance(argvalues);
			}
		}
		
		
	}

}
