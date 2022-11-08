package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.dto.PersonaDTO;
import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.generic.service.IPersonaService;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import com.spring.sigmaweb.backend.process.legajo.service.PersonalService;
import com.spring.sigmaweb.backend.process.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sigmaweb/persona")
@RequiredArgsConstructor
public class PersonaRestController {

    private final IPersonaService personaService;
    private final PersonalService personalService;
    private final ModelMapper mapper ;

    @GetMapping("/buscar/obra")
    public ResponseEntity< List<PersonaDTO>> findByObraPers(@RequestParam String idObra){

       return new ResponseEntity<>(personaService.findByObraPers(idObra).stream().map(p->mapper.map(p,PersonaDTO.class)).collect(Collectors.toList()), HttpStatus.OK);

    }

    @GetMapping("/buscar/idPersona")
    public ResponseEntity< PersonaDTO> findByIdPersona(@RequestParam Long id){
//        personaService.findByIdPersona(id);
        return new ResponseEntity<>(mapper.map(personaService.findByIdPersona(id),PersonaDTO.class),HttpStatus.OK);
    }

    @PostMapping
    public Persona create(@RequestBody PersonaDTO persona){
//      return personaService.save(persona);

        Persona findPersonaNroDoc = personaService.findByNroDocPersAndObraPers(persona.getNroDocPers(), persona.getObraPers());

        if (findPersonaNroDoc == null) {
            return   personaService.save(mapper.map(persona,Persona.class));
        } else {
            return null;
        }
    }

    @PutMapping
    public Persona update(@RequestBody PersonaDTO persona){

        return   personaService.update(mapper.map(persona,Persona.class));
    }

    @PutMapping("update/estado")
    public Persona updatePersona(@RequestParam Long idPersona){
        Persona entidad= personaService.findByIdPersona(idPersona);
        entidad.setEstadoPers(Constants.FLAG_ESTADO.INACTIVO);
        return personaService.save(entidad);
    }
}
