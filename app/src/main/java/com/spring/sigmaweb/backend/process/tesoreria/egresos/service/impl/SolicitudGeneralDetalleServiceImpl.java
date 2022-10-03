package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.SolicitudGeneralDetalle;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.SolicitudGeneralDetalleRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ISolicitudGeneralDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SolicitudGeneralDetalleServiceImpl extends CRUDImpl<SolicitudGeneralDetalle,Long> implements ISolicitudGeneralDetalleService {

    private final SolicitudGeneralDetalleRepository repo;

    @Override
    protected IGenericRepo<SolicitudGeneralDetalle, Long> getRepo() {
        return repo;
    }
}
