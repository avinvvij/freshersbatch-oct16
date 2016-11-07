package com.sample.hibernate.HibernateExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
		 @NamedQuery(
				 name = "getsalarysum", query = "SELECT sum(salary) FROM Employee"
				 ),
		 @NamedQuery(
				 name = "getavgsalary",
				 query = "SELECT avg(salary) FROM Employee"
				 )
})


@Entity
@Table(name = "employee_master")
public class Employee {

	
	
	public Employee(){
		
	}
	public Employee(String name , Double salary){
		this.name = name;
		this.salary = salary;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name="ename")
	private String name;
	
	@Column(name = "esal")
	private Double salary;
	
	@Column(name="city")
	private String city;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	public String toString(){
		return this.id+" "+this.name+" "+this.salary+" "+this.city;
	}
	
	
}
