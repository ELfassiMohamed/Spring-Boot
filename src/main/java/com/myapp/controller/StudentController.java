package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.myapp.entities.Student;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class StudentController {
	
	List<Student> students = new ArrayList<>();
	
	@GetMapping("student")
	public List<Student> getallStudent(){
		return this.students;
	}
	
	@PostMapping("student")
	public Student addStudent(@RequestBody Student s) {
		this.students.add(s);
		return s;
	}
	
	@DeleteMapping("student")
	public void deleteStudent(@RequestBody Student s) {
		this.students.remove(s);
	}
	
	@DeleteMapping("student/{id}")
	public void deleteStudent(@PathVariable Long id) {
		this.students.removeIf(e->(e.getId()==id));
	}

}
