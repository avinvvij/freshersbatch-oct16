 class Dateabc{
	
	int day,month,year;
	
	public Dateabc(){
		day = 26;
		month = 6;
		year = 1994;
	}
	
	public Dateabc(int day,int month,int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getday(){
		return this.day;
	}
	
	public int getmonth(){
		return this.month;
	}
	
	public int getyear(){
		return this.year;
	}
	
	
	public void setyear(int year){
		this.year = year;
	}
	
	
	public void setmonth(int month){
		this.month = month;
	}
	
	public void setday(int day){
		this.day = day;
	}
	
	public void print_date(){
		System.out.println(this.day+"/"+this.month+"/"+this.year);
	}
	
	public void swap_date(Dateabc datobj)
	{
			
	}
	
	public static void main(String args[]){
		Dateabc d = new Dateabc();
		d.print_date();
		Dateabc d1 = new Dateabc(5,10,2004);
		d1.print_date();
		d.swap_date(d1);
	}
	
}