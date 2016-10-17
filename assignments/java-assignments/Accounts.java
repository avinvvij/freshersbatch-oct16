public class Accouts{
	
	int ac_no;
	String holder_name;
	float balance;
	
	public void Deposit(float val)
	{
		balance+=val;
	}
	
	public void withdraw(float val)
	{
		balance-=val;
	}
	
	public void print_bal()
	{
		System.out.println(this.bal+"Rs.");
	}
	
	public static void main(String args[]){
		
	}
	
}