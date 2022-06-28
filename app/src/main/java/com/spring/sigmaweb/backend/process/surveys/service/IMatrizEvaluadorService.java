package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;

import java.util.List;

public interface IMatrizEvaluadorService {

    public MatrizEvaluacion findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(String idobra, Long idmatrizeval, Long Idperiodomaev, Long ideventomaev);

    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluador(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal);

    public MatrizEvaluacion saveMatrizEvaluacion (MatrizEvaluacion matriz);

    public void deleteMatrizEvaluador (MatrizEvaluacion matriz);
}
