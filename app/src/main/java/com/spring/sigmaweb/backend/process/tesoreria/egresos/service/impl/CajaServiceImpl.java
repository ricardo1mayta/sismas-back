package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;


import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CajaRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CajaServiceImpl extends CRUDImpl<Caja,Long> implements CajaService {

    private final CajaRepository repo;

    @Override
    public List<Caja> findByIdObra(String idobra) {
        return repo.findByIdObra(idobra);
    }

    @Override
    public List<Caja> findByIdObraAndFlgEstado(String idobra, Boolean flgestado) {
        return repo.findByIdObraAndFlgEstado(idobra, flgestado);
    }

    @Override
    public Caja findByIdObraAndIdCaja(String idobra, Long idcaja) {
        return repo.findByIdObraAndIdCaja(idobra, idcaja);
    }

    @Override
    @Transactional
    public Caja save(Caja caja) {
        return repo.save(caja);
    }

    @Override
    protected IGenericRepo<Caja, Long> getRepo() {
        return null;
    }
}
