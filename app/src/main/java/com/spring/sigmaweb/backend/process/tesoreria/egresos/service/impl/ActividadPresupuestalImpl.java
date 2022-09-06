package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.ActividadPresupuestal;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.ActividadPresupuestalRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IActividadPresupuestalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActividadPresupuestalImpl extends CRUDImpl<ActividadPresupuestal,Long> implements IActividadPresupuestalService {

    private final ActividadPresupuestalRepository repo;

    @Override
    protected IGenericRepo<ActividadPresupuestal, Long> getRepo() {
        return repo;
    }

}
