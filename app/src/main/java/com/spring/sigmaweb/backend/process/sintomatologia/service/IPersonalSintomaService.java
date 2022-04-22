package com.spring.sigmaweb.backend.process.sintomatologia.service;

import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaSintoma;

import java.util.List;

public interface IPersonalSintomaService {
    List<FichaSintoma> findAll();
    FichaSintoma findById(Long id);
    FichaSintoma save(FichaSintoma enfermedad);
    void delete(Long id);

}
