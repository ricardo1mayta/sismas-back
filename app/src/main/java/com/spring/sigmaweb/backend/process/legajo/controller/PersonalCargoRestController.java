package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Cargo;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalCargo;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalCargoService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personal/cargo")
public class PersonalCargoRestController {
    @Autowired
    private IPersonalCargoService personalCargoService;

    @Autowired
    private IPersonalService personalservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporid/{idPercargo}")
    public PersonalCargo showPersonalCargoPorId(@PathVariable Long idPercargo){
        return personalCargoService.findByIdPercargo(idPercargo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobraid/{idpersona}/{idobra}/{idpercargo}")
    public PersonalCargo showPersonalCargoPorPersonalObraId(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercargo){
        return personalCargoService.findByPersonalAndObraAndIdCargo(idpersona, idobra, idpercargo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobra/{idpersona}/{idobra}")
    public List<PersonalCargo> showPersonalCargoPorPersonalObra(@PathVariable Long idpersona, @PathVariable String idobra){
        return personalCargoService.findByPersonalAndObraList(idpersona, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobraIddto/{idpersona}/{idobra}/{idpercargo}")
    public PersonalCargosDTO showPersonalCargoPorPersonalObraIdDto(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercargo){
        return personalCargoService.findPersonalAndObraAndCargoDto(idpersona, idobra, idpercargo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobraListdto/{idpersona}/{idobra}")
    public List<PersonalCargosDTO> showPersonalCargoPorPersonalObraIdDto(@PathVariable Long idpersona, @PathVariable String idobra){
        return personalCargoService.findPersonalAndObraListDto(idpersona, idobra);
    }

    //cargos
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/cargoporid/{idcargo}")
    public Cargo showCargoPorId(@PathVariable Long idcargo){
        return personalCargoService.findByIdCargo(idcargo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/cargoall")
    public List<Cargo> showCargoAll(){
        return personalCargoService.findAll();
    }

    //CRUD
    @PostMapping("/personalcargosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalCargosDTO cargo, BindingResult result) {
        PersonalCargo cargoNew = null;
        PersonalCargo cargoInsert = null;

        Personal persoCargo = personalservice.findByIdPersonalAndObraname(cargo.getIdPersonal(), cargo.getIdObraPercargo());
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
            cargoInsert = new PersonalCargo();

            cargoInsert.setIdObraPercargo(cargo.getIdObraPercargo());
            cargoInsert.setIdPersonalPercargo(persoCargo);
            cargoInsert.setIdCargoPercargo(cargo.getIdCargoPercargo());
            cargoInsert.setIdAreaPercont(cargo.getIdAreaPercont());
            cargoInsert.setIdTipoNivelPlanillaPercargo(cargo.getIdTipoNivelPlanillaPercargo());
            cargoInsert.setIdPuestoPercargo(cargo.getIdPuestoPercargo());

            cargoInsert.setFlgCargoPrincipalPercargo(cargo.getFlgCargoPrincipalPercargo());
            cargoInsert.setFlgCargoDirectivoPercargo(cargo.getFlgCargoDirectivoPercargo());
            cargoInsert.setFlgCargoConfianzaPercargo(cargo.getFlgCargoConfianzaPercargo());

            cargoInsert.setObservacionesPercargo(cargo.getObservacionesPercargo());
            cargoInsert.setFechaIniPercargo(cargo.getFechaIniPercargo());
            cargoInsert.setFechaFinPercargo(cargo.getFechaFinPercargo());

            cargoInsert.setEstadoPercargo(cargo.getEstadoPercargo());
            cargoInsert.setBonifCargoPercargo(cargo.getBonifCargoPercargo());
            cargoInsert.setBonifCargoEstPercargo(cargo.getBonifCargoEstPercargo());
            cargoInsert.setFechaIngPercargo(cargo.getFechaIngPercargo());
            cargoInsert.setCreaPorPercargo(cargo.getCreaPorPercargo());

            cargoNew = personalCargoService.save(cargoInsert);
            
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalcargo", cargoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/percargoupdate/{idpercargo}/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalCargo updatePersonalCargoDTO  (@RequestBody PersonalCargosDTO personalCargo, @PathVariable Long idpercargo, @PathVariable Long idpersonal, @PathVariable String obraname) {
        System.out.println(idpersonal);
        System.out.println(obraname);
        System.out.println(idpercargo);

        PersonalCargo percargoAct = personalCargoService.findByPersonalAndObraAndIdCargo(idpersonal, obraname, idpercargo);
        
        if(percargoAct !=null) {

            percargoAct.setIdCargoPercargo(personalCargo.getIdCargoPercargo());
            percargoAct.setIdAreaPercont(personalCargo.getIdAreaPercont());
            percargoAct.setIdTipoNivelPlanillaPercargo(personalCargo.getIdTipoNivelPlanillaPercargo());
            percargoAct.setIdPuestoPercargo(personalCargo.getIdPuestoPercargo());

            percargoAct.setFlgCargoPrincipalPercargo(personalCargo.getFlgCargoPrincipalPercargo());
            percargoAct.setFlgCargoDirectivoPercargo(personalCargo.getFlgCargoDirectivoPercargo());
            percargoAct.setFlgCargoConfianzaPercargo(personalCargo.getFlgCargoConfianzaPercargo());

            percargoAct.setObservacionesPercargo(personalCargo.getObservacionesPercargo());
            percargoAct.setFechaIniPercargo(personalCargo.getFechaIniPercargo());
            percargoAct.setFechaFinPercargo(personalCargo.getFechaFinPercargo());

            percargoAct.setEstadoPercargo(personalCargo.getEstadoPercargo());
            percargoAct.setBonifCargoPercargo(personalCargo.getBonifCargoPercargo());
            percargoAct.setBonifCargoEstPercargo(personalCargo.getBonifCargoEstPercargo());
            percargoAct.setFechaModiPercargo(personalCargo.getFechaModiPercargo());
            percargoAct.setModiPorPercargo(personalCargo.getModiPorPercargo());
        }
        return personalCargoService.save(percargoAct);
    }
            



}
