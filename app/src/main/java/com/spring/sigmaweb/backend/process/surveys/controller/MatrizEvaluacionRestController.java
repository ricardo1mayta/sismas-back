package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.generic.model.Periodo;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContratoJornada;
import com.spring.sigmaweb.backend.process.surveys.dto.MatrizEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.PersonalEvaluacionDTO;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
import com.spring.sigmaweb.backend.process.surveys.service.IMatrizEvaluadorService;
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
public class MatrizEvaluacionRestController {

    @Autowired
    private IMatrizEvaluadorService matrizEvaluadorService;


    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/matrizevalucionobrapersonalcargoEvaluador/{idobra}/{idpersonal}/{idcargoPuesto}/{esPrincipal}")
    public List<MatrizEvaluacionDTO> showPersonalEvaluacionEvaluadorList(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable Long idcargoPuesto, @PathVariable Integer esPrincipal){

        Boolean esprinc = (esPrincipal==1 ? true : false);
        return matrizEvaluadorService.findListaByObraByPeriodoByEventoidByEvaluador(idobra,idpersonal, idcargoPuesto, esprinc);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/matrizevalucionobrapersonalcargoEvaluado/{idobra}/{idpersonal}/{idcargoPuesto}/{esPrincipal}")
    public List<MatrizEvaluacionDTO> showPersonalEvaluacionEvaluadoList(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable Long idcargoPuesto, @PathVariable Integer esPrincipal){

        Boolean esprinc = (esPrincipal==1 ? true : false);
        return matrizEvaluadorService.findListaByObraByPeriodoByEventoidByEvaluado(idobra,idpersonal, idcargoPuesto, esprinc);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @PostMapping("/matrizevaluadorsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createMatrizEvaluacion(@RequestBody MatrizEvaluacionDTO matriz, BindingResult result) {
        MatrizEvaluacion matrizNew= null;
        MatrizEvaluacion matrizInsert= null;




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
            //Valida si ya esta registrado el mismo personal en la evaluación
            List<MatrizEvaluacion> findRes = matrizEvaluadorService.contarEvaluadoresEvaluado(matriz.getIdObraMaev(), matriz.getIdPersonalEvaluadorMaev(), matriz.getIdPersonalEvaluadoMaev());

            if(findRes !=null){
                if(findRes.size()>0){
                    response.put("mensaje", "Evaluador evalua mas de 1 vez al evaluado!");
                    response.put("error", "error de validación");
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
                }
            }


            matrizInsert = new MatrizEvaluacion();
            matrizInsert.setIdObraMaev(matriz.getIdObraMaev());
            matrizInsert.setIdPeriodoMaev(matriz.getIdPeriodoMaev());
            matrizInsert.setIdEventoMaev(matriz.getIdEventoMaev());
            matrizInsert.setIdEvaluadorMaev(matriz.getIdEvaluadorMaev());
            matrizInsert.setIdEvaluadoMaev(matriz.getIdEvaluadoMaev());
            matrizInsert.setEstadoMaev(matriz.getEstadoMaev());
            matrizInsert.setFechaingMaev(new Date());
            matrizInsert.setCreaporMaev(matriz.getCreaporMaev());

            matrizNew = matrizEvaluadorService.saveMatrizEvaluacion(matrizInsert);

        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("matrizevaluacion", matrizNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/deletematrizevaluacion/{idobra}/{idmatrizEval}/{idperiodo}/{idevento}")
    public ResponseEntity<?> deleteAll(@PathVariable Long idmatrizEval, @PathVariable String idobra, @PathVariable Long idperiodo, @PathVariable Long idevento){
        Map<String, Object> response = new HashMap<>();
        MatrizEvaluacion matrizdelete = matrizEvaluadorService.findByIdObraMaevAndIdMatrizEvalAndIdPeriodoMaevAndIdEventoMaev(idobra,idmatrizEval,idperiodo,idevento);
        try {


            if(matrizdelete != null){
                matrizEvaluadorService.deleteMatrizEvaluador(matrizdelete);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el registro correctamente");
        response.put("matrizevaluadorDel", matrizdelete);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/matrizevalucioncountEvaluadoresevaluado/{idobra}/{idpersonal}/{idcargoPuesto}/{esPrincipal}")
    public Integer countEvaluadoresPorEvaluador(@PathVariable String idobra, @PathVariable Long idpersonal, @PathVariable Long idcargoPuesto, @PathVariable Integer esPrincipal){
        Boolean esprinc = (esPrincipal==1 ? true : false);
        return matrizEvaluadorService.spuCountEvaluadoresEvaluado(idobra,idpersonal, idcargoPuesto, esprinc);
    }

}
