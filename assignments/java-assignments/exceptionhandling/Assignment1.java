package exceptionhandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream file = new FileInputStream(new File("abc.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			//e.printStackTrace();
		} catch (Exception e1){
			e1.printStackTrace();
		}
		
		
		try {
			FileInputStream file = new FileInputStream(new File("abc.txt"));
			try {
				Class c = Class.forName("Abc");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("File not found");
		}
		
		
		try {
			Class c = Class.forName("Abc");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Class not found");
		} finally{
			System.out.println("Final block");
		}
		
		
		try {
			int x = 5/0;
		}finally{
			System.out.println("Try with finally will terminate now....");
		}
		
		
	}

}
