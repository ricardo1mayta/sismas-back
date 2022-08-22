package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.IndicadoresGODto;
import com.spring.sigmaweb.backend.process.surveys.model.EvaluacionIndicadoresLogro;
import com.spring.sigmaweb.backend.process.surveys.repository.IEvaluacionIndicadoresLogroDao;
import com.spring.sigmaweb.backend.process.surveys.repository.IIndicadoresGoDao;
import com.spring.sigmaweb.backend.process.surveys.repository.IIndicadoresLogroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IndicadoresLogroService implements IIndicadoresLogroService{

    @Autowired
    private IIndicadoresLogroDao indicadoresLogroDao;

    @Autowired
    private IIndicadoresGoDao indicadoresGoDao;

    @Autowired
    private IEvaluacionIndicadoresLogroDao evaluacionIndicadoresLogroDao;

    @Override
    @Transactional(readOnly = true)
    public List<IndicadoresGODto> findByObraAndGrupoOcupacionalAndPuestoAndEvento(String idobra, Integer idgo, Long idpuesto, Long idevento) {
        return indicadoresGoDao.findByObraAndGrupoOcupacionalAndPuestoAndEvento(idobra, idgo, idpuesto, idevento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EvaluacionIndicadoresLogroDTO> findByEvaluacionObraGrupoocupacionalEvento(String idobra, Integer idgo, Long idpuesto, Long idevento) {

        return evaluacionIndicadoresLogroDao.findByEvaluacionObraGrupoocupacionalEvento(idobra, idgo, idpuesto, idevento);
    }

    @Override
    @Transactional(readOnly = true)
    public EvaluacionIndicadoresLogro findByIdIndicgoEvalindlogAndIdObraEvalindlogAndIdPersonalEvalindlog(Long idIndicgoEvalindlog, String idobra, Long idPersonalEvalindlog) {
        return evaluacionIndicadoresLogroDao.findByIdIndicgoEvalindlogAndIdObraEvalindlogAndIdPersonalEvalindlog(idIndicgoEvalindlog, idobra, idPersonalEvalindlog);
    }

    @Override
    @Transactional
    public EvaluacionIndicadoresLogro saveEvaluacionIndLog(EvaluacionIndicadoresLogro evaluacion) {
        return evaluacionIndicadoresLogroDao.save(evaluacion);
    }
}
