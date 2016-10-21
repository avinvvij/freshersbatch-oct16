package com.file;

import java.io.File;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File directory = new File("D:/Core_java/Assignments");
		File[] list = directory.listFiles();
		for(int i=0;i<list.length;i++){
			System.out.println("name: "+list[i].getName()+" size:"+list[i].length()+" date: "+list[i].lastModified());
		}
	}

}
