package com.inherit.singletable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class InheritHiberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		Vehicle v = new Vehicle("YAMAHA");
		Car c = new Car("Toyota",12.0);
		Bike b = new Bike("Suzuki", 15.0);
		SessionFactory sf = config.buildSessionFactory();
		Session session1 = sf.openSession();
		Transaction create_transaction = session1.beginTransaction();
		session1.save(v);
		session1.save(c);
		session1.save(b);
		create_transaction.commit();
		session1.close();
		sf.close();
	}

}
