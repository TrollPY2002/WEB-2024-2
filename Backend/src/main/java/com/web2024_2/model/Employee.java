package com.web2024_2.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity@Data
public class Employee {
	Department department= new Department();
	Position position=new Position();
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(unique = true)
 private String first_name;
 private String last_name;
 private LocalDate birthdate;
 private Long dep_id=department.getId();
 private Long pos_id=position.getId();
 private LocalDate entry_date;
 
 



}

