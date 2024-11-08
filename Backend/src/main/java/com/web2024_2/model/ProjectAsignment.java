package com.web2024_2.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity@Data
public class ProjectAsignment{
	Project project= new Project();
	Employee employee = new Employee();
	Role role= new Role();
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(unique = true)
 private Long project_id=project.getId();
 private Long employee_id=employee.getId();
 private Long role_id=role.getId();

}
 