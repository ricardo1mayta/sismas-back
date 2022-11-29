package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.ConfiguracionesModulos;
import com.spring.sigmaweb.backend.process.generic.service.IConfiguracionesModulosService;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalContratoObraDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaGeneralDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaGeneral;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("sigmaweb/configModulos")
@RequiredArgsConstructor
public class ConfiguracionesModulosRestController {
    private final IConfiguracionesModulosService service;

    @GetMapping("find/obra/modulo/grupo/subgrupo1/opcion")
    public ConfiguracionesModulos listasCajaPorObras(@RequestParam String idobra,
                                                     @RequestParam String idmodulo,
                                                     @RequestParam String codigogrupo,
                                                     @RequestParam String codigosubgrupo1,
                                                     @RequestParam String codigoopcion) throws Exception{
        return service.findByIdObraAndIdModuloAndCodigoGrupoAndCodigoSubgrupo1AndCodigoOpcion(idobra, idmodulo, codigogrupo, codigosubgrupo1, codigoopcion);
    }

    @GetMapping("find/obra/modulo")
    public List<ConfiguracionesModulos> listasConfigObraModulo(@RequestParam String idobra, @RequestParam String idmodulo) throws Exception{
        return service.findByIdObraAndIdModulo(idobra, idmodulo);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createConfigModulo(@RequestBody ConfiguracionesModulos body, BindingResult result){
        ConfiguracionesModulos newItem = null;
        ConfiguracionesModulos returnItem = null;

        ConfiguracionesModulos findExist = service.findByIdObraAndIdModuloAndCodigoGrupoAndCodigoSubgrupo1AndCodigoOpcion(body.getIdObra(),
                                                                                                                        body.getIdModulo(),
                                                                                                                        body.getCodigoGrupo(),
                                                                                                                        body.getCodigoSubgrupo1(),
                                                                                                                        body.getCodigoOpcion());

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
            newItem=new ConfiguracionesModulos();

            if(findExist == null){
                newItem.setIdObra(body.getIdObra());
                newItem.setIdModulo(body.getIdModulo());
                newItem.setCodigoGrupo(body.getCodigoGrupo());
                newItem.setCodigoSubgrupo1(body.getCodigoSubgrupo1());
                newItem.setCodigoOpcion(body.getCodigoOpcion());
                newItem.setValorOpcion(body.getValorOpcion());
                newItem.setCreapor(body.getCreapor());
                newItem.setFechaRegistro(new Date());

                returnItem = service.save(newItem);
            } else {
                response.put("mensaje", "ya registrado");
                response.put("configuracionesmodulos", null);
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
            }
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El item ha sido creado con éxito!");
        response.put("configuracionesmodulos", returnItem);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @PutMapping()
    public ConfiguracionesModulos updateConfiguracionesModulos(@RequestBody ConfiguracionesModulos body) {
        ConfiguracionesModulos findExist = service.findByIdObraAndIdModuloAndCodigoGrupoAndCodigoSubgrupo1AndCodigoOpcion(body.getIdObra(),
                body.getIdModulo(),
                body.getCodigoGrupo(),
                body.getCodigoSubgrupo1(),
                body.getCodigoOpcion());
        if(findExist != null){
            findExist.setValorOpcion(body.getValorOpcion());
            findExist.setModificadoPor(body.getModificadoPor());
            findExist.setFechaActualiza(new Date());
        } else {
            return null;
        }
        return service.save(findExist);
    }
}
