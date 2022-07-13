package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.repository.IMatrizEvaluacionDao;
import com.spring.sigmaweb.backend.process.surveys.repository.IPersonalEvaluacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalEvaluacionService implements IPersonalEvaluacionService {
    @Autowired
    private IPersonalEvaluacionDao personalevaluaciondao;

    @Autowired
    IMatrizEvaluacionDao matrizEvaluacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<PersonalEvaluacionDTO> findByIdObraPerevalList(String idobra, Integer idgruoocu , Long idpuesto, Long idcargo, Integer principal) {
        return personalevaluaciondao.findByIdObraPerevalList(idobra, idgruoocu, idpuesto, idcargo, principal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctList(String idobra) {
        return personalevaluaciondao.findByIdObraPerevalDistinctList(idobra);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalEvaluacionDTO> findByIdObraPersonallListCargosPuestos(String idobra, Long idpersonal, Integer esPrincipal) {

         return personalevaluaciondao.findByIdObraPersonallListCargosPuestos(idobra, idpersonal, esPrincipal);
    }
}
