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

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    @Override
    @Transactional
    public void deletePersonalContrato(PersonalContrato contrato) {
        contratoDao.delete(contrato);
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
    public List<ReportContract> reportContratosPorObra(String idobra, Integer estadoper, Integer grupoocacional, Integer tipoplanilla, Integer idtipocontrato, Integer periodoIni, Integer periodoFin) {

        Sort sortContrato = Sort.by(Sort.Direction.ASC, "tcont.descripTab");
        Sort sortApepat = Sort.by(Sort.Direction.ASC, "psn.apePaternoPers");
        Sort sortApeMat = Sort.by(Sort.Direction.ASC, "psn.apeMaternoPers");
        Sort sortNombres = Sort.by(Sort.Direction.ASC, "psn.nombrePers");
        Sort sortPlanilla = Sort.by(Sort.Direction.ASC, "tgrpl.descripTab");
        Sort sortOcupacional = Sort.by(Sort.Direction.ASC, "tgroc.descripTab");
        Sort grupSort = null;

        if(tipoplanilla==0 && idtipocontrato == 0 ) {
            grupSort = sortContrato.and(sortApepat.and(sortApeMat.and(sortNombres)));
        } else if(grupoocacional == -1 && idtipocontrato == -1){
            grupSort = sortOcupacional.and(sortContrato);
        } else if(tipoplanilla!=0 && idtipocontrato == 0){
            grupSort = sortContrato.and(sortPlanilla.and(sortOcupacional.and(sortApeMat.and(sortNombres))));
        } else if(tipoplanilla==0 && idtipocontrato != 0){
            grupSort = sortContrato.and(sortOcupacional.and(sortPlanilla.and(sortApepat.and(sortApeMat.and(sortNombres)))));
        } else if(tipoplanilla !=0 && idtipocontrato != 0){
            grupSort = sortContrato.and(sortPlanilla.and(sortOcupacional.and(sortApepat.and(sortApeMat.and(sortNombres)))));
        }

        Integer tipoGrupo = (grupoocacional == -1 ? 0 :grupoocacional);
        Integer tipoCont = (idtipocontrato == -1 ? 0 : idtipocontrato);

        List<ReportContract> dataReport = contratoDao.reportContratosPorObra(idobra, estadoper, tipoGrupo, tipoplanilla,tipoCont, periodoIni,periodoFin, grupSort);
        List<HistoricoVilaLabotalDTO> dataAct = new ArrayList<>();

        if(tipoplanilla != -1 && idtipocontrato != -1){
            for (ReportContract c : dataReport) {

                dataAct= historicovinculolaboralDao.findByUltimoCambioHistoricoVidaLab(idobra,c.getIdPersonal(),c.getIdPervila(),c.getIdPerCont(), "JORN");
                if(dataAct.size() > 0){
                    c.setJornadaSemanalAct(dataAct.get(0).getJornadaSemaNewHistvila());
                }
                dataAct.clear();
                dataAct= historicovinculolaboralDao.findByUltimoCambioHistoricoVidaLab(idobra,c.getIdPersonal(),c.getIdPervila(),c.getIdPerCont(), "REMU");
                if(dataAct.size() > 0){
                    c.setRemuneracionPerAct(dataAct.get(0).getRemuneracionNewHistvila());
                }
                dataAct.clear();
            }
        }

        return dataReport;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReportContract> reportContratosHistoricoPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipocontrato, String textolike, Integer periodoIni, Integer periodoFin) {
        return contratoDao.reportContratosHistoricoPorObra(idobra,estadoper,tipogrupo,tipoplanilla,idtipocontrato,textolike, periodoIni, periodoFin);
    }

    @Override
    @Transactional(readOnly = true)
    public HistoricoVilaLabotalDTO findByUltimoCambioHistoricoVidaLab(String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipo) {

        List<HistoricoVilaLabotalDTO> all = historicovinculolaboralDao.findByUltimoCambioHistoricoVidaLab(idObraHistvila, idPersonalHistvila, idPervilaHistvila, idPercontHistvila, tipo);
        if(all.size()>0){
            return all.get(0);
        } else {
            return null;
        }

    }

    @Override
    @Transactional(readOnly = true)
    public HistoricoVilaLabotalDTO findByUltimoCambioHistoricoVidaLabMasActual(String idObraHistvila, Long idPersonalHistvila, Long idPervilaHistvila, Long idPercontHistvila, String tipo, Integer periodoIni, Integer periodoFin) {


        List<HistoricoVilaLabotalDTO> all = historicovinculolaboralDao.findByUltimoCambioHistoricoVidaLabActual(idObraHistvila, idPersonalHistvila, idPervilaHistvila, idPercontHistvila, tipo, periodoIni, periodoFin);

        if(all.size()>0){
            return all.get(0);
        } else {
            return null;
        }

    }

}
