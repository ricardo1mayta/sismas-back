package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.Pais;
import com.spring.sigmaweb.backend.process.generic.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/sigmaweb/api")
public class PaisRestController {
    @Autowired
    private IPaisService paisService;

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tablaspaises")
    public List<Pais> show(){
        return paisService.findAll();
    }
}
