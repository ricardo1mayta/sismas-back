package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class EntidadDataSelectDTO implements Serializable {
    private Long idEntidad;
    private String idobra;
    private String rucEnt;
    private String nombreEnt;
    private String nombreComerEnt;
    private String telefonoEnt;
    private String urlEnt;
    private String emailEnt;
    private Integer tipoEnt;
    private String flgEduSupEnt;
    private String flgFinacieraEnt;
    private String flgPrevisionalEnt;
    private String flgProveedorEnt;
    private String flgSaludEnt;
    private String codigoDocExternoEnt;
    private String creaPorEnt;
    private String modiPorEnt;
    private String contactoEnt;
    private String partidaRegEnt;
    private String representanteEnt;
    private String representanteNroDocEnt;
    private String nroCtaSolesEnt;
    private String nroCtaDolarEnt;
    private String cciSolesEnt;
    private String cciDolarEnt;;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngEnt;

    private Boolean estadoEnt;

    public EntidadDataSelectDTO(Long idEntidad, String idobra, String rucEnt, String nombreEnt, String nombreComerEnt, String telefonoEnt, String urlEnt, String emailEnt, Integer tipoEnt, String flgEduSupEnt, String flgFinacieraEnt, String flgPrevisionalEnt, String flgProveedorEnt, String flgSaludEnt, String codigoDocExternoEnt, String creaPorEnt, String modiPorEnt, Date fechaIngEnt, Boolean estadoEnt) {
        this.idEntidad = idEntidad;
        this.idobra = idobra;
        this.rucEnt = rucEnt;
        this.nombreEnt = nombreEnt;
        this.nombreComerEnt = nombreComerEnt;
        this.telefonoEnt = telefonoEnt;
        this.urlEnt = urlEnt;
        this.emailEnt = emailEnt;
        this.tipoEnt = tipoEnt;
        this.flgEduSupEnt = flgEduSupEnt;
        this.flgFinacieraEnt = flgFinacieraEnt;
        this.flgPrevisionalEnt = flgPrevisionalEnt;
        this.flgProveedorEnt = flgProveedorEnt;
        this.flgSaludEnt = flgSaludEnt;
        this.codigoDocExternoEnt = codigoDocExternoEnt;
        this.creaPorEnt = creaPorEnt;
        this.modiPorEnt = modiPorEnt;
        this.fechaIngEnt = fechaIngEnt;
        this.estadoEnt = estadoEnt;
    }

    public EntidadDataSelectDTO(Long idEntidad, String idobra, String rucEnt, String nombreEnt, String nombreComerEnt, String telefonoEnt, String urlEnt, String emailEnt, Integer tipoEnt, String flgEduSupEnt, String flgFinacieraEnt, String flgPrevisionalEnt, String flgProveedorEnt, String flgSaludEnt, String codigoDocExternoEnt, String creaPorEnt, String modiPorEnt, String contactoEnt, String partidaRegEnt, String presentanteEnt, String representanteNroDocEnt, String nroCtaSolesEnt, String nroCtaDolarEnt, String cciSolesEnt, String cciDolarEnt, Date fechaIngEnt, Boolean estadoEnt) {
        this.idEntidad = idEntidad;
        this.idobra = idobra;
        this.rucEnt = rucEnt;
        this.nombreEnt = nombreEnt;
        this.nombreComerEnt = nombreComerEnt;
        this.telefonoEnt = telefonoEnt;
        this.urlEnt = urlEnt;
        this.emailEnt = emailEnt;
        this.tipoEnt = tipoEnt;
        this.flgEduSupEnt = flgEduSupEnt;
        this.flgFinacieraEnt = flgFinacieraEnt;
        this.flgPrevisionalEnt = flgPrevisionalEnt;
        this.flgProveedorEnt = flgProveedorEnt;
        this.flgSaludEnt = flgSaludEnt;
        this.codigoDocExternoEnt = codigoDocExternoEnt;
        this.creaPorEnt = creaPorEnt;
        this.modiPorEnt = modiPorEnt;
        this.contactoEnt = contactoEnt;
        this.partidaRegEnt = partidaRegEnt;
        this.representanteEnt = presentanteEnt;
        this.representanteNroDocEnt = representanteNroDocEnt;
        this.nroCtaSolesEnt = nroCtaSolesEnt;
        this.nroCtaDolarEnt = nroCtaDolarEnt;
        this.cciSolesEnt = cciSolesEnt;
        this.cciDolarEnt = cciDolarEnt;
        this.fechaIngEnt = fechaIngEnt;
        this.estadoEnt = estadoEnt;
    }

    public EntidadDataSelectDTO() {
        super();
        // TODO Auto-generated constructor stub
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

    public String getFlgEduSupEnt() {
        return flgEduSupEnt;
    }

    public void setFlgEduSupEnt(String flgEduSupEnt) {
        this.flgEduSupEnt = flgEduSupEnt;
    }

    public String getFlgFinacieraEnt() {
        return flgFinacieraEnt;
    }

    public void setFlgFinacieraEnt(String flgFinacieraEnt) {
        this.flgFinacieraEnt = flgFinacieraEnt;
    }

    public String getFlgPrevisionalEnt() {
        return flgPrevisionalEnt;
    }

    public void setFlgPrevisionalEnt(String flgPrevisionalEnt) {
        this.flgPrevisionalEnt = flgPrevisionalEnt;
    }

    public String getFlgProveedorEnt() {
        return flgProveedorEnt;
    }

    public void setFlgProveedorEnt(String flgProveedorEnt) {
        this.flgProveedorEnt = flgProveedorEnt;
    }

    public String getFlgSaludEnt() {
        return flgSaludEnt;
    }

    public void setFlgSaludEnt(String flgSaludEnt) {
        this.flgSaludEnt = flgSaludEnt;
    }

    public String getCodigoDocExternoEnt() {
        return codigoDocExternoEnt;
    }

    public void setCodigoDocExternoEnt(String codigoDocExternoEnt) {
        this.codigoDocExternoEnt = codigoDocExternoEnt;
    }

    public String getCreaPorEnt() {
        return creaPorEnt;
    }

    public void setCreaPorEnt(String creaPorEnt) {
        this.creaPorEnt = creaPorEnt;
    }

    public String getModiPorEnt() {
        return modiPorEnt;
    }

    public void setModiPorEnt(String modiPorEnt) {
        this.modiPorEnt = modiPorEnt;
    }

    public Date getFechaIngEnt() {
        return fechaIngEnt;
    }

    public void setFechaIngEnt(Date fechaIngEnt) {
        this.fechaIngEnt = fechaIngEnt;
    }

    public Integer getTipoEnt() {
        return tipoEnt;
    }

    public void setTipoEnt(Integer tipoEnt) {
        this.tipoEnt = tipoEnt;
    }

    public Boolean getEstadoEnt() {
        return estadoEnt;
    }

    public void setEstadoEnt(Boolean estadoEnt) {
        this.estadoEnt = estadoEnt;
    }

    public String getContactoEnt() {
        return contactoEnt;
    }

    public void setContactoEnt(String contactoEnt) {
        this.contactoEnt = contactoEnt;
    }

    public String getPartidaRegEnt() {
        return partidaRegEnt;
    }

    public void setPartidaRegEnt(String partidaRegEnt) {
        this.partidaRegEnt = partidaRegEnt;
    }

    public String getRepresentanteEnt() {
        return representanteEnt;
    }

    public void setRepresentanteEnt(String representanteEnt) {
        this.representanteEnt = representanteEnt;
    }

    public String getRepresentanteNroDocEnt() {
        return representanteNroDocEnt;
    }

    public void setRepresentanteNroDocEnt(String representanteNroDocEnt) {
        this.representanteNroDocEnt = representanteNroDocEnt;
    }

    public String getNroCtaSolesEnt() {
        return nroCtaSolesEnt;
    }

    public void setNroCtaSolesEnt(String nroCtaSolesEnt) {
        this.nroCtaSolesEnt = nroCtaSolesEnt;
    }

    public String getNroCtaDolarEnt() {
        return nroCtaDolarEnt;
    }

    public void setNroCtaDolarEnt(String nroCtaDolarEnt) {
        this.nroCtaDolarEnt = nroCtaDolarEnt;
    }

    public String getCciSolesEnt() {
        return cciSolesEnt;
    }

    public void setCciSolesEnt(String cciSolesEnt) {
        this.cciSolesEnt = cciSolesEnt;
    }

    public String getCciDolarEnt() {
        return cciDolarEnt;
    }

    public void setCciDolarEnt(String cciDolarEnt) {
        this.cciDolarEnt = cciDolarEnt;
    }

    private static final long serialVersionUID = 1L;
}
