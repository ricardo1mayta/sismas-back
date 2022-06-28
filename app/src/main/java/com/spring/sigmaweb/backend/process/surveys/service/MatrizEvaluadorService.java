package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.repository.IMatrizEvaluacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatrizEvaluadorService implements IMatrizEvaluadorService{
    @Autowired
    private IMatrizEvaluacionDao matrizEvaluadordao;

    @Override
    @Transactional(readOnly = true)
    public MatrizEvaluacion findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(String idobra, Long idmatrizeval, Long Idperiodomaev, Long ideventomaev) {
        return matrizEvaluadordao.findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(idobra, idmatrizeval, Idperiodomaev, ideventomaev);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluador(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal) {
        return matrizEvaluadordao.findListaByObraByPeriodoByEventoidByEvaluador(idobra, idpersonal, idcargoPuesto, esPrincipal);
    }

    @Override
    @Transactional
    public MatrizEvaluacion saveMatrizEvaluacion(MatrizEvaluacion matriz) {
        return matrizEvaluadordao.save(matriz);
    }

    @Override
    @Transactional
    public void deleteMatrizEvaluador(MatrizEvaluacion matriz) {
        matrizEvaluadordao.delete(matriz);
    }
}
