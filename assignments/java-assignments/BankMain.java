class Account{
	private int ac_no;
	private String cust_name;
	private double init_amt;
	
	public Account(int ac_no , String cust_name,double init_amt){
		this.ac_no = ac_no;
		this.cust_name = cust_name;
		this.init_amt = init_amt;
	}
	
	public double get_amt(){
		return this.init_amt;
	}
}

class SavingAccount extends Account{
	private double pf;
	
	public SavingAccount(int ac_no,String cust_name,double init_amt,double pf){
		super(ac_no,cust_name,init_amt);
		this.pf = pf;
	}
	
	public double get_amt(){
		return super.get_amt() + this.pf;
	}
}

class CurrentAccount extends Account{
	private double cr;

	public CurrentAccount(int ac_no,String cust_name,double init_amt,double cr){
		super(ac_no,cust_name,init_amt);
		this.cr = cr;
	}
	
	public double get_amt(){
		return super.get_amt() + this.cr;
	}
}

public class BankMain{
	public static void main(String args[]){
		Account a[] = new Account[2];
		a[0] = new CurrentAccount(101,"Abc",2000.0,500.0);
		a[1] = new SavingAccount(102,"DEF",500.0,40000.0);
		double res = totalamt(a);
		System.out.println("Total amount = "+res);
	}
	
	public static double totalamt(Account a[]){
		double sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum+=a[i].get_amt();
		}
		return sum;
	}
}