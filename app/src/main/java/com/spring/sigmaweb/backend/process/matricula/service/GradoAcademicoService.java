package com.spring.sigmaweb.backend.process.matricula.service;

import com.spring.sigmaweb.backend.process.matricula.model.Formacion;
import com.spring.sigmaweb.backend.process.matricula.model.GradoAcademico;
import com.spring.sigmaweb.backend.process.matricula.model.NivelAcademico;
import com.spring.sigmaweb.backend.process.matricula.repository.IGradoAcademicoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradoAcademicoService implements IGradoAcademicoService{
    @Autowired
    private IGradoAcademicoDao gradoacademicoDao;

    @Override
    public GradoAcademico findByIdGrado(Long idGrado) {
        // TODO Auto-generated method stub
        return gradoacademicoDao.findByIdGrado(idGrado);
    }

    @Override
    public List<GradoAcademico> findByGradoForIdNivel(Long idnivel) {
        // TODO Auto-generated method stub
        return gradoacademicoDao.findByGradoForIdNivel(idnivel);
    }

    @Override
    public List<NivelAcademico> findByNivelForIdFormacion(Long idformacion) {
        // TODO Auto-generated method stub
        return gradoacademicoDao.findByNivelForIdFormacion(idformacion);
    }

    @Override
    public List<Formacion> listFormacion() {
        // TODO Auto-generated method stub
        return gradoacademicoDao.listFormacion();
    }
}
