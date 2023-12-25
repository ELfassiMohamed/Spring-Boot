package com.myapp.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Groupe {
	@Id
	private Long id;
	private String name;
	@OneToMany(mappedBy = "groupe")
	@JsonIgnore
	List<Student> students;
}
