package com.spring.sigmaweb.backend.process.sintomatologia.service;

import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaSintomatologica;

import java.util.List;

public interface IPersonalSintomatologiaService {
    List<FichaSintomatologica> findAll();
    FichaSintomatologica findById(Long id);
    FichaSintomatologica save(FichaSintomatologica enfermedad);
    void delete(Long id);
}
