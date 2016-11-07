package com.sample.hibernate.HibernateExample;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernatemain {

	public static void insertSql(SessionFactory sf){
		Session s = sf.openSession();
		String sqlquery = "INSERT INTO PRODUCT_MASTER(P_ID,NAME,COST) VALUES(12,'MICROMAX',15000)";
		Transaction t = s.beginTransaction();
		SQLQuery squery = s.createSQLQuery(sqlquery);
		squery.executeUpdate();
		t.commit();
		s.close();
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		
		//create a product
		Session s1 = sf.openSession();
		Product p = new Product("Nokia", 10000);
		Transaction t = s1.beginTransaction();
		Long product_id = p.getId();
		s1.save(p);
		t.commit();
		s1.close();
		
		
		//insertSql(sf);
		
		//read all products
		Session s2 = sf.openSession();
		Query query = s2.createQuery("from Product");
		List<Product> plist = query.list();
		for(Product p_1 : plist){
			System.out.println(p_1);
		}
		s2.close();
		
		//update a product
		/*Session s3 = sf.openSession();
		Transaction t1 = s3.beginTransaction();
		Product product_to_update = s3.load(Product.class,16l);
		product_to_update.setName("Samsung");
		t1.commit();
		s3.flush();
		s3.close();
		*/
		
		//read all products
		Session s4 = sf.openSession();
		Query query1 = s4.createQuery("from Product");
		List<Product> plist1 = query1.list();
		for(Product p_1 : plist1){
			System.out.println(p_1);
		}
		s4.close();

		
		//delete all products
		/*Session s5 = sf.openSession();
		Query delete_query = s5.createQuery("delete from Product where id = "+15l);
		int updates = delete_query.executeUpdate();
		System.out.println("Number of updates: "+updates);*/
				
		sf.close();
	}
	

}
