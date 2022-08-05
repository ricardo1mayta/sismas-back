package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PuestosDto {
    private Long idPuesto;
    private String nombrePues;
    private String abreviadoPues;
    private String codigoPues;
    private String idObraPues;
    private Boolean estadoPues;
    private Integer idTipoGoPues;
    private String tipoGoPues;
    private Long equivalenciaCargoPues;
    private String descEquivalenciaCargoPues;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngPues;

    private String creaPorPues;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiPues;

    private String modiPorPues;

    public PuestosDto() {
        super();
        // TODO Auto-generated constructor stub
    }


    public PuestosDto(Long idPuesto, String nombrePues, String abreviadoPues, String codigoPues, String idObraPues, Boolean estadoPues, Integer idTipoGoPues, String tipoGoPues, Long equivalenciaCargoPues, String descEquivalenciaCargoPues, Date fechaIngPues, String creaPorPues, Date fechaModiPues, String modiPorPues) {
        this.idPuesto = idPuesto;
        this.nombrePues = nombrePues;
        this.abreviadoPues = abreviadoPues;
        this.codigoPues = codigoPues;
        this.idObraPues = idObraPues;
        this.estadoPues = estadoPues;
        this.idTipoGoPues = idTipoGoPues;
        this.tipoGoPues = tipoGoPues;
        this.equivalenciaCargoPues = equivalenciaCargoPues;
        this.descEquivalenciaCargoPues = descEquivalenciaCargoPues;
        this.fechaIngPues = fechaIngPues;
        this.creaPorPues = creaPorPues;
        this.fechaModiPues = fechaModiPues;
        this.modiPorPues = modiPorPues;
    }

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombrePues() {
        return nombrePues;
    }

    public void setNombrePues(String nombrePues) {
        this.nombrePues = nombrePues;
    }

    public String getAbreviadoPues() {
        return abreviadoPues;
    }

    public void setAbreviadoPues(String abreviadoPues) {
        this.abreviadoPues = abreviadoPues;
    }

    public String getCodigoPues() {
        return codigoPues;
    }

    public void setCodigoPues(String codigoPues) {
        this.codigoPues = codigoPues;
    }

    public String getIdObraPues() {
        return idObraPues;
    }

    public void setIdObraPues(String idObraPues) {
        this.idObraPues = idObraPues;
    }

    public Boolean getEstadoPues() {
        return estadoPues;
    }

    public void setEstadoPues(Boolean estadoPues) {
        this.estadoPues = estadoPues;
    }

    public Integer getIdTipoGoPues() {
        return idTipoGoPues;
    }

    public void setIdTipoGoPues(Integer idTipoGoPues) {
        this.idTipoGoPues = idTipoGoPues;
    }

    public Long getEquivalenciaCargoPues() {
        return equivalenciaCargoPues;
    }

    public void setEquivalenciaCargoPues(Long equivalenciaCargoPues) {
        this.equivalenciaCargoPues = equivalenciaCargoPues;
    }

    public String getDescEquivalenciaCargoPues() {
        return descEquivalenciaCargoPues;
    }

    public void setDescEquivalenciaCargoPues(String descEquivalenciaCargoPues) {
        this.descEquivalenciaCargoPues = descEquivalenciaCargoPues;
    }

    public String getTipoGoPues() {
        return tipoGoPues;
    }

    public void setTipoGoPues(String tipoGoPues) {
        this.tipoGoPues = tipoGoPues;
    }

    public Date getFechaIngPues() {
        return fechaIngPues;
    }

    public void setFechaIngPues(Date fechaIngPues) {
        this.fechaIngPues = fechaIngPues;
    }

    public String getCreaPorPues() {
        return creaPorPues;
    }

    public void setCreaPorPues(String creaPorPues) {
        this.creaPorPues = creaPorPues;
    }

    public Date getFechaModiPues() {
        return fechaModiPues;
    }

    public void setFechaModiPues(Date fechaModiPues) {
        this.fechaModiPues = fechaModiPues;
    }

    public String getModiPorPues() {
        return modiPorPues;
    }

    public void setModiPorPues(String modiPorPues) {
        this.modiPorPues = modiPorPues;
    }
}
