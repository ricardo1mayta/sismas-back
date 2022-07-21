package com.spring.sigmaweb.backend.process.surveys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class PreguntasCompetenciaDTO implements Serializable {

    private Long idPregcomp;
    private Long idCompetenciaPregcomp;
    private String descripcionCompetencia;
    private Long idPreguntaPregcomp;
    private String descripcionPregunta;
    private Integer idGrupoPregcomp;
    private String descripcionGrupo;
    private Long idEventoPregcomp;
    private String descripcionEvento;
    private Long idPeriodoEvento;
    private Integer anioPeriodoEvento;
    private String descripcionPregcomp;
    private Integer ordenCompetenciaPregcomp;
    private Integer ordenPreguntaPregcomp;
    private Boolean flgActivoPregcomp;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingPregcomp;

    private String creaporPregcomp;

    public PreguntasCompetenciaDTO(Long idPregcomp, Long idCompetenciaPregcomp, String descripcionCompetencia, Long idPreguntaPregcomp, String descripcionPregunta, Integer idGrupoPregcomp, String descripcionGrupo, Long idEventoPregcomp, String descripcionEvento, Long idPeriodoEvento, Integer anioPeriodoEvento, String descripcionPregcomp, Integer ordenCompetenciaPregcomp, Integer ordenPreguntaPregcomp, Boolean flgActivoPregcomp, Date fechaingPregcomp, String creaporPregcomp) {
        this.idPregcomp = idPregcomp;
        this.idCompetenciaPregcomp = idCompetenciaPregcomp;
        this.descripcionCompetencia = descripcionCompetencia;
        this.idPreguntaPregcomp = idPreguntaPregcomp;
        this.descripcionPregunta = descripcionPregunta;
        this.idGrupoPregcomp = idGrupoPregcomp;
        this.descripcionGrupo = descripcionGrupo;
        this.idEventoPregcomp = idEventoPregcomp;
        this.descripcionEvento = descripcionEvento;
        this.idPeriodoEvento = idPeriodoEvento;
        this.anioPeriodoEvento = anioPeriodoEvento;
        this.descripcionPregcomp = descripcionPregcomp;
        this.ordenCompetenciaPregcomp = ordenCompetenciaPregcomp;
        this.ordenPreguntaPregcomp = ordenPreguntaPregcomp;
        this.flgActivoPregcomp = flgActivoPregcomp;
        this.fechaingPregcomp = fechaingPregcomp;
        this.creaporPregcomp = creaporPregcomp;
    }

    public PreguntasCompetenciaDTO(Long idCompetenciaPregcomp, String descripcionCompetencia, Integer idGrupoPregcomp, String descripcionGrupo, Long idEventoPregcomp, String descripcionEvento, Long idPeriodoEvento, Integer anioPeriodoEvento) {
        this.idCompetenciaPregcomp = idCompetenciaPregcomp;
        this.descripcionCompetencia = descripcionCompetencia;
        this.idGrupoPregcomp = idGrupoPregcomp;
        this.descripcionGrupo = descripcionGrupo;
        this.idEventoPregcomp = idEventoPregcomp;
        this.descripcionEvento = descripcionEvento;
        this.idPeriodoEvento = idPeriodoEvento;
        this.anioPeriodoEvento = anioPeriodoEvento;
    }

    public PreguntasCompetenciaDTO() {
        super();
        // TODO Auto-generated constructor stub
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

    public String getDescripcionCompetencia() {
        return descripcionCompetencia;
    }

    public void setDescripcionCompetencia(String descripcionCompetencia) {
        this.descripcionCompetencia = descripcionCompetencia;
    }

    public Long getIdPreguntaPregcomp() {
        return idPreguntaPregcomp;
    }

    public void setIdPreguntaPregcomp(Long idPreguntaPregcomp) {
        this.idPreguntaPregcomp = idPreguntaPregcomp;
    }

    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public Integer getIdGrupoPregcomp() {
        return idGrupoPregcomp;
    }

    public void setIdGrupoPregcomp(Integer idGrupoPregcomp) {
        this.idGrupoPregcomp = idGrupoPregcomp;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }

    public Long getIdEventoPregcomp() {
        return idEventoPregcomp;
    }

    public void setIdEventoPregcomp(Long idEventoPregcomp) {
        this.idEventoPregcomp = idEventoPregcomp;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Long getIdPeriodoEvento() {
        return idPeriodoEvento;
    }

    public void setIdPeriodoEvento(Long idPeriodoEvento) {
        this.idPeriodoEvento = idPeriodoEvento;
    }

    public Integer getAnioPeriodoEvento() {
        return anioPeriodoEvento;
    }

    public void setAnioPeriodoEvento(Integer anioPeriodoEvento) {
        this.anioPeriodoEvento = anioPeriodoEvento;
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

    public String getDescripcionPregcomp() {
        return descripcionPregcomp;
    }

    public void setDescripcionPregcomp(String descripcionPregcomp) {
        this.descripcionPregcomp = descripcionPregcomp;
    }

    public Integer getOrdenCompetenciaPregcomp() {
        return ordenCompetenciaPregcomp;
    }

    public void setOrdenCompetenciaPregcomp(Integer ordenCompetenciaPregcomp) {
        this.ordenCompetenciaPregcomp = ordenCompetenciaPregcomp;
    }

    public Integer getOrdenPreguntaPregcomp() {
        return ordenPreguntaPregcomp;
    }

    public void setOrdenPreguntaPregcomp(Integer ordenPreguntaPregcomp) {
        this.ordenPreguntaPregcomp = ordenPreguntaPregcomp;
    }
}
