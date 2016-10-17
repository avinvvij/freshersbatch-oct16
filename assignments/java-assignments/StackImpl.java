public class StackImpl{
	int arr[];
	int top;

	public StackImpl(){
		top = -1;
		arr = new int[50];
	}
	
	public void push(int x){
		this.top+=1;
		arr[top] = x;
	}
	
	public void pop(){
		this.top-=1;
		
	}
	
	public void print_stack()
	{
		for(int i =0;i<=this.top;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String args[]){
		StackImpl i = new StackImpl();
		i.push(1);
		i.push(7);
		i.print_stack();
		i.pop();
		i.print_stack();
	}
	
}