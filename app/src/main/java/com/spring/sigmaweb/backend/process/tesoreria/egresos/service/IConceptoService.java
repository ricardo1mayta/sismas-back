package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Concepto;

import java.util.List;


public interface IConceptoService extends ICRUD<Concepto, Long>{

    List<Concepto> listarPorTipoConcepto(Long id);
}
