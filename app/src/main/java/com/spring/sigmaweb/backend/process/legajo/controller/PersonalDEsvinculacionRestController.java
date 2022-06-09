package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDesvinculacionDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDocDesvDTO;
import com.spring.sigmaweb.backend.process.legajo.model.*;
import com.spring.sigmaweb.backend.process.legajo.reports.ReportDesvinculacion;
import com.spring.sigmaweb.backend.process.legajo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @PostMapping("/desvinculacionsave/{habilita}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalDesvinculacionDTO desvinculacion, @PathVariable Integer habilita, BindingResult result) {
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

            desvinculacionInsert.setFechaIngPerdesv(new Date());
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
                                                            desvinculacion.getFechaCesePerdesv(),
                                                            habilita);


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

            desvinculacionAct.setFechaModiPerdesv(new Date());
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

    @PostMapping("/docdesvinculasave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createDocDesv(@RequestBody DocumentoDesvinculacion docuDesvi, BindingResult result) {
        DocumentoDesvinculacion docDesvNew = null;
        DocumentoDesvinculacion docDesvInsert = null;

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
            docDesvInsert = new DocumentoDesvinculacion();
            docDesvInsert.setIdObraDocdesv(docuDesvi.getIdObraDocdesv());
            docDesvInsert.setDescripcionDocdesv(docuDesvi.getDescripcionDocdesv());
            docDesvInsert.setTipoDocdesv(docuDesvi.getTipoDocdesv());
            docDesvInsert.setDescripcionGrupoDocdesv(docuDesvi.getDescripcionGrupoDocdesv());
            docDesvInsert.setFlgInsertarMontoDocdesv(docuDesvi.getFlgInsertarMontoDocdesv());
            docDesvInsert.setFlgAdjuntarFileDocdesv(docuDesvi.getFlgAdjuntarFileDocdesv());

            docDesvNew = documentoemployeeservice.saveDocDesv(docDesvInsert);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("Documentodesvinculacion", docDesvNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/docdesvinculaupdate/{iddocdesv}/{obraname}/{tipo}")
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentoDesvinculacion updateDocDesvincula  (@RequestBody DocumentoDesvinculacion docuDesvi, @PathVariable Long iddocdesv, @PathVariable String obraname, @PathVariable String tipo) {
        DocumentoDesvinculacion docDesvAct = documentoemployeeservice.findByIdDocdesvAndIdObraDocdesvAndTipoDocdesv(iddocdesv,obraname, tipo);

        if(docDesvAct != null) {
            docDesvAct.setDescripcionDocdesv(docuDesvi.getDescripcionDocdesv());
            docDesvAct.setTipoDocdesv(docuDesvi.getTipoDocdesv());
            docDesvAct.setDescripcionGrupoDocdesv(docuDesvi.getDescripcionGrupoDocdesv());
            docDesvAct.setFlgInsertarMontoDocdesv(docuDesvi.getFlgInsertarMontoDocdesv());
            docDesvAct.setFlgAdjuntarFileDocdesv(docuDesvi.getFlgAdjuntarFileDocdesv());
        }
        return documentoemployeeservice.saveDocDesv(docDesvAct);
    }


    //--------------
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistpersonaldociddesvobra/{idPerentr}/{idPerentr}/{idObraPerentr}")
    public PersonalDocDesvinculacion showPersonalDcoDesvPorIdDesvinculacionObra(@PathVariable String idPerentr, @PathVariable Long idPerdesvPerentr, @PathVariable String idObraPerentr){
        return documentoemployeeservice.findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr(idPerentr, idPerdesvPerentr, idObraPerentr);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistpersonaldocdesvobradtolist/{perdesv}/{idobra}")
    public List<PersonalDocDesvDTO> showPersonalDocPorDesvinculacionObralist(@PathVariable Long perdesv, @PathVariable String idobra){
        return documentoemployeeservice.findDesvinculacionAndIdObralist(perdesv, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/countdocdesvobratipo/{idObra}/{tipo}")
    public long showPersonalDcoDesvPorIdDesvinculacionObra(@PathVariable String idObra, @PathVariable Long tipo){
        return desvinculacionService.countByIdObraPerentrAndIdTipoDocDesvPerentr(idObra, tipo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/checklistpersonaldociddesvobradto/{perdesv}/{idobra}/{idperentr}")
    public PersonalDocDesvDTO findDesvinculacionAndIdObralist(@PathVariable Long perdesv, @PathVariable String idobra, @PathVariable String idperentr){
        return documentoemployeeservice.findDesvinculacionAndIdObraAndId(perdesv, idobra, idperentr);
    }

    @PostMapping("/personaldocdesvsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPersonalDocDesv(@RequestBody PersonalDocDesvDTO docDesvPersNew, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        PersonalDocDesvDTO personalDocDesvAct=null;
        String newIId="";

        try {
            newIId = desvinculacionService.insertNativePersoDocDesv(docDesvPersNew);
            personalDocDesvAct = documentoemployeeservice.findDesvinculacionAndIdObraAndId( docDesvPersNew.getIdPerdesvPerentr(), docDesvPersNew.getIdObraPerentr(),newIId);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personaldocdesvinculacion", personalDocDesvAct);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);


    }


    @PutMapping("/personaldocdesvupdate/{idperdesv}/{obraname}/{idperentr}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalDocDesvDTO updatePersonalDocDesvDTO  (@RequestBody PersonalDocDesvDTO desvinculacionDTO, @PathVariable Long idperdesv, @PathVariable String obraname, @PathVariable String idperentr) {
        Integer res= -1;
        res=desvinculacionService.updatePerdocDesvincula(idperentr, obraname,idperdesv,
                desvinculacionDTO.getFlgEntregoPerentr(),
                desvinculacionDTO.getMontoPerentr(),
                desvinculacionDTO.getFechaEjecucionPerentr(),
                desvinculacionDTO.getIdfileUploadPerentr()
        );

        return documentoemployeeservice.findDesvinculacionAndIdObraAndId(idperdesv, obraname,idperentr);

        /*PersonalDocDesvinculacion personalDocDesvAct = documentoemployeeservice.findByIdPerentrAndIdPerdesvPerentrAndIdObraPerentr(idperentr,idperdesv, obraname);
        if(personalDocDesvAct != null) {

            personalDocDesvAct.setFlgEntregoPerentr(desvinculacionDTO.getFlgEntregoPerentr());
            personalDocDesvAct.setMontoPerentr(desvinculacionDTO.getMontoPerentr());
            personalDocDesvAct.setFechaEjecucionPerentr(desvinculacionDTO.getFechaEjecucionPerentr());
        }

        return documentoemployeeservice.saveDDoc(personalDocDesvAct);*/
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/perdocdesviculadelete/{idperentr}/{obraname}/{idperdesv}")
    public ResponseEntity<?> deleteDocDesvin(@PathVariable String idperentr, @PathVariable String obraname, @PathVariable Long idperdesv){

        Map<String, Object> response = new HashMap<>();

        try {
            PersonalDocDesvDTO personalDocDes = documentoemployeeservice.findDesvinculacionAndIdObraAndId(idperdesv, obraname,idperentr);

            desvinculacionService.deletePersonalDocDesv(idperentr, obraname, idperdesv);


        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el item de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se eliminaron los familiares con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
