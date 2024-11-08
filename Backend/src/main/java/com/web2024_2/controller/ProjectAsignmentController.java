package com.web2024_2.controller;

import com.web2024_2.model.ProjectAsignment;
import com.web2024_2.service.ProjectAsignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project-assignments")
public class ProjectAsignmentController {

    @Autowired
    private ProjectAsignmentService projectAsignmentService;

    // Endpoint para asignar un empleado a un proyecto con un rol específico
    @PostMapping
    public ProjectAsignment assignEmployeeToProject(@RequestParam Long projectId,
                                                     @RequestParam Long employeeId,
                                                     @RequestParam Long roleId) {
        // Llama al servicio para asignar el empleado al proyecto con el rol
        return projectAsignmentService.assignEmployeeToProject(projectId, employeeId, roleId);
    }
}
