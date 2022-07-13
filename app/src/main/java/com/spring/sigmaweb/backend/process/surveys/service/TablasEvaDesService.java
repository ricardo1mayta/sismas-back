package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.PreguntasCompetenciaDTO;
import com.spring.sigmaweb.backend.process.surveys.model.Competencia;
import com.spring.sigmaweb.backend.process.surveys.model.Pregunta;
import com.spring.sigmaweb.backend.process.surveys.model.PreguntasCompetencia;
import com.spring.sigmaweb.backend.process.surveys.repository.ICompetenciaDao;
import com.spring.sigmaweb.backend.process.surveys.repository.IPreguntaDao;
import com.spring.sigmaweb.backend.process.surveys.repository.IPreguntasCompetenciaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TablasEvaDesService implements ITablasEvaDesService{
    @Autowired
    private IPreguntaDao preguntaDao;

    @Autowired
    private ICompetenciaDao competenciaDao;

    @Autowired
    private IPreguntasCompetenciaDao preguntascompetenciadao;

    @Override
    @Transactional(readOnly = true)
    public List<Pregunta> findByPreguntasForPeriodo(Long idperiodo) {
        return preguntaDao.findByPreguntasForPeriodo(idperiodo);
    }

    @Override
    public List<Pregunta> findAllPregunta() {
        return (List<Pregunta>) preguntaDao.findAll();
    }

    @Override
    public List<Pregunta> findByFlgActivoPreg(Boolean flgactivopreg) {
        return preguntaDao.findByFlgActivoPreg(flgactivopreg);
    }

    @Override
    @Transactional(readOnly = true)
    public Pregunta findByIdPregunta(Long idpregunta) {
        return preguntaDao.findByIdPregunta(idpregunta);
    }

    @Override
    public Pregunta findByIdPreguntaAndIdEventoPreg(Long idpregunta, Long ideventopreg) {
        return preguntaDao.findByIdPreguntaAndIdEventoPreg(idpregunta, ideventopreg);
    }

    @Override
    @Transactional
    public Pregunta savePregunta(Pregunta pregunta) {
        return preguntaDao.save(pregunta);
    }

    @Override
    @Transactional
    public void deletePregunta(Pregunta pregunta) {
        preguntaDao.delete(pregunta);
    }

    //COMPETENCIAS
    @Override
    public Competencia findByIdCompetencia(Long idcompetencia) {
        return competenciaDao.findByIdCompetencia(idcompetencia);
    }

    @Override
    public List<Competencia> findAllCompetencia() {
        return (List<Competencia>) competenciaDao.findAll();
    }

    @Override
    public List<Competencia> findByFlgActivoCompe(Boolean flgactivocompe) {
        return competenciaDao.findByFlgActivoCompe(flgactivocompe);
    }

    @Override
    public Competencia findByIdCompetenciaAndIdEventoCompe(Long idcompetencia, Long ideventocompe) {
        return competenciaDao.findByIdCompetenciaAndIdEventoCompe(idcompetencia, ideventocompe);
    }

    @Override
    public List<Competencia> findByCompetenciaForPeriodo(Long idperiodo) {
        return competenciaDao.findByCompetenciaForPeriodo(idperiodo);
    }

    @Override
    public Competencia saveCompetencia(Competencia competencia) {
        return competenciaDao.save(competencia);
    }

    @Override
    public void deleteCompetencia(Competencia competencia) {
        competenciaDao.delete(competencia);
    }

    //PREGUNTAS COMPETENCIAS
    @Override
    public PreguntasCompetencia findByIdPregcomp(Long idpregcomp) {
        return preguntascompetenciadao.findByIdPregcomp(idpregcomp);
    }

    @Override
    public PreguntasCompetencia findByIdCompetenciaPregcompAndIdPreguntaPregcompAndIdGrupoPregcompAndIdEventoPregcompAndIdPregcomp(Long idcompetenciapregcomp, Long idpreguntapregcomp, Integer idgrupopregcomp, Long ideventopregcomp, Long idpregcomp) {
        return preguntascompetenciadao.findByIdCompetenciaPregcompAndIdPreguntaPregcompAndIdGrupoPregcompAndIdEventoPregcompAndIdPregcomp(idcompetenciapregcomp, idpreguntapregcomp, idgrupopregcomp, ideventopregcomp,idpregcomp);
    }

    @Override
    public List<PreguntasCompetenciaDTO> findByIdEventoPregcompAndIdGrupoPregcompAndIdCompetenciaPregcompDto(Long Ideventopregcomp, Integer idgrupopregcomp, Long idcompetenciapregcomp) {
        return preguntascompetenciadao.findByIdEventoPregcompAndIdGrupoPregcompAndIdCompetenciaPregcompDto(Ideventopregcomp, idgrupopregcomp, idcompetenciapregcomp);
    }

    @Override
    public List<PreguntasCompetenciaDTO> findByIdEventoPregcompAndIdGrupoPregcompDtoDistinct(Long Ideventopregcomp, Integer idgrupopregcomp) {
        return preguntascompetenciadao.findByIdEventoPregcompAndIdGrupoPregcompDtoDistinct(Ideventopregcomp,idgrupopregcomp);
    }

    @Override
    @Transactional
    public PreguntasCompetencia savePreguntaComp(PreguntasCompetencia preguntasCompetencia) {
        return preguntascompetenciadao.save(preguntasCompetencia);
    }

    @Override
    @Transactional
    public void deletePreguntacomp(PreguntasCompetencia preguntasCompetencia) {
        preguntascompetenciadao.delete(preguntasCompetencia);
    }
}
