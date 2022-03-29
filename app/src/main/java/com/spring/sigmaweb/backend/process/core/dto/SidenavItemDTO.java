package com.spring.sigmaweb.backend.process.core.dto;

import java.io.Serializable;
import java.util.List;

public class SidenavItemDTO implements Serializable{

    private String name;
    private String icon;
    private String routeOrFunction;
    private SidenavItemDTO parent;
    private List<SidenavItemDTO> subItems;
    private Long position;
    private Boolean pathMatchExact ;
    private String badge;
    private String badgeColor;
    private String type;
    private String customClass;
    private Long idPadre;
    private Long idItem;
    private Boolean flgLecturaRolItem;
    private Boolean flgEscrituraRolItem;

    /*
    public SidenavItemDTO(String name, String icon, String routeOrFunction, SidenavItemDTO parent,
            List<SidenavItemDTO> subItems, Long position, Boolean pathMatchExact, String badge, String badgeColor,
            String type, String customClass) {
        super();
        this.name = name;
        this.icon = icon;
        this.routeOrFunction = routeOrFunction;
        this.parent = parent;
        this.subItems = subItems;
        this.position = position;
        this.pathMatchExact = pathMatchExact;
        this.badge = badge;
        this.badgeColor = badgeColor;
        this.type = type;
        this.customClass = customClass;
    }
*/
    private static final long serialVersionUID = 1L;

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

    public SidenavItemDTO getParent() {
        return parent;
    }

    public void setParent(SidenavItemDTO parent) {
        this.parent = parent;
    }

    public List<SidenavItemDTO> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<SidenavItemDTO> subItems) {
        this.subItems = subItems;
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

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
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
}
