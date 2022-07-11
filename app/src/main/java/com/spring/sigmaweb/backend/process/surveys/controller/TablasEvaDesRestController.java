package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.generic.model.EventosPeriodo;
import com.spring.sigmaweb.backend.process.generic.service.IEventosPeriodoService;
import com.spring.sigmaweb.backend.process.surveys.dto.PreguntasCompetenciaDTO;
import com.spring.sigmaweb.backend.process.surveys.model.Competencia;
import com.spring.sigmaweb.backend.process.surveys.model.Pregunta;
import com.spring.sigmaweb.backend.process.surveys.model.PreguntasCompetencia;
import com.spring.sigmaweb.backend.process.surveys.service.ITablasEvaDesService;
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
@RequestMapping("/sigmaweb/evaluaciondesemp")
public class TablasEvaDesRestController {

    @Autowired
    private ITablasEvaDesService tablasevadesService;

    @Autowired
    private IEventosPeriodoService eventosperiodoService;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listapreguntasperiodo/{idperiodo}")
    public List<Pregunta> showPreguntasEvaDesList(@PathVariable Long idperiodo){
        return tablasevadesService.findByPreguntasForPeriodo(idperiodo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listapreguntasall")
    public List<Pregunta> showPreguntasEvaDesallList(){
        return tablasevadesService.findAllPregunta();
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listapreguntasactivo/{flgactivopreg}")
    public List<Pregunta> showPreguntasEvaDesaEstadolList(@PathVariable Integer flgactivopreg){
        Boolean estado = flgactivopreg == 1 ? true : false;
        return tablasevadesService.findByFlgActivoPreg(estado);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @PostMapping("/preguntasave/{idperiodo}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPregunta(@RequestBody Pregunta pregunta, @PathVariable Long idperiodo, BindingResult result) {
        Pregunta preguntaNew= null;
        Pregunta preguntaInsert= null;

        List<EventosPeriodo> findEvento= eventosperiodoService.findByIdObraEventAndTipoEventAndIdPeriodoEvent("SECTOR", 40101, idperiodo);

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
            if(findEvento.size() == 0) {
                response.put("mensaje", "Error al realizar el insert en la base de datos");
                response.put("error", "No existe un evento para evaluación de desempeño en el periodo seleccionado");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }

            if(findEvento.size() > 1) {
                response.put("mensaje", "Error al realizar el insert en la base de datos");
                response.put("error", "Hay mas de un evento de Evaluación de Desempeño en el mismo año");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }
            preguntaInsert = new Pregunta();
            preguntaInsert.setDescripcionPreg(pregunta.getDescripcionPreg());
            preguntaInsert.setIdEventoPreg(findEvento.get(0).getIdEvento());
            preguntaInsert.setFlgActivoPreg(pregunta.getFlgActivoPreg());
            preguntaInsert.setFechaingPreg(new Date());
            preguntaInsert.setCreaporPreg(pregunta.getCreaporPreg());

            preguntaNew = tablasevadesService.savePregunta(preguntaInsert);


        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("pregunta", preguntaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/preguntaupdate/{idpregunta}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pregunta updatePregunta(@RequestBody Pregunta pregunta, @PathVariable Long idpregunta) {
        Pregunta preguntaAct = tablasevadesService.findByIdPregunta(idpregunta);

        preguntaAct.setDescripcionPreg(pregunta.getDescripcionPreg());
        preguntaAct.setIdEventoPreg(pregunta.getIdEventoPreg());
        preguntaAct.setFlgActivoPreg(pregunta.getFlgActivoPreg());
        preguntaAct.setFechamodiPreg(new Date());
        preguntaAct.setModiporPreg(pregunta.getModiporPreg());

        return tablasevadesService.savePregunta(preguntaAct);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/preguntadelete/{idpregunta}/{idevento}")
    public ResponseEntity<?> deletePregunta(@PathVariable Long idpregunta, @PathVariable Long idevento){
        Map<String, Object> response = new HashMap<>();
        Pregunta preguntadelete = tablasevadesService.findByIdPreguntaAndIdEventoPreg(idpregunta, idevento);
        try {
            /*falta verificar que no este usado en otra tabla relacionada*/
            if(preguntadelete != null){
                tablasevadesService.deletePregunta(preguntadelete);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el registro correctamente");
        response.put("pregunta", preguntadelete);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //COMPETENCIAS

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listacompetenciasperiodo/{idperiodo}")
    public List<Competencia> showcompetenciasEvaDesList(@PathVariable Long idperiodo){
        return tablasevadesService.findByCompetenciaForPeriodo(idperiodo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listacompetenciasall")
    public List<Competencia> showCompetenciasEvaDesallList(){
        return tablasevadesService.findAllCompetencia();
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listacompetenciasactivo/{flgactivocompe}")
    public List<Competencia> showCompetenciasEvaDesaEstadolList(@PathVariable Integer flgactivocompe){
        Boolean estado = flgactivocompe == 1 ? true : false;
        return tablasevadesService.findByFlgActivoCompe(estado);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @PostMapping("/competenciasave/{idperiodo}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCompetencia(@RequestBody Competencia competencia, @PathVariable Long idperiodo, BindingResult result) {
        Competencia competenciaNew= null;
        Competencia competenciaInsert= null;

        List<EventosPeriodo> findEvento= eventosperiodoService.findByIdObraEventAndTipoEventAndIdPeriodoEvent("SECTOR", 40101, idperiodo);

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
            if(findEvento.size() == 0) {
                response.put("mensaje", "Error al realizar el insert en la base de datos");
                response.put("error", "No existe un evento para evaluación de desempeño en el periodo seleccionado");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }

            if(findEvento.size() > 1) {
                response.put("mensaje", "Error al realizar el insert en la base de datos");
                response.put("error", "Hay mas de un evento de Evaluación de Desempeño en el mismo año");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }
            competenciaInsert = new Competencia();
            competenciaInsert.setDescripcionCompe(competencia.getDescripcionCompe());
            competenciaInsert.setIdEventoCompe(findEvento.get(0).getIdEvento());
            competenciaInsert.setFlgActivoCompe(competencia.getFlgActivoCompe());
            competenciaInsert.setFechaingCompe(new Date());
            competenciaInsert.setCreaporCompe(competencia.getCreaporCompe());

            competenciaNew = tablasevadesService.saveCompetencia(competenciaInsert);

        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("competencia", competenciaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/competenciaupdate/{idcompetencia}")
    @ResponseStatus(HttpStatus.CREATED)
    public Competencia updateCompetencia(@RequestBody Competencia competencia, @PathVariable Long idcompetencia) {
        Competencia competenciaAct = tablasevadesService.findByIdCompetencia(idcompetencia);

        competenciaAct.setDescripcionCompe(competencia.getDescripcionCompe());
        competenciaAct.setIdEventoCompe(competencia.getIdEventoCompe());
        competenciaAct.setFlgActivoCompe(competencia.getFlgActivoCompe());
        competenciaAct.setFechamodiComp(new Date());
        competenciaAct.setModiporCompe(competencia.getModiporCompe());

        return tablasevadesService.saveCompetencia(competenciaAct);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/competenciadelete/{idcompetencia}/{idevento}")
    public ResponseEntity<?> deleteCompetencia(@PathVariable Long idcompetencia, @PathVariable Long idevento){
        Map<String, Object> response = new HashMap<>();
        Competencia competenciadelete = tablasevadesService.findByIdCompetenciaAndIdEventoCompe(idcompetencia, idevento);
        try {
            /*falta verificar que no este usado en otra tabla relacionada*/

            if(competenciadelete != null){
                tablasevadesService.deleteCompetencia(competenciadelete);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el registro correctamente");
        response.put("competencia", competenciadelete);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //PREGUNTAS X COMPETENCIA
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listapreguntasxcompetencia/{Ideventopregcomp}/{idgrupopregcomp}/{idcompetenciapregcomp}")
    public List<PreguntasCompetenciaDTO> showPreguntasPorCompetenciaList(@PathVariable Long Ideventopregcomp, @PathVariable Integer idgrupopregcomp, @PathVariable Long idcompetenciapregcomp){
        return tablasevadesService.findByIdEventoPregcompAndIdGrupoPregcompAndIdCompetenciaPregcompDto(Ideventopregcomp, idgrupopregcomp, idcompetenciapregcomp);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @PostMapping("/preguntacompetenciasave/{idperiodo}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPreguntaCompetencia(@RequestBody PreguntasCompetenciaDTO preguntacompetencia, @PathVariable Long idperiodo, BindingResult result) {
        PreguntasCompetencia pregcompeNew= null;
        PreguntasCompetencia pregcompeInsert= null;

        List<EventosPeriodo> findEvento= eventosperiodoService.findByIdObraEventAndTipoEventAndIdPeriodoEvent("SECTOR", 40101, idperiodo);

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
            if(findEvento.size() == 0) {
                response.put("mensaje", "Error al realizar el insert en la base de datos");
                response.put("error", "No existe un evento para evaluación de desempeño en el periodo seleccionado");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }

            if(findEvento.size() > 1) {
                response.put("mensaje", "Error al realizar el insert en la base de datos");
                response.put("error", "Hay mas de un evento de Evaluación de Desempeño en el mismo año");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }
            pregcompeInsert = new PreguntasCompetencia();
            pregcompeInsert.setIdCompetenciaPregcomp(preguntacompetencia.getIdCompetenciaPregcomp());
            pregcompeInsert.setIdPreguntaPregcomp(preguntacompetencia.getIdPreguntaPregcomp());
            pregcompeInsert.setIdGrupoPregcomp(preguntacompetencia.getIdGrupoPregcomp());
            pregcompeInsert.setIdEventoPregcomp(preguntacompetencia.getIdEventoPregcomp());

            pregcompeInsert.setFlgActivoPregcomp(preguntacompetencia.getFlgActivoPregcomp());
            pregcompeInsert.setFechaingPregcomp(new Date());
            pregcompeInsert.setCreaporPregcomp(preguntacompetencia.getCreaporPregcomp());

            pregcompeNew = tablasevadesService.savePreguntaComp(pregcompeInsert);

        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("preguntacompetencia", pregcompeNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/preguntacompetenciadelete/{idcompetencia}/{idPregunta}/{idgrupo}/{idevento}/{idpregcomp}")
    public ResponseEntity<?> deletePreguntaCompetencia(@PathVariable Long idcompetencia, @PathVariable Long idPregunta, @PathVariable Long idgrupo, @PathVariable Long idevento, @PathVariable Long idpregcomp){
        Map<String, Object> response = new HashMap<>();
        PreguntasCompetencia pregcompedelete = tablasevadesService.findByIdCompetenciaPregcompAndIdPreguntaPregcompAndIdGrupoPregcompAndIdEventoPregcompAndIdPregcomp(idcompetencia, idPregunta, idgrupo, idevento, idpregcomp);
        try {
            /*falta verificar que no este usado en otra tabla relacionada*/

            if(pregcompedelete != null){
                tablasevadesService.deletePreguntacomp(pregcompedelete);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el registro correctamente");
        response.put("preguntacompetencia", pregcompedelete);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
