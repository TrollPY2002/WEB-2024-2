package com.web2024_2.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String first_name;
    
    @Column(nullable = false)
    private String last_name;
    
    private LocalDate birthdate;
    
    @ManyToOne
    @JoinColumn(name = "dep_id", nullable = false)
    private Department department;  // Relación con Departamento
    
    @ManyToOne
    @JoinColumn(name = "pos_id", nullable = false)
    private Position position;  // Relación con Posición
    
    private LocalDate entry_date;
}





