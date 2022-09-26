package com.greatlearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String dept;
	private String country;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param dept
	 * @param country
	 */
	public Student(String name, String dept, String country) {
		super();
		this.name = name;
		this.dept = dept;
		this.country = country;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", department=" + dept + ", country=" + country + "]";
	}

}
