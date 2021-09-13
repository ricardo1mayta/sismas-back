package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;

import java.util.List;

public interface IEntidadService {
    public List<EntidadListSelectDTO> findByTipoEntAndFlgSaludEntAndObra(String idobra);

    public List<EntidadListSelectDTO> findByTipoEntAndFlgPrevisionalEntAndObra(Integer tipoEnt, String idobra);
}
