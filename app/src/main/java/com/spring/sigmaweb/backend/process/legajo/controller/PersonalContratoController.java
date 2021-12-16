package com.spring.sigmaweb.backend.process.legajo.controller;

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
        response.put("Entidad", contratoNew);
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
    @GetMapping("/jornadaporidjorncontratopersonalobra/{idpersona}/{idobra}/{idpercont}/{idperjorn}")
    public PersonalContratoJornada showjornadaPorIdjornAndContratoAndObraAndIdpersonal(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont, @PathVariable Long idperjorn){
        return personalcontratoservice.findByJornadaPersonalAndObraAndcontrato(idpersona, idobra, idpercont,idperjorn);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/jornadaporcontratopersonalobra/{idpersona}/{idobra}/{idpercont}")
    public List<PersonalContratoJornada> showjornadaPorContratoAndObraAndIdpersonal(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercont){
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

    @PostMapping("/jornadacontratosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody JornadaPersonalContratoDTO jornada, BindingResult result) {
        PersonalContratoJornada jornadaNew = null;
        PersonalContratoJornada jornadaInsert = null;

        PersonalContrato persoContrato = personalcontratoservice.findByPersonalAndObraAndcontrato(jornada.getIdPersonal(), jornada.getIdObraPerjorn(), jornada.getIdPerCont());

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

            jornadaInsert = new PersonalContratoJornada();

            jornadaInsert.setIdPersonalContPerjorn(persoContrato);
            jornadaInsert.setIdObraPerjorn(jornada.getIdObraPerjorn());
            jornadaInsert.setDiaLunePerjorn(jornada.getDiaLunePerjorn());
            jornadaInsert.setDiaMartPerjorn(jornada.getDiaMartPerjorn());
            jornadaInsert.setDiaMierPerjorn(jornada.getDiaMierPerjorn());
            jornadaInsert.setDiaJuevPerjorn(jornada.getDiaJuevPerjorn());
            jornadaInsert.setDiaVierPerjorn(jornada.getDiaVierPerjorn());
            jornadaInsert.setDiaSabaPerjorn(jornada.getDiaSabaPerjorn());
            jornadaInsert.setDiaDomiPerjorn(jornada.getDiaDomiPerjorn());
            jornadaInsert.setDiaLuneInihorPerjorn(jornada.getDiaLuneInihorPerjorn());
            jornadaInsert.setDiaLuneFinhorPerjorn(jornada.getDiaLuneFinhorPerjorn());

            jornadaInsert.setDiaMartInihorPerjorn(jornada.getDiaMartInihorPerjorn());
            jornadaInsert.setDiaMartFinhorPerjorn(jornada.getDiaMartFinhorPerjorn());
            jornadaInsert.setDiaMierInihorPerjorn(jornada.getDiaMierInihorPerjorn());
            jornadaInsert.setDiaMierFinhorPerjorn(jornada.getDiaMierFinhorPerjorn());
            jornadaInsert.setDiaJuevInihorPerjorn(jornada.getDiaJuevInihorPerjorn());
            jornadaInsert.setDiaJuevFinhorPerjorn(jornada.getDiaJuevFinhorPerjorn());
            jornadaInsert.setDiaVierInihorPerjorn(jornada.getDiaVierInihorPerjorn());
            jornadaInsert.setDiaVierFinhorPerjorn(jornada.getDiaVierFinhorPerjorn());
            jornadaInsert.setDiaSabaInihorPerjorn(jornada.getDiaSabaInihorPerjorn());
            jornadaInsert.setDiaSabaFinhorPerjorn(jornada.getDiaSabaFinhorPerjorn());
            jornadaInsert.setDiaDomiInihorPerjorn(jornada.getDiaDomiInihorPerjorn());
            jornadaInsert.setDiaDomiFinhorPerjorn(jornada.getDiaDomiFinhorPerjorn());
            jornadaInsert.setDiaLuneInirefPerjorn(jornada.getDiaLuneInirefPerjorn());
            jornadaInsert.setDiaLuneFinrefPerjorn(jornada.getDiaLuneFinrefPerjorn());
            jornadaInsert.setDiaMartInirefPerjorn(jornada.getDiaMartInirefPerjorn());
            jornadaInsert.setDiaMartFinrefPerjorn(jornada.getDiaMartFinrefPerjorn());
            jornadaInsert.setDiaMierInirefPerjorn(jornada.getDiaMierInirefPerjorn());
            jornadaInsert.setDiaMierFinrefPerjorn(jornada.getDiaMierFinrefPerjorn());
            jornadaInsert.setDiaJuevInirefPerjorn(jornada.getDiaJuevInirefPerjorn());
            jornadaInsert.setDiaJuevFinrefPerjorn(jornada.getDiaJuevFinrefPerjorn());
            jornadaInsert.setDiaVierInirefPerjorn(jornada.getDiaVierInirefPerjorn());
            jornadaInsert.setDiaVierFinrefPerjorn(jornada.getDiaVierFinrefPerjorn());
            jornadaInsert.setDiaSabaInirefPerjorn(jornada.getDiaSabaInirefPerjorn());
            jornadaInsert.setDiaSabaFinrefPerjorn(jornada.getDiaSabaFinrefPerjorn());
            jornadaInsert.setDiaDomiInirefPerjorn(jornada.getDiaDomiInirefPerjorn());
            jornadaInsert.setDiaDomiFinrefPerjorn(jornada.getDiaDomiFinrefPerjorn());

            jornadaInsert.setCreaPorPerjorn(jornada.getCreaPorPerjorn());
            jornadaInsert.setFechaIngPerjorn(jornada.getFechaIngPerjorn());

            jornadaNew = personalcontratoservice.save(jornadaInsert);

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
            
            jornadaAct.setDiaLunePerjorn(jornadaDTO.getDiaLunePerjorn());
            jornadaAct.setDiaMartPerjorn(jornadaDTO.getDiaMartPerjorn());
            jornadaAct.setDiaMierPerjorn(jornadaDTO.getDiaMierPerjorn());
            jornadaAct.setDiaJuevPerjorn(jornadaDTO.getDiaJuevPerjorn());
            jornadaAct.setDiaVierPerjorn(jornadaDTO.getDiaVierPerjorn());
            jornadaAct.setDiaSabaPerjorn(jornadaDTO.getDiaSabaPerjorn());
            jornadaAct.setDiaDomiPerjorn(jornadaDTO.getDiaDomiPerjorn());
            jornadaAct.setDiaLuneInihorPerjorn(jornadaDTO.getDiaLuneInihorPerjorn());
            jornadaAct.setDiaLuneFinhorPerjorn(jornadaDTO.getDiaLuneFinhorPerjorn());

            jornadaAct.setDiaMartInihorPerjorn(jornadaDTO.getDiaMartInihorPerjorn());
            jornadaAct.setDiaMartFinhorPerjorn(jornadaDTO.getDiaMartFinhorPerjorn());
            jornadaAct.setDiaMierInihorPerjorn(jornadaDTO.getDiaMierInihorPerjorn());
            jornadaAct.setDiaMierFinhorPerjorn(jornadaDTO.getDiaMierFinhorPerjorn());
            jornadaAct.setDiaJuevInihorPerjorn(jornadaDTO.getDiaJuevInihorPerjorn());
            jornadaAct.setDiaJuevFinhorPerjorn(jornadaDTO.getDiaJuevFinhorPerjorn());
            jornadaAct.setDiaVierInihorPerjorn(jornadaDTO.getDiaVierInihorPerjorn());
            jornadaAct.setDiaVierFinhorPerjorn(jornadaDTO.getDiaVierFinhorPerjorn());
            jornadaAct.setDiaSabaInihorPerjorn(jornadaDTO.getDiaSabaInihorPerjorn());
            jornadaAct.setDiaSabaFinhorPerjorn(jornadaDTO.getDiaSabaFinhorPerjorn());
            jornadaAct.setDiaDomiInihorPerjorn(jornadaDTO.getDiaDomiInihorPerjorn());
            jornadaAct.setDiaDomiFinhorPerjorn(jornadaDTO.getDiaDomiFinhorPerjorn());
            jornadaAct.setDiaLuneInirefPerjorn(jornadaDTO.getDiaLuneInirefPerjorn());
            jornadaAct.setDiaLuneFinrefPerjorn(jornadaDTO.getDiaLuneFinrefPerjorn());
            jornadaAct.setDiaMartInirefPerjorn(jornadaDTO.getDiaMartInirefPerjorn());
            jornadaAct.setDiaMartFinrefPerjorn(jornadaDTO.getDiaMartFinrefPerjorn());
            jornadaAct.setDiaMierInirefPerjorn(jornadaDTO.getDiaMierInirefPerjorn());
            jornadaAct.setDiaMierFinrefPerjorn(jornadaDTO.getDiaMierFinrefPerjorn());
            jornadaAct.setDiaJuevInirefPerjorn(jornadaDTO.getDiaJuevInirefPerjorn());
            jornadaAct.setDiaJuevFinrefPerjorn(jornadaDTO.getDiaJuevFinrefPerjorn());
            jornadaAct.setDiaVierInirefPerjorn(jornadaDTO.getDiaVierInirefPerjorn());
            jornadaAct.setDiaVierFinrefPerjorn(jornadaDTO.getDiaVierFinrefPerjorn());
            jornadaAct.setDiaSabaInirefPerjorn(jornadaDTO.getDiaSabaInirefPerjorn());
            jornadaAct.setDiaSabaFinrefPerjorn(jornadaDTO.getDiaSabaFinrefPerjorn());
            jornadaAct.setDiaDomiInirefPerjorn(jornadaDTO.getDiaDomiInirefPerjorn());
            jornadaAct.setDiaDomiFinrefPerjorn(jornadaDTO.getDiaDomiFinrefPerjorn());

            jornadaAct.setCreaPorPerjorn(jornadaDTO.getCreaPorPerjorn());
            jornadaAct.setFechaIngPerjorn(jornadaDTO.getFechaIngPerjorn());
        }
        return personalcontratoservice.save(jornadaAct);
    }


}
