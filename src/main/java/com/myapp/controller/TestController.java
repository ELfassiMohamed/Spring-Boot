package com.myapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entities.Student;

@RestController
public class TestController {
 
	@PostMapping("MonStudent")
	public Student getStudent(@RequestBody Student s) {
		return s;
	}
}
