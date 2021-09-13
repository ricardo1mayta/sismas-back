package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Provincia;

import java.util.List;
import java.util.Optional;

public interface IProvinciaService {
    public List<Provincia> findByDepartamento(Long idDepa);

    public Optional<Provincia> findById(Long id);
}
