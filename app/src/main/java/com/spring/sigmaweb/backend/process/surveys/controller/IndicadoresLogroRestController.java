package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.surveys.dto.EncuestaDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.IndicadoresGODto;
import com.spring.sigmaweb.backend.process.surveys.model.EvaluacionIndicadoresLogro;
import com.spring.sigmaweb.backend.process.surveys.service.IIndicadoresLogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/evaluaciondesemp/indicadoreslogro")
public class IndicadoresLogroRestController {

    @Autowired
    private IIndicadoresLogroService indicadoresLogroService;



    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listaindicadoresgo/{idobra}/{idgo}/{idpuesto}/{idevento}")
    public List<IndicadoresGODto> showPersonalEvaluacionEvaluadorList(@PathVariable String idobra, @PathVariable Integer idgo, @PathVariable Long idpuesto, @PathVariable Long idevento){

        return indicadoresLogroService.findByObraAndGrupoOcupacionalAndPuestoAndEvento(idobra, idgo, idpuesto, idevento);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/evaluacionindicadoreslogro/{idobra}/{idgo}/{idpuesto}/{idevento}")
    public List<EvaluacionIndicadoresLogroDTO> showEvalucionIndicadoresLogro(@PathVariable String idobra, @PathVariable Integer idgo, @PathVariable Long idpuesto, @PathVariable Long idevento){


        return indicadoresLogroService.findByEvaluacionObraGrupoocupacionalEvento(idobra, idgo, idpuesto, idevento);
    }


    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @PostMapping("/evaluacionindicadoressaveupdate")
    public ResponseEntity<?> createEvaluacionIndicadores(@RequestBody EvaluacionIndicadoresLogroDTO evaluacion, BindingResult result) {
        EvaluacionIndicadoresLogro evaluacionNew = null;
        EvaluacionIndicadoresLogro evaluacionInsert = null;
        Boolean isupdateable = false ;
        String tipoProc="";

        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try{
            EvaluacionIndicadoresLogro findEvaluacion = indicadoresLogroService.findByIdIndicgoEvalindlogAndIdObraEvalindlogAndIdPersonalEvalindlog(evaluacion.getIdIndicgoEvalindlog(), evaluacion.getIdObraEvalindlog(), evaluacion.getIdPersonalEvalindlog() );
            if(findEvaluacion != null){
                //ya esta registrado
                if(evaluacion.getIdEvalindlog() !=null){
                    if(evaluacion.getPromedioEvalindlog() == null && findEvaluacion.getPromedioEvalindlog() != null){
                        isupdateable=true;
                    } else if(evaluacion.getPromedioEvalindlog() != null && findEvaluacion.getPromedioEvalindlog() != null){
                        if(!findEvaluacion.getPromedioEvalindlog().equals(evaluacion.getPromedioEvalindlog()) ) {
                            isupdateable=true;
                        } else {
                            isupdateable=false;
                        }

                    } else {
                        isupdateable=false;
                    }

                    if(isupdateable){
                        findEvaluacion.setPromedioEvalindlog(evaluacion.getPromedioEvalindlog());
                        findEvaluacion.setModiporEvalindlog(evaluacion.getModiporEvalindlog());
                        findEvaluacion.setFechamodiEvalindlog(new Date());
                        tipoProc = "UPDATE";
                        evaluacionNew= indicadoresLogroService.saveEvaluacionIndLog(findEvaluacion);
                    }
                }
            } else {
                //crear
                if(evaluacion.getIdEvalindlog() ==null && evaluacion.getPromedioEvalindlog() != null ){
                    evaluacionInsert = new EvaluacionIndicadoresLogro();
                    evaluacionInsert.setIdIndicgoEvalindlog(evaluacion.getIdIndicgoEvalindlog());
                    evaluacionInsert.setIdObraEvalindlog(evaluacion.getIdObraEvalindlog());
                    evaluacionInsert.setIdPersonalEvalindlog(evaluacion.getIdPersonalEvalindlog());
                    evaluacionInsert.setPromedioEvalindlog(evaluacion.getPromedioEvalindlog());
                    evaluacionInsert.setCreaporEvalindlog(evaluacion.getCreaporEvalindlog());
                    evaluacionInsert.setModiporEvalindlog(evaluacion.getModiporEvalindlog());
                    tipoProc = "SAVE";
                    evaluacionNew = indicadoresLogroService.saveEvaluacionIndLog(evaluacionInsert);
                }
            }



        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("evaluacionindicadoreslogro", evaluacionNew);
        response.put("tipo", tipoProc);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }
}
