package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Departamento;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    public List<Departamento> findAll();
    public Optional<Departamento> findById(Long id);
}
