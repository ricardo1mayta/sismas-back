package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class CajaChicaLiquidacionDto {
    private  Long idCajaChicaLiquidacion;
    private SolicitudGeneralDatosDto idSolicitudGeneral;
    private DocumentoEgresoDto documentoEgreso;
    private EntidadDatosDTO entidadProveedor;
    private Integer idTipoDocumento;
    private String numeroDocumento;
    private BigDecimal importe;
    private BigDecimal descuento;
    private BigDecimal impuesto;
    private BigDecimal importeTotal;
    private BigDecimal importeDevuelto;
    private PlanContableDTO planContable;
    private String creaporPer;
    private Instant fechaRegistro;
    private String modiporPer;
    private Integer idTipoDistribucion;
    private Instant fechaLiquidacion;
    private Long idSolicitudGeneralNew;
    private Long idDocumentoEgresoNew;
    private Long idCajaChicaLiquidacionNew;
    private String descripcion;
    private Boolean flgEstado;
}
