package com.spring.sigmaweb.backend.process.tesoreria.egresos.service.impl;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.PlanContable;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.IGenericRepo;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.repository.PlanContableRepository;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IPlanContableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PlanContableServiceImpl extends CRUDImpl<PlanContable, Long> implements IPlanContableService {

    private final PlanContableRepository repo;
    @Override
    protected IGenericRepo<PlanContable, Long> getRepo() {
        return repo;
    }

    @Override
    public List<PlanContable> listarPorIdCategoriaContable(Long id) {
        return repo.listarPorIdCategoriaContable(id);
    }

    @Override
    public List<PlanContable> listarPlanContable() {
        return repo.listarPlanContable();
    }
}
