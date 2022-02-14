package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.model.DocumentoDesvinculacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDocumentoDesvinculacionDao extends CrudRepository<DocumentoDesvinculacion, Long> {
    public DocumentoDesvinculacion findByIdDocdesvAndIdObraDocdesvAndTipoDocdesv (Long idDocdesv, String idObraDocdesv, String tipoDocdesv);

    public List<DocumentoDesvinculacion> findByIdObraDocdesvAndTipoDocdesv (String idObraDocdesv, String tipoDocdesv);
}
