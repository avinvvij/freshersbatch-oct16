import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginAttempt{
	public static void main(String args[]){
		int count = 1;
		while(count<=3){
		count++;
		System.out.println("Enter username: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try{
		str = br.readLine();
		}catch(Exception e){
			//exception
		}
		System.out.println("Enter password: ");
		String strpass = null;
		try{
		strpass = br.readLine();
		}catch(Exception e){
			//exception
		}
		if(str.equals("avin") && strpass.equals("avinvij"))
		{
			System.out.println("Valid");
			break;
		}else{
			System.out.println("try again");
		}
	}
	
	 if(count>3){
		 System.out.println("Contact admin");
	 }
	}
}