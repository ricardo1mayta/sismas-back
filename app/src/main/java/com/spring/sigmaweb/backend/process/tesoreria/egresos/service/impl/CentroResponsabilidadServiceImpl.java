package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CentroResponsabilidad;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CentroResponsabilidadRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ICentroResponsabilidadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CentroResponsabilidadServiceImpl extends CRUDImpl<CentroResponsabilidad, Long> implements ICentroResponsabilidadService {

    private final CentroResponsabilidadRepository repo;

    @Override
    protected IGenericRepo<CentroResponsabilidad, Long> getRepo() {
        return repo;
    }

    @Override
    public List<CentroResponsabilidad> listarPorOPbraCR(Integer tipo) {
        return repo.listarPorOPbraCR(tipo);
    }


}
