package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;

import java.util.Date;

public class JornadaPersonalContratoDTO implements Serializable {
    private Long idPerCont;
    private Long idPerjorn;
    private String idObraPerjorn;
    private Long idPersonal;

    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private Boolean diaLunePerjorn;
    private Boolean diaMartPerjorn;
    private Boolean diaMierPerjorn;
    private Boolean diaJuevPerjorn;
    private Boolean diaVierPerjorn;
    private Boolean diaSabaPerjorn;
    private Boolean diaDomiPerjorn;

    private String diaLuneInihorPerjorn;
    private String diaLuneFinhorPerjorn;
    private String diaMartInihorPerjorn;
    private String diaMartFinhorPerjorn;
    private String diaMierInihorPerjorn;
    private String diaMierFinhorPerjorn;
    private String diaJuevInihorPerjorn;
    private String diaJuevFinhorPerjorn;
    private String diaVierInihorPerjorn;
    private String diaVierFinhorPerjorn;
    private String diaSabaInihorPerjorn;
    private String diaSabaFinhorPerjorn;
    private String diaDomiInihorPerjorn;
    private String diaDomiFinhorPerjorn;

    private String diaLuneInirefPerjorn;
    private String diaLuneFinrefPerjorn;
    private String diaMartInirefPerjorn;
    private String diaMartFinrefPerjorn;
    private String diaMierInirefPerjorn;
    private String diaMierFinrefPerjorn;
    private String diaJuevInirefPerjorn;
    private String diaJuevFinrefPerjorn;
    private String diaVierInirefPerjorn;
    private String diaVierFinrefPerjorn;
    private String diaSabaInirefPerjorn;
    private String diaSabaFinrefPerjorn;
    private String diaDomiInirefPerjorn;
    private String diaDomiFinrefPerjorn;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerjorn;

    private String creaPorPerjorn;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerjorn;

    private String modiPorPerjorn;

    public JornadaPersonalContratoDTO(Long idPerCont, Long idPerjorn, String idObraPerjorn, Long idPersonal, String apePaternoPers, String apeMaternoPers,
                                      String nombrePers, Boolean diaLunePerjorn, Boolean diaMartPerjorn, Boolean diaMierPerjorn, Boolean diaJuevPerjorn,
                                      Boolean diaVierPerjorn, Boolean diaSabaPerjorn, Boolean diaDomiPerjorn, String diaLuneInihorPerjorn,
                                      String diaLuneFinhorPerjorn, String diaMartInihorPerjorn, String diaMartFinhorPerjorn, String diaMierInihorPerjorn,
                                      String diaMierFinhorPerjorn, String diaJuevInihorPerjorn, String diaJuevFinhorPerjorn, String diaVierInihorPerjorn,
                                      String diaVierFinhorPerjorn, String diaSabaInihorPerjorn, String diaSabaFinhorPerjorn, String diaDomiInihorPerjorn,
                                      String diaDomiFinhorPerjorn, String diaLuneInirefPerjorn, String diaLuneFinrefPerjorn, String diaMartInirefPerjorn,
                                      String diaMartFinrefPerjorn, String diaMierInirefPerjorn, String diaMierFinrefPerjorn, String diaJuevInirefPerjorn,
                                      String diaJuevFinrefPerjorn, String diaVierInirefPerjorn, String diaVierFinrefPerjorn, String diaSabaInirefPerjorn,
                                      String diaSabaFinrefPerjorn, String diaDomiInirefPerjorn, String diaDomiFinrefPerjorn, Date fechaIngPerjorn,
                                      String creaPorPerjorn, Date fechaModiPerjorn, String modiPorPerjorn) {
        this.idPerCont = idPerCont;
        this.idPerjorn = idPerjorn;
        this.idObraPerjorn = idObraPerjorn;
        this.idPersonal = idPersonal;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;

        this.diaLunePerjorn = diaLunePerjorn;
        this.diaMartPerjorn = diaMartPerjorn;
        this.diaMierPerjorn = diaMierPerjorn;
        this.diaJuevPerjorn = diaJuevPerjorn;
        this.diaVierPerjorn = diaVierPerjorn;
        this.diaSabaPerjorn = diaSabaPerjorn;
        this.diaDomiPerjorn = diaDomiPerjorn;

        this.diaLuneInihorPerjorn = diaLuneInihorPerjorn;
        this.diaLuneFinhorPerjorn = diaLuneFinhorPerjorn;
        this.diaMartInihorPerjorn = diaMartInihorPerjorn;
        this.diaMartFinhorPerjorn = diaMartFinhorPerjorn;
        this.diaMierInihorPerjorn = diaMierInihorPerjorn;
        this.diaMierFinhorPerjorn = diaMierFinhorPerjorn;
        this.diaJuevInihorPerjorn = diaJuevInihorPerjorn;
        this.diaJuevFinhorPerjorn = diaJuevFinhorPerjorn;
        this.diaVierInihorPerjorn = diaVierInihorPerjorn;
        this.diaVierFinhorPerjorn = diaVierFinhorPerjorn;
        this.diaSabaInihorPerjorn = diaSabaInihorPerjorn;
        this.diaSabaFinhorPerjorn = diaSabaFinhorPerjorn;
        this.diaDomiInihorPerjorn = diaDomiInihorPerjorn;
        this.diaDomiFinhorPerjorn = diaDomiFinhorPerjorn;

        this.diaLuneInirefPerjorn = diaLuneInirefPerjorn;
        this.diaLuneFinrefPerjorn = diaLuneFinrefPerjorn;
        this.diaMartInirefPerjorn = diaMartInirefPerjorn;
        this.diaMartFinrefPerjorn = diaMartFinrefPerjorn;
        this.diaMierInirefPerjorn = diaMierInirefPerjorn;
        this.diaMierFinrefPerjorn = diaMierFinrefPerjorn;
        this.diaJuevInirefPerjorn = diaJuevInirefPerjorn;
        this.diaJuevFinrefPerjorn = diaJuevFinrefPerjorn;
        this.diaVierInirefPerjorn = diaVierInirefPerjorn;
        this.diaVierFinrefPerjorn = diaVierFinrefPerjorn;
        this.diaSabaInirefPerjorn = diaSabaInirefPerjorn;
        this.diaSabaFinrefPerjorn = diaSabaFinrefPerjorn;
        this.diaDomiInirefPerjorn = diaDomiInirefPerjorn;
        this.diaDomiFinrefPerjorn = diaDomiFinrefPerjorn;

        this.fechaIngPerjorn = fechaIngPerjorn;
        this.creaPorPerjorn = creaPorPerjorn;
        this.fechaModiPerjorn = fechaModiPerjorn;
        this.modiPorPerjorn = modiPorPerjorn;
    }

    public JornadaPersonalContratoDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPerCont() {
        return idPerCont;
    }

    public void setIdPerCont(Long idPerCont) {
        this.idPerCont = idPerCont;
    }

    public Long getIdPerjorn() {
        return idPerjorn;
    }

    public void setIdPerjorn(Long idPerjorn) {
        this.idPerjorn = idPerjorn;
    }

    public String getIdObraPerjorn() {
        return idObraPerjorn;
    }

    public void setIdObraPerjorn(String idObraPerjorn) {
        this.idObraPerjorn = idObraPerjorn;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
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

    public Boolean getDiaLunePerjorn() {
        return diaLunePerjorn;
    }

    public void setDiaLunePerjorn(Boolean diaLunePerjorn) {
        this.diaLunePerjorn = diaLunePerjorn;
    }

    public Boolean getDiaMartPerjorn() {
        return diaMartPerjorn;
    }

    public void setDiaMartPerjorn(Boolean diaMartPerjorn) {
        this.diaMartPerjorn = diaMartPerjorn;
    }

    public Boolean getDiaMierPerjorn() {
        return diaMierPerjorn;
    }

    public void setDiaMierPerjorn(Boolean diaMierPerjorn) {
        this.diaMierPerjorn = diaMierPerjorn;
    }

    public Boolean getDiaJuevPerjorn() {
        return diaJuevPerjorn;
    }

    public void setDiaJuevPerjorn(Boolean diaJuevPerjorn) {
        this.diaJuevPerjorn = diaJuevPerjorn;
    }

    public Boolean getDiaVierPerjorn() {
        return diaVierPerjorn;
    }

    public void setDiaVierPerjorn(Boolean diaVierPerjorn) {
        this.diaVierPerjorn = diaVierPerjorn;
    }

    public Boolean getDiaSabaPerjorn() {
        return diaSabaPerjorn;
    }

    public void setDiaSabaPerjorn(Boolean diaSabaPerjorn) {
        this.diaSabaPerjorn = diaSabaPerjorn;
    }

    public Boolean getDiaDomiPerjorn() {
        return diaDomiPerjorn;
    }

    public void setDiaDomiPerjorn(Boolean diaDomiPerjorn) {
        this.diaDomiPerjorn = diaDomiPerjorn;
    }

    public String getDiaLuneInihorPerjorn() {
        return diaLuneInihorPerjorn;
    }

    public void setDiaLuneInihorPerjorn(String diaLuneInihorPerjorn) {
        this.diaLuneInihorPerjorn = diaLuneInihorPerjorn;
    }

    public String getDiaLuneFinhorPerjorn() {
        return diaLuneFinhorPerjorn;
    }

    public void setDiaLuneFinhorPerjorn(String diaLuneFinhorPerjorn) {
        this.diaLuneFinhorPerjorn = diaLuneFinhorPerjorn;
    }

    public String getDiaMartInihorPerjorn() {
        return diaMartInihorPerjorn;
    }

    public void setDiaMartInihorPerjorn(String diaMartInihorPerjorn) {
        this.diaMartInihorPerjorn = diaMartInihorPerjorn;
    }

    public String getDiaMartFinhorPerjorn() {
        return diaMartFinhorPerjorn;
    }

    public void setDiaMartFinhorPerjorn(String diaMartFinhorPerjorn) {
        this.diaMartFinhorPerjorn = diaMartFinhorPerjorn;
    }

    public String getDiaMierInihorPerjorn() {
        return diaMierInihorPerjorn;
    }

    public void setDiaMierInihorPerjorn(String diaMierInihorPerjorn) {
        this.diaMierInihorPerjorn = diaMierInihorPerjorn;
    }

    public String getDiaMierFinhorPerjorn() {
        return diaMierFinhorPerjorn;
    }

    public void setDiaMierFinhorPerjorn(String diaMierFinhorPerjorn) {
        this.diaMierFinhorPerjorn = diaMierFinhorPerjorn;
    }

    public String getDiaJuevInihorPerjorn() {
        return diaJuevInihorPerjorn;
    }

    public void setDiaJuevInihorPerjorn(String diaJuevInihorPerjorn) {
        this.diaJuevInihorPerjorn = diaJuevInihorPerjorn;
    }

    public String getDiaJuevFinhorPerjorn() {
        return diaJuevFinhorPerjorn;
    }

    public void setDiaJuevFinhorPerjorn(String diaJuevFinhorPerjorn) {
        this.diaJuevFinhorPerjorn = diaJuevFinhorPerjorn;
    }

    public String getDiaVierInihorPerjorn() {
        return diaVierInihorPerjorn;
    }

    public void setDiaVierInihorPerjorn(String diaVierInihorPerjorn) {
        this.diaVierInihorPerjorn = diaVierInihorPerjorn;
    }

    public String getDiaVierFinhorPerjorn() {
        return diaVierFinhorPerjorn;
    }

    public void setDiaVierFinhorPerjorn(String diaVierFinhorPerjorn) {
        this.diaVierFinhorPerjorn = diaVierFinhorPerjorn;
    }

    public String getDiaSabaInihorPerjorn() {
        return diaSabaInihorPerjorn;
    }

    public void setDiaSabaInihorPerjorn(String diaSabaInihorPerjorn) {
        this.diaSabaInihorPerjorn = diaSabaInihorPerjorn;
    }

    public String getDiaSabaFinhorPerjorn() {
        return diaSabaFinhorPerjorn;
    }

    public void setDiaSabaFinhorPerjorn(String diaSabaFinhorPerjorn) {
        this.diaSabaFinhorPerjorn = diaSabaFinhorPerjorn;
    }

    public String getDiaDomiInihorPerjorn() {
        return diaDomiInihorPerjorn;
    }

    public void setDiaDomiInihorPerjorn(String diaDomiInihorPerjorn) {
        this.diaDomiInihorPerjorn = diaDomiInihorPerjorn;
    }

    public String getDiaDomiFinhorPerjorn() {
        return diaDomiFinhorPerjorn;
    }

    public void setDiaDomiFinhorPerjorn(String diaDomiFinhorPerjorn) {
        this.diaDomiFinhorPerjorn = diaDomiFinhorPerjorn;
    }

    public String getDiaLuneInirefPerjorn() {
        return diaLuneInirefPerjorn;
    }

    public void setDiaLuneInirefPerjorn(String diaLuneInirefPerjorn) {
        this.diaLuneInirefPerjorn = diaLuneInirefPerjorn;
    }

    public String getDiaLuneFinrefPerjorn() {
        return diaLuneFinrefPerjorn;
    }

    public void setDiaLuneFinrefPerjorn(String diaLuneFinrefPerjorn) {
        this.diaLuneFinrefPerjorn = diaLuneFinrefPerjorn;
    }

    public String getDiaMartInirefPerjorn() {
        return diaMartInirefPerjorn;
    }

    public void setDiaMartInirefPerjorn(String diaMartInirefPerjorn) {
        this.diaMartInirefPerjorn = diaMartInirefPerjorn;
    }

    public String getDiaMartFinrefPerjorn() {
        return diaMartFinrefPerjorn;
    }

    public void setDiaMartFinrefPerjorn(String diaMartFinrefPerjorn) {
        this.diaMartFinrefPerjorn = diaMartFinrefPerjorn;
    }

    public String getDiaMierInirefPerjorn() {
        return diaMierInirefPerjorn;
    }

    public void setDiaMierInirefPerjorn(String diaMierInirefPerjorn) {
        this.diaMierInirefPerjorn = diaMierInirefPerjorn;
    }

    public String getDiaMierFinrefPerjorn() {
        return diaMierFinrefPerjorn;
    }

    public void setDiaMierFinrefPerjorn(String diaMierFinrefPerjorn) {
        this.diaMierFinrefPerjorn = diaMierFinrefPerjorn;
    }

    public String getDiaJuevInirefPerjorn() {
        return diaJuevInirefPerjorn;
    }

    public void setDiaJuevInirefPerjorn(String diaJuevInirefPerjorn) {
        this.diaJuevInirefPerjorn = diaJuevInirefPerjorn;
    }

    public String getDiaJuevFinrefPerjorn() {
        return diaJuevFinrefPerjorn;
    }

    public void setDiaJuevFinrefPerjorn(String diaJuevFinrefPerjorn) {
        this.diaJuevFinrefPerjorn = diaJuevFinrefPerjorn;
    }

    public String getDiaVierInirefPerjorn() {
        return diaVierInirefPerjorn;
    }

    public void setDiaVierInirefPerjorn(String diaVierInirefPerjorn) {
        this.diaVierInirefPerjorn = diaVierInirefPerjorn;
    }

    public String getDiaVierFinrefPerjorn() {
        return diaVierFinrefPerjorn;
    }

    public void setDiaVierFinrefPerjorn(String diaVierFinrefPerjorn) {
        this.diaVierFinrefPerjorn = diaVierFinrefPerjorn;
    }

    public String getDiaSabaInirefPerjorn() {
        return diaSabaInirefPerjorn;
    }

    public void setDiaSabaInirefPerjorn(String diaSabaInirefPerjorn) {
        this.diaSabaInirefPerjorn = diaSabaInirefPerjorn;
    }

    public String getDiaSabaFinrefPerjorn() {
        return diaSabaFinrefPerjorn;
    }

    public void setDiaSabaFinrefPerjorn(String diaSabaFinrefPerjorn) {
        this.diaSabaFinrefPerjorn = diaSabaFinrefPerjorn;
    }

    public String getDiaDomiInirefPerjorn() {
        return diaDomiInirefPerjorn;
    }

    public void setDiaDomiInirefPerjorn(String diaDomiInirefPerjorn) {
        this.diaDomiInirefPerjorn = diaDomiInirefPerjorn;
    }

    public String getDiaDomiFinrefPerjorn() {
        return diaDomiFinrefPerjorn;
    }

    public void setDiaDomiFinrefPerjorn(String diaDomiFinrefPerjorn) {
        this.diaDomiFinrefPerjorn = diaDomiFinrefPerjorn;
    }

    public Date getFechaIngPerjorn() {
        return fechaIngPerjorn;
    }

    public void setFechaIngPerjorn(Date fechaIngPerjorn) {
        this.fechaIngPerjorn = fechaIngPerjorn;
    }

    public String getCreaPorPerjorn() {
        return creaPorPerjorn;
    }

    public void setCreaPorPerjorn(String creaPorPerjorn) {
        this.creaPorPerjorn = creaPorPerjorn;
    }

    public Date getFechaModiPerjorn() {
        return fechaModiPerjorn;
    }

    public void setFechaModiPerjorn(Date fechaModiPerjorn) {
        this.fechaModiPerjorn = fechaModiPerjorn;
    }

    public String getModiPorPerjorn() {
        return modiPorPerjorn;
    }

    public void setModiPorPerjorn(String modiPorPerjorn) {
        this.modiPorPerjorn = modiPorPerjorn;
    }

    private static final long serialVersionUID = 1L;
}
