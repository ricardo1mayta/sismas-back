package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.repository.IMatrizEvaluacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class MatrizEvaluadorService implements IMatrizEvaluadorService{
    @Autowired
    private IMatrizEvaluacionDao matrizEvaluadordao;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public MatrizEvaluacion findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(String idobra, Long idmatrizeval, Long Idperiodomaev, Long ideventomaev) {
        return matrizEvaluadordao.findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(idobra, idmatrizeval, Idperiodomaev, ideventomaev);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluador(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal) {
        return matrizEvaluadordao.findListaByObraByPeriodoByEventoidByEvaluador(idobra, idpersonal, idcargoPuesto, esPrincipal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatrizEvaluacionDTO> findListaByObraByPeriodoByEventoidByEvaluado(String idobra, Long idpersonal, Long idcargoPuesto, Boolean esPrincipal) {
        System.out.println(idobra);
        System.out.println(idpersonal);
        System.out.println(idcargoPuesto);
        System.out.println(esPrincipal);

        return matrizEvaluadordao.findListaByObraByPeriodoByEventoidByEvaluado(idobra, idpersonal, idcargoPuesto, esPrincipal);
    }

    @Override
    @Transactional
    public MatrizEvaluacion saveMatrizEvaluacion(MatrizEvaluacion matriz) {
        return matrizEvaluadordao.save(matriz);
    }

    @Override
    @Transactional
    public void deleteMatrizEvaluador(MatrizEvaluacion matriz) {
        matrizEvaluadordao.delete(matriz);
    }

    @Override
    public Integer spuCountEvaluadoresEvaluado(String idobra, Long idpersonal, Long idpuestocargo, Boolean esprincipal) {
        Integer resultado=0;
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_countEvaluadores_x_evaluador");
        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_id_personal", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_id_cargopuesto", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_esprincipal", Boolean.class, ParameterMode.IN);

        query.setParameter("p_obra", idobra);
        query.setParameter("p_id_personal", idpersonal);
        query.setParameter("p_id_cargopuesto", idpuestocargo);
        query.setParameter("p_esprincipal", esprincipal);


        List<Integer> result = query.getResultList();
        if(result != null){
            if(result.size()>0){
                resultado= Integer.parseInt(result.get(0) + "");
            } else {
                resultado=0;
            }

        } else{
            resultado= -1;
        }

        return resultado;
    }

    @Override
    @Transactional
    public List<MatrizEvaluacion> contarEvaluadoresEvaluado(String idobra, Long idevaluador, Long idevaluado) {
        return matrizEvaluadordao.contarEvaluadoresEvaluado(idobra, idevaluador, idevaluado);
    }
}
