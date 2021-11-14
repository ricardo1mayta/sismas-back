package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportCumpleaniosPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportOtrosDatosPersonal;

import java.util.List;

public interface IReportesLegajoService {

    List<ReportDirectorioPersonal> reportDirectorioPersonal(String obraname, String estadoper, String textofiltro );

    List<ReportCumpleaniosPersonal> reportCumpleaniosPersonal(String obraname, String textofiltro, Integer mes );

    List<ReportOtrosDatosPersonal> reportOtrosDatosPersonal(String obraname, String estadoper, String textofiltro );
}
