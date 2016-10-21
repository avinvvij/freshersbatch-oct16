package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class Assignment4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f1 = new File("abc.txt");
		File f2 = new File("pqr.txt");
		File f3 = new File("accountdata.txt");
		FileInputStream fis1 = null;
		FileInputStream fis2 = null,fis3 = null;
		try {
			fis1 = new FileInputStream(f1);
			fis2 = new FileInputStream(f2);
			fis3 = new FileInputStream(f3);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Vector fislist = new Vector();
		fislist.add(fis1);
		fislist.add(fis2);
		fislist.add(fis3);
		Enumeration e = fislist.elements();
		SequenceInputStream sis = new SequenceInputStream(e);
		int i=0;
		try {
			while((i=sis.read())!=-1){
				System.out.println((char)i);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sis.close();
		fis1.close();
		fis2.close();
		fis3.close();
	}

}
