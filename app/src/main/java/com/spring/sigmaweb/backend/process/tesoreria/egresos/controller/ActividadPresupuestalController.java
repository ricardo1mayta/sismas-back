package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.ActividadPresupuestal;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IActividadPresupuestalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("sigmaweb/actividadpresupuestal")
@RequiredArgsConstructor
public class ActividadPresupuestalController {

    private final IActividadPresupuestalService actividadPresupuestalService;

    @GetMapping
    public List<ActividadPresupuestal> listarPorObra() throws Exception {

        return actividadPresupuestalService.listar();
    }

    @GetMapping("buscar/actividad")
    public ActividadPresupuestal listarPorId(@RequestParam Long idActividad) throws Exception {
        return actividadPresupuestalService.buscarPorId(idActividad);
    }

    @PostMapping
    public ActividadPresupuestal registrar(@RequestBody ActividadPresupuestal actividadPresupuestal) throws Exception {
        return  actividadPresupuestalService.registrar(actividadPresupuestal);
    }

    @PutMapping
    public ActividadPresupuestal actualizar(@RequestBody ActividadPresupuestal actividadPresupuestal) throws Exception {
        return actividadPresupuestalService.modificar(actividadPresupuestal);
    }

}
