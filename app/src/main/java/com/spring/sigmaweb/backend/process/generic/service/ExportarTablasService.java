package com.spring.sigmaweb.backend.process.generic.service;

import com.spring.sigmaweb.backend.process.generic.model.CamposTablaExportar;
import com.spring.sigmaweb.backend.process.generic.repository.ICampoTablaExportarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class ExportarTablasService implements IExportarTablasService{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ICampoTablaExportarDao campotablaExportDao;

    @Transactional
    @Override
    public List<Object> exportTablaLegajo(String obraname, String opcion, String selectsql, String fromsql, String wheresql) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_exportTablas");
        query.registerStoredProcedureParameter("p_unineg", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_opcion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_selectSql", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_fromSql", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_whereSql", String.class, ParameterMode.IN);



        query.setParameter("p_unineg", obraname);
        query.setParameter("p_opcion", opcion);
        query.setParameter("p_selectSql", selectsql);
        query.setParameter("p_fromSql", fromsql);
        query.setParameter("p_whereSql", wheresql);

        return query.getResultList();
    }

    @Override
    public List<CamposTablaExportar> findByIdGrupoCampoAndEstadoCampo(String idgrupo, Boolean estadocampo) {
        return campotablaExportDao.findByIdGrupoCampoAndEstadoCampo(idgrupo, estadocampo);
    }
}
