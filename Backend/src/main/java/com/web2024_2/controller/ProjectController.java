package com.web2024_2.controller;

import com.web2024_2.model.Project;
import com.web2024_2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Endpoint para crear un nuevo proyecto
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);  // Llama al servicio para crear el proyecto
    }
}
