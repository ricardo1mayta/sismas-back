package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.ImpresoraCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Impresora;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IImpresoraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("sigmaweb/impresora")
@RequiredArgsConstructor
public class ImpresoraController {
    private final IImpresoraService impresoraService;

    @GetMapping("/listar/obra/flgestado")
    public List<ImpresoraCajaDTO> listasCajaPorObras(@RequestParam String idobra, @RequestParam Integer flgestado) throws Exception{
        return impresoraService.findByIdObraAndFlgEstado(idobra,flgestado);
    }

    @GetMapping("/buscar/obra/id")
    public Impresora listasCajaPorObras(@RequestParam String idobra, @RequestParam Long idimpresora) throws Exception{
        return impresoraService.findByIdObraAndIdImpresora(idobra, idimpresora);
    }

    @GetMapping("/buscarimpresorasCaja/obra/caja/flgestado")
    public List<ImpresoraCajaDTO> listasImpresorascaja(@RequestParam String idobra, @RequestParam Long idcaja, @RequestParam Integer flgestado) throws Exception{
        return impresoraService.findByImpresorasCajaSelect(idobra, idcaja, flgestado);
    }

}
