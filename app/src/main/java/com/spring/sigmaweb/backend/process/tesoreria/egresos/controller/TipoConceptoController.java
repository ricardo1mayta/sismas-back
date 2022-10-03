package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TipoConceptoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TipoConcepto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.ITipoConceptoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sigmaweb/tipoconcepto")
@RequiredArgsConstructor
public class TipoConceptoController {

    private final ModelMapper mapper;

    private final ITipoConceptoService tipoConceptoService;

    @GetMapping
    public List<TipoConceptoDTO> listarTipoConcepto() throws Exception {
        return tipoConceptoService.listar().stream().map(c->mapper.map(c,TipoConceptoDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public TipoConceptoDTO buscarPorIdTipoConcepto(@RequestParam Long id) throws Exception {
        return mapper.map(tipoConceptoService.buscarPorId(id),TipoConceptoDTO.class);
    }

    @PostMapping
    public TipoConceptoDTO guardarTipoConcepto (@RequestBody TipoConceptoDTO bodyDTO) throws Exception {

        return mapper.map(tipoConceptoService.registrar( mapper.map(bodyDTO,TipoConcepto.class) ),TipoConceptoDTO.class);
    }

    @PutMapping
    public TipoConceptoDTO modificarTipoConcepto (@RequestBody TipoConceptoDTO bodyDTO) throws Exception {
        return mapper.map(tipoConceptoService.modificar( mapper.map(bodyDTO,TipoConcepto.class) ),TipoConceptoDTO.class);
    }

    @DeleteMapping
    public void borrarTipoConcepto(@RequestParam Long id) throws Exception {
        tipoConceptoService.eliminar(id);
    }
}
