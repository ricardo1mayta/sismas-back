package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.generic.repository.IPersonaDao;
import com.spring.sigmaweb.backend.process.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
        persona.setFechaIngPers(new Date());
        persona.setFechaNacPers(new Date());
        persona.setReligionProfesaPers("");
        persona.setTipoViaDomiPers(14501);
        persona.setTipoZonaDomiPers(31001);
        persona.setEstadoPers(Constants.FLAG_ESTADO.ACTIVO);
        return personaDao.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        Persona personaACtual =personaDao.findByIdPersona(persona.getIdPersona());
        personaACtual.setApePaternoPers(persona.getApePaternoPers());
        personaACtual.setApeMaternoPers(persona.getApeMaternoPers());
        personaACtual.setNombrePers(persona.getNombrePers());
        personaACtual.setIdTipoDocPers(persona.getIdTipoDocPers());
        personaACtual.setNroDocPers(persona.getNroDocPers());
        personaACtual.setIdPaisDocPers(persona.getIdPaisDocPers());
        personaACtual.setSexoPers(persona.getSexoPers());
        personaACtual.setNombrePers(persona.getNombrePers());
        personaACtual.setNombrePers(persona.getNombrePers());
        personaACtual.setEstCivilPers(persona.getEstCivilPers());
        personaACtual.setCelularPers(persona.getCelularPers());
        personaACtual.setCelularBPers(persona.getCelularBPers());
        personaACtual.setTelefonoFijoPers(persona.getTelefonoFijoPers());
        personaACtual.setEmailPers(persona.getEmailPers());
        personaACtual.setEmailCorPers(persona.getEmailCorPers());
        personaACtual.setModiPorPers(persona.getModiPorPers());
        personaACtual.setReferenciaContactoPers(persona.getReferenciaContactoPers());
        personaACtual.setDomicilioPers(persona.getDomicilioPers());
        personaACtual.setFechaModiPers(new Date());
        return personaDao.save(personaACtual);
    }

    @Override
    public List<Persona> findByObraPers(String obraPers) {
        //return personaDao.findByObraPers(obraPers);
        return personaDao.findByObraPersOrderByObraPers(obraPers);
    }


}
