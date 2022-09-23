package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.legajo.dto.HistoricoVilaLabotalDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalPuesto;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportPuestosCargos;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalHistoricoVinculoLaboralDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalPuestoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalPuestoService implements IPersonalPuestoService{

    @Autowired
    private IPersonalPuestoDao personalpuestoDao;

    @Autowired
    private IPersonalHistoricoVinculoLaboralDao historicovinculolaboralDao;

    @Override
    @Transactional(readOnly = true)
    public List<PersonalPuesto> findByIdPersonalAndIdobraAndIdPervila(Long idpersona, String idobra, Long idpervila) {
        return personalpuestoDao.findByIdPersonalAndIdobraAndIdPervila(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalPuesto findByIdPersonalAndIdobraAndIdPervilaAndId(Long idpersona, String idobra, Long idpervila, Long idperpuesto) {
        return personalpuestoDao.findByIdPersonalAndIdobraAndIdPervilaAndId(idpersona, idobra, idpervila, idperpuesto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalPuestoDTO> findByObraPersonalVidaLab(Long idpersona, String idobra, Long idpervila) {
        return personalpuestoDao.findByObraPersonalVidaLab(idpersona, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalPuestoDTO findByObraPersonalVidaLabId(Long idpersona, String idobra, Long idpervila, Long idperpuest) {
        return personalpuestoDao.findByObraPersonalVidaLabId(idpersona, idobra, idpervila, idperpuest);
    }

    @Override
    @Transactional
    public PersonalPuesto save(PersonalPuesto newPuesto) {
        return personalpuestoDao.save(newPuesto);
    }

    @Override
    public List<ReportPuestosCargos> reportPuestosCargosPorObra(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer idtipocontrato, String ordenOpcion, Integer periodoIni, Integer periodoFin) {
        List<HistoricoVilaLabotalDTO> jornadaLab ;

        Sort sortPlanilla = Sort.by(Sort.Direction.ASC, "tgrplp.descripTab");
        Sort sortOcupacional = Sort.by(Sort.Direction.ASC, "tgrocp.descripTab");
        Sort sortPuesto = Sort.by(Sort.Direction.ASC,"pst.nombrePues");
        Sort sortCargo = Sort.by(Sort.Direction.ASC,"cc.nombreCar");
        Sort sortFechaCargo = Sort.by(Sort.Direction.ASC,"pc.fechaIniPercargo");
        Sort sortApepat = Sort.by(Sort.Direction.ASC, "psn.apePaternoPers");
        Sort sortApeMat = Sort.by(Sort.Direction.ASC, "psn.apeMaternoPers");
        Sort sortNombres = Sort.by(Sort.Direction.ASC, "psn.nombrePers");


        Sort grupSort = null;
        if(ordenOpcion.equals("GO")){
            grupSort = sortOcupacional.and(sortApepat.and(sortApeMat.and(sortNombres).and(sortPuesto.and(sortFechaCargo.and(sortCargo)))));
        } else {
            grupSort = sortPlanilla.and(sortApepat.and(sortApeMat.and(sortNombres).and(sortPuesto.and(sortFechaCargo.and(sortCargo)))));
        }

        List<ReportPuestosCargos> result = personalpuestoDao.reportPuestosCargosPorObra(idobra, estadoper, tipogrupo, tipoplanilla, idtipocontrato,periodoIni, periodoFin, grupSort);
        if(result.size()>0){

            for (ReportPuestosCargos item : result) {
                jornadaLab = historicovinculolaboralDao.findByUltimoCambioHistoricoVidaLabActual(item.getIdobra(), item.getIdPersonal(), item.getIdPervila(), Long.parseLong("-1"),"JORN", periodoIni, periodoFin);

                if(jornadaLab != null){
                    if(jornadaLab.size()>0){

                        item.setJornadaActual( jornadaLab.get(0).getJornadaSemaNewHistvila() );
                    }
                }

            }
        }

        return result;
    }

    @Override
    public List<ReportPuestosCargos> reportPuestosCargosPorPersonalObra(String idobra, Long idPersonal) {
        return personalpuestoDao.reportPuestosCargosPorPersonalObra(idobra, idPersonal);

        /*
        List<ReportPuestosCargos> result=personalpuestoDao.reportPuestosCargosPorPersonalObra(idobra, idPersonal);
        List<HistoricoVilaLabotalDTO> jornadaLab ;



        if(result.size()>0){
            System.out.println(result.size());
            for (ReportPuestosCargos item : result) {
                jornadaLab = historicovinculolaboralDao.findByUltimoCambioHistoricoVidaLabActual(item.getIdobra(), item.getIdPersonal(), item.getIdPervila(), Long.parseLong("-1"),"JORN");
                System.out.println(jornadaLab.get(0).getJornadaSemaNewHistvila());
                if(jornadaLab != null){
                    if(jornadaLab.size()>0){

                        item.setJornadaActual( jornadaLab.get(0).getJornadaSemaNewHistvila() );
                    }
                }

            }
        }

        return result;

         */
    }
}
