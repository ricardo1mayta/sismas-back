package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class PersonalContratoObraDTO implements Serializable {
    private Long idPerCont;
    private String idObraPercont;
    private Long idPersonal;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;
    private Integer idTipoPercont;
    private String tipoContrato;
    private String urlDocumentoPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPercont;

    private String observacionesPercont;
    private String estadoPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminoPercont;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPercont;

    private String creaPorPercont;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPercont;

    private String modiPorPercont;

    public PersonalContratoObraDTO(Long idPerCont, String idObraPercont, Long idPersonal, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idTipoPercont, String tipoContrato, String urlDocumentoPercont, Date fechaIniPercont, Date fechaFinPercont, String observacionesPercont, String estadoPercont, Date fechaTerminoPercont, Date fechaIngPercont, String creaPorPercont, Date fechaModiPercont, String modiPorPercont) {
        this.idPerCont = idPerCont;
        this.idObraPercont = idObraPercont;
        this.idPersonal = idPersonal;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idTipoPercont = idTipoPercont;
        this.tipoContrato = tipoContrato;
        this.urlDocumentoPercont = urlDocumentoPercont;
        this.fechaIniPercont = fechaIniPercont;
        this.fechaFinPercont = fechaFinPercont;
        this.observacionesPercont = observacionesPercont;
        this.estadoPercont = estadoPercont;
        this.fechaTerminoPercont = fechaTerminoPercont;
        this.fechaIngPercont = fechaIngPercont;
        this.creaPorPercont = creaPorPercont;
        this.fechaModiPercont = fechaModiPercont;
        this.modiPorPercont = modiPorPercont;
    }

    public PersonalContratoObraDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPerCont() {
        return idPerCont;
    }

    public void setIdPerCont(Long idPerCont) {
        this.idPerCont = idPerCont;
    }

    public String getIdObraPercont() {
        return idObraPercont;
    }

    public void setIdObraPercont(String idObraPercont) {
        this.idObraPercont = idObraPercont;
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

    public Integer getIdTipoPercont() {
        return idTipoPercont;
    }

    public void setIdTipoPercont(Integer idTipoPercont) {
        this.idTipoPercont = idTipoPercont;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getUrlDocumentoPercont() {
        return urlDocumentoPercont;
    }

    public void setUrlDocumentoPercont(String urlDocumentoPercont) {
        this.urlDocumentoPercont = urlDocumentoPercont;
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

    public String getObservacionesPercont() {
        return observacionesPercont;
    }

    public void setObservacionesPercont(String observacionesPercont) {
        this.observacionesPercont = observacionesPercont;
    }

    public Date getFechaIngPercont() {
        return fechaIngPercont;
    }

    public void setFechaIngPercont(Date fechaIngPercont) {
        this.fechaIngPercont = fechaIngPercont;
    }

    public String getCreaPorPercont() {
        return creaPorPercont;
    }

    public void setCreaPorPercont(String creaPorPercont) {
        this.creaPorPercont = creaPorPercont;
    }

    public Date getFechaModiPercont() {
        return fechaModiPercont;
    }

    public void setFechaModiPercont(Date fechaModiPercont) {
        this.fechaModiPercont = fechaModiPercont;
    }

    public String getModiPorPercont() {
        return modiPorPercont;
    }

    public void setModiPorPercont(String modiPorPercont) {
        this.modiPorPercont = modiPorPercont;
    }

    public String getEstadoPercont() {
        return estadoPercont;
    }

    public void setEstadoPercont(String estadoPercont) {
        this.estadoPercont = estadoPercont;
    }

    public Date getFechaTerminoPercont() {
        return fechaTerminoPercont;
    }

    public void setFechaTerminoPercont(Date fechaTerminoPercont) {
        this.fechaTerminoPercont = fechaTerminoPercont;
    }

    private static final long serialVersionUID = 1L;
}
