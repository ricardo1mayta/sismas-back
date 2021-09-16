package com.spring.sigmaweb.backend.process.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.Obra;

@Entity
@Table(name = "mm_rolsidenavitem")
public class RolSideNavItem implements Serializable {

    @Id
    @Column(name = "id_rolitem", nullable = false)
    private Integer idRolItem;

    @JsonIgnoreProperties(value = { "alumnos", "familia", "obradocumentos", "usuarios", "personal","hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_obra", foreignKey = @ForeignKey(name = "fk_rolsidenavitem_obra"))
    private Obra obraRolItem;

    @Column(name = "id_rol", nullable = false)
    private Long rolRolItem;

    @JsonIgnoreProperties(value = { "sideNavItemRol", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_item", foreignKey = @ForeignKey(name = "fk_rolsidenavitem_slidenavitem"))
    private SideNavItem idItem;

    @Column(name = "flg_activo_rolitem", nullable = false, columnDefinition = "boolean default true")
    private Boolean flgActivoRolItem;

    @Column(name = "flg_lectura_rolitem", nullable = false, columnDefinition = "boolean default true")
    private Boolean flgLecturaRolItem;

    @Column(name = "flg_escritura_rolitem", nullable = false, columnDefinition = "boolean default true")
    private Boolean flgEscrituraRolItem;

    @Column(nullable = true, name = "fechamodi_rolitem")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltModiRolItem;

    @Column(nullable = true, name = "modipor_rolitem", length = 30)
    private String modiPorUltRolItem;

    @PrePersist
    public void prePersist() {
        this.fechaUltModiRolItem = new Date();
        this.flgActivoRolItem = true;
    }

    public Integer getIdRolItem() {
        return idRolItem;
    }

    public void setIdRolItem(Integer idRolItem) {
        this.idRolItem = idRolItem;
    }

    public Obra getObraRolItem() {
        return obraRolItem;
    }

    public void setObraRolItem(Obra obraRolItem) {
        this.obraRolItem = obraRolItem;
    }

    public Long getRolRolItem() {
        return rolRolItem;
    }

    public void setRolRolItem(Long rolRolItem) {
        this.rolRolItem = rolRolItem;
    }

    public SideNavItem getIdItem() {
        return idItem;
    }

    public void setIdItem(SideNavItem idItem) {
        this.idItem = idItem;
    }

    public Boolean getFlgActivoRolItem() {
        return flgActivoRolItem;
    }

    public void setFlgActivoRolItem(Boolean flgActivoRolItem) {
        this.flgActivoRolItem = flgActivoRolItem;
    }

    public Boolean getFlgLecturaRolItem() {
        return flgLecturaRolItem;
    }

    public void setFlgLecturaRolItem(Boolean flgLecturaRolItem) {
        this.flgLecturaRolItem = flgLecturaRolItem;
    }

    public Boolean getFlgEscrituraRolItem() {
        return flgEscrituraRolItem;
    }

    public void setFlgEscrituraRolItem(Boolean flgEscrituraRolItem) {
        this.flgEscrituraRolItem = flgEscrituraRolItem;
    }

    public Date getFechaUltModiRolItem() {
        return fechaUltModiRolItem;
    }

    public void setFechaUltModiRolItem(Date fechaUltModiRolItem) {
        this.fechaUltModiRolItem = fechaUltModiRolItem;
    }

    public String getModiPorUltRolItem() {
        return modiPorUltRolItem;
    }

    public void setModiPorUltRolItem(String modiPorUltRolItem) {
        this.modiPorUltRolItem = modiPorUltRolItem;
    }

    private static final long serialVersionUID = 1L;
}
