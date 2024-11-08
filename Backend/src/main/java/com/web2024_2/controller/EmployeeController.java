package com.web2024_2.controller;

import com.web2024_2.model.Employee;
import com.web2024_2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Endpoint para obtener todos los empleados
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();  // Llama al servicio para obtener todos los empleados
    }

    // Endpoint para obtener un empleado por id con su salario
    @GetMapping("/{id}")
    public Employee getEmployeeWithSalary(@PathVariable Long id) {
        return employeeService.getEmployeeWithSalary(id);  // Llama al servicio para obtener el empleado con su salario
    }

    // Endpoint para actualizar un empleado
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);

        // Si el empleado no fue encontrado, retorna un código 404
        if (updatedEmployee == null) {
            // Retorna null si el empleado no fue encontrado
            return null;
        }

        // Si el empleado fue actualizado correctamente, lo retornamos
        return updatedEmployee;
    }
 // Endpoint para asignar un departamento a un empleado
    @PostMapping("/{employeeId}/assign-department/{departmentId}")
    public Employee assignDepartmentToEmployee(@PathVariable Long employeeId, @PathVariable Long departmentId) {
        return employeeService.assignDepartmentToEmployee(employeeId, departmentId);
    }
}

