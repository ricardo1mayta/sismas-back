package com.spring.sigmaweb.backend.process.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mm_sidenavitem")
public class SideNavItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item", nullable = false)
    private Long idItem;

    @Column(name = "id_obraitem", nullable = true, length = 6)
    private String obraItem;

    @JsonIgnoreProperties(value = {"sideNavItem","hibernateLazyInitializer","handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_modulo", foreignKey = @ForeignKey(name = "fk_sidenavitem_modulo"))
    private Modulo moduloItem;

    @Column(name = "name_item", nullable = false, length = 100)
    private String name;

    @Column(name = "icon_item", nullable = true, length = 50)
    private String icon;

    @Column(name = "routeorfunction_item", nullable = true, length = 200)
    private String routeOrFunction;

    @Column(name = "idpadre_item", nullable = true)
    private Long idPadreItem;

    @Column(name = "position_item", nullable = true)
    private Long position;

    @Column(name = "pathmatchexact_item", nullable = true)
    private Boolean pathMatchExact;

    @Column(name = "badge_item", nullable = true, length = 100)
    private String badge;

    @Column(name = "badgecolor_item", nullable = true, length = 100)
    private String badgeColor;

    @Column(name = "type_item", nullable = true, length = 50)
    private String type;

    @Column(name = "customclass_item", nullable = true, length = 100)
    private String customClass;

    @Column(nullable = false, name = "fechaing_item")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngItem;

    @Column(nullable = false, name = "creapor_item", length = 30)
    private String creaPorItem;

    @Column(nullable = true, name = "fechamodi_Item")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiItem;

    @Column(nullable = true, name = "modipor_Item", length = 30)
    private String modiPorItem;

    @JsonIgnoreProperties({"idItem","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idItem", cascade = CascadeType.ALL)
    private List<RolSideNavItem> sideNavItemRol;

    public SideNavItem() {
        this.sideNavItemRol= new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {

        this.fechaIngItem = new Date();
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getObraItem() {
        return obraItem;
    }

    public void setObraItem(String obraItem) {
        this.obraItem = obraItem;
    }

    public Modulo getModuloItem() {
        return moduloItem;
    }

    public void setModuloItem(Modulo moduloItem) {
        this.moduloItem = moduloItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRouteOrFunction() {
        return routeOrFunction;
    }

    public void setRouteOrFunction(String routeOrFunction) {
        this.routeOrFunction = routeOrFunction;
    }

    public Long getIdPadreItem() {
        return idPadreItem;
    }

    public void setIdPadreItem(Long idPadreItem) {
        this.idPadreItem = idPadreItem;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Boolean getPathMatchExact() {
        return pathMatchExact;
    }

    public void setPathMatchExact(Boolean pathMatchExact) {
        this.pathMatchExact = pathMatchExact;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getBadgeColor() {
        return badgeColor;
    }

    public void setBadgeColor(String badgeColor) {
        this.badgeColor = badgeColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomClass() {
        return customClass;
    }

    public void setCustomClass(String customClass) {
        this.customClass = customClass;
    }

    public Date getFechaIngItem() {
        return fechaIngItem;
    }

    public void setFechaIngItem(Date fechaIngItem) {
        this.fechaIngItem = fechaIngItem;
    }

    public String getCreaPorItem() {
        return creaPorItem;
    }

    public void setCreaPorItem(String creaPorItem) {
        this.creaPorItem = creaPorItem;
    }

    public Date getFechaModiItem() {
        return fechaModiItem;
    }

    public void setFechaModiItem(Date fechaModiItem) {
        this.fechaModiItem = fechaModiItem;
    }

    public String getModiPorItem() {
        return modiPorItem;
    }

    public void setModiPorItem(String modiPorItem) {
        this.modiPorItem = modiPorItem;
    }

    private static final long serialVersionUID = 1L;
}
