package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;

import java.util.Date;

public class JornadaPersonalContratoDTO implements Serializable {
    private Long idPerCont;
    private Long idPerjorn;
    private String idObraPerjorn;
    private Long idPersonal;

    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private Integer idDiaPerJorn;
    private String diaInihorPerjorn;
    private String diaFinhorPerjorn;
    private String tipoDiaPerjorn;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerjorn;

    private String creaPorPerjorn;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerjorn;

    private String modiPorPerjorn;

    public JornadaPersonalContratoDTO(Long idPerCont, Long idPerjorn, String idObraPerjorn, Long idPersonal, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idDiaPerJorn, String diaInihorPerjorn, String diaFinhorPerjorn, String tipoDiaPerjorn, Date fechaIngPerjorn, String creaPorPerjorn, Date fechaModiPerjorn, String modiPorPerjorn) {
        this.idPerCont = idPerCont;
        this.idPerjorn = idPerjorn;
        this.idObraPerjorn = idObraPerjorn;
        this.idPersonal = idPersonal;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idDiaPerJorn = idDiaPerJorn;
        this.diaInihorPerjorn = diaInihorPerjorn;
        this.diaFinhorPerjorn = diaFinhorPerjorn;
        this.tipoDiaPerjorn = tipoDiaPerjorn;
        this.fechaIngPerjorn = fechaIngPerjorn;
        this.creaPorPerjorn = creaPorPerjorn;
        this.fechaModiPerjorn = fechaModiPerjorn;
        this.modiPorPerjorn = modiPorPerjorn;
    }

    public JornadaPersonalContratoDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPerCont() {
        return idPerCont;
    }

    public void setIdPerCont(Long idPerCont) {
        this.idPerCont = idPerCont;
    }

    public Long getIdPerjorn() {
        return idPerjorn;
    }

    public void setIdPerjorn(Long idPerjorn) {
        this.idPerjorn = idPerjorn;
    }

    public String getIdObraPerjorn() {
        return idObraPerjorn;
    }

    public void setIdObraPerjorn(String idObraPerjorn) {
        this.idObraPerjorn = idObraPerjorn;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getApePaternoPers() {
        return apePaternoPers;
    }

    public void setApePaternoPers(String apePaternoPers) {
        this.apePaternoPers = apePaternoPers;
    }

    public String getApeMaternoPers() {
        return apeMaternoPers;
    }

    public void setApeMaternoPers(String apeMaternoPers) {
        this.apeMaternoPers = apeMaternoPers;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
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

    private static final long serialVersionUID = 1L;
}
