package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistoricoVinculoLaboral;
import com.spring.sigmaweb.backend.process.legajo.repository.IContratoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IJornadaContratoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalHistoricoVinculoLaboralDao;
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

    @Autowired
    private IPersonalHistoricoVinculoLaboralDao historicovinculolaboralDao;


    @Override
    @Transactional(readOnly = true)
    public PersonalContrato findByIdPerCont(Long idPerCont) {
        return contratoDao.findByIdPerCont(idPerCont);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalContrato findByPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idpervila) {
        return contratoDao.findByPersonalAndObraAndcontrato(idpersona, idobra, idpercont, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalContrato> findByPersonalAndObraList(Long idpersona, String idobra, Long idpervila) {
        return contratoDao.findByPersonalAndObraList(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalContratoObraDTO findByPersonalAndObraAndcontratoDto(Long idpersona, String idobra, Long idpercont, Long idpervila) {
        return contratoDao.findByPersonalAndObraAndcontratoDto(idpersona, idobra, idpercont, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalContratoObraDTO> findByPersonalAndObraAndcontratoDtoList(Long idpersona, String idobra, Long idpervila) {
        return contratoDao.findByPersonalAndObraAndcontratoDtoList(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalContratoObraDTO> findContratoActivoPersonalObra(Long idpersona, String idobra, Long idpervila) {
        return contratoDao.findContratoActivoPersonalObra(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional
    public PersonalContrato save(PersonalContrato contrato) {
        return contratoDao.save(contrato);
    }


    //********************************************************************************

    @Override
    @Transactional(readOnly = true)
    public PersonalContratoJornada findByIdPerjorn(Long idPerjorn) {
        return jornadacontratoDao.findByIdPerjorn(idPerjorn);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalContratoJornada findByJornadaPersonalAndObraAndcontrato(Long idpersona, String idobra, Long idpercont, Long idperjorn) {
        return jornadacontratoDao.findByJornadaPersonalAndObraAndcontrato(idpersona, idobra, idpercont, idperjorn);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalContratoJornada> findByJornadaPersonalAndObraAndcontratoList(Long idpersona, String idobra, Long idpercont) {
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

    @Override
    @Transactional
    public void deleteAll(List<PersonalContratoJornada> jornadas) {
        jornadacontratoDao.deleteAll(jornadas);
    }

    @Override
    @Transactional
    public void delete(PersonalContratoJornada jornada) {
        jornadacontratoDao.delete(jornada);
    }

    @Override
    @Transactional
    public PersonalContratoJornada save(PersonalContratoJornada jornada) {
        return jornadacontratoDao.save(jornada);
    }

    //historico contrato

    @Override
    @Transactional(readOnly = true)
    public PersonalHistoricoVinculoLaboral findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPercontHistvilaAndIdHistvila(String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, Long idHistvila) {
        return historicovinculolaboralDao.findByIdObraHistvilaAndIdPersonalHistvilaAndIdPervilaHistvilaAndIdPercontHistvilaAndIdHistvila(idObraHistvila, idPersonalHistvila, idPervilaHistvila, idPercontHistvila, idHistvila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalHistoricoVinculoLaboral> findByObraAndPersonalAndVidaLabAndContratoAndtipoList(String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipoHistvila) {
        return historicovinculolaboralDao.findByObraAndPersonalAndVidaLabAndContratoAndtipoList(idObraHistvila, idPersonalHistvila, idPervilaHistvila, idPercontHistvila, tipoHistvila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoricoVilaLabotalDTO> findByObraAndPersonalAndVidaLabAndContratoAndtipoListDto(String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipoHistvila) {
        return historicovinculolaboralDao.findByObraAndPersonalAndVidaLabAndContratoAndtipoListDto(idObraHistvila, idPersonalHistvila, idPervilaHistvila, idPercontHistvila, tipoHistvila);
    }

    @Override
    @Transactional
    public PersonalHistoricoVinculoLaboral saveHistVidaLab(PersonalHistoricoVinculoLaboral historico) {
        return historicovinculolaboralDao.save(historico);
    }
}
