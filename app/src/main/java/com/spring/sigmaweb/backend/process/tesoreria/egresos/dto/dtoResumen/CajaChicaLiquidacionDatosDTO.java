package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CajaChicaLiquidacionDatosDTO {
    private  Long idCajaChicaLiquidacion;
    private Long idDocumentoEgreso;
    private Long idEntidadProveedor;
    private Integer idTipoDocumento;
    private String nombreDocumento;
    private String numeroDocumento;
    private BigDecimal importe;
    private BigDecimal descuento;
    private BigDecimal impuesto;
    private BigDecimal importeTotal;
    private BigDecimal importeDevuelto;

}
