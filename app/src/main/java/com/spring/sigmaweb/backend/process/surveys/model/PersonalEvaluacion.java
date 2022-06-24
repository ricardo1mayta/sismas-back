package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_personal_eval")
public class PersonalEvaluacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pereval", nullable = false, unique = true)
    private Long idPereval;

    @Column(nullable = false, length = 6, name = "id_obra_pereval")
    private String idObraPereval;

    @Column(nullable = false, name = "id_personal_pereval")
    private Long idPersonalPereval;

    @Column(nullable = false, name = "id_evento_pereval")
    private Long idEventoPereval;

    @Column(nullable = false, name = "id_cargopuesto_pereval")
    private Long idCargoPuestoPereval;

    @Column(nullable = false, name = "id_periodo_pereval")
    private Long idPeriodoPereval;

    @Column(nullable = false, length = 20, name = "codigo_per_pereval")
    private String codigoperPereval;

    @Column(nullable = false, name = "flg_es_cargoprincipal_pereval", columnDefinition = "boolean default false")
    private Boolean flgEsCargoprincipalPereval;

    @Column(nullable = false, name = "id_grupo_ocupacional_pereval")
    private Integer idGrupoOcupacionalPereval;

    @Column(nullable = false, name = "fechaing_pereval")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingPereval;

    @Column(nullable = false, name = "creapor_pereval", length = 100)
    private String creaporPereval;

    @Column(nullable = true, name = "fechamodi_pereval")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiPereval;

    @Column(nullable = true, name = "modipor_pereval", length = 100)
    private String modiporPereval;

    public Long getIdPereval() {
        return idPereval;
    }

    public void setIdPereval(Long idPereval) {
        this.idPereval = idPereval;
    }

    public String getIdObraPereval() {
        return idObraPereval;
    }

    public void setIdObraPereval(String idObraPereval) {
        this.idObraPereval = idObraPereval;
    }

    public Long getIdPersonalPereval() {
        return idPersonalPereval;
    }

    public void setIdPersonalPereval(Long idPersonalPereval) {
        this.idPersonalPereval = idPersonalPereval;
    }

    public Long getIdEventoPereval() {
        return idEventoPereval;
    }

    public void setIdEventoPereval(Long idEventoPereval) {
        this.idEventoPereval = idEventoPereval;
    }

    public Long getIdCargoPuestoPereval() {
        return idCargoPuestoPereval;
    }

    public void setIdCargoPuestoPereval(Long idCargoPuestoPereval) {
        this.idCargoPuestoPereval = idCargoPuestoPereval;
    }

    public Long getIdPeriodoPereval() {
        return idPeriodoPereval;
    }

    public void setIdPeriodoPereval(Long idPeriodoPereval) {
        this.idPeriodoPereval = idPeriodoPereval;
    }

    public String getCodigoperPereval() {
        return codigoperPereval;
    }

    public void setCodigoperPereval(String codigoperPereval) {
        this.codigoperPereval = codigoperPereval;
    }

    public Boolean getFlgEsCargoprincipalPereval() {
        return flgEsCargoprincipalPereval;
    }

    public void setFlgEsCargoprincipalPereval(Boolean flgEsCargoprincipalPereval) {
        this.flgEsCargoprincipalPereval = flgEsCargoprincipalPereval;
    }

    public Integer getIdGrupoOcupacionalPereval() {
        return idGrupoOcupacionalPereval;
    }

    public void setIdGrupoOcupacionalPereval(Integer idGrupoOcupacionalPereval) {
        this.idGrupoOcupacionalPereval = idGrupoOcupacionalPereval;
    }

    public Date getFechaingPereval() {
        return fechaingPereval;
    }

    public void setFechaingPereval(Date fechaingPereval) {
        this.fechaingPereval = fechaingPereval;
    }

    public String getCreaporPereval() {
        return creaporPereval;
    }

    public void setCreaporPereval(String creaporPereval) {
        this.creaporPereval = creaporPereval;
    }

    public Date getFechamodiPereval() {
        return fechamodiPereval;
    }

    public void setFechamodiPereval(Date fechamodiPereval) {
        this.fechamodiPereval = fechamodiPereval;
    }

    public String getModiporPereval() {
        return modiporPereval;
    }

    public void setModiporPereval(String modiporPereval) {
        this.modiporPereval = modiporPereval;
    }

    private static final long serialVersionUID = 1L;
}
