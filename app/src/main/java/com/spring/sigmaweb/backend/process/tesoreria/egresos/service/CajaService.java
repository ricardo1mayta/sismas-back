package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Concepto;

import java.util.List;

public interface CajaService extends ICRUD<Caja, Long>{

    List<Caja> findByIdObra (String idobra);

    Caja findByIdObraAndIdCaja (String idobra, Long idcaja);
}
