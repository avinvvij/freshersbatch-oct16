public class QueueImpl{
	
	int arr[];
	int start,end;
	
	public QueueImpl()
	{
		start = 0;
		end = 0;
		arr = new int[50];	
	}
	
	public void push(int x)
	{
		this.end+=1;
		for(int i = end-1;i>=0 ;i--){
			arr[i+1] = arr[i];
		}
		arr[start]=x;
	}
	
	public void pop(){
		this.end-=1;
	}
	
	public void print_queue(){
		for(int i=0;i<end;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String args[]){
		QueueImpl q = new QueueImpl();
		q.push(1);
		q.push(7);
		q.push(9);
		q.print_queue();
		q.pop();
		q.print_queue();
	}
}