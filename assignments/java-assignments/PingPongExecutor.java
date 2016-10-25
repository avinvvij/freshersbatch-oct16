package com.version2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPongExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0 ;i<10;i++){
					System.out.println("PING");
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++){
					System.out.println("\tPONG");
				}
			}
		};
		
		Runnable r3 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0;i<10;i++){
					System.out.println("\t\tTONG");
				}
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(r1);
		executor.submit(r2);
		executor.submit(r3);
	}

}
