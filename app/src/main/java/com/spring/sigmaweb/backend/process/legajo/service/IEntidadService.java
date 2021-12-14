package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;

import java.util.List;

public interface IEntidadService {
    public List<EntidadListSelectDTO> findByTipoEntAndFlgSaludEntAndObra(String idobra);

    public List<EntidadListSelectDTO> findByTipoEntAndFlgPrevisionalEntAndObra(Integer tipoEnt, String idobra);

    public Entidad findByIdEntidad(Long idEntidad);

    public Entidad findByIdEntidadAndObraEnt(Long idEntidad, String idobra);

    public List<EntidadDataSelectDTO> findByEntidadObra(String idobra);

    public EntidadDataSelectDTO findByIdEntidadObra(Long idEntidad,String idobra);

    public Entidad save(Entidad entidad);


}
