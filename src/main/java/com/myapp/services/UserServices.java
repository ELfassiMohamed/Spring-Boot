package com.myapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myapp.dao.UserRepository;
import com.myapp.entities.User;
import com.myapp.exception.UserNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	UserRepository user_rep;
	
	public List<User> getAllUsers(){
		return user_rep.findAll();
	}
	
	//public User getUserById(Long id) {
	//	return user_rep.findById(id).get();
	//}
	
	public User getUserById(Long id) {
		return user_rep.findById(id).get();
		
	}
	
	public User addUser(User user) {
		return user_rep.save(user);
	}
	
	public User updateUser(User user) {
		return user_rep.save(user);
	}
	
	public void deleteuser(Long id) {
		user_rep.deleteById(id);
	}
}
