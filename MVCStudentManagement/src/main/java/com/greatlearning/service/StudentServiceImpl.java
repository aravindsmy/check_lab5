package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.StudentDAO;
import com.greatlearning.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAOimpl;

	@Override
	public List<Student> findall() {
		// TODO Auto-generated method stub
		return studentDAOimpl.findall();
	}

	@Override
	public Student findbyID(int id) {
		// TODO Auto-generated method stub
		return studentDAOimpl.findbyID(id);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDAOimpl.save(student);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		studentDAOimpl.delete(id);
	}

}
