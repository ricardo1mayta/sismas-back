package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "mo_personalcontratosjornada")
public class PersonalContratoJornada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perjorn", nullable = false, unique = true)
    private Long idPerjorn;

    @JsonIgnoreProperties(value = { "idPersonalContPerjorn", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_percont_jorn", foreignKey = @ForeignKey(name = "fk_contrato_jornada"))
    private PersonalContrato idPersonalContPerjorn;

    @Column(name = "id_obra_perjorn", nullable = false, length = 6)
    private String idObraPerjorn;
//******************************************************************************
    @Column(nullable = false, name = "dia_lune", columnDefinition = "boolean default false")
    private Boolean diaLunePerjorn;

    @Column(nullable = false, name = "dia_mart", columnDefinition = "boolean default false")
    private Boolean diaMartPerjorn;

    @Column(nullable = false, name = "dia_mier", columnDefinition = "boolean default false")
    private Boolean diaMierPerjorn;

    @Column(nullable = false, name = "dia_juev", columnDefinition = "boolean default false")
    private Boolean diaJuevPerjorn;

    @Column(nullable = false, name = "dia_vier", columnDefinition = "boolean default false")
    private Boolean diaVierPerjorn;

    @Column(nullable = false, name = "dia_saba", columnDefinition = "boolean default false")
    private Boolean diaSabaPerjorn;

    @Column(nullable = false, name = "dia_domi", columnDefinition = "boolean default false")
    private Boolean diaDomiPerjorn;
//******************************************************************************
    @Column(nullable = true, name = "dia_lune_inihor")
    private String diaLuneInihorPerjorn;

    @Column(nullable = true, name = "dia_lune_finhor")
    private String diaLuneFinhorPerjorn;

    @Column(nullable = true, name = "dia_mart_inihor")
    private String diaMartInihorPerjorn;

    @Column(nullable = true, name = "dia_mart_finhor")
    private String diaMartFinhorPerjorn;

    @Column(nullable = true, name = "dia_mier_inihor")
    private String diaMierInihorPerjorn;

    @Column(nullable = true, name = "dia_mier_finhor")
    private String diaMierFinhorPerjorn;

    @Column(nullable = true, name = "dia_juev_inihor")
    private String diaJuevInihorPerjorn;

    @Column(nullable = true, name = "dia_juev_finhor")
    private String diaJuevFinhorPerjorn;

    @Column(nullable = true, name = "dia_vier_inihor")
    private String diaVierInihorPerjorn;

    @Column(nullable = true, name = "dia_vier_finhor")
    private String diaVierFinhorPerjorn;

    @Column(nullable = true, name = "dia_saba_inihor")
    private String diaSabaInihorPerjorn;

    @Column(nullable = true, name = "dia_saba_finhor")
    private String diaSabaFinhorPerjorn;

    @Column(nullable = true, name = "dia_domi_inihor")
    private String diaDomiInihorPerjorn;

    @Column(nullable = true, name = "dia_domi_finhor")
    private String diaDomiFinhorPerjorn;

//**************************************************************************
    @Column(nullable = true, name = "dia_lune_iniref")
    private String diaLuneInirefPerjorn;

    @Column(nullable = true, name = "dia_lune_finref")
    private String diaLuneFinrefPerjorn;

    @Column(nullable = true, name = "dia_mart_iniref")
    private String diaMartInirefPerjorn;

    @Column(nullable = true, name = "dia_mart_finref")
    private String diaMartFinrefPerjorn;

    @Column(nullable = true, name = "dia_mier_iniref")
    private String diaMierInirefPerjorn;

    @Column(nullable = true, name = "dia_mier_finref")
    private String diaMierFinrefPerjorn;

    @Column(nullable = true, name = "dia_juev_iniref")
    private String diaJuevInirefPerjorn;

    @Column(nullable = true, name = "dia_juev_finref")
    private String diaJuevFinrefPerjorn;

    @Column(nullable = true, name = "dia_vier_iniref")
    private String diaVierInirefPerjorn;

    @Column(nullable = true, name = "dia_vier_finref")
    private String diaVierFinrefPerjorn;

    @Column(nullable = true, name = "dia_saba_iniref")
    private String diaSabaInirefPerjorn;

    @Column(nullable = true, name = "dia_saba_finref")
    private String diaSabaFinrefPerjorn;

    @Column(nullable = true, name = "dia_domi_iniref")
    private String diaDomiInirefPerjorn;

    @Column(nullable = true, name = "dia_domi_finref")
    private String diaDomiFinrefPerjorn;


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

    public Boolean getDiaLunePerjorn() {
        return diaLunePerjorn;
    }

    public void setDiaLunePerjorn(Boolean diaLunePerjorn) {
        this.diaLunePerjorn = diaLunePerjorn;
    }

    public Boolean getDiaMartPerjorn() {
        return diaMartPerjorn;
    }

    public void setDiaMartPerjorn(Boolean diaMartPerjorn) {
        this.diaMartPerjorn = diaMartPerjorn;
    }

    public Boolean getDiaMierPerjorn() {
        return diaMierPerjorn;
    }

    public void setDiaMierPerjorn(Boolean diaMierPerjorn) {
        this.diaMierPerjorn = diaMierPerjorn;
    }

    public Boolean getDiaJuevPerjorn() {
        return diaJuevPerjorn;
    }

    public void setDiaJuevPerjorn(Boolean diaJuevPerjorn) {
        this.diaJuevPerjorn = diaJuevPerjorn;
    }

    public Boolean getDiaVierPerjorn() {
        return diaVierPerjorn;
    }

    public void setDiaVierPerjorn(Boolean diaVierPerjorn) {
        this.diaVierPerjorn = diaVierPerjorn;
    }

    public Boolean getDiaSabaPerjorn() {
        return diaSabaPerjorn;
    }

    public void setDiaSabaPerjorn(Boolean diaSabaPerjorn) {
        this.diaSabaPerjorn = diaSabaPerjorn;
    }

    public Boolean getDiaDomiPerjorn() {
        return diaDomiPerjorn;
    }

    public void setDiaDomiPerjorn(Boolean diaDomiPerjorn) {
        this.diaDomiPerjorn = diaDomiPerjorn;
    }

    public String getDiaLuneInihorPerjorn() {
        return diaLuneInihorPerjorn;
    }

    public void setDiaLuneInihorPerjorn(String diaLuneInihorPerjorn) {
        this.diaLuneInihorPerjorn = diaLuneInihorPerjorn;
    }

    public String getDiaLuneFinhorPerjorn() {
        return diaLuneFinhorPerjorn;
    }

    public void setDiaLuneFinhorPerjorn(String diaLuneFinhorPerjorn) {
        this.diaLuneFinhorPerjorn = diaLuneFinhorPerjorn;
    }

    public String getDiaMartInihorPerjorn() {
        return diaMartInihorPerjorn;
    }

    public void setDiaMartInihorPerjorn(String diaMartInihorPerjorn) {
        this.diaMartInihorPerjorn = diaMartInihorPerjorn;
    }

    public String getDiaMartFinhorPerjorn() {
        return diaMartFinhorPerjorn;
    }

    public void setDiaMartFinhorPerjorn(String diaMartFinhorPerjorn) {
        this.diaMartFinhorPerjorn = diaMartFinhorPerjorn;
    }

    public String getDiaMierInihorPerjorn() {
        return diaMierInihorPerjorn;
    }

    public void setDiaMierInihorPerjorn(String diaMierInihorPerjorn) {
        this.diaMierInihorPerjorn = diaMierInihorPerjorn;
    }

    public String getDiaMierFinhorPerjorn() {
        return diaMierFinhorPerjorn;
    }

    public void setDiaMierFinhorPerjorn(String diaMierFinhorPerjorn) {
        this.diaMierFinhorPerjorn = diaMierFinhorPerjorn;
    }

    public String getDiaJuevInihorPerjorn() {
        return diaJuevInihorPerjorn;
    }

    public void setDiaJuevInihorPerjorn(String diaJuevInihorPerjorn) {
        this.diaJuevInihorPerjorn = diaJuevInihorPerjorn;
    }

    public String getDiaJuevFinhorPerjorn() {
        return diaJuevFinhorPerjorn;
    }

    public void setDiaJuevFinhorPerjorn(String diaJuevFinhorPerjorn) {
        this.diaJuevFinhorPerjorn = diaJuevFinhorPerjorn;
    }

    public String getDiaVierInihorPerjorn() {
        return diaVierInihorPerjorn;
    }

    public void setDiaVierInihorPerjorn(String diaVierInihorPerjorn) {
        this.diaVierInihorPerjorn = diaVierInihorPerjorn;
    }

    public String getDiaVierFinhorPerjorn() {
        return diaVierFinhorPerjorn;
    }

    public void setDiaVierFinhorPerjorn(String diaVierFinhorPerjorn) {
        this.diaVierFinhorPerjorn = diaVierFinhorPerjorn;
    }

    public String getDiaSabaInihorPerjorn() {
        return diaSabaInihorPerjorn;
    }

    public void setDiaSabaInihorPerjorn(String diaSabaInihorPerjorn) {
        this.diaSabaInihorPerjorn = diaSabaInihorPerjorn;
    }

    public String getDiaSabaFinhorPerjorn() {
        return diaSabaFinhorPerjorn;
    }

    public void setDiaSabaFinhorPerjorn(String diaSabaFinhorPerjorn) {
        this.diaSabaFinhorPerjorn = diaSabaFinhorPerjorn;
    }

    public String getDiaDomiInihorPerjorn() {
        return diaDomiInihorPerjorn;
    }

    public void setDiaDomiInihorPerjorn(String diaDomiInihorPerjorn) {
        this.diaDomiInihorPerjorn = diaDomiInihorPerjorn;
    }

    public String getDiaDomiFinhorPerjorn() {
        return diaDomiFinhorPerjorn;
    }

    public void setDiaDomiFinhorPerjorn(String diaDomiFinhorPerjorn) {
        this.diaDomiFinhorPerjorn = diaDomiFinhorPerjorn;
    }

    public String getDiaLuneInirefPerjorn() {
        return diaLuneInirefPerjorn;
    }

    public void setDiaLuneInirefPerjorn(String diaLuneInirefPerjorn) {
        this.diaLuneInirefPerjorn = diaLuneInirefPerjorn;
    }

    public String getDiaLuneFinrefPerjorn() {
        return diaLuneFinrefPerjorn;
    }

    public void setDiaLuneFinrefPerjorn(String diaLuneFinrefPerjorn) {
        this.diaLuneFinrefPerjorn = diaLuneFinrefPerjorn;
    }

    public String getDiaMartInirefPerjorn() {
        return diaMartInirefPerjorn;
    }

    public void setDiaMartInirefPerjorn(String diaMartInirefPerjorn) {
        this.diaMartInirefPerjorn = diaMartInirefPerjorn;
    }

    public String getDiaMartFinrefPerjorn() {
        return diaMartFinrefPerjorn;
    }

    public void setDiaMartFinrefPerjorn(String diaMartFinrefPerjorn) {
        this.diaMartFinrefPerjorn = diaMartFinrefPerjorn;
    }

    public String getDiaMierInirefPerjorn() {
        return diaMierInirefPerjorn;
    }

    public void setDiaMierInirefPerjorn(String diaMierInirefPerjorn) {
        this.diaMierInirefPerjorn = diaMierInirefPerjorn;
    }

    public String getDiaMierFinrefPerjorn() {
        return diaMierFinrefPerjorn;
    }

    public void setDiaMierFinrefPerjorn(String diaMierFinrefPerjorn) {
        this.diaMierFinrefPerjorn = diaMierFinrefPerjorn;
    }

    public String getDiaJuevInirefPerjorn() {
        return diaJuevInirefPerjorn;
    }

    public void setDiaJuevInirefPerjorn(String diaJuevInirefPerjorn) {
        this.diaJuevInirefPerjorn = diaJuevInirefPerjorn;
    }

    public String getDiaJuevFinrefPerjorn() {
        return diaJuevFinrefPerjorn;
    }

    public void setDiaJuevFinrefPerjorn(String diaJuevFinrefPerjorn) {
        this.diaJuevFinrefPerjorn = diaJuevFinrefPerjorn;
    }

    public String getDiaVierInirefPerjorn() {
        return diaVierInirefPerjorn;
    }

    public void setDiaVierInirefPerjorn(String diaVierInirefPerjorn) {
        this.diaVierInirefPerjorn = diaVierInirefPerjorn;
    }

    public String getDiaVierFinrefPerjorn() {
        return diaVierFinrefPerjorn;
    }

    public void setDiaVierFinrefPerjorn(String diaVierFinrefPerjorn) {
        this.diaVierFinrefPerjorn = diaVierFinrefPerjorn;
    }

    public String getDiaSabaInirefPerjorn() {
        return diaSabaInirefPerjorn;
    }

    public void setDiaSabaInirefPerjorn(String diaSabaInirefPerjorn) {
        this.diaSabaInirefPerjorn = diaSabaInirefPerjorn;
    }

    public String getDiaSabaFinrefPerjorn() {
        return diaSabaFinrefPerjorn;
    }

    public void setDiaSabaFinrefPerjorn(String diaSabaFinrefPerjorn) {
        this.diaSabaFinrefPerjorn = diaSabaFinrefPerjorn;
    }

    public String getDiaDomiInirefPerjorn() {
        return diaDomiInirefPerjorn;
    }

    public void setDiaDomiInirefPerjorn(String diaDomiInirefPerjorn) {
        this.diaDomiInirefPerjorn = diaDomiInirefPerjorn;
    }

    public String getDiaDomiFinrefPerjorn() {
        return diaDomiFinrefPerjorn;
    }

    public void setDiaDomiFinrefPerjorn(String diaDomiFinrefPerjorn) {
        this.diaDomiFinrefPerjorn = diaDomiFinrefPerjorn;
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
