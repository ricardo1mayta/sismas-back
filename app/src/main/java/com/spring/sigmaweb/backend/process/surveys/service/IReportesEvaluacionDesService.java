package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.model.report.*;

import java.util.List;

public interface IReportesEvaluacionDesService {
    public List<ReportCountEvaluacionesEvalDes> reportCountEvaluaciones(String idobra, Long idperiodo, String tipo, Long idgo, Long idnivelp, String orden);

    public List<ReportEvaluadoresEvaluados> reportEvaluadorEvaluado(String idobra, String tipo, Long idPeriodo, String orden);

    public List<ReportEstadoEvaluacionEvaluadorEvaluado> reportEstadoEvaluacionEvaluadorEvaluado(String idobra, String tipo, Long idPeriodo, String orden);

    public List<ReportNoParticipan> reportNoParticipanEvaldesemp(String idobra, Long idPeriodo);

    public List<ReportIndividualesEvaluacionDesemp> reportIndividualesEvaluacionDesemp(Long idPersonal, String idobra);

    public List<ReportGeneralEvaluacionDesemp> reportGeneralEvaluacionDesemps(Long idpersonal, String idobra, Double pesoCar, Double pesoEsp, Double pesoIl, String orderPromedio) ;


    //Graficos
    public List<GraficosDirectoresPromedio> graficoDirectoresPromedio(String idobra, String idtipo) ;

}
