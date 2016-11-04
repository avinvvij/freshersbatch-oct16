package com.sample.assignment2;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		//creation
		Session s1 = sf.openSession();
		Transaction t = s1.beginTransaction();
		Customer c = new Customer("ABC");
		Enquiry e = new Enquiry("No Water", c);
		s1.persist(e);
		t.commit();
		s1.close();
		
		
		//read
		Session s2 = sf.openSession();
		Query q = s2.createQuery("from Enquiry");
		List<Enquiry> elist = q.list();
		for(Enquiry e1: elist){
			System.out.println(e1);
		}
		s2.close();
		
		//Update
		Session s3 = sf.openSession();
		Transaction t2 = s3.beginTransaction();
		Enquiry ee = s3.load(Enquiry.class, 6l);
		ee.setEnq_message("No water in mumbai");
		s3.update(ee);
		t2.commit();
		s3.close();
		
		
		//Delete
		Session s4 = sf.openSession();
		Transaction t3 = s4.beginTransaction();
		Query del_query = s4.createQuery("delete from Enquiry");
		int updates = del_query.executeUpdate();
		System.out.println(updates+" Rows deleted");
		t3.commit();
		s4.close();
		sf.close();
	}

}
