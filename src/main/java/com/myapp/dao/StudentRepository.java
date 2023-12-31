package com.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entities.Groupe;
import com.myapp.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
List<Student> findByGroupe(Groupe g);
}
