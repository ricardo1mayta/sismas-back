package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.model.report.ReportCountEvaluacionesEvalDes;
import com.spring.sigmaweb.backend.process.surveys.model.report.ReportEstadoEvaluacionEvaluadorEvaluado;
import com.spring.sigmaweb.backend.process.surveys.model.report.ReportEvaluadoresEvaluados;
import com.spring.sigmaweb.backend.process.surveys.model.report.ReportNoParticipan;

import java.util.List;

public interface IReportesEvaluacionDesService {
    public List<ReportCountEvaluacionesEvalDes> reportCountEvaluaciones(String idobra, Long idperiodo, String tipo, Long idgo, Long idnivelp, String orden);

    public List<ReportEvaluadoresEvaluados> reportEvaluadorEvaluado(String idobra, String tipo, Long idPeriodo, String orden);

    public List<ReportEstadoEvaluacionEvaluadorEvaluado> reportEstadoEvaluacionEvaluadorEvaluado(String idobra, String tipo, Long idPeriodo, String orden);

    public List<ReportNoParticipan> reportNoParticipanEvaldesemp(String idobra, Long idPeriodo);

    public Integer update_promediosEvaldes(Long idpersonal, String idobra);
}
