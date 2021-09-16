package com.spring.sigmaweb.backend.process.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.spring.sigmaweb.backend.process.core.model.Rol;
import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.core.service.IRolService;
import com.spring.sigmaweb.backend.process.core.service.IRolSideNavItemService;
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

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/roles")
public class RolRestController {
    @Autowired
    private IRolService rolService;

    @Autowired
    private IRolSideNavItemService rolSideNavItemService;

    @Secured("ROLE_ADMI")
    @GetMapping("/rolesall")
    public Iterable<Rol> findRolesAll() {
        return rolService.findAll();
    }

    @Secured("ROLE_ADMI")
    @GetMapping("/rolesallobra/{idobra}")
    public List<Rol> findRolesObra(@PathVariable String idobra) {
        return rolService.findByIdobraRol(idobra);
    }

    @Secured({"ROLE_ADMI"})
    @DeleteMapping("/roldelete/{idrol}/{obraname}")
    public ResponseEntity<?> deleteRol(@RequestBody Rol rolDelete){
        List<RolSideNavItem> rolSideList = rolSideNavItemService.findByIdRolAndIdObra(rolDelete.getIdRol(),rolDelete.getIdobraRol());
        Map<String, Object> response = new HashMap<>();
        try {
            //1. Elimina primero los accesos
            rolSideNavItemService.deleteAll(rolSideList);
            //2. Elimina al final el perfil
            rolService.delete(rolDelete);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el perfil");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se eliminaron los accesos correctamente!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/rolsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody Rol rol, BindingResult result) {
        Rol rolNew  =null;
        Rol rolFind = null;


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
            //verifica si ya esta registrado
            rolFind=rolService.findByNombreRolAndIdObraRol(rol.getNombreRol(), rol.getIdobraRol());
            if (rolFind == null) {
                rolNew = rolService.save(rol);
            } else {
                response.put("mensaje", "Error perfil nombre de perfil duplicado");
                response.put("error", "Error perfil nombre de perfil duplicado");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
            }


        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("Rol", rolNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/rolupdate/{idrol}/{idobra}")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol updateRol(@RequestBody Rol rolUpdate, @PathVariable Long idrol, @PathVariable String idobra) {
        Rol RolAct = rolService.findByIdRolAndIdObraRol(idrol, idobra);

        RolAct.setDescripcionRol(rolUpdate.getDescripcionRol());

        return rolService.save(RolAct);
    }
}
