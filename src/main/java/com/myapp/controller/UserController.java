package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entities.User;
import com.myapp.services.UserServices;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserServices us;
	
	@GetMapping("getAll")
	public List<User> getAllUsers(){
		return us.getAllUsers();
	}
	
	@GetMapping("get/{id}")
	public User getUserById(@PathVariable Long id) {
		return us.getUserById(id);
	}
	
	@PostMapping("add")
	public User addUser(@RequestBody User user) {
		return us.addUser(user);
	}
}
