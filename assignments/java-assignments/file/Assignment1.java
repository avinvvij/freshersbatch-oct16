package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f1 = new File("abc.txt");
		File f2 = new File("pqr.txt");
		try {
			FileInputStream fis = new FileInputStream(f2);
			FileOutputStream fos = new FileOutputStream(f1);
			int i = 0;
			while((i = fis.read())!=-1){
				fos.write(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Contents overruled....");
	}

	
	
}
