package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;

import java.util.Date;
import java.util.List;

public interface IPersonalEvaluacionService {

    public List<PersonalEvaluacionDTO> findByIdObraPerevalList(String idobra, Integer idgruoocu , Long idpuesto, Long idcargo, Integer principal);

    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctList(String idobra);

    public List<PersonalEvaluacionDTO> findByIdObraPersonallListCargosPuestos(String idobra, Long idpersonal, Integer esPrincipal);

    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctListCristoStamar(String idobra);

    //EXTERNOS
    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctListExternos(String idobra);
    //CIERRE
    public List<PersonalEvaluacionDTO> findEstadoBloqueoEncuesta(String idobra, Long idevento, Long idpersonal, Integer idgrupoocu);

    public Integer updateBloqueoPersonalEval(Integer estado, Long idpersonal, String obraname, Long idevento);
}
