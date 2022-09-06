package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CategoriaPlanContable;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.CategoriaContableRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ICategoriaPlanContableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoriaContableServiceImpl extends CRUDImpl<CategoriaPlanContable,Long > implements ICategoriaPlanContableService {

    private final CategoriaContableRepository repo;

    @Override
    protected IGenericRepo<CategoriaPlanContable, Long> getRepo() {
        return repo;
    }

    @Override
    public List<CategoriaPlanContable> buscarPorCategoriaPlanContableByGrupo(String grupo) {
        return repo.findCategoriaPlanContableByGrupo(grupo);
    }
}
