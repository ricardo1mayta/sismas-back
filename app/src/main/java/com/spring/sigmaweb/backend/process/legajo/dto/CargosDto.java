package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CargosDto implements Serializable {
    private Long idCargo;
    private String nombreCar;
    private String abreviadoCar;
    private Boolean estadoCar;
    private Integer idTipoGoCar;
    private String tipoGoCar;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngCar;

    private String creaPorCar;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiCar;

    private String modiPorCar;

    public CargosDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CargosDto(Long idCargo, String nombreCar, String abreviadoCar, Boolean estadoCar, Integer idTipoGoCar, String tipoGoCar, Date fechaIngCar, String creaPorCar, Date fechaModiCar, String modiPorCar) {
        this.idCargo = idCargo;
        this.nombreCar = nombreCar;
        this.abreviadoCar = abreviadoCar;
        this.estadoCar = estadoCar;
        this.idTipoGoCar = idTipoGoCar;
        this.tipoGoCar = tipoGoCar;
        this.fechaIngCar = fechaIngCar;
        this.creaPorCar = creaPorCar;
        this.fechaModiCar = fechaModiCar;
        this.modiPorCar = modiPorCar;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCar() {
        return nombreCar;
    }

    public void setNombreCar(String nombreCar) {
        this.nombreCar = nombreCar;
    }

    public String getAbreviadoCar() {
        return abreviadoCar;
    }

    public void setAbreviadoCar(String abreviadoCar) {
        this.abreviadoCar = abreviadoCar;
    }

    public Boolean getEstadoCar() {
        return estadoCar;
    }

    public void setEstadoCar(Boolean estadoCar) {
        this.estadoCar = estadoCar;
    }

    public Integer getIdTipoGoCar() {
        return idTipoGoCar;
    }

    public void setIdTipoGoCar(Integer idTipoGoCar) {
        this.idTipoGoCar = idTipoGoCar;
    }

    public String getTipoGoCar() {
        return tipoGoCar;
    }

    public void setTipoGoCar(String tipoGoCar) {
        this.tipoGoCar = tipoGoCar;
    }

    public Date getFechaIngCar() {
        return fechaIngCar;
    }

    public void setFechaIngCar(Date fechaIngCar) {
        this.fechaIngCar = fechaIngCar;
    }

    public String getCreaPorCar() {
        return creaPorCar;
    }

    public void setCreaPorCar(String creaPorCar) {
        this.creaPorCar = creaPorCar;
    }

    public Date getFechaModiCar() {
        return fechaModiCar;
    }

    public void setFechaModiCar(Date fechaModiCar) {
        this.fechaModiCar = fechaModiCar;
    }

    public String getModiPorCar() {
        return modiPorCar;
    }

    public void setModiPorCar(String modiPorCar) {
        this.modiPorCar = modiPorCar;
    }
}
