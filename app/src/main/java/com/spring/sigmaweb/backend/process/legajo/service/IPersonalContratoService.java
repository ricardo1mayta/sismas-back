package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;

import java.util.List;

public interface IPersonalContratoService {
    public PersonalContrato findByIdPerCont(Long idPerCont);

    public PersonalContrato findByPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont);

    public List<PersonalContrato> findByPersonalAndObraList(Long idpersona, String idobra);

    public PersonalContratoObraDTO findByPersonalAndObraAndcontratoDto(Long idpersona, String idobra, Long idpercont);

    public List<PersonalContratoObraDTO> findByPersonalAndObraAndcontratoDtoList(Long idpersona, String idobra);

    public PersonalContrato save (PersonalContrato contrato);
    //************** JORNADA *********************

    public PersonalContratoJornada findByIdPerjorn(Long idPerjorn);

    public PersonalContratoJornada findByJornadaPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idperjorn);

    public List<PersonalContratoJornada> findByJornadaPersonalAndObraAndcontratoList(Long idpersona, String idobra, Long idpercont);

    public JornadaPersonalContratoDTO findIdJornadaPersonalAndObraAndContratoDTO(Long idpersona, String idobra, Long idpercont, Long idperjorn);

    public List<JornadaPersonalContratoDTO> findJornadasPersonalAndObraAndContratoDTOList(Long idpersona, String idobra, Long idpercont);

    public PersonalContratoJornada save (PersonalContratoJornada jornada);

}
