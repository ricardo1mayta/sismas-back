package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.dataPlanillaDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.repository.IContratoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDesvinculacionDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDocDesvinculacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Service
public class PersonalDesvinculacionService implements IPersonalDesvinculacionService {
    @Autowired
    private IPersonalDesvinculacionDao personalDesvinculacionDao;

    @Autowired
    private IPersonalDocDesvinculacionDao docdesvinculacionDao;

    @Autowired
    private IContratoDao personalcontratoDao;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public PersonalDesvinculacion findByIdPerDesv(Long idPerDesv) {
        return personalDesvinculacionDao.findByIdPerDesv(idPerDesv);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDesvinculacion findByPersonalDesvinculacionActivos(Long idpersonal, String idobra, Long idperdesv, Long idpervila) {
        return personalDesvinculacionDao.findByPersonalDesvinculacionActivos(idpersonal, idobra, idperdesv, idpervila);
    }

    @Override
    public PersonalDesvinculacion findByPersonalDesvinculacionId(Long idpersonal, String idobra, Long idperdesv) {
        return personalDesvinculacionDao.findByPersonalDesvinculacionId(idpersonal, idobra, idperdesv);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDesvinculacionDTO findByPersonalDesvinculacionActivosDTO(Long idpersonal, String idobra, Long idperdesv, Long idpervila) {
        return personalDesvinculacionDao.findByPersonalDesvinculacionActivosDTO(idpersonal, idobra, idperdesv, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDesvinculacionDTO> findByPersonalDesvinculacionActivosListDTO(Long idpersonal, String idobra, Long idpervila) {
        return personalDesvinculacionDao.findByPersonalDesvinculacionActivosListDTO(idpersonal, idobra, idpervila);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDesvinculacionDTO> findByPersonalDesvinculacionListDTO(Long idpersonal, String idobra){
        return personalDesvinculacionDao.findByPersonalDesvinculacionListDTO(idpersonal, idobra);
    }

    @Override
    @Transactional
    public PersonalDesvinculacion save(PersonalDesvinculacion desvinculacion) {
        return personalDesvinculacionDao.save(desvinculacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByIdObraPerentrAndIdTipoDocDesvPerentr(String idObraPerentr, Long idTipoDocDesvPerentr) {
        return docdesvinculacionDao.countByIdObraPerentrAndIdTipoDocDesvPerentr(idObraPerentr, idTipoDocDesvPerentr);
    }

    @Override
    public void update_spu_desvinculacion(Long id_personal, String obra, Long idpervila, String usermodi, Date datetermino, Integer habilita) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_desvinculacion_personal");
        query.registerStoredProcedureParameter("p_idpersonal", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idpervila", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_dateTermino", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_habilita", Integer.class, ParameterMode.IN);

        query.setParameter("p_idpersonal", id_personal);
        query.setParameter("p_obra", obra);
        query.setParameter("p_idpervila", idpervila);
        query.setParameter("p_user", usermodi);
        query.setParameter("p_dateTermino", datetermino);
        query.setParameter("p_habilita", habilita);

        query.execute();
    }

    @Override
    @Transactional
    public String insertNativePersoDocDesv(PersonalDocDesvDTO perdocDesv) {
        String id = perdocDesv.getIdObraPerentr() + "-" + perdocDesv.getIdPerdesvPerentr().toString() + "-" + perdocDesv.getIdTipoDocDesvPerentr().toString() ;



        docdesvinculacionDao.insertNativePersoDocDesv(id,
                                                    perdocDesv.getIdPerdesvPerentr(),
                                                    perdocDesv.getIdObraPerentr(),
                                                    perdocDesv.getIdTipoDocDesvPerentr(),
                                                    perdocDesv.getIdResponsablePerentr());
        return id;
    }

    @Override
    @Transactional
    public Integer updatePerdocDesvincula(String idperentr, String obraname, Long idperdesv, Boolean flgEnt, Double monto, Date fecha, String idfile) {
        return docdesvinculacionDao.updatePerdocDesvincula(idperentr, obraname, idperdesv, flgEnt, monto, fecha, idfile);
    }

    @Override
    @Transactional
    public Integer deletePersonalDocDesv(String idperentr, String obraname, Long idperdesv) {
        return docdesvinculacionDao.deletePersonalDocDesv(idperentr, obraname, idperdesv);
    }

    @Override
    public List<ReportDesvinculacion> reportDesvinculacionesColaborador(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer tipoDesvinculacion, Integer fechaini, Integer Fechafin, String ordenOpcion) {
        Sort sortPlanilla = Sort.by(Sort.Direction.ASC, "tgrpl.descripTab");
        Sort sortOcupacional = Sort.by(Sort.Direction.ASC, "tgroc.descripTab");
        Sort sortApepat = Sort.by(Sort.Direction.ASC, "psn.apePaternoPers");
        Sort sortApeMat = Sort.by(Sort.Direction.ASC, "psn.apeMaternoPers");
        Sort sortNombres = Sort.by(Sort.Direction.ASC, "psn.nombrePers");

        Sort grupSort = null;
        if(ordenOpcion.equals("GO")){
            grupSort = sortOcupacional.and(sortApepat.and(sortApeMat.and(sortNombres)));
        } else {
            grupSort = sortPlanilla.and(sortApepat.and(sortApeMat.and(sortNombres)));
        }
        List<ReportDesvinculacion> result =personalDesvinculacionDao.reportDesvinculacionesColaborador(idobra, estadoper, tipogrupo, tipoplanilla, tipoDesvinculacion,fechaini, Fechafin, grupSort);
        List<PersonalContratoObraDTO> data =null;
        Long idPer=Long.parseLong("-1");
        Long idVila=Long.parseLong("-1");
        for (ReportDesvinculacion item : result) {
            if(!idPer.equals(item.getIdPersonal()) && !idVila.equals(item.getIdPervila())){
                data = personalcontratoDao.findByIdPersonalPercontAndIdPervilaPercontAndIdObraPervila(item.getIdPersonal(),item.getIdPervila(),item.getIdobra());
                idPer = item.getIdPersonal();
                idVila = item.getIdPervila();
            }
            item.setTipoUltPercont(data.get(0).getTipoContrato());
            item.setFechaFinUltPercont(data.get(0).getFechaFinPercont());
            item.setFechaTerminoUltPercont(data.get(0).getFechaTerminoPercont());
            item.setFechaIniUltPercont(data.get(0).getFechaIniPercont());
        }


        return result;
    }

    @Override
    public List<ReportDesvinculacion> reportDesvinculacionesChecklistColaborador(String idobra, Integer estadoper, Integer tipogrupo, Integer tipoplanilla, Integer tipoDesvinculacion, Integer fechaini, Integer Fechafin,Integer estadoEntrega, String ordenOpcion) {
        Sort sortPlanilla = Sort.by(Sort.Direction.ASC, "tgrpl.descripTab");
        Sort sortOcupacional = Sort.by(Sort.Direction.ASC, "tgroc.descripTab");
        Sort sortApepat = Sort.by(Sort.Direction.ASC, "psn.apePaternoPers");
        Sort sortApeMat = Sort.by(Sort.Direction.ASC, "psn.apeMaternoPers");
        Sort sortNombres = Sort.by(Sort.Direction.ASC, "psn.nombrePers");
        Sort sortDocNombre = Sort.by(Sort.Direction.ASC, "dd.descripcionDocdesv");

        Sort grupSort = null;
        if(ordenOpcion.equals("GO")){
            grupSort = sortOcupacional.and(sortApepat.and(sortApeMat.and(sortNombres.and(sortDocNombre))));
        } else if(ordenOpcion.equals("NC")){
            grupSort = sortApepat.and(sortApeMat.and(sortNombres.and(sortDocNombre)));
        } else {
            grupSort = sortPlanilla.and(sortApepat.and(sortApeMat.and(sortNombres.and(sortDocNombre))));
        }

        List<ReportDesvinculacion> result =personalDesvinculacionDao.reportDesvinculacionesChecklistColaborador(idobra, estadoper, tipogrupo, tipoplanilla, tipoDesvinculacion,fechaini, Fechafin, estadoEntrega, grupSort);
        List<PersonalContratoObraDTO> data =null;
        Long idPer=Long.parseLong("-1");
        Long idVila=Long.parseLong("-1");

        for (ReportDesvinculacion item : result) {
            if(!idPer.equals(item.getIdPersonal()) && !idVila.equals(item.getIdPervila())){
                data = personalcontratoDao.findByIdPersonalPercontAndIdPervilaPercontAndIdObraPervila(item.getIdPersonal(),item.getIdPervila(),item.getIdobra());
                idPer = item.getIdPersonal();
                idVila = item.getIdPervila();
            }
            item.setTipoUltPercont(data.get(0).getTipoContrato());
            item.setFechaFinUltPercont(data.get(0).getFechaFinPercont());
            item.setFechaTerminoUltPercont(data.get(0).getFechaTerminoPercont());
            item.setFechaIniUltPercont(data.get(0).getFechaIniPercont());
        }

        return result;
    }
}
