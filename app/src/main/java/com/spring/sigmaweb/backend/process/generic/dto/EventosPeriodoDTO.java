package com.spring.sigmaweb.backend.process.generic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class EventosPeriodoDTO implements Serializable {
    private Long idEvento;
    private Long idPeriodoEvent;
    private Integer anioPeri;
    private String idObraEvent;
    private String nombreobra;
    private Integer tipoEvent;
    private String desctipoEvent;
    private String nombreEvent;
    private String descripcionEvent;
    private String flgEstadoEvent;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniEvent;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinEvent;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingEvent;

    private String creaporEvent;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiEvent;
    private String modiporEvent;

    public EventosPeriodoDTO() {
        super();
    }

    public EventosPeriodoDTO(Long idEvento, Long idPeriodoEvent, Integer anioPeri, String idObraEvent, String nombreobra, Integer tipoEvent, String desctipoEvent, String nombreEvent, String descripcionEvent, String flgEstadoEvent, Date fechaIniEvent, Date fechaFinEvent, Date fechaingEvent, String creaporEvent) {
        this.idEvento = idEvento;
        this.idPeriodoEvent = idPeriodoEvent;
        this.anioPeri = anioPeri;
        this.idObraEvent = idObraEvent;
        this.nombreobra = nombreobra;
        this.tipoEvent = tipoEvent;
        this.desctipoEvent = desctipoEvent;
        this.nombreEvent = nombreEvent;
        this.descripcionEvent = descripcionEvent;
        this.flgEstadoEvent = flgEstadoEvent;
        this.fechaIniEvent = fechaIniEvent;
        this.fechaFinEvent = fechaFinEvent;
        this.fechaingEvent = fechaingEvent;
        this.creaporEvent = creaporEvent;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdPeriodoEvent() {
        return idPeriodoEvent;
    }

    public void setIdPeriodoEvent(Long idPeriodoEvent) {
        this.idPeriodoEvent = idPeriodoEvent;
    }

    public Integer getAnioPeri() {
        return anioPeri;
    }

    public void setAnioPeri(Integer anioPeri) {
        this.anioPeri = anioPeri;
    }

    public String getIdObraEvent() {
        return idObraEvent;
    }

    public void setIdObraEvent(String idObraEvent) {
        this.idObraEvent = idObraEvent;
    }

    public String getNombreobra() {
        return nombreobra;
    }

    public void setNombreobra(String nombreobra) {
        this.nombreobra = nombreobra;
    }

    public Integer getTipoEvent() {
        return tipoEvent;
    }

    public void setTipoEvent(Integer tipoEvent) {
        this.tipoEvent = tipoEvent;
    }

    public String getDesctipoEvent() {
        return desctipoEvent;
    }

    public void setDesctipoEvent(String desctipoEvent) {
        this.desctipoEvent = desctipoEvent;
    }

    public String getNombreEvent() {
        return nombreEvent;
    }

    public void setNombreEvent(String nombreEvent) {
        this.nombreEvent = nombreEvent;
    }

    public String getDescripcionEvent() {
        return descripcionEvent;
    }

    public void setDescripcionEvent(String descripcionEvent) {
        this.descripcionEvent = descripcionEvent;
    }

    public String getFlgEstadoEvent() {
        return flgEstadoEvent;
    }

    public void setFlgEstadoEvent(String flgEstadoEvent) {
        this.flgEstadoEvent = flgEstadoEvent;
    }

    public Date getFechaIniEvent() {
        return fechaIniEvent;
    }

    public void setFechaIniEvent(Date fechaIniEvent) {
        this.fechaIniEvent = fechaIniEvent;
    }

    public Date getFechaFinEvent() {
        return fechaFinEvent;
    }

    public void setFechaFinEvent(Date fechaFinEvent) {
        this.fechaFinEvent = fechaFinEvent;
    }

    public Date getFechaingEvent() {
        return fechaingEvent;
    }

    public void setFechaingEvent(Date fechaingEvent) {
        this.fechaingEvent = fechaingEvent;
    }

    public String getCreaporEvent() {
        return creaporEvent;
    }

    public void setCreaporEvent(String creaporEvent) {
        this.creaporEvent = creaporEvent;
    }

    public Date getFechamodiEvent() {
        return fechamodiEvent;
    }

    public void setFechamodiEvent(Date fechamodiEvent) {
        this.fechamodiEvent = fechamodiEvent;
    }

    public String getModiporEvent() {
        return modiporEvent;
    }

    public void setModiporEvent(String modiporEvent) {
        this.modiporEvent = modiporEvent;
    }
}
