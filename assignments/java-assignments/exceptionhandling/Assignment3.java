package exceptionhandling;

class MyClass implements AutoCloseable{

	private int id;
	private String name;
	
	public MyClass(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Auto closing");
	}
	
}

public class Assignment3 {
	
 public static void main(String args[]){
	 try(MyClass m = new MyClass(101,"Abc")){
		 //some functions
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
