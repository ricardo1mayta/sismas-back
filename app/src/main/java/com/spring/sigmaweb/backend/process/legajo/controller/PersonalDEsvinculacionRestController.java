package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.*;
import com.spring.sigmaweb.backend.process.legajo.repository.IDocumentoDesvinculacionDao;
import com.spring.sigmaweb.backend.process.legajo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personal/desvinculacion")
public class PersonalDEsvinculacionRestController {
    @Autowired
    private IPersonalDesvinculacionService desvinculacionService;

    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private IPersonalVidaLaboralService personalvidalaboralservice;

    @Autowired
    private IDocumentEmployeeService documentoemployeeservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/desvinculacionporiddesvinculacion/{idPerDesv}")
    public PersonalDesvinculacion showDesvinculacionPorIdDesvinculacion(@PathVariable Long idPerDesv){
        return desvinculacionService.findByIdPerDesv(idPerDesv);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/desvinculacionporpersonalobracontratoid/{idpersonal}/{idobra}/{idperdesv}/{idpervila}")
    public PersonalDesvinculacion showDesvinculacionPorPersonalObraContratoId(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idperdesv, @PathVariable Long idpervila){
        return desvinculacionService.findByPersonalDesvinculacionActivos(idpersonal, idobra, idperdesv, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/desvinculacionporpersonalobraidvidalabdto/{idpersonal}/{idobra}/{idperdesv}/{idpervila}")
    public PersonalDesvinculacionDTO showDesvinculacionPorPersonalObraIdVidaLabDto(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idperdesv, @PathVariable Long idpervila){
        return desvinculacionService.findByPersonalDesvinculacionActivosDTO(idpersonal, idobra, idperdesv, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/desvinculacionporpersonalobravidalabactivoslistdto/{idpersonal}/{idobra}/{idpervila}")
    public List<PersonalDesvinculacionDTO> showDesvinculacionPorPersonalObraIdVidaLabListDto(@PathVariable Long idpersonal, @PathVariable String idobra, @PathVariable Long idpervila){
        return desvinculacionService.findByPersonalDesvinculacionActivosListDTO(idpersonal, idobra, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/desvinculacionporpersonalobralistdto/{idpersonal}/{idobra}")
    public List<PersonalDesvinculacionDTO> showDesvinculacionPorPersonalObraListDto(@PathVariable Long idpersonal, @PathVariable String idobra){
        return desvinculacionService.findByPersonalDesvinculacionListDTO(idpersonal, idobra);
    }

    @PostMapping("/desvinculacionsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalDesvinculacionDTO desvinculacion, BindingResult result) {
        PersonalDesvinculacion desvinculacionNew = null;
        PersonalDesvinculacion desvinculacionInsert = null;
        Personal persoDesvinculacion = personalservice.findByIdPersonalAndObraname(desvinculacion.getIdPersonal(), desvinculacion.getIdObraPerdesv());
        PersonalVidaLaboral vidaLaboral = personalvidalaboralservice.findByObraPersonalId(desvinculacion.getIdObraPerdesv(), desvinculacion.getIdPersonal(), desvinculacion.getIdPervila());

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
            desvinculacionInsert = new PersonalDesvinculacion();
            desvinculacionInsert.setIdObraPerdesv(desvinculacion.getIdObraPerdesv());
            desvinculacionInsert.setIdPersonalPerdesv(persoDesvinculacion);
            desvinculacionInsert.setIdPervilaPerdesv(vidaLaboral);
            desvinculacionInsert.setFechaCesePerdesv(desvinculacion.getFechaCesePerdesv());
            desvinculacionInsert.setIdMotivoPerdesv(desvinculacion.getIdMotivoPerdesv());
            desvinculacionInsert.setObservacionesPerdesv(desvinculacion.getObservacionesPerdesv());
            desvinculacionInsert.setFlgCompesacionPerdesv(desvinculacion.getFlgCompesacionPerdesv());
            desvinculacionInsert.setEstadoPerdesv(desvinculacion.getEstadoPerdesv());
            desvinculacionInsert.setCompeGraciaPerdesv(desvinculacion.getCompeGraciaPerdesv());
            desvinculacionInsert.setLiquidacionPerdesv(desvinculacion.getLiquidacionPerdesv());

            desvinculacionInsert.setFechaIngPerdesv(desvinculacion.getFechaIngPerdesv());
            desvinculacionInsert.setCreaPorPerdesv(desvinculacion.getCreaPorPerdesv());

            desvinculacionNew = desvinculacionService.save(desvinculacionInsert);
/*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00.00000");
            String dateDesv = sdf.format(desvinculacion.getFechaCesePerdesv());
            System.out.println(dateDesv);*/



            desvinculacionService.update_spu_desvinculacion(desvinculacionNew.getIdPersonalPerdesv().getIdPersonal(),
                                                            desvinculacionNew.getIdObraPerdesv(),
                                                            desvinculacionNew.getIdPervilaPerdesv().getIdPervila(),
                                                            desvinculacionNew.getCreaPorPerdesv(),
                                                            desvinculacion.getFechaCesePerdesv()
                                                            );
            

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personaldesvinculacion", desvinculacionNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/desvinculacionupdate/{idpersonal}/{obraname}/{idperdesv}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalDesvinculacion updateDesvinculacionDTO  (@RequestBody PersonalDesvinculacionDTO desvinculacionDTO, @PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idperdesv) {
        PersonalDesvinculacion desvinculacionAct = desvinculacionService.findByPersonalDesvinculacionId(idpersonal,obraname, idperdesv);

        if(desvinculacionAct != null) {

            desvinculacionAct.setFechaCesePerdesv(desvinculacionDTO.getFechaCesePerdesv());
            desvinculacionAct.setIdMotivoPerdesv(desvinculacionDTO.getIdMotivoPerdesv());
            desvinculacionAct.setObservacionesPerdesv(desvinculacionDTO.getObservacionesPerdesv());
            desvinculacionAct.setFlgCompesacionPerdesv(desvinculacionDTO.getFlgCompesacionPerdesv());
            desvinculacionAct.setEstadoPerdesv(desvinculacionDTO.getEstadoPerdesv());
            desvinculacionAct.setCompeGraciaPerdesv(desvinculacionDTO.getCompeGraciaPerdesv());
            desvinculacionAct.setLiquidacionPerdesv(desvinculacionDTO.getLiquidacionPerdesv());

            desvinculacionAct.setFechaModiPerdesv(desvinculacionDTO.getFechaModiPerdesv());
            desvinculacionAct.setModiPorPerdesv(desvinculacionDTO.getModiPorPerdesv());
        }

        return desvinculacionService.save(desvinculacionAct);

    }

    //Documentos Desvinculación
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistiddocdesv/{idDocdesv}/{idObraDocdesv}/{tipoDocdesv}")
    public DocumentoDesvinculacion showDocumentoDesvIdAndObraAndTipo(@PathVariable Long idDocdesv, @PathVariable String idObraDocdesv, @PathVariable String tipoDocdesv){
        return documentoemployeeservice.findByIdDocdesvAndIdObraDocdesvAndTipoDocdesv(idDocdesv, idObraDocdesv, tipoDocdesv);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistdocumentolist/{idObraDocdesv}/{tipoDocdesv}")
    public List<DocumentoDesvinculacion> showDesvinculacionPorPersonalObraListDto(@PathVariable String idObraDocdesv, @PathVariable String tipoDocdesv){

        return documentoemployeeservice.findByIdObraDocdesvAndTipoDocdesv(idObraDocdesv, tipoDocdesv);
    }
    //--------------
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistpersonaldociddesvobra/{idPerentr}/{idPerentr}/{idObraPerentr}")
    public PersonalDocDesvinculacion showPersonalDcoDesvPorIdDesvinculacionObra(@PathVariable Long idPerentr, @PathVariable Long idPerdesvPerentr, @PathVariable String idObraPerentr){
        return documentoemployeeservice.findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr(idPerentr, idPerdesvPerentr, idObraPerentr);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistpersonaldocdesvobradtolist/{perdesv}/{idobra}")
    public List<PersonalDocDesvDTO> showPersonalDocPorDesvinculacionObralist(@PathVariable Long perdesv, @PathVariable String idobra){
        return documentoemployeeservice.findDesvinculacionAndIdObralist(perdesv, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistpersonaldociddesvobradto/{perdesv}/{idobra}/{idperentr}")
    public PersonalDocDesvDTO findDesvinculacionAndIdObralist(@PathVariable Long perdesv, @PathVariable String idobra, @PathVariable Long idperentr){
        return documentoemployeeservice.findDesvinculacionAndIdObraAndId(perdesv, idobra, idperentr);
    }

    @PostMapping("/personaldocdesvsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPersonalDocDesv(@RequestBody PersonalDocDesvDTO docDesvPersNew, BindingResult result) {
        PersonalDocDesvinculacion docDesvPersonalNew = null;
        PersonalDocDesvinculacion docDesvPersonalInsert = null;

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
            docDesvPersonalInsert = new PersonalDocDesvinculacion();
            docDesvPersonalInsert.setIdPerdesvPerentr (docDesvPersNew.getIdPerdesvPerentr());
            docDesvPersonalInsert.setIdObraPerentr(docDesvPersNew.getIdObraPerentr());
            docDesvPersonalInsert.setIdTipoDocDesvPerentr(docDesvPersNew.getIdTipoDocDesvPerentr());
            docDesvPersonalInsert.setFlgEntregoPerentr(docDesvPersNew.getFlgEntregoPerentr());
            docDesvPersonalInsert.setMontoPerentr(docDesvPersNew.getMontoPerentr());
            docDesvPersonalInsert.setFechaEjecucionPerentr(docDesvPersNew.getFechaEjecucionPerentr());
            docDesvPersonalInsert.setIdResponsablePerentr(docDesvPersNew.getIdResponsablePerentr());

            docDesvPersonalNew = documentoemployeeservice.saveDDoc(docDesvPersonalInsert);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personaldocdesvinculacion", docDesvPersonalNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/personaldocdesvupdate/{idperdesv}/{obraname}/{idperentr}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalDocDesvinculacion updatePersonalDocDesvDTO  (@RequestBody PersonalDocDesvDTO desvinculacionDTO, @PathVariable Long idperdesv, @PathVariable String obraname, @PathVariable Long idperentr) {
        PersonalDocDesvinculacion personalDocDesvAct = documentoemployeeservice.findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr(idperentr,idperdesv, obraname);
        if(personalDocDesvAct != null) {

            personalDocDesvAct.setFlgEntregoPerentr(desvinculacionDTO.getFlgEntregoPerentr());
            personalDocDesvAct.setMontoPerentr(desvinculacionDTO.getMontoPerentr());
            personalDocDesvAct.setFechaEjecucionPerentr(desvinculacionDTO.getFechaEjecucionPerentr());
        }

        return documentoemployeeservice.saveDDoc(personalDocDesvAct);

    }





}
