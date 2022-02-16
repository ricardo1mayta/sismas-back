package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.DocumentEmployeeDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.DocumentEmployee;
import com.spring.sigmaweb.backend.process.legajo.model.DocumentoDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDocDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.model.TipoDocumento;
import com.spring.sigmaweb.backend.process.legajo.repository.IDocumentEmployeeDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IDocumentoDesvinculacionDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDocDesvinculacionDao;
import com.spring.sigmaweb.backend.process.legajo.repository.ITipoDocumentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentEmployeeService implements IDocumentEmployeeService{
    @Autowired
    private IDocumentEmployeeDao documentemployeeDao;

    @Autowired
    private ITipoDocumentoDao tipoDocumentoDao;

    @Autowired
    private IDocumentoDesvinculacionDao documentodesvinculacionDao;

    @Autowired
    private IPersonalDocDesvinculacionDao personaldocdesvDao;

    @Override
    @Transactional(readOnly = true)
    public List<DocumentEmployeeDTO> findByDocumentPersonalAndObraAndTipoList(Long idpersonal, String idobra, String tipodocumento, Long idIPadre) {
        return documentemployeeDao.findByDocumentPersonalAndObraAndTipoList(idpersonal, idobra, tipodocumento, idIPadre);
    }

    @Override
    @Transactional
    public DocumentEmployee save(DocumentEmployee documento) {
        return documentemployeeDao.save(documento);
    }

    @Override
    @Transactional
    public void delete(DocumentEmployee documento) {
        documentemployeeDao.delete(documento);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentEmployee findByDocumentPersonalAndObraAndTipoAndId(Long idpersonal, String idobra, String tipodocumento, Long idopcion, Long idIPadre, Long iddocu) {
        return documentemployeeDao.findByDocumentPersonalAndObraAndTipoAndId(idpersonal, idobra, tipodocumento, idopcion, idIPadre, iddocu);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentEmployeeDTO findByDocumentPersonalAndObraAndTipoAndIdDto(Long idpersonal, String idobra, String tipodocumento, Long idopcion, Long idIPadre, Long iddocu) {
        return documentemployeeDao.findByDocumentPersonalAndObraAndTipoAndIdDto(idpersonal, idobra, tipodocumento, idopcion, idIPadre, iddocu);
    }

    @Override
    @Transactional(readOnly = true)
    public Long generateIdFile(Long idpersonal, String idobra, String tipodocumento, Long idIPadre, Long opcion) {
        Integer indexObra= null;
        Integer indexTipo= null;
        Long rtn = null;
        String txt="";
        String txtopcion="";
        switch (idobra) {
            case "BARIBA" :
                indexObra = 1; break;
            case "CHAMPC" :
                indexObra = 2; break;
            case "CHAMPS" :
                indexObra = 3; break;
            case "SANJOC" :
                indexObra = 4; break;
            case "SANJOH" :
                indexObra = 5; break;
            case "SANJOS" :
                indexObra = 6; break;
            case "SANLUI" :
                indexObra = 7; break;
            case "STAROS" :
                indexObra = 8; break;
            case "SECTOR" :
                indexObra = 0; break;
        }
        switch (tipodocumento) {
            case "CARGO" :
                indexTipo = 1; break;
            case "CONTRATO" :
                indexTipo = 2; break;
            case "DESVINCULA" :
                indexTipo = 3; break;
            case "CONVENIO" :
                indexTipo = 4; break;
            case "DESVINCDOC":
                indexTipo = 31; break;
        }

        Double divide = Double.parseDouble(((idpersonal.toString() + idIPadre.toString()+"").length() / 3 )+"");
        double parteDecimal = divide % 1;
        double parteEntera = divide - parteDecimal;
        Integer x = 1;
        while(x <= parteEntera){
            txt +="0";
            x++;
        }
        txt = (idpersonal.toString() + idIPadre.toString()+"") + txt;
        txtopcion= ("000" + opcion );

        rtn  = Long.parseLong ( txt + (indexObra.toString() + indexTipo.toString() + "000").substring(0,3) + txtopcion.substring(txtopcion.length() - 3));

        return rtn ;
    }

    @Override
    public Long countByIdObraFilePerAndtipoFilePerAndOpcionFilePer(String idObraFilePer, String tipoFilePer, Long opcionFilePer) {
        return documentemployeeDao.countByIdObraFilePerAndTipoFilePerAndOpcionFilePer(idObraFilePer, tipoFilePer, opcionFilePer);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentEmployeeDTO findByDocumentPersonalAndObraAndOpcionAndTipoDto(Long idpersonal, String idobra, String tipodocumento, Long idopcion, Long idIPadre) {
        return documentemployeeDao.findByDocumentPersonalAndObraAndOpcionAndTipoDto(idpersonal, idobra, tipodocumento, idopcion, idIPadre);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoDocumento findByIdTipoFileAndIdObraTipoFile(Long idTipoFile, String idObraTipoFile) {
        return tipoDocumentoDao.findByIdTipoFileAndIdObraTipoFile(idTipoFile, idObraTipoFile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoDocumento> findByTipoFileAndIdObraTipoFile(String tipoFile, String idObraTipoFile) {
        return tipoDocumentoDao.findByTipoFileAndIdObraTipoFile(tipoFile, idObraTipoFile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoDocumento> findByTipoFileAndEstadoTipoFileAndIdObraTipoFile(String tipoFile, Boolean estadoTipoFile, String idObraTipoFile) {
        return tipoDocumentoDao.findByTipoFileAndEstadoTipoFileAndIdObraTipoFile(tipoFile, estadoTipoFile, idObraTipoFile);
    }

    @Override
    @Transactional
    public TipoDocumento save(TipoDocumento tipodocumento) {
        return tipoDocumentoDao.save(tipodocumento);
    }

    @Override
    public void delete(TipoDocumento tipodocumento) {
        tipoDocumentoDao.delete(tipodocumento);
    }


    //Documentos Desvinculacion
    @Override
    @Transactional(readOnly = true)
    public DocumentoDesvinculacion findByIdDocdesvAndIdObraDocdesvAndTipoDocdesv(Long idDocdesv, String idObraDocdesv, String tipoDocdesv) {
        return documentodesvinculacionDao.findByIdDocdesvAndIdObraDocdesvAndTipoDocdesv(idDocdesv, idObraDocdesv, tipoDocdesv);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentoDesvinculacion> findByIdObraDocdesvAndTipoDocdesv(String idObraDocdesv, String tipoDocdesv) {
        return documentodesvinculacionDao.findByIdObraDocdesvAndTipoDocdesv(idObraDocdesv, tipoDocdesv);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDocDesvinculacion findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr(String idPerentr, Long idPerdesvPerentr, String idObraPerentr) {
        return personaldocdesvDao.findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr(idPerentr, idPerdesvPerentr, idObraPerentr);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDocDesvinculacion> findByIdPerdesvPerentrAndIdObraPerentr(Long idPerdesvPerentr, String idObraPerentr) {
        return personaldocdesvDao.findByIdPerdesvPerentrAndIdObraPerentr(idPerdesvPerentr, idObraPerentr);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDocDesvDTO> findDesvinculacionAndIdObralist(Long perdesv, String idobra) {

        return personaldocdesvDao.findDesvinculacionAndIdObralist(perdesv,idobra);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDocDesvDTO findDesvinculacionAndIdObraAndId(Long perdesv, String idobra, String idperentr) {
        return personaldocdesvDao.findDesvinculacionAndIdObraAndId(perdesv, idobra, idperentr);
    }

    @Override
    @Transactional
    public PersonalDocDesvinculacion saveDDoc(PersonalDocDesvinculacion perdocdesv) {
        return personaldocdesvDao.save(perdocdesv);
    }


}
