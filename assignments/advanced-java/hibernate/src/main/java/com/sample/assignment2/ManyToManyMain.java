package com.sample.assignment2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		
		Course course1 = new Course();
		Course course2 = new Course();
		Course course3 = new Course();
		course1.setCourse_name("maths");
		course2.setCourse_name("science");
		course3.setCourse_name("english");
		
		
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setGender("Male");
		student1.setName("ABC");
		student2.setGender("FeMale");
		student2.setName("DEF");
		
		
		student1.getCourseset().add(course1);
		student1.getCourseset().add(course2);
	
		student2.getCourseset().add(course3);
		
		course1.getStudentset().add(student1);
		course2.getStudentset().add(student1);
		course3.getStudentset().add(student2);
		
		//creation
		
		/*Session session1 = sf.openSession();
		Transaction create_transaction = session1.beginTransaction();
		session1.save(student1);
		session1.save(student2);
		create_transaction.commit();
		session1.close();
		*/
		
		//read
		Session s2 = sf.openSession();
		Query read_query = s2.createQuery("from Student");
		List<Student> studlist = read_query.list();
		for(Student s: studlist){
			System.out.println(s);
		}
		s2.close();
		
		
		//update
		Session s3 = sf.openSession();
		
		s3.close();
		
		
		//delete
		
		sf.close();
		
	}

}
