package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.surveys.model.report.ReportCountEvaluacionesEvalDes;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.*;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class ReportesEvaluacionDesService implements IReportesEvaluacionDesService{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ReportCountEvaluacionesEvalDes> reportCountEvaluaciones(String idobra, Long idperiodo, String tipo, Long idgo, Long idnivelp, String orden) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_reportCountEvaluadoEvaluador", "ReportCountEvaluacionesEvalDes");
        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idperiodo", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_tipo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idgrupo_ocu", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idtipoplanilla", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_orden", String.class, ParameterMode.IN);


        query.setParameter("p_obra", idobra);
        query.setParameter("p_idperiodo", idperiodo);
        query.setParameter("p_tipo", tipo);
        query.setParameter("p_idgrupo_ocu", idgo);
        query.setParameter("p_idtipoplanilla", idnivelp);
        query.setParameter("p_orden", orden);


        List<ReportCountEvaluacionesEvalDes> result = query.getResultList();

        return result;
    }
}
