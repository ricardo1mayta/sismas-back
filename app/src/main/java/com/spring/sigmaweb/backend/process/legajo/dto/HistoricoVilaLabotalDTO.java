package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;

import java.io.Serializable;
import java.util.Date;

public class HistoricoVilaLabotalDTO implements Serializable {
    private Long idHistvila;
    private String idObraHistvila;

    private Long idPersonalHistvila;
    private String codigoPer;
    private Boolean estadoPer;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;
    private String nroDocPers;

    private Long idPercontHistvila;
    private Date fechaIniPercont;
    private Date fechaFinPercont;
    private Date fechaTerminoPercont;
    private String tipoPercont;

    private Long idPervilaHistvila;
    private Date fechaInicioPervila;
    private Date fechaFinPervila;
    private String estadoPervila;


    private Integer motivoHistvila;
    private String textMotivoHistvila;
    private String tipoHistvila;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaCambioHistvila;

    private Double jornadaSemaOldHistvila;
    private Double bonificacionOldHistvila;
    private Double remuneracionOldHistvila;

    private Double jornadaSemaNewHistvila;
    private Double bonificacionNewHistvila;
    private Double remuneracionNewHistvila;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngHistvila;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiHistvila;

    private String creaPorHistvila;
    private String modiPorHistvila;

    private Boolean estadoHistvila;

    private Long idPuestoCargoHistvila;

    public HistoricoVilaLabotalDTO(Long idHistvila, String idObraHistvila, Long idPersonalHistvila, String codigoPer, Boolean estadoPer, String apePaternoPers, String apeMaternoPers, String nombrePers, String nroDocPers, Long idPercontHistvila, Date fechaIniPercont, Date fechaFinPercont, Date fechaTerminoPercont, String tipoPercont, Long idPervilaHistvila, Date fechaInicioPervila, Date fechaFinPervila, String estadoPervila, Integer motivoHistvila, String textMotivoHistvila, String tipoHistvila, Date fechaCambioHistvila, Double jornadaSemaOldHistvila, Double bonificacionOldHistvila, Double remuneracionOldHistvila, Double jornadaSemaNewHistvila, Double bonificacionNewHistvila, Double remuneracionNewHistvila, Date fechaIngHistvila, Date fechaModiHistvila, String creaPorHistvila, String modiPorHistvila, Boolean estadoHistvila) {
        this.idHistvila = idHistvila;
        this.idObraHistvila = idObraHistvila;
        this.idPersonalHistvila = idPersonalHistvila;
        this.codigoPer = codigoPer;
        this.estadoPer = estadoPer;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.nroDocPers = nroDocPers;
        this.idPercontHistvila = idPercontHistvila;
        this.fechaIniPercont = fechaIniPercont;
        this.fechaFinPercont = fechaFinPercont;
        this.fechaTerminoPercont = fechaTerminoPercont;
        this.tipoPercont = tipoPercont;
        this.idPervilaHistvila = idPervilaHistvila;
        this.fechaInicioPervila = fechaInicioPervila;
        this.fechaFinPervila = fechaFinPervila;
        this.estadoPervila = estadoPervila;
        this.motivoHistvila = motivoHistvila;
        this.textMotivoHistvila = textMotivoHistvila;
        this.tipoHistvila = tipoHistvila;
        this.fechaCambioHistvila = fechaCambioHistvila;
        this.jornadaSemaOldHistvila = jornadaSemaOldHistvila;
        this.bonificacionOldHistvila = bonificacionOldHistvila;
        this.remuneracionOldHistvila = remuneracionOldHistvila;
        this.jornadaSemaNewHistvila = jornadaSemaNewHistvila;
        this.bonificacionNewHistvila = bonificacionNewHistvila;
        this.remuneracionNewHistvila = remuneracionNewHistvila;
        this.fechaIngHistvila = fechaIngHistvila;
        this.fechaModiHistvila = fechaModiHistvila;
        this.creaPorHistvila = creaPorHistvila;
        this.modiPorHistvila = modiPorHistvila;
        this.estadoHistvila = estadoHistvila;
    }

    public HistoricoVilaLabotalDTO(Long idHistvila, String idObraHistvila, Long idPersonalHistvila, Long idPercontHistvila, Long idPervilaHistvila,
                                   Integer motivoHistvila, String textMotivoHistvila, String tipoHistvila, Date fechaCambioHistvila,
                                   Double jornadaSemaNewHistvila, Double remuneracionNewHistvila, Double bonificacionNewHistvila, Date fechaIngHistvila, String creaPorHistvila) {
        this.idHistvila = idHistvila;
        this.idObraHistvila = idObraHistvila;
        this.idPersonalHistvila = idPersonalHistvila;
        this.idPercontHistvila = idPercontHistvila;
        this.idPervilaHistvila = idPervilaHistvila;
        this.motivoHistvila = motivoHistvila;
        this.textMotivoHistvila = textMotivoHistvila;
        this.tipoHistvila = tipoHistvila;
        this.fechaCambioHistvila = fechaCambioHistvila;
        this.jornadaSemaNewHistvila = jornadaSemaNewHistvila;
        this.remuneracionNewHistvila = remuneracionNewHistvila;
        this.bonificacionNewHistvila = bonificacionNewHistvila;
        this.fechaIngHistvila = fechaIngHistvila;
        this.creaPorHistvila = creaPorHistvila;
    }

    public HistoricoVilaLabotalDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdHistvila() {
        return idHistvila;
    }

    public void setIdHistvila(Long idHistvila) {
        this.idHistvila = idHistvila;
    }

    public String getIdObraHistvila() {
        return idObraHistvila;
    }

    public void setIdObraHistvila(String idObraHistvila) {
        this.idObraHistvila = idObraHistvila;
    }

    public Long getIdPersonalHistvila() {
        return idPersonalHistvila;
    }

    public void setIdPersonalHistvila(Long idPersonalHistvila) {
        this.idPersonalHistvila = idPersonalHistvila;
    }

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public Boolean getEstadoPer() {
        return estadoPer;
    }

    public void setEstadoPer(Boolean estadoPer) {
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

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public Long getIdPercontHistvila() {
        return idPercontHistvila;
    }

    public void setIdPercontHistvila(Long idPercontHistvila) {
        this.idPercontHistvila = idPercontHistvila;
    }

    public Date getFechaIniPercont() {
        return fechaIniPercont;
    }

    public void setFechaIniPercont(Date fechaIniPercont) {
        this.fechaIniPercont = fechaIniPercont;
    }

    public Date getFechaFinPercont() {
        return fechaFinPercont;
    }

    public void setFechaFinPercont(Date fechaFinPercont) {
        this.fechaFinPercont = fechaFinPercont;
    }

    public Date getFechaTerminoPercont() {
        return fechaTerminoPercont;
    }

    public void setFechaTerminoPercont(Date fechaTerminoPercont) {
        this.fechaTerminoPercont = fechaTerminoPercont;
    }

    public String getTipoPercont() {
        return tipoPercont;
    }

    public void setTipoPercont(String tipoPercont) {
        this.tipoPercont = tipoPercont;
    }

    public Long getIdPervilaHistvila() {
        return idPervilaHistvila;
    }

    public void setIdPervilaHistvila(Long idPervilaHistvila) {
        this.idPervilaHistvila = idPervilaHistvila;
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

    public String getTipoHistvila() {
        return tipoHistvila;
    }

    public void setTipoHistvila(String tipoHistvila) {
        this.tipoHistvila = tipoHistvila;
    }

    public Date getFechaCambioHistvila() {
        return fechaCambioHistvila;
    }

    public void setFechaCambioHistvila(Date fechaCambioHistvila) {
        this.fechaCambioHistvila = fechaCambioHistvila;
    }

    public Double getJornadaSemaOldHistvila() {
        return jornadaSemaOldHistvila;
    }

    public void setJornadaSemaOldHistvila(Double jornadaSemaOldHistvila) {
        this.jornadaSemaOldHistvila = jornadaSemaOldHistvila;
    }

    public Double getBonificacionOldHistvila() {
        return bonificacionOldHistvila;
    }

    public void setBonificacionOldHistvila(Double bonificacionOldHistvila) {
        this.bonificacionOldHistvila = bonificacionOldHistvila;
    }

    public Double getRemuneracionOldHistvila() {
        return remuneracionOldHistvila;
    }

    public void setRemuneracionOldHistvila(Double remuneracionOldHistvila) {
        this.remuneracionOldHistvila = remuneracionOldHistvila;
    }

    public Double getJornadaSemaNewHistvila() {
        return jornadaSemaNewHistvila;
    }

    public void setJornadaSemaNewHistvila(Double jornadaSemaNewHistvila) {
        this.jornadaSemaNewHistvila = jornadaSemaNewHistvila;
    }

    public Double getBonificacionNewHistvila() {
        return bonificacionNewHistvila;
    }

    public void setBonificacionNewHistvila(Double bonificacionNewHistvila) {
        this.bonificacionNewHistvila = bonificacionNewHistvila;
    }

    public Double getRemuneracionNewHistvila() {
        return remuneracionNewHistvila;
    }

    public void setRemuneracionNewHistvila(Double remuneracionNewHistvila) {
        this.remuneracionNewHistvila = remuneracionNewHistvila;
    }

    public Date getFechaIngHistvila() {
        return fechaIngHistvila;
    }

    public void setFechaIngHistvila(Date fechaIngHistvila) {
        this.fechaIngHistvila = fechaIngHistvila;
    }

    public Date getFechaModiHistvila() {
        return fechaModiHistvila;
    }

    public void setFechaModiHistvila(Date fechaModiHistvila) {
        this.fechaModiHistvila = fechaModiHistvila;
    }

    public String getCreaPorHistvila() {
        return creaPorHistvila;
    }

    public void setCreaPorHistvila(String creaPorHistvila) {
        this.creaPorHistvila = creaPorHistvila;
    }

    public String getModiPorHistvila() {
        return modiPorHistvila;
    }

    public void setModiPorHistvila(String modiPorHistvila) {
        this.modiPorHistvila = modiPorHistvila;
    }

    public Boolean getEstadoHistvila() {
        return estadoHistvila;
    }

    public void setEstadoHistvila(Boolean estadoHistvila) {
        this.estadoHistvila = estadoHistvila;
    }

    public Integer getMotivoHistvila() {
        return motivoHistvila;
    }

    public void setMotivoHistvila(Integer motivoHistvila) {
        this.motivoHistvila = motivoHistvila;
    }

    public String getTextMotivoHistvila() {
        return textMotivoHistvila;
    }

    public void setTextMotivoHistvila(String textMotivoHistvila) {
        this.textMotivoHistvila = textMotivoHistvila;
    }

    public Long getIdPuestoCargoHistvila() {
        return idPuestoCargoHistvila;
    }

    public void setIdPuestoCargoHistvila(Long idPuestoCargoHistvila) {
        this.idPuestoCargoHistvila = idPuestoCargoHistvila;
    }

    private static final long serialVersionUID = 1L;
}
