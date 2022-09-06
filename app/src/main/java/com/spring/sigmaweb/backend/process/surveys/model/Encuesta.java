package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "me_encuesta")
public class Encuesta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encuesta", nullable = false, unique = true)
    private Long idEncuesta;

    @Column(nullable = false, name = "id_matrizeval_encuesta")
    private Long idMatrizevalEncuesta;

    @Column(nullable = false, length = 6,name = "id_obra_encuesta")
    private String idObraEncuesta;

    @Column(nullable = false, name = "total_preguntas_encuesta")
    private Integer totalPreguntasEncuesta;

    @Column(nullable = false, name = "flg_activo_encuesta", columnDefinition = "boolean default true")
    private Boolean flg_activoEncuesta;

    @Column(nullable = false, name = "flg_estado_encuesta", length = 1)
    private String flgEstadoEncuesta;

    @Column(nullable = true, name = "fecha_inicio_encuesta")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioEncuesta;

    @Column(nullable = true, name = "fecha_fin_encuesta")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinEncuesta;

    @Column(nullable = false, name = "fechaing_encuesta")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingEncuesta;

    @Column(nullable = false, name = "creapor_encuesta", length = 100)
    private String creaporEncuesta;

    @Column(nullable = true, name = "fechamodi_encuesta")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiEncuesta;

    @Column(nullable = true, name = "modipor_encuesta", length = 100)
    private String modiporEncuesta;

    @PrePersist
    public void prePersist() {
        this.fechaingEncuesta = new Date();
    }

    public Long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Long getIdMatrizevalEncuesta() {
        return idMatrizevalEncuesta;
    }

    public void setIdMatrizevalEncuesta(Long idMatrizevalEncuesta) {
        this.idMatrizevalEncuesta = idMatrizevalEncuesta;
    }

    public String getIdObraEncuesta() {
        return idObraEncuesta;
    }

    public void setIdObraEncuesta(String idObraEncuesta) {
        this.idObraEncuesta = idObraEncuesta;
    }

    public Integer getTotalPreguntasEncuesta() {
        return totalPreguntasEncuesta;
    }

    public void setTotalPreguntasEncuesta(Integer totalPreguntasEncuesta) {
        this.totalPreguntasEncuesta = totalPreguntasEncuesta;
    }

    public Boolean getFlg_activoEncuesta() {
        return flg_activoEncuesta;
    }

    public void setFlg_activoEncuesta(Boolean flg_activoEncuesta) {
        this.flg_activoEncuesta = flg_activoEncuesta;
    }

    public String getFlgEstadoEncuesta() {
        return flgEstadoEncuesta;
    }

    public void setFlgEstadoEncuesta(String flgEstadoEncuesta) {
        this.flgEstadoEncuesta = flgEstadoEncuesta;
    }

    public Date getFechaInicioEncuesta() {
        return fechaInicioEncuesta;
    }

    public void setFechaInicioEncuesta(Date fechaInicioEncuesta) {
        this.fechaInicioEncuesta = fechaInicioEncuesta;
    }

    public Date getFechaFinEncuesta() {
        return fechaFinEncuesta;
    }

    public void setFechaFinEncuesta(Date fechaFinEncuesta) {
        this.fechaFinEncuesta = fechaFinEncuesta;
    }

    public Date getFechaingEncuesta() {
        return fechaingEncuesta;
    }

    public void setFechaingEncuesta(Date fechaingEncuesta) {
        this.fechaingEncuesta = fechaingEncuesta;
    }

    public String getCreaporEncuesta() {
        return creaporEncuesta;
    }

    public void setCreaporEncuesta(String creaporEncuesta) {
        this.creaporEncuesta = creaporEncuesta;
    }

    public Date getFechamodiEncuesta() {
        return fechamodiEncuesta;
    }

    public void setFechamodiEncuesta(Date fechamodiEncuesta) {
        this.fechamodiEncuesta = fechamodiEncuesta;
    }

    public String getModiporEncuesta() {
        return modiporEncuesta;
    }

    public void setModiporEncuesta(String modiporEncuesta) {
        this.modiporEncuesta = modiporEncuesta;
    }

    private static final long serialVersionUID = 1L;
}
