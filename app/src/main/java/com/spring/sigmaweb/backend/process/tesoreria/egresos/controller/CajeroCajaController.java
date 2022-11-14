package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajeroCaja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajeroCajaService;
import com.spring.sigmaweb.backend.process.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("sigmaweb/cajerocaja")
@RequiredArgsConstructor
public class CajeroCajaController {
    private final CajeroCajaService cajeroCajaService;

    @GetMapping("listarcajeros/obra")
    public List<CajeroCajaDTO> listasCajerosPorObra(@RequestParam String idobra){
        return cajeroCajaService.findByIdObraAndIdCajaAndIdUsuarioDistintDTO(idobra);
    }

    @GetMapping("listar/obra/caja")
    public List<CajeroCajaDTO> listasCajerosPorObra(@RequestParam String idobra, @RequestParam long idcaja){
        return cajeroCajaService.findByIdObraAndIdCajaAndIdUsuarioDTO(idobra, idcaja);
    }

    @PostMapping
    public ResponseEntity<CajeroCaja> guardaCajeroCaja(@RequestBody CajeroCaja body) throws Exception {
        CajeroCaja newItem= null;
        String idItem = Utils.idObraNumerico(body.getIdObra()) + "-"  + body.getIdCaja() + "-" + body.getIdUsuario();
        newItem = new CajeroCaja();

        newItem.setIdCajeroCaja(idItem);
        newItem.setIdCaja(body.getIdCaja());
        newItem.setIdUsuario(body.getIdUsuario());
        newItem.setIdObra(body.getIdObra());
        newItem.setFechaInicio(body.getFechaInicio());
        newItem.setFechaFin(body.getFechaFin());
        newItem.setFlgEstado(body.getFlgEstado());
        newItem.setCreapor(body.getCreapor());
        newItem.setFechaRegistro(new Date());

        return  new ResponseEntity<>(cajeroCajaService.saveCajeroCaja(newItem), HttpStatus.OK);
    }



}
