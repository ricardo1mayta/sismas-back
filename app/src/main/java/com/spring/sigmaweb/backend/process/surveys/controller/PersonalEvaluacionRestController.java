package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.PersonalEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.service.IPersonalEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/evaluaciondesemp")
public class PersonalEvaluacionRestController {

    @Autowired
    private IPersonalEvaluacionService personalevaluacionservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalaniolist/{idobra}/{idgruoocu}/{idpuesto}/{idcargo}")
    public List<PersonalEvaluacionDTO> showPersonalEvaluacionList(@PathVariable String idobra, @PathVariable Integer idgruoocu , @PathVariable Long idpuesto, @PathVariable Long idcargo){
        return personalevaluacionservice.findByIdObraPerevalList(idobra, idgruoocu, idpuesto, idcargo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalnombresobralist/{idobra}")
    public List<PersonalEvaluacionDTO> showPersonalEvaluacionDistinctList(@PathVariable String idobra){
        return personalevaluacionservice.findByIdObraPerevalDistinctList(idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalevalcargospuestoporpersonal/{idobra}/{idpersonal}")
    public List<PersonalEvaluacionDTO> showPuestosCargosPersonalEval(@PathVariable String idobra, @PathVariable Long idpersonal){
        return personalevaluacionservice.findByIdObraPersonallListCargosPuestos(idobra, idpersonal);
    }

}
