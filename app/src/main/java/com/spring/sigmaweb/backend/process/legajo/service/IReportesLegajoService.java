package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportCumpleaniosPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportFamiliaresPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportOtrosDatosPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportProgresoActualizacionPersonal;

import java.util.List;

public interface IReportesLegajoService {

    List<ReportDirectorioPersonal> reportDirectorioPersonal(String obraname, String estadoper, String textofiltro );

    List<ReportCumpleaniosPersonal> reportCumpleaniosPersonal(String obraname, String textofiltro, Integer mes );

    List<ReportOtrosDatosPersonal> reportOtrosDatosPersonal(String obraname, String estadoper, String textofiltro );

    List<ReportProgresoActualizacionPersonal> reportProgresoActualizacionPersonal(String obraname, String estadoper, String estadoaut, String fechaInicio, String fechaFin );

    List<ReportFamiliaresPersonal> reportListaFamiliaresPersonal(String obraname, String estadoper, Integer idparentesco);
}
