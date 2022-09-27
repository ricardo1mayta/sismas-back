package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CentroResponsabilidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CentroResponsabilidadRepository extends IGenericRepo<CentroResponsabilidad, Long > {

//    @Query(value = " FROM CentroResponsabilidad cr where cr.flgOut=true ")
    @Query(value = " FROM CentroResponsabilidad cr where cr.flgOut=true and cr.tipo=:tipo")
    List<CentroResponsabilidad> listarPorOPbraCR(@Param("tipo") Integer tipo);
}
