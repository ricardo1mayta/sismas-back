package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ConceptoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Concepto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IConceptoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sigmaweb/concepto")
@Validated
@RequiredArgsConstructor
public class ConceptoController {

    private final ModelMapper mapper;
    private final IConceptoService conceptoService;

    @GetMapping
    public List<ConceptoDTO> listarConcepto() throws Exception {
        return conceptoService.listar().stream().map(c->mapper.map(c,ConceptoDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public ConceptoDTO buscarPorIdConcepto(@RequestParam Long id) throws Exception {
        return mapper.map(conceptoService.buscarPorId(id),ConceptoDTO.class);
    }

    @PostMapping
    public ConceptoDTO guardarConcepto (@RequestBody ConceptoDTO bodyDTO) throws Exception {
        return mapper.map( conceptoService.registrar(mapper.map(bodyDTO,Concepto.class)),ConceptoDTO.class);
    }

    @PutMapping
    public ConceptoDTO modificarConcepto (@RequestBody ConceptoDTO bodyDTO) throws Exception {
        return mapper.map( conceptoService.modificar(mapper.map(bodyDTO,Concepto.class)),ConceptoDTO.class);
    }

    @DeleteMapping
    public void borrarConcepto(@RequestParam Long id) throws Exception {
        conceptoService.eliminar(id);
    }

    @GetMapping("/buscar/tipoconcepto")
    public List<ConceptoDTO> listar(@RequestParam Long idTipoconcepto){
       return  conceptoService.listarPorTipoConcepto(idTipoconcepto).stream().map(c->mapper.map(c,ConceptoDTO.class)).collect(Collectors.toList());
    }


}
