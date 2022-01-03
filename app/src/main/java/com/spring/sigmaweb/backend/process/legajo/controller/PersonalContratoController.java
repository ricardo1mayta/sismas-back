package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.legajo.dto.JornadaPersonalContratoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalContratoService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personal/contrato")
public class PersonalContratoController {
    @Autowired
    private IPersonalContratoService personalcontratoservice;

    @Autowired
    private IPersonalService personalservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontrato/{idPerCont}")
    public PersonalContrato showContratoPorIdContrato(@PathVariable Long idPerCont){
        return personalcontratoservice.findByIdPerCont(idPerCont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontratoobrapersonal/{idpersonal}/{idobra}/{idpercont}")
    public PersonalContrato showContratoPorIdContratoAndObraAndIdpersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByPersonalAndObraAndcontrato(idpersonal, idobra, idpercont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoobrapersonallist/{idpersonal}/{idobra}")
    public List<PersonalContrato> showContratoPorIdContratoAndObraAndIdpersonalList(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByPersonalAndObraList(idpersonal, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoidcontratoobrapersonaldto/{idpersonal}/{idobra}/{idpercont}")
    public PersonalContratoObraDTO showContratoPorIdContratoAndObraAndIdpersonalDTO(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByPersonalAndObraAndcontratoDto(idpersonal, idobra, idpercont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/contratoobrapersonaldtolist/{idpersonal}/{idobra}")
    public List<PersonalContratoObraDTO> showContratoPorObraAndIdpersonalDTOList(@PathVariable Long idpersonal, @PathVariable String idobra){
        return personalcontratoservice.findByPersonalAndObraAndcontratoDtoList(idpersonal, idobra);
    }

    @PostMapping("/contratosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalContratoObraDTO contrato, BindingResult result) {
        PersonalContrato contratoNew = null;
        PersonalContrato contratoInsert = null;

        Personal persoContrato = personalservice.findByIdPersonalAndObraname(contrato.getIdPersonal(), contrato.getIdObraPercont());

        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {

            contratoInsert = new PersonalContrato();

            contratoInsert.setIdObraPercont(contrato.getIdObraPercont());
            contratoInsert.setIdPersonalPercont(persoContrato);
            contratoInsert.setIdTipoPercont(contrato.getIdTipoPercont());
            contratoInsert.setUrlDocumentoPercont(contrato.getUrlDocumentoPercont());
            contratoInsert.setFechaIniPercont(contrato.getFechaIniPercont());
            contratoInsert.setFechaFinPercont(contrato.getFechaFinPercont());
            contratoInsert.setObservacionesPercont(contrato.getObservacionesPercont());
            contratoInsert.setEstadoPercont(contrato.getEstadoPercont());
            contratoInsert.setFechaIngPercont(contrato.getFechaIngPercont());
            contratoInsert.setCreaPorPercont(contrato.getCreaPorPercont());

            contratoNew = personalcontratoservice.save(contratoInsert);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("contrato", contratoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/contratoupdate/{idcontrato}/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalContrato updateContratoDTO  (@RequestBody PersonalContratoObraDTO contratoDTO, @PathVariable Long idcontrato, @PathVariable Long idpersonal, @PathVariable String obraname) {
        PersonalContrato contratoAct = personalcontratoservice.findByPersonalAndObraAndcontrato(idpersonal, obraname, idcontrato);

        if(contratoAct != null) {

            contratoAct.setIdTipoPercont(contratoDTO.getIdTipoPercont());
            contratoAct.setUrlDocumentoPercont(contratoDTO.getUrlDocumentoPercont());
            contratoAct.setFechaIniPercont(contratoDTO.getFechaIniPercont());
            contratoAct.setFechaFinPercont(contratoDTO.getFechaFinPercont());
            contratoAct.setObservacionesPercont(contratoDTO.getObservacionesPercont());
            contratoAct.setEstadoPercont(contratoDTO.getEstadoPercont());
            contratoAct.setFechaModiPercont(contratoDTO.getFechaModiPercont());
            contratoAct.setModiPorPercont(contratoDTO.getModiPorPercont());
        }
        return personalcontratoservice.save(contratoAct);
    }


    //************************************* jornadas *******************************************

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjornada/{idPerjorn}")
    public PersonalContratoJornada showJornadaIdjornada(@PathVariable Long idPerjorn){
        return personalcontratoservice.findByIdPerjorn(idPerjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjorncontratopersonalobra/{idpersonal}/{idobra}/{idpercont}/{idperjorn}")
    public PersonalContratoJornada showjornadaPorIdjornAndContratoAndObraAndIdpersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idperjorn){
        return personalcontratoservice.findByJornadaPersonalAndObraAndcontrato(idpersonal, idobra, idpercont,idperjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporcontratopersonalobra/{idpersonal}/{idobra}/{idpercont}")
    public List<PersonalContratoJornada> showjornadaPorContratoAndObraAndIdpersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findByJornadaPersonalAndObraAndcontratoList(idpersonal, idobra, idpercont);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporidjorncontratopersonalobradto/{idpersonal}/{idobra}/{idpercont}/{idperjorn}")
    public JornadaPersonalContratoDTO showjornadaPorIdjornAndContratoAndObraAndIdpersonalDTO(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idperjorn){
        return personalcontratoservice.findIdJornadaPersonalAndObraAndContratoDTO(idpersonal, idobra, idpercont,idperjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporcontratopersonalobradtolist/{idpersonal}/{idobra}/{idpercont}")
    public List<JornadaPersonalContratoDTO> showjornadaPorContratoAndObraAndIdpersonalDtoList(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpercont){
        return personalcontratoservice.findJornadasPersonalAndObraAndContratoDTOList(idpersonal, idobra, idpercont);
    }

    @PostMapping("/jornadacontratosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody List<JornadaPersonalContratoDTO> jornada, BindingResult result) {
        PersonalContratoJornada jornadaNew = null;
        PersonalContratoJornada jornadaInsert = null;

        PersonalContrato persoContrato = personalcontratoservice.findByPersonalAndObraAndcontrato(jornada.get(0).getIdPersonal(), jornada.get(0).getIdObraPerjorn(), jornada.get(0).getIdPerCont());

        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            for (JornadaPersonalContratoDTO jorn : jornada) {
                System.out.println(jorn.getIdPerjorn());
                jornadaInsert = new PersonalContratoJornada();
                jornadaInsert.setIdPerjorn(jorn.getIdPerjorn());
                jornadaInsert.setIdPersonalContPerjorn(persoContrato);
                jornadaInsert.setIdObraPerjorn(jorn.getIdObraPerjorn());

                jornadaInsert.setIdDiaPerJorn(jorn.getIdDiaPerJorn());
                jornadaInsert.setDiaInihorPerjorn(jorn.getDiaInihorPerjorn());
                jornadaInsert.setDiaFinhorPerjorn(jorn.getDiaFinhorPerjorn());
                jornadaInsert.setTipoDiaPerjorn(jorn.getTipoDiaPerjorn());

                jornadaInsert.setCreaPorPerjorn(jorn.getCreaPorPerjorn());
                jornadaInsert.setFechaIngPerjorn(jorn.getFechaIngPerjorn());

                jornadaNew = personalcontratoservice.save(jornadaInsert);

            }

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("Entidad", jornadaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/jornadaupdate/{idcontrato}/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalContratoJornada updateContratoDTO  (@RequestBody JornadaPersonalContratoDTO jornadaDTO, @PathVariable Long idcontrato, @PathVariable Long idjornada, @PathVariable Long idpersonal, @PathVariable String obraname) {
        PersonalContratoJornada jornadaAct = personalcontratoservice.findByJornadaPersonalAndObraAndcontrato(idpersonal,obraname, idcontrato, idjornada);

        if(jornadaAct != null) {
            jornadaAct.setIdDiaPerJorn(jornadaDTO.getIdDiaPerJorn());
            jornadaAct.setDiaInihorPerjorn(jornadaDTO.getDiaInihorPerjorn());
            jornadaAct.setDiaFinhorPerjorn(jornadaDTO.getDiaFinhorPerjorn());
            jornadaAct.setTipoDiaPerjorn(jornadaDTO.getTipoDiaPerjorn());


            jornadaAct.setCreaPorPerjorn(jornadaDTO.getCreaPorPerjorn());
            jornadaAct.setFechaIngPerjorn(jornadaDTO.getFechaIngPerjorn());
        }
        return personalcontratoservice.save(jornadaAct);
    }

    @Secured({"ROLE_ADMI"})
    @DeleteMapping("/jornadadeleteall/{idpersonal}/{obraname}/{idcontrato}")
    public ResponseEntity<?> deleteAll(@PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idcontrato){
        Map<String, Object> response = new HashMap<>();
        try {
            List<PersonalContratoJornada> jornadaDelete = personalcontratoservice.findByJornadaPersonalAndObraAndcontratoList(idpersonal, obraname, idcontrato);
            System.out.println(jornadaDelete.size());
            if(jornadaDelete.size()>0){
                personalcontratoservice.deleteAll(jornadaDelete);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar jornada");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se eliminaron las jornadas del contrato");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
