package com.spring.sigmaweb.backend.process.legajo.reports;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class ReportPuestosCargos implements Serializable {
    private String idobra;
    private String nombreobra;

    private Long idPersonal;
    private String codigoPer;
    private String estadoPer;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private Integer idTipoDocPers;
    private String tipoDocPers;
    private String nroDocPers;

    private Long idPervila;
    private Long idPerpuest;
    private Long idPuestoPerpuest;
    private String puestoPerpuest;
    private Integer idAreaPerpuest;
    private String areaPerpuest;
    private Integer idTipoNivelPlanillaPerpuest;
    private String tipoNivelPlanillaPerpuest;

    private Boolean flgPuestoDirePerpuest;
    private Boolean flgPuestoConfiPerpuest;
    private Boolean flgPuestoNofilcalPerpuest;
    private Boolean flgPuestoNoAplicaPerpuest;
    private String observacionesPerpuest;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPerpuest;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPerpuest;

    private Boolean estadoPerpuest;
    private Double bonifCargoPerpuest;
    private Double jornadaActual;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerpuest;

    private String creaPorPerpuest;

    private Long idPercargo;
    private Long idCargoPercargo;
    private String cargoPercargo;
    private Integer idAreaPercargo;
    private String areaPercargo;
    private String observacionesPercargo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPercargo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPercargo;

    private Boolean estadoPercargo;
    private Double bonifCargoPercargo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPercargo;

    private String creaPorPercargo;

    public ReportPuestosCargos(String idobra, String nombreobra, Long idPersonal, String codigoPer, String estadoPer, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idTipoDocPers, String tipoDocPers, String nroDocPers, Long idPervila, Long idPerpuest, Long idPuestoPerpuest, String puestoPerpuest, Integer idAreaPerpuest, String areaPerpuest, Integer idTipoNivelPlanillaPerpuest, String tipoNivelPlanillaPerpuest, Boolean flgPuestoDirePerpuest, Boolean flgPuestoConfiPerpuest, Boolean flgPuestoNofilcalPerpuest, Boolean flgPuestoNoAplicaPerpuest, String observacionesPerpuest, Date fechaIniPerpuest, Date fechaFinPerpuest, Boolean estadoPerpuest, Double bonifCargoPerpuest, Date fechaIngPerpuest, String creaPorPerpuest, Long idPercargo, Long idCargoPercargo, String cargoPercargo, Integer idAreaPercargo, String areaPercargo, String observacionesPercargo, Date fechaIniPercargo, Date fechaFinPercargo, Boolean estadoPercargo, Double bonifCargoPercargo, Date fechaIngPercargo, String creaPorPercargo, Double jornadaActual) {
        this.idobra = idobra;
        this.nombreobra = nombreobra;
        this.idPersonal = idPersonal;
        this.codigoPer = codigoPer;
        this.estadoPer = estadoPer;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idTipoDocPers = idTipoDocPers;
        this.tipoDocPers = tipoDocPers;
        this.nroDocPers = nroDocPers;
        this.idPervila = idPervila;
        this.idPerpuest = idPerpuest;
        this.idPuestoPerpuest = idPuestoPerpuest;
        this.puestoPerpuest = puestoPerpuest;
        this.idAreaPerpuest = idAreaPerpuest;
        this.areaPerpuest = areaPerpuest;
        this.idTipoNivelPlanillaPerpuest = idTipoNivelPlanillaPerpuest;
        this.tipoNivelPlanillaPerpuest = tipoNivelPlanillaPerpuest;
        this.flgPuestoDirePerpuest = flgPuestoDirePerpuest;
        this.flgPuestoConfiPerpuest = flgPuestoConfiPerpuest;
        this.flgPuestoNofilcalPerpuest = flgPuestoNofilcalPerpuest;
        this.flgPuestoNoAplicaPerpuest = flgPuestoNoAplicaPerpuest;
        this.observacionesPerpuest = observacionesPerpuest;
        this.fechaIniPerpuest = fechaIniPerpuest;
        this.fechaFinPerpuest = fechaFinPerpuest;
        this.estadoPerpuest = estadoPerpuest;
        this.bonifCargoPerpuest = bonifCargoPerpuest;
        this.fechaIngPerpuest = fechaIngPerpuest;
        this.creaPorPerpuest = creaPorPerpuest;
        this.idPercargo = idPercargo;
        this.idCargoPercargo = idCargoPercargo;
        this.cargoPercargo = cargoPercargo;
        this.idAreaPercargo = idAreaPercargo;
        this.areaPercargo = areaPercargo;
        this.observacionesPercargo = observacionesPercargo;
        this.fechaIniPercargo = fechaIniPercargo;
        this.fechaFinPercargo = fechaFinPercargo;
        this.estadoPercargo = estadoPercargo;
        this.bonifCargoPercargo = bonifCargoPercargo;
        this.fechaIngPercargo = fechaIngPercargo;
        this.creaPorPercargo = creaPorPercargo;
        this.jornadaActual = jornadaActual;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    public String getNombreobra() {
        return nombreobra;
    }

    public void setNombreobra(String nombreobra) {
        this.nombreobra = nombreobra;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public String getEstadoPer() {
        return estadoPer;
    }

    public void setEstadoPer(String estadoPer) {
        this.estadoPer = estadoPer;
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

    public Integer getIdTipoDocPers() {
        return idTipoDocPers;
    }

    public void setIdTipoDocPers(Integer idTipoDocPers) {
        this.idTipoDocPers = idTipoDocPers;
    }

    public String getTipoDocPers() {
        return tipoDocPers;
    }

    public void setTipoDocPers(String tipoDocPers) {
        this.tipoDocPers = tipoDocPers;
    }

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public Long getIdPervila() {
        return idPervila;
    }

    public void setIdPervila(Long idPervila) {
        this.idPervila = idPervila;
    }

    public Long getIdPerpuest() {
        return idPerpuest;
    }

    public void setIdPerpuest(Long idPerpuest) {
        this.idPerpuest = idPerpuest;
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

    public Date getFechaIniPerpuest() {
        return fechaIniPerpuest;
    }

    public void setFechaIniPerpuest(Date fechaIniPerpuest) {
        this.fechaIniPerpuest = fechaIniPerpuest;
    }

    public Date getFechaFinPerpuest() {
        return fechaFinPerpuest;
    }

    public void setFechaFinPerpuest(Date fechaFinPerpuest) {
        this.fechaFinPerpuest = fechaFinPerpuest;
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

    public Long getIdPercargo() {
        return idPercargo;
    }

    public void setIdPercargo(Long idPercargo) {
        this.idPercargo = idPercargo;
    }

    public Long getIdCargoPercargo() {
        return idCargoPercargo;
    }

    public void setIdCargoPercargo(Long idCargoPercargo) {
        this.idCargoPercargo = idCargoPercargo;
    }

    public String getCargoPercargo() {
        return cargoPercargo;
    }

    public void setCargoPercargo(String cargoPercargo) {
        this.cargoPercargo = cargoPercargo;
    }

    public Integer getIdAreaPercargo() {
        return idAreaPercargo;
    }

    public void setIdAreaPercargo(Integer idAreaPercargo) {
        this.idAreaPercargo = idAreaPercargo;
    }

    public String getAreaPercargo() {
        return areaPercargo;
    }

    public void setAreaPercargo(String areaPercargo) {
        this.areaPercargo = areaPercargo;
    }

    public String getObservacionesPercargo() {
        return observacionesPercargo;
    }

    public void setObservacionesPercargo(String observacionesPercargo) {
        this.observacionesPercargo = observacionesPercargo;
    }

    public Date getFechaIniPercargo() {
        return fechaIniPercargo;
    }

    public void setFechaIniPercargo(Date fechaIniPercargo) {
        this.fechaIniPercargo = fechaIniPercargo;
    }

    public Date getFechaFinPercargo() {
        return fechaFinPercargo;
    }

    public void setFechaFinPercargo(Date fechaFinPercargo) {
        this.fechaFinPercargo = fechaFinPercargo;
    }

    public Boolean getEstadoPercargo() {
        return estadoPercargo;
    }

    public void setEstadoPercargo(Boolean estadoPercargo) {
        this.estadoPercargo = estadoPercargo;
    }

    public Double getBonifCargoPercargo() {
        return bonifCargoPercargo;
    }

    public void setBonifCargoPercargo(Double bonifCargoPercargo) {
        this.bonifCargoPercargo = bonifCargoPercargo;
    }

    public Date getFechaIngPercargo() {
        return fechaIngPercargo;
    }

    public void setFechaIngPercargo(Date fechaIngPercargo) {
        this.fechaIngPercargo = fechaIngPercargo;
    }

    public String getCreaPorPercargo() {
        return creaPorPercargo;
    }

    public void setCreaPorPercargo(String creaPorPercargo) {
        this.creaPorPercargo = creaPorPercargo;
    }

    public Double getJornadaActual() {
        return jornadaActual;
    }

    public void setJornadaActual(Double jornadaActual) {
        this.jornadaActual = jornadaActual;
    }
}

