import java.util.Random;
public class LotterySystem{
	public static void main(String args[])
	{
		Random rn = new Random();
		int arr[] = new int[50];
		int usrarr[] = new int[6];
		for(int i =0 ;i<6;i++){
		 usrarr[i] = Integer.parseInt(args[i]);	
		}
		
		for(int i = 0 ;i<=49;i++){
			arr[i] = i;
		}
		
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--)
		{
		int index = rnd.nextInt(i + 1);
		// Simple swap
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
    }
		
		
		for(int i=0;i<6;i++){
		 
		 //System.out.println(arr[i]);
		 for(int j=0;j<6;j++){
			if(arr[i]==usrarr[j]){
				System.out.println(usrarr[j]);
			} 
		  }
		 }
		}
	}
	