package com.version2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class WaterTank extends Frame {

	int y1 =200, yht = 200;
	Thread inlet,outlet,controller;
	String per = "70";
	boolean myflow = true;
	
	public WaterTank() {
		super("Ball game");
		setBackground(Color.CYAN);
		setSize(500, 500);
		setVisible(true);
		
		
		inlet= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
				y1-=10;
				yht+=10;
				int myper = Integer.parseInt(per)+2;
				per = ""+myper;
				myflow = true;
				myCommunication();
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				}
			}
		});
		
		inlet.start();
		
		outlet = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					y1+=10;
					yht-=10;
					int myper = Integer.parseInt(per)-2;
					per = ""+myper;
					myflow = false;
					myCommunication();
					
					try {
						Thread.sleep(350);
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					repaint();
					}
				}
			});
		outlet.start();
		controller = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					if(Integer.parseInt(per)>=85){
						inlet.suspend();
						outlet.resume();
					}else if(Integer.parseInt(per)<=75){
						inlet.resume();
						outlet.suspend();
					}
				}
			}
		});
		
		controller.setDaemon(true);
		//controller.start();
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
		
	synchronized void myCommunication(){
		if(Integer.parseInt(per)<=78 && myflow==false){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			notify();
		}
		
		
		if(Integer.parseInt(per)>=82 && myflow==true){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			notify();
		}
		
		
		
	}
	
	public void paint(Graphics g) {
		g.drawRect(150, 100, 200, 300);
		g.setColor(Color.RED);
		g.fillRect(150, y1, 200, yht);
		g.drawString(per+"%", 380, 200);
	}

	public static void main(String[] args) {
		Frame mf = new WaterTank();
		mf.setSize(500, 500);
		mf.setVisible(true);
	}
}
