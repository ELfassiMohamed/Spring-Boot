package com.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myapp.dao.UserRepository;
import com.myapp.entities.User;

@Service
public class UserServices {
	
	@Autowired
	UserRepository user_rep;
	
	public List<User> getAllUsers(){
		return user_rep.findAll();
	}
	
	public User getUserById(Long id) {
		return user_rep.findById(id).get();
	}
	
	public User addUser(User user) {
		return user_rep.save(user);
	}
}
