package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacion;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.DistribucionCRRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DistribucionCRService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DistribucionCRImpl extends CRUDImpl<DistribucionPonderacion,Long> implements DistribucionCRService {

    private final DistribucionCRRepository repo;

    @Override
    protected IGenericRepo<DistribucionPonderacion, Long> getRepo() {
        return repo;
    }

    @Override
    public List<DistribucionPonderacion> listarPorObraYPeriodoDistribucionCR(String idObra, String periodo) {
        return repo.listarPorObraYPeriodoDistribucionCR(idObra,periodo);
    }
}
