package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Persona;

import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long> {
    public Persona findByIdPersona(Long idPersona);

    public Persona findByIdPersonaAndObraPers(Long idPersona, String obraPers);

    public Persona findByNroDocPersAndObraPers(String nroDocPers, String obraPers);


}
