package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ms_preguntas_competencia")
public class PreguntasCompetencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregcomp", nullable = false, unique = true)
    private Long idPregcomp;

    @Column(nullable = false, name = "id_competencia_pregcomp")
    private Long idCompetenciaPregcomp;

    @Column(nullable = false, name = "id_pregunta_pregcomp")
    private Long idPreguntaPregcomp;

    @Column(nullable = false, name = "id_grupo_pregcomp")
    private Integer idGrupoPregcomp;

    @Column(nullable = false, name = "id_evento_pregcomp")
    private Long idEventoPregcomp;

    @Column(nullable = false, name = "flg_activo_pregcomp", columnDefinition = "boolean default true")
    private Boolean flgActivoPregcomp;

    @Column(nullable = false, name = "fechaing_pregcomp")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingPregcomp;

    @Column(nullable = false, name = "creapor_pregcomp", length = 100)
    private String creaporPregcomp;

    @PrePersist
    public void prePersist() {
        this.fechaingPregcomp = new Date();
    }

    public Long getIdPregcomp() {
        return idPregcomp;
    }

    public void setIdPregcomp(Long idPregcomp) {
        this.idPregcomp = idPregcomp;
    }

    public Long getIdCompetenciaPregcomp() {
        return idCompetenciaPregcomp;
    }

    public void setIdCompetenciaPregcomp(Long idCompetenciaPregcomp) {
        this.idCompetenciaPregcomp = idCompetenciaPregcomp;
    }

    public Long getIdPreguntaPregcomp() {
        return idPreguntaPregcomp;
    }

    public void setIdPreguntaPregcomp(Long idPreguntaPregcomp) {
        this.idPreguntaPregcomp = idPreguntaPregcomp;
    }

    public Integer getIdGrupoPregcomp() {
        return idGrupoPregcomp;
    }

    public void setIdGrupoPregcomp(Integer idGrupoPregcomp) {
        this.idGrupoPregcomp = idGrupoPregcomp;
    }

    public Long getIdEventoPregcomp() {
        return idEventoPregcomp;
    }

    public void setIdEventoPregcomp(Long idEventoPregcomp) {
        this.idEventoPregcomp = idEventoPregcomp;
    }

    public Boolean getFlgActivoPregcomp() {
        return flgActivoPregcomp;
    }

    public void setFlgActivoPregcomp(Boolean flgActivoPregcomp) {
        this.flgActivoPregcomp = flgActivoPregcomp;
    }

    public Date getFechaingPregcomp() {
        return fechaingPregcomp;
    }

    public void setFechaingPregcomp(Date fechaingPregcomp) {
        this.fechaingPregcomp = fechaingPregcomp;
    }

    public String getCreaporPregcomp() {
        return creaporPregcomp;
    }

    public void setCreaporPregcomp(String creaporPregcomp) {
        this.creaporPregcomp = creaporPregcomp;
    }

    private static final long serialVersionUID = 1L;
}
