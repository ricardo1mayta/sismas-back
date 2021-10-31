package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.generic.repository.IPersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaDao personaDao;


    @Override
    @Transactional(readOnly = true)
    public Persona findByIdPersona(Long idPersona) {
        return personaDao.findByIdPersona(idPersona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findByIdPersonaAndObraPers(Long idPersona, String obraPers) {
        return personaDao.findByIdPersonaAndObraPers(idPersona,obraPers);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findByNroDocPersAndObraPers(String nroDocPers, String obraPers) {
        return personaDao.findByNroDocPersAndObraPers(nroDocPers,obraPers);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }
}
