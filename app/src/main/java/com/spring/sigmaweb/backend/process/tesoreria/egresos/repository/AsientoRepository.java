package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.AsientoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Asiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsientoRepository extends IGenericRepo<Asiento,Long> {

//    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.AsientoDTO")
//    List<AsientoDTO> listarAsientoPorIdDocumentoEgreso(@Param("odDocumentoEgreso") Long idDocumentoEgreso);
}
