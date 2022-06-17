package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.legajo.dto.*;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorcoBancario;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorico;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistoricoVinculoLaboral;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDataHistoricoDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalHistoricoBancarioDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalHistoricoVinculoLaboralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class PersonalService implements IPersonalService{

    @Autowired
    private IPersonalDao personalDao;

    @Autowired
    private IPersonalDataHistoricoDao personalHistoricoDao;

    @Autowired
    private IPersonalHistoricoBancarioDao personalHistoricobancDao;

    @Autowired
    private IPersonalHistoricoVinculoLaboralDao historicovinculolabDAo;


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public PersonalDTO findByNroDocPerAndobraPersonal(String nroDocPer, String obraname) {
        return personalDao.findByNroDocPerAndobraPersonal(nroDocPer, obraname);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDatosPersonalesDTO findByIdPersonaAndObraPersonalInfoPersonal(Long idpersonal, String obraname) {
        // TODO Auto-generated method stub
        return personalDao.findByIdPersonaAndObraPersonalInfoPersonal(idpersonal, obraname);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDatosMedicosDTO findByIdPersonaAndObraInfoMedico(Long idpersonal, String obraname) {
        // TODO Auto-generated method stub
        return personalDao.findByIdPersonaAndObraInfoMedico(idpersonal, obraname);
    }

    @Override
    @Transactional
    public Personal save(Personal personal) {
        // TODO Auto-generated method stub

        return personalDao.save(personal);
    }

    @Override
    @Transactional(readOnly = true)
    public Personal findByIdPersonalAndObraname(Long idpersonal, String obraname) {
        // TODO Auto-generated method stub
        return personalDao.findByIdPersonalAndObraname(idpersonal, obraname);
    }

    @Override
    @Transactional
    public Integer updateFechaConfirPersonal(Long idpersonal) {
        return personalDao.updateFechaConfirPersonal(idpersonal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDatosListDTO> findByIdPersonalAndObraList(String obraname) {
        // TODO Auto-generated method stub
        return personalDao.findByIdPersonalAndObraList(obraname);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDatosListDTO> findByObraAndEstadoPerList(String obraname, Boolean estadoper) {
        // TODO Auto-generated method stub
        return personalDao.findByObraAndEstadoPerList(obraname, estadoper);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDatosListDTO> findByObraAndEstadoPerTestList(String obraname, Integer estadoper) {
        return personalDao.findByObraAndEstadoPerTestList(obraname,estadoper);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDatosListDTO findByObraAndidPersonalBasico(String obraname, Long idpersonal) {
        return personalDao.findByObraAndidPersonalBasico(obraname, idpersonal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDatosListDTO> findByNroDocPersAndIdObra(String obraname, String nrodocpers) {
        return personalDao.findByNroDocPersAndIdObra(obraname, nrodocpers);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDatosListDTO> findByCodigoPerAndIdObra(String obraname, String codigoPer) {
        return personalDao.findByCodigoPerAndIdObra(obraname, codigoPer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<dataPlanillaDTO> listDataPlanilla(String obraname) {
        List<dataPlanillaDTO> data = personalDao.listDataPlanilla(obraname);
        //actualiza el basico actual
        List<PersonalHistoricoVinculoLaboral> hist = null;
        Long idcont = Long.parseLong("-1");
        for (dataPlanillaDTO item : data) {
            hist =  historicovinculolabDAo.findByObraAndPersonalAndVidaLabAndContratoAndtipoList (obraname, item.getIdPersonal(), item.getIdPervila(),idcont,"REMU");
            if (hist != null) {
                if(hist.size()>0){
                    item.setBasico(hist.get(0).getRemuneracionNewHistvila());
                }
            }
        }
        return data;
    }

    @Override
    @Transactional
    public PersonalHistorico saveAll(List<PersonalHistorico> persoHist) {
        personalHistoricoDao.saveAll(persoHist);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalHistoricoDTO> buscarPorIdPersonalAndObraAndTipo(Long idpers, String idobra, String tipo) {
        //
        return personalHistoricoDao.buscarPorIdPersonalAndObraAndTipo(idpers, idobra, tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalDatosBancariosDTO findByObraAndidPersonalParaInfoBancario(String obraname, Long idpersonal) {
        return personalDao.findByObraAndidPersonalParaInfoBancario(obraname, idpersonal);
    }

    @Override
    @Transactional
    public Integer updateColaboradorActivo(Long idpersonal, String obraname, String fechaactivo, Boolean clearcodigo) {

        Date fecha = new Date();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            fecha = formatter.parse(fechaactivo);

        } catch (ParseException e){

        }

        return personalDao.updateColaboradorActivo(idpersonal, obraname, fecha, clearcodigo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalHistorcoBancario> findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdb(String idObraHistdb, long idPersonalHistdb, Long idPervilaHistdb) {
        return personalHistoricobancDao.findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdb(idObraHistdb, idPersonalHistdb, idPervilaHistdb);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalHistorcoBancario findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndIdHistdb(String idObraHistdb, long idPersonalHistdb, Long idPervilaHistdb, Long idHistdb) {
        return personalHistoricobancDao.findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndIdHistdb(idObraHistdb, idPersonalHistdb, idPervilaHistdb, idHistdb);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalHistorcoBancario> findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndTipoHistdb(String idObraHistdb, long idPersonalHistdb, Long idPervilaHistdb, String tipoHistdb) {
        return personalHistoricobancDao.findByIdObraHistdbAndIdPersonalHistdbAndIdPervilaHistdbAndTipoHistdb(idObraHistdb, idPersonalHistdb, idPervilaHistdb, tipoHistdb);
    }

    @Override
    public PersonalHistorcoBancario saveHistBancario(PersonalHistorcoBancario historico) {
        return personalHistoricobancDao.save(historico);
    }

    @Override
    public void updatePlanilla(Long idper, String obra, Long idpervila, String codigo, String usuario, String sexo, String fechain, String ipss, String cuspp, String afp, String ocupacion,
                               String contrato, String basico, String bonicargo, String jornadas) {

        Double bas = 0.0;
        Double boni = 0.0;
        Double jorn = 0.0;

        if(contrato != ""){
            bas = validaDouble(basico) == true ?Double.parseDouble( basico) : 0.0;
            boni = validaDouble(bonicargo) == true ?Double.parseDouble( bonicargo) : 0.0;
            jorn = validaDouble(jornadas) == true ?Double.parseDouble( jornadas) : 0.0;
        }

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_update_planilla");
        query.registerStoredProcedureParameter("p_idpersonal", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idpervila", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_codigo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_usuario", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_sexo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_fecha_ingreso", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_num_ipss", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_num_cuspp", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_afp", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_ocupacion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_contrato", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_basico", Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_bonicargo", Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_jornadas", Double.class, ParameterMode.IN);

        query.setParameter("p_idpersonal", idper);
        query.setParameter("p_obra", obra);
        query.setParameter("p_idpervila", idpervila != null ? idpervila : -1);
        query.setParameter("p_codigo", codigo);
        query.setParameter("p_usuario", usuario);
        query.setParameter("p_sexo", sexo);
        query.setParameter("p_fecha_ingreso", fechain);
        query.setParameter("p_num_ipss", ipss);
        query.setParameter("p_num_cuspp", cuspp);
        query.setParameter("p_afp", afp);
        query.setParameter("p_ocupacion", ocupacion);

        query.setParameter("p_contrato", contrato);
        query.setParameter("p_basico", bas);
        query.setParameter("p_bonicargo", boni);
        query.setParameter("p_jornadas", jorn);

        query.execute();

    }

    private Boolean validaDouble(String dato){

        Double value =0.0;
        try {
            value = Double.parseDouble(dato);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}

