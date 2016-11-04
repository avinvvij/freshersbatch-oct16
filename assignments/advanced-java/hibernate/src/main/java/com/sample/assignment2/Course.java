package com.sample.assignment2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_master")
public class Course {
	
	public Course(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String course_name;
	
	@ManyToMany(cascade={CascadeType.ALL} , mappedBy="courseset")
	private Set<Student> studentset = new HashSet<Student>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Set<Student> getStudentset() {
		return studentset;
	}

	public void setStudentset(Set<Student> studentset) {
		this.studentset = studentset;
	}
	
	
	public String toString(){
		return this.course_name+" students enrolled: ";
	}
	
}
