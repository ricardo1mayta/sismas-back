package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudGeneralDetalleDTO {


    private Long idSolicitudDetalle;

    private SolicitudGeneralDTO solicitudGeneral;
    private CentroResponsabilidadDTO centroResponsabilidad;
    private Integer idTipoDistribucion;
    private Long idDistribucionPonderacionDet;
    private Long idDistribucionPonderacion;
    private BigDecimal importe;
    private String creaporPer;
    private String modiporPer;
    private Date fechaRegistro;
    private Date fechaActualiza;
    private Boolean flgEstado;
}
