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
@RequestMapping("/sigmaweb/parametrosreportes")
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
    public List<Reporte> showReporteporModuloTipoEstado(@PathVariable String idmodulo,@PathVariable String tiporepo,@PathVariable Integer estadorepo){
        Boolean estado = false;
        if(estadorepo == 1){estado = true;}
        return parametrosReporteService.findByIdModuloTipoRepoEstadoRepo(idmodulo, tiporepo, estado);
    }

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reporteslistgrupoperfilobra/{idmodulo}/{tiporepo}/{estadorepo}/{idgrupo}/{idobra}/{idrol}")
    public List<Reporte> showReporteporModuloTipoEstadoGrupoPerfilObra(@PathVariable String idmodulo,@PathVariable String tiporepo,@PathVariable Integer estadorepo,@PathVariable Integer idgrupo,@PathVariable String idobra,@PathVariable String idrol){
        Boolean estado = false;
        if(estadorepo == 1){estado = true;}

        return parametrosReporteService.findByIdModuloTipoRepoEstadoRepoGrupoRol(idmodulo, tiporepo,estado, idgrupo, idobra, idrol);
    }

    @Secured({"ROLE_FAMI", "ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/reportesnotgrupolist/{idmodulo}/{tiporepo}/{estadorepo}/{idgrupo}/{idobra}")
    public List<Reporte> showReporteporModuloTipoEstadonotingrupoid(@PathVariable String idmodulo,@PathVariable String tiporepo,@PathVariable Integer estadorepo,@PathVariable String idgrupo,@PathVariable String idobra){
        Boolean estado = false;
        if(estadorepo == 1){estado = true;}
        return parametrosReporteService.findByIdModuloTipoRepoEstadoRepoNotInGrupo(idmodulo, tiporepo,estado, idgrupo, idobra);
    }

}
