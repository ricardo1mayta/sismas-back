package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalExtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalExtService implements IPersonalExtService{
    @Autowired
    private IPersonalExtDao personalExtDao;


    @Override
    public PersonalDatosListDTO findByObraAndidPersonalExternoBasico(String obraname, Long idpersonal) {
        return personalExtDao.findByObraAndidPersonalExternoBasico(obraname, idpersonal);
    }
}
