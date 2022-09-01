package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;

public interface IPersonalExtService {

    public PersonalDatosListDTO findByObraAndidPersonalExternoBasico(String obraname, Long idpersonal);
}
