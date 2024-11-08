package com.web2024_2.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    private String description;
    
    private LocalDate start_date;
    
    private LocalDate end_date;
}
