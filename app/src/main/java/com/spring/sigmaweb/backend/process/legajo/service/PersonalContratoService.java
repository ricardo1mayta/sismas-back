package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistoricoVinculoLaboral;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportContract;
import com.spring.sigmaweb.backend.process.legajo.repository.IContratoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IJornadaContratoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalHistoricoVinculoLaboralDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public List<PersonalContrato> findByActivosPersonalAndObraList(Long idpersona, String idobra, Long idpervila) {
        return contratoDao.findByActivosPersonalAndObraList(idpersona, idobra, idpervila);
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
    @Transactional(readOnly = true)
    public PersonalContratoObraDTO findAnteriorContratoPersonalVidaLaboralObra(Long idpersona, String idobra, Long idpervila, Long idpercont, Date fechaini) {
        PersonalContratoObraDTO vidaLabRtn = new PersonalContratoObraDTO();
        List<PersonalContratoObraDTO> data = contratoDao.findAnteriorContratoPersonalVidaLaboralObra(idpersona, idobra, idpervila, idpercont, fechaini);
        if(data.size() > 0){
            vidaLabRtn = data.get(0);
            return vidaLabRtn;
        }

        return null;
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

    @Override
    @Transactional(readOnly = true)
    public List<ReportContract> reportContratosPorObra(String idobra, Integer estadoper, Integer grupoocacional, Integer tipoplanilla, Integer idtipocontrato) {
        Sort sortContrato = Sort.by(Sort.Direction.ASC, "tcont.descripTab");
        Sort sortApepat = Sort.by(Sort.Direction.ASC, "psn.apePaternoPers");
        Sort sortApeMat = Sort.by(Sort.Direction.ASC, "psn.apeMaternoPers");
        Sort sortNombres = Sort.by(Sort.Direction.ASC, "psn.nombrePers");
        Sort sortPlanilla = Sort.by(Sort.Direction.ASC, "tgrpl.descripTab");
        Sort sortOcupacional = Sort.by(Sort.Direction.ASC, "tgroc.descripTab");
        Sort grupSort = null;

        if(tipoplanilla==0 && idtipocontrato == 0 ){
            grupSort = sortContrato.and(sortApepat.and(sortApeMat.and(sortNombres)));
        } else if(tipoplanilla!=0 && idtipocontrato == 0){
            grupSort = sortContrato.and(sortPlanilla.and(sortOcupacional.and(sortApeMat.and(sortNombres))));
        } else if(tipoplanilla==0 && idtipocontrato != 0){
            grupSort = sortContrato.and(sortOcupacional.and(sortPlanilla.and(sortApepat.and(sortApeMat.and(sortNombres)))));
        } else if(tipoplanilla !=0 && idtipocontrato != 0){
            grupSort = sortContrato.and(sortPlanilla.and(sortOcupacional.and(sortApepat.and(sortApeMat.and(sortNombres)))));
        }
        return contratoDao.reportContratosPorObra(idobra, estadoper, grupoocacional, tipoplanilla,idtipocontrato, grupSort);
    }

}
