package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalHistoricoDTO implements Serializable {
    private Long idPersonalHist;
    private String idobra;
    private String nombreobra;
    private Long idPersonal;
    private Long idPerSigma;
    private String codigoPer;
    private String apePaternoPer;
    private String apeMaternoPer;
    private String nombrePer;
    private String descDocPer;
    private String nroDocPer;

    private String tipoHist;
    private String direccionHist;
    private Integer tipoEstCivilHist;
    private String descEstCivilHist;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaCambECHist;

    private String creaPorHist;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngHist;



    public PersonalHistoricoDTO(Long idPersonalHist, String idobra, String nombreobra, Long idPersonal, Long idPerSigma,
                                String codigoPer, String apePaternoPer, String apeMaternoPer, String nombrePer, String descDocPer,
                                String nroDocPer, String tipoHist, String direccionHist, Integer tipoEstCivilHist, String descEstCivilHist,
                                Date fechaCambECHist, String creaPorHist, Date fechaIngHist) {
        super();
        this.idPersonalHist = idPersonalHist;
        this.idobra = idobra;
        this.nombreobra = nombreobra;
        this.idPersonal = idPersonal;
        this.idPerSigma = idPerSigma;
        this.codigoPer = codigoPer;
        this.apePaternoPer = apePaternoPer;
        this.apeMaternoPer = apeMaternoPer;
        this.nombrePer = nombrePer;
        this.descDocPer = descDocPer;
        this.nroDocPer = nroDocPer;
        this.tipoHist = tipoHist;
        this.direccionHist = direccionHist;
        this.tipoEstCivilHist = tipoEstCivilHist;
        this.descEstCivilHist = descEstCivilHist;
        this.fechaCambECHist = fechaCambECHist;
        this.creaPorHist = creaPorHist;
        this.fechaIngHist = fechaIngHist;
    }

    public Long getIdPersonalHist() {
        return idPersonalHist;
    }

    public void setIdPersonalHist(Long idPersonalHist) {
        this.idPersonalHist = idPersonalHist;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    public String getNombreobra() {
        return nombreobra;
    }

    public void setNombreobra(String nombreobra) {
        this.nombreobra = nombreobra;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Long getIdPerSigma() {
        return idPerSigma;
    }

    public void setIdPerSigma(Long idPerSigma) {
        this.idPerSigma = idPerSigma;
    }

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public String getApePaternoPer() {
        return apePaternoPer;
    }

    public void setApePaternoPer(String apePaternoPer) {
        this.apePaternoPer = apePaternoPer;
    }

    public String getApeMaternoPer() {
        return apeMaternoPer;
    }

    public void setApeMaternoPer(String apeMaternoPer) {
        this.apeMaternoPer = apeMaternoPer;
    }

    public String getNombrePer() {
        return nombrePer;
    }

    public void setNombrePer(String nombrePer) {
        this.nombrePer = nombrePer;
    }

    public String getDescDocPer() {
        return descDocPer;
    }

    public void setDescDocPer(String descDocPer) {
        this.descDocPer = descDocPer;
    }

    public String getNroDocPer() {
        return nroDocPer;
    }

    public void setNroDocPer(String nroDocPer) {
        this.nroDocPer = nroDocPer;
    }

    public String getTipoHist() {
        return tipoHist;
    }

    public void setTipoHist(String tipoHist) {
        this.tipoHist = tipoHist;
    }

    public String getDireccionHist() {
        return direccionHist;
    }

    public void setDireccionHist(String direccionHist) {
        this.direccionHist = direccionHist;
    }

    public Integer getTipoEstCivilHist() {
        return tipoEstCivilHist;
    }

    public void setTipoEstCivilHist(Integer tipoEstCivilHist) {
        this.tipoEstCivilHist = tipoEstCivilHist;
    }

    public String getDescEstCivilHist() {
        return descEstCivilHist;
    }

    public void setDescEstCivilHist(String descEstCivilHist) {
        this.descEstCivilHist = descEstCivilHist;
    }

    public Date getFechaCambECHist() {
        return fechaCambECHist;
    }

    public void setFechaCambECHist(Date fechaCambECHist) {
        this.fechaCambECHist = fechaCambECHist;
    }

    public String getCreaPorHist() {
        return creaPorHist;
    }

    public void setCreaPorHist(String creaPorHist) {
        this.creaPorHist = creaPorHist;
    }

    public Date getFechaIngHist() {
        return fechaIngHist;
    }

    public void setFechaIngHist(Date fechaIngHist) {
        this.fechaIngHist = fechaIngHist;
    }

    private static final long serialVersionUID = 1L;
}
