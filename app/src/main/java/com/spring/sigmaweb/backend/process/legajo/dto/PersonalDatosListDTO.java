package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalDatosListDTO implements Serializable {
    private Long idPersonal;
    private String idobra;
    private Long idPerSigma;
    private String nombrePers;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nomCompleto;
    private String fotoPer;
    private String codigoPer;
    private String nroDocPers;
    private String emailcorp;
    private String emailpers;
    private Byte sexoPers;
    private Boolean estadoPer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaAutorizaPer;

    public PersonalDatosListDTO(Long idPersonal, String idobra, Long idPerSigma, String nombrePers, String apePaternoPers, String apeMaternoPers, String nomCompleto, String fotoPer, String codigoPer, String nroDocPers, String emailcorp, String emailpers, Byte sexoPers, Boolean estadoPer, Date fechaAutorizaPer) {
        this.idPersonal = idPersonal;
        this.idobra = idobra;
        this.idPerSigma = idPerSigma;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nomCompleto = nomCompleto;
        this.fotoPer = fotoPer;
        this.codigoPer = codigoPer;
        this.nroDocPers = nroDocPers;
        this.emailcorp = emailcorp;
        this.emailpers = emailpers;
        this.sexoPers = sexoPers;
        this.estadoPer = estadoPer;
        this.fechaAutorizaPer = fechaAutorizaPer;
    }

    public PersonalDatosListDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    public Long getIdPerSigma() {
        return idPerSigma;
    }

    public void setIdPerSigma(Long idPerSigma) {
        this.idPerSigma = idPerSigma;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
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

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public String getFotoPer() {
        return fotoPer;
    }

    public void setFotoPer(String fotoPer) {
        this.fotoPer = fotoPer;
    }

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public String getEmailcorp() {
        return emailcorp;
    }

    public void setEmailcorp(String emailcorp) {
        this.emailcorp = emailcorp;
    }

    public String getEmailpers() {
        return emailpers;
    }

    public void setEmailpers(String emailpers) {
        this.emailpers = emailpers;
    }

    public Byte getSexoPers() {
        return sexoPers;
    }

    public void setSexoPers(Byte sexoPers) {
        this.sexoPers = sexoPers;
    }

    public Boolean getEstadoPer() {
        return estadoPer;
    }

    public void setEstadoPer(Boolean estadoPer) {
        this.estadoPer = estadoPer;
    }

    public Date getFechaAutorizaPer() {
        return fechaAutorizaPer;
    }

    public void setFechaAutorizaPer(Date fechaAutorizaPer) {
        this.fechaAutorizaPer = fechaAutorizaPer;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
