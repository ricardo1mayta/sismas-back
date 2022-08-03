package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "me_evaluacion_indicadores_logro")
public class EvaluacionIndicadoresLogro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evalindlog", nullable = false, unique = true)
    private Long idEvalindlog;

    @Column(nullable = false, name = "id_indicador_evalindlog")
    private Long idIndicadorEvalindlog;

    @Column(nullable = false, name = "id_grupoocupacional_evalindlog")
    private Integer idGrupoocupacionalEvalindlog;

    @Column(nullable = false, name = "id_personal_evalindlog")
    private Long idPersonalEvalindlog;

    @Column(nullable = false, name = "id_evento_evalindlog")
    private Long idEventoEvalindlog;

    @Column(nullable = true, name = "promedio_evalindlog")
    private Double promedioEvalindlog;


    @Column(nullable = false, name = "fechaing_evalindlog")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingEvalindlog;

    @Column(nullable = false, name = "creapor_evalindlog", length = 100)
    private String creaporEvalindlog;

    @Column(nullable = true, name = "fechamodi_evalindlog")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiEvalindlog;

    @Column(nullable = true, name = "modipor_evalindlog", length = 100)
    private String modiporEvalindlog;

    @PrePersist
    public void prePersist() {
        this.fechaingEvalindlog = new Date();
    }

    public Long getIdEvalindlog() {
        return idEvalindlog;
    }

    public void setIdEvalindlog(Long idEvalindlog) {
        this.idEvalindlog = idEvalindlog;
    }

    public Long getIdIndicadorEvalindlog() {
        return idIndicadorEvalindlog;
    }

    public void setIdIndicadorEvalindlog(Long idIndicadorEvalindlog) {
        this.idIndicadorEvalindlog = idIndicadorEvalindlog;
    }

    public Integer getIdGrupoocupacionalEvalindlog() {
        return idGrupoocupacionalEvalindlog;
    }

    public void setIdGrupoocupacionalEvalindlog(Integer idGrupoocupacionalEvalindlog) {
        this.idGrupoocupacionalEvalindlog = idGrupoocupacionalEvalindlog;
    }

    public Long getIdPersonalEvalindlog() {
        return idPersonalEvalindlog;
    }

    public void setIdPersonalEvalindlog(Long idPersonalEvalindlog) {
        this.idPersonalEvalindlog = idPersonalEvalindlog;
    }

    public Long getIdEventoEvalindlog() {
        return idEventoEvalindlog;
    }

    public void setIdEventoEvalindlog(Long idEventoEvalindlog) {
        this.idEventoEvalindlog = idEventoEvalindlog;
    }

    public Double getPromedioEvalindlog() {
        return promedioEvalindlog;
    }

    public void setPromedioEvalindlog(Double promedioEvalindlog) {
        this.promedioEvalindlog = promedioEvalindlog;
    }

    public Date getFechaingEvalindlog() {
        return fechaingEvalindlog;
    }

    public void setFechaingEvalindlog(Date fechaingEvalindlog) {
        this.fechaingEvalindlog = fechaingEvalindlog;
    }

    public String getCreaporEvalindlog() {
        return creaporEvalindlog;
    }

    public void setCreaporEvalindlog(String creaporEvalindlog) {
        this.creaporEvalindlog = creaporEvalindlog;
    }

    public Date getFechamodiEvalindlog() {
        return fechamodiEvalindlog;
    }

    public void setFechamodiEvalindlog(Date fechamodiEvalindlog) {
        this.fechamodiEvalindlog = fechamodiEvalindlog;
    }

    public String getModiporEvalindlog() {
        return modiporEvalindlog;
    }

    public void setModiporEvalindlog(String modiporEvalindlog) {
        this.modiporEvalindlog = modiporEvalindlog;
    }
}
