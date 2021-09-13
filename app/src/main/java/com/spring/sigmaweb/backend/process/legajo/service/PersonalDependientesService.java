package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDependienteDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDependiente;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDependientesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalDependientesService implements IPersonalDependientesService{
    @Autowired
    private IPersonalDependientesDao personaldependienteDao;

    @Override
    @Transactional
    public PersonalDependiente save(PersonalDependiente personaldependiente) {
        // TODO Auto-generated method stub
        return personaldependienteDao.save(personaldependiente);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDependiente findByIdPersonalAndObraname(Long idpersonaldep, Long idpersonal, String obraname) {
        // TODO Auto-generated method stub
        return personaldependienteDao.findByIdPersonalAndObraname(idpersonaldep, idpersonal, obraname);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDependienteDTO> findByIdPersonalAndIdObra(Long idpersonal, String idobra) {
        // TODO Auto-generated method stub
        return personaldependienteDao.findByIdPersonalAndIdObra(idpersonal, idobra);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDependienteDTO findByIdPersonalAndIdObraAndIdPerDep(Long idpersonaldep, Long idpersonal,
                                                                       String idobra) {
        return personaldependienteDao.findByIdPersonalAndIdObraAndIdPerDep(idpersonaldep, idpersonal, idobra);
    }

    @Override
    @Transactional
    public void delete(PersonalDependiente personaldependiente) {
        personaldependienteDao.delete(personaldependiente);
    }

    @Override
    @Transactional
    public void deleteAll(List<PersonalDependiente> personaldependiente) {
        personaldependienteDao.deleteAll(personaldependiente);
    }

    @Override
    public List<PersonalDependiente> findByIdPersonalAndObranameList(Long idpersonal, String obraname) {
        // TODO Auto-generated method stub
        return personaldependienteDao.findByIdPersonalAndObranameList(idpersonal, obraname);
    }

}
