package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import com.spring.sigmaweb.backend.process.legajo.model.PersonalContrato;

import java.io.Serializable;
import java.util.Date;

public class PersonalDesvinculacionDTO implements Serializable {
    private Long idPerDesv;
    private String idObraPerdesv;
    private Long idPersonal;
    private Long idPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicioPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinPervila;

    private String estadoPervila;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaCesePerdesv;

    private Integer idMotivoPerdesv;
    private String motivoPerdesv;


    private String observacionesPerdesv;
    private Boolean flgCompesacionPerdesv;
    private Boolean estadoPerdesv;
    private Double compeGraciaPerdesv;
    private Double liquidacionPerdesv;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngPerdesv;

    private String creaPorPerdesv;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiPerdesv;

    private String modiPorPerdesv;

    public PersonalDesvinculacionDTO(Long idPerDesv, String idObraPerdesv, Long idPersonal, Long idPervila, Date fechaInicioPervila, Date fechaFinPervila, String estadoPervila, String apePaternoPers, String apeMaternoPers, String nombrePers, Date fechaCesePerdesv, Integer idMotivoPerdesv, String motivoPerdesv, String observacionesPerdesv, Boolean flgCompesacionPerdesv, Boolean estadoPerdesv, Double compeGraciaPerdesv, Double liquidacionPerdesv, Date fechaIngPerdesv, String creaPorPerdesv, Date fechaModiPerdesv, String modiPorPerdesv) {
        this.idPerDesv = idPerDesv;
        this.idObraPerdesv = idObraPerdesv;
        this.idPersonal = idPersonal;
        this.idPervila = idPervila;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaFinPervila = fechaFinPervila;
        this.estadoPervila = estadoPervila;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.fechaCesePerdesv = fechaCesePerdesv;
        this.idMotivoPerdesv = idMotivoPerdesv;
        this.motivoPerdesv = motivoPerdesv;
        this.observacionesPerdesv = observacionesPerdesv;
        this.flgCompesacionPerdesv = flgCompesacionPerdesv;
        this.estadoPerdesv = estadoPerdesv;
        this.compeGraciaPerdesv = compeGraciaPerdesv;
        this.liquidacionPerdesv = liquidacionPerdesv;
        this.fechaIngPerdesv = fechaIngPerdesv;
        this.creaPorPerdesv = creaPorPerdesv;
        this.fechaModiPerdesv = fechaModiPerdesv;
        this.modiPorPerdesv = modiPorPerdesv;
    }

    public PersonalDesvinculacionDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPerDesv() {
        return idPerDesv;
    }

    public void setIdPerDesv(Long idPerDesv) {
        this.idPerDesv = idPerDesv;
    }

    public String getIdObraPerdesv() {
        return idObraPerdesv;
    }

    public void setIdObraPerdesv(String idObraPerdesv) {
        this.idObraPerdesv = idObraPerdesv;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Long getIdPervila() {
        return idPervila;
    }

    public void setIdPervila(Long idPervila) {
        this.idPervila = idPervila;
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

    public Date getFechaCesePerdesv() {
        return fechaCesePerdesv;
    }

    public void setFechaCesePerdesv(Date fechaCesePerdesv) {
        this.fechaCesePerdesv = fechaCesePerdesv;
    }

    public Integer getIdMotivoPerdesv() {
        return idMotivoPerdesv;
    }

    public void setIdMotivoPerdesv(Integer idMotivoPerdesv) {
        this.idMotivoPerdesv = idMotivoPerdesv;
    }

    public String getMotivoPerdesv() {
        return motivoPerdesv;
    }

    public void setMotivoPerdesv(String motivoPerdesv) {
        this.motivoPerdesv = motivoPerdesv;
    }

    public String getObservacionesPerdesv() {
        return observacionesPerdesv;
    }

    public void setObservacionesPerdesv(String observacionesPerdesv) {
        this.observacionesPerdesv = observacionesPerdesv;
    }

    public Boolean getFlgCompesacionPerdesv() {
        return flgCompesacionPerdesv;
    }

    public void setFlgCompesacionPerdesv(Boolean flgCompesacionPerdesv) {
        this.flgCompesacionPerdesv = flgCompesacionPerdesv;
    }

    public Boolean getEstadoPerdesv() {
        return estadoPerdesv;
    }

    public void setEstadoPerdesv(Boolean estadoPerdesv) {
        this.estadoPerdesv = estadoPerdesv;
    }

    public Double getCompeGraciaPerdesv() {
        return compeGraciaPerdesv;
    }

    public void setCompeGraciaPerdesv(Double compeGraciaPerdesv) {
        this.compeGraciaPerdesv = compeGraciaPerdesv;
    }

    public Double getLiquidacionPerdesv() {
        return liquidacionPerdesv;
    }

    public void setLiquidacionPerdesv(Double liquidacionPerdesv) {
        this.liquidacionPerdesv = liquidacionPerdesv;
    }

    public Date getFechaIngPerdesv() {
        return fechaIngPerdesv;
    }

    public void setFechaIngPerdesv(Date fechaIngPerdesv) {
        this.fechaIngPerdesv = fechaIngPerdesv;
    }

    public String getCreaPorPerdesv() {
        return creaPorPerdesv;
    }

    public void setCreaPorPerdesv(String creaPorPerdesv) {
        this.creaPorPerdesv = creaPorPerdesv;
    }

    public Date getFechaModiPerdesv() {
        return fechaModiPerdesv;
    }

    public void setFechaModiPerdesv(Date fechaModiPerdesv) {
        this.fechaModiPerdesv = fechaModiPerdesv;
    }

    public String getModiPorPerdesv() {
        return modiPorPerdesv;
    }

    public void setModiPorPerdesv(String modiPorPerdesv) {
        this.modiPorPerdesv = modiPorPerdesv;
    }

    private static final long serialVersionUID = 1L;
}
