package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.surveys.dto.EncuestaDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.Encuesta;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.service.IEncuestaService;
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
public class EncuestaRestController {

    @Autowired
    IEncuestaService encuestaService;

    public ResponseEntity<?> createEncuesta(@RequestBody EncuestaDTO encuesta, BindingResult result) {
        Encuesta encuestaNew= null;
        Encuesta encuestaInsert= null;


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
            //Valida si ya esta creada la evaluacion para la misma matriz
            Encuesta findEncuesta = encuestaService.findByIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(encuesta.getIdMatrizevalEncuesta(),
                                                                                                            encuesta.getIdObraEncuesta(), encuesta.getIdEventoMaev());
            if(findEncuesta !=null){
                response.put("mensaje", "Id Matriz Ya esta registrado!");
                response.put("error", "error de validación");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }

            encuestaInsert.setIdMatrizevalEncuesta(encuesta.getIdMatrizevalEncuesta());
            encuestaInsert.setIdObraEncuesta(encuesta.getIdObraEncuesta());
            encuestaInsert.setTotalPreguntasEncuesta(encuesta.getTotalPreguntasEncuesta());
            encuestaInsert.setFlg_activoEncuesta(true);
            encuestaInsert.setFlgEstadoEncuesta("R");
            encuestaInsert.setFechaingEncuesta(new Date());
            encuestaInsert.setCreaporEncuesta(encuesta.getCreaporEncuesta());

            encuestaNew = encuestaService.saveEncuesta(encuestaInsert);

        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("encuesta", encuestaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/deleteencuesta/{idobra}/{idmatrizEval}/{idencuesta}/{idevento}")
    public ResponseEntity<?> deleteEncuesta(@PathVariable String idobra, @PathVariable Long idmatrizEval, @PathVariable Long idencuesta, @PathVariable Long idevento){
        Map<String, Object> response = new HashMap<>();
        Boolean esEliminable=false;
        //Verifica que no exista preguntas ya registradas
        Encuesta encuestadelete = encuestaService.findByIdEncuestaAndIdMatrizevalEncuestaAndIdObraEncuestaAndEvento(idencuesta,idmatrizEval,idobra,idevento);

        try {

            if(encuestadelete != null){
                //verificaque que valide para eliminar
                esEliminable = encuestaService.estadodeEncuestaBorrar(idencuesta,idmatrizEval,idobra);
                if(esEliminable){
                    encuestaService.deleteEncuesta(encuestadelete);
                } else {
                    response.put("mensaje", "No se puede eliminar hay datos relacionados");
                    response.put("error", "tiene respuestas ya asignadas o estado ya no es (R)egistrado");
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
                }
            } else {
                response.put("mensaje", "No se encuentra la encuesta");
                response.put("error", "encuesta indicada no se encuentra:" + idencuesta +"," + idmatrizEval+","+ idobra + "," + idevento);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el registro correctamente");
        response.put("encuestadelete", encuestadelete);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }



}
