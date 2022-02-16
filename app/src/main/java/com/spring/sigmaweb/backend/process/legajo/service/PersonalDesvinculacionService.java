package com.spring.sigmaweb.backend.process.legajo.service;

import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDesvinculacionDao;
import com.spring.sigmaweb.backend.process.legajo.repository.IPersonalDocDesvinculacionDao;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void update_spu_desvinculacion(Long id_personal, String obra, Long idpervila, String usermodi, Date datetermino) {

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("spu_desvinculacion_personal");
        query.registerStoredProcedureParameter("p_idpersonal", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_obra", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_idpervila", Long.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_dateTermino", Date.class, ParameterMode.IN);

        query.setParameter("p_idpersonal", id_personal);
        query.setParameter("p_obra", obra);
        query.setParameter("p_idpervila", idpervila);
        query.setParameter("p_user", usermodi);
        query.setParameter("p_dateTermino", datetermino);

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
}
