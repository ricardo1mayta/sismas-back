package com.spring.sigmaweb.backend.process.matricula.service;

import com.spring.sigmaweb.backend.process.matricula.model.Formacion;
import com.spring.sigmaweb.backend.process.matricula.model.GradoAcademico;
import com.spring.sigmaweb.backend.process.matricula.model.NivelAcademico;

import java.util.List;

public interface IGradoAcademicoService {
    public GradoAcademico findByIdGrado(Long idGrado);
    public List<GradoAcademico> findByGradoForIdNivel(Long idnivel);
    public List<NivelAcademico> findByNivelForIdFormacion(Long idformacion);
    public List<Formacion> listFormacion();
}
