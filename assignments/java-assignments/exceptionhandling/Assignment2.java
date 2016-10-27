package exceptionhandling;

class InsufficientBalanceException extends Exception{
	String message;
	public InsufficientBalanceException(){
		message = "Insufficient Balance in your account";
	}
	
	public String toString(){
		return this.message;
	}
}

class Account{
	private int ac_no;
	private float balance;
	
	public Account(int ac_no,float balance){
		this.ac_no = ac_no;
		this.balance = balance;
	}
	
	public void withdraw(float balance) throws InsufficientBalanceException{
		if(balance > this.balance){
			throw new InsufficientBalanceException();
		}
	}
}

public class Assignment2 {

	public static void main(String args[])
	{
		Account a = new Account(101, 5000f);
		try {
			a.withdraw(10000f);
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
