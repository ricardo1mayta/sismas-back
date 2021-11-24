package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.CamposTablaExportar;

import java.util.List;

public interface IExportarTablasService {

    List<Object> exportTablaLegajo(String obraname, String opcion, String selectsql, String fromsql, String wheresql);

    public List<CamposTablaExportar> findByIdGrupoCampoAndEstadoCampo(String idgrupo, Boolean estadocampo);
}
