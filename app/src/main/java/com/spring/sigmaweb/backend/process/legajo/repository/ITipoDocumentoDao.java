package com.spring.sigmaweb.backend.process.legajo.repository;

import com.spring.sigmaweb.backend.process.legajo.model.TipoDocumento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Long> {
    public TipoDocumento findByIdTipoFileAndIdObraTipoFile(Long idTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndIdObraTipoFile(String tipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndEstadoTipoFileAndIdObraTipoFile(String tipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndCodigoTipoFileAndEstadoTipoFileAndIdObraTipoFile(String tipoFile, String codigoTipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    @Query("select td " +
            "from TipoDocumento td " +
            "where td.tipoFile = ?1  And td.codigoTipoFile in (?2, '') And td.estadoTipoFile = ?3 And td.idObraTipoFile = ?4"
    )
    public List<TipoDocumento> findByTipoCodigoEstadoObras(String tipoFile, String codigoTipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndCodigoTipoFileAndEstadoTipoFileAndIdObraTipoFileAndNumRepeatTipoFile(String tipoFile, String codigoTipoFile, Boolean estadoTipoFile, String idObraTipoFile, Integer numRepeatTipoFile);


    public TipoDocumento save (TipoDocumento tipodocumento);
}
