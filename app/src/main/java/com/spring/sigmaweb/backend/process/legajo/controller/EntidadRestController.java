package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.service.IEntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/entidad")
public class EntidadRestController {
    @Autowired
    private IEntidadService entidadservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadsaludeps/{idobra}")
    public List<EntidadListSelectDTO> showEntidadSalud(@PathVariable String idobra){
        return entidadservice.findByTipoEntAndFlgSaludEntAndObra(idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadprevicion/{tipoEnt}/{idobra}")
    public List<EntidadListSelectDTO> showEntidadPrevicion(@PathVariable Integer tipoEnt, @PathVariable String idobra){
        return entidadservice.findByTipoEntAndFlgPrevisionalEntAndObra(tipoEnt, idobra);
    }
}
