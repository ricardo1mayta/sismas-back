package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Detraccion;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.DetraccionRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DetraccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetraccionServiceImp extends  CRUDImpl<Detraccion,Long > implements DetraccionService {

    private final DetraccionRepository repo;

    @Override
    protected IGenericRepo<Detraccion, Long> getRepo() {
        return repo;
    }

    @Override
    public List<Detraccion> listarPorIdObra(String idObra) {
        return repo.findByidObra(idObra);
    }
}
