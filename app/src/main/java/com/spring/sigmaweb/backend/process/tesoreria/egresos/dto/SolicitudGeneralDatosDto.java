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
public class SolicitudGeneralDatosDto {
    private Long idSolicitudGeneral;
    private String idObra;
    private Integer idTipoMoneda;
    private BigDecimal importeSolicitado;
    private BigDecimal importeAprobado;
    private Date fechaSolicitud;
    private String motivo;
    private String detalle;
    private Integer idEstado;
    private Long idUsuarioAutoriza;
    private Boolean flgCr;
}
