package com.myapp.entities;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
Long id;
String name;
double note;
}
