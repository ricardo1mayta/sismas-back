package com.spring.sigmaweb.backend.process.generic.repository;

import com.spring.sigmaweb.backend.process.generic.model.Persona;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonaDao extends CrudRepository<Persona, Long> {
    public Persona findByIdPersona(Long idPersona);

    public Persona findByIdPersonaAndObraPers(Long idPersona, String obraPers);

    public Persona findByNroDocPersAndObraPers(String nroDocPers, String obraPers);

    //@Query(value = "FROM Persona p where p.obraPers= :obraPers  order by p.idPersona desc ")
    List<Persona> findByObraPersOrderByObraPers(@Param("obraPers") String obraPers);
}
