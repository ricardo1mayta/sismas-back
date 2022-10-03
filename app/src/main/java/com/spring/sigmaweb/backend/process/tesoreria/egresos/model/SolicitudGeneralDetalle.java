package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "mt_solicitud_general_detalle")
public class SolicitudGeneralDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudDetalle;

    @ManyToOne()
    @JoinColumn(name = "id_solicitud_general")
    private SolicitudGeneral solicitudGeneral;

    @ManyToOne
    @JoinColumn(name = "id_centro_responsabilidad")
    private CentroResponsabilidad centroResponsabilidad;

    private Long idDistribucionPonderacion;
    private Long idDistribucionPonderacionDet;
    private Integer idTipoDistribucion;
    private BigDecimal importe;
    private String creaporPer;
    private String modiporPer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    private Date fechaActualiza;
    private Boolean flgEstado;

    @PrePersist
    public void prePersist(){this.fechaRegistro= new Date();}
}
