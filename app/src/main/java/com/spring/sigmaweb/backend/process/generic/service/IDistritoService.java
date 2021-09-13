package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Distrito;

import java.util.List;
import java.util.Optional;

public interface IDistritoService {
    public List<Distrito> findByProvincia(Long idProv);

    public Optional<Distrito> findById(Long id);
}
