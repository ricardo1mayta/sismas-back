package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class DocumentoEgresoListaDTO implements Serializable {
    private Long idDocumentoEgreso;
    private Integer numeroDocumentoEgreso;
    private Long idSolicitudGeneral;
    private Integer idTipoModoPago;
    private String modoPago;
    private Long idCargo;
    private String nombreCargo;
    private String numeroMovimiento;
    private BigDecimal importePagado;
    private Integer idTipoMoneda;
    private String tipoMoneda;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaRegistro;

    public DocumentoEgresoListaDTO(Long idDocumentoEgreso, Integer numeroDocumentoEgreso, Long idSolicitudGeneral, Integer idTipoModoPago, String modoPago, Long idCargo, String nombreCargo, String numeroMovimiento, BigDecimal importePagado, Integer idTipoMoneda, String tipoMoneda, Date fechaRegistro) {
        this.idDocumentoEgreso = idDocumentoEgreso;
        this.numeroDocumentoEgreso = numeroDocumentoEgreso;
        this.idSolicitudGeneral = idSolicitudGeneral;
        this.idTipoModoPago = idTipoModoPago;
        this.modoPago = modoPago;
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        this.numeroMovimiento = numeroMovimiento;
        this.importePagado = importePagado;
        this.idTipoMoneda = idTipoMoneda;
        this.tipoMoneda = tipoMoneda;
        this.fechaRegistro = fechaRegistro;
    }


    public DocumentoEgresoListaDTO() {
    }

    private static final long serialVersionUID = 1L;
}
