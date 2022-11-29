package com.spring.sigmaweb.backend.process.generic.controller;

import com.spring.sigmaweb.backend.process.generic.dto.TipoCambioDTO;
import com.spring.sigmaweb.backend.process.generic.model.TipoCambio;
import com.spring.sigmaweb.backend.process.generic.service.impl.TipoCambioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sigmaweb/tipocambio")
@RequiredArgsConstructor
public class TipoCambioController {
    private final TipoCambioServiceImpl tipoCambioService;
    private final ModelMapper mapper;

    @GetMapping("buscar/idtipocambio")
    public ResponseEntity<TipoCambio> findByIdTipoCambio(@RequestParam Long idTipoCambio) {
        return new ResponseEntity<>(tipoCambioService.findByIdTipoCambio(idTipoCambio), HttpStatus.OK);
    }

    @GetMapping("buscar/obra/fecha")
    public ResponseEntity<TipoCambio> findByIdOBraAndDate(@RequestParam String idObra, @RequestParam Date fecha) {
        return new ResponseEntity<>(tipoCambioService.findByIdOBraAndDate(idObra, fecha), HttpStatus.OK);
    }

    @GetMapping("buscar/obra/fecha/moneda")
    public ResponseEntity<TipoCambio> findByIdOBraAndDateAndMoneda(@RequestParam String idObra, @RequestParam Date fecha, @RequestParam Integer moneda) {

        return new ResponseEntity<>(tipoCambioService.findByIdOBraAndDateAndMoneda(idObra, fecha, moneda), HttpStatus.OK);
    }

    @GetMapping("buscar/obra")
    public ResponseEntity<List<TipoCambio>> findByidObra(@RequestParam String idObra) {
        return new ResponseEntity<>(tipoCambioService.findByidObra(idObra), HttpStatus.OK);
    }

    @GetMapping("buscardto/obra")
    public ResponseEntity<List<TipoCambioDTO>> findByidObraDto(@RequestParam String idObra) {
        return new ResponseEntity<>(tipoCambioService.findByIdObraDto(idObra), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<TipoCambio> saveTipoCambio(@RequestBody TipoCambio body){
        body.setFechaRegistro(new Date());
        return  new ResponseEntity<>(tipoCambioService.save(body),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<TipoCambio> udpateTipoCambio(@RequestBody TipoCambio body){
        return  new ResponseEntity<>(tipoCambioService.save(body),HttpStatus.OK);
    }
}
