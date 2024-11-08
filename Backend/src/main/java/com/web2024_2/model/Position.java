package com.web2024_2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Position {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    private Long salary;
}
