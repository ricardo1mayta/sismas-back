package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.ItemListVidaLaboralDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalVidaLabDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalVidaLaboral;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalVidaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personal/vidalaboral")
public class PersonalVidaLaboralRestController {

    @Autowired
    IPersonalVidaLaboralService personalvidalabService;

    @Autowired
    private IPersonalService personalservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/vidalaboralobraid/{idPervila}/{idObraPervila}")
    public PersonalVidaLaboral showVidaLaboralObraId(@PathVariable Long idPervila, @PathVariable String idObraPervila){
        return personalvidalabService.findByIdPervilaAndIdObraPervila(idPervila,idObraPervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/vidalaboralobrapersonalid/{idobra}/{idpersonal}/{idPervila}")
    public PersonalVidaLaboral showVidaLaboralObraPersonalId(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable Long idpervila){
        return personalvidalabService.findByObraPersonalId(idobra, idpersonal, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/vidalaboralobrapersonalestado/{idobra}/{idpersonal}/{estado}")
    public List<PersonalVidaLaboral> showVidaLaboralObraPersonalestado(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable String estado){
        return personalvidalabService.findByObraPersonalEstado(idobra, idpersonal, estado);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/ultimavidalaboralobrapersonal/{idobra}/{idpersonal}")
    public PersonalVidaLabDTO showUltimaVidaLaboral(@PathVariable String idobra, @PathVariable Long idpersonal){
        return personalvidalabService.ultimoPeriodoVidaLaboral(idobra, idpersonal);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/vidalaboralobrapersonallistdto/{idobra}/{idpersonal}")
    public List<PersonalVidaLabDTO> showVidaLaboralObraPersonalListDTO(@PathVariable String idobra, @PathVariable Long idpersonal){
        return personalvidalabService.findByObraPersonalListDTO(idobra, idpersonal);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/vidalaboralobrapersonaliddto/{idobra}/{idpersonal}/{idpervila}")
    public PersonalVidaLabDTO showVidaLaboralObraPersonalIdDTO(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable Long idpervila){
        return personalvidalabService.findByObraPersonalIdDTO(idobra, idpersonal, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/vidalaboralitemslist/{idobra}/{idpersonal}/{idpervila}/{estado}")
    public List<ItemListVidaLaboralDTO> showVidaLaboralItemsList(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable Long idpervila, @PathVariable String estado){
        return personalvidalabService.findItemsVidaLaboral(idobra, idpersonal, idpervila, estado);
    }




    //CRUD
    @PostMapping("/vidalaboralsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalVidaLabDTO vidaLab, BindingResult result) {
        PersonalVidaLaboral vidalabNew = null;
        PersonalVidaLaboral vidalabInsert = null;

        Personal persoContrato = personalservice.findByIdPersonalAndObraname(vidaLab.getIdPersonalPervila(), vidaLab.getIdObraPervila());

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
            vidalabInsert = new PersonalVidaLaboral();
            vidalabInsert.setIdObraPervila(vidaLab.getIdObraPervila());
            vidalabInsert.setIdPersonalPervila(persoContrato);
            vidalabInsert.setFechaInicioPervila(vidaLab.getFechaInicioPervila());
            vidalabInsert.setFechaFinPervila(vidaLab.getFechaFinPervila());
            vidalabInsert.setEstadoPervila(vidaLab.getEstadoPervila());
            vidalabInsert.setCreaPorPervila(vidaLab.getCreaPorPervila());
            vidalabInsert.setFechaIngPervila(new Date());

            vidalabNew  = personalvidalabService.save(vidalabInsert);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalvidalaboral", vidalabNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/contratoupdate/{idcontrato}/{idpersonal}/{obraname}/{idpervila}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalVidaLaboral updateContratoDTO  (@RequestBody PersonalVidaLabDTO vidalabDTO, @PathVariable String idobra, @PathVariable Long idpersonal,  @PathVariable Long idpervila) {
        PersonalVidaLaboral vidalabAct = personalvidalabService.findByObraPersonalId(idobra, idpersonal, idpervila);

        if(vidalabAct != null) {

            vidalabAct.setFechaInicioPervila(vidalabDTO.getFechaInicioPervila());
            vidalabAct.setFechaFinPervila(vidalabDTO.getFechaFinPervila());
            vidalabAct.setEstadoPervila(vidalabDTO.getEstadoPervila());
            vidalabAct.setModiPorPervila(vidalabDTO.getModiPorPervila());
            vidalabAct.setFechaModiPervila(new Date());
        }
        return personalvidalabService.save(vidalabAct);
    }

}
