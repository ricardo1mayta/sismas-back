package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistribucionCRRepository extends IGenericRepo<DistribucionPonderacion, Long>{
    @Query(value = "FROM DistribucionPonderacion d where d.idObra=:idObra and d.periodo=:periodo and d.flgEstado=true ")
    List<DistribucionPonderacion> listarPorObraYPeriodoDistribucionCR(@Param("idObra") String idObra, @Param("periodo")String periodo);
}
