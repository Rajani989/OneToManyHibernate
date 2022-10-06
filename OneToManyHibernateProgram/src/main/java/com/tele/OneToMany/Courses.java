package com.tele.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="Courses")
public class Courses {
	
	@Id
	@Column(name="Course_id")
	private int id;
	@Column(name="Course_name")
	private String name;
	
	
	
	public Courses(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	
	
}
