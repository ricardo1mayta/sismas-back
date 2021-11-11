package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;

import java.util.List;

public interface IReportesLegajoService {
    List<ReportDirectorioPersonal> reportDirectorioPersonal(String obraname, String estadoper, String textofiltro );
}
