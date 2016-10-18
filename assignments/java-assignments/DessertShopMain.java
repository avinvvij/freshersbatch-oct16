import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

abstract class DessertItem{
	abstract double getcost();
	
}

class Candy extends DessertItem{
	private String name;
	private int base_cost;
	private int tax_per;
	private int quantity;
	double getcost(){
	return ((double)this.base_cost+(this.tax_per/100.0))*60;	
	}
	
	String getname(){
		return this.name;
	}
	
	public void add(String name,int base_cost,int tax_per,int quantity){
		this.name = name;
		this.base_cost = base_cost;
		this.tax_per = tax_per;
		this.quantity = quantity;
	}
	
	public void purchase(int quantity){
		this.quantity-= quantity;
	}
	
	public int getquan(){
		return this.quantity;
	}
	

	
}

class Cookie extends DessertItem{
	private String name;
	private int base_cost;
	private int tax_per;
	private int quantity;
	double getcost(){
		return ((double)this.base_cost+(this.tax_per/100.0))*70;
	}
	
	
	String getname(){
		return this.name;
	}
	
	public void add(String name,int base_cost,int tax_per,int quantity){
		this.name = name;
		this.base_cost = base_cost;
		this.tax_per = tax_per;
		this.quantity = quantity;
	}
}

class IceCream extends DessertItem{
	private String name;
	private int base_cost;
	private int tax_per;
	private int quantity;
	
	double getcost(){
		return (double)this.base_cost+(this.tax_per/100.0);
	}
	
	
	String getname(){
		return this.name;
	}
	
	public void add(String name,int base_cost,int tax_per,int quantity){
		this.name = name;
		this.base_cost = base_cost;
		this.tax_per = tax_per;
		this.quantity = quantity;
	}
}

public class DessertShopMain{
	
	public static void main(String args[]){
		ArrayList<Candy> candylist = new ArrayList<Candy>();
		ArrayList<Cookie> cookielist = new ArrayList<Cookie>();
		ArrayList<IceCream> iclist = new ArrayList<IceCream>();
		
		
		double totalbill  = 0;
		while(true){
			System.out.println("Select Your role:\n1)Owner\n2)Customer");
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			String choice = null;
			try{
			choice = b.readLine();
			}catch(Exception e){
			
			}
			if(Integer.parseInt(choice)==1){
				//owner code
				System.out.println("Choose desert item:\n1)Candy\n2)cookie\n3)Icecream");
				try{
				choice = b.readLine();
				}catch(Exception e){
				
				}
				switch(Integer.parseInt(choice)){
					case 1:
						Candy c = new Candy();
						System.out.println("Enter flavour: ");
							String candname = null;
							try{
								candname = b.readLine();
							}catch(Exception e){
								
							}	
						System.out.println("Enter quantity: ");
							String candquan = null;
							try{
								candquan = b.readLine();
							}catch(Exception e){
								
							}								
						c.add(candname,100,10,Integer.parseInt(candquan));
						candylist.add(c);
						System.out.println("Candy added to inventory");
					break;
					case 2:
						Cookie cc = new Cookie();
						System.out.println("Enter flavour: ");
							String cookname = null;
							try{
								cookname = b.readLine();
							}catch(Exception e){
								
							}			
						//cc.add(cookname,200,5);
						cookielist.add(cc);
						System.out.println("Cookie added to inventory");
					break;
					case 3:
					IceCream ic = new IceCream();
					System.out.println("Enter flavour: ");
							String icname = null;
							try{
								icname = b.readLine();
							}catch(Exception e){
								
							}			
						//ic.add(icname,150,3);
						iclist.add(ic);
						System.out.println("IceCream added to inventory");
					break;
				}
				
				System.out.println("Your inventory: ");
				for(int i =0 ;i<candylist.size();i++){
					Candy c = candylist.get(i);
					System.out.println(" "+c.getname()+" quantity: "+c.getquan());
				}
				
				
			}else if(Integer.parseInt(choice)==2){
			//customer code
			
			System.out.println("Choose desert item:\n1)Candy\n2)cookie\n3)Icecream");
				try{
				choice = b.readLine();
				}catch(Exception e){
				
				}
				switch(Integer.parseInt(choice)){  
					case 1:
						System.out.println("Choose your candy: ");
						for(int i =0 ;i<candylist.size();i++){
						Candy c = candylist.get(i);
						System.out.println(i+" "+c.getname());
				}
					int custchoice = 0;
					int custquan = 0;
					
					try{
						custchoice = Integer.parseInt(b.readLine());
						System.out.println("Select Quantity: ");
						custquan = Integer.parseInt(b.readLine());
					}catch(Exception e){
				
					}
					Candy c1 = candylist.get(custchoice);
					if(c1.getquan()>custquan){
					totalbill+=c1.getquan();
					c1.purchase(custquan);
					System.out.println("Selling "+c1.getname()+" bill="+totalbill);
					}
					break;
					
				}
			}
		}
	}
}