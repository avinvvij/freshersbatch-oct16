package com.file;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;


import com.file.Account5;

public class Assignment6 {
	static File f;
	static RandomAccessFile raf;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		f = new File("assignment6.txt");
		raf = new RandomAccessFile(f, "rw");
	
		int choice = 0;
		int ac_count = 1;
		while(true){
			
		System.out.println("Enter YOur choice:\n1)Create\n2)Read\n3)Update\n4)Delete:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		choice = Integer.parseInt(br.readLine());
		switch(choice){
		case 1:
			createAccount(new Account5(ac_count, "Abc", 10000, null));
			ac_count++;
			break;
		case 2:
			readAccount();
			break;
		case 3:
			updateAccount(2);
			break;
		case 4:
			deleteAccount(2);
			break;
		case 5:
			raf.close();
			System.exit(0);
		
		}
		
	}
		
	
}
	
	

	public static void createAccount(Account5 a) throws IOException{
		raf.writeInt(a.getAc_no());
		raf.writeUTF(a.getName());
		raf.writeLong(a.getBalance());
	}
	
	public static void readAccount() throws IOException{
		raf.seek(0);
		System.out.println("Raf data: ");
		while(raf.getFilePointer() != raf.length()){
			Account5 b = new Account5(raf.readInt(), raf.readUTF(), raf.readLong(), null);
			if(b.getBalance()>=10000)
			System.out.println(b);
		}
		
	}
	
	public static void updateAccount(int ac_no) throws IOException{
		raf.seek(0);
		
		while(raf.getFilePointer() != raf.length()){
			if(raf.readInt()==ac_no){
				raf.writeUTF("DEF");
				raf.writeLong(10000);
				
			}else{
				raf.readUTF(); 
				raf.readLong();
			}
		}
		System.out.println("Updated ");
	}
	
	public static void deleteAccount(int ac_no) throws IOException{
		raf.seek(0);
		
		while(raf.getFilePointer() != raf.length()){
			if(raf.readInt()==ac_no){
				raf.setLength(raf.getFilePointer()-4);
			}else{
				raf.readUTF(); 
				raf.readLong();
			}
		}
		System.out.println("Deleted ");
	}
	
	
	
}
