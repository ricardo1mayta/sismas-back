package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.IndicadoresGODto;

import java.util.List;

public interface IIndicadoresLogroService {

    public List<IndicadoresGODto> findByObraAndGrupoOcupacionalAndPuestoAndEvento(String idobra, Integer idgo, Long idpuesto, Long idevento);

    public List<EvaluacionIndicadoresLogroDTO> findByEvaluacionObraGrupoocupacionalEvento(String idobra, Integer idgo, Long idpuesto, Long idevento);
}
