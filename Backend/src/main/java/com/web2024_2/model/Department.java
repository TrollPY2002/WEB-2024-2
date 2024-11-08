package com.web2024_2.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity@Data
public class Department{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(unique = true)
 private String name;
 private Long chief_id;
}
