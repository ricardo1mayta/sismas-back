package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Asiento;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CajaRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    public Caja findByIdObraAndIdCaja(String idobra, Long idcaja) {
        return repo.findByIdObraAndIdCaja(idobra, idcaja);
    }

    @Override
    protected IGenericRepo<Caja, Long> getRepo() {
        return null;
    }
}
