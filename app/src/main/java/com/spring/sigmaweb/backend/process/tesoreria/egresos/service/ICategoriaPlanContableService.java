package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CategoriaPlanContable;

import java.util.List;

public interface ICategoriaPlanContableService extends ICRUD<CategoriaPlanContable,Long>{
    List<CategoriaPlanContable> buscarPorCategoriaPlanContableByGrupo(String grupo);
}

