package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.PlanContable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanContableRepository extends IGenericRepo<PlanContable, Long> {
    @Query(value = "FROM PlanContable p where p.categoriaPlanContable.idCategoriaPlanContable = :idCategoriaContable")
    List<PlanContable> listarPorIdCategoriaContable(@Param("idCategoriaContable") Long idCategoriaContable);

    @Query(value = "FROM PlanContable p where p.categoriaPlanContable.idCategoriaPlanContable  is not null")
    List<PlanContable> listarPlanContable();
}
