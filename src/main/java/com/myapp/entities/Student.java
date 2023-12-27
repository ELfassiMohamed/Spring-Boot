package com.myapp.entities;

import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
	@Id
	private Long id;
	private String name;
	private double note;
	@ManyToOne
	Groupe groupe;
}
