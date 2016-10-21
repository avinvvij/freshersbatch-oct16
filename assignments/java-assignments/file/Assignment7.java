package com.file;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class ExternizableTry implements Externalizable{

	private int ac_no;
	private String name;
	
	
	public ExternizableTry(){
		
	}
	
	 public ExternizableTry(int ac_no,String name) {
		// TODO Auto-generated constructor stub
		 this.ac_no = ac_no;
		 this.name = name;
	 }
	
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(in.readUTF());
	}
	
	public String toString(){
		return ac_no+" "+name;
	}
	
}

public class Assignment7 {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		File f = new File("assignment7.txt");
		FileOutputStream fos  = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ExternizableTry et = new ExternizableTry(1, "ABC"); 
		oos.writeObject(et);
		oos.flush();
		oos.close();
		
		System.out.println("Data inserted");
		
		FileInputStream fis  = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ExternizableTry et1 = (ExternizableTry) ois.readObject(); 
		ois.close();
		
		
		
	}

}
