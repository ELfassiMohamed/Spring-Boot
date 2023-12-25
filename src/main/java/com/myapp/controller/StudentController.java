package com.myapp.controller;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.web.bind.annotation.RestController;


import com.myapp.entities.Student;
import com.myapp.services.StudentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StudentController {
	
	@Autowired
	StudentServices ss;
	
	@GetMapping("student")
	public List<Student> getallStudent(){
		return ss.getallStudent();
	}
	
	@PostMapping("student")
	public Student addStudent(@RequestBody Student s) {
		return ss.addStudent(s);
	}
	
	@DeleteMapping("student")
	public void deleteStudent(@RequestBody Student s) {
		ss.deleteStudent(s);
	}
	
	@DeleteMapping("student/{id}")
	public void deleteStudent(@PathVariable Long id) {
		ss.deleteStudent(id);
	}
	
	@PutMapping("student")
	public Student updateStudent(@RequestBody Student s) {
		return ss.updateStudent(s);
	}

}
