package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.PlanContable;

import java.util.List;

public interface IPlanContableService extends  ICRUD<PlanContable, Long>{

    List<PlanContable> listarPorIdCategoriaContable(Long id);

    List<PlanContable> listarPlanContable();
}
