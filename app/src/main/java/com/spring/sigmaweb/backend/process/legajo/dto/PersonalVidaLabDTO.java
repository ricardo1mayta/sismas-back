package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;

import java.io.Serializable;
import java.util.Date;

public class PersonalVidaLabDTO implements Serializable {
    private Long idPervila;
    private String idObraPervila;
    private Long idPersonalPervila;

    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private String codigoPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicioPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinPervila;
    private String estadoPervila;

    private String creaPorPervila;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngPervila;

    private String modiPorPervila;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiPervila;

    public PersonalVidaLabDTO(Long idPervila, String idObraPervila, Long idPersonalPervila, String apePaternoPers, String apeMaternoPers, String nombrePers, String codigoPer, Date fechaInicioPervila, Date fechaFinPervila, String estadoPervila, String creaPorPervila, Date fechaIngPervila, String modiPorPervila, Date fechaModiPervila) {
        this.idPervila = idPervila;
        this.idObraPervila = idObraPervila;
        this.idPersonalPervila = idPersonalPervila;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.codigoPer = codigoPer;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaFinPervila = fechaFinPervila;
        this.estadoPervila = estadoPervila;
        this.creaPorPervila = creaPorPervila;
        this.fechaIngPervila = fechaIngPervila;
        this.modiPorPervila = modiPorPervila;
        this.fechaModiPervila = fechaModiPervila;
    }

    public PersonalVidaLabDTO() {
        super();
    }

    public Long getIdPervila() {
        return idPervila;
    }

    public void setIdPervila(Long idPervila) {
        this.idPervila = idPervila;
    }

    public String getIdObraPervila() {
        return idObraPervila;
    }

    public void setIdObraPervila(String idObraPervila) {
        this.idObraPervila = idObraPervila;
    }

    public Long getIdPersonalPervila() {
        return idPersonalPervila;
    }

    public void setIdPersonalPervila(Long idPersonalPervila) {
        this.idPersonalPervila = idPersonalPervila;
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

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
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

    public String getCreaPorPervila() {
        return creaPorPervila;
    }

    public void setCreaPorPervila(String creaPorPervila) {
        this.creaPorPervila = creaPorPervila;
    }

    public Date getFechaIngPervila() {
        return fechaIngPervila;
    }

    public void setFechaIngPervila(Date fechaIngPervila) {
        this.fechaIngPervila = fechaIngPervila;
    }

    public String getModiPorPervila() {
        return modiPorPervila;
    }

    public void setModiPorPervila(String modiPorPervila) {
        this.modiPorPervila = modiPorPervila;
    }

    public Date getFechaModiPervila() {
        return fechaModiPervila;
    }

    public void setFechaModiPervila(Date fechaModiPervila) {
        this.fechaModiPervila = fechaModiPervila;
    }

    private static final long serialVersionUID = 1L;
}
