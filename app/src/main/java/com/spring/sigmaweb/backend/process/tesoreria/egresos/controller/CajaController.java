package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IActividadPresupuestalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("sigmaweb/caja")
@RequiredArgsConstructor
public class CajaController {
    private final CajaService cajaService;

    @GetMapping("listar/obra")
    public List<Caja> listasCajaPorObras(@RequestParam String idobra) throws Exception{
        return cajaService.findByIdObra(idobra);
    }

    @GetMapping("buscar/obra/id")
    public Caja listasCajaPorObras(@RequestParam String idobra, @RequestParam Long idcaja) throws Exception{
        return cajaService.findByIdObraAndIdCaja(idobra, idcaja);
    }


}
