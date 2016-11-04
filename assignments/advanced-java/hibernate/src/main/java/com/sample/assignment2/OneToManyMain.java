package com.sample.assignment2;

import java.io.Closeable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Market market1 = new Market("BSE");
		Stock stock1 = new Stock("ABC", 1500.00, market1);
		Stock stock2 = new Stock("DEF",12.00,market1);
		Set<Stock> stockset = new HashSet<Stock>();
		stockset.add(stock1);
		stockset.add(stock2);
		market1.setStockset(stockset);
		
		//creation
		/*Session session1 = sf.openSession();
		Transaction transaction1 = session1.beginTransaction();
		session1.save(market1);
		transaction1.commit();
		session1.close();
		sf.close();
		*/
		
		//read
		Session session2 = sf.openSession();
		Query read_query = session2.createQuery("from Market");
		List<Market> market_list = read_query.list();
		for(Market m1 : market_list)
			System.out.println(m1);
		session2.close();
		
		//Update
		Session session3 = sf.openSession();
		Transaction update_transaction = session3.beginTransaction();
		Market market2 = session3.load(Market.class, 10l);
		stockset = market2.getStockset();
		Stock stock_to_update = stockset.iterator().next();
		stock_to_update.setStock_price(1800.50);
		session3.update(market2);
		update_transaction.commit();
		session3.close();
		
		
		//Delete
		Session session4 = sf.openSession();
		Transaction delete_transaction = session4.beginTransaction();
		Query delete_query = session4.createQuery("delete from Market");
		int updates = delete_query.executeUpdate();
		System.out.println(updates+" Rows deleted");
		delete_transaction.commit();
		session4.close();
		sf.close();
		
	}

}
