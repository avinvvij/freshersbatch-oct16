package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Date implements Serializable{
	private int day;
	private int month;
	private int year;
	
	public Date(int day,int month,int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
	public String toString(){
		return this.day+"/"+this.month+"/"+this.year;
	}
}


class Account5 implements Serializable{
	
	private int ac_no;
	private String name;
	private Date dob;
	private transient long balance;
	private static final long serialVersionUID = 5l;
	
	public Account5(int ac_no,String name,long balance,Date dob)
	{
		this.ac_no = ac_no;
		this.name = name;
		this.balance = balance;
		this.dob = dob;
	}

	public int getAc_no() {
		return ac_no;
	}

	public void setAc_no(int ac_no) {
		this.ac_no = ac_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}


	public String toString(){
		return this.ac_no+" "+this.name+" "+this.balance;
	}
	
	
	
	
}


public class Assignment5 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Account5 a = new Account5(1, "ABC", 1000l, new Date(26, 6, 1994));
		File f = new File("assignment5.txt");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(a);
			os.flush();
			os.close();
			System.out.println("Data successfully recorded.. lets read it now");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Account5 aobj = (Account5)ois.readObject();
			System.out.println("Name = "+aobj.getName()+" balance = "+aobj.getBalance()+" ac_no = "+aobj.getAc_no()+" dob = "+aobj.getDob());
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
