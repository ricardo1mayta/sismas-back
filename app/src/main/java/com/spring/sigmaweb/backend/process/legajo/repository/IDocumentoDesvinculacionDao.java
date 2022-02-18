package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.model.DocumentoDesvinculacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDocumentoDesvinculacionDao extends CrudRepository<DocumentoDesvinculacion, Long> {
    public DocumentoDesvinculacion findByIdDocdesvAndIdObraDocdesvAndTipoDocdesv (Long idDocdesv, String idObraDocdesv, String tipoDocdesv);

    @Query("select dd " +
            "from DocumentoDesvinculacion dd " +
            "where dd.idObraDocdesv = ?1 and dd.tipoDocdesv = (case ?2 when '_' then dd.tipoDocdesv else ?2 end)"
    )
    public List<DocumentoDesvinculacion> findByIdObraDocdesvAndTipoDocdesv (String idObraDocdesv, String tipoDocdesv);


}
