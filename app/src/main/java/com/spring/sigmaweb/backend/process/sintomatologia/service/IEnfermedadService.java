package com.spring.sigmaweb.backend.process.sintomatologia.service;

import com.spring.sigmaweb.backend.process.sintomatologia.model.Enfermedad;

import java.util.List;

public interface IEnfermedadService {
    List<Enfermedad> findAll();
    Enfermedad findById(Long id);
    Enfermedad save(Enfermedad enfermedad);
    void delete(Long id);
}
