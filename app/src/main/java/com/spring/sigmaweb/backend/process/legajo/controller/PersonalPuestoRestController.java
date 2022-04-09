package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalPuestoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PuestosDto;
import com.spring.sigmaweb.backend.process.legajo.model.*;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalPuestoService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalVidaLaboralService;
import com.spring.sigmaweb.backend.process.legajo.service.IPuestoService;
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
@RequestMapping("/sigmaweb/legajo/personal/puesto")
public class PersonalPuestoRestController {
    @Autowired
    private IPersonalPuestoService personalpuestoservice;

    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private IPersonalVidaLaboralService personalvidalaboralservice;

    @Autowired
    private IPuestoService puestosservice;

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalpuestopersonalobravila/{idpersona}/{idobra}/{idpervila}")
    public List<PersonalPuesto> showPersonalPuestoForPersonalAndObraAndVila(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalpuestoservice.findByIdPersonalAndIdobraAndIdPervila(idpersona, idobra, idpervila);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/puestopersonalobravilaid/{idpersona}/{idobra}/{idpervila}/{idperpuesto}")
    public PersonalPuesto showPersonalPuestoForPersonalAndObraAndId(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpervila, @PathVariable Long idperpuesto){
        return personalpuestoservice.findByIdPersonalAndIdobraAndIdPervilaAndId(idpersona, idobra, idpervila, idperpuesto);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalpuestopersonalobraviladto/{idpersona}/{idobra}/{idpervila}")
    public List<PersonalPuestoDTO> showPersonalPuestoForPersonalAndObraAndVilaDTO(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalpuestoservice.findByObraPersonalVidaLab(idpersona, idobra, idpervila);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/puestopersonalobravilaiddto/{idpersona}/{idobra}/{idpervila}/{idperpuesto}")
    public PersonalPuestoDTO showPersonalPuestoForPersonalAndObraAndIdDTO(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpervila, @PathVariable Long idperpuesto){
        return personalpuestoservice.findByObraPersonalVidaLabId(idpersona, idobra, idpervila, idperpuesto);
    }

    //CRUD
    @PostMapping("/personalpuestosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalPuestoDTO puesto, BindingResult result) {
        PersonalPuesto puestoNew = null;
        PersonalPuesto puestoInsert = null;

        Personal persoPuesto = personalservice.findByIdPersonalAndObraname(puesto.getIdPersonal(), puesto.getIdObraPerpuest());
        PersonalVidaLaboral vidaLaboral = personalvidalaboralservice.findByObraPersonalId(puesto.getIdObraPerpuest(), puesto.getIdPersonal(), puesto.getIdPervila());

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
            puestoInsert = new PersonalPuesto();

            puestoInsert.setIdObraPerpuest(puesto.getIdObraPerpuest());
            puestoInsert.setIdPersonalPerpuest(persoPuesto);
            puestoInsert.setIdPuestoPerpuest(puesto.getIdPuestoPerpuest());
            puestoInsert.setIdPervilaPerpuest (vidaLaboral);
            puestoInsert.setIdAreaPerpuest(puesto.getIdAreaPerpuest());
            puestoInsert.setIdTipoNivelPlanillaPerpuest(puesto.getIdTipoNivelPlanillaPerpuest());
            puestoInsert.setIdPuestoTPerpuest(puesto.getIdPuestoTPerpuest());
            puestoInsert.setFlgPuestoDirePerpuest(puesto.getFlgPuestoDirePerpuest());
            puestoInsert.setFlgPuestoConfiPerpuest(puesto.getFlgPuestoConfiPerpuest());
            puestoInsert.setFlgPuestoNofilcalPerpuest(puesto.getFlgPuestoNofilcalPerpuest());
            puestoInsert.setFlgPuestoNoAplicaPerpuest(puesto.getFlgPuestoNoAplicaPerpuest());

            puestoInsert.setObservacionesPerpuest(puesto.getObservacionesPerpuest());
            puestoInsert.setFechaIniPerpuest(puesto.getFechaIniPerpuest());
            puestoInsert.setFechaFinPerpuest(puesto.getFechaFinPerpuest());
            puestoInsert.setEstadoPerpuest(puesto.getEstadoPerpuest());
            puestoInsert.setBonifCargoPerpuest(puesto.getBonifCargoPerpuest());

            puestoInsert.setFechaIngPerpuest(new Date());
            puestoInsert.setCreaPorPerpuest(puesto.getCreaPorPerpuest());

            puestoNew = personalpuestoservice.save(puestoInsert);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalpuesto", puestoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @PutMapping("/perpuestoupdate/{idperpuesto}/{idpersonal}/{obraname}/{idpervila}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalPuesto updatePersonalCargoDTO  (@RequestBody PersonalPuestoDTO personalpuesto, @PathVariable Long idperpuesto, @PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idpervila) {

        PersonalPuesto perpuestoAct = personalpuestoservice.findByIdPersonalAndIdobraAndIdPervilaAndId(idpersonal, obraname, idpervila, idperpuesto);

        if(perpuestoAct !=null) {

            perpuestoAct.setIdPuestoPerpuest(personalpuesto.getIdPuestoPerpuest());
            perpuestoAct.setIdAreaPerpuest(personalpuesto.getIdAreaPerpuest());
            perpuestoAct.setIdTipoNivelPlanillaPerpuest(personalpuesto.getIdTipoNivelPlanillaPerpuest());
            perpuestoAct.setIdPuestoTPerpuest(personalpuesto.getIdPuestoTPerpuest());
            System.out.println(personalpuesto.getIdPuestoTPerpuest());
            perpuestoAct.setFlgPuestoDirePerpuest(personalpuesto.getFlgPuestoDirePerpuest());
            perpuestoAct.setFlgPuestoConfiPerpuest(personalpuesto.getFlgPuestoConfiPerpuest());
            perpuestoAct.setFlgPuestoNofilcalPerpuest(personalpuesto.getFlgPuestoNofilcalPerpuest());
            perpuestoAct.setFlgPuestoNoAplicaPerpuest(personalpuesto.getFlgPuestoNoAplicaPerpuest());

            perpuestoAct.setObservacionesPerpuest(personalpuesto.getObservacionesPerpuest());
            perpuestoAct.setFechaIniPerpuest(personalpuesto.getFechaIniPerpuest());
            perpuestoAct.setFechaFinPerpuest(personalpuesto.getFechaFinPerpuest());
            perpuestoAct.setEstadoPerpuest(personalpuesto.getEstadoPerpuest());
            perpuestoAct.setBonifCargoPerpuest(personalpuesto.getBonifCargoPerpuest());
            perpuestoAct.setFechaModiPerpuest(new Date());
            perpuestoAct.setModiPorPerpuest(personalpuesto.getModiPorPerpuest());

        }
        return personalpuestoservice.save(perpuestoAct);
    }
    //CRUD DEL PUESTO
    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/puestoidobra/{idPuesto}/{idObraPues}")
    public Puestos showPuestoPoridObra(@PathVariable Long idPuesto, @PathVariable String idObraPues){
        return puestosservice.findByIdPuestoAndIdObraPues(idPuesto, idObraPues);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/puestocodigoobra/{codigoPues}/{idObraPues}")
    public Puestos showPuestoPorCodigoObra(@PathVariable String codigoPues, @PathVariable String idObraPues){
        return puestosservice.findByCodigoPuesAndIdObraPues(codigoPues, idObraPues);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/puestoobraestadolist/{idObraPues}/{estadoPues}")
    public List<PuestosDto> showPuestoPorObraEstadoList(@PathVariable String idObraPues, @PathVariable Integer estadoPues){
        Boolean estado = estadoPues == 1;
        return puestosservice.findByIdObraPuesAndEstadoPues(idObraPues, estado);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/puestoobralist/{idObraPues}")
    public List<PuestosDto> showPuestoPorObraList(@PathVariable String idObraPues){
        return puestosservice.findByIdObraPues(idObraPues );
    }

    @PostMapping("/puestosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPuestos(@RequestBody PuestosDto puesto, BindingResult result) {
        Puestos puestoNew = null;
        Puestos puestoInsert = null;

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
            puestoInsert = new Puestos();

            puestoInsert.setNombrePues(puesto.getNombrePues());
            puestoInsert.setAbreviadoPues(puesto.getAbreviadoPues());
            puestoInsert.setCodigoPues(puesto.getCodigoPues());
            puestoInsert.setIdObraPues(puesto.getIdObraPues());
            puestoInsert.setEstadoPues(puesto.getEstadoPues());
            puestoInsert.setIdTipoGoPues(puesto.getIdTipoGoPues());
            puestoInsert.setFechaIngPues(new Date());
            puestoInsert.setCreaPorPues(puesto.getCreaPorPues());

            puestoNew = puestosservice.save(puestoInsert);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalpuesto", puestoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/puestoupdate")
    @ResponseStatus(HttpStatus.CREATED)
    public Puestos updatePuestos (@RequestBody PuestosDto puesto) {

        Puestos puestoAct =puestosservice.findByIdPuestoAndIdObraPues(puesto.getIdPuesto(), puesto.getIdObraPues());

        if(puestoAct !=null) {
            puestoAct.setNombrePues(puesto.getNombrePues());
            puestoAct.setAbreviadoPues(puesto.getAbreviadoPues());
            puestoAct.setCodigoPues(puesto.getCodigoPues());

            puestoAct.setEstadoPues(puesto.getEstadoPues());
            puestoAct.setIdTipoGoPues(puesto.getIdTipoGoPues());
            puestoAct.setFechaModiPues(new Date());
            puestoAct.setModiPorPues(puesto.getCreaPorPues());
        }
        return puestosservice.save(puestoAct);
    }




}
