package com.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Account{
	private int ac_no;
	private long balance;
	private String name;
	
	public int getAc_no() {
		return ac_no;
	}

	public void setAc_no(int ac_no) {
		this.ac_no = ac_no;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account(int ac_no,long balance,String name){
		this.ac_no = ac_no;
		this.balance = balance;
		this.name = name;
	}
	
}

public class Assignment3 {
	public static void main(String args[]){
		File f = new File("accountdata.txt");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			Account a = new Account(1, 2000l, "ABC");
			dos.writeInt(a.getAc_no());
			dos.writeLong(a.getBalance());
			dos.writeUTF(a.getName());
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Data successfully entered.... lets read it now...");
		try {
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			System.out.println("account no = " + dis.readInt()+" balance = "+dis.readLong()+" name = "+dis.readUTF());;
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
