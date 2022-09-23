package com.spring.sigmaweb.backend.process.surveys.service;

import com.spring.sigmaweb.backend.process.core.dto.SidenavItemDTO;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.repository.IMatrizEvaluacionDao;
import com.spring.sigmaweb.backend.process.surveys.repository.IPersonalEvaluacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        List<PersonalEvaluacionDTO> result = personalevaluaciondao.findByIdObraPerevalList(idobra, idgruoocu, idpuesto, idcargo, principal);
        List<PersonalEvaluacionDTO> externos = new ArrayList<PersonalEvaluacionDTO>();
        if(idobra.equals("SECTOR")){
            externos = personalevaluaciondao.findByIdObraPerevalListExterno(idobra, idgruoocu, idpuesto, idcargo, principal);

            if(externos.size()>0){
                result.addAll(externos);
            }

        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctList(String idobra) {
        List<PersonalEvaluacionDTO> result =personalevaluaciondao.findByIdObraPerevalDistinctList(idobra);
        List<PersonalEvaluacionDTO> externos = new ArrayList<PersonalEvaluacionDTO>();
        if(idobra.equals("SECTOR")){
            externos = personalevaluaciondao.findByIdObraPerevalDistinctListExternos(idobra);
            if(externos.size()>0){
                result.addAll(externos);
            }
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalEvaluacionDTO> findByIdObraPersonallListCargosPuestos(String idobra, Long idpersonal, Integer esPrincipal) {
        List<PersonalEvaluacionDTO> result = personalevaluaciondao.findByIdObraPersonallListCargosPuestos(idobra, idpersonal, esPrincipal);
        List<PersonalEvaluacionDTO> externos = new ArrayList<PersonalEvaluacionDTO>();
        if(idobra.equals("SECTOR")){
            externos = personalevaluaciondao.findByIdObraPersonallListCargosPuestosExterno(idobra, idpersonal, esPrincipal);
            if(externos.size()>0){
                result.addAll(externos);
            }
        }
        return result;
    }

    @Override
    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctListCristoStamar(String idobra) {
        List<PersonalEvaluacionDTO> result =personalevaluaciondao.findByIdObraPerevalDistinctListCristoStamar(idobra);
        List<PersonalEvaluacionDTO> externos = new ArrayList<PersonalEvaluacionDTO>();
        String obraDep = idobra.equals("CRISTO") || idobra.equals("STAMAR") ? "SECTOR" : idobra;

        if(obraDep.equals("SECTOR")){
            externos = personalevaluaciondao.findByIdObraPerevalDistinctListExternos(obraDep);
            if(externos.size()>0){
                result.addAll(externos);
            }
        }

        return result;
    }

    //EXTERNOS
    @Override
    public List<PersonalEvaluacionDTO> findByIdObraPerevalDistinctListExternos(String idobra) {
        return personalevaluaciondao.findByIdObraPerevalDistinctListExternos(idobra);
    }
}
