package com.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entities.Student;

@RestController
public class Test {
	
	@GetMapping("message")
	public String message(){
		return "Hello From Test Class";
	}
	
	@GetMapping("notifyme")
	public String notifyme(){
		return "Hello From notify method";
	}
	
	
	@RequestMapping(value = "/example", method = RequestMethod.POST, produces = "application/json")
	public Student getStudent(@RequestBody Student s) {
		return s;
	}

}
