package com.sample.hibernate.HibernateExample;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session s1 = sf.openSession();
		//Query q = s1.createQuery("SELECT sum(salary) FROM Employee");
		Query q = s1.getNamedQuery("getsalarysum");
		List<Object> result = q.list();
		for(Object o : result){
			System.out.println(o.toString());
		}
		s1.close();
		
		Session s2 = sf.openSession();
		//Query q1 = s2.createQuery("SELECT avg(salary) FROM Employee");
		Query q1 = s2.getNamedQuery("getavgsalary");
		List<Object> res = q1.list();
		for(Object o : res){
			System.out.println(o.toString());
		}
		s2.close();
		
		Session s3 = sf.openSession();
		Query q2 = s3.createQuery("from Employee ORDER BY salary DESC");
		List<Employee> result1 = q2.list();
		for(Employee e : result1){
			System.out.println(e.toString());
		}
		Criteria c = s3.createCriteria(Employee.class);
		c.addOrder(Order.desc("salary"));
		result1 = c.list();
		for(Employee e : result1){
			System.out.println(e.toString());
		}
		
		s3.close();
		
		
		Session s4 = sf.openSession();
		Query q3 = s4.createQuery("select sum(E1.salary) , E1.city from Employee as E1 GROUP BY E1.city");
		q3.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List<Map> sumlist = q3.list();
		for(Map d : sumlist){
			System.out.println(d);
		}
		s4.flush();
		s4.close();
		
		s4 = sf.openSession();
		Criteria c1 = s4.createCriteria(Employee.class);
		c1.setProjection(Projections.projectionList().
				add(Projections.sum("salary").as("salarysum"))
				.add(Projections.groupProperty("city"))
				);
		c1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		sumlist = c1.list();
		for(Map d : sumlist){
			System.out.println(d);
		}
		
		s4.close();
		
		
		Session s5 = sf.openSession();
		Query q4 = s5.createQuery("from Employee where salary>10000");
		List<Employee> result2 = q4.list();
		for(Employee e : result2){
			System.out.println(e);
		}
		s5.close();
		
		s5 = sf.openSession();
		Criteria c2 = s5.createCriteria(Employee.class);
		c2.add(Restrictions.gt("salary", 10000.0));
		result2 = c2.list();
		for(Employee e : result2){
			System.out.println(e);
		}
		s5.close();
		sf.close();
	}

}
