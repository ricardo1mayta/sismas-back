package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalConveniosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalConvenio;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalVidaLaboral;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalConvenioService;
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
@RequestMapping("/sigmaweb/legajo/personal/convenio")
public class PersonalConvenioRestController {
    @Autowired
    private IPersonalConvenioService personalConvenioService;

    @Autowired
    private IPersonalService personalService;

    @Autowired
    private IPersonalVidaLaboralService personalvidalaboralservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/findforid/{idPerConv}")
    public PersonalConvenio showconvenioPorId(@PathVariable Long idPerConv){
        return personalConvenioService.findByIdPerConv(idPerConv);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/findforidobrapersonal/{idpersonal}/{idobra}/{idPerConv}/{idpervila}")
    public PersonalConvenio showConvenioPorObraPersonalId(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idPerConv, @PathVariable Long idpervila){
        return personalConvenioService.findByPersonalAndObraAndConvenio(idpersonal, idobra, idPerConv, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/findforpersonalobra/{idpersonal}/{idobra}/{idpervila}")
    public List<PersonalConvenio> showConvenioPorObraPersonal(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalConvenioService.findByPersonalAndObraList(idpersonal, idobra, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/findforpersonalobraiddto/{idpersonal}/{idobra}/{idperconv}/{idpervila}")
    public PersonalConveniosDTO showConvenioPorObraPersonalIdDTO(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idperconv, @PathVariable Long idpervila){
        return personalConvenioService.findByPersonalAndObraAndConvenioDto(idpersonal, idobra, idperconv, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/findforpersonalobralistdto/{idpersonal}/{idobra}/{idpervila}")
    public List<PersonalConveniosDTO> showConvenioPorObraPersonalListDTO(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalConvenioService.findByPersonalAndObraListDto(idpersonal, idobra, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/convenioactivo/{idpersonal}/{idobra}/{idpervila}")
    public List<PersonalConveniosDTO> showConvenioActivoListDTO(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalConvenioService.findConvenioActivoPracticasListDto(idpersonal, idobra, idpervila);
    }

    @PostMapping("/conveniosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalConveniosDTO convenio, BindingResult result) {
        PersonalConvenio convenioNew = null;
        PersonalConvenio convenioInsert = null;
        Personal persoConvenio = personalService.findByIdPersonalAndObraname(convenio.getIdPersonal(), convenio.getIdObraPerconv());
        PersonalVidaLaboral vidaLaboral = personalvidalaboralservice.findByObraPersonalId(convenio.getIdObraPerconv(), convenio.getIdPersonal(), convenio.getIdPervila());
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

            if(convenio.getIdTipoPerconv() == 32006 || convenio.getIdTipoPerconv() == 32007){
                //practicas , se crea vida laboral
                if(vidaLaboral == null){
                    //CREA UNO NUEVO, ni no a tenido vida laboral reciente
                    vidaLaboral = new PersonalVidaLaboral();
                    vidaLaboral.setIdObraPervila(convenio.getIdObraPerconv());
                    vidaLaboral.setIdPersonalPervila(persoConvenio);
                    vidaLaboral.setFechaInicioPervila(convenio.getFechaIniPerconv());
                    vidaLaboral.setEstadoPervila("ACTIVO");
                    vidaLaboral.setFechaIngPervila(convenio.getFechaIngPerconv());
                    vidaLaboral.setCreaPorPervila(convenio.getCreaPorPerconv());

                    vidaLaboral = personalvidalaboralservice.save(vidaLaboral);
                }
            }

            convenioInsert  = new PersonalConvenio();
            convenioInsert.setIdObraPerconv(convenio.getIdObraPerconv());
            convenioInsert.setIdPersonalPerconv(persoConvenio);
            convenioInsert.setIdPervilaPerconv(vidaLaboral);
            convenioInsert.setIdTipoPerconv(convenio.getIdTipoPerconv());
            convenioInsert.setFechaIniPerconv(convenio.getFechaIniPerconv());
            convenioInsert.setFechaFinPerconv(convenio.getFechaFinPerconv());

            convenioInsert.setObservacionesPerconv(convenio.getObservacionesPerconv());
            convenioInsert.setEstadoPerconv(convenio.getEstadoPerconv());
            convenioInsert.setFechaTerminoPerconv(convenio.getFechaTerminoPerconv());

            convenioInsert.setFechaIngPerconv(new Date());
            convenioInsert.setCreaPorPerconv(convenio.getCreaPorPerconv());

            convenioNew = personalConvenioService.save(convenioInsert);
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalconvenio", convenioNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/convenioupdate/{idconvenio}/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalConvenio updateConvenioDTO  (@RequestBody PersonalConveniosDTO convenioDTO, @PathVariable Long idconvenio, @PathVariable Long idpersonal, @PathVariable String obraname) {
        PersonalConvenio convenioAct = personalConvenioService.findByPersonalAndObraAndConvenio(idpersonal, obraname, idconvenio, convenioDTO.getIdPervila());

        if(convenioAct != null) {
            convenioAct.setIdTipoPerconv(convenioDTO.getIdTipoPerconv());
            convenioAct.setFechaIniPerconv(convenioDTO.getFechaIniPerconv());
            convenioAct.setFechaFinPerconv(convenioDTO.getFechaFinPerconv());

            convenioAct.setObservacionesPerconv(convenioDTO.getObservacionesPerconv());
            convenioAct.setEstadoPerconv(convenioDTO.getEstadoPerconv());
            convenioAct.setFechaTerminoPerconv(convenioDTO.getFechaTerminoPerconv());

            convenioAct.setModiPorPerconv(convenioDTO.getModiPorPerconv());
            convenioAct.setFechaModiPerconv(new Date());
        }
        return personalConvenioService.save(convenioAct);
    }

}
