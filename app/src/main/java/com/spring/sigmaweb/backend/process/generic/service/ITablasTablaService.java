package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.dto.GroupContratos;
import com.spring.sigmaweb.backend.process.generic.dto.TipoContratoDTO;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;

import java.util.List;

public interface ITablasTablaService {
    public List<TablasTabla> findByTipoTab(Integer tipotab);
    public TablasTabla findByCodigoTab(Integer codigoTab);
    public List<TablasTabla> findByCodigoList(Integer tipotab,String listCodigos);
    public List<TablasTabla> findByCodigoListNot(Integer tipotab,String listCodigos);
    public List<GroupContratos> getTipoContrato(Integer tipotab);
}
