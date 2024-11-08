package com.web2024_2.service;

import com.web2024_2.model.Employee;
import com.web2024_2.model.Department;
import com.web2024_2.model.Position;
import com.web2024_2.repository.EmployeeRepository;
import com.web2024_2.repository.DepartmentRepository;
import com.web2024_2.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PositionRepository positionRepository;

    // Método para obtener todos los empleados
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Método para obtener un empleado por id, incluyendo su salario
    public Employee getEmployeeWithSalary(Long id) {
        // Buscar el empleado por su id
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        // Verifica si el empleado existe
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Position position = employee.getPosition(); // Obtiene la posición asociada

            // Incluye el salario del empleado
            if (position != null) {
                // Asignamos el salario a un campo temporal o de uso directo
                employee.setSalary(position.getSalary());
            }

            return employee;
        }

        // Si el empleado no existe, retorna null
        return null;
    }

    // Método para actualizar un empleado
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        // Verifica si el empleado existe
        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();

            // Actualiza los campos del empleado con los detalles proporcionados
            existingEmployee.setFirst_name(employeeDetails.getFirst_name());
            existingEmployee.setLast_name(employeeDetails.getLast_name());
            existingEmployee.setBirthdate(employeeDetails.getBirthdate());
            existingEmployee.setEntry_date(employeeDetails.getEntry_date());

            // Buscar el Departamento y la Posición usando sus respectivos IDs
            Department department = departmentRepository.findById(employeeDetails.getDepartment().getId())
                    .orElse(null);  // Retorna null si no se encuentra el departamento
            Position position = positionRepository.findById(employeeDetails.getPosition().getId())
                    .orElse(null);  // Retorna null si no se encuentra la posición

            // Asigna los objetos Department y Position al empleado si se encuentran
            if (department != null) {
                existingEmployee.setDepartment(department);
            }
            if (position != null) {
                existingEmployee.setPosition(position);
            }

            // Guarda el empleado actualizado
            return employeeRepository.save(existingEmployee);
        }

        // Si el empleado no se encuentra, retorna null
        return null;
    }
 // Método para asignar un departamento a un empleado
    public Employee assignDepartmentToEmployee(Long employeeId, Long departmentId) {
        // Buscar el empleado por su ID
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (!employeeOptional.isPresent()) {
            return null;  // Si el empleado no se encuentra, retorna null
        }

        Employee employee = employeeOptional.get();

        // Buscar el departamento por su ID
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if (!departmentOptional.isPresent()) {
            return null;  // Si el departamento no se encuentra, retorna null
        }

        Department department = departmentOptional.get();

        // Asignar el departamento al empleado
        employee.setDepartment(department);

        // Guardar el empleado con el nuevo departamento
        return employeeRepository.save(employee);
    }
}

