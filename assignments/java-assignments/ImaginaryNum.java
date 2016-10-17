public class ImaginaryNum{
	
	int real,imaginary;
	
	public ImaginaryNum()
	{
		this.real = 0;
		this.imaginary = 0;
	}
	
	public ImaginaryNum(int r,int i){
		this.real = r;
		this.imaginary = i;
	}
	
	public void add(ImaginaryNum n){
		int res_real = this.real+n.real;
		int res_imag = this.imaginary+n.imaginary;
		System.out.println(res_real+"."+res_imag);
	}
	
	public void sub(ImaginaryNum n){
		int res_real = this.real-n.real;
		int res_imag = this.imaginary-n.imaginary;
		System.out.println(res_real+"."+res_imag);
	}
	
	public void mul(ImaginaryNum n){
		int res_real = this.real*n.real;
		int res_imag = this.imaginary*n.imaginary;
		System.out.println(res_real+"."+res_imag);
	}
	
	/*public void swap(ImaginaryNum n1,ImaginaryNum n){
		ImaginaryNum temp = n;
		n = n1;
		n1 = temp;
	}*/
	
	public static void swapd(ImaginaryNum i2[]){
		ImaginaryNum temp = i2[0];
		i2[0] = i2[1];
		i2[1] = temp;
	}
	
	public void printnum()
	{
		System.out.println(this.real+"."+this.imaginary);
	}	
	public static void main(String args[])
	{
		ImaginaryNum i2[] = new ImaginaryNum[2];
		i2[0] = new ImaginaryNum(3,2);
		i2[1] = new ImaginaryNum(2,5);
		i2[0].add(i2[1]);
		i2[0].sub(i2[1]);
		i2[0].mul(i2[1]);
		//i.swap(i,i1);
		ImaginaryNum.swapd(i2);
		i2[0].printnum();
	}
}