class Employee{
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary){
		this.id=id;
		this.name = name;
		this.salary = salary;
	}
	
	public double getsalary(){
		return this.salary;
	}
}

class Manager extends Employee{
	private double incentive;
	
	public Manager(int id,String name,double salary,double incentive){
		super(id,name,salary);
		this.incentive = incentive;
	}
	
	public double getsalary()
	{
		return super.getsalary() + this.incentive;
	}
	
}

class Labour extends Employee{
	private double overtime;
	
	public Labour(int id,String name,double salary,double overtime){
		super(id,name,salary);
		this.overtime = overtime;
	}
	
	public double getsalary()
	{
		return super.getsalary() + this.overtime;
	}
}

public class OrganisationMain{
	public static void main(String args[]){
		Employee e[] = new Employee[3];
		e[0] = new Labour(101,"Abc" , 2000,300);
		e[1] = new Manager(102,"Def" , 18000,500);
		e[2] = new Labour(103,"GHI" , 5000,800);
		double res = gettotalsalary(e);
		System.out.print("Total salary: "+res);
		
	}
	
	public static double gettotalsalary(Employee e[]){
		double sum = 0;
		for(int i = 0 ;i<e.length;i++){
			sum+=e[i].getsalary();
		}
		//System.out.print("Total Salary: "+sum);
		return sum;
	}
}