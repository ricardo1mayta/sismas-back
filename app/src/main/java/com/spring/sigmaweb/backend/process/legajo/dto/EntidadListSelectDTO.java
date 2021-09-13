package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;

public class EntidadListSelectDTO implements Serializable{
    private Long idEntidad;
    private String idobra;
    private String rucEnt;
    private String nombreEnt;
    private String nombreComerEnt;
    private String telefonoEnt;
    private String urlEnt;
    private String emailEnt;

    public EntidadListSelectDTO(Long idEntidad, String idobra, String rucEnt, String nombreEnt, String nombreComerEnt,
                                String telefonoEnt, String urlEnt, String emailEnt) {
        super();
        this.idEntidad = idEntidad;
        this.idobra = idobra;
        this.rucEnt = rucEnt;
        this.nombreEnt = nombreEnt;
        this.nombreComerEnt = nombreComerEnt;
        this.telefonoEnt = telefonoEnt;
        this.urlEnt = urlEnt;
        this.emailEnt = emailEnt;
    }

    public Long getIdEntidad() {
        return idEntidad;
    }
    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }
    public String getIdobra() {
        return idobra;
    }
    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }
    public String getRucEnt() {
        return rucEnt;
    }
    public void setRucEnt(String rucEnt) {
        this.rucEnt = rucEnt;
    }
    public String getNombreEnt() {
        return nombreEnt;
    }
    public void setNombreEnt(String nombreEnt) {
        this.nombreEnt = nombreEnt;
    }
    public String getNombreComerEnt() {
        return nombreComerEnt;
    }
    public void setNombreComerEnt(String nombreComerEnt) {
        this.nombreComerEnt = nombreComerEnt;
    }
    public String getTelefonoEnt() {
        return telefonoEnt;
    }
    public void setTelefonoEnt(String telefonoEnt) {
        this.telefonoEnt = telefonoEnt;
    }
    public String getUrlEnt() {
        return urlEnt;
    }
    public void setUrlEnt(String urlEnt) {
        this.urlEnt = urlEnt;
    }
    public String getEmailEnt() {
        return emailEnt;
    }
    public void setEmailEnt(String emailEnt) {
        this.emailEnt = emailEnt;
    }

    private static final long serialVersionUID = 1L;
}
