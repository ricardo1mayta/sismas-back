package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalDTO implements Serializable {
    private Long idPersonal;
    private String codigoPer;
    private String idobra;
    private String nombrePers;
    private String apePaternoPers;
    private String apeMaternoPers;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacPers;

    private Integer idTipoDocPer;
    private String nroDocPers;
    private String emailPers;
    private String celularPers;
    private Byte sexoPers;
    public PersonalDTO(){

    }
    public PersonalDTO(Long idPersonal, String codigoPer, String idobra, String nombrePers, String apePaternoPers, String apeMaternoPers,
                       Date fechaNacPers, Integer idTipoDocPer, String nroDocPers, String emailPers, String celularPers, Byte sexoPers) {
        this.idPersonal = idPersonal;
        this.codigoPer = codigoPer;
        this.idobra = idobra;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.fechaNacPers = fechaNacPers;
        this.idTipoDocPer = idTipoDocPer;
        this.nroDocPers = nroDocPers;
        this.emailPers = emailPers;
        this.celularPers = celularPers;
        this.sexoPers = sexoPers;
    }
    public PersonalDTO(Long idPersonal, String codigoPer, String nombrePers, String apePaternoPers, String apeMaternoPers,
                       Date fechaNacPers, Integer idTipoDocPer, String nroDocPers, String emailPers, String celularPers, Byte sexoPers) {
        this.idPersonal = idPersonal;
        this.codigoPer = codigoPer;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.fechaNacPers = fechaNacPers;
        this.idTipoDocPer = idTipoDocPer;
        this.nroDocPers = nroDocPers;
        this.emailPers = emailPers;
        this.celularPers = celularPers;
        this.sexoPers = sexoPers;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
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

    public Date getFechaNacPers() {
        return fechaNacPers;
    }

    public void setFechaNacPers(Date fechaNacPers) {
        this.fechaNacPers = fechaNacPers;
    }

    public Integer getIdTipoDocPer() {
        return idTipoDocPer;
    }

    public void setIdTipoDocPer(Integer idTipoDocPer) {
        this.idTipoDocPer = idTipoDocPer;
    }

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public String getEmailPers() {
        return emailPers;
    }

    public void setEmailPers(String emailPers) {
        this.emailPers = emailPers;
    }

    public String getCelularPers() {
        return celularPers;
    }

    public void setCelularPers(String celularPers) {
        this.celularPers = celularPers;
    }

    public Byte getSexoPers() {
        return sexoPers;
    }

    public void setSexoPers(Byte sexoPers) {
        this.sexoPers = sexoPers;
    }

    private static final long serialVersionUID = 1L;
}
