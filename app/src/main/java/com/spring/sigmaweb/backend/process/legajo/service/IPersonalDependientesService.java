package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDependienteDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDependiente;

import java.util.List;

public interface IPersonalDependientesService {
    public PersonalDependiente save(PersonalDependiente personaldependiente);

    public PersonalDependiente findByIdPersonalAndObraname(Long idpersonaldep, Long idpersonal, String obraname);

    public List<PersonalDependiente> findByIdPersonalAndObranameList(Long idpersonal, String obraname);

    public List<PersonalDependienteDTO> findByIdPersonalAndIdObra(Long idpersonal, String idobra);

    public PersonalDependienteDTO findByIdPersonalAndIdObraAndIdPerDep(Long idpersonaldep, Long idpersonal, String idobra);

    public void delete(PersonalDependiente personaldependiente);

    public void deleteAll(List<PersonalDependiente> personaldependiente);
}
