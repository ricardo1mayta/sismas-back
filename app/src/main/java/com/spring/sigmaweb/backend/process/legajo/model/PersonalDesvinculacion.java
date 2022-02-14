package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_personaldesvinculacion")
public class PersonalDesvinculacion  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perdesv", nullable = false)
    private Long idPerDesv;

    @Column(name = "id_obra_perdesv", nullable = false, length = 6)
    private String idObraPerdesv;

    @JsonIgnoreProperties(value = {"idPersonalPercargo", "idPersonalPerconv", "PersonalContrato", "personalDependiente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal_perdesv", foreignKey = @ForeignKey(name = "fk_desvinculacion_x_personal"))
    private Personal idPersonalPerdesv;

    @JsonIgnoreProperties(value = {"idPervilaPercargo", "idPervilaPerconv","idPervilaPercont","idPervilaPerdesv", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_pervila_perdesv", foreignKey = @ForeignKey(name = "fk_contrato_vidalaboral"))
    private PersonalVidaLaboral idPervilaPerdesv;

    @Column(nullable = true, name = "fechacese_perdesv")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCesePerdesv;

    @Column(nullable = false, name = "id_motivocese_perdesv")
    private Integer idMotivoPerdesv;

    @Column(name = "observaciones_perdesv", nullable = true, length = 500)
    private String observacionesPerdesv;

    @Column(nullable = false, name = "flg_compensacion_perdesv", columnDefinition = "boolean default false")
    private Boolean flgCompesacionPerdesv;

    @Column(nullable = false, name = "estado_perdesv", columnDefinition = "boolean default true")
    private Boolean estadoPerdesv;

    @Column(nullable = true, name = "compensacion_gracia_perdesv", columnDefinition = "boolean default 0.00")
    private Double compeGraciaPerdesv;

    @Column(nullable = true, name = "liquidacion_perdesv", columnDefinition = "boolean default 0.00")
    private Double liquidacionPerdesv;


    @Column(nullable = false, name = "fechaing_perdesv")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerdesv;

    @Column(nullable = false, name = "creapor_perdesv", length = 100)
    private String creaPorPerdesv;

    @Column(nullable = true, name = "fechamodi_perdesv")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerdesv;

    @Column(nullable = true, name = "modipor_perdesv", length = 100)
    private String modiPorPerdesv;

    @PrePersist
    public void prePersist() {
        this.fechaIngPerdesv = new Date();
    }


    public Long getIdPerDesv() {
        return idPerDesv;
    }

    public void setIdPerDesv(Long idPerDesv) {
        this.idPerDesv = idPerDesv;
    }

    public String getIdObraPerdesv() {
        return idObraPerdesv;
    }

    public void setIdObraPerdesv(String idObraPerdesv) {
        this.idObraPerdesv = idObraPerdesv;
    }

    public Personal getIdPersonalPerdesv() {
        return idPersonalPerdesv;
    }

    public void setIdPersonalPerdesv(Personal idPersonalPerdesv) {
        this.idPersonalPerdesv = idPersonalPerdesv;
    }

    public Date getFechaCesePerdesv() {
        return fechaCesePerdesv;
    }

    public void setFechaCesePerdesv(Date fechaCesePerdesv) {
        this.fechaCesePerdesv = fechaCesePerdesv;
    }

    public Integer getIdMotivoPerdesv() {
        return idMotivoPerdesv;
    }

    public void setIdMotivoPerdesv(Integer idMotivoPerdesv) {
        this.idMotivoPerdesv = idMotivoPerdesv;
    }

    public String getObservacionesPerdesv() {
        return observacionesPerdesv;
    }

    public void setObservacionesPerdesv(String observacionesPerdesv) {
        this.observacionesPerdesv = observacionesPerdesv;
    }

    public Boolean getFlgCompesacionPerdesv() {
        return flgCompesacionPerdesv;
    }

    public void setFlgCompesacionPerdesv(Boolean flgCompesacionPerdesv) {
        this.flgCompesacionPerdesv = flgCompesacionPerdesv;
    }

    public Boolean getEstadoPerdesv() {
        return estadoPerdesv;
    }

    public void setEstadoPerdesv(Boolean estadoPerdesv) {
        this.estadoPerdesv = estadoPerdesv;
    }

    public Double getCompeGraciaPerdesv() {
        return compeGraciaPerdesv;
    }

    public void setCompeGraciaPerdesv(Double compeGraciaPerdesv) {
        this.compeGraciaPerdesv = compeGraciaPerdesv;
    }

    public Double getLiquidacionPerdesv() {
        return liquidacionPerdesv;
    }

    public void setLiquidacionPerdesv(Double liquidacionPerdesv) {
        this.liquidacionPerdesv = liquidacionPerdesv;
    }

    public Date getFechaIngPerdesv() {
        return fechaIngPerdesv;
    }

    public void setFechaIngPerdesv(Date fechaIngPerdesv) {
        this.fechaIngPerdesv = fechaIngPerdesv;
    }

    public String getCreaPorPerdesv() {
        return creaPorPerdesv;
    }

    public void setCreaPorPerdesv(String creaPorPerdesv) {
        this.creaPorPerdesv = creaPorPerdesv;
    }

    public Date getFechaModiPerdesv() {
        return fechaModiPerdesv;
    }

    public void setFechaModiPerdesv(Date fechaModiPerdesv) {
        this.fechaModiPerdesv = fechaModiPerdesv;
    }

    public String getModiPorPerdesv() {
        return modiPorPerdesv;
    }

    public void setModiPorPerdesv(String modiPorPerdesv) {
        this.modiPorPerdesv = modiPorPerdesv;
    }

    public PersonalVidaLaboral getIdPervilaPerdesv() {
        return idPervilaPerdesv;
    }

    public void setIdPervilaPerdesv(PersonalVidaLaboral idPervilaPerdesv) {
        this.idPervilaPerdesv = idPervilaPerdesv;
    }

    private static final long serialVersionUID = 1L;
}
