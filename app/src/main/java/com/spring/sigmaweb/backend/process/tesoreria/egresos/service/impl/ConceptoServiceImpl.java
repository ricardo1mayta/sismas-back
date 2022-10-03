package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Concepto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.ConceptoRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IConceptoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConceptoServiceImpl extends CRUDImpl<Concepto,Long> implements  IConceptoService{

    private final ConceptoRepository repo;

    @Override
    protected IGenericRepo<Concepto, Long> getRepo() {
        return repo;
    }

    @Override
    public List<Concepto> listarPorTipoConcepto(Long id) {
        return repo.listarPorTipoConcepto(id);
    }
}
