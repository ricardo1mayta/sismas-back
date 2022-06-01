package com.spring.sigmaweb.backend.process.legajo.reports;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class ReportAgreement implements Serializable {
    private String idobra;
    private String nombreobra;

    private Long idPersonal;
    private String codigoPer;
    private String estadoPer;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private Integer idTipoDocPers;
    private String tipoDocPers;
    private String nroDocPers;

    private String grupoOcupacional;
    private String nivelPlanilla;

    private Long idPervila;

    private Long idPerConv;
    private Integer idTipoPerconv;
    private String tipoPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminoPerconv;

    private String observacionesPerconv;
    private String estadoPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerconv;

    private String creaPorPerconv;

    public ReportAgreement(String idobra, String nombreobra, Long idPersonal, String codigoPer, String estadoPer, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idTipoDocPers, String tipoDocPers, String nroDocPers, String grupoOcupacional, String nivelPlanilla, Long idPervila, Long idPerConv, Integer idTipoPerconv, String tipoPerconv, Date fechaIniPerconv, Date fechaFinPerconv, Date fechaTerminoPerconv, String observacionesPerconv, String estadoPerconv, Date fechaIngPerconv, String creaPorPerconv) {
        this.idobra = idobra;
        this.nombreobra = nombreobra;
        this.idPersonal = idPersonal;
        this.codigoPer = codigoPer;
        this.estadoPer = estadoPer;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;

        this.idTipoDocPers = idTipoDocPers;
        this.tipoDocPers = tipoDocPers;
        this.nroDocPers = nroDocPers;
        this.grupoOcupacional = grupoOcupacional;
        this.nivelPlanilla = nivelPlanilla;

        this.idPervila = idPervila;
        this.idPerConv = idPerConv;
        this.idTipoPerconv = idTipoPerconv;
        this.tipoPerconv = tipoPerconv;

        this.fechaIniPerconv = fechaIniPerconv;
        this.fechaFinPerconv = fechaFinPerconv;
        this.fechaTerminoPerconv = fechaTerminoPerconv;
        this.observacionesPerconv = observacionesPerconv;

        this.estadoPerconv = estadoPerconv;
        this.fechaIngPerconv = fechaIngPerconv;
        this.creaPorPerconv = creaPorPerconv;
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

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public String getEstadoPer() {
        return estadoPer;
    }

    public void setEstadoPer(String estadoPer) {
        this.estadoPer = estadoPer;
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

    public Integer getIdTipoDocPers() {
        return idTipoDocPers;
    }

    public void setIdTipoDocPers(Integer idTipoDocPers) {
        this.idTipoDocPers = idTipoDocPers;
    }

    public String getTipoDocPers() {
        return tipoDocPers;
    }

    public void setTipoDocPers(String tipoDocPers) {
        this.tipoDocPers = tipoDocPers;
    }

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public String getGrupoOcupacional() {
        return grupoOcupacional;
    }

    public void setGrupoOcupacional(String grupoOcupacional) {
        this.grupoOcupacional = grupoOcupacional;
    }

    public String getNivelPlanilla() {
        return nivelPlanilla;
    }

    public void setNivelPlanilla(String nivelPlanilla) {
        this.nivelPlanilla = nivelPlanilla;
    }

    public Long getIdPervila() {
        return idPervila;
    }

    public void setIdPervila(Long idPervila) {
        this.idPervila = idPervila;
    }

    public Long getIdPerConv() {
        return idPerConv;
    }

    public void setIdPerConv(Long idPerConv) {
        this.idPerConv = idPerConv;
    }

    public Integer getIdTipoPerconv() {
        return idTipoPerconv;
    }

    public void setIdTipoPerconv(Integer idTipoPerconv) {
        this.idTipoPerconv = idTipoPerconv;
    }

    public String getTipoPerconv() {
        return tipoPerconv;
    }

    public void setTipoPerconv(String tipoPerconv) {
        this.tipoPerconv = tipoPerconv;
    }

    public Date getFechaIniPerconv() {
        return fechaIniPerconv;
    }

    public void setFechaIniPerconv(Date fechaIniPerconv) {
        this.fechaIniPerconv = fechaIniPerconv;
    }

    public Date getFechaFinPerconv() {
        return fechaFinPerconv;
    }

    public void setFechaFinPerconv(Date fechaFinPerconv) {
        this.fechaFinPerconv = fechaFinPerconv;
    }

    public Date getFechaTerminoPerconv() {
        return fechaTerminoPerconv;
    }

    public void setFechaTerminoPerconv(Date fechaTerminoPerconv) {
        this.fechaTerminoPerconv = fechaTerminoPerconv;
    }

    public String getObservacionesPerconv() {
        return observacionesPerconv;
    }

    public void setObservacionesPerconv(String observacionesPerconv) {
        this.observacionesPerconv = observacionesPerconv;
    }

    public String getEstadoPerconv() {
        return estadoPerconv;
    }

    public void setEstadoPerconv(String estadoPerconv) {
        this.estadoPerconv = estadoPerconv;
    }

    public Date getFechaIngPerconv() {
        return fechaIngPerconv;
    }

    public void setFechaIngPerconv(Date fechaIngPerconv) {
        this.fechaIngPerconv = fechaIngPerconv;
    }

    public String getCreaPorPerconv() {
        return creaPorPerconv;
    }

    public void setCreaPorPerconv(String creaPorPerconv) {
        this.creaPorPerconv = creaPorPerconv;
    }
}
