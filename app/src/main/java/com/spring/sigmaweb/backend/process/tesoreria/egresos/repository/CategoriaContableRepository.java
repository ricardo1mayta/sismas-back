package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CategoriaPlanContable;

import java.util.List;

public interface CategoriaContableRepository extends IGenericRepo<CategoriaPlanContable,Long>{
    List<CategoriaPlanContable> findCategoriaPlanContableByGrupo(String grupo);
}
