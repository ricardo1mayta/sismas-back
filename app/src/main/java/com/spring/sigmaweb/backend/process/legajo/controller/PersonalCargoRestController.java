package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.CargosDto;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalCargosDTO;
import com.spring.sigmaweb.backend.process.legajo.model.*;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalCargoService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalVidaLaboralService;
import com.spring.sigmaweb.backend.process.surveys.model.Encuesta;
import com.spring.sigmaweb.backend.process.surveys.model.MatrizEvaluacion;
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
@RequestMapping("/sigmaweb/legajo/personal/cargo")
public class PersonalCargoRestController {
    @Autowired
    private IPersonalCargoService personalCargoService;

    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private IPersonalVidaLaboralService personalvidalaboralservice;


    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporid/{idPercargo}")
    public PersonalCargo showPersonalCargoPorId(@PathVariable Long idPercargo){
        return personalCargoService.findByIdPercargo(idPercargo);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobraid/{idpersona}/{idobra}/{idpercargo}/{idpervila}")
    public PersonalCargo showPersonalCargoPorPersonalObraId(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercargo, @PathVariable Long idpervila){
        return personalCargoService.findByPersonalAndObraAndIdCargo(idpersona, idobra, idpercargo, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobra/{idpersona}/{idobra}/{idpervila}")
    public List<PersonalCargo> showPersonalCargoPorPersonalObra(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalCargoService.findByPersonalAndObraList(idpersona, idobra, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobraIddto/{idpersona}/{idobra}/{idpercargo/{idpervila}")
    public PersonalCargosDTO showPersonalCargoPorPersonalObraIdDto(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpercargo, @PathVariable Long idpervila){
        return personalCargoService.findPersonalAndObraAndCargoDto(idpersona, idobra, idpercargo, idpervila);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personalcargoporpersonalobraListdto/{idpersona}/{idobra}/{idpervila}")
    public List<PersonalCargosDTO> showPersonalCargoPorPersonalObraIdDto(@PathVariable Long idpersona, @PathVariable String idobra, @PathVariable Long idpervila){
        return personalCargoService.findPersonalAndObraListDto(idpersona, idobra, idpervila);
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

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/cargoporgoestado/{idgo}/{estadocargo}")
    public List<Cargo> showCargoPorGrupoOcupaAndEstado(@PathVariable Integer idgo, @PathVariable Integer estadocargo){
        Boolean estado = (estadocargo == 1 ? true : false);
        return personalCargoService.findByIdTipoGoCarAndEstadoCarOrderByNombreCar(idgo, estado);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/cargoestadodto/{estado}")
    public List<CargosDto> showCargoPorEstado(@PathVariable Integer estado){
        Boolean est = estado == 1;
        return personalCargoService.findCargosDto(est);
    }

    @PostMapping("/cargosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCargo(@RequestBody CargosDto cargo, BindingResult result) {
        Cargo cargoNew = null;
        Cargo cargoInsert = null;

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
            cargoInsert = new Cargo();

            cargoInsert.setNombreCar(cargo.getNombreCar());
            cargoInsert.setAbreviadoCar(cargo.getAbreviadoCar());
            cargoInsert.setEstadoCar(cargo.getEstadoCar());
            cargoInsert.setIdTipoGoCar(cargo.getIdTipoGoCar());
            cargoInsert.setFechaIngCar(new Date());
            cargoInsert.setCreaPorCar(cargo.getCreaPorCar());

            cargoNew = personalCargoService.savecargo(cargoInsert);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalpuesto", cargoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/cargoupdate")
    @ResponseStatus(HttpStatus.CREATED)
    public Cargo updatePuestos (@RequestBody CargosDto cargo) {

        Cargo cargoAct = personalCargoService.findByIdCargo(cargo.getIdCargo());

        if(cargoAct !=null) {
            cargoAct.setNombreCar(cargo.getNombreCar());
            cargoAct.setAbreviadoCar(cargo.getAbreviadoCar());
            cargoAct.setEstadoCar(cargo.getEstadoCar());
            cargoAct.setIdTipoGoCar(cargo.getIdTipoGoCar());
            cargoAct.setFechaModiCar(new Date());
            cargoAct.setModiPorCar(cargo.getModiPorCar());
        }
        return personalCargoService.savecargo(cargoAct);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/cargodelete/{idcargo}")
    public ResponseEntity<?> delete(@PathVariable Long idcargo ){

        Map<String, Object> response = new HashMap<>();

        try {
            Cargo cargo = personalCargoService.findByIdCargo(idcargo);
            personalCargoService.delete(cargo);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //Cargos TR
    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/cargotrporid/{idcargoTr}")
    public CargoTReg showCargoTrPorId(@PathVariable Long idcargoTr){
        return personalCargoService.findByIdCargoTr(idcargoTr);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/cargotrall")
    public List<CargoTReg> showCargoTrAll(){
        return personalCargoService.findAllCargoTr();
    }

    //CRUD
    @PostMapping("/personalcargosave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalCargosDTO cargo, BindingResult result) {
        PersonalCargo cargoNew = null;
        PersonalCargo cargoInsert = null;

        Personal persoCargo = personalservice.findByIdPersonalAndObraname(cargo.getIdPersonal(), cargo.getIdObraPercargo());
        PersonalVidaLaboral vidaLaboral = personalvidalaboralservice.findByObraPersonalId(cargo.getIdObraPercargo(), cargo.getIdPersonal(), cargo.getIdPervila());
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
            cargoInsert.setIdPervilaPercargo(vidaLaboral);
            cargoInsert.setIdPersonalPercargo(persoCargo);
            cargoInsert.setIdCargoPercargo(cargo.getIdCargoPercargo());
            cargoInsert.setIdAreaPercargo(cargo.getIdAreaPercargo());
            cargoInsert.setIdTipoNivelPlanillaPercargo(cargo.getIdTipoNivelPlanillaPercargo());
            cargoInsert.setIdPuestoPercargo(cargo.getIdPuestoPercargo());
            cargoInsert.setFlgCargoConfiPercargo(cargo.getFlgCargoConfiPercargo());
            cargoInsert.setFlgCargoDirePercargo(cargo.getFlgCargoDirePercargo());
            cargoInsert.setFlgCargoNofilcalPercargo(cargo.getFlgCargoNofilcalPercargo());
            cargoInsert.setFlgCargoNoAplicaPercargo(cargo.getFlgCargoNoAplicaPercargo());

            cargoInsert.setObservacionesPercargo(cargo.getObservacionesPercargo());
            cargoInsert.setFechaIniPercargo(cargo.getFechaIniPercargo());
            cargoInsert.setFechaFinPercargo(cargo.getFechaFinPercargo());

            cargoInsert.setEstadoPercargo(cargo.getEstadoPercargo());
            cargoInsert.setBonifCargoPercargo(cargo.getBonifCargoPercargo());
            cargoInsert.setBonifCargoEstPercargo(cargo.getBonifCargoEstPercargo());
            cargoInsert.setFechaIngPercargo(new Date());
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

    @PutMapping("/percargoupdate/{idpercargo}/{idpersonal}/{obraname}/{idpervila}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalCargo updatePersonalCargoDTO  (@RequestBody PersonalCargosDTO personalCargo, @PathVariable Long idpercargo, @PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idpervila) {

        PersonalCargo percargoAct = personalCargoService.findByPersonalAndObraAndIdCargo(idpersonal, obraname, idpercargo, idpervila);
        
        if(percargoAct !=null) {

            percargoAct.setIdCargoPercargo(personalCargo.getIdCargoPercargo());
            percargoAct.setIdAreaPercargo(personalCargo.getIdAreaPercargo());
            percargoAct.setIdTipoNivelPlanillaPercargo(personalCargo.getIdTipoNivelPlanillaPercargo());
            percargoAct.setIdPuestoPercargo(personalCargo.getIdPuestoPercargo());
            percargoAct.setFlgCargoConfiPercargo(personalCargo.getFlgCargoConfiPercargo());
            percargoAct.setFlgCargoDirePercargo(personalCargo.getFlgCargoDirePercargo());
            percargoAct.setFlgCargoNofilcalPercargo(personalCargo.getFlgCargoNofilcalPercargo());
            percargoAct.setFlgCargoNoAplicaPercargo(personalCargo.getFlgCargoNoAplicaPercargo());

            percargoAct.setObservacionesPercargo(personalCargo.getObservacionesPercargo());
            percargoAct.setFechaIniPercargo(personalCargo.getFechaIniPercargo());
            percargoAct.setFechaFinPercargo(personalCargo.getFechaFinPercargo());

            percargoAct.setEstadoPercargo(personalCargo.getEstadoPercargo());
            percargoAct.setBonifCargoPercargo(personalCargo.getBonifCargoPercargo());
            percargoAct.setBonifCargoEstPercargo(personalCargo.getBonifCargoEstPercargo());
            percargoAct.setFechaModiPercargo(new Date());
            percargoAct.setModiPorPercargo(personalCargo.getModiPorPercargo());
        }
        return personalCargoService.save(percargoAct);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/personalcargodelete/{idpercargo}/{idpersonal}/{obraname}/{idpervila}")
    public ResponseEntity<?> deleteAll(@PathVariable Long idpercargo, @PathVariable Long idpersonal, @PathVariable String obraname, @PathVariable Long idpervila) {
        Map<String, Object> response = new HashMap<>();

        PersonalCargo personalcargodelete = personalCargoService.findByPersonalAndObraAndIdCargo(idpersonal, obraname, idpercargo, idpervila);
        try {
            if(personalcargodelete != null){
                    personalCargoService.personalcargodelete(personalcargodelete);
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el registro");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se elimino el registro correctamente");
        response.put("matrizevaluadorDel", personalcargodelete);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
