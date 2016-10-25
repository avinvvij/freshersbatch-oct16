package com.version2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.event.WindowAdapter;

public class ReentrantExample extends Frame {
	Thread t1, t2, t3;
	int y1 = 400, y2 = 400, y3 = 400;
	boolean reachedup = false;
	boolean reacheddown = false;
	ReentrantLock lock;
	Condition mycondition;
	
	public ReentrantExample() {
		super("Ball game");
		setBackground(Color.CYAN);
		setSize(500, 500);
		setVisible(true);
		lock = new ReentrantLock();
		mycondition = lock.newCondition();
		
		t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int reverse = 0;
				
				while(true){
					if(y1 >= 50 && reverse == 0)
					{
						y1-=10;
					}else if(y1<100 && reverse == 0){
						lock.lock();
						reachedup = true;
						reacheddown = false;
						myReachedupMethod();
						lock.unlock();
						reverse = 1;
					}
					else if(y1<=400 && reverse == 1){
						y1+=10;
					}else{
						lock.lock();
						reacheddown = true;
						reachedup = false;
						myReachedDownMethod();
						lock.unlock();
						reverse=0;
					}
					repaint();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
			
		});
		
		t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int reverse = 0;
				while(true){
					
					if(y2 >= 50 && reverse == 0)
					{
						y2-=10;
					}else if(y2<100 && reverse == 0){
						myReachedupMethod();
						reverse = 1;
					}else if(y2<=400 && reverse == 1){
						y2+=10;
					}else{
						myReachedDownMethod();
						reverse=0;
					}
					repaint();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int reverse = 0;
				while(true){
					
					if(y3 >= 50 && reverse == 0)
					{
						y3-=10;
					}else if(y3<100 && reverse == 0){	
						myReachedupMethod();
						reverse = 1;
					 }else if(y3<=400 && reverse == 1){
						y3+=10;
					}else{
						myReachedDownMethod();
						reverse=0;
					}
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}
	});
		
		t1.start();
		t2.start();
		t3.start();
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
		void myReachedupMethod(){
			lock.lock();
		if(reachedup == false){
			try {
				mycondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			mycondition.signalAll();
		}
		lock.unlock();
	}
	
	   void myReachedDownMethod(){
		   lock.lock();
		if(reacheddown == false){
			try {
				mycondition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			mycondition.signalAll();
		}
		lock.unlock();
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(100, y1, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(200, y2, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(300, y3, 50, 50);
	}

public static void main(String[] args) {
	Frame mf = new ReentrantExample();
	mf.setSize(500, 500);
	mf.setVisible(true);
}

}
