package com.spring.sigmaweb.backend.process.legajo.service;

import java.util.List;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import com.spring.sigmaweb.backend.process.legajo.repository.IEntidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntidadService implements IEntidadService{
    @Autowired
    private IEntidadDao entidadDao;

    @Override
    @Transactional(readOnly = true)
    public List<EntidadListSelectDTO> findByTipoEntAndFlgSaludEntAndObra(String idobra) {
        // TODO Auto-generated method stub
        return entidadDao.findByTipoEntAndFlgSaludEntAndObra(idobra);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EntidadListSelectDTO> findByTipoEntAndFlgPrevisionalEntAndObra(Integer tipoEnt, String idobra) {
        // TODO Auto-generated method stub
        return entidadDao.findByTipoEntAndFlgPrevisionalEntAndObra(tipoEnt, idobra);
    }

    @Override
    public Entidad findByIdEntidad(Long idEntidad) {
        return entidadDao.findByIdEntidad(idEntidad);
    }

    @Override
    public Entidad findByIdEntidadAndObraEnt(Long idEntidad, String idobra) {
        return entidadDao.findByIdEntidadAndObraEnt(idEntidad, idobra);
    }

    @Override
    public List<EntidadDataSelectDTO> findByEntidadObra(String idobra) {
        return entidadDao.findByEntidadObra(idobra);
    }

    @Override
    public EntidadDataSelectDTO findByIdEntidadObra(Long idEntidad, String idobra) {
        return entidadDao.findByIdEntidadObra(idEntidad, idobra);
    }

    @Override
    public Entidad save(Entidad entidad) {
        return entidadDao.save(entidad);
    }

    @Override
    public List<EntidadListSelectDTO> findByEntidadTipoFlgAndEstadoAndObra(String idobra, Boolean esproveedor, Boolean esprevisor, Boolean essalud, Boolean esedusup, Boolean esFinanciera, Boolean estado) {
        return entidadDao.findByEntidadTipoFlgAndEstadoAndObra(idobra, esproveedor, esprevisor, essalud, esedusup, esFinanciera, estado);
    }
}
