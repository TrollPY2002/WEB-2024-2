package com.web2024_2.service;

import com.web2024_2.model.Project;
import com.web2024_2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Método para crear un nuevo proyecto
    public Project createProject(Project project) {
        // Aquí puedes agregar lógica adicional si es necesario (validaciones, etc.)
        return projectRepository.save(project);  // Guarda el proyecto en la base de datos y lo devuelve
    }
}
