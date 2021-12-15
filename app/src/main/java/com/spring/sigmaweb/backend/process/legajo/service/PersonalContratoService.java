package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import com.spring.sigmaweb.backend.process.legajo.repository.IContratoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IJornadaContratoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalContratoService implements IPersonalContratoService{
    @Autowired
    private IContratoDao contratoDao;

    @Autowired
    private IJornadaContratoDao jornadacontratoDao;


    @Override
    @Transactional(readOnly = true)
    public PersonalContrato findByIdPerCont(Long idPerCont) {
        return contratoDao.findByIdPerCont(idPerCont);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalContrato findByPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont) {
        return contratoDao.findByPersonalAndObraAndcontrato(idpersona, idobra, idpercont);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalContrato> findByPersonalAndObraList(Long idpersona, String idobra) {
        return contratoDao.findByPersonalAndObraList(idpersona, idobra);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalContratoObraDTO findByPersonalAndObraAndcontratoDto(Long idpersona, String idobra, Long idpercont) {
        return contratoDao.findByPersonalAndObraAndcontratoDto(idpersona, idobra, idpercont);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalContratoObraDTO> findByPersonalAndObraAndcontratoDtoList(Long idpersona, String idobra) {
        return contratoDao.findByPersonalAndObraAndcontratoDtoList(idpersona, idobra);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalContratoJornada findByIdPerjorn(Long idPerjorn) {
        return jornadacontratoDao.findByIdPerjorn(idPerjorn);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalContrato findByJornadaPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idperjorn) {
        return jornadacontratoDao.findByJornadaPersonalAndObraAndcontrato(idpersona, idobra, idpercont, idperjorn);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalContrato> findByJornadaPersonalAndObraAndcontratoList(Long idpersona, String idobra, Long idpercont) {
        return jornadacontratoDao.findByJornadaPersonalAndObraAndcontratoList(idpersona, idobra, idpercont);
    }

    @Override
    @Transactional(readOnly = true)
    public JornadaPersonalContratoDTO findIdJornadaPersonalAndObraAndContratoDTO(Long idpersona, String idobra, Long idpercont, Long idperjorn) {
        return jornadacontratoDao.findIdJornadaPersonalAndObraAndContratoDTO(idpersona, idobra, idpercont, idperjorn);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JornadaPersonalContratoDTO> findJornadasPersonalAndObraAndContratoDTOList(Long idpersona, String idobra, Long idpercont) {
        return jornadacontratoDao.findJornadasPersonalAndObraAndContratoDTOList(idpersona, idobra, idpercont);
    }
}
