package com.myapp.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.dao.GroupeRepository;
import com.myapp.dao.StudentRepository;
import com.myapp.entities.Groupe;
import com.myapp.entities.Student;

@Service
public class GroupeServices {

	@Autowired
	GroupeRepository gr;
	
	@Autowired
	StudentRepository sr;
	
	public List<Groupe> showGroupe(){
		return gr.findAll();
	}
	
	public Groupe getGroupeById(Long id){
		return gr.findById(id).get();
	}
	
	public Groupe insertGroupe(Groupe grp) {
		return gr.save(grp);
	}
	
	public List<Student> getStudentByGroupeId(Long id) {
		Groupe g=gr.findById(id).get();
		return sr.findByGroupe(g);
	}
	

	public Student addStudentToGroupe(Long id , Student s) {
		Groupe g=gr.findById(id).get();
		s.setGroupe(g);
		return sr.save(s);
	}
	

	public void deleteGroupeById(Long id) {
		List<Student> students=getStudentByGroupeId(id);
		students.forEach(s->{
			s.setGroupe(null);
		});
		gr.deleteById(id);
	}
}
