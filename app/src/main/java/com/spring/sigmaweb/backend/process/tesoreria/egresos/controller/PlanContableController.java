package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.PlanContableDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.PlanContable;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IPlanContableService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sigmaweb/plancontable")
@Validated
@RequiredArgsConstructor
public class PlanContableController {
    
    private final IPlanContableService planContableService;
    private final ModelMapper mapper;
    
    @GetMapping
    public List<PlanContableDTO> listarPlanContable() throws Exception {
        return planContableService.listarPlanContable().stream().map(c->mapper.map(c,PlanContableDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public PlanContableDTO buscarPorIdPlanContable(@RequestParam Long id) throws Exception {
        return mapper.map(planContableService.buscarPorId(id),PlanContableDTO.class);
    }

    @PostMapping
    public PlanContableDTO guardarPlanContable (@RequestBody PlanContableDTO bodyDTO) throws Exception {
        return mapper.map( planContableService.registrar(mapper.map(bodyDTO, PlanContable.class)),PlanContableDTO.class);
    }

    @PutMapping
    public PlanContableDTO modificarPlanContable (@RequestBody PlanContableDTO bodyDTO) throws Exception {
        return mapper.map( planContableService.modificar(mapper.map(bodyDTO,PlanContable.class)),PlanContableDTO.class);
    }

    @DeleteMapping
    public void borrarPlanContable(@RequestParam Long id) throws Exception {
        planContableService.eliminar(id);
    }

    @GetMapping("/buscar/categoriacontable")
    public List<PlanContableDTO> listara(@RequestParam Long id){
        return  planContableService.listarPorIdCategoriaContable(id).stream().map(c->mapper.map(c,PlanContableDTO.class)).collect(Collectors.toList());
    }
    
}
