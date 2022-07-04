package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.dto.EventosPeriodoDTO;
import com.spring.sigmaweb.backend.process.generic.model.Departamento;
import com.spring.sigmaweb.backend.process.generic.model.EventosPeriodo;
import com.spring.sigmaweb.backend.process.generic.model.Periodo;
import com.spring.sigmaweb.backend.process.generic.service.IEventosPeriodoService;
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

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/sigmaweb/api/eventos")
public class EventosPeriodoRestController {
    @Autowired
    private IEventosPeriodoService eventosperiodoservice;

    @Secured({"ROLE_ADMI","ROLE_COLA"})
    @GetMapping("/eventosperiodolista/{idobra}/{idperiodo}/{estadoevent}/{tipoevent}")
    public List<EventosPeriodoDTO> showEventosPeriodoListas(@PathVariable String idobra, @PathVariable Long idperiodo, @PathVariable String estadoevent, @PathVariable String tipoevent) {
        return eventosperiodoservice.findByObraAndPeriodoAndAnioPeri(idobra, idperiodo, estadoevent, tipoevent);
    }

    @PostMapping("/eventoperiodosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPeriodo(@RequestBody EventosPeriodoDTO evento, BindingResult result) {
        EventosPeriodo eventoPernew= null;
        EventosPeriodo eventoPerInsert= null;

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
            eventoPerInsert = new EventosPeriodo();
            eventoPerInsert.setIdPeriodoEvent(evento.getIdPeriodoEvent());
            eventoPerInsert.setIdObraEvent(evento.getIdObraEvent());
            eventoPerInsert.setTipoEvent(evento.getTipoEvent());
            eventoPerInsert.setNombreEvent(evento.getNombreEvent());
            eventoPerInsert.setDescripcionEvent(evento.getDescripcionEvent());
            eventoPerInsert.setFlgEstadoEvent(evento.getFlgEstadoEvent());
            eventoPerInsert.setFechaIniEvent(evento.getFechaIniEvent());
            eventoPerInsert.setFechaFinEvent(evento.getFechaFinEvent());

            eventoPerInsert.setFechaingEvent(new Date());
            eventoPerInsert.setCreaporEvent(evento.getCreaporEvent());

            eventoPernew = eventosperiodoservice.saveEvento(eventoPerInsert);

        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("eventoperiodo", eventoPernew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/eventoperiodoupdate/{ideventoperiodo}/{idobra}")
    @ResponseStatus(HttpStatus.CREATED)
    public EventosPeriodo updatePeriodo(@RequestBody EventosPeriodoDTO evento, @PathVariable Long ideventoperiodo, @PathVariable String idobra) {
        EventosPeriodo eventoAct = eventosperiodoservice.findByIdEventoAndIdObraEvent(ideventoperiodo, idobra);


        eventoAct.setIdPeriodoEvent(evento.getIdPeriodoEvent());
        eventoAct.setTipoEvent(evento.getTipoEvent());
        eventoAct.setNombreEvent(evento.getNombreEvent());
        eventoAct.setDescripcionEvent(evento.getDescripcionEvent());
        eventoAct.setFlgEstadoEvent(evento.getFlgEstadoEvent());
        eventoAct.setFechaIniEvent(evento.getFechaIniEvent());
        eventoAct.setFechaFinEvent(evento.getFechaFinEvent());

        eventoAct.setFechamodiEvent(new Date());
        eventoAct.setModiporEvent(evento.getModiporEvent());

        return eventosperiodoservice.saveEvento(eventoAct);

    }

}
