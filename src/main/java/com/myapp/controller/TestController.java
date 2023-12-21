package com.myapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entities.Student;
import com.myapp.entities.beans;
import com.myapp.entities.object;

@RestController
public class TestController {
 
	@PostMapping("MyStudent")
	public Student getStudent(@RequestBody Student s) {
		return s;
	}
	
//	@PostMapping("MyObject")
//	public beans getObject(@RequestBody beans object) {
//		return object;
//	}
	
	@PostMapping("MyBeans")
	public String getData(@RequestBody beans bbb) {
		return "beans id : " +bbb.getId()+ "tag : "+bbb.getTag();
	}
	
	@PostMapping("MyObject")
	public object getObject(@RequestBody object obt) {
		obt.setId(26895);
		obt.setTag("messahe from controller");
		return obt;
	}
	
	@PostMapping("Object")
	public String getobject(@RequestBody object obt) {
		return "id :"+obt.getId()+" tag:"+obt.getTag();
	}
}
