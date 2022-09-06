package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Detraccion;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DetraccionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sigmaweb/detracciones")
@RequiredArgsConstructor
public class DetraccionController {
    private final DetraccionService detraccionService;
    private final ModelMapper mapper;

    @GetMapping("listar/obra")
    public List<Detraccion> listarPorObraDetraccion(@RequestParam String idObra) {
        return  detraccionService.listarPorIdObra(idObra);
    }

}
