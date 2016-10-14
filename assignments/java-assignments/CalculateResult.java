public class CalculateResult{
	public static void main(String args[])
	{
		if(Integer.parseInt(args[0]) >= 60 && Integer.parseInt(args[1])>=60 && Integer.parseInt(args[2])>=60){
			System.out.println("Passed");
		}else if((Integer.parseInt(args[0])>=60 && Integer.parseInt(args[1])>=60)||(Integer.parseInt(args[0])>=60 && Integer.parseInt(args[2])>=60) || (Integer.parseInt(args[1])>=60 && Integer.parseInt(args[2])>=60)){
			System.out.println("Promoted");
		}else{
			System.out.println("Failed");
		}
	}
}