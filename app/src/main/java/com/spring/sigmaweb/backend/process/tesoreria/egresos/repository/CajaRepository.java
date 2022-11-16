package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;

import java.util.List;

public interface CajaRepository extends IGenericRepo<Caja, Long> {
    List<Caja> findByIdObra (String idobra);

    List<Caja> findByIdObraAndFlgEstado (String idobra, Boolean flgestado);

    Caja findByIdObraAndIdCaja (String idobra, Long idcaja);



}
