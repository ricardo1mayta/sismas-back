package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.PersonalEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.service.IPersonalEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/evaluaciondesemp")
public class PersonalEvaluacionRestController {

    @Autowired
    private IPersonalEvaluacionService personalevaluacionservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalaniolist/{idobra}/{idgruoocu}/{idpuesto}/{idcargo}/{principal}")
    public List<PersonalEvaluacionDTO> showPersonalEvaluacionList(@PathVariable String idobra, @PathVariable Integer idgruoocu , @PathVariable Long idpuesto, @PathVariable Long idcargo, @PathVariable Integer principal){
        return personalevaluacionservice.findByIdObraPerevalList(idobra, idgruoocu, idpuesto, idcargo, principal);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalnombresobralist/{idobra}")
    public List<PersonalEvaluacionDTO> showPersonalEvaluacionDistinctList(@PathVariable String idobra){
        return personalevaluacionservice.findByIdObraPerevalDistinctList(idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalnombresobralistcristostamar/{idobra}")
    public List<PersonalEvaluacionDTO> showPersonalEvaluacionDistinctListMasCristoStamar(@PathVariable String idobra){
        return personalevaluacionservice.findByIdObraPerevalDistinctListCristoStamar(idobra);
    }



    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalcargospuestoporpersonal/{idobra}/{idpersonal}/{esPrincipal}")
    public List<PersonalEvaluacionDTO> showPuestosCargosPersonalEval(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable Integer esPrincipal){
        return personalevaluacionservice.findByIdObraPersonallListCargosPuestos(idobra, idpersonal, esPrincipal);
    }

    //cierre
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalestadobloqueo/{idobra}/{idevento}/{idpersonal}/{idgrupoocu}")
    public List<PersonalEvaluacionDTO> showEstadoBloqueoPersonalEval(@PathVariable String idobra, @PathVariable Long idevento, @PathVariable Long idpersonal, @PathVariable Integer idgrupoocu){
        return personalevaluacionservice.findEstadoBloqueoEncuesta(idobra, idevento, idpersonal, idgrupoocu);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @PutMapping("/personalevalupdatebloque/{estado}/{idpersonal}/{obraname}/{idevento}")
    public Integer updateBloqueoPersonaleval(@PathVariable Integer estado, @PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idevento){
        Integer resp = 0;
        resp = personalevaluacionservice.updateBloqueoPersonalEval(estado,idpersonal,obraname,idevento);
        return resp ;
    }


}
