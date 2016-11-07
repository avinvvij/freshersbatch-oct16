package com.hbcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session session1 = sf.openSession();
		Transaction cr_transaction = session1.beginTransaction();
		MyEmployee e1 = new MyEmployee("Abc", 1400.0);
		session1.persist(e1);
		MyEmployee e2 = session1.get(MyEmployee.class, e1.getId());
		MyEmployee e3 = session1.get(MyEmployee.class, e1.getId());
		cr_transaction.commit();
		session1.close();
		
		Session session2 = sf.openSession();
		MyEmployee e4 = session2.get(MyEmployee.class, e1.getId());
		session2.close();
		
		sf.close();
		
		
		
	}

}
