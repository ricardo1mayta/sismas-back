package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mg_eventosperiodo")
public class EventosPeriodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento", nullable = false, unique = true)
    private Long idEvento;

    @Column(nullable = false, name = "id_periodo_event")
    private Long idPeriodoEvent;

    @Column(nullable = false, length = 6, name = "id_obra_event")
    private String idObraEvent;

    @Column(nullable = false, name = "tipo_event")
    private Integer tipoEvent;

    @Column(nullable = false, length = 150, name = "nombre_event")
    private String nombreEvent;

    @Column(nullable = true, length = 500, name = "descripcion_event")
    private String descripcionEvent;

    @Column(nullable = false, length = 1, name = "flg_estado_event")
    private String flgEstadoEvent;

    @Column(nullable = true, name = "fecha_ini_event")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniEvent;

    @Column(nullable = true, name = "fecha_fin_event")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinEvent;

    @Column(nullable = false, name = "fechaing_event")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingEvent;

    @Column(nullable = false, name = "creapor_event", length = 100)
    private String creaporEvent;

    @Column(nullable = true, name = "fechamodi_event")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiEvent;

    @Column(nullable = true, name = "modipor_event", length = 100)
    private String modiporEvent;

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

    public String getIdObraEvent() {
        return idObraEvent;
    }

    public void setIdObraEvent(String idObraEvent) {
        this.idObraEvent = idObraEvent;
    }

    public Integer getTipoEvent() {
        return tipoEvent;
    }

    public void setTipoEvent(Integer tipoEvent) {
        this.tipoEvent = tipoEvent;
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

    private static final long serialVersionUID = 1L;
}
