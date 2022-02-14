package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.legajo.dto.*;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalHistorico;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDataHistoricoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class PersonalService implements IPersonalService{

    @Autowired
    private IPersonalDao personalDao;

    @Autowired
    private IPersonalDataHistoricoDao personalHistoricoDao;

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
    public Integer updateColaboradorActivo(Long idpersonal, String obraname, String fechaactivo) {
        System.out.println(fechaactivo);
        Date fecha = new Date();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            fecha = formatter.parse(fechaactivo);

        } catch (ParseException e){

        }
        return personalDao.updateColaboradorActivo(idpersonal, obraname, fecha);
    }


}
