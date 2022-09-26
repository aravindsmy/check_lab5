package com.greatlearning.dao;

import java.util.List;

import com.greatlearning.entity.Student;



public interface StudentDAO {

	public List<Student> findall();
	public Student findbyID(int id);
	
	public void save(Student student);
	public void delete(int id);
	
}
