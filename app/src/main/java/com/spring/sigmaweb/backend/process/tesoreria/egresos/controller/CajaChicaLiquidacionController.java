package com.spring.sigmaweb.backend.process.tesoreria.egresos.controller;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.AsientoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.CajaChicaLiquidacionDto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.DocumentoEgresoDto;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.RendicionCajaChicaLiquidacionDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CajaChicaLiquidacionDatosDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Asiento;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaChicaLiquidacion;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.service.CajaChicaLiquidacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/sigmaweb/cajachica-liquidacion")
@Validated
@RequiredArgsConstructor
public class CajaChicaLiquidacionController {

    private final ModelMapper mapper;
    private final CajaChicaLiquidacionService cajaChicaLiquidacionService;

    @GetMapping("listar/obra")
    public Page<CajaChicaLiquidacionDatosDTO> listarPorObra(@RequestParam String idObra,
                                                     @RequestParam Integer page,
                                                     @RequestParam Integer size)throws Exception {
        return cajaChicaLiquidacionService.listarPorObra(idObra,page,size);
    }

    @GetMapping("listar/documento-egreso")
    public List<CajaChicaLiquidacionDatosDTO> listarPorIdDocumentoEgreso(@RequestParam Long idDocumentoEgreso)throws Exception {
        return cajaChicaLiquidacionService.listarPorIdDocumentoEgreso(idDocumentoEgreso);
    }

    @GetMapping("buscar/id")
    public RendicionCajaChicaLiquidacionDTO buscarPorIdRendicion(@RequestParam Long idCajaChicaLiquidacion) throws Exception {


        return cajaChicaLiquidacionService.buscarPorIdRendicion(idCajaChicaLiquidacion);
    }

    @PostMapping
    public CajaChicaLiquidacionDto registrar(@RequestBody RendicionCajaChicaLiquidacionDTO bodyDTO){
//        CajaChicaLiquidacionDto cch= bodyDTO.getCajaChicaLiquidacion();
//        List<AsientoDTO> listaAsiento= bodyDTO.getAsientoDTOList();
//        CajaChicaLiquidacion cchl= mapper.map(cch,CajaChicaLiquidacion.class);
        return  mapper.map(cajaChicaLiquidacionService.registrarTransaccional(
                    mapper.map(
                            bodyDTO.getCajaChicaLiquidacion(),
                            CajaChicaLiquidacion.class),
                    bodyDTO.getAsientoDTOList()),
                CajaChicaLiquidacionDto.class);
    }


    @PutMapping
    public CajaChicaLiquidacionDto modificar(@RequestBody RendicionCajaChicaLiquidacionDTO bodyDTO){


        return  mapper.map(cajaChicaLiquidacionService.modificarTransaccional(
                        mapper.map(
                                bodyDTO.getCajaChicaLiquidacion(),
                                CajaChicaLiquidacion.class),
                                bodyDTO.getAsientoDTOList().stream().map(a->mapper.map(a, Asiento.class)).collect(Collectors.toList())
                        ),
                CajaChicaLiquidacionDto.class);
    }

    @DeleteMapping
    public void  eliminar(Long idCajaChicaLiquidacion) throws Exception {
        cajaChicaLiquidacionService.eliminar(idCajaChicaLiquidacion);
    }

    @PutMapping("/confirmar-rendicion")
    public Boolean confirmarRendicion(@RequestParam Long idDocumentoEgreso,
                                      @RequestParam BigDecimal montoEntregado,
                                      @RequestParam BigDecimal totalRendir,
                                      @RequestParam BigDecimal diferencia){
        return cajaChicaLiquidacionService.confirmarRendicion(idDocumentoEgreso,montoEntregado,totalRendir,diferencia);
    }

    public List<AsientoDTO>listarAsientosCajaChicaLiquidacion(@RequestParam String idObra){
        return null;
    }

}
