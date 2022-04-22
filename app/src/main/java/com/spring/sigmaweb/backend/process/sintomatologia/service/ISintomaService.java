package com.spring.sigmaweb.backend.process.sintomatologia.service;

import com.spring.sigmaweb.backend.process.sintomatologia.model.Sintoma;

import java.util.List;

public interface ISintomaService {
    List<Sintoma> findAll();
    Sintoma findById(Long id);
    Sintoma save(Sintoma enfermedad);
    void delete(Long id);

}
