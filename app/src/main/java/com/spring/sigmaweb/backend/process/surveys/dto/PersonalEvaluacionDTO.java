package com.spring.sigmaweb.backend.process.surveys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class PersonalEvaluacionDTO implements Serializable {
    private Long idPereval;
    private Long idEventoPereval;
    private String nombreEvent;
    private String idObraPereval;

    private Long idPersonal;
    private String nombrePers;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nomCompleto;
    private Long idCargoPuestoPereval;
    private String nombreCargoPuestoPereval;
    private Long idPeriodoPereval;
    private Integer anioPeri;
    private String codigoperPereval;

    private Boolean flgEsCargoprincipalPereval;
    private Boolean flgPrincipalEvalPereval;
    private Integer idGrupoOcupacionalPereval;
    private String nombreGrupoOcupacionalPereval;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingPereval;

    private String creaporPereval;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiPereval;
    private String modiporPereval;

    public PersonalEvaluacionDTO(Long idPereval, Long idEventoPereval, String nombreEvent, String idObraPereval, Long idPersonal, String nombrePers, String apePaternoPers, String apeMaternoPers, String nomCompleto, Long idCargoPuestoPereval, String nombreCargoPuestoPereval, Long idPeriodoPereval, Integer anioPeri, String codigoperPereval, Boolean flgEsCargoprincipalPereval,Boolean flgPrincipalEvalPereval, Integer idGrupoOcupacionalPereval, String nombreGrupoOcupacionalPereval, Date fechaingPereval, String creaporPereval, Date fechamodiPereval, String modiporPereval) {
        this.idPereval = idPereval;
        this.idEventoPereval = idEventoPereval;
        this.nombreEvent = nombreEvent;
        this.idObraPereval = idObraPereval;
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nomCompleto = nomCompleto;
        this.idCargoPuestoPereval = idCargoPuestoPereval;
        this.nombreCargoPuestoPereval = nombreCargoPuestoPereval;
        this.idPeriodoPereval = idPeriodoPereval;
        this.anioPeri = anioPeri;
        this.codigoperPereval = codigoperPereval;
        this.flgEsCargoprincipalPereval = flgEsCargoprincipalPereval;
        this.flgPrincipalEvalPereval = flgPrincipalEvalPereval;
        this.idGrupoOcupacionalPereval = idGrupoOcupacionalPereval;
        this.nombreGrupoOcupacionalPereval = nombreGrupoOcupacionalPereval;
        this.fechaingPereval = fechaingPereval;
        this.creaporPereval = creaporPereval;
        this.fechamodiPereval = fechamodiPereval;
        this.modiporPereval = modiporPereval;
    }

    public PersonalEvaluacionDTO(Long idEventoPereval, String nombreEvent, String idObraPereval, Long idPersonal, String nombrePers, String apePaternoPers, String apeMaternoPers, String nomCompleto, Long idPeriodoPereval, Integer anioPeri, String codigoperPereval, Integer idGrupoOcupacionalPereval, String nombreGrupoOcupacionalPereval) {
        this.idEventoPereval = idEventoPereval;
        this.nombreEvent = nombreEvent;
        this.idObraPereval = idObraPereval;
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nomCompleto = nomCompleto;
        this.idPeriodoPereval = idPeriodoPereval;
        this.anioPeri = anioPeri;
        this.codigoperPereval = codigoperPereval;
        this.idGrupoOcupacionalPereval = idGrupoOcupacionalPereval;
        this.nombreGrupoOcupacionalPereval = nombreGrupoOcupacionalPereval;
    }

    public PersonalEvaluacionDTO(Long idPereval, Long idEventoPereval, String nombreEvent, String idObraPereval, Long idPersonal, String nombrePers, String apePaternoPers, String apeMaternoPers, String nomCompleto, Long idCargoPuestoPereval, String nombreCargoPuestoPereval, Boolean flgEsCargoprincipalPereval, Boolean flgPrincipalEvalPereval) {
        this.idPereval = idPereval;
        this.idEventoPereval = idEventoPereval;
        this.nombreEvent = nombreEvent;
        this.idObraPereval = idObraPereval;
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nomCompleto = nomCompleto;
        this.idCargoPuestoPereval = idCargoPuestoPereval;
        this.nombreCargoPuestoPereval = nombreCargoPuestoPereval;
        this.flgEsCargoprincipalPereval = flgEsCargoprincipalPereval;
        this.flgPrincipalEvalPereval = flgPrincipalEvalPereval;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public Long getIdPereval() {
        return idPereval;
    }

    public void setIdPereval(Long idPereval) {
        this.idPereval = idPereval;
    }

    public Long getIdEventoPereval() {
        return idEventoPereval;
    }

    public void setIdEventoPereval(Long idEventoPereval) {
        this.idEventoPereval = idEventoPereval;
    }

    public String getNombreEvent() {
        return nombreEvent;
    }

    public void setNombreEvent(String nombreEvent) {
        this.nombreEvent = nombreEvent;
    }

    public String getIdObraPereval() {
        return idObraPereval;
    }

    public void setIdObraPereval(String idObraPereval) {
        this.idObraPereval = idObraPereval;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
    }

    public String getApePaternoPers() {
        return apePaternoPers;
    }

    public void setApePaternoPers(String apePaternoPers) {
        this.apePaternoPers = apePaternoPers;
    }

    public String getApeMaternoPers() {
        return apeMaternoPers;
    }

    public void setApeMaternoPers(String apeMaternoPers) {
        this.apeMaternoPers = apeMaternoPers;
    }

    public Long getIdCargoPuestoPereval() {
        return idCargoPuestoPereval;
    }

    public void setIdCargoPuestoPereval(Long idCargoPuestoPereval) {
        this.idCargoPuestoPereval = idCargoPuestoPereval;
    }

    public String getNombreCargoPuestoPereval() {
        return nombreCargoPuestoPereval;
    }

    public void setNombreCargoPuestoPereval(String nombreCargoPuestoPereval) {
        this.nombreCargoPuestoPereval = nombreCargoPuestoPereval;
    }

    public Long getIdPeriodoPereval() {
        return idPeriodoPereval;
    }

    public void setIdPeriodoPereval(Long idPeriodoPereval) {
        this.idPeriodoPereval = idPeriodoPereval;
    }

    public Integer getAnioPeri() {
        return anioPeri;
    }

    public void setAnioPeri(Integer anioPeri) {
        this.anioPeri = anioPeri;
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

    public String getNombreGrupoOcupacionalPereval() {
        return nombreGrupoOcupacionalPereval;
    }

    public void setNombreGrupoOcupacionalPereval(String nombreGrupoOcupacionalPereval) {
        this.nombreGrupoOcupacionalPereval = nombreGrupoOcupacionalPereval;
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

    public Boolean getFlgPrincipalEvalPereval() {
        return flgPrincipalEvalPereval;
    }

    public void setFlgPrincipalEvalPereval(Boolean flgPrincipalEvalPereval) {
        this.flgPrincipalEvalPereval = flgPrincipalEvalPereval;
    }
}
