package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.Departamento;
import com.spring.sigmaweb.backend.process.generic.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/sigmaweb/api")
public class DepartamentoRestController {
    @Autowired
    private IDepartamentoService departamentoservice;

    @Secured({"ROLE_FAMI", "ROLE_ADMI","ROLE_COLA"})
    @GetMapping("/ubigeodepart")
    public List<Departamento> showDepartamento() {
        return departamentoservice.findAll();
    }

    @Secured({"ROLE_FAMI", "ROLE_ADMI","ROLE_COLA"})
    @GetMapping("/ubigeodepaid/{id}")
    public Optional<Departamento> showDepartamentoId(@PathVariable Long id) {
        return departamentoservice.findById(id);
    }

}
