package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "mt_caja_chica_liquidacion")
public class CajaChicaLiquidacion {
    @Id
    private Long idCajaChicaLiquidacion;

    private String idObra;

    @ManyToOne
    @JoinColumn(name = "id_solicitud_general")
    private SolicitudGeneral solicitudGeneral;

    @Column(name = "id_caja_chica_movimiento")
    private Long idCajaChicaMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_documento_egreso")
    private DocumentoEgreso documentoEgreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad_proveedor")
    private Entidad entidadProveedor;

    private Integer idTipoDocumento;

    @Column(name = "numero_documento", length = 15)
    private String numeroDocumento;

    @Column(name = "importe", precision = 12, scale = 2)
    private BigDecimal importe;

    @Column(name = "descuento", precision = 12, scale = 2)
    private BigDecimal descuento;

    @Column(name = "impuesto", precision = 12, scale = 2)
    private BigDecimal impuesto;

    @Column(name = "importe_total", precision = 12, scale = 2)
    private BigDecimal importeTotal;

    @Column(name = "importe_devuelto", precision = 12, scale = 2)
    private BigDecimal importeDevuelto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_contable")
    private PlanContable planContable;

    @Column(name = "creapor_per", length = 20)
    private String creaporPer;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "modipor_per", length = 20)
    private String modiporPer;

    private Integer idTipoDistribucion;

    @Column(name = "fecha_liquidacion")
    private Date fechaLiquidacion;

    @Column(name = "id_solicitud_general_new")
    private Long idSolicitudGeneralNew;

    @Column(name = "id_documento_egreso_new")
    private Long idDocumentoEgresoNew;

    @Column(name = "id_caja_chica_liquidacion_new")
    private Long idCajaChicaLiquidacionNew;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "flg_estado")
    private Boolean flgEstado;
}
