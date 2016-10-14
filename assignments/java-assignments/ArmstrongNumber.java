public class ArmstrongNumber{
	public static void main(String args[])
	{
		int sum=0;
		int d;
		int num = Integer.parseInt(args[0]);
		int cp_num = num;
		while(num!=0){
			d = num%10;
			sum+=(d*d*d);
			num = num/10;
		}
		if(sum==cp_num){
			System.out.println("Armstrong");
		}else{
			System.out.println("Not Armstrong");
		}
	}
}