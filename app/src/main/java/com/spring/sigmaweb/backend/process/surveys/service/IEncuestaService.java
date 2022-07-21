package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.legajo.reports.ReportFamiliaresPersonal;
import com.spring.sigmaweb.backend.process.surveys.model.Encuesta;
import com.spring.sigmaweb.backend.process.surveys.model.report.ListaEvaluadosEvaluador;

import java.util.List;

public interface IEncuestaService {

    public Encuesta findByIdMatrizevalEncuestaAndIdObraEncuesta(Long idMatrizevalEncuesta, String idObraEncuesta);

    public Encuesta findByIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(Long idMatrizevalEncuesta, String idObraEncuesta, Long idevento);

    public Encuesta findByIdEncuestaAndIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(Long idEncuesta, Long idMatrizevalEncuesta, String idObraEncuesta, Long idevento);

    public Encuesta saveEncuesta (Encuesta encuesta);

    public void deleteEncuesta (Encuesta encuesta);

    public boolean estadodeEncuestaBorrar(Long idEncuesta, Long idMatriz, String idObra);

    public List<ListaEvaluadosEvaluador> listaEvaluadosEvaluador(String idObra, Long idPersonal, Long idEvento);

}
