package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacionDetalle;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.DistribucionCRDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sigmaweb/distribuciondetalle")
@RequiredArgsConstructor
public class DistribucionCrDetalleController {

    private final  DistribucionCRDetalleService distribucionCRDetalleService;

    @PostMapping
    private DistribucionPonderacionDetalle guardarDistribucionCRDetalle(@RequestBody DistribucionPonderacionDetalle distribucionCRDetalle) throws Exception {


        return distribucionCRDetalleService.registrar(distribucionCRDetalle);
    }

    @GetMapping
    private List<DistribucionPonderacionDetalle> listarDistribucionCRDetalle() throws Exception {
        return distribucionCRDetalleService.listar();
    }

    @PutMapping
    private DistribucionPonderacionDetalle modificarDistribucionCrDetalle(@RequestBody DistribucionPonderacionDetalle distribucionCRDetalle) throws Exception {

        return distribucionCRDetalleService.modificar(distribucionCRDetalle);
    }

}
