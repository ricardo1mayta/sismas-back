package com.spring.sigmaweb.backend.process.tesoreria.egresos.service;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.AsientoDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.RendicionCajaChicaLiquidacionDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen.CajaChicaLiquidacionDatosDTO;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.CajaChicaLiquidacion;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface CajaChicaLiquidacionService extends ICRUD<CajaChicaLiquidacion,Long>{
    Page<CajaChicaLiquidacionDatosDTO>listarPorObra(String idObra,Integer page,Integer size);
    CajaChicaLiquidacion registrarTransaccional(CajaChicaLiquidacion cajaChicaLiquidacion, List<AsientoDTO> asientoDTOList);
    List<CajaChicaLiquidacionDatosDTO> listarPorIdDocumentoEgreso(Long idDocumentoEgreso);
    Boolean confirmarRendicion(Long idDocumentoEgreso, BigDecimal montoEntregado, BigDecimal totalRendir, BigDecimal diferencia);
    RendicionCajaChicaLiquidacionDTO buscarPorIdRendicion(Long idCajaChicaLiquidacion);
}
