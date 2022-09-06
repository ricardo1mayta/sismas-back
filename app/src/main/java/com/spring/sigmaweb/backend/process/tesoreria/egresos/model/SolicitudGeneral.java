package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_solicitud_general")
public class SolicitudGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud_general")
    private Long idSolicitudGeneral;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_personal")
    private Personal personal;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_personal_cargo")
    private Personal personalCargo;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_persona_cargo")
    private Persona personaCargo;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_entidad_cargo")
    private Entidad entidadCargo;

    private String idObra;

//    @ManyToOne
//    @JoinColumn(name = "id_concepto")
//    private Concepto Concepto;

    @ManyToOne
    @JoinColumn(name="id_plan_contable")
    private PlanContable planContable;

    @ManyToOne
    @JoinColumn(name = "id_tipo_solicitud")
    private TipoSolicitud tipoSolicitud;

    private Integer idTipoMoneda;
    private BigDecimal importeSolicitado;
    private BigDecimal importeAprobado;
    private Date fechaSolicitud;

    private String motivo;
    private String detalle;
    private Integer idEstado;
    private Long idUsuarioAutoriza;
    private String creaporPer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    private String modiporPer;

    private Date fechaActualiza;
    private String idResponsableCheque;
    private String idEstadoRendimiento;
    private String idTipoResponsableCheque;
    private Integer idTipoModoPago;
    private Boolean flgCr;
    private Boolean flgEstado;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_banco")
    private CuentaBanco cuentaBanco;
    @ManyToOne
    @JoinColumn(name = "id_tarjeta_credito")
    private TarjetaCredito tarjetaCredito;

    @ManyToOne
    @JoinColumn(name = "id_actividad_presupuestal")
    private ActividadPresupuestal actividadPresupuestal;

    @JsonIgnoreProperties({"solicitudGeneral","hibernateLazyInitializer", "handler" })
    @OneToMany(mappedBy = "solicitudGeneral",cascade = { CascadeType.ALL })
    private List<SolicitudGeneralDetalle> solicitudGeneralDetalle;

    @PrePersist
    public void prePersist(){
        this.fechaRegistro = new Date();
    }

}
