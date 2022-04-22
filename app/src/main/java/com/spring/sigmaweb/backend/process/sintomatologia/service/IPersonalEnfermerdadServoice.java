package com.spring.sigmaweb.backend.process.sintomatologia.service;

import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaEnfermedad;

import java.util.List;

public interface IPersonalEnfermerdadServoice {
    List<FichaEnfermedad> findAll();
    FichaEnfermedad findById(Long id);
    FichaEnfermedad save(FichaEnfermedad enfermedad);
    void delete(Long id);

}
