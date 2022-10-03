package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacion;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DistribucionCRDetalleService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DistribucionCRService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("sigmaweb/distribucioncr")
@RequiredArgsConstructor
public class DistribucionCRController {

    private final ModelMapper mapper;
    private final DistribucionCRService distribucionCRService;
    private final DistribucionCRDetalleService distribucionCRDetalleService;

    @GetMapping("buscar/obra")
    private List<DistribucionPonderacion>listarPorObraYPeriodoDistribucionCR(@RequestParam String idObra,
                                                                             @RequestParam String periodo) throws Exception {
        return  distribucionCRService.listarPorObraYPeriodoDistribucionCR(idObra,periodo);
    }

    @GetMapping("buscar/id")
    private DistribucionPonderacion buscarPorIdDistribucionCR(@RequestParam Long idDistribucionCR) throws Exception {
        return distribucionCRService.buscarPorId(idDistribucionCR);
    }

    @PostMapping
    private DistribucionPonderacion guardarDistribuicionCR(@RequestBody DistribucionPonderacion distribucionCR) throws Exception {
        return distribucionCRService.registrar(distribucionCR);
    }

    @PutMapping
    private DistribucionPonderacion modificarDistribucionCR(@RequestBody DistribucionPonderacion distribucionCR) throws Exception {
        return distribucionCRService.modificar(distribucionCR);
    }

    @DeleteMapping
    public void borrarDistribucionCR(@RequestParam Long idDistribucionCR) throws Exception {
        distribucionCRService.eliminar(idDistribucionCR);
    }
}
