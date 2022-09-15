package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CentroResponsabilidadAuxDTO {

    private Long idCentroResponsabilidad;
    private String nombreCentroResponsabilidad;
    private String descCentroResponsabilidad;
    private Integer codigoCentroResponsabilidad;
    private BigDecimal importe;

}
