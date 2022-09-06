package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacion;
import lombok.Data;



@Data
public class DistribucionPonderacionDetalleDTO {

    private Long idDistribucionPonderacionDetalle;
    private DistribucionPonderacion distribucionPonderacion;
    private String nombreDistribucionDetalle;
    private Integer medidaNumerico;
    private Integer medidaPorcentual;
    private Long idCentroResponsabilidad;
    private Boolean flgCalculo;
    private String periodo;
    private Boolean flgEstado;

}
