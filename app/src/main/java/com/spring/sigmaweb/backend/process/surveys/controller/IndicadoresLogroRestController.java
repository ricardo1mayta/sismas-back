package com.spring.sigmaweb.backend.process.surveys.controller;

import com.spring.sigmaweb.backend.process.surveys.dto.EvaluacionIndicadoresLogroDTO;
import com.spring.sigmaweb.backend.process.surveys.dto.IndicadoresGODto;
import com.spring.sigmaweb.backend.process.surveys.service.IIndicadoresLogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/sigmaweb/evaluaciondesemp/indicadoreslogro")
public class IndicadoresLogroRestController {

    @Autowired
    private IIndicadoresLogroService indicadoresLogroService;



    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/listaindicadoresgo/{idobra}/{idgo}/{idpuesto}/{idevento}")
    public List<IndicadoresGODto> showPersonalEvaluacionEvaluadorList(@PathVariable String idobra, @PathVariable Integer idgo, @PathVariable Long idpuesto, @PathVariable Long idevento){

        return indicadoresLogroService.findByObraAndGrupoOcupacionalAndPuestoAndEvento(idobra, idgo, idpuesto, idevento);
    }

    @Secured({"ROLE_ADMI", "ROLE_COLA"})
    @GetMapping("/evaluacionindicadoreslogro/{idobra}/{idgo}/{idpuesto}/{idevento}")
    public List<EvaluacionIndicadoresLogroDTO> showEvalucionIndicadoresLogro(@PathVariable String idobra, @PathVariable Integer idgo, @PathVariable Long idpuesto, @PathVariable Long idevento){
        return indicadoresLogroService.findByEvaluacionObraGrupoocupacionalEvento(idobra, idgo, idpuesto, idevento);
    }
}
