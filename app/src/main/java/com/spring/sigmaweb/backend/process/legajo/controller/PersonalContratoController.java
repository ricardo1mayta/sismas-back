package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personalcontrato")
public class PersonalContratoController {
    @Autowired
    private IPersonalContratoService personalcontratoservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontrato/{idPerCont}")
    public PersonalContrato showContratoPorIdContrato(@PathVariable Long idPerCont){
        return personalcontratoservice.findByIdPerCont(idPerCont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontratoobrapersonal/{idpersona}/{idobra}/{idpercont}")
    public PersonalContrato showContratoPorIdContratoAndObraAndIdpersonal(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByPersonalAndObraAndcontrato(idpersona, idobra, idpercont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoobrapersonallist/{idpersona}/{idobra}")
    public List<PersonalContrato> showContratoPorIdContratoAndObraAndIdpersonalList(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByPersonalAndObraList(idpersona, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontratoobrapersonaldto/{idpersona}/{idobra}/{idpercont}")
    public PersonalContratoObraDTO showContratoPorIdContratoAndObraAndIdpersonalDTO(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByPersonalAndObraAndcontratoDto(idpersona, idobra, idpercont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoobrapersonaldtolist/{idpersona}/{idobra}")
    public List<PersonalContratoObraDTO> showContratoPorObraAndIdpersonalDTOListO(@PathVariable Long idpersona, @PathVariable String idobra){
        return personalcontratoservice.findByPersonalAndObraAndcontratoDtoList(idpersona, idobra);
    }

    //************************************* jornadas *******************************************

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjornada/{idPerjorn}")
    public PersonalContratoJornada showJornadaIdjornada(@PathVariable Long idPerjorn){
        return personalcontratoservice.findByIdPerjorn(idPerjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjorncontratopersonalobra/{idpersona}/{idobra}/{idpercont}/{idperjorn}")
    public PersonalContrato showjornadaPorIdjornAndContratoAndObraAndIdpersonal(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idperjorn){
        return personalcontratoservice.findByJornadaPersonalAndObraAndcontrato(idpersona, idobra, idpercont,idperjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporcontratopersonalobra/{idpersona}/{idobra}/{idpercont}")
    public List<PersonalContrato> showjornadaPorContratoAndObraAndIdpersonal(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByJornadaPersonalAndObraAndcontratoList(idpersona, idobra, idpercont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjorncontratopersonalobradto/{idpersona}/{idobra}/{idpercont}/{idperjorn}")
    public JornadaPersonalContratoDTO showjornadaPorIdjornAndContratoAndObraAndIdpersonalDTO(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idperjorn){
        return personalcontratoservice.findIdJornadaPersonalAndObraAndContratoDTO(idpersona, idobra, idpercont,idperjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporcontratopersonalobradtolist/{idpersona}/{idobra}/{idpercont}")
    public List<JornadaPersonalContratoDTO> showjornadaPorContratoAndObraAndIdpersonalDtoList(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findJornadasPersonalAndObraAndContratoDTOList(idpersona, idobra, idpercont);
    }

}
