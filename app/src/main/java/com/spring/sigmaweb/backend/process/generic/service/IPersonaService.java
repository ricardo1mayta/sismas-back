package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.Persona;

public interface IPersonaService {
    public Persona findByIdPersona(Long idPersona);

    public Persona findByIdPersonaAndObraPers(Long idPersona, String obraPers);

    public Persona findByNroDocPersAndObraPers(String nroDocPers, String obraPers);

    public Persona save(Persona persona);
}
