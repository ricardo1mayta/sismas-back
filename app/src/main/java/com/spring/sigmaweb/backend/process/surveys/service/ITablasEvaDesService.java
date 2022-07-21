package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.dto.PreguntasCompetenciaDTO;
import com.spring.sigmaweb.backend.process.surveys.model.Competencia;
import com.spring.sigmaweb.backend.process.surveys.model.Pregunta;
import com.spring.sigmaweb.backend.process.surveys.model.PreguntasCompetencia;

import java.util.List;

public interface ITablasEvaDesService {
    /*Preguntas*/
    public List<Pregunta> findByPreguntasForPeriodo(Long idperiodo);

    public List<Pregunta> findAllPregunta();

    public List<Pregunta> findByFlgActivoPreg(Boolean flgactivopreg);

    public Pregunta findByIdPregunta(Long idpregunta);

    public Pregunta findByIdPreguntaAndIdEventoPreg(Long idpregunta, Long ideventopreg);

    public Pregunta savePregunta(Pregunta pregunta);

    public void deletePregunta(Pregunta pregunta);

    /*competencias*/
    public Competencia findByIdCompetencia(Long idcompetencia);

    public List<Competencia> findAllCompetencia();

    public List<Competencia> findByFlgActivoCompe(Boolean flgactivocompe);

    public Competencia findByIdCompetenciaAndIdEventoCompe(Long idcompetencia, Long ideventocompe);

    public List<Competencia> findByCompetenciaForPeriodo(Long idperiodo);

    public Competencia saveCompetencia(Competencia competencia);

    public void deleteCompetencia(Competencia competencia);

    /*PreguntasCompetencias*/
    public PreguntasCompetencia findByIdPregcomp(Long idpregcomp);

    public PreguntasCompetencia findByIdCompetenciaPregcompAndIdPreguntaPregcompAndIdGrupoPregcompAndIdEventoPregcompAndIdPregcomp(Long idcompetenciapregcomp, Long idpreguntapregcomp, Integer idgrupopregcomp, Long ideventopregcomp,Long idpregcomp);

    public List<PreguntasCompetenciaDTO> findByIdEventoPregcompAndIdGrupoPregcompAndIdCompetenciaPregcompDto(Long Ideventopregcomp, Integer idgrupopregcomp, Long idcompetenciapregcomp);

    public List<PreguntasCompetenciaDTO> findByIdEventoPregcompAndIdGrupoPregcompCardinalesDtoDistinct(Long Ideventopregcomp, Integer idgrupopregcomp,Boolean principal);
    public List<PreguntasCompetenciaDTO> findByIdEventoPregcompAndIdGrupoPregcompDtoDistinct(Long Ideventopregcomp, Integer idgrupopregcomp);

    public PreguntasCompetencia savePreguntaComp(PreguntasCompetencia preguntasCompetencia);

    public void  deletePreguntacomp(PreguntasCompetencia preguntasCompetencia);

}
