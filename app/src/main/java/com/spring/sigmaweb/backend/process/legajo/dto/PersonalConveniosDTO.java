package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PersonalConveniosDTO implements Serializable {
    private Long idPerConv;
    private String idObraPerconv;
    private Long idPersonal;
    private Long idPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicioPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinPervila;

    private String estadoPervila;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;
    private Integer idTipoPerconv;
    private String tipoConvenio;
    private String observacionesPerconv;
    private String estadoPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaIniPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaTerminoPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngPerconv;

    private String creaPorPerconv;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiPerconv;

    private String modiPorPerconv;

    public PersonalConveniosDTO(Long idPerConv, String idObraPerconv, Long idPersonal, Long idPervila, Date fechaInicioPervila, Date fechaFinPervila, String estadoPervila, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idTipoPerconv, String tipoConvenio, String observacionesPerconv, String estadoPerconv, Date fechaIniPerconv, Date fechaFinPerconv, Date fechaTerminoPerconv, Date fechaIngPerconv, String creaPorPerconv, Date fechaModiPerconv, String modiPorPerconv) {
        this.idPerConv = idPerConv;
        this.idObraPerconv = idObraPerconv;
        this.idPersonal = idPersonal;
        this.idPervila = idPervila;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaFinPervila = fechaFinPervila;
        this.estadoPervila = estadoPervila;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idTipoPerconv = idTipoPerconv;
        this.tipoConvenio = tipoConvenio;
        this.observacionesPerconv = observacionesPerconv;
        this.estadoPerconv = estadoPerconv;
        this.fechaIniPerconv = fechaIniPerconv;
        this.fechaFinPerconv = fechaFinPerconv;
        this.fechaTerminoPerconv = fechaTerminoPerconv;
        this.fechaIngPerconv = fechaIngPerconv;
        this.creaPorPerconv = creaPorPerconv;
        this.fechaModiPerconv = fechaModiPerconv;
        this.modiPorPerconv = modiPorPerconv;
    }

    public PersonalConveniosDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPerConv() {
        return idPerConv;
    }

    public void setIdPerConv(Long idPerConv) {
        this.idPerConv = idPerConv;
    }

    public String getIdObraPerconv() {
        return idObraPerconv;
    }

    public void setIdObraPerconv(String idObraPerconv) {
        this.idObraPerconv = idObraPerconv;
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

    public Integer getIdTipoPerconv() {
        return idTipoPerconv;
    }

    public void setIdTipoPerconv(Integer idTipoPerconv) {
        this.idTipoPerconv = idTipoPerconv;
    }

    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
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

    public Date getFechaModiPerconv() {
        return fechaModiPerconv;
    }

    public void setFechaModiPerconv(Date fechaModiPerconv) {
        this.fechaModiPerconv = fechaModiPerconv;
    }

    public String getModiPorPerconv() {
        return modiPorPerconv;
    }

    public void setModiPorPerconv(String modiPorPerconv) {
        this.modiPorPerconv = modiPorPerconv;
    }

    public Long getIdPervila() {
        return idPervila;
    }

    public void setIdPervila(Long idPervila) {
        this.idPervila = idPervila;
    }

    public Date getFechaInicioPervila() {
        return fechaInicioPervila;
    }

    public void setFechaInicioPervila(Date fechaInicioPervila) {
        this.fechaInicioPervila = fechaInicioPervila;
    }

    public Date getFechaFinPervila() {
        return fechaFinPervila;
    }

    public void setFechaFinPervila(Date fechaFinPervila) {
        this.fechaFinPervila = fechaFinPervila;
    }

    public String getEstadoPervila() {
        return estadoPervila;
    }

    public void setEstadoPervila(String estadoPervila) {
        this.estadoPervila = estadoPervila;
    }

    private static final long serialVersionUID = 1L;
}
