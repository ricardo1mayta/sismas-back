package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personalext")
public class PersonalExtRestController {
    @Autowired
    private IPersonalExtService personalExtService;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalexternoobra/{obraname}/{idpersonal}")
    public PersonalDatosListDTO showpersonalexternoListDTO(@PathVariable String obraname, @PathVariable Long idpersonal) {
        return personalExtService.findByObraAndidPersonalExternoBasico(obraname, idpersonal);
    }
}
