package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Asiento;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.AsientoRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.AsientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsientoServiceImpl extends CRUDImpl<Asiento,Long> implements AsientoService {

    private final AsientoRepository repo;

    @Override
    protected IGenericRepo<Asiento, Long> getRepo() {
        return repo;
    }


    @Override
    public List<Asiento> listarPorIdObjectoYObjecto(Long idObjeto, String objeto, String IdOra) {
        return null;
    }
}
