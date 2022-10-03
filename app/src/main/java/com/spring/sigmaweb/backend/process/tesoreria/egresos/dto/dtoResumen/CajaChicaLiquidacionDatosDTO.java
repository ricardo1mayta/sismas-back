package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class CajaChicaLiquidacionDatosDTO {
    private  Long idCajaChicaLiquidacion;
    private Long idDocumentoEgreso;
    private Long idEntidadProveedor;
    private String nombreEnt;
    private String RUC;
    private Integer idTipoDocumento;
    private String nombreDocumento;
    private String numeroDocumento;
    private BigDecimal importe;
    private BigDecimal descuento;
    private BigDecimal impuesto;
    private BigDecimal importeTotal;
    private BigDecimal importeDevuelto;

    public CajaChicaLiquidacionDatosDTO(Long idCajaChicaLiquidacion, Long idDocumentoEgreso, Long idEntidadProveedor, Integer idTipoDocumento, String nombreDocumento, String numeroDocumento, BigDecimal importe, BigDecimal descuento, BigDecimal impuesto, BigDecimal importeTotal, BigDecimal importeDevuelto) {
        this.idCajaChicaLiquidacion = idCajaChicaLiquidacion;
        this.idDocumentoEgreso = idDocumentoEgreso;
        this.idEntidadProveedor = idEntidadProveedor;
        this.idTipoDocumento = idTipoDocumento;
        this.nombreDocumento = nombreDocumento;
        this.importe = importe;
        this.descuento = descuento;
        this.impuesto = impuesto;
        this.importeTotal = importeTotal;
        this.importeDevuelto = importeDevuelto;
    }

    public CajaChicaLiquidacionDatosDTO(Long idCajaChicaLiquidacion, Long idDocumentoEgreso, Long idEntidadProveedor, String nombreEnt, String RUC, Integer idTipoDocumento, String nombreDocumento, String numeroDocumento, BigDecimal importe, BigDecimal descuento, BigDecimal impuesto, BigDecimal importeTotal, BigDecimal importeDevuelto) {
        this.idCajaChicaLiquidacion = idCajaChicaLiquidacion;
        this.idDocumentoEgreso = idDocumentoEgreso;
        this.idEntidadProveedor = idEntidadProveedor;
        this.nombreEnt = nombreEnt;
        this.RUC = RUC;
        this.idTipoDocumento = idTipoDocumento;
        this.nombreDocumento = nombreDocumento;
        this.numeroDocumento = numeroDocumento;
        this.importe = importe;
        this.descuento = descuento;
        this.impuesto = impuesto;
        this.importeTotal = importeTotal;
        this.importeDevuelto = importeDevuelto;
    }
}
