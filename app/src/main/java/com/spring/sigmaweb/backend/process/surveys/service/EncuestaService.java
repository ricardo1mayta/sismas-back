package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.legajo.reports.ReportCumpleaniosPersonal;
import com.spring.sigmaweb.backend.process.surveys.model.CierreEvaluacionDesemp;
import com.spring.sigmaweb.backend.process.surveys.model.Encuesta;
import com.spring.sigmaweb.backend.process.surveys.model.EncuestaDet;
import com.spring.sigmaweb.backend.process.surveys.model.report.ListaEvaluadosEvaluador;
import com.spring.sigmaweb.backend.process.surveys.repository.IEncuestaDao;
import com.spring.sigmaweb.backend.process.surveys.repository.IEncuestaDetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class EncuestaService implements IEncuestaService{
    @Autowired
    private IEncuestaDao encuestaDao;

    @Autowired
    private IEncuestaDetDao encuestaDetDao;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Encuesta findByIdMatrizevalEncuestaAndIdObraEncuesta(Long idMatrizevalEncuesta, String idObraEncuesta) {
        return encuestaDao.findByIdMatrizevalEncuestaAndIdObraEncuesta(idMatrizevalEncuesta, idObraEncuesta);
    }

    @Override
    public Encuesta findByIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(Long idMatrizevalEncuesta, String idObraEncuesta, Long idevento) {
        return encuestaDao.findByIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(idMatrizevalEncuesta, idObraEncuesta, idevento);
    }

    @Override
    @Transactional(readOnly = true)
    public Encuesta findByIdEncuestaAndIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(Long idEncuesta, Long idMatrizevalEncuesta, String idObraEncuesta, Long idevento){
        return encuestaDao.findByIdEncuestaAndIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(idEncuesta, idMatrizevalEncuesta, idObraEncuesta, idevento);
    }

    @Override
    @Transactional
    public Encuesta saveEncuesta(Encuesta encuesta) {
        return encuestaDao.save(encuesta);
    }

    @Override
    @Transactional
    public void deleteEncuesta(Encuesta encuesta) {
        encuestaDao.delete(encuesta);

    }

    @Override
    public boolean estadodeEncuestaBorrar(Long idEncuesta, Long idMatriz, String idObra) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_countPreguntasEvalucion");
        Boolean resultado=false;
        query.registerStoredProcedureParameter("p_idEncuesta", long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idMatrizEval", long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idObraEncuesta", String.class, ParameterMode.IN);


        query.setParameter("p_idEncuesta", idEncuesta);
        query.setParameter("p_idMatrizEval", idMatriz);
        query.setParameter("p_idObraEncuesta", idObra);

        List<Boolean> result = query.getResultList();

        if(result != null){
            if(result.size()>0){
                resultado= Boolean.parseBoolean(result.get(0) + "");
            } else {
                resultado=true;
            }
        } else {
            resultado = true;
        }
        return resultado;
    }

    @Override
    public List<ListaEvaluadosEvaluador> listaEvaluadosEvaluador(String idObra, Long idPersonal, Long idEvento) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_lista_evaluados_x_evaluador","ListaEvaluadosEvaluador");

        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_id_personal", long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idevento", long.class, ParameterMode.IN);


        query.setParameter("p_obra", idObra);
        query.setParameter("p_id_personal", idPersonal);
        query.setParameter("p_idevento", idEvento);

        List<ListaEvaluadosEvaluador> result = query.getResultList();

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean findEstadoCierreEvaluacion(String idobra, Long idevento) {
        CierreEvaluacionDesemp result = encuestaDao.findEstadoCierreEvaluacion(idobra, idevento);
        Boolean estado = false;

        if(result == null){
            estado = false;
        } else {
            estado=true;
        }
        return estado;
    }

    //detalle de encuesta
    @Override
    @Transactional
    public void saveEncuestaDet(List<EncuestaDet> encuestadet) {
         encuestaDetDao.saveAll(encuestadet);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EncuestaDet> findByIdEncuestaEncdetAndIdObraEncdet(Long idencuestaencdet, String idobraencdet) {
        return encuestaDetDao.findByIdEncuestaEncdetAndIdObraEncdet(idencuestaencdet, idobraencdet);
    }
}
