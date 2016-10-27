package com.collectionex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Parked_Car_Owner_Details{
	private String owner_name;
	private String car_model;
	private int car_no;
	private String owner_mobile;
	private String owner_address;
	

	
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public int getCar_no() {
		return car_no;
	}
	public void setCar_no(int car_no) {
		this.car_no = car_no;
	}
	public String getOwner_mobile() {
		return owner_mobile;
	}
	public void setOwner_mobile(String owner_mobile) {
		this.owner_mobile = owner_mobile;
	}
	public String getOwner_address() {
		return owner_address;
	}
	public void setOwner_address(String owner_address) {
		this.owner_address = owner_address;
	}
	
	
}




class Parked_carOwnerList{
	
	private int floor;
	private int section;
	private int roll;
	private Parked_Car_Owner_Details powner;
	private boolean dirty;
	String token;
	
	public Parked_carOwnerList(int floor ,int section , int roll , Parked_Car_Owner_Details powner , boolean dirty){
		this.floor = floor;
		this.section = section;
		this.roll = roll;
		this.powner = powner;
		this.dirty = false;
	}
	
	

	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public void setSection(int section) {
		this.section = section;
	}



	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public Parked_Car_Owner_Details getPowner() {
		return powner;
	}

	public void setPowner(Parked_Car_Owner_Details powner) {
		this.powner = powner;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	
	
	
}


public class Assignment7 {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Parked_carOwnerList> mylist = new ArrayList<Parked_carOwnerList>();
		HashMap<Integer, Parked_carOwnerList> hmap = new HashMap<Integer,Parked_carOwnerList>();
		
		
		for(int i= 0 ; i<240 ; i++){
			int floor = i/80;
			int section = i/20;
			Parked_carOwnerList pl = new Parked_carOwnerList(floor, section, i, null, false);
			mylist.add(pl);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
		
		System.out.println("Welcome to abc parking:\n1)New Car\n2)Remove car\n3)Search Car");
			switch(Integer.parseInt(br.readLine())){
				case 1:
					Parked_Car_Owner_Details po = new Parked_Car_Owner_Details();
					System.out.println("Enter name: ");
					po.setOwner_name(br.readLine());
					System.out.println("Enter car model");
					po.setCar_model(br.readLine());
					System.out.println("Enter car no:");
					po.setCar_no(Integer.parseInt(br.readLine()));
					System.out.println("Enter mobile number");
					po.setOwner_mobile(br.readLine());
					System.out.println("Enter owner address");
					po.setOwner_address(br.readLine());
					for(int i = 0;i<240;i++){
						Parked_carOwnerList p = mylist.get(i);
						if(p.isDirty() == false){
							p.setPowner(po);
							p.setDirty(true);
							String token = p.getFloor()+" "+p.getSection()+" "+p.getRoll();
							System.out.println("Your token is: "+token);
							p.token = token;
							hmap.put(po.getCar_no(),p);
							break;
						}
					}
					break;
				case 2:
						//code to remove a car
					System.out.println("Enter car_no: ");
					int mycar = Integer.parseInt(br.readLine());
					Parked_carOwnerList pol = hmap.get(mycar);
					pol.setDirty(false);
					pol.setPowner(null);
					hmap.replace(mycar, pol);
					
					break;
				case 3:
						//code to search a car
						System.out.println("Enter Carno:");
						int mycar1 = Integer.parseInt(br.readLine());
						Parked_carOwnerList pol1 = hmap.get(mycar1);
						System.out.println(pol1.getToken());
					break;
			}
		}
		
	}

}
