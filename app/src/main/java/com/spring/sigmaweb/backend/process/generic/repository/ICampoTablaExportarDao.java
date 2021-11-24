package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.CamposTablaExportar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICampoTablaExportarDao extends CrudRepository<CamposTablaExportar, Long> {

   public List<CamposTablaExportar> findByIdGrupoCampoAndEstadoCampo(String idgrupo, boolean estadocampo);
}
