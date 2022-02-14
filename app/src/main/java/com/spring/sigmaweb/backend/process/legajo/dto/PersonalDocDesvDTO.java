package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PersonalDocDesvDTO implements Serializable {
    private Long idPerentr;
    private Long idPerdesvPerentr;
    private String idObraPerentr;
    private Long idTipoDocDesvPerentr;

    private String descripcionDocdesv;
    private String tipoDocdesv;
    private String descripcionGrupoDocdesv;
    private Boolean flgInsertarMontoDocdesv;
    private Boolean flgAdjuntarFileDocdesv;


    private Boolean flgEntregoPerentr;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaEjecucionPerentr;

    private String idResponsablePerentr;

    public PersonalDocDesvDTO(Long idPerentr, Long idPerdesvPerentr, String idObraPerentr, Long idTipoDocDesvPerentr, String descripcionDocdesv, String tipoDocdesv, String descripcionGrupoDocdesv, Boolean flgInsertarMontoDocdesv, Boolean flgAdjuntarFileDocdesv, Boolean flgEntregoPerentr, Date fechaEjecucionPerentr, String idResponsablePerentr) {
        super();
        this.idPerentr = idPerentr;
        this.idPerdesvPerentr = idPerdesvPerentr;
        this.idObraPerentr = idObraPerentr;
        this.idTipoDocDesvPerentr = idTipoDocDesvPerentr;
        this.descripcionDocdesv = descripcionDocdesv;
        this.tipoDocdesv = tipoDocdesv;
        this.descripcionGrupoDocdesv = descripcionGrupoDocdesv;
        this.flgInsertarMontoDocdesv = flgInsertarMontoDocdesv;
        this.flgAdjuntarFileDocdesv = flgAdjuntarFileDocdesv;
        this.flgEntregoPerentr = flgEntregoPerentr;
        this.fechaEjecucionPerentr = fechaEjecucionPerentr;
        this.idResponsablePerentr = idResponsablePerentr;
    }

    public PersonalDocDesvDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPerentr() {
        return idPerentr;
    }

    public void setIdPerentr(Long idPerentr) {
        this.idPerentr = idPerentr;
    }

    public Long getIdPerdesvPerentr() {
        return idPerdesvPerentr;
    }

    public void setIdPerdesvPerentr(Long idPerdesvPerentr) {
        this.idPerdesvPerentr = idPerdesvPerentr;
    }

    public String getIdObraPerentr() {
        return idObraPerentr;
    }

    public void setIdObraPerentr(String idObraPerentr) {
        this.idObraPerentr = idObraPerentr;
    }

    public Long getIdTipoDocDesvPerentr() {
        return idTipoDocDesvPerentr;
    }

    public void setIdTipoDocDesvPerentr(Long idTipoDocDesvPerentr) {
        this.idTipoDocDesvPerentr = idTipoDocDesvPerentr;
    }

    public String getDescripcionDocdesv() {
        return descripcionDocdesv;
    }

    public void setDescripcionDocdesv(String descripcionDocdesv) {
        this.descripcionDocdesv = descripcionDocdesv;
    }

    public String getTipoDocdesv() {
        return tipoDocdesv;
    }

    public void setTipoDocdesv(String tipoDocdesv) {
        this.tipoDocdesv = tipoDocdesv;
    }

    public String getDescripcionGrupoDocdesv() {
        return descripcionGrupoDocdesv;
    }

    public void setDescripcionGrupoDocdesv(String descripcionGrupoDocdesv) {
        this.descripcionGrupoDocdesv = descripcionGrupoDocdesv;
    }

    public Boolean getFlgInsertarMontoDocdesv() {
        return flgInsertarMontoDocdesv;
    }

    public void setFlgInsertarMontoDocdesv(Boolean flgInsertarMontoDocdesv) {
        this.flgInsertarMontoDocdesv = flgInsertarMontoDocdesv;
    }

    public Boolean getFlgAdjuntarFileDocdesv() {
        return flgAdjuntarFileDocdesv;
    }

    public void setFlgAdjuntarFileDocdesv(Boolean flgAdjuntarFileDocdesv) {
        this.flgAdjuntarFileDocdesv = flgAdjuntarFileDocdesv;
    }

    public Boolean getFlgEntregoPerentr() {
        return flgEntregoPerentr;
    }

    public void setFlgEntregoPerentr(Boolean flgEntregoPerentr) {
        this.flgEntregoPerentr = flgEntregoPerentr;
    }

    public Date getFechaEjecucionPerentr() {
        return fechaEjecucionPerentr;
    }

    public void setFechaEjecucionPerentr(Date fechaEjecucionPerentr) {
        this.fechaEjecucionPerentr = fechaEjecucionPerentr;
    }

    public String getIdResponsablePerentr() {
        return idResponsablePerentr;
    }

    public void setIdResponsablePerentr(String idResponsablePerentr) {
        this.idResponsablePerentr = idResponsablePerentr;
    }

    private static final long serialVersionUID = 1L;
}
