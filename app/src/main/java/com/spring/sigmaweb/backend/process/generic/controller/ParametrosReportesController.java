package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.dto.ParametrosReporteDTO;
import com.spring.sigmaweb.backend.process.generic.model.Reporte;
import com.spring.sigmaweb.backend.process.generic.service.IParametrosReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/parametrosreportes")
public class ParametrosReportesController {

    @Autowired
    private IParametrosReporteService parametrosReporteService;

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/parametrosxreporte/{idRepo}")
    public List<ParametrosReporteDTO> parametrosPorReporte(@PathVariable Long idRepo){
        return parametrosReporteService.findByParametrosPorReporte(idRepo);
    }

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reporteslist/{idmodulo}/{tiporepo}/{estadorepo}")
    public List<Reporte> showReporteporModuloTipoEstado(@PathVariable String idmodulo,@PathVariable String tiporepo,@PathVariable String estadorepo){
        Boolean estado = false;
        if(estadorepo.equals("true")){estado = true;}
        return parametrosReporteService.findByIdModuloTipoRepoEstadoRepo(idmodulo, tiporepo, estado);
    }

}
