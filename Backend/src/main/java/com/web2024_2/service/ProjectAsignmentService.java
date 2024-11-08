package com.web2024_2.service;

import com.web2024_2.model.Employee;
import com.web2024_2.model.Project;
import com.web2024_2.model.Role;
import com.web2024_2.model.ProjectAsignment;
import com.web2024_2.repository.EmployeeRepository;
import com.web2024_2.repository.ProjectRepository;
import com.web2024_2.repository.RoleRepository;
import com.web2024_2.repository.ProjectAsignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectAsignmentService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProjectAsignmentRepository projectAssignmentRepository;

    // Método para agregar un empleado a un proyecto con un rol específico
    public ProjectAsignment assignEmployeeToProject(Long projectId, Long employeeId, Long roleId) {
        // Buscar el proyecto por ID
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project == null) {
            return null;  // Si no se encuentra el proyecto, retorna null
        }

        // Buscar el empleado por ID
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            return null;  // Si no se encuentra el empleado, retorna null
        }

        // Buscar el rol por ID
        Role role = roleRepository.findById(roleId).orElse(null);
        if (role == null) {
            return null;  // Si no se encuentra el rol, retorna null
        }

        // Crear una nueva asignación de proyecto
        ProjectAsignment projectAssignment = new ProjectAsignment();
        projectAssignment.setProject(project);
        projectAssignment.setEmployee(employee);
        projectAssignment.setRole(role);

        // Guardar la asignación en la base de datos
        return projectAssignmentRepository.save(projectAssignment);
    }
}

