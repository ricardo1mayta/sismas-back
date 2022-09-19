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
public class AsientoDTO {
    private Long idAsiento;
    private String idObra;
    private Long idObjeto;
    private String objeto;
    private Integer cuentaDebe;
    private Integer cuentaHaber;
    private Long idCentroResponsabilidad;
    private BigDecimal importe;
    private String numeroComprobante;
    private Long idProcesoRecuperacion;
    private String ruc;
    private Integer idTipoMoneda;
    private Long idTipoCambio;
    private Integer idTipoOpereacion;
    private Date fechaperacion;
    private Date fechaDocumento;
    private Integer anio;
    private Integer mes;
    private Integer idTipoDocumento;
    private Date fechaRegistro;
    private String creaporPer;
    private String modiporPer;
    private Date fechaActualiza;
    private Boolean flgEstado;
    private Long idDitribucionPonderacion;
    private Long idDistribucionPonderacionDet;
}
