package com.spring.sigmaweb.backend.process.legajo.service;


import com.spring.sigmaweb.backend.process.legajo.dto.DocumentEmployeeDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.DocumentEmployee;
import com.spring.sigmaweb.backend.process.legajo.model.DocumentoDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDocDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.model.TipoDocumento;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

public interface IDocumentEmployeeService {
    public List<DocumentEmployeeDTO> findByDocumentPersonalAndObraAndTipoList(Long idpersonal, String idobra, String tipodocumento, Long idIPadre);

    public DocumentEmployee save(DocumentEmployee documento);

    public void insertNativeDocumentoUpload(DocumentEmployee documento);

    public void delete(DocumentEmployee documento);

    public DocumentEmployee findByDocumentPersonalAndObraAndTipoAndId(Long idpersonal, String idobra, String tipodocumento,
                                                                         Long idopcion, Long idIPadre, String iddocu);

    public DocumentEmployeeDTO findByDocumentPersonalAndObraAndTipoAndIdDto(Long idpersonal, String idobra, String tipodocumento,
                                                                            Long idopcion, Long idIPadre, String iddocu);

    public String generateIdFile (Long idpersonal, String idobra, String tipodocumento, Long idIPadre, Long opcion);

    public Long countByIdObraFilePerAndtipoFilePerAndOpcionFilePer(String idObraFilePer, String tipoFilePer, Long opcionFilePer);

    public DocumentEmployeeDTO findByDocumentPersonalAndObraAndOpcionAndTipoDto(Long idpersonal, String idobra, String tipodocumento,
                                                                                Long idopcion, Long idIPadre);

    //tipos de documentos
    public TipoDocumento findByIdTipoFileAndIdObraTipoFile(Long idTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndIdObraTipoFile(String tipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndEstadoTipoFileAndIdObraTipoFile(String tipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndCodigoTipoFileAndEstadoTipoFileAndIdObraTipoFile(String tipoFile, String codigoTipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoCodigoEstadoObras(String tipoFile, String codigoTipoFile, Boolean estadoTipoFile, String idObraTipoFile);

    public List<TipoDocumento> findByTipoFileAndCodigoTipoFileAndEstadoTipoFileAndIdObraTipoFileAndNumRepeatTipoFile(String tipoFile, String codigoTipoFile, Boolean estadoTipoFile, String idObraTipoFile, Integer numRepeatTipoFile);

    public TipoDocumento save (TipoDocumento tipodocumento);

    public void delete(TipoDocumento tipodocumento);

    //ckeck-list Desvinculacion
    public DocumentoDesvinculacion findByIdDocdesvAndIdObraDocdesvAndTipoDocdesv (Long idDocdesv, String idObraDocdesv, String tipoDocdesv);

    public List<DocumentoDesvinculacion> findByIdObraDocdesvAndTipoDocdesv (String idObraDocdesv, String tipoDocdesv);

    public DocumentoDesvinculacion saveDocDesv(DocumentoDesvinculacion docdesv);
    //-----
    public PersonalDocDesvinculacion findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr (String idPerentr, Long idPerdesvPerentr, String idObraPerentr);

    public List<PersonalDocDesvinculacion> findByIdPerdesvPerentrAndIdObraPerentr (Long idPerdesvPerentr, String idObraPerentr);

    public List<PersonalDocDesvDTO> findDesvinculacionAndIdObralist(Long perdesv, String idobra);

    public PersonalDocDesvDTO findDesvinculacionAndIdObraAndId(Long perdesv, String idobra, String idperentr);

    public PersonalDocDesvinculacion saveDDoc( PersonalDocDesvinculacion perdocdesv);


}
