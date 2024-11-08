package com.web2024_2.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class ProjectAsignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;  // Relación con el Proyecto
    
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;  // Relación con el Empleado
    
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;  // Relación con el Rol
}
