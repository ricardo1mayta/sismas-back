package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.surveys.model.report.ReportCountEvaluacionesEvalDes;
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

}
