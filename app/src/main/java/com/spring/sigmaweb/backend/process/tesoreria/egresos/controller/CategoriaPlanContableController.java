package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CategoriaPlanContableDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CategoriaPlanContable;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ICategoriaPlanContableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/sigmaweb/categoriaplancontable")
@Validated
@RequiredArgsConstructor
public class CategoriaPlanContableController {

    private final ModelMapper mapper;

    private final ICategoriaPlanContableService categoriaPlanContableService;

    @GetMapping
    public List<CategoriaPlanContableDTO> listarCategoriaPlanContable() throws Exception {
        return categoriaPlanContableService.listar().stream().map(c->mapper.map(c,CategoriaPlanContableDTO.class)).collect(Collectors.toList());
    }
    @GetMapping("listar/grupo")
    public List<CategoriaPlanContableDTO> listarPorGrupoCategoriaPlanContable(@RequestParam String grupo) throws Exception {
        return categoriaPlanContableService.buscarPorCategoriaPlanContableByGrupo(grupo).stream().map(c->mapper.map(c,CategoriaPlanContableDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public CategoriaPlanContableDTO buscarPorIdCategoriaPlanContable(@RequestParam Long id) throws Exception {
        return mapper.map(categoriaPlanContableService.buscarPorId(id),CategoriaPlanContableDTO.class);
    }

    @PostMapping
    public CategoriaPlanContableDTO guardarCategoriaPlanContable (@RequestBody CategoriaPlanContableDTO bodyDTO) throws Exception {

        return mapper.map(categoriaPlanContableService.registrar( mapper.map(bodyDTO, CategoriaPlanContable.class) ),CategoriaPlanContableDTO.class);
    }

    @PutMapping
    public CategoriaPlanContableDTO modificarCategoriaPlanContable (@RequestBody CategoriaPlanContableDTO bodyDTO) throws Exception {
        return mapper.map(categoriaPlanContableService.modificar( mapper.map(bodyDTO,CategoriaPlanContable.class) ),CategoriaPlanContableDTO.class);
    }

    @DeleteMapping
    public void borrarCategoriaPlanContable(@RequestParam Long id) throws Exception {
        categoriaPlanContableService.eliminar(id);
    }
}
