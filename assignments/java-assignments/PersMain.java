abstract class Persistence{
	abstract void persist();
}

class FilePersistence extends Persistence{
	void persist(){
		System.out.println("File Persisted");
	}
}

class DatabasePersistence extends Persistence{
	void persist(){
		System.out.println("Database Persisted");
	}
}

class PersistFactory{
	public static Persistence getpers(){
		return new DatabasePersistence();
	}
}

public class PersMain{
	
	public static void main(String args[]){
		Persistence p = PersistFactory.getpers();
		p.persist();
	}
}