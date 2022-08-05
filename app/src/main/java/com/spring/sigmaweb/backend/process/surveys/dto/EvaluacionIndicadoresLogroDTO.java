package com.spring.sigmaweb.backend.process.surveys.dto;

import java.io.Serializable;

public class EvaluacionIndicadoresLogroDTO implements Serializable {
    private Long idEvalindlog;
    private String idObraEvalindlog;
    private Long idIndicgoEvalindlog;
    private Long idIndicador;
    private String descripcionIndicador;
    private Integer idGrupoOcupacional;
    private String descripcionGrupoOcupa;

    private Long idPersonalEvalindlog;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;
    private Long idPuestoPerpuest;
    private String nombrePues;
    private Double promedioEvalindlog;
    private String creaporEvalindlog;
    private String modiporEvalindlog;

    public EvaluacionIndicadoresLogroDTO(Long idEvalindlog, String idObraEvalindlog, Long idIndicgoEvalindlog, Long idIndicador, String descripcionIndicador, Integer idGrupoOcupacional, String descripcionGrupoOcupa, Long idPersonalEvalindlog, String apePaternoPers, String apeMaternoPers, String nombrePers, Long idPuestoPerpuest, String nombrePues, Double promedioEvalindlog, String creaporEvalindlog, String modiporEvalindlog) {
        this.idEvalindlog = idEvalindlog;
        this.idObraEvalindlog = idObraEvalindlog;
        this.idIndicgoEvalindlog = idIndicgoEvalindlog;
        this.idIndicador = idIndicador;
        this.descripcionIndicador = descripcionIndicador;
        this.idGrupoOcupacional = idGrupoOcupacional;
        this.descripcionGrupoOcupa = descripcionGrupoOcupa;
        this.idPersonalEvalindlog = idPersonalEvalindlog;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idPuestoPerpuest = idPuestoPerpuest;
        this.nombrePues = nombrePues;
        this.promedioEvalindlog = promedioEvalindlog;
        this.creaporEvalindlog = creaporEvalindlog;
        this.modiporEvalindlog = modiporEvalindlog;
    }

    public Long getIdEvalindlog() {
        return idEvalindlog;
    }

    public void setIdEvalindlog(Long idEvalindlog) {
        this.idEvalindlog = idEvalindlog;
    }

    public String getIdObraEvalindlog() {
        return idObraEvalindlog;
    }

    public void setIdObraEvalindlog(String idObraEvalindlog) {
        this.idObraEvalindlog = idObraEvalindlog;
    }

    public Long getIdIndicgoEvalindlog() {
        return idIndicgoEvalindlog;
    }

    public void setIdIndicgoEvalindlog(Long idIndicgoEvalindlog) {
        this.idIndicgoEvalindlog = idIndicgoEvalindlog;
    }

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public String getDescripcionIndicador() {
        return descripcionIndicador;
    }

    public void setDescripcionIndicador(String descripcionIndicador) {
        this.descripcionIndicador = descripcionIndicador;
    }

    public Integer getIdGrupoOcupacional() {
        return idGrupoOcupacional;
    }

    public void setIdGrupoOcupacional(Integer idGrupoOcupacional) {
        this.idGrupoOcupacional = idGrupoOcupacional;
    }

    public String getDescripcionGrupoOcupa() {
        return descripcionGrupoOcupa;
    }

    public void setDescripcionGrupoOcupa(String descripcionGrupoOcupa) {
        this.descripcionGrupoOcupa = descripcionGrupoOcupa;
    }

    public Long getIdPersonalEvalindlog() {
        return idPersonalEvalindlog;
    }

    public void setIdPersonalEvalindlog(Long idPersonalEvalindlog) {
        this.idPersonalEvalindlog = idPersonalEvalindlog;
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

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
    }

    public Long getIdPuestoPerpuest() {
        return idPuestoPerpuest;
    }

    public void setIdPuestoPerpuest(Long idPuestoPerpuest) {
        this.idPuestoPerpuest = idPuestoPerpuest;
    }

    public String getNombrePues() {
        return nombrePues;
    }

    public void setNombrePues(String nombrePues) {
        this.nombrePues = nombrePues;
    }

    public Double getPromedioEvalindlog() {
        return promedioEvalindlog;
    }

    public void setPromedioEvalindlog(Double promedioEvalindlog) {
        this.promedioEvalindlog = promedioEvalindlog;
    }

    public String getCreaporEvalindlog() {
        return creaporEvalindlog;
    }

    public void setCreaporEvalindlog(String creaporEvalindlog) {
        this.creaporEvalindlog = creaporEvalindlog;
    }

    public String getModiporEvalindlog() {
        return modiporEvalindlog;
    }

    public void setModiporEvalindlog(String modiporEvalindlog) {
        this.modiporEvalindlog = modiporEvalindlog;
    }
}
