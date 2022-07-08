package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ms_pregunta")
public class Pregunta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta", nullable = false, unique = true)
    private Long idPregunta;

    @Column(nullable = false, length = 500, name = "descripcion_preg")
    private String descripcionPreg;

    @Column(nullable = false, name = "id_evento_preg")
    private Long idEventoPreg;

    @Column(nullable = false, name = "flg_activo_preg", columnDefinition = "boolean default true")
    private Boolean flgActivoPreg;

    @Column(nullable = false, name = "fechaing_preg")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingPreg;

    @Column(nullable = false, name = "creapor_preg", length = 100)
    private String creaporPreg;

    @Column(nullable = true, name = "fechamodi_preg")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiPreg;

    @Column(nullable = true, name = "modipor_preg", length = 100)
    private String modiporPreg;

    @PrePersist
    public void prePersist() {
        this.fechaingPreg = new Date();
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcionPreg() {
        return descripcionPreg;
    }

    public void setDescripcionPreg(String descripcionPreg) {
        this.descripcionPreg = descripcionPreg;
    }

    public Long getIdEventoPreg() {
        return idEventoPreg;
    }

    public void setIdEventoPreg(Long idEventoPreg) {
        this.idEventoPreg = idEventoPreg;
    }

    public Boolean getFlgActivoPreg() {
        return flgActivoPreg;
    }

    public void setFlgActivoPreg(Boolean flgActivoPreg) {
        this.flgActivoPreg = flgActivoPreg;
    }

    public Date getFechaingPreg() {
        return fechaingPreg;
    }

    public void setFechaingPreg(Date fechaingPreg) {
        this.fechaingPreg = fechaingPreg;
    }

    public String getCreaporPreg() {
        return creaporPreg;
    }

    public void setCreaporPreg(String creaporPreg) {
        this.creaporPreg = creaporPreg;
    }

    public Date getFechamodiPreg() {
        return fechamodiPreg;
    }

    public void setFechamodiPreg(Date fechamodiPreg) {
        this.fechamodiPreg = fechamodiPreg;
    }

    public String getModiporPreg() {
        return modiporPreg;
    }

    public void setModiporPreg(String modiporPreg) {
        this.modiporPreg = modiporPreg;
    }

    private static final long serialVersionUID = 1L;
}
