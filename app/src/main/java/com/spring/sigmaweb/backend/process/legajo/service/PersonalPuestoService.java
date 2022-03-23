package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalPuesto;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalPuestoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalPuestoService implements IPersonalPuestoService{

    @Autowired
    private IPersonalPuestoDao personalpuestoDao;

    @Override
    @Transactional(readOnly = true)
    public List<PersonalPuesto> findByIdPersonalAndIdobraAndIdPervila(Long idpersona, String idobra, Long idpervila) {
        return personalpuestoDao.findByIdPersonalAndIdobraAndIdPervila(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalPuesto findByIdPersonalAndIdobraAndIdPervilaAndId(Long idpersona, String idobra, Long idpervila, Long idperpuesto) {
        return personalpuestoDao.findByIdPersonalAndIdobraAndIdPervilaAndId(idpersona, idobra, idpervila, idperpuesto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalPuestoDTO> findByObraPersonalVidaLab(Long idpersona, String idobra, Long idpervila) {
        return personalpuestoDao.findByObraPersonalVidaLab(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalPuestoDTO findByObraPersonalVidaLabId(Long idpersona, String idobra, Long idpervila, Long idperpuest) {
        return personalpuestoDao.findByObraPersonalVidaLabId(idpersona, idobra, idpervila, idperpuest);
    }

    @Override
    @Transactional
    public PersonalPuesto save(PersonalPuesto newPuesto) {
        return personalpuestoDao.save(newPuesto);
    }
}
