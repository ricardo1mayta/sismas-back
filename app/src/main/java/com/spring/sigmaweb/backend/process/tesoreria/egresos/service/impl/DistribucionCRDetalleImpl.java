package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacionDetalle;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.DistribucionCRDetalleRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DistribucionCRDetalleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DistribucionCRDetalleImpl extends CRUDImpl<DistribucionPonderacionDetalle,Long > implements DistribucionCRDetalleService {

    private final DistribucionCRDetalleRepository repo;


    @Override
    protected IGenericRepo<DistribucionPonderacionDetalle, Long> getRepo() {
        return repo;
    }

}
