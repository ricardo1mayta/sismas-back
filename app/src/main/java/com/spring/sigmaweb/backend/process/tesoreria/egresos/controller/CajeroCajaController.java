package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.core.dto.usuarioDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajeroCajaDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
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

    @GetMapping("listarcajerossincaja/obra")
    public List<usuarioDTO> listasCajerosSinCajaPorObra(@RequestParam String idobra){
        return cajeroCajaService.findByIdObraSinCajaDTO(idobra);
    }

    @PostMapping
    public ResponseEntity<CajeroCaja> guardaCajeroCaja(@RequestBody CajeroCaja body) throws Exception {
        CajeroCaja newItem= null;
        newItem = new CajeroCaja();

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

    @PutMapping
    public CajeroCaja modificarCajero (@RequestBody CajeroCaja body) throws Exception {

        CajeroCaja newItem = cajeroCajaService.findByIdObraAndIdCajeroCaja(body.getIdObra(), body.getIdCajeroCaja());
        if(newItem != null){
            newItem.setIdCaja(body.getIdCaja());
            newItem.setFechaInicio(body.getFechaInicio());
            newItem.setFechaFin(body.getFechaFin());
            newItem.setFlgEstado(body.getFlgEstado());

            newItem.setModificadoPor(body.getModificadoPor());
            newItem.setFechaActualiza(new Date());

            return cajeroCajaService.saveCajeroCaja(newItem);
        } else {
            return null;
        }

        //Caja so=mapper.map(body, Caja.class);
        //Caja so2 =cajaService.modificar(so);

        //return cajeroCajaService.saveCajeroCaja(newItem); //mapper.map(cajaService.modificar( mapper.map(so, Caja.class) ),Caja.class);

    }



}
