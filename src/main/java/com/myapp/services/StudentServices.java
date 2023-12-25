package com.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.dao.StudentRepository;
import com.myapp.entities.Student;

@Service
public class StudentServices {
	@Autowired
	StudentRepository sr;
	
	public List<Student> getallStudent(){
		return sr.findAll();
	}
	
	public Student addStudent(Student s) {
		return sr.save(s);
	}
	
	public void deleteStudent(Student s) {
		sr.delete(s);
	}
	
	public void deleteStudent(Long id) {
		sr.deleteById(id);
	}
	
	public Student updateStudent(Student s) {
		return sr.save(s);
	}
}
