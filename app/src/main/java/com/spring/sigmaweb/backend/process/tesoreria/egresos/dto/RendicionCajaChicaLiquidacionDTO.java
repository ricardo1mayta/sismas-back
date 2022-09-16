package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RendicionCajaChicaLiquidacionDTO {
    CajaChicaLiquidacionDto cajaChicaLiquidacion;
    List<AsientoDTO> asientoDTOList;
}
