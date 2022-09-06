package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.dto.PersonaDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDTO;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Detraccion;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentoEgresoDto  {
    private  Long idDocumentoEgreso;
    private  String idObra;
    private  Integer numeroDocumentoEgreso;
    private  Long idCajaGen;
    private  String idTipoDocumentoEgreso;
    private  Integer idCompra;
    private  SolicitudGeneralDatosDto solicitudGeneral;
    private  Long idCaja;
    private String usuarioCaja;
    private Long idUsuarioCaja;
    private  EntidadDatosDTO proveedorCargo;
    private  PersonaDTO peronsaCargo;
    private  PersonalDTO personaCargo;
    private  Integer idTipoModoPago;
    private  String glosa;
    private  BigDecimal importePagado;
    private Detraccion detraccion;
    private  BigDecimal importeDetraccion;
    private  Integer idTipoMoneda;

    @JsonIgnoreProperties({"cuentaBanco","hibernateLazyInitializer", "handler" })
    private  EntidadDatosDTO entidadBanco;

    @JsonIgnoreProperties({"cuentaBanco","entidadBanco","tarjetaCredito","hibernateLazyInitializer", "handler" })
    private  CuentaBancoDatosDTO cuentaBanco;
    private TarjetaCreditoDTO tarjetaCredito;
    private  String numeroMovimiento;
    private  String numeroDocumentoReferencia;
    private  Boolean flgRendicion;
    private  Integer idTipoCambio;
    private  Integer idTipoDocumento;
    private  String serieDocumento;
    private  BigDecimal importeGarantia;
    private  BigDecimal descuentoNotaCredito;
    private  String numeroNotaCredito;
    private  String creaporPer;
    private  Date fechaRegistro;
    private  String modiporPer;
    private  Date fechaActualiza;
    private  Boolean flgEstado;
}
