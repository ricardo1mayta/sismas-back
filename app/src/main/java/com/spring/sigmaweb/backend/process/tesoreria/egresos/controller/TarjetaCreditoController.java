package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.service.PersonalService;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.TarjetaCreditoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.TarjetaCreditoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("listar/obra")
    public List<TarjetaCreditoDTO> listarPorObra(@RequestParam String idObra) {
        return  tarjetaCreditoService.listarPorIdObra(idObra).stream().map(tc->mapper.map(tc, TarjetaCreditoDTO.class)).collect(Collectors.toList());
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
}
