package com.spring.sigmaweb.backend.process.core.dto;

import java.io.Serializable;

public class RolSideNavItemActivosDTO implements Serializable {
    /**
     *
     */

    private Integer idRolItem;
    private String idobra;
    private Long idRol;
    private Long idItem;
    private String idModulo;
    private String name;
    private Boolean flgActivoRolItem;
    private Boolean flgLecturaRolItem;
    private Boolean flgEscrituraRolItem;
    private String modiPorUltRolItem;
    private String routeOrFunction;

    public RolSideNavItemActivosDTO(Integer idRolItem, String idobra, Long idRol, Long idItem, String idModulo,
                                    String name, Boolean flgActivoRolItem, Boolean flgLecturaRolItem, Boolean flgEscrituraRolItem,
                                    String modiPorUltRolItem, String routeOrFunction) {
        super();
        this.idRolItem = idRolItem;
        this.idobra = idobra;
        this.idRol = idRol;
        this.idItem = idItem;
        this.idModulo = idModulo;
        this.name = name;
        this.flgActivoRolItem = flgActivoRolItem;
        this.flgLecturaRolItem = flgLecturaRolItem;
        this.flgEscrituraRolItem = flgEscrituraRolItem;
        this.modiPorUltRolItem = modiPorUltRolItem;
        this.routeOrFunction = routeOrFunction;
    }

    public RolSideNavItemActivosDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
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

    public String getModiPorUltRolItem() {
        return modiPorUltRolItem;
    }

    public void setModiPorUltRolItem(String modiPorUltRolItem) {
        this.modiPorUltRolItem = modiPorUltRolItem;
    }

    public String getRouteOrFunction() {
        return routeOrFunction;
    }

    public void setRouteOrFunction(String routeOrFunction) {
        this.routeOrFunction = routeOrFunction;
    }

    public Integer getIdRolItem() {
        return idRolItem;
    }

    public void setIdRolItem(Integer idRolItem) {
        this.idRolItem = idRolItem;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    private static final long serialVersionUID = 1L;
}
