package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Detraccion;

import java.util.List;

public interface DetraccionService extends ICRUD<Detraccion,Long>{

    List<Detraccion> listarPorIdObra(String idObra);
}
