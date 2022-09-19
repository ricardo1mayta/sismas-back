package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.surveys.model.report.*;
import com.spring.sigmaweb.backend.process.surveys.service.IReportesEvaluacionDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/evaluaciondesemp/reportes")
public class ReportesEvaluacionDesRestController {
    @Autowired
    private IReportesEvaluacionDesService reportesEvaluaciondes;

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportcountevaluaciones/{idobra}/{idperiodo}/{tipo}/{idgo}/{idnivelp}/{orden}")
    public List<ReportCountEvaluacionesEvalDes> reportCountEvaluaciones(@PathVariable String idobra, @PathVariable Long idperiodo, @PathVariable String tipo, @PathVariable Long idgo, @PathVariable Long idnivelp, @PathVariable String orden){
        return reportesEvaluaciondes.reportCountEvaluaciones(idobra, idperiodo, tipo, idgo, idnivelp, orden);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportevaluadorevaluado/{idobra}/{tipo}/{idperiodo}/{orden}")
    public List<ReportEvaluadoresEvaluados> reportesEvaluadorEvaluado(@PathVariable String idobra, @PathVariable String tipo, @PathVariable Long idperiodo, @PathVariable String orden){
        return reportesEvaluaciondes.reportEvaluadorEvaluado(idobra, tipo, idperiodo,  orden);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportestadoevaluacionevaluadorevaluado/{idobra}/{tipo}/{idperiodo}/{orden}")
    public List<ReportEstadoEvaluacionEvaluadorEvaluado> reportesEstadoEvaluacionEvaluadorEvaluado(@PathVariable String idobra, @PathVariable String tipo, @PathVariable Long idperiodo, @PathVariable String orden){

        return reportesEvaluaciondes.reportEstadoEvaluacionEvaluadorEvaluado(idobra, tipo, idperiodo,  orden);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportesnoparticipanevaldesemp/{idobra}/{idperiodo}")
    public List<ReportNoParticipan> reportesNoParticipanEvaldesemp(@PathVariable String idobra, @PathVariable Long idperiodo){

        return reportesEvaluaciondes.reportNoParticipanEvaldesemp(idobra, idperiodo);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportesindividualesevaldes/{idPersonal}/{idobra}")
    public List<ReportIndividualesEvaluacionDesemp> reportesResultadosEvalDes(@PathVariable Long idPersonal, @PathVariable String idobra){

        return reportesEvaluaciondes.reportIndividualesEvaluacionDesemp(idPersonal, idobra);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportesgeneralesevaldes/{idpersonal}/{pesoCar}/{pesoEsp}/{pesoIl}/{idobra}")
    public List<ReportGeneralEvaluacionDesemp> reportesResultadosEvalDes(@PathVariable Long idpersonal,@PathVariable Double pesoCar, @PathVariable Double pesoEsp, @PathVariable Double pesoIl,  @PathVariable String idobra){

        return reportesEvaluaciondes.reportGeneralEvaluacionDesemps(idpersonal, idobra, pesoCar, pesoEsp, pesoIl);
    }



    //Graficos
    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/graficodirectorespromedio/{idobra}/{idtipo}")
    public List<GraficosDirectoresPromedio> graficoDirectoresPromedio(@PathVariable String idobra, @PathVariable String idtipo){

        return reportesEvaluaciondes.graficoDirectoresPromedio(idobra, idtipo);
    }

}
