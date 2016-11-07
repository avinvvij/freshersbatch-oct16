package com.sample.assignment2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_master")
public class Student {
	
	public Student(){
		
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(
			name="student_course",
			joinColumns = {@JoinColumn(name="student_id")},
			inverseJoinColumns = {@JoinColumn(name = "course_id")}
			)
	private Set<Course> courseset = new HashSet<Course>();


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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Set<Course> getCourseset() {
		return courseset;
	}


	public void setCourseset(Set<Course> courseset) {
		this.courseset = courseset;
	}
	
	
	
	public String toString(){
		return this.name+" "+this.gender+" courses enrolled: "+this.courseset;
	}
	
}
