package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.Pais;
import com.spring.sigmaweb.backend.process.generic.model.Periodo;
import com.spring.sigmaweb.backend.process.generic.service.IPeriodoService;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
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
@RequestMapping("/sigmaweb/api")
public class PeriodoRestController {
    @Autowired
    private IPeriodoService periodoservice;

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/periodosall/{idobraperi}/{orden}")
    public List<Periodo> showPeriodos(@PathVariable String idobraperi, @PathVariable String orden){
        return periodoservice.findByidObraPeriOrderByAnioPeri(orden, idobraperi);
    }

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/periodosall/{start}/{end}/{idobraperi}/{orden}")
    public List<Periodo> showPeriodosRango(@PathVariable Integer start, @PathVariable Integer end, @PathVariable String idobraperi, @PathVariable String orden){
        return periodoservice.findByAnioPeriBetweenOrderByAnioPeri(start, end, idobraperi, orden);
    }

    @PostMapping("/periodosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPeriodo(@RequestBody Periodo periodo, BindingResult result) {
        Periodo periodonew= null;
        Periodo periodoInsert= null;
        List<Periodo> listaPeri = periodoservice.findByidObraPeriAndAnioPeri(periodo.getIdObraPeri(), periodo.getAnioPeri());

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
            if(listaPeri.size()>0){
                response.put("mensaje", "Ya existe un periodo con este año!");
                response.put("error", "Error fila duplicada");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }

            periodoInsert = new Periodo();
            periodoInsert.setAnioPeri(periodo.getAnioPeri());
            periodoInsert.setIdObraPeri(periodo.getIdObraPeri());
            periodoInsert.setNombrePeri(periodo.getNombrePeri());
            periodoInsert.setFlgEstadoPeri(periodo.getFlgEstadoPeri());
            periodoInsert.setFechaIngPeri(new Date());
            periodoInsert.setCreaPorPeri(periodo.getCreaPorPeri());

            periodonew = periodoservice.savePeriodo(periodoInsert);

        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("periodo", periodonew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/periodoupdate/{idperiodo}/{idobra}")
    @ResponseStatus(HttpStatus.CREATED)
    public Periodo updatePeriodo(@RequestBody Periodo periodo, @PathVariable Long idperiodo, @PathVariable String idobra) {
        Periodo periodoAct = periodoservice.findByIdPeriodoAndIdObraPeri(idperiodo, idobra);

        periodoAct.setAnioPeri(periodo.getAnioPeri());
        periodoAct.setNombrePeri(periodo.getNombrePeri());
        periodoAct.setFlgEstadoPeri(periodo.getFlgEstadoPeri());
        periodoAct.setFechaModiPeri(new Date());
        periodoAct.setModiPorPeri(periodo.getModiPorPeri());

        return periodoservice.savePeriodo(periodoAct);

    }


}
