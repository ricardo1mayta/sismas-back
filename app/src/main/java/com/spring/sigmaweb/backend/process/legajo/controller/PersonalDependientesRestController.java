package com.spring.sigmaweb.backend.process.legajo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;
import com.spring.sigmaweb.backend.process.generic.service.ITablasTablaService;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDependienteDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalDependiente;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalDependientesService;
import com.spring.sigmaweb.backend.process.legajo.service.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/personal/dependiente")
public class PersonalDependientesRestController {
    @Autowired
    private IPersonalDependientesService personaldependienteservice;

    @Autowired
    private IPersonalService personalservice;

    @Autowired
    private ITablasTablaService tablastablaservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personaldepenporidperyobra/{idpersonaldep}/{idpersonal}/{obraname}")
    public PersonalDependiente showpersonaldepporiddep(@PathVariable Long idpersonaldep, @PathVariable Long idpersonal, @PathVariable String obraname) {
        return personaldependienteservice.findByIdPersonalAndObraname(idpersonaldep, idpersonal, obraname);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personaldepenporidperyobraList/{idpersonal}/{idobra}")
    public List<PersonalDependienteDTO> showpersonaldelporidpersonalyobra(@PathVariable Long idpersonal, @PathVariable String idobra) {
        return personaldependienteservice.findByIdPersonalAndIdObra(idpersonal, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/personaldepenporidandidperyobra/{idpersonal}/{idobra}")
    public PersonalDependienteDTO showPersonalDepPorIdpersyobra( @PathVariable Long idpersonaldep, @PathVariable Long idpersonal, @PathVariable String idobra) {
        return personaldependienteservice.findByIdPersonalAndIdObraAndIdPerDep(idpersonaldep, idpersonal, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/personaldependientedelete/{idpersonaldep}/{idpersonal}/{obraname}")
    public ResponseEntity<?> delete(@PathVariable Long idpersonaldep, @PathVariable Long idpersonal, @PathVariable String obraname){

        Map<String, Object> response = new HashMap<>();

        try {
            PersonalDependiente personalDep = personaldependienteservice.findByIdPersonalAndObraname(idpersonaldep, idpersonal, obraname);
            personaldependienteservice.delete(personalDep);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el Familiar de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se eliminaron los familiares con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @DeleteMapping("/personaldependientedeleteAll/{idpersonal}/{obraname}")
    public ResponseEntity<?> deleteAll(@PathVariable Long idpersonal, @PathVariable String obraname){
        Map<String, Object> response = new HashMap<>();

        try {
            List<PersonalDependiente> personalDepList = personaldependienteservice.findByIdPersonalAndObranameList(idpersonal, obraname);
            personaldependienteservice.deleteAll(personalDepList);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el Familiar de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se eliminaron los familiares con exito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/personaldepsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PersonalDependienteDTO personaldep, BindingResult result) {
        PersonalDependiente personalDepNew = null;
        PersonalDependiente personalDepInsert = null;
        Personal personal = personalservice.findByIdPersonalAndObraname(personaldep.getIdPersonal(), personaldep.getIdobra());
        TablasTabla tablaT = tablastablaservice.findByCodigoTab(personaldep.getIdparentPerDep());

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
            personalDepInsert =new PersonalDependiente();
            personalDepInsert.setPersonalDep(personal);
            personalDepInsert.setParentescoPerDep(tablaT);
            personalDepInsert.setFlgvive(personaldep.getFlgvive());
            personalDepInsert.setFlgDiscapacidadPerdep(personaldep.getFlgDiscapacidadPerdep());
            personalDepInsert.setNombrePerDep(personaldep.getNombrePerDep());
            personalDepInsert.setApPaternoPerDep(personaldep.getApPaternoPerDep());
            personalDepInsert.setApMaternoPerDep(personaldep.getApMaternoPerDep());
            personalDepInsert.setSexoAPerDep(personaldep.getSexoAPerDep());

            tablaT = tablastablaservice.findByCodigoTab(personaldep.getIdEstcivPerDep());
            personalDepInsert.setEstCivilPerDep(tablaT);

            personalDepInsert.setIdTipoDocPerDep(personaldep.getIdTipodocPerDep());
            personalDepInsert.setNroDocPerDep(personaldep.getNroDocPerDep());
            personalDepInsert.setFechaNacPerDep(personaldep.getFechaNacPerDep());
            personalDepInsert.setNacionalidadPerDep(personaldep.getNacionalidadPerDep());
            personalDepInsert.setTelefonoPerDep(personaldep.getTelefonoPerDep());
            if(personaldep.getGradoAcademicoPerDep() == null) {
                personalDepInsert.setGradoAcademicoPerDep(Long.parseLong( "140"));
            } else {
                personalDepInsert.setGradoAcademicoPerDep(personaldep.getGradoAcademicoPerDep());
            }

            personalDepInsert.setFlgEstudiaActPerDep(personaldep.getFlgEstudiaActPerDep());
            personalDepInsert.setNombreInstEducPerDep(personaldep.getNombreInstEducPerDep());
            personalDepInsert.setCreaPorPerDep(personaldep.getCreaPorPerDep());

            personalDepNew = personaldependienteservice.save(personalDepInsert);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("personalDependiente", personalDepNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);


    }

    @PutMapping("/personaldepupdate/{idpersonaldep}/{idpersonal}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalDependiente updatepersonaldepDTO(@RequestBody PersonalDependienteDTO personaldepDTO, @PathVariable Long idpersonaldep, @PathVariable Long idpersonal, @PathVariable String obraname) {
        PersonalDependiente personalDepAct = personaldependienteservice.findByIdPersonalAndObraname(idpersonaldep, idpersonal, obraname);
        TablasTabla tablaT = tablastablaservice.findByCodigoTab(personaldepDTO.getIdparentPerDep());

        personalDepAct.setParentescoPerDep(tablaT);
        personalDepAct.setFlgvive(personaldepDTO.getFlgvive());
        personalDepAct.setFlgDiscapacidadPerdep(personaldepDTO.getFlgDiscapacidadPerdep());
        personalDepAct.setNombrePerDep(personaldepDTO.getNombrePerDep());
        personalDepAct.setApPaternoPerDep(personaldepDTO.getApPaternoPerDep());
        personalDepAct.setApMaternoPerDep(personaldepDTO.getApMaternoPerDep());
        personalDepAct.setSexoAPerDep(personaldepDTO.getSexoAPerDep());

        tablaT = tablastablaservice.findByCodigoTab(personaldepDTO.getIdEstcivPerDep());
        personalDepAct.setEstCivilPerDep(tablaT);

        personalDepAct.setIdTipoDocPerDep(personaldepDTO.getIdTipodocPerDep());
        personalDepAct.setNroDocPerDep(personaldepDTO.getNroDocPerDep());
        personalDepAct.setNacionalidadPerDep(personaldepDTO.getNacionalidadPerDep());
        personalDepAct.setFechaNacPerDep(personaldepDTO.getFechaNacPerDep());
        personalDepAct.setTelefonoPerDep(personaldepDTO.getTelefonoPerDep());

        if(personaldepDTO.getGradoAcademicoPerDep() == null) {
            personalDepAct.setGradoAcademicoPerDep(Long.parseLong( "140"));
        } else {
            personalDepAct.setGradoAcademicoPerDep(personaldepDTO.getGradoAcademicoPerDep());
        }

        //personalDepAct.setGradoAcademicoPerDep(personaldepDTO.getGradoAcademicoPerDep());
        personalDepAct.setFlgEstudiaActPerDep(personaldepDTO.getFlgEstudiaActPerDep());
        personalDepAct.setNombreInstEducPerDep(personaldepDTO.getNombreInstEducPerDep());

        personalDepAct.setModiPorPerDep(personaldepDTO.getModiPorPerDep());
        personalDepAct.setFechaModiPerDep(new Date());


        return personaldependienteservice.save(personalDepAct);
    }
}
