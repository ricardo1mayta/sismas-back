package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalConvenio;
import com.spring.sigmaweb.backend.process.legajo.repository.IConvenioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalConvenioService implements IPersonalConvenioService{

    @Autowired
    IConvenioDao convenioDao;

    @Override
    public PersonalConvenio findByIdPerConv(Long idPerConv) {
        return convenioDao.findByIdPerConv(idPerConv);
    }

    @Override
    public PersonalConvenio findByPersonalAndObraAndConvenio(Long idpersonal, String idobra, Long idperconv, Long idpervila) {
        return convenioDao.findByPersonalAndObraAndConvenio(idpersonal, idobra, idperconv, idpervila);
    }

    @Override
    public List<PersonalConvenio> findByPersonalAndObraList(Long idpersonal, String idobra, Long idpervila) {
        return convenioDao.findByPersonalAndObraList(idpersonal, idobra, idpervila);
    }

    @Override
    public PersonalConveniosDTO findByPersonalAndObraAndConvenioDto(Long idpersona, String idobra, Long idperconv, Long idpervila) {
        return convenioDao.findByPersonalAndObraAndConvenioDto(idpersona, idobra, idperconv, idpervila);
    }

    @Override
    public List<PersonalConveniosDTO> findByPersonalAndObraListDto(Long idpersona, String idobra, Long idpervila) {
        return convenioDao.findByPersonalAndObraListDto(idpersona, idobra, idpervila);
    }

    @Override
    public List<PersonalConveniosDTO> findConvenioActivoPracticasListDto(Long idpersona, String idobra, Long idpervila) {
        return convenioDao.findConvenioActivoPracticasListDto(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional
    public PersonalConvenio save(PersonalConvenio convenio) {
        return convenioDao.save(convenio);
    }
}
