package com.web2024_2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;  // Relación con Departamento
    
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;  // Relación con Empleado
}
