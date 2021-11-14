package com.spring.sigmaweb.backend.process.matricula.controller;

import com.spring.sigmaweb.backend.process.matricula.model.Formacion;
import com.spring.sigmaweb.backend.process.matricula.model.GradoAcademico;
import com.spring.sigmaweb.backend.process.matricula.model.NivelAcademico;
import com.spring.sigmaweb.backend.process.matricula.service.IGradoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("sigmaweb/gradoAcademico")
public class GradoAcademicoRestController {
    @Autowired
    private IGradoAcademicoService gradoacademicoservice;

    @GetMapping("/gradoporid/{idGrado}")
    public GradoAcademico showGradoAcademico(@PathVariable Long idGrado) {
        return gradoacademicoservice.findByIdGrado(idGrado);
    }

    @GetMapping("/gradopornivel/{idnivel}")
    public List<GradoAcademico> showGradoPorNivel(@PathVariable Long idnivel) {
        return gradoacademicoservice.findByGradoForIdNivel(idnivel);
    }

    @GetMapping("/nivelporformacion/{idformacion}")
    public List<NivelAcademico> showNivelPorFormacion(@PathVariable Long idformacion) {
        return gradoacademicoservice.findByNivelForIdFormacion(idformacion);
    }

    @GetMapping("/formacionlist")
    public List<Formacion> showFormacion() {
        return gradoacademicoservice.listFormacion();
    }
}
