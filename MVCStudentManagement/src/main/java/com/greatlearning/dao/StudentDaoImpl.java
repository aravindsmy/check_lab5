package com.greatlearning.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public StudentDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;

		try {
			session = sessionFactory.getCurrentSession();

		} catch (HibernateException e) {
			// TODO: handle exception
			session = sessionFactory.openSession();
		}
	}

	@Override
	public List<Student> findall() {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

	@Override
	public Student findbyID(int id) {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		transaction.commit();
		return student;
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		transaction.commit();
	}

}
