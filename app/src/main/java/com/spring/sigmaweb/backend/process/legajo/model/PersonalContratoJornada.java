package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "mo_personalcontratosjornada")
public class PersonalContratoJornada implements Serializable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_perjorn", nullable = false, unique = true)
    private Long idPerjorn;

    @JsonIgnoreProperties(value = { "idPersonalContPerjorn", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_percont_jorn", foreignKey = @ForeignKey(name = "fk_contrato_jornada"))
    private PersonalContrato idPersonalContPerjorn;

    @Column(name = "id_obra_perjorn", nullable = false, length = 6)
    private String idObraPerjorn;
//******************************************************************************
    @Column(nullable = false, name = "id_dia_perjorn")
    private Integer idDiaPerJorn;

    @Column(nullable = false, name = "dia_inihor_perjorn")
    private String diaInihorPerjorn;

    @Column(nullable = false, name = "dia_finhor_perjorn")
    private String diaFinhorPerjorn;

    @Column(nullable = false, name = "tipo_dia_perjorn")
    private String tipoDiaPerjorn;


    @Column(nullable = false, name = "fechaing_perjorn")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerjorn;

    @Column(nullable = false, name = "creapor_perjorn", length = 100)
    private String creaPorPerjorn;

    @Column(nullable = true, name = "fechamodi_perjorn")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerjorn;

    @Column(nullable = true, name = "modipor_perjorn", length = 100)
    private String modiPorPerjorn;


    @PrePersist
    public void prePersist() {
        this.fechaIngPerjorn = new Date();

    }

    public Long getIdPerjorn() {
        return idPerjorn;
    }

    public void setIdPerjorn(Long idPerjorn) {
        this.idPerjorn = idPerjorn;
    }

    public PersonalContrato getIdPersonalContPerjorn() {
        return idPersonalContPerjorn;
    }

    public void setIdPersonalContPerjorn(PersonalContrato idPersonalContPerjorn) {
        this.idPersonalContPerjorn = idPersonalContPerjorn;
    }

    public String getIdObraPerjorn() {
        return idObraPerjorn;
    }

    public void setIdObraPerjorn(String idObraPerjorn) {
        this.idObraPerjorn = idObraPerjorn;
    }

    public Integer getIdDiaPerJorn() {
        return idDiaPerJorn;
    }

    public void setIdDiaPerJorn(Integer idDiaPerJorn) {
        this.idDiaPerJorn = idDiaPerJorn;
    }

    public String getDiaInihorPerjorn() {
        return diaInihorPerjorn;
    }

    public void setDiaInihorPerjorn(String diaInihorPerjorn) {
        this.diaInihorPerjorn = diaInihorPerjorn;
    }

    public String getDiaFinhorPerjorn() {
        return diaFinhorPerjorn;
    }

    public void setDiaFinhorPerjorn(String diaFinhorPerjorn) {
        this.diaFinhorPerjorn = diaFinhorPerjorn;
    }

    public String getTipoDiaPerjorn() {
        return tipoDiaPerjorn;
    }

    public void setTipoDiaPerjorn(String tipoDiaPerjorn) {
        this.tipoDiaPerjorn = tipoDiaPerjorn;
    }

    public Date getFechaIngPerjorn() {
        return fechaIngPerjorn;
    }

    public void setFechaIngPerjorn(Date fechaIngPerjorn) {
        this.fechaIngPerjorn = fechaIngPerjorn;
    }

    public String getCreaPorPerjorn() {
        return creaPorPerjorn;
    }

    public void setCreaPorPerjorn(String creaPorPerjorn) {
        this.creaPorPerjorn = creaPorPerjorn;
    }

    public Date getFechaModiPerjorn() {
        return fechaModiPerjorn;
    }

    public void setFechaModiPerjorn(Date fechaModiPerjorn) {
        this.fechaModiPerjorn = fechaModiPerjorn;
    }

    public String getModiPorPerjorn() {
        return modiPorPerjorn;
    }

    public void setModiPorPerjorn(String modiPorPerjorn) {
        this.modiPorPerjorn = modiPorPerjorn;
    }
}
