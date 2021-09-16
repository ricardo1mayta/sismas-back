package com.spring.sigmaweb.backend.process.core.dto;

import java.io.Serializable;

public class RolSideNavItemMenuOrderDTO implements Serializable {

    private String ordenMenu;
    private Integer nivelMenu;
    private Long idItem;
    private Long position;
    private String idModulo;
    private String name;
    private Long idPadreItem;
    private String icon;
    private String routeOrFunction;
    private Boolean pathMatchExact;
    private String badge;
    private String badgeColor;
    private String type;
    private String customClass;

    public RolSideNavItemMenuOrderDTO(String ordenMenu, Integer nivelMenu, Long idItem, Long position, String idModulo,
                                      String name, Long idPadreItem, String icon, String routeOrFunction, Boolean pathMatchExact, String badge,
                                      String badgeColor, String type, String customClass) {
        super();
        this.ordenMenu = ordenMenu;
        this.nivelMenu = nivelMenu;
        this.idItem = idItem;
        this.position = position;
        this.idModulo = idModulo;
        this.name = name;
        this.idPadreItem = idPadreItem;
        this.icon = icon;
        this.routeOrFunction = routeOrFunction;
        this.pathMatchExact = pathMatchExact;
        this.badge = badge;
        this.badgeColor = badgeColor;
        this.type = type;
        this.customClass = customClass;
    }

    public String getOrdenMenu() {
        return ordenMenu;
    }

    public void setOrdenMenu(String ordenMenu) {
        this.ordenMenu = ordenMenu;
    }

    public Integer getNivelMenu() {
        return nivelMenu;
    }

    public void setNivelMenu(Integer nivelMenu) {
        this.nivelMenu = nivelMenu;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdPadreItem() {
        return idPadreItem;
    }

    public void setIdPadreItem(Long idPadreItem) {
        this.idPadreItem = idPadreItem;
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

    private static final long serialVersionUID = 1L;
}
