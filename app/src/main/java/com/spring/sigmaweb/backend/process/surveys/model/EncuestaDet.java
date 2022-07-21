package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "me_encuesta_det")
public class EncuestaDet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_det_encuesta", nullable = false, unique = true)
    private Long idDetEncuesta;

    @Column(nullable = false, name = "id_encuesta_encdet")
    private Long idEncuestaEncdet;

    @Column(nullable = false, name = "id_pregunta_encdet")
    private Long idPreguntaEncdet;

    @Column(nullable = false, name = "id_competencia_encdet")
    private Long idCompetenciaEncdet;

    @Column(nullable = false, length = 6, name = "id_obra_encdet")
    private Long idObraEncdet;

    @Column(nullable = false, name = "respuesta_encdet")
    private Integer respuestaEncdet;

    @Column(nullable = false, name = "fechaing_encdet")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingEncdet;

    @Column(nullable = false, name = "creapor_encdet", length = 100)
    private String creaporEncdet;

    @PrePersist
    public void prePersist() {
        this.fechaingEncdet = new Date();
    }

    public Long getIdDetEncuesta() {
        return idDetEncuesta;
    }

    public void setIdDetEncuesta(Long idDetEncuesta) {
        this.idDetEncuesta = idDetEncuesta;
    }

    public Long getIdEncuestaEncdet() {
        return idEncuestaEncdet;
    }

    public void setIdEncuestaEncdet(Long idEncuestaEncdet) {
        this.idEncuestaEncdet = idEncuestaEncdet;
    }

    public Long getIdPreguntaEncdet() {
        return idPreguntaEncdet;
    }

    public void setIdPreguntaEncdet(Long idPreguntaEncdet) {
        this.idPreguntaEncdet = idPreguntaEncdet;
    }

    public Long getIdCompetenciaEncdet() {
        return idCompetenciaEncdet;
    }

    public void setIdCompetenciaEncdet(Long idCompetenciaEncdet) {
        this.idCompetenciaEncdet = idCompetenciaEncdet;
    }

    public Long getIdObraEncdet() {
        return idObraEncdet;
    }

    public void setIdObraEncdet(Long idObraEncdet) {
        this.idObraEncdet = idObraEncdet;
    }

    public Integer getRespuestaEncdet() {
        return respuestaEncdet;
    }

    public void setRespuestaEncdet(Integer respuestaEncdet) {
        this.respuestaEncdet = respuestaEncdet;
    }

    public Date getFechaingEncdet() {
        return fechaingEncdet;
    }

    public void setFechaingEncdet(Date fechaingEncdet) {
        this.fechaingEncdet = fechaingEncdet;
    }

    public String getCreaporEncdet() {
        return creaporEncdet;
    }

    public void setCreaporEncdet(String creaporEncdet) {
        this.creaporEncdet = creaporEncdet;
    }
}
