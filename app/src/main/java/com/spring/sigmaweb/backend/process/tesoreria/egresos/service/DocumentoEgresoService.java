package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoListaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DocumentoEgreso;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DocumentoEgresoService extends  ICRUD<DocumentoEgreso,Long>{
    List<DocumentoEgreso> listarPorObraDocumentoEgreso(String idObra);
    DocumentoEgreso registrarTransaccional(DocumentoEgreso documentoEgreso) throws Exception;
    Integer numeroCorrelativo(String idObra);
    Page<DocumentoEgresoListaDTO> listarPorObra(String idObra,Integer page, Integer size);
}
