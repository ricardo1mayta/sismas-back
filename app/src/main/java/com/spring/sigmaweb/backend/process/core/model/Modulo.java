package com.spring.sigmaweb.backend.process.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mm_modulo")
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_modulo", nullable = false, length = 3)
    private String idModulo;

    @Column(name = "nombre_mod", nullable = false, length = 50)
    private String nombreMod;

    @Column(name = "descripcion_mod", nullable = false, length = 50)
    private String descripcionMod;

    @Column(name = "flg_activo_mod", nullable = false, columnDefinition = "boolean default true")
    private Boolean flgActivoMod;

    @Column(nullable = false, name = "fechaing_mod")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngMod;

    @Column(nullable = false, name = "creapor_mod", length = 30)
    private String creaPorMod;

    @Column(nullable = true, name = "fechamodi_mod")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiMod;

    @Column(nullable = true, name = "modipor_mod", length = 30)
    private String modiPorMod;

    @JsonIgnoreProperties({ "moduloItem", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "moduloItem", cascade = CascadeType.ALL)
    private List<SideNavItem> sideNavItem;

    public Modulo() {
        this.sideNavItem = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        this.fechaIngMod = new Date();
        this.flgActivoMod = true;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombreMod() {
        return nombreMod;
    }

    public void setNombreMod(String nombreMod) {
        this.nombreMod = nombreMod;
    }

    public String getDescripcionMod() {
        return descripcionMod;
    }

    public void setDescripcionMod(String descripcionMod) {
        this.descripcionMod = descripcionMod;
    }

    public Boolean getFlgActivoMod() {
        return flgActivoMod;
    }

    public void setFlgActivoMod(Boolean flgActivoMod) {
        this.flgActivoMod = flgActivoMod;
    }

    public Date getFechaIngMod() {
        return fechaIngMod;
    }

    public void setFechaIngMod(Date fechaIngMod) {
        this.fechaIngMod = fechaIngMod;
    }

    public String getCreaPorMod() {
        return creaPorMod;
    }

    public void setCreaPorMod(String creaPorMod) {
        this.creaPorMod = creaPorMod;
    }

    public Date getFechaModiMod() {
        return fechaModiMod;
    }

    public void setFechaModiMod(Date fechaModiMod) {
        this.fechaModiMod = fechaModiMod;
    }

    public String getModiPorMod() {
        return modiPorMod;
    }

    public void setModiPorMod(String modiPorMod) {
        this.modiPorMod = modiPorMod;
    }

    private static final long serialVersionUID = 1L;
}
