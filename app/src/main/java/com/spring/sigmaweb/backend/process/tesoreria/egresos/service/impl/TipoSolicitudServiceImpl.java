package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TipoSolicitud;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.TipoSolicitudRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ITipoSolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TipoSolicitudServiceImpl extends CRUDImpl<TipoSolicitud,Long> implements ITipoSolicitudService {

    private final TipoSolicitudRepository repo;

    @Override
    protected IGenericRepo<TipoSolicitud, Long> getRepo() {
        return repo;
    }
}
