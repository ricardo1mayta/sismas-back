package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "me_cierre_evaluacion_desemp")
public class CierreEvaluacionDesemp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cierre_evaldes",nullable = false, unique = true)
    private Long idCierreEvaldes;

    @Column(name = "id_evento_cierreeval", nullable = false)
    private Long idEventoCierreeval;

    @Column(nullable = false, length = 6, name = "id_obra_cierreeval")
    private String idObraCierreeval;

    @Column(nullable = true, name = "fecha_cierreeval")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierreeval;

    @Column(nullable = false, name = "fechaing_cierreeval")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingCierreeval;

    @Column(nullable = false, name = "creapor_cierreeval", length = 100)
    private String creaporCierreeval;

    @Column(nullable = true, name = "fechamodi_cierreeval")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiCierreeval;

    @Column(nullable = false, length = 6, name = "hora_cierreeval")
    private String horaCierreeval;

    @Column(nullable = true, name = "modipor_cierreeval", length = 100)
    private String modiporCierreeval;

    @PrePersist
    public void prePersist() {
        this.fechaingCierreeval = new Date();

    }

    public Long getIdCierreEvaldes() {
        return idCierreEvaldes;
    }

    public void setIdCierreEvaldes(Long idCierreEvaldes) {
        this.idCierreEvaldes = idCierreEvaldes;
    }

    public Long getIdEventoCierreeval() {
        return idEventoCierreeval;
    }

    public void setIdEventoCierreeval(Long idEventoCierreeval) {
        this.idEventoCierreeval = idEventoCierreeval;
    }

    public String getIdObraCierreeval() {
        return idObraCierreeval;
    }

    public void setIdObraCierreeval(String idObraCierreeval) {
        this.idObraCierreeval = idObraCierreeval;
    }

    public Date getFechaCierreeval() {
        return fechaCierreeval;
    }

    public void setFechaCierreeval(Date fechaCierreeval) {
        this.fechaCierreeval = fechaCierreeval;
    }

    public Date getFechaingCierreeval() {
        return fechaingCierreeval;
    }

    public void setFechaingCierreeval(Date fechaingCierreeval) {
        this.fechaingCierreeval = fechaingCierreeval;
    }

    public String getCreaporCierreeval() {
        return creaporCierreeval;
    }

    public void setCreaporCierreeval(String creaporCierreeval) {
        this.creaporCierreeval = creaporCierreeval;
    }

    public Date getFechamodiCierreeval() {
        return fechamodiCierreeval;
    }

    public void setFechamodiCierreeval(Date fechamodiCierreeval) {
        this.fechamodiCierreeval = fechamodiCierreeval;
    }

    public String getModiporCierreeval() {
        return modiporCierreeval;
    }

    public void setModiporCierreeval(String modiporCierreeval) {
        this.modiporCierreeval = modiporCierreeval;
    }

    public String getHoraCierreeval() {
        return horaCierreeval;
    }

    public void setHoraCierreeval(String horaCierreeval) {
        this.horaCierreeval = horaCierreeval;
    }

    private static final long serialVersionUID = 1L;
}
