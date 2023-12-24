package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.myapp.dao.StudentRepository;
import com.myapp.entities.Student;

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
	StudentRepository sr;
	
	@GetMapping("student")
	public List<Student> getallStudent(){
		return sr.findAll();
	}
	
	@PostMapping("student")
	public Student addStudent(@RequestBody Student s) {
		return sr.save(s);
	}
	
	@DeleteMapping("student")
	public void deleteStudent(@RequestBody Student s) {
		sr.delete(s);
	}
	
	@DeleteMapping("student/{id}")
	public void deleteStudent(@PathVariable Long id) {
		sr.deleteById(id);
	}
	
	@PutMapping("student")
	public Student updateStudent(@RequestBody Student s) {
		return sr.save(s);
	}

}
