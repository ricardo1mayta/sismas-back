package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Obra;

import java.util.List;
import java.util.Optional;

public interface IObraService {
    public List<Obra> findAll();
    public Optional<Obra> findById(String id);
}
