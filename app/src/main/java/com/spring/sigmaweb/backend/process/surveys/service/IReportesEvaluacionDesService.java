package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.model.report.ReportCountEvaluacionesEvalDes;

import java.util.List;

public interface IReportesEvaluacionDesService {
    List<ReportCountEvaluacionesEvalDes> reportCountEvaluaciones(String idobra, Long idperiodo, String tipo, String orden);
}
