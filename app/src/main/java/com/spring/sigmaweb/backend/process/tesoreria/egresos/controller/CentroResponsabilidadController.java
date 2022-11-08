package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CentroResponsabilidad;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ICentroResponsabilidadService;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sigmaweb/centroresponsabilidad")
@Validated
@RequiredArgsConstructor
public class CentroResponsabilidadController {

    public final ICentroResponsabilidadService centroResponsabilidadService;

    @GetMapping
    public List<CentroResponsabilidad> listarCentroResponsabilidad(@RequestParam String idObra) throws Exception {

        if(idObra.equals("SECTOR")){
            return centroResponsabilidadService.listarPorOPbraCR(0);
        }else{
            return centroResponsabilidadService.listarPorOPbraCR(1);
        }
    }

    @GetMapping("/buscar")
    public CentroResponsabilidad buscarPorIdCentroResponsabilidad(@RequestParam Long id) throws Exception {
        return centroResponsabilidadService.buscarPorId(id);
    }

    @PostMapping
    public CentroResponsabilidad guardarCentroResponsabilidad (@RequestBody CentroResponsabilidad body) throws Exception {
        return centroResponsabilidadService.registrar(body);
    }

    @PutMapping
    public CentroResponsabilidad modificarCentroResponsabilidad (@RequestBody CentroResponsabilidad body) throws Exception {
        return centroResponsabilidadService.modificar(body);
    }

    @DeleteMapping("/id")
    @ResponseBody
    public void borrarCentroResponsabilidad(@RequestParam Long id) throws Exception {
        centroResponsabilidadService.eliminar(id);
    }

}
