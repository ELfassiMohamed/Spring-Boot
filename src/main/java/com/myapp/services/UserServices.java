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
	
	public User getUserById(Long id) {
	User user = user_rep.findById(id)
	.orElseThrow(() -> new UserNotFoundException("USER WITH ID : \"+id+\" NOT FOUND"));
    return user;
	}

	public User addUser(User user) {
		return user_rep.save(user);
	}
	
	public User updateUser(User newuser , Long id) {
		return user_rep.findById(id).map(user ->{
			user.setName(newuser.getName());
			user.setEmail(newuser.getEmail());
			user.setPassword(newuser.getPassword());
			return user_rep.save(user);
		}).orElseThrow(() -> new UserNotFoundException("USER WITH ID : "+id+" NOT FOUND"));
	}
	
	public String deleteuser(Long id) {
		if(!user_rep.existsById(id)) {
			return "User with id : "+id+" Not Found";
		}
		user_rep.deleteById(id);
		return "User Deleted";
	}
}
