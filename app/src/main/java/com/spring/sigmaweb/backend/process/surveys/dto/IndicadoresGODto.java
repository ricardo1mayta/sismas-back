package com.spring.sigmaweb.backend.process.surveys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class IndicadoresGODto implements Serializable {
    private Long idIndicgo;
    private Long idIndicadorIndicgo;
    private String indicadorIndicgo;
    private Integer idGrupoocupacionalIndicgo;
    private String grupoocupacionalIndicgo;
    private String idObraIndicgo;
    private Long idPuestoIndicgo;
    private String puestoIndicgo;
    private Long idEventoIndicgo;
    private Boolean flgActivoIndicgo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingIndicgo;

    private String creaporIndicgo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiIndicgo;

    private String modiporIndicgo;

    public IndicadoresGODto(Long idIndicgo, Long idIndicadorIndicgo, String indicadorIndicgo, Integer idGrupoocupacionalIndicgo, String grupoocupacionalIndicgo, String idObraIndicgo, Long idPuestoIndicgo, String puestoIndicgo, Long idEventoIndicgo, Boolean flgActivoIndicgo, Date fechaingIndicgo, String creaporIndicgo, Date fechamodiIndicgo, String modiporIndicgo) {
        this.idIndicgo = idIndicgo;
        this.idIndicadorIndicgo = idIndicadorIndicgo;
        this.indicadorIndicgo = indicadorIndicgo;
        this.idGrupoocupacionalIndicgo = idGrupoocupacionalIndicgo;
        this.grupoocupacionalIndicgo = grupoocupacionalIndicgo;
        this.idObraIndicgo = idObraIndicgo;
        this.idPuestoIndicgo = idPuestoIndicgo;
        this.puestoIndicgo = puestoIndicgo;
        this.idEventoIndicgo = idEventoIndicgo;
        this.flgActivoIndicgo = flgActivoIndicgo;
        this.fechaingIndicgo = fechaingIndicgo;
        this.creaporIndicgo = creaporIndicgo;
        this.fechamodiIndicgo = fechamodiIndicgo;
        this.modiporIndicgo = modiporIndicgo;
    }

    public Long getIdIndicgo() {
        return idIndicgo;
    }

    public void setIdIndicgo(Long idIndicgo) {
        this.idIndicgo = idIndicgo;
    }

    public Long getIdIndicadorIndicgo() {
        return idIndicadorIndicgo;
    }

    public void setIdIndicadorIndicgo(Long idIndicadorIndicgo) {
        this.idIndicadorIndicgo = idIndicadorIndicgo;
    }

    public String getIndicadorIndicgo() {
        return indicadorIndicgo;
    }

    public void setIndicadorIndicgo(String indicadorIndicgo) {
        this.indicadorIndicgo = indicadorIndicgo;
    }

    public Integer getIdGrupoocupacionalIndicgo() {
        return idGrupoocupacionalIndicgo;
    }

    public void setIdGrupoocupacionalIndicgo(Integer idGrupoocupacionalIndicgo) {
        this.idGrupoocupacionalIndicgo = idGrupoocupacionalIndicgo;
    }

    public String getGrupoocupacionalIndicgo() {
        return grupoocupacionalIndicgo;
    }

    public void setGrupoocupacionalIndicgo(String grupoocupacionalIndicgo) {
        this.grupoocupacionalIndicgo = grupoocupacionalIndicgo;
    }

    public String getIdObraIndicgo() {
        return idObraIndicgo;
    }

    public void setIdObraIndicgo(String idObraIndicgo) {
        this.idObraIndicgo = idObraIndicgo;
    }

    public Long getIdPuestoIndicgo() {
        return idPuestoIndicgo;
    }

    public void setIdPuestoIndicgo(Long idPuestoIndicgo) {
        this.idPuestoIndicgo = idPuestoIndicgo;
    }

    public String getPuestoIndicgo() {
        return puestoIndicgo;
    }

    public void setPuestoIndicgo(String puestoIndicgo) {
        this.puestoIndicgo = puestoIndicgo;
    }

    public Long getIdEventoIndicgo() {
        return idEventoIndicgo;
    }

    public void setIdEventoIndicgo(Long idEventoIndicgo) {
        this.idEventoIndicgo = idEventoIndicgo;
    }

    public Boolean getFlgActivoIndicgo() {
        return flgActivoIndicgo;
    }

    public void setFlgActivoIndicgo(Boolean flgActivoIndicgo) {
        this.flgActivoIndicgo = flgActivoIndicgo;
    }

    public Date getFechaingIndicgo() {
        return fechaingIndicgo;
    }

    public void setFechaingIndicgo(Date fechaingIndicgo) {
        this.fechaingIndicgo = fechaingIndicgo;
    }

    public String getCreaporIndicgo() {
        return creaporIndicgo;
    }

    public void setCreaporIndicgo(String creaporIndicgo) {
        this.creaporIndicgo = creaporIndicgo;
    }

    public Date getFechamodiIndicgo() {
        return fechamodiIndicgo;
    }

    public void setFechamodiIndicgo(Date fechamodiIndicgo) {
        this.fechamodiIndicgo = fechamodiIndicgo;
    }

    public String getModiporIndicgo() {
        return modiporIndicgo;
    }

    public void setModiporIndicgo(String modiporIndicgo) {
        this.modiporIndicgo = modiporIndicgo;
    }
}
