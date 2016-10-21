package com.file;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.file.Account5;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("assignment6.txt");
		
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			Account5 a = new Account5(1, "Abc", 10000, new Date(26, 6, 1994));
			Account5 a1 = new Account5(2, "Def", 1000, new Date(21, 2, 1998));
			raf.writeInt(a.getAc_no());
			raf.writeUTF(a.getName());
			raf.writeLong(a.getBalance());
			raf.writeInt(a1.getAc_no());
			raf.writeUTF(a1.getName());
			raf.writeLong(a1.getBalance());
			
			raf.seek(0);
			System.out.println("Raf data: ");
			while(raf.getFilePointer() != raf.length()){
				Account5 b = new Account5(raf.readInt(), raf.readUTF(), raf.readLong(), null);
				if(b.getBalance()>=10000)
				System.out.println(b);
			}
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
