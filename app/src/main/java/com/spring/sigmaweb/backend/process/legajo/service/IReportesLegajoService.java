package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.*;

import java.util.List;

public interface IReportesLegajoService {

    List<ReportDirectorioPersonal> reportDirectorioPersonal(String obraname, String estadoper, String textofiltro );

    List<ReportCumpleaniosPersonal> reportCumpleaniosPersonal(String obraname, String textofiltro, Integer mes );

    List<ReportOtrosDatosPersonal> reportOtrosDatosPersonal(String obraname, String estadoper, String textofiltro );

    List<ReportProgresoActualizacionPersonal> reportProgresoActualizacionPersonal(String obraname, String estadoper, String estadoaut, String fechaInicio, String fechaFin );

    List<ReportFamiliaresPersonal> reportListaFamiliaresPersonal(String obraname, String estadoper, Integer idparentesco);

    List<ReportListAsignacionFamiliar> reportListaAsignacionFamiliarPersonal(String obraname, String estadoper, String tipoasig );

    List<ReporteListaHijosPersonal> reportListaHijosPersonal(String obraname, String estadoper);

    List<ReportEntidadesEPSPersonal> reportListaEntEPSPersonal(String obraname, String estadoper, Integer identidad);

    List<ReportentidadesPensionPersonal> reportListaEntPensionPersonal(String obraname, String estadoper, Integer tipopens, Integer identidad);

}
