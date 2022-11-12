package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.SolicitudGeneralDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDataDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.SolicitudGeneral;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TarjetaCredito;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.IActividadPresupuestalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("sigmaweb/caja")
@RequiredArgsConstructor
public class CajaController {
    private final ModelMapper mapper;
    private final CajaService cajaService;

    @GetMapping("listar/obra")
    public List<Caja> listasCajaPorObras(@RequestParam String idobra) throws Exception{
        return cajaService.findByIdObra(idobra);
    }

    @GetMapping("buscar/obra/id")
    public Caja listasCajaPorObras(@RequestParam String idobra, @RequestParam Long idcaja) throws Exception{
        return cajaService.findByIdObraAndIdCaja(idobra, idcaja);
    }

    @PostMapping
    public ResponseEntity<Caja> guardarCaja (@RequestBody Caja body) throws Exception {

        Caja newItem=null;
        newItem = new Caja();
        newItem.setIdObra(body.getIdObra());
        newItem.setNombreCaja(body.getNombreCaja());
        newItem.setHostIp(body.getHostIp());
        newItem.setHostName(body.getHostName());
        newItem.setMac(body.getMac());
        newItem.setCreaporPer(body.getCreaporPer());
        newItem.setFechaRegistro((new Date()));

        return  new ResponseEntity<>(cajaService.save(newItem), HttpStatus.OK);
        //return mapper.map(tipoConceptoService.registrar( mapper.map(bodyDTO, TipoConcepto.class) ),TipoConceptoDTO.class);
    }

    @PutMapping
    public Caja modificarCaja (@RequestBody Caja body) throws Exception {
        body.setFechaActualiza(new Date());
        Caja so=mapper.map(body, Caja.class);
        Caja so2 =cajaService.modificar(so);

        return mapper.map(cajaService.modificar( mapper.map(so, Caja.class) ),Caja.class);

    }


}
