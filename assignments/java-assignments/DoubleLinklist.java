public class DoubleLinklist{

	int data;
	DoubleLinklist next;
	DoubleLinklist prev;

	public DoubleLinklist()
	{
		this.next = null;
		this.prev = null;
		this.data = 0;
	}
	
	public void add_head(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public void add_node(DoubleLinklist d,int data){
		DoubleLinklist temp = this;
		while(temp.next!=null){
			temp = temp.next;
		}
		d.data = data;
		temp.next = d;
		d.prev = temp;
	}
	
	public void insert_node(DoubleLinklist d,int data,int index){
		DoubleLinklist temp = this;
		for(int i=1;i<index;i++){
			temp = temp.next;
		}
		d.data = data;
		d.next = temp.next;
		temp.next.prev = d;
		temp.next = d;
		d.prev = temp;
		
		
	}
	
	public void delete_node(int index){
		DoubleLinklist temp = this;
		for(int i=0;i<index && temp.next!=null;i++){
			temp = temp.next;
		}
		if(temp.next!=null){
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		}else{
			temp.prev.next = null;
		}
		/*
		d.data = data;
		d.next = temp.next;
		temp.next.prev = d;
		temp.next = d;
		d.prev = temp;*/
	}
	
	
	public void count()
	{
		int count = 1;
		DoubleLinklist temp = this;
		while(temp.next!=null){
			//System.out.print(temp.data+" ");
			count++;
			temp = temp.next;
		}
		System.out.println("count="+count);
	}
	
	public void print()
	{
		DoubleLinklist temp = this;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	
	public static void main(String args[]){
		DoubleLinklist head = new DoubleLinklist();
		head.add_head(1);
		DoubleLinklist d1 = new DoubleLinklist();
		head.add_node(d1,2);
		head.count();
		head.print();
		DoubleLinklist d2 = new DoubleLinklist();
		head.insert_node(d2,5,1);
		d2 = new DoubleLinklist();
		head.insert_node(d2,7,2);
		head.count();
		head.print();
		head.delete_node(1);
		head.count();
		head.print();
		
	}
	
}