package com.myapp.controller;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.web.bind.annotation.RestController;


import com.myapp.entities.Student;
import com.myapp.services.StudentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentServices ss;
	
	@GetMapping("show")
	public List<Student> getallStudent(){
		return ss.getallStudent();
	}
	
	@PostMapping("insert")
	public Student addStudent(@RequestBody Student s) {
		return ss.addStudent(s);
	}
	
	@DeleteMapping("delete")
	public void deleteStudent(@RequestBody Student s) {
		ss.deleteStudent(s);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteStudent(@PathVariable Long id) {
		ss.deleteStudent(id);
	}
	
	@PutMapping("update")
	public Student updateStudent(@RequestBody Student s) {
		return ss.updateStudent(s);
	}

}
