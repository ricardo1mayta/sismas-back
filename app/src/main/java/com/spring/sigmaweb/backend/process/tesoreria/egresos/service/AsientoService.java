package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Asiento;

import java.util.List;

public interface AsientoService extends ICRUD<Asiento,Long>{

    List<Asiento> listarPorIdObjectoYObjecto(Long idObjeto, String objeto, String IdOra);

}
