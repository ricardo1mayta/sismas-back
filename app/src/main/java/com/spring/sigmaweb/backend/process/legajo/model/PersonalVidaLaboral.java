package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mo_personalvidalaboral")
public class PersonalVidaLaboral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pervila", nullable = false, unique = true)
    private Long idPervila;

    @Column(name = "id_obra_pervila", nullable = false, length = 6)
    private String idObraPervila;

    @JsonIgnoreProperties(value = { "id_personal_pervila", "idPersonalPerconv", "PersonalContrato", "personalDependiente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal_pervila", foreignKey = @ForeignKey(name = "fk_vidalaboral_personal"))
    private Personal idPersonalPervila;

    @Column(nullable = false, name = "fechainicio_pervila")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioPervila;

    @Column(nullable = true, name = "fechafin_pervila")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPervila;

    @Column(name = "estado_pervila", nullable = false, length = 20)
    private String estadoPervila;

    @Column(nullable = false, name = "creapor_pervila", length = 100)
    private String creaPorPervila;

    @Column(nullable = false, name = "fechaing_pervila")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPervila;

    @Column(nullable = true, name = "modipor_pervila", length = 100)
    private String modiPorPervila;

    @Column(nullable = true, name = "fechamodi_pervila")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPervila;

    @JsonIgnoreProperties({ "idPervilaPercont", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPervilaPercont", cascade = CascadeType.ALL)
    private List<PersonalContrato> personalContrato;

    @JsonIgnoreProperties({ "idPervilaPerconv", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPervilaPerconv", cascade = CascadeType.ALL)
    private List<PersonalConvenio> PersonalConvenio;

    @JsonIgnoreProperties({ "idPervilaPerdesv", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPervilaPerdesv", cascade = CascadeType.ALL)
    private List<PersonalDesvinculacion> personalDesvinculacion;

    @JsonIgnoreProperties({ "idPervilaPercargo", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPervilaPercargo", cascade = CascadeType.ALL)
    private List<PersonalCargo> personalCargos;

    @JsonIgnoreProperties({ "idPervilaPerpuest", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPervilaPerpuest", cascade = CascadeType.ALL)
    private List<PersonalPuesto> personalPuesto;

    @PrePersist
    public void prePersist() {
        this.fechaIngPervila = new Date();

    }

    public Long getIdPervila() {
        return idPervila;
    }

    public void setIdPervila(Long idPervila) {
        this.idPervila = idPervila;
    }

    public String getIdObraPervila() {
        return idObraPervila;
    }

    public void setIdObraPervila(String idObraPervila) {
        this.idObraPervila = idObraPervila;
    }

    public Personal getIdPersonalPervila() {
        return idPersonalPervila;
    }

    public void setIdPersonalPervila(Personal idPersonalPervila) {
        this.idPersonalPervila = idPersonalPervila;
    }

    public Date getFechaInicioPervila() {
        return fechaInicioPervila;
    }

    public void setFechaInicioPervila(Date fechaInicioPervila) {
        this.fechaInicioPervila = fechaInicioPervila;
    }

    public Date getFechaFinPervila() {
        return fechaFinPervila;
    }

    public void setFechaFinPervila(Date fechaFinPervila) {
        this.fechaFinPervila = fechaFinPervila;
    }

    public String getEstadoPervila() {
        return estadoPervila;
    }

    public void setEstadoPervila(String estadoPervila) {
        this.estadoPervila = estadoPervila;
    }

    public String getCreaPorPervila() {
        return creaPorPervila;
    }

    public void setCreaPorPervila(String creaPorPervila) {
        this.creaPorPervila = creaPorPervila;
    }

    public Date getFechaIngPervila() {
        return fechaIngPervila;
    }

    public void setFechaIngPervila(Date fechaIngPervila) {
        this.fechaIngPervila = fechaIngPervila;
    }

    public String getModiPorPervila() {
        return modiPorPervila;
    }

    public void setModiPorPervila(String modiPorPervila) {
        this.modiPorPervila = modiPorPervila;
    }

    public Date getFechaModiPervila() {
        return fechaModiPervila;
    }

    public void setFechaModiPervila(Date fechaModiPervila) {
        this.fechaModiPervila = fechaModiPervila;
    }

    private static final long serialVersionUID = 1L;
}
