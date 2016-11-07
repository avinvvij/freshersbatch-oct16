package com.chatapp;

public class PersistanceFactory {

	static PersistanceFactory pf = null;
	
	private PersistanceFactory(){
		
	}
	
	public static PersistanceFactory getInstance(){
		if(pf!=null){
			return pf;
		}else{
			pf = new PersistanceFactory();
			return pf;
		}
	}
	
	
	public static Persistance getPersistance(){
		return new HibernatePersistance();
		
	}
	
}
