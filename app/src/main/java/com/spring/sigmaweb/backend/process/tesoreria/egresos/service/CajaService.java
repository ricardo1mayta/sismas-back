package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Concepto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TarjetaCredito;

import java.util.List;

public interface CajaService extends ICRUD<Caja, Long>{

    List<Caja> findByIdObra (String idobra);

    List<Caja> findByIdObraAndFlgEstado (String idobra, Boolean flgestado);

    Caja findByIdObraAndIdCaja (String idobra, Long idcaja);

    Caja save(Caja caja);
}
