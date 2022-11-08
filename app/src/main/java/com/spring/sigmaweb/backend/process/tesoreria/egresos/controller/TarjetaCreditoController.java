package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.service.PersonalService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDataDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TipoConceptoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TarjetaCredito;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.TipoConcepto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CuentaBancoService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.TarjetaCreditoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/sigmaweb/tarjetascredito")
@RequiredArgsConstructor
public class TarjetaCreditoController {

    private final ModelMapper mapper;
    private final TarjetaCreditoService tarjetaCreditoService;
    private final PersonalService personalService;
    private final CuentaBancoService cuentaBancoService;

    @GetMapping("listar/obra")
    public List<TarjetaCreditoDTO> listarPorObra(@RequestParam String idObra) {
        return  tarjetaCreditoService.listarPorIdObra(idObra).stream().map(tc->mapper.map(tc, TarjetaCreditoDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("listar/obra/estado")
    public List<TarjetaCreditoDataDTO> listarPorObraEstado(@RequestParam String idObra, @RequestParam Integer estado) {
        return  tarjetaCreditoService.findByidObraEstado(idObra,estado);
    }

    @GetMapping("listar/obra/tipo-cuentabanco")
    public List<TarjetaCreditoDTO> listarPorIdCuentaBancoYObra(@RequestParam String idObra,@RequestParam Long idCuentaBanco) {
        List<TarjetaCreditoDTO> lista= new ArrayList<>();
        lista= tarjetaCreditoService.listarPorIdCuentaBancoYObra(idCuentaBanco,idObra).stream()
                .map(tc->
                        mapper.map(tc, TarjetaCreditoDTO.class)
                ).collect(Collectors.toList());


        for (TarjetaCreditoDTO l: lista){
            PersonalDatosListDTO personalDTO = new PersonalDatosListDTO();
            personalDTO=personalService.findByIdPersonalResumen(l.getPersonal().getIdPersonal());
            l.setPersonal(personalDTO);
        }
        return lista;
    }

    @PostMapping
    public ResponseEntity<TarjetaCredito> guardarTarjetaCredito (@RequestBody TarjetaCreditoDataDTO bodyDTO) throws Exception {
        //bodyDTO.setFechaRegistro(new Date());
        TarjetaCredito newTarjeta=null;
        newTarjeta.setNumeroTarjeta(bodyDTO.getNumeroTarjeta());
        newTarjeta.setCuentaBanco(cuentaBancoService.buscarPorIdCuentaBanco(bodyDTO.getIdCuentaBanco()));
        newTarjeta.setPersonal(personalService.findByIdPersonalAndObraname(bodyDTO.getIdPersonal(), bodyDTO.getIdObra()));
        newTarjeta.setIdObra(bodyDTO.getIdObra());
        newTarjeta.setFechaRegistro(new Date());


        return  new ResponseEntity<>(tarjetaCreditoService.save(newTarjeta), HttpStatus.OK);
        //return mapper.map(tipoConceptoService.registrar( mapper.map(bodyDTO, TipoConcepto.class) ),TipoConceptoDTO.class);
    }
}
