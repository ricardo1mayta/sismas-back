package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Detraccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetraccionRepository extends IGenericRepo<Detraccion,Long>{

    @Query("FROM Detraccion d where d.idObra=:idObra and d.flgEstado=true ")
    List<Detraccion>findByidObra(@Param("idObra")String idObra);

    @Query("FROM Detraccion  d where d.idObra=:idObra and d.flgEstado=true and d.valorPorcentual=0")
    Detraccion findDetraccionByImport(@Param("idObra") String idObra);

}
