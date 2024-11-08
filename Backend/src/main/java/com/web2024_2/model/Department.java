package com.web2024_2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;  // Relación bidireccional con la entidad Employee

    @OneToMany(mappedBy = "department")
    private List<Visit> visits;  // Relación bidireccional con la entidad Visit
}

