package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.Provincia;
import com.spring.sigmaweb.backend.process.generic.service.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("sigmaweb/api")
public class ProvinciaRestController {
    @Autowired
    private IProvinciaService provinciaService;

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/ubigeoprovincias/{idDepa}")
    public List<Provincia> showProvincias(@PathVariable Long idDepa){
        return provinciaService.findByDepartamento(idDepa);
    }

    //@Secured("ROLE_FAMI")
    @GetMapping("/ubigeoprovid/{id}")
    public Optional<Provincia> showProvinciasId(@PathVariable Long id){

        return provinciaService.findById(id);
    }
}
