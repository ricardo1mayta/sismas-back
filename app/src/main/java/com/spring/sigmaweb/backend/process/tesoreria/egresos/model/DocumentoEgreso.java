package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.Persona;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_documento_egreso")
public class DocumentoEgreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumentoEgreso;
    private String idObra;
    private Integer numeroDocumentoEgreso;
    private Long idCajaGen;
    private String idTipoDocumentoEgreso;
    private Integer idCompra; //por definir

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_solicitud_general")
    private SolicitudGeneral solicitudGeneral;
    private Long idCaja;
    private String usuarioCaja;
    private Long idUsuarioCaja;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_proveedor_cargo")
    private Entidad proveedorCargo;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_persona_cargo")
    private Persona personaCargo;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_personal_cargo")
    private Personal personalCargo;

    private Integer idTipoModoPago;
    private String glosa;
    private BigDecimal importePagado;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_detraccion")
    private Detraccion detraccion;

    private BigDecimal importeDetraccion;
    private Integer idTipoMoneda;

    @ManyToOne
    @JoinColumn(name = "id_entidad_banco")
    private Entidad entidadBanco;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_banco")
    private CuentaBanco cuentaBanco;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name="id_tarjeta_credito")
    private TarjetaCredito tarjetaCredito;

    private String numeroMovimiento;
    private String numeroDocumentoReferencia;
    private Boolean flgRendicion;
    private Long idTipoCambio;
    private Float tipoCambioVenta;
    private Integer idTipoDocumento;
    private String serieDocumento;
    private BigDecimal importeGarantia; //validar
    private BigDecimal descuentoNotaCredito;
    private String numeroNotaCredito;
    private String creaporPer;
    private Date fechaRegistro;
    private String modiporPer;
    private Date fechaActualiza;
    private Boolean flgEstado;


}
