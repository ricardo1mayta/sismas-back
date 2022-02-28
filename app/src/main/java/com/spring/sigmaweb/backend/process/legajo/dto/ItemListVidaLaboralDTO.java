package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ItemListVidaLaboralDTO implements Serializable {

    private Long idPervila;
    private String idObraPervila;
    private Long idPersonalPervila;

    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private String codigoPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicioPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinPervila;

    private String estadoPervila;

    private String tipoItem;
    private Long idItem;
    private String tipoDetItem;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaIniItem;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinItem;

    private String estadoItem;

    public ItemListVidaLaboralDTO(Long idPervila, String idObraPervila, Long idPersonalPervila, String apePaternoPers, String apeMaternoPers, String nombrePers, String codigoPer, Date fechaInicioPervila, Date fechaFinPervila, String estadoPervila, String tipoItem, Long idItem, String tipoDetItem, Date fechaIniItem, Date fechaFinItem, String estadoItem) {
        this.idPervila = idPervila;
        this.idObraPervila = idObraPervila;
        this.idPersonalPervila = idPersonalPervila;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.codigoPer = codigoPer;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaFinPervila = fechaFinPervila;
        this.estadoPervila = estadoPervila;
        this.tipoItem = tipoItem;
        this.idItem = idItem;
        this.tipoDetItem = tipoDetItem;
        this.fechaIniItem = fechaIniItem;
        this.fechaFinItem = fechaFinItem;
        this.estadoItem = estadoItem;
    }

    public ItemListVidaLaboralDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPervila() {
        return idPervila;
    }

    public void setIdPervila(Long idPervila) {
        this.idPervila = idPervila;
    }

    public String getIdObraPervila() {
        return idObraPervila;
    }

    public void setIdObraPervila(String idObraPervila) {
        this.idObraPervila = idObraPervila;
    }

    public Long getIdPersonalPervila() {
        return idPersonalPervila;
    }

    public void setIdPersonalPervila(Long idPersonalPervila) {
        this.idPersonalPervila = idPersonalPervila;
    }

    public String getApePaternoPers() {
        return apePaternoPers;
    }

    public void setApePaternoPers(String apePaternoPers) {
        this.apePaternoPers = apePaternoPers;
    }

    public String getApeMaternoPers() {
        return apeMaternoPers;
    }

    public void setApeMaternoPers(String apeMaternoPers) {
        this.apeMaternoPers = apeMaternoPers;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
    }

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public Date getFechaInicioPervila() {
        return fechaInicioPervila;
    }

    public void setFechaInicioPervila(Date fechaInicioPervila) {
        this.fechaInicioPervila = fechaInicioPervila;
    }

    public Date getFechaFinPervila() {
        return fechaFinPervila;
    }

    public void setFechaFinPervila(Date fechaFinPervila) {
        this.fechaFinPervila = fechaFinPervila;
    }

    public String getEstadoPervila() {
        return estadoPervila;
    }

    public void setEstadoPervila(String estadoPervila) {
        this.estadoPervila = estadoPervila;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getTipoDetItem() {
        return tipoDetItem;
    }

    public void setTipoDetItem(String tipoDetItem) {
        this.tipoDetItem = tipoDetItem;
    }

    public Date getFechaIniItem() {
        return fechaIniItem;
    }

    public void setFechaIniItem(Date fechaIniItem) {
        this.fechaIniItem = fechaIniItem;
    }

    public Date getFechaFinItem() {
        return fechaFinItem;
    }

    public void setFechaFinItem(Date fechaFinItem) {
        this.fechaFinItem = fechaFinItem;
    }

    public String getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(String estadoItem) {
        this.estadoItem = estadoItem;
    }

    private static final long serialVersionUID = 1L;
}