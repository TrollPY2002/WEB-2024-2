package com.web2024_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web2024_2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}