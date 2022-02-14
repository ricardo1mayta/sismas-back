package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalVidaLabDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalVidaLaboral;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalVidaLaboralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalVidaLaboralService implements IPersonalVidaLaboralService{
    @Autowired
    IPersonalVidaLaboralDao personalVidaLaboralDao;


    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLaboral findByIdPervilaAndIdObraPervila(Long idPervila, String idObraPervila) {
        return personalVidaLaboralDao.findByIdPervilaAndIdObraPervila(idPervila, idObraPervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLaboral findByObraPersonalId(String idobra, Long idpersonal, Long idpervila) {
        return personalVidaLaboralDao.findByObraPersonalId(idobra, idpersonal, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalVidaLaboral> findByObraPersonalEstado(String idobra, Long idpersonal, String estado) {
        return personalVidaLaboralDao.findByObraPersonalEstado(idobra, idpersonal, estado);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLabDTO findByObraPersonalIdDTO(String idobra, Long idpersonal, Long idpervila) {
        return personalVidaLaboralDao.findByObraPersonalIdDTO(idobra, idpersonal, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalVidaLabDTO ultimoPeriodoVidaLaboral(String idobra, Long idpersonal) {

        List<PersonalVidaLabDTO> vidaLabList = personalVidaLaboralDao.findByObraPersonalListDTO(idobra, idpersonal);
        PersonalVidaLabDTO vidaLabRtn = new PersonalVidaLabDTO();
        /*Integer countR=0;*/
        if(vidaLabList.size() < 1) {
            return null;
        } else {
            /*countR = vidaLabList.size();*/

            vidaLabRtn = vidaLabList.get(0);
        }
        return vidaLabRtn;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalVidaLabDTO> findByObraPersonalListDTO(String idobra, Long idpersonal) {

        return personalVidaLaboralDao.findByObraPersonalListDTO(idobra, idpersonal);
    }

    @Override
    @Transactional
    public PersonalVidaLaboral save(PersonalVidaLaboral vidalaboral) {
        return personalVidaLaboralDao.save(vidalaboral);
    }
}
