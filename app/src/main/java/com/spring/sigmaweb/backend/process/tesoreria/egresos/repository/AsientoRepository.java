package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.AsientoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Asiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsientoRepository extends IGenericRepo<Asiento,Long> {

//    @Query("select new com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.AsientoDTO")
//    List<AsientoDTO> listarAsientoPorIdDocumentoEgreso(@Param("odDocumentoEgreso") Long idDocumentoEgreso);

    @Query("FROM Asiento a where a.idObjeto=:idObjeto and a.objeto=:objecto and a.idObra=:idObra ")
    List<Asiento> listarPorIdObjectoYObjecto(@Param("idObjeto") Long idObjeto, @Param("objecto") String objecto, @Param("idObra")String idObra);
}
