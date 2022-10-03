package com.spring.sigmaweb.backend.process.legajo.controller;

import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.service.IObraService;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadListSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import com.spring.sigmaweb.backend.process.legajo.service.IEntidadService;
import com.spring.sigmaweb.backend.process.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/legajo/entidad")
public class EntidadRestController {
    @Autowired
    private IEntidadService entidadservice;

    @Autowired
    private IObraService obraservice;

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadsaludeps/{idobra}")
    public List<EntidadListSelectDTO> showEntidadSalud(@PathVariable String idobra){
        return entidadservice.findByTipoEntAndFlgSaludEntAndObra(idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadprevicion/{tipoEnt}/{idobra}")
    public List<EntidadListSelectDTO> showEntidadPrevicion(@PathVariable Integer tipoEnt, @PathVariable String idobra){
        return entidadservice.findByTipoEntAndFlgPrevisionalEntAndObra(tipoEnt, idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadporid/{idEntidad}")
    public Entidad showEntidadporIdEntidad(@PathVariable Long idEntidad){
        return entidadservice.findByIdEntidad(idEntidad);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadporobra/{idobra}")
    public List<EntidadDataSelectDTO> showListEntidadesporObra(@PathVariable String idobra){
        return entidadservice.findByEntidadObra(idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadporobrat/{idobra}")
    public List<EntidadDataSelectDTO> showListEntidadesporObraT(@PathVariable String idobra){
        return entidadservice.findByEntidadObraT(idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadporobra/proveedores/{idobra}")
    public List<EntidadDataSelectDTO> showListEntidadesProveedoresporObra(@PathVariable String idobra){
        return entidadservice.findByEntidadProveedoresObra(idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadporidandobra/{idEntidad}/{idobra}")
    public EntidadDataSelectDTO showEntidadporIdAndObra(@PathVariable Long idEntidad, @PathVariable String idobra){
        return entidadservice.findByIdEntidadObra(idEntidad,idobra);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/entidadesporflgandobra/{idobra}/{esproveedor}/{esprevisor}/{essalud}/{esedusup}/{esFinanciera}/{estado}")
    public List<EntidadListSelectDTO> showEntidadesPorFglyObra(@PathVariable String idobra, @PathVariable Boolean esproveedor, @PathVariable Boolean esprevisor, @PathVariable Boolean essalud, @PathVariable Boolean esedusup, @PathVariable Boolean esFinanciera, @PathVariable Boolean estado){

        return entidadservice.findByEntidadTipoFlgAndEstadoAndObra(idobra, esproveedor, esprevisor, essalud, esedusup, esFinanciera, estado);
    }

    @PostMapping("/entidadsave")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody EntidadDataSelectDTO entidad, BindingResult result) {
        Entidad entidadNew = null;
        Entidad entidadInsert = null;
        Optional<Obra> obraNew = obraservice.findById(entidad.getIdobra());

        Boolean flgEduSupEnt = false ;
        Boolean flgFinacieraEnt=false;
        Boolean flgPrevisionalEnt=false;
        Boolean flgProveedorEnt=false;
        Boolean flgSaludEnt=false;

        if (entidad.getFlgEduSupEnt().equals("Si")){flgEduSupEnt=true;}
        if (entidad.getFlgFinacieraEnt().equals("Si")){flgFinacieraEnt=true;}
        if (entidad.getFlgPrevisionalEnt().equals("Si")){flgPrevisionalEnt=true;}
        if (entidad.getFlgProveedorEnt().equals("Si")){flgProveedorEnt=true;}
        if (entidad.getFlgSaludEnt().equals("Si")){flgSaludEnt=true;}

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
            entidadInsert = new Entidad();
            entidadInsert.setObraEnt(obraNew.get());
            entidadInsert.setRucEnt(entidad.getRucEnt());
            entidadInsert.setNombreEnt(entidad.getNombreEnt());
            entidadInsert.setNombreComerEnt(entidad.getNombreComerEnt());
            entidadInsert.setTelefonoEnt(entidad.getTelefonoEnt());
            entidadInsert.setUrlEnt(entidad.getUrlEnt());
            entidadInsert.setEmailEnt(entidad.getEmailEnt());
            entidadInsert.setTipoEnt(entidad.getTipoEnt());
            entidadInsert.setFlgEduSupEnt(flgEduSupEnt);
            entidadInsert.setFlgFinacieraEnt(flgFinacieraEnt);
            entidadInsert.setFlgPrevisionalEnt(flgPrevisionalEnt);
            entidadInsert.setFlgProveedorEnt(flgProveedorEnt);
            entidadInsert.setFlgSaludEnt(flgSaludEnt);
            entidadInsert.setCodigoDocExternoEnt(entidad.getCodigoDocExternoEnt());
            entidadInsert.setCreaPorEnt(entidad.getCreaPorEnt());
            entidadInsert.setFechaIngEnt(entidad.getFechaIngEnt());
            entidadInsert.setEstadoEnt(entidad.getEstadoEnt());
            //agregado para proveedores
            entidadInsert.setContactoEnt(entidad.getContactoEnt());
            entidadInsert.setPartidaRegEnt(entidad.getPartidaRegEnt());
            entidadInsert.setRepresentanteEnt(entidad.getRepresentanteEnt());
            entidadInsert.setRepresentanteNroDocEnt(entidad.getRepresentanteNroDocEnt());
            entidadInsert.setNroCtaSolesEnt(entidad.getNroCtaSolesEnt());
            entidadInsert.setNroCtaDolarEnt(entidad.getNroCtaDolarEnt());
            entidadInsert.setCciSolesEnt(entidad.getCciSolesEnt());
            entidadInsert.setCciDolarEnt(entidad.getCciDolarEnt());


            entidadNew = entidadservice.save(entidadInsert);

        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("Entidad", entidadNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/entidadupdate/{identidad}/{obraname}")
    @ResponseStatus(HttpStatus.CREATED)
    public Entidad updateEntidadDTO(@RequestBody EntidadDataSelectDTO entidadDTO, @PathVariable Long identidad, @PathVariable String obraname) {
        Entidad entidadAct = entidadservice.findByIdEntidadAndObraEnt(identidad,obraname);
        Boolean flgEduSupEnt = false ;
        Boolean flgFinacieraEnt=false;
        Boolean flgPrevisionalEnt=false;
        Boolean flgProveedorEnt=false;
        Boolean flgSaludEnt=false;

        if (entidadDTO.getFlgEduSupEnt().equals("Si")){flgEduSupEnt=true;}
        if (entidadDTO.getFlgFinacieraEnt().equals("Si")){flgFinacieraEnt=true;}
        if (entidadDTO.getFlgPrevisionalEnt().equals("Si")){flgPrevisionalEnt=true;}
        if (entidadDTO.getFlgProveedorEnt().equals("Si")){flgProveedorEnt=true;}
        if (entidadDTO.getFlgSaludEnt().equals("Si")){flgSaludEnt=true;}
        entidadAct.setNombreEnt(entidadDTO.getNombreEnt());
        entidadAct.setNombreComerEnt(entidadDTO.getNombreComerEnt());
        entidadAct.setTelefonoEnt(entidadDTO.getTelefonoEnt());
        entidadAct.setUrlEnt(entidadDTO.getUrlEnt());
        entidadAct.setEmailEnt(entidadDTO.getEmailEnt());
        entidadAct.setTipoEnt(entidadDTO.getTipoEnt());
        entidadAct.setFlgEduSupEnt(flgEduSupEnt);
        entidadAct.setFlgFinacieraEnt(flgFinacieraEnt);
        entidadAct.setFlgPrevisionalEnt(flgPrevisionalEnt);
        entidadAct.setFlgProveedorEnt(flgProveedorEnt);
        entidadAct.setFlgSaludEnt(flgSaludEnt);
        entidadAct.setCodigoDocExternoEnt((entidadDTO.getCodigoDocExternoEnt()));
        entidadAct.setModiPorEnt(entidadDTO.getModiPorEnt());

        //agregado para proveedores
        entidadAct.setContactoEnt(entidadDTO.getContactoEnt());
        entidadAct.setPartidaRegEnt(entidadDTO.getPartidaRegEnt());
        entidadAct.setRepresentanteEnt(entidadDTO.getRepresentanteEnt());
        entidadAct.setRepresentanteNroDocEnt(entidadDTO.getRepresentanteNroDocEnt());
        entidadAct.setNroCtaSolesEnt(entidadDTO.getNroCtaSolesEnt());
        entidadAct.setNroCtaDolarEnt(entidadDTO.getNroCtaDolarEnt());
        entidadAct.setCciSolesEnt(entidadDTO.getCciSolesEnt());
        entidadAct.setCciDolarEnt(entidadDTO.getCciDolarEnt());
        entidadAct.setFechaModiEnt(new Date());

        return entidadservice.save(entidadAct);
    }

    @Secured({"ROLE_FAMI","ROLE_ADMI", "ROLE_COLA"})
    @PutMapping("update/estado/{idEntidad}")
    public Entidad updateEtnidad(@PathVariable Long idEntidad){
        Entidad entidad= entidadservice.findByIdEntidad(idEntidad);
        entidad.setEstadoEnt(Constants.FLAG_ESTADO.INACTIVO);
        return entidadservice.save(entidad);
    }
}
