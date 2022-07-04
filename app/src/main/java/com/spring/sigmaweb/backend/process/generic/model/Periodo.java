package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mg_periodo")
public class Periodo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo", nullable = false, unique = true)
    private Long idPeriodo;

    @Column(nullable = false, name = "anio_peri")
    private Integer anioPeri;

    @Column(nullable = false, length = 6, name = "id_obra_peri")
    private String idObraPeri;

    @Column(nullable = true, length = 200, name = "nombre_peri")
    private String nombrePeri;

    @Column(nullable = false, name = "flg_estado_peri", columnDefinition = "boolean default false")
    private Boolean flgEstadoPeri;

    @Column(nullable = false, name = "fechaing_peri")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPeri;

    @Column(nullable = false, name = "creapor_peri", length = 100)
    private String creaPorPeri;

    @Column(nullable = true, name = "fechamodi_peri")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPeri;

    @Column(nullable = true, name = "modipor_peri", length = 100)
    private String modiPorPeri;

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getAnioPeri() {
        return anioPeri;
    }

    public void setAnioPeri(Integer anioPeri) {
        this.anioPeri = anioPeri;
    }

    public String getIdObraPeri() {
        return idObraPeri;
    }

    public void setIdObraPeri(String idObraPeri) {
        this.idObraPeri = idObraPeri;
    }

    public String getNombrePeri() {
        return nombrePeri;
    }

    public void setNombrePeri(String nombrePeri) {
        this.nombrePeri = nombrePeri;
    }

    public Boolean getFlgEstadoPeri() {
        return flgEstadoPeri;
    }

    public void setFlgEstadoPeri(Boolean flgEstadoPeri) {
        this.flgEstadoPeri = flgEstadoPeri;
    }

    public Date getFechaIngPeri() {
        return fechaIngPeri;
    }

    public void setFechaIngPeri(Date fechaIngPeri) {
        this.fechaIngPeri = fechaIngPeri;
    }

    public String getCreaPorPeri() {
        return creaPorPeri;
    }

    public void setCreaPorPeri(String creaPorPeri) {
        this.creaPorPeri = creaPorPeri;
    }

    public Date getFechaModiPeri() {
        return fechaModiPeri;
    }

    public void setFechaModiPeri(Date fechaModiPeri) {
        this.fechaModiPeri = fechaModiPeri;
    }

    public String getModiPorPeri() {
        return modiPorPeri;
    }

    public void setModiPorPeri(String modiPorPeri) {
        this.modiPorPeri = modiPorPeri;
    }

    private static final long serialVersionUID = 1L;
}
