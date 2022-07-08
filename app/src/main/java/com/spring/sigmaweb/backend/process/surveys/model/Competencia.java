package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ms_competencia")
public class Competencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competencia", nullable = false, unique = true)
    private Long idCompetencia;

    @Column(nullable = false, length = 100, name = "descripcion_compe")
    private String descripcionCompe;

    @Column(nullable = false, name = "id_evento_compe")
    private Long idEventoCompe;

    @Column(nullable = false, name = "flg_activo_compe", columnDefinition = "boolean default false")
    private Boolean flgActivoCompe;

    @Column(nullable = false, name = "fechaing_compe")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingCompe;

    @Column(nullable = false, name = "creapor_compe", length = 100)
    private String creaporCompe;

    @Column(nullable = true, name = "fechamodi_compe")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiComp;

    @Column(nullable = true, name = "modipor_compe", length = 100)
    private String modiporCompe;

    @PrePersist
    public void prePersist() {
        this.fechaingCompe = new Date();
    }

    public Long getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Long idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getDescripcionCompe() {
        return descripcionCompe;
    }

    public void setDescripcionCompe(String descripcionCompe) {
        this.descripcionCompe = descripcionCompe;
    }

    public Long getIdEventoCompe() {
        return idEventoCompe;
    }

    public void setIdEventoCompe(Long idEventoCompe) {
        this.idEventoCompe = idEventoCompe;
    }

    public Boolean getFlgActivoCompe() {
        return flgActivoCompe;
    }

    public void setFlgActivoCompe(Boolean flgActivoCompe) {
        this.flgActivoCompe = flgActivoCompe;
    }

    public Date getFechaingCompe() {
        return fechaingCompe;
    }

    public void setFechaingCompe(Date fechaingCompe) {
        this.fechaingCompe = fechaingCompe;
    }

    public String getCreaporCompe() {
        return creaporCompe;
    }

    public void setCreaporCompe(String creaporCompe) {
        this.creaporCompe = creaporCompe;
    }

    public Date getFechamodiComp() {
        return fechamodiComp;
    }

    public void setFechamodiComp(Date fechamodiComp) {
        this.fechamodiComp = fechamodiComp;
    }

    public String getModiporCompe() {
        return modiporCompe;
    }

    public void setModiporCompe(String modiporCompe) {
        this.modiporCompe = modiporCompe;
    }

    private static final long serialVersionUID = 1L;
}
