package com.web2024_2.service;

import com.web2024_2.model.Position;
import com.web2024_2.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    // Método para buscar una posición por ID
    public Position getPositionById(Long id) {
        Optional<Position> position = positionRepository.findById(id);  // Busca la posición por ID

        // Si la posición no existe, puedes lanzar una excepción personalizada o devolver null
        return position.orElse(null);  // Retorna null si no se encuentra la posición
    }
}
