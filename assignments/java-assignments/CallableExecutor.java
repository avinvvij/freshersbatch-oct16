package com.version2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Callable<Integer> c1 = new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return 1;
			}
		};
		
		Callable<String> c2 = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Two";
			}
		};
		
		Callable<Float> c3 = new Callable<Float>() {
			
			@Override
			public Float call() throws Exception {
				// TODO Auto-generated method stub
				return 3.0f;
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Future<Integer> f1 = executor.submit(c1);
		Future<String> str = executor.submit(c2);
		Future<Float> fl = executor.submit(c3);
		System.out.println(f1.get()+" "+str.get()+" "+fl.get());
	}

}
