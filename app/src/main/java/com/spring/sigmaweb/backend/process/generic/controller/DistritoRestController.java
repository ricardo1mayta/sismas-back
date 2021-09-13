package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.Distrito;
import com.spring.sigmaweb.backend.process.generic.service.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class DistritoRestController {
    @Autowired
    private IDistritoService distritoService;

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA" })
    @GetMapping("/ubigeodistritos/{idProv}")
    public List<Distrito> showDistritos(@PathVariable Long idProv){
        return distritoService.findByProvincia(idProv);
    }

    //@Secured("ROLE_FAMI")
    @GetMapping("/ubigeodistid/{id}")
    public Optional<Distrito> showDistritosid(@PathVariable Long id){
        return distritoService.findById(id);
    }
}
