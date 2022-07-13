package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;

import java.util.List;

public interface IPersonalEvaluacionService {

    public List<PersonalEvaluacionDTO> findByIdObraPerevalList(String idobra, Integer idgruoocu , Long idpuesto, Long idcargo, Integer principal);

    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctList(String idobra);

    public List<PersonalEvaluacionDTO> findByIdObraPersonallListCargosPuestos(String idobra, Long idpersonal, Integer esPrincipal);
    
}
