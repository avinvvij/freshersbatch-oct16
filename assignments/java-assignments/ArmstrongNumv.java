public class ArmstrongNumv{
	public static void main(String args[])
	{
		
		//int num = Integer.parseInt(args[0]);
		for(int cp_num = 100 ;cp_num<=999 ;cp_num++)
		{
		int sum=0;
		int d;
		int num = cp_num;
		while(num!=0){
			d = num%10;
			sum+=(d*d*d);
			num = num/10;
		}
		if(sum==cp_num){
			System.out.println(cp_num);
		}
	}
	}
}