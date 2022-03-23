package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.model.TipoDocumento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Long> {
    public TipoDocumento findByIdTipoFileAndIdObraTipoFile(Long idTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndIdObraTipoFile(String tipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndEstadoTipoFileAndIdObraTipoFile(String tipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndCodigoTipoFileAndEstadoTipoFileAndIdObraTipoFile(String tipoFile, String codigoTipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    public TipoDocumento save (TipoDocumento tipodocumento);
}
