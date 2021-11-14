package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportCumpleaniosPersonal;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportOtrosDatosPersonal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ReportesLegajoService implements IReportesLegajoService{


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ReportDirectorioPersonal> reportDirectorioPersonal(String obraname, String estadoper, String textofiltro) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_directorioPersonal", "ReportDirectorioPersonal");
        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_textfilter", String.class, ParameterMode.IN);

        query.setParameter("p_obra", obraname);
        query.setParameter("p_estado", estadoper);
        query.setParameter("p_textfilter", textofiltro);

        List<ReportDirectorioPersonal> result = query.getResultList();
        return result;
    }

    @Override
    public List<ReportCumpleaniosPersonal> reportCumpleaniosPersonal(String obraname, String textofiltro, Integer mes) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_cumpleaniosColaborador", "ReportCumpleaniosPersonal");

        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_textfilter", String.class, ParameterMode.IN);

        query.setParameter("p_obra", obraname);
        query.setParameter("p_textfilter", textofiltro);
        query.setParameter("p_estado", mes);

        List<ReportCumpleaniosPersonal> result = query.getResultList();

        return result;
    }

    @Override
    public List<ReportOtrosDatosPersonal> reportOtrosDatosPersonal(String obraname, String estadoper, String textofiltro) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_otrosDatosPersonal", "ReportOtrosDatosPersonal");

        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_estado", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_textfilter", String.class, ParameterMode.IN);

        query.setParameter("p_obra", obraname);
        query.setParameter("p_estado", estadoper);
        query.setParameter("p_textfilter", textofiltro);

        List<ReportOtrosDatosPersonal> result = query.getResultList();

        return result;
    }
}
