package com.spring.sigmaweb.backend.process.core.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemActivosDTO;
import com.spring.sigmaweb.backend.process.core.dto.RolSideNavItemMenuOrderDTO;
import com.spring.sigmaweb.backend.process.core.dto.SidenavItemDTO;
import com.spring.sigmaweb.backend.process.core.model.RolSideNavItem;
import com.spring.sigmaweb.backend.process.core.model.SideNavItem;
import com.spring.sigmaweb.backend.process.core.service.IRolService;
import com.spring.sigmaweb.backend.process.core.service.IRolSideNavItemService;
import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.service.IObraService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/sidenav/")
public class RolSideNavItemRestController {

    @Autowired
    private IRolSideNavItemService rolsidenavitemservice;

    @Autowired
    private IRolService rolservice;

    @Autowired
    private IObraService obraservice;

    @GetMapping("/menuorder/{idroles}/{idobra}")
    public List<RolSideNavItemMenuOrderDTO> showMenuOrdenadoDTO(@PathVariable String idroles,
                                                                @PathVariable String idobra) {
        return rolsidenavitemservice.findByMenuPorRolAndObra(idroles, idobra);
    }

    @GetMapping("/menurolobra/{idroles}/{idobra}")
    public List<SidenavItemDTO> showMenuRolObraDTO(@PathVariable String idroles, @PathVariable String idobra) {
        return rolsidenavitemservice.listesquemaMenu(idroles, idobra);
    }

    @GetMapping("/menurolobraall")
    public List<SidenavItemDTO> showMenuRolObraAllDTO() {
        return rolsidenavitemservice.listesquemaMenuAll();
    }

    @GetMapping("/menuorderall")
    public List<RolSideNavItemMenuOrderDTO> showMenuOrdenadoDTO() {
        return rolsidenavitemservice.findByMenuGeneral();
    }

    @GetMapping("/menuorderrolactivodos/{idroles}/{idobra}")
    public List<RolSideNavItemActivosDTO> showMenuOrdenadoRolActivosDTO(@PathVariable String idroles, @PathVariable String idobra) {
        return rolsidenavitemservice.findByMenuPorRolAndObraActivos(idroles, idobra);
    }

    @GetMapping("/menuorolandobra/{idrol}/{idobra}")
    public List<RolSideNavItem> showMenuRolAndObra(@PathVariable Long idrol, @PathVariable String idobra) {
        return rolsidenavitemservice.findByIdRolAndIdObra(idrol, idobra);
    }

    @Secured({"ROLE_ADMI"})
    @DeleteMapping("/menuroldeleteall/{idrol}/{obraname}")
    public ResponseEntity<?> deleteAll(@PathVariable Long idrol, @PathVariable String obraname){
        Map<String, Object> response = new HashMap<>();

        try {

            List<RolSideNavItem> rolSideList = rolsidenavitemservice.findByIdRolAndIdObra(idrol, obraname);

            rolsidenavitemservice.deleteAll(rolSideList);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar accesos relacionados al perfil");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", " Se eliminaron los accesos correctamente!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PostMapping("/accesorolsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody RolSideNavItemActivosDTO rolSide, BindingResult result) {
        RolSideNavItem rolSideNew  =null;
        RolSideNavItem rolSideResp  =null;


        //Rol rolSelect = rolservice.findByIdRolAndIdObraRol(rolSide.getIdRol(), rolSide.getIdobra());
        Optional<Obra> obraSelect = obraservice.findById(rolSide.getIdobra());
        SideNavItem sidenavSelect  = rolsidenavitemservice.findBysideNavItem(rolSide.getIdItem(), "_");

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

            rolSideNew = new RolSideNavItem();
            rolSideNew.setIdRolItem(rolSide.getIdRolItem());
            rolSideNew.setObraRolItem(obraSelect.get());

            rolSideNew.setRolRolItem(rolSide.getIdRol());//rolSelect);
            rolSideNew.setIdItem(sidenavSelect);
            rolSideNew.setFlgActivoRolItem(rolSide.getFlgActivoRolItem());
            rolSideNew.setFlgLecturaRolItem(rolSide.getFlgLecturaRolItem());
            rolSideNew.setFlgEscrituraRolItem(rolSide.getFlgEscrituraRolItem());
            rolSideNew.setFechaUltModiRolItem(new Date());
            rolSideNew.setModiPorUltRolItem(rolSide.getModiPorUltRolItem());


            rolSideResp = rolsidenavitemservice.save(rolSideNew);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("RolSideNAvItem", rolSideResp);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
