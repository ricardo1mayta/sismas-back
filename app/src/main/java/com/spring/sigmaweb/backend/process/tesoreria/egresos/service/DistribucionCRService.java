package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacion;

import java.util.List;

public interface DistribucionCRService extends  ICRUD<DistribucionPonderacion,Long>{

    List<DistribucionPonderacion>listarPorObraYPeriodoDistribucionCR(String idObra, String periodo);
}
