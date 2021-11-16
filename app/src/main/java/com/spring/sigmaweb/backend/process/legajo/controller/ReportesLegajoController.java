package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportCumpleaniosPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportFamiliaresPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportOtrosDatosPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportProgresoActualizacionPersonal;
import com.spring.sigmaweb.backend.process.legajo.service.IReportesLegajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/reportes")
public class ReportesLegajoController {

    @Autowired
    private IReportesLegajoService reportelegajoService;

    @Secured({"ROLE_ADMI", "ROLE_RRHH"})
    @GetMapping("/reportdirectoriolegajo/{obraname}/{estadoper}/{textofiltro}")
    public List<ReportDirectorioPersonal> reportDirectorioLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable String textofiltro){
        return reportelegajoService.reportDirectorioPersonal(obraname, estadoper, textofiltro);
    }

    @Secured({"ROLE_ADMI", "ROLE_RRHH"})
    @GetMapping("/reportcumpleanioslegajo/{obraname}/{textofiltro}/{mes}")
    public List<ReportCumpleaniosPersonal> reportDirectorioLegajo(@PathVariable String obraname, @PathVariable String textofiltro, @PathVariable Integer mes ){
        return reportelegajoService.reportCumpleaniosPersonal(obraname,textofiltro,mes);
    }

    @Secured({"ROLE_ADMI", "ROLE_RRHH"})
    @GetMapping("/reportotrosdatoslegajo/{obraname}/{estadoper}/{textofiltro}")
    public List<ReportOtrosDatosPersonal> reportOtrosDatosLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable String textofiltro ){
        return reportelegajoService.reportOtrosDatosPersonal(obraname,estadoper,textofiltro);
    }

    @Secured({"ROLE_ADMI", "ROLE_RRHH"})
    @GetMapping("/reportprogresoactualizacionlegajo/{obraname}/{estadoper}/{estadoaut}/{fechaInicio}/{fechaFin}")
    public List<ReportProgresoActualizacionPersonal> reportProgesoActualizacionLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable String estadoaut, @PathVariable String fechaInicio, @PathVariable String fechaFin){
        return reportelegajoService.reportProgresoActualizacionPersonal(obraname,estadoper, estadoaut,fechaInicio, fechaFin);
    }

    @Secured({"ROLE_ADMI", "ROLE_RRHH"})
    @GetMapping("/reportfamiliareslegajo/{obraname}/{estadoper}/{idparentesco}")
    public List<ReportFamiliaresPersonal> reportListaFamilaiesLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable Integer idparentesco){
        return reportelegajoService.reportListaFamiliaresPersonal(obraname, estadoper,idparentesco);
    }

}
