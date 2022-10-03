package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TipoConcepto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.TipoConceptoRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ITipoConceptoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoConceptoServiceImpl extends CRUDImpl<TipoConcepto, Long > implements ITipoConceptoService {

    private final TipoConceptoRepository repo;

    @Override
    protected IGenericRepo<TipoConcepto, Long> getRepo() {
        return repo;
    }
}
