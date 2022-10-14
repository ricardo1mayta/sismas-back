package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.*;
import com.spring.sigmaweb.backend.process.legajo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/reportes")
public class ReportesLegajoController {

    @Autowired
    private IReportesLegajoService reportelegajoService;

    @Autowired
    private IPersonalContratoService personalcontratoservice;

    @Autowired
    private IPersonalConvenioService personalconvenioservice;

    @Autowired
    private IPersonalPuestoService personalpuestoservice;

    @Autowired
    private IPersonalDesvinculacionService desvinculacionService;

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportdirectoriolegajo/{obraname}/{estadoper}/{textofiltro}")
    public List<ReportDirectorioPersonal> reportDirectorioLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable String textofiltro){
        return reportelegajoService.reportDirectorioPersonal(obraname, estadoper, textofiltro);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportcumpleanioslegajo/{obraname}/{textofiltro}/{mes}")
    public List<ReportCumpleaniosPersonal> reportDirectorioLegajo(@PathVariable String obraname, @PathVariable String textofiltro, @PathVariable Integer mes ){
        return reportelegajoService.reportCumpleaniosPersonal(obraname,textofiltro,mes);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportotrosdatoslegajo/{obraname}/{estadoper}/{textofiltro}")
    public List<ReportOtrosDatosPersonal> reportOtrosDatosLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable String textofiltro ){
        return reportelegajoService.reportOtrosDatosPersonal(obraname,estadoper,textofiltro);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportprogresoactualizacionlegajo/{obraname}/{estadoper}/{estadoaut}/{fechaInicio}/{fechaFin}")
    public List<ReportProgresoActualizacionPersonal> reportProgesoActualizacionLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable String estadoaut, @PathVariable String fechaInicio, @PathVariable String fechaFin){
        return reportelegajoService.reportProgresoActualizacionPersonal(obraname,estadoper, estadoaut,fechaInicio, fechaFin);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportfamiliareslegajo/{obraname}/{estadoper}/{idparentesco}")
    public List<ReportFamiliaresPersonal> reportListaFamilaiesLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable Integer idparentesco){
        return reportelegajoService.reportListaFamiliaresPersonal(obraname, estadoper,idparentesco);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportListaasigfamilarlegajo/{obraname}/{estadoper}/{tipoasig}")
    public List<ReportListAsignacionFamiliar> reportListaAsigFamilarLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable String tipoasig){
        return reportelegajoService.reportListaAsignacionFamiliarPersonal(obraname, estadoper, tipoasig);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportListahijoslegajo/{obraname}/{estadoper}")
    public List<ReporteListaHijosPersonal> reportListaHijosLegajo(@PathVariable String obraname, @PathVariable String estadoper){
        return reportelegajoService.reportListaHijosPersonal(obraname, estadoper);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportListaentepslegajo/{obraname}/{estadoper}/{identidad}")
    public List<ReportEntidadesEPSPersonal> reportListaEntEPSLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable Integer identidad){
        return reportelegajoService.reportListaEntEPSPersonal(obraname, estadoper, identidad);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportListaentpensionlegajo/{obraname}/{estadoper}/{tipopens}/{identidad}")
    public List<ReportentidadesPensionPersonal> reportListaEntPensionLegajo(@PathVariable String obraname, @PathVariable String estadoper, @PathVariable Integer tipopens, @PathVariable Integer identidad){
        return reportelegajoService.reportListaEntPensionPersonal(obraname, estadoper, tipopens, identidad);
    }

    //========================= REPORTES CONTRATOS & CONVENIOS =========================
    //============================================================
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportcontratoObra/{idobra}/{estado}/{grupoocacional}/{tipoplanilla}/{idtipocontrato}/{periodoIni}/{periodoFin}")
    public List<ReportContract> reporteContratosPorObra(@PathVariable String idobra, @PathVariable Integer estado, @PathVariable Integer grupoocacional, @PathVariable Integer tipoplanilla, @PathVariable Integer idtipocontrato, @PathVariable Integer periodoIni, @PathVariable Integer periodoFin){
        return personalcontratoservice.reportContratosPorObra(idobra,estado, grupoocacional, tipoplanilla, idtipocontrato, periodoIni, periodoFin);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reporthistoricocontratoobra/{idobra}/{estado}/{grupoocacional}/{tipoplanilla}/{idtipocontrato}/{textolike}/{periodoini}/{periodofin}")
    public List<ReportContract> reporteHistoricoContratosPorObra(@PathVariable String idobra, @PathVariable Integer estado, @PathVariable Integer grupoocacional, @PathVariable Integer tipoplanilla, @PathVariable Integer idtipocontrato, @PathVariable String textolike, @PathVariable Integer periodoini, @PathVariable Integer periodofin){
        String texto = textolike.equals("_") ? "": textolike.trim();
        return personalcontratoservice.reportContratosHistoricoPorObra(idobra,estado, grupoocacional, tipoplanilla, idtipocontrato, texto, periodoini, periodofin);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportconveniosObra/{idobra}/{estado}/{grupoocacional}/{tipoplanilla}/{idtipoconvenio}/{periodoini}/{periodofin}")
    public List<ReportAgreement> reporteConveniosPorObra(@PathVariable String idobra, @PathVariable Integer estado, @PathVariable Integer grupoocacional, @PathVariable Integer tipoplanilla, @PathVariable Integer idtipoconvenio, @PathVariable Integer periodoini, @PathVariable Integer periodofin){
        return personalconvenioservice.reportConveniosPorObra(idobra,estado, grupoocacional, tipoplanilla, idtipoconvenio, periodoini, periodofin);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportconvenioscolaborador/{idobra}/{estado}/{grupoocacional}/{tipoplanilla}/{idtipoconvenio}/{periodoini}/{periodofin}")
    public List<ReportAgreement> reporteConveniosPorColaborador(@PathVariable String idobra, @PathVariable Integer estado, @PathVariable Integer grupoocacional, @PathVariable Integer tipoplanilla, @PathVariable Integer idtipoconvenio, @PathVariable Integer periodoini, @PathVariable Integer periodofin){
        return personalconvenioservice.reportConveniosPorColaborador(idobra,estado, grupoocacional, tipoplanilla, idtipoconvenio, periodoini, periodofin);
    }

    //========================= REPORTES PUESTOS Y CARGOS =========================
    //============================================================

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportpuestoscargoscolaborador/{idobra}/{estado}/{grupoocacional}/{tipoplanilla}/{idtipopuesto}/{ordenOpcion}/{periodoIni}/{periodoFin}")
    public List<ReportPuestosCargos> reportePuestosCargosPorColaborador(@PathVariable String idobra, @PathVariable Integer estado, @PathVariable Integer grupoocacional, @PathVariable Integer tipoplanilla, @PathVariable Integer idtipopuesto, @PathVariable String ordenOpcion, @PathVariable Integer periodoIni, @PathVariable Integer periodoFin){
        return personalpuestoservice.reportPuestosCargosPorObra(idobra,estado, grupoocacional, tipoplanilla, idtipopuesto,ordenOpcion, periodoIni, periodoFin, false);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportpuestoscargoscolaboradormasboni/{idobra}/{estado}/{grupoocacional}/{tipoplanilla}/{idtipopuesto}/{ordenOpcion}/{periodoIni}/{periodoFin}")
    public List<ReportPuestosCargos> reportePuestosCargosPorColaboradorMasBoni(@PathVariable String idobra, @PathVariable Integer estado, @PathVariable Integer grupoocacional, @PathVariable Integer tipoplanilla, @PathVariable Integer idtipopuesto, @PathVariable String ordenOpcion, @PathVariable Integer periodoIni, @PathVariable Integer periodoFin){
        return personalpuestoservice.reportPuestosCargosPorObra(idobra,estado, grupoocacional, tipoplanilla, idtipopuesto,ordenOpcion, periodoIni, periodoFin, true);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportpuestoscargosidpersonalobra/{idobra}/{idPersonal}")
    public List<ReportPuestosCargos> reportePuestosCargosPorColaborador(@PathVariable String idobra, @PathVariable Long idPersonal){
        return personalpuestoservice.reportPuestosCargosPorPersonalObra(idobra, idPersonal);
    }

    //REPORTES DESVINCULACION
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportelistadesvinculaciones/{idobra}/{estadoper}/{tipogrupo}/{tipoplanilla}/{tipoDesvinculacion}/{fechaini}/{Fechafin}/{ordenOpcion}")
    public List<ReportDesvinculacion> showReporteDesvinculaciones(@PathVariable String idobra, @PathVariable Integer estadoper, @PathVariable Integer tipogrupo, @PathVariable Integer tipoplanilla, @PathVariable Integer tipoDesvinculacion, @PathVariable String fechaini, @PathVariable String Fechafin, @PathVariable String ordenOpcion){


        return desvinculacionService.reportDesvinculacionesColaborador(idobra, estadoper, tipogrupo, tipoplanilla, tipoDesvinculacion, Integer.parseInt(fechaini), Integer.parseInt(Fechafin), ordenOpcion);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportechecklistdesvinculaciones/{idobra}/{estadoper}/{tipogrupo}/{tipoplanilla}/{tipoDesvinculacion}/{fechaini}/{Fechafin}/{estadoEntrega}/{ordenOpcion}")
    public List<ReportDesvinculacion> showReportesCheckListDesviculaciones(@PathVariable String idobra, @PathVariable Integer estadoper, @PathVariable Integer tipogrupo, @PathVariable Integer tipoplanilla, @PathVariable Integer tipoDesvinculacion, @PathVariable String fechaini, @PathVariable String Fechafin, @PathVariable Integer estadoEntrega, @PathVariable String ordenOpcion){
        return desvinculacionService.reportDesvinculacionesChecklistColaborador(idobra, estadoper, tipogrupo, tipoplanilla, tipoDesvinculacion, Integer.parseInt(fechaini), Integer.parseInt(Fechafin), estadoEntrega, ordenOpcion);
    }


}
