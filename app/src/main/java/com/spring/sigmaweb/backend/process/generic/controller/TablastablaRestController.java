package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import com.spring.sigmaweb.backend.process.generic.service.ITablasTablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/api")
public class TablastablaRestController {
    @Autowired
    private ITablasTablaService tablastablaservice;

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tablastipo/{tipotab}")
    public List<TablasTabla> show(@PathVariable Integer tipotab) {
        return tablastablaservice.findByTipoTab(tipotab);
    }

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tablastipolistin/{tipotab}/{listcodigos}")
    public List<TablasTabla> showListCodigoIn(@PathVariable Integer tipotab,@PathVariable String listcodigos) {
        return tablastablaservice.findByCodigoList(tipotab, listcodigos);
    }

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/tablastipolistnotin/{tipotab}/{listcodigos}")
    public List<TablasTabla> showListCodigoInNot(@PathVariable Integer tipotab,@PathVariable String listcodigos) {
        return tablastablaservice.findByCodigoListNot(tipotab, listcodigos);

    }
}
