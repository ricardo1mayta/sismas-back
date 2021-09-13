package com.spring.sigmaweb.backend.process.legajo.service;

import java.util.List;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
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
}
