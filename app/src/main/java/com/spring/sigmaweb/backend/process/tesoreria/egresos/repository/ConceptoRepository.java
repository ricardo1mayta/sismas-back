package com.spring.sigmaweb.backend.process.tesoreria.egresos.repository;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Concepto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConceptoRepository extends IGenericRepo<Concepto, Long>{

    @Query(value = "FROM Concepto c where c.tipoConcepto.idTipoConcepto = :idTipoConcepto")
    List<Concepto> listarPorTipoConcepto(@Param("idTipoConcepto") Long idTipoConcepto);
}
