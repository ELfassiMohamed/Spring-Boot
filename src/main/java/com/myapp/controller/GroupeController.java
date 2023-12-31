package com.myapp.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entities.Groupe;
import com.myapp.entities.Student;
import com.myapp.services.GroupeServices;

@RestController
@RequestMapping("groupe")
public class GroupeController {
	@Autowired
	GroupeServices gs;
	
	@GetMapping("getAll")
	public List<Groupe> showGroupe(){
		return gs.showGroupe();
	}
	
	@GetMapping("get/{id}")
	public Groupe getGroupeById(@PathVariable Long id){
		return gs.getGroupeById(id);
	}
	
	@PostMapping("insert")
	public Groupe insertGroupe(@RequestBody Groupe grp) {
		return gs.insertGroupe(grp);
	}
	
	@GetMapping("{id}/student")
	public List<Student> getStudentByGroupeId(@PathVariable Long id) {
		return gs.getStudentByGroupeId(id);
	}
	
	@PostMapping("{id}/student")
	public Student addStudentToGroupe(@PathVariable Long id ,@RequestBody Student s) {
		return gs.addStudentToGroupe(id, s);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteGroupeById(@PathVariable Long id) {
		gs.deleteGroupeById(id);
	}
}
