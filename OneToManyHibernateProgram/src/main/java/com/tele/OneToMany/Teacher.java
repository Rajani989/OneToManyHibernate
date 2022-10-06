package com.tele.OneToMany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="Teacher")

public class Teacher {
	
	@Id
	@PrimaryKeyJoinColumn
	@Column(name="Teacher_id")
	private int id;
	@Column(name="Teacher_name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	List<Courses> courses=new ArrayList<Courses>();
	
	
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

}
