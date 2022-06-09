package com.spring.sigmaweb.backend.process.legajo.reports;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class ReportDesvinculacion implements Serializable {
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

    private Integer idAreaPerpuest;
    private String areaPerpuest;
    private Integer idTipoNivelPlanillaPerpuest;
    private String tipoNivelPlanillaPerpuest;

    private Long idPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioPervila;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPervila;

    private String estadoPervila;

    private Long idPerDesv;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCesePerdesv;

    private Integer idMotivoPerdesv;
    private String motivoPerdesv;
    private String observacionesPerdesv;
    private Boolean estadoPerdesv;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerdesv;

    private String creaPorPerdesv;

    private Long idUltPerCont;
    private Integer idTipoUltPercont;
    private String tipoUltPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniUltPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinUltPercont;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminoUltPercont;

    private String idPerentr;
    private Long idTipoDocDesvPerentr;
    private String tipoDocDesvPerentr;
    private String flgEntregoPerentr;
    private Double montoPerentr;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEjecucionPerentr;

    private String idResponsablePerentr;

    private String titleFilePer;
    private Long sizeFilePer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDateFilePer;

    public ReportDesvinculacion(String idobra, String nombreobra, Long idPersonal, String codigoPer, String estadoPer, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idTipoDocPers, String tipoDocPers, String nroDocPers, Integer idAreaPerpuest, String areaPerpuest, Integer idTipoNivelPlanillaPerpuest, String tipoNivelPlanillaPerpuest, Long idPervila, Date fechaInicioPervila, Date fechaCesePerdesv, Integer idMotivoPerdesv, String motivoPerdesv, String observacionesPerdesv, Date fechaIngPerdesv, String creaPorPerdesv, Integer idTipoUltPercont, String tipoUltPercont, Date fechaIniUltPercont, Date fechaFinUltPercont, Date fechaTerminoUltPercont) {
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
        this.idAreaPerpuest = idAreaPerpuest;
        this.areaPerpuest = areaPerpuest;
        this.idTipoNivelPlanillaPerpuest = idTipoNivelPlanillaPerpuest;
        this.tipoNivelPlanillaPerpuest = tipoNivelPlanillaPerpuest;

        this.idPervila = idPervila;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaCesePerdesv = fechaCesePerdesv;
        this.idMotivoPerdesv = idMotivoPerdesv;
        this.motivoPerdesv = motivoPerdesv;
        this.observacionesPerdesv = observacionesPerdesv;
        this.fechaIngPerdesv = fechaIngPerdesv;
        this.creaPorPerdesv = creaPorPerdesv;

        this.idTipoUltPercont = idTipoUltPercont;
        this.tipoUltPercont = tipoUltPercont;
        this.fechaIniUltPercont = fechaIniUltPercont;
        this.fechaFinUltPercont = fechaFinUltPercont;
        this.fechaTerminoUltPercont = fechaTerminoUltPercont;
    }

    public ReportDesvinculacion(String idobra, String nombreobra, Long idPersonal, String apePaternoPers, String apeMaternoPers, String nombrePers, Integer idTipoDocPers, String tipoDocPers, String nroDocPers, Integer idAreaPerpuest, String areaPerpuest, Integer idTipoNivelPlanillaPerpuest, String tipoNivelPlanillaPerpuest, Long idPervila, Date fechaInicioPervila, Date fechaFinPervila, Long idPerDesv, Date fechaCesePerdesv, Integer idMotivoPerdesv, String motivoPerdesv, Integer idTipoUltPercont, String tipoUltPercont, Date fechaIniUltPercont, Date fechaFinUltPercont, Date fechaTerminoUltPercont, String idPerentr, Long idTipoDocDesvPerentr, String tipoDocDesvPerentr, String flgEntregoPerentr, Double montoPerentr, Date fechaEjecucionPerentr, String idResponsablePerentr, String titleFilePer, Long sizeFilePer, Date uploadDateFilePer) {
        this.idobra = idobra;
        this.nombreobra = nombreobra;
        this.idPersonal = idPersonal;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idTipoDocPers = idTipoDocPers;
        this.tipoDocPers = tipoDocPers;
        this.nroDocPers = nroDocPers;

        this.idAreaPerpuest = idAreaPerpuest;
        this.areaPerpuest = areaPerpuest;
        this.idTipoNivelPlanillaPerpuest = idTipoNivelPlanillaPerpuest;
        this.tipoNivelPlanillaPerpuest = tipoNivelPlanillaPerpuest;

        this.idPervila = idPervila;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaFinPervila = fechaFinPervila;
        this.idPerDesv = idPerDesv;
        this.fechaCesePerdesv = fechaCesePerdesv;
        this.idMotivoPerdesv = idMotivoPerdesv;
        this.motivoPerdesv = motivoPerdesv;

        this.idTipoUltPercont = idTipoUltPercont;
        this.tipoUltPercont = tipoUltPercont;
        this.fechaIniUltPercont = fechaIniUltPercont;
        this.fechaFinUltPercont = fechaFinUltPercont;
        this.fechaTerminoUltPercont = fechaTerminoUltPercont;

        this.idPerentr = idPerentr;
        this.idTipoDocDesvPerentr = idTipoDocDesvPerentr;
        this.tipoDocDesvPerentr = tipoDocDesvPerentr;
        this.flgEntregoPerentr = flgEntregoPerentr;
        this.montoPerentr = montoPerentr;
        this.fechaEjecucionPerentr = fechaEjecucionPerentr;
        this.idResponsablePerentr = idResponsablePerentr;
        this.titleFilePer = titleFilePer;
        this.sizeFilePer = sizeFilePer;
        this.uploadDateFilePer = uploadDateFilePer;
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

    public Long getIdPerDesv() {
        return idPerDesv;
    }

    public void setIdPerDesv(Long idPerDesv) {
        this.idPerDesv = idPerDesv;
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

    public Boolean getEstadoPerdesv() {
        return estadoPerdesv;
    }

    public void setEstadoPerdesv(Boolean estadoPerdesv) {
        this.estadoPerdesv = estadoPerdesv;
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

    public Long getIdUltPerCont() {
        return idUltPerCont;
    }

    public void setIdUltPerCont(Long idUltPerCont) {
        this.idUltPerCont = idUltPerCont;
    }

    public Integer getIdTipoUltPercont() {
        return idTipoUltPercont;
    }

    public void setIdTipoUltPercont(Integer idTipoUltPercont) {
        this.idTipoUltPercont = idTipoUltPercont;
    }

    public String getTipoUltPercont() {
        return tipoUltPercont;
    }

    public void setTipoUltPercont(String tipoUltPercont) {
        this.tipoUltPercont = tipoUltPercont;
    }

    public Date getFechaIniUltPercont() {
        return fechaIniUltPercont;
    }

    public void setFechaIniUltPercont(Date fechaIniUltPercont) {
        this.fechaIniUltPercont = fechaIniUltPercont;
    }

    public Date getFechaFinUltPercont() {
        return fechaFinUltPercont;
    }

    public void setFechaFinUltPercont(Date fechaFinUltPercont) {
        this.fechaFinUltPercont = fechaFinUltPercont;
    }

    public Date getFechaTerminoUltPercont() {
        return fechaTerminoUltPercont;
    }

    public void setFechaTerminoUltPercont(Date fechaTerminoUltPercont) {
        this.fechaTerminoUltPercont = fechaTerminoUltPercont;
    }

    public String getIdPerentr() {
        return idPerentr;
    }

    public void setIdPerentr(String idPerentr) {
        this.idPerentr = idPerentr;
    }

    public Long getIdTipoDocDesvPerentr() {
        return idTipoDocDesvPerentr;
    }

    public void setIdTipoDocDesvPerentr(Long idTipoDocDesvPerentr) {
        this.idTipoDocDesvPerentr = idTipoDocDesvPerentr;
    }

    public String getTipoDocDesvPerentr() {
        return tipoDocDesvPerentr;
    }

    public void setTipoDocDesvPerentr(String tipoDocDesvPerentr) {
        this.tipoDocDesvPerentr = tipoDocDesvPerentr;
    }

    public String getFlgEntregoPerentr() {
        return flgEntregoPerentr;
    }

    public void setFlgEntregoPerentr(String flgEntregoPerentr) {
        this.flgEntregoPerentr = flgEntregoPerentr;
    }

    public Double getMontoPerentr() {
        return montoPerentr;
    }

    public void setMontoPerentr(Double montoPerentr) {
        this.montoPerentr = montoPerentr;
    }

    public Date getFechaEjecucionPerentr() {
        return fechaEjecucionPerentr;
    }

    public void setFechaEjecucionPerentr(Date fechaEjecucionPerentr) {
        this.fechaEjecucionPerentr = fechaEjecucionPerentr;
    }

    public String getIdResponsablePerentr() {
        return idResponsablePerentr;
    }

    public void setIdResponsablePerentr(String idResponsablePerentr) {
        this.idResponsablePerentr = idResponsablePerentr;
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

    public String getTitleFilePer() {
        return titleFilePer;
    }

    public void setTitleFilePer(String titleFilePer) {
        this.titleFilePer = titleFilePer;
    }

    public Long getSizeFilePer() {
        return sizeFilePer;
    }

    public void setSizeFilePer(Long sizeFilePer) {
        this.sizeFilePer = sizeFilePer;
    }

    public Date getUploadDateFilePer() {
        return uploadDateFilePer;
    }

    public void setUploadDateFilePer(Date uploadDateFilePer) {
        this.uploadDateFilePer = uploadDateFilePer;
    }
}
