package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PersonalDatosBancariosDTO implements Serializable {
    private Long idpersonal;
    private String idobra;
    private String nombrePers;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String codigoPer;
    private Integer idTipoDocPer;
    private String descDocuPer;
    private String nroDocPers;

    private Long idEntidadHaberesPer;
    private String entidadHaberesPer;
    private Long idEntidadCtsPer;
    private String entidadCtsPer;
    private Integer idTipoMonedaCtsPer;
    private String tipoMonedaCtsPer;

    private String nroCtabacHaberesPer;
    private String nroCtaintbacHaberesPer;

    private String nroCtabacCtsPer;
    private String nroCtaintbacCtsPer;

    private String flgRequiereAperturaCtaCtsPer;
    private String flgRequiereAperturaCtaHaberesPer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaSolAperturaCtaCtsPer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaSolAperturaCtaHaberesPer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaResAperturaCtaCtsPer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaResAperturaCtaHaberesPer;

    private Boolean flgPermitirCambioCtsPer;
    private Boolean flgPermitirCambioHaberesPer;

    public PersonalDatosBancariosDTO(Long idpersonal, String idobra, String nombrePers, String apePaternoPers, String apeMaternoPers, String codigoPer, Integer idTipoDocPer, String descDocuPer, String nroDocPers, Long idEntidadHaberesPer, String entidadHaberesPer, Long idEntidadCtsPer, String entidadCtsPer, Integer idTipoMonedaCtsPer, String tipoMonedaCtsPer, String nroCtabacHaberesPer, String nroCtaintbacHaberesPer, String nroCtabacCtsPer, String nroCtaintbacCtsPer, String flgRequiereAperturaCtaCtsPer, String flgRequiereAperturaCtaHaberesPer, Date fechaSolAperturaCtaCtsPer, Date fechaSolAperturaCtaHaberesPer,
                                     Date fechaResAperturaCtaCtsPer, Date fechaResAperturaCtaHaberesPer, Boolean flgPermitirCambioCtsPer, Boolean flgPermitirCambioHaberesPer) {
        this.idpersonal = idpersonal;
        this.idobra = idobra;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.codigoPer = codigoPer;
        this.idTipoDocPer = idTipoDocPer;
        this.descDocuPer = descDocuPer;
        this.nroDocPers = nroDocPers;
        this.idEntidadHaberesPer = idEntidadHaberesPer;
        this.entidadHaberesPer = entidadHaberesPer;
        this.idEntidadCtsPer = idEntidadCtsPer;
        this.entidadCtsPer = entidadCtsPer;
        this.idTipoMonedaCtsPer = idTipoMonedaCtsPer;
        this.tipoMonedaCtsPer = tipoMonedaCtsPer;
        this.nroCtabacHaberesPer = nroCtabacHaberesPer;
        this.nroCtaintbacHaberesPer = nroCtaintbacHaberesPer;
        this.nroCtabacCtsPer = nroCtabacCtsPer;
        this.nroCtaintbacCtsPer = nroCtaintbacCtsPer;
        this.flgRequiereAperturaCtaCtsPer = flgRequiereAperturaCtaCtsPer;
        this.flgRequiereAperturaCtaHaberesPer = flgRequiereAperturaCtaHaberesPer;
        this.fechaSolAperturaCtaCtsPer = fechaSolAperturaCtaCtsPer;
        this.fechaSolAperturaCtaHaberesPer = fechaSolAperturaCtaHaberesPer;
        this.fechaResAperturaCtaCtsPer = fechaResAperturaCtaCtsPer;
        this.fechaResAperturaCtaHaberesPer = fechaResAperturaCtaHaberesPer;
        this.flgPermitirCambioCtsPer = flgPermitirCambioCtsPer;
        this.flgPermitirCambioHaberesPer = flgPermitirCambioHaberesPer;
    }

    public PersonalDatosBancariosDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Long idpersonal) {
        this.idpersonal = idpersonal;
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

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public Integer getIdTipoDocPer() {
        return idTipoDocPer;
    }

    public void setIdTipoDocPer(Integer idTipoDocPer) {
        this.idTipoDocPer = idTipoDocPer;
    }

    public String getDescDocuPer() {
        return descDocuPer;
    }

    public void setDescDocuPer(String descDocuPer) {
        this.descDocuPer = descDocuPer;
    }

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public Long getIdEntidadHaberesPer() {
        return idEntidadHaberesPer;
    }

    public void setIdEntidadHaberesPer(Long idEntidadHaberesPer) {
        this.idEntidadHaberesPer = idEntidadHaberesPer;
    }

    public String getEntidadHaberesPer() {
        return entidadHaberesPer;
    }

    public void setEntidadHaberesPer(String entidadHaberesPer) {
        this.entidadHaberesPer = entidadHaberesPer;
    }

    public Long getIdEntidadCtsPer() {
        return idEntidadCtsPer;
    }

    public void setIdEntidadCtsPer(Long idEntidadCtsPer) {
        this.idEntidadCtsPer = idEntidadCtsPer;
    }

    public String getEntidadCtsPer() {
        return entidadCtsPer;
    }

    public void setEntidadCtsPer(String entidadCtsPer) {
        this.entidadCtsPer = entidadCtsPer;
    }

    public Integer getIdTipoMonedaCtsPer() {
        return idTipoMonedaCtsPer;
    }

    public void setIdTipoMonedaCtsPer(Integer idTipoMonedaCtsPer) {
        this.idTipoMonedaCtsPer = idTipoMonedaCtsPer;
    }

    public String getTipoMonedaCtsPer() {
        return tipoMonedaCtsPer;
    }

    public void setTipoMonedaCtsPer(String tipoMonedaCtsPer) {
        this.tipoMonedaCtsPer = tipoMonedaCtsPer;
    }

    public String getNroCtabacHaberesPer() {
        return nroCtabacHaberesPer;
    }

    public void setNroCtabacHaberesPer(String nroCtabacHaberesPer) {
        this.nroCtabacHaberesPer = nroCtabacHaberesPer;
    }

    public String getNroCtaintbacHaberesPer() {
        return nroCtaintbacHaberesPer;
    }

    public void setNroCtaintbacHaberesPer(String nroCtaintbacHaberesPer) {
        this.nroCtaintbacHaberesPer = nroCtaintbacHaberesPer;
    }

    public String getNroCtabacCtsPer() {
        return nroCtabacCtsPer;
    }

    public void setNroCtabacCtsPer(String nroCtabacCtsPer) {
        this.nroCtabacCtsPer = nroCtabacCtsPer;
    }

    public String getNroCtaintbacCtsPer() {
        return nroCtaintbacCtsPer;
    }

    public void setNroCtaintbacCtsPer(String nroCtaintbacCtsPer) {
        this.nroCtaintbacCtsPer = nroCtaintbacCtsPer;
    }

    public String getFlgRequiereAperturaCtaCtsPer() {
        return flgRequiereAperturaCtaCtsPer;
    }

    public void setFlgRequiereAperturaCtaCtsPer(String flgRequiereAperturaCtaCtsPer) {
        this.flgRequiereAperturaCtaCtsPer = flgRequiereAperturaCtaCtsPer;
    }

    public String getFlgRequiereAperturaCtaHaberesPer() {
        return flgRequiereAperturaCtaHaberesPer;
    }

    public void setFlgRequiereAperturaCtaHaberesPer(String flgRequiereAperturaCtaHaberesPer) {
        this.flgRequiereAperturaCtaHaberesPer = flgRequiereAperturaCtaHaberesPer;
    }

    public Date getFechaSolAperturaCtaCtsPer() {
        return fechaSolAperturaCtaCtsPer;
    }

    public void setFechaSolAperturaCtaCtsPer(Date fechaSolAperturaCtaCtsPer) {
        this.fechaSolAperturaCtaCtsPer = fechaSolAperturaCtaCtsPer;
    }

    public Date getFechaSolAperturaCtaHaberesPer() {
        return fechaSolAperturaCtaHaberesPer;
    }

    public void setFechaSolAperturaCtaHaberesPer(Date fechaSolAperturaCtaHaberesPer) {
        this.fechaSolAperturaCtaHaberesPer = fechaSolAperturaCtaHaberesPer;
    }

    public Date getFechaResAperturaCtaCtsPer() {
        return fechaResAperturaCtaCtsPer;
    }

    public void setFechaResAperturaCtaCtsPer(Date fechaResAperturaCtaCtsPer) {
        this.fechaResAperturaCtaCtsPer = fechaResAperturaCtaCtsPer;
    }

    public Date getFechaResAperturaCtaHaberesPer() {
        return fechaResAperturaCtaHaberesPer;
    }

    public void setFechaResAperturaCtaHaberesPer(Date fechaResAperturaCtaHaberesPer) {
        this.fechaResAperturaCtaHaberesPer = fechaResAperturaCtaHaberesPer;
    }

    public Boolean getFlgPermitirCambioCtsPer() {
        return flgPermitirCambioCtsPer;
    }

    public void setFlgPermitirCambioCtsPer(Boolean flgPermitirCambioCtsPer) {
        this.flgPermitirCambioCtsPer = flgPermitirCambioCtsPer;
    }

    public Boolean getFlgPermitirCambioHaberesPer() {
        return flgPermitirCambioHaberesPer;
    }

    public void setFlgPermitirCambioHaberesPer(Boolean flgPermitirCambioHaberesPer) {
        this.flgPermitirCambioHaberesPer = flgPermitirCambioHaberesPer;
    }

    private static final long serialVersionUID = 1L;
}
