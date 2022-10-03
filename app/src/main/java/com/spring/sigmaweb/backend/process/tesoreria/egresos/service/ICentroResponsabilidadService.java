package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CentroResponsabilidad;

import java.util.List;

public interface ICentroResponsabilidadService extends ICRUD<CentroResponsabilidad,Long>{
    List<CentroResponsabilidad>listarPorOPbraCR(Integer tipo);

}
