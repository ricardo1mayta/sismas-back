package com.spring.sigmaweb.backend.process.legajo.reports;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class ReportContract implements Serializable {

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

    private Long idPerCont;
    private Integer idTipoPercont;
    private String tipoPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminoPercont;


    private String estadoPercont;

    private Double jornadaSemanalPercont;
    private Double remuneracionPercont;

    private String observacionesPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIniPruebaPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFinPruebaPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPercont;

    public ReportContract(String idobra, String nombreobra, Long idPersonal, String codigoPer, String estadoPer, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idTipoDocPers, String tipoDocPers, String nroDocPers, String grupoOcupacional, String nivelPlanilla, Long idPerCont, Integer idTipoPercont, String tipoPercont, Date fechaIniPercont, Date fechaFinPercont, Date fechaTerminoPercont, String estadoPercont, Double jornadaSemanalPercont, Double remuneracionPercont, Date fecIniPruebaPercont, Date fecFinPruebaPercont) {
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
        this.nivelPlanilla =  nivelPlanilla;

        this.idPerCont = idPerCont;
        this.idTipoPercont = idTipoPercont;
        this.tipoPercont = tipoPercont;
        this.fechaIniPercont = fechaIniPercont;
        this.fechaFinPercont = fechaFinPercont;
        this.fechaTerminoPercont = fechaTerminoPercont;
        this.estadoPercont = estadoPercont;
        this.jornadaSemanalPercont = jornadaSemanalPercont;
        this.remuneracionPercont = remuneracionPercont;
        this.fecIniPruebaPercont = fecIniPruebaPercont;
        this.fecFinPruebaPercont = fecFinPruebaPercont;
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

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public Long getIdPerCont() {
        return idPerCont;
    }

    public void setIdPerCont(Long idPerCont) {
        this.idPerCont = idPerCont;
    }

    public Integer getIdTipoPercont() {
        return idTipoPercont;
    }

    public void setIdTipoPercont(Integer idTipoPercont) {
        this.idTipoPercont = idTipoPercont;
    }

    public String getTipoPercont() {
        return tipoPercont;
    }

    public void setTipoPercont(String tipoPercont) {
        this.tipoPercont = tipoPercont;
    }

    public Date getFechaIniPercont() {
        return fechaIniPercont;
    }

    public void setFechaIniPercont(Date fechaIniPercont) {
        this.fechaIniPercont = fechaIniPercont;
    }

    public Date getFechaFinPercont() {
        return fechaFinPercont;
    }

    public void setFechaFinPercont(Date fechaFinPercont) {
        this.fechaFinPercont = fechaFinPercont;
    }

    public Date getFechaTerminoPercont() {
        return fechaTerminoPercont;
    }

    public void setFechaTerminoPercont(Date fechaTerminoPercont) {
        this.fechaTerminoPercont = fechaTerminoPercont;
    }

    public String getEstadoPercont() {
        return estadoPercont;
    }

    public void setEstadoPercont(String estadoPercont) {
        this.estadoPercont = estadoPercont;
    }

    public Double getJornadaSemanalPercont() {
        return jornadaSemanalPercont;
    }

    public void setJornadaSemanalPercont(Double jornadaSemanalPercont) {
        this.jornadaSemanalPercont = jornadaSemanalPercont;
    }

    public Double getRemuneracionPercont() {
        return remuneracionPercont;
    }

    public void setRemuneracionPercont(Double remuneracionPercont) {
        this.remuneracionPercont = remuneracionPercont;
    }

    public String getObservacionesPercont() {
        return observacionesPercont;
    }

    public void setObservacionesPercont(String observacionesPercont) {
        this.observacionesPercont = observacionesPercont;
    }

    public Date getFecIniPruebaPercont() {
        return fecIniPruebaPercont;
    }

    public void setFecIniPruebaPercont(Date fecIniPruebaPercont) {
        this.fecIniPruebaPercont = fecIniPruebaPercont;
    }

    public Date getFecFinPruebaPercont() {
        return fecFinPruebaPercont;
    }

    public void setFecFinPruebaPercont(Date fecFinPruebaPercont) {
        this.fecFinPruebaPercont = fecFinPruebaPercont;
    }

    public Date getFechaIngPercont() {
        return fechaIngPercont;
    }

    public void setFechaIngPercont(Date fechaIngPercont) {
        this.fechaIngPercont = fechaIngPercont;
    }

    public String getTipoDocPers() {
        return tipoDocPers;
    }

    public void setTipoDocPers(String tipoDocPers) {
        this.tipoDocPers = tipoDocPers;
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
}
