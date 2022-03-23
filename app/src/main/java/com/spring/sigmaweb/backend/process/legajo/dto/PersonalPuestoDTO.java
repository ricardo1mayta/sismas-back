package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PersonalPuestoDTO implements Serializable {
    private Long idPerpuest;
    private String idObraPerpuest;
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

    private Long idPuestoTPerpuest;
    private String puestoTPerpuest;
    private Integer idAreaPerpuest;
    private String areaPerpuest;

    private Integer idTipoNivelPlanillaPerpuest;
    private String tipoNivelPlanillaPerpuest;
    private Long idPuestoPerpuest;
    private String puestoPerpuest;

    private Boolean flgPuestoDirePerpuest;
    private Boolean flgPuestoConfiPerpuest;
    private Boolean flgPuestoNofilcalPerpuest;
    private Boolean flgPuestoNoAplicaPerpuest;
    private String observacionesPerpuest;
    private Boolean estadoPerpuest;
    private Double bonifCargoPerpuest;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaIniPerpuest;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinPerpuest;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngPerpuest;

    private String creaPorPerpuest;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiPerpuest;

    private String modiPorPerpuest;

    public PersonalPuestoDTO(Long idPerpuest, String idObraPerpuest, Long idPersonal, Long idPervila, Date fechaInicioPervila, Date fechaFinPervila, String estadoPervila, String apePaternoPers, String apeMaternoPers, String nombrePers, Long idPuestoTPerpuest, String puestoTPerpuest, Integer idAreaPerpuest, String areaPerpuest, Integer idTipoNivelPlanillaPerpuest, String tipoNivelPlanillaPerpuest, Long idPuestoPerpuest, String puestoPerpuest, Boolean flgPuestoDirePerpuest, Boolean flgPuestoConfiPerpuest, Boolean flgPuestoNofilcalPerpuest, Boolean flgPuestoNoAplicaPerpuest, String observacionesPerpuest, Boolean estadoPerpuest, Double bonifCargoPerpuest, Date fechaIniPerpuest, Date fechaFinPerpuest, Date fechaIngPerpuest, String creaPorPerpuest, Date fechaModiPerpuest, String modiPorPerpuest) {
        this.idPerpuest = idPerpuest;
        this.idObraPerpuest = idObraPerpuest;
        this.idPersonal = idPersonal;
        this.idPervila = idPervila;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaFinPervila = fechaFinPervila;
        this.estadoPervila = estadoPervila;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idPuestoTPerpuest = idPuestoTPerpuest;
        this.puestoTPerpuest = puestoTPerpuest;
        this.idAreaPerpuest = idAreaPerpuest;
        this.areaPerpuest = areaPerpuest;
        this.idTipoNivelPlanillaPerpuest = idTipoNivelPlanillaPerpuest;
        this.tipoNivelPlanillaPerpuest = tipoNivelPlanillaPerpuest;
        this.idPuestoPerpuest = idPuestoPerpuest;
        this.puestoPerpuest = puestoPerpuest;
        this.flgPuestoDirePerpuest = flgPuestoDirePerpuest;
        this.flgPuestoConfiPerpuest = flgPuestoConfiPerpuest;
        this.flgPuestoNofilcalPerpuest = flgPuestoNofilcalPerpuest;
        this.flgPuestoNoAplicaPerpuest = flgPuestoNoAplicaPerpuest;
        this.observacionesPerpuest = observacionesPerpuest;
        this.estadoPerpuest = estadoPerpuest;
        this.bonifCargoPerpuest = bonifCargoPerpuest;
        this.fechaIniPerpuest = fechaIniPerpuest;
        this.fechaFinPerpuest = fechaFinPerpuest;
        this.fechaIngPerpuest = fechaIngPerpuest;
        this.creaPorPerpuest = creaPorPerpuest;
        this.fechaModiPerpuest = fechaModiPerpuest;
        this.modiPorPerpuest = modiPorPerpuest;
    }

    public PersonalPuestoDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPerpuest() {
        return idPerpuest;
    }

    public void setIdPerpuest(Long idPerpuest) {
        this.idPerpuest = idPerpuest;
    }

    public String getIdObraPerpuest() {
        return idObraPerpuest;
    }

    public void setIdObraPerpuest(String idObraPerpuest) {
        this.idObraPerpuest = idObraPerpuest;
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

    public Long getIdPuestoTPerpuest() {
        return idPuestoTPerpuest;
    }

    public void setIdPuestoTPerpuest(Long idPuestoTPerpuest) {
        this.idPuestoTPerpuest = idPuestoTPerpuest;
    }

    public String getPuestoTPerpuest() {
        return puestoTPerpuest;
    }

    public void setPuestoTPerpuest(String puestoTPerpuest) {
        this.puestoTPerpuest = puestoTPerpuest;
    }

    public Integer getIdAreaPerpuest() {
        return idAreaPerpuest;
    }

    public void setIdAreaPerpuest(Integer idAreaPerpuest) {
        this.idAreaPerpuest = idAreaPerpuest;
    }

    public String getAreaPerpuest() {
        return areaPerpuest;
    }

    public void setAreaPerpuest(String areaPerpuest) {
        this.areaPerpuest = areaPerpuest;
    }

    public Integer getIdTipoNivelPlanillaPerpuest() {
        return idTipoNivelPlanillaPerpuest;
    }

    public void setIdTipoNivelPlanillaPerpuest(Integer idTipoNivelPlanillaPerpuest) {
        this.idTipoNivelPlanillaPerpuest = idTipoNivelPlanillaPerpuest;
    }

    public String getTipoNivelPlanillaPerpuest() {
        return tipoNivelPlanillaPerpuest;
    }

    public void setTipoNivelPlanillaPerpuest(String tipoNivelPlanillaPerpuest) {
        this.tipoNivelPlanillaPerpuest = tipoNivelPlanillaPerpuest;
    }

    public Long getIdPuestoPerpuest() {
        return idPuestoPerpuest;
    }

    public void setIdPuestoPerpuest(Long idPuestoPerpuest) {
        this.idPuestoPerpuest = idPuestoPerpuest;
    }

    public String getPuestoPerpuest() {
        return puestoPerpuest;
    }

    public void setPuestoPerpuest(String puestoPerpuest) {
        this.puestoPerpuest = puestoPerpuest;
    }

    public Boolean getFlgPuestoDirePerpuest() {
        return flgPuestoDirePerpuest;
    }

    public void setFlgPuestoDirePerpuest(Boolean flgPuestoDirePerpuest) {
        this.flgPuestoDirePerpuest = flgPuestoDirePerpuest;
    }

    public Boolean getFlgPuestoConfiPerpuest() {
        return flgPuestoConfiPerpuest;
    }

    public void setFlgPuestoConfiPerpuest(Boolean flgPuestoConfiPerpuest) {
        this.flgPuestoConfiPerpuest = flgPuestoConfiPerpuest;
    }

    public Boolean getFlgPuestoNofilcalPerpuest() {
        return flgPuestoNofilcalPerpuest;
    }

    public void setFlgPuestoNofilcalPerpuest(Boolean flgPuestoNofilcalPerpuest) {
        this.flgPuestoNofilcalPerpuest = flgPuestoNofilcalPerpuest;
    }

    public Boolean getFlgPuestoNoAplicaPerpuest() {
        return flgPuestoNoAplicaPerpuest;
    }

    public void setFlgPuestoNoAplicaPerpuest(Boolean flgPuestoNoAplicaPerpuest) {
        this.flgPuestoNoAplicaPerpuest = flgPuestoNoAplicaPerpuest;
    }

    public String getObservacionesPerpuest() {
        return observacionesPerpuest;
    }

    public void setObservacionesPerpuest(String observacionesPerpuest) {
        this.observacionesPerpuest = observacionesPerpuest;
    }

    public Boolean getEstadoPerpuest() {
        return estadoPerpuest;
    }

    public void setEstadoPerpuest(Boolean estadoPerpuest) {
        this.estadoPerpuest = estadoPerpuest;
    }

    public Double getBonifCargoPerpuest() {
        return bonifCargoPerpuest;
    }

    public void setBonifCargoPerpuest(Double bonifCargoPerpuest) {
        this.bonifCargoPerpuest = bonifCargoPerpuest;
    }

    public Date getFechaIniPerpuest() {
        return fechaIniPerpuest;
    }

    public void setFechaIniPerpuest(Date fechaIniPerpuest) {
        this.fechaIniPerpuest = fechaIniPerpuest;
    }

    public Date getFechaFinPerpuest() {
        return fechaFinPerpuest;
    }

    public void setFechaFinPerpuest(Date fechaFinPerPuest) {
        this.fechaFinPerpuest = fechaFinPerPuest;
    }

    public Date getFechaIngPerpuest() {
        return fechaIngPerpuest;
    }

    public void setFechaIngPerpuest(Date fechaIngPerpuest) {
        this.fechaIngPerpuest = fechaIngPerpuest;
    }

    public String getCreaPorPerpuest() {
        return creaPorPerpuest;
    }

    public void setCreaPorPerpuest(String creaPorPerpuest) {
        this.creaPorPerpuest = creaPorPerpuest;
    }

    public Date getFechaModiPerpuest() {
        return fechaModiPerpuest;
    }

    public void setFechaModiPerpuest(Date fechaModiPerpuest) {
        this.fechaModiPerpuest = fechaModiPerpuest;
    }

    public String getModiPorPerpuest() {
        return modiPorPerpuest;
    }

    public void setModiPorPerpuest(String modiPorPerpuest) {
        this.modiPorPerpuest = modiPorPerpuest;
    }

    private static final long serialVersionUID = 1L;
}
