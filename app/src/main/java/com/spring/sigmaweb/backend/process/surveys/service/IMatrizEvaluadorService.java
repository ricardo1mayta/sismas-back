package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.model.report.ListaEvaluadosEvaluador;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IMatrizEvaluadorService {

    public MatrizEvaluacion findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(String idobra, Long idmatrizeval, Long Idperiodomaev, Long ideventomaev);

    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluador(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal);

    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluado(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal);

    public MatrizEvaluacion saveMatrizEvaluacion (MatrizEvaluacion matriz);

    public void deleteMatrizEvaluador (MatrizEvaluacion matriz);

    public Integer spuCountEvaluadoresEvaluado(String idobra, Long idpersonal, Long idpuestocargo, Boolean esprincipal);

    public List<MatrizEvaluacion> contarEvaluadoresEvaluado (String idobra, Long idevaluador, Long idevaluado);

    public List<MatrizEvaluacionDTO> reportEvaluadoEvaluador(String idobra, String tipo, Long idpersonal, Long idcargoPuesto, Integer esPrincipal,Long idperiodo);

    public ListaEvaluadosEvaluador findByAutoevaluación(String idobra, Long idpersonal, Long idevento);
}
