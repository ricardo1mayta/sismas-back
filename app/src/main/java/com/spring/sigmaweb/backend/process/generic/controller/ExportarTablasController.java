package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.model.CamposTablaExportar;
import com.spring.sigmaweb.backend.process.generic.repository.ICampoTablaExportarDao;
import com.spring.sigmaweb.backend.process.generic.service.IExportarTablasService;
import com.spring.sigmaweb.backend.process.legajo.dto.ReportDirectorioPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/exportarTablas")
public class ExportarTablasController {

    @Autowired
    private IExportarTablasService exportartablasService;



    @Secured({"ROLE_ADMI", "ROLE_RRHH"})
    @GetMapping("/exportartablassigma/{obraname}/{selectsql}/{fromsql}/{whsql}/{opcion}")
    public List<Object> exportarTablas(@PathVariable String obraname, @PathVariable String selectsql, @PathVariable String fromsql, @PathVariable String whsql,@PathVariable String opcion){

        return exportartablasService.exportTablaLegajo(obraname, opcion, selectsql, fromsql, whsql);
    }

    @Secured({"ROLE_ADMI", "ROLE_RRHH"})
    @GetMapping("/listacamposgrupo/{idgrupo}/{estadocampo}")
    public List<CamposTablaExportar> listaCamposPorGrupo(@PathVariable String idgrupo, @PathVariable Boolean estadocampo){
        return exportartablasService.findByIdGrupoCampoAndEstadoCampo(idgrupo, estadocampo);
    }

}
