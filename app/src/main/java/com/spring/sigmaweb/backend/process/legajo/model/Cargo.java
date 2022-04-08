package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_cargos")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", nullable = false, unique = true)
    private Long idCargo;

    @Column(nullable = false, length = 100, name = "nombre_car", unique = true)
    private String nombreCar;

    @Column(nullable = false, length = 10, name = "abreviado_car", unique = true)
    private String abreviadoCar;

    @Column(nullable = false, name = "estado_car", columnDefinition = "boolean default true")
    private Boolean estadoCar;

    @Column(nullable = true, name = "id_tipo_go_car")
    private Integer idTipoGoCar;

    @Column(nullable = false, name = "fechaing_car")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngCar;

    @Column(nullable = false, name = "creapor_car", length = 30)
    private String creaPorCar;

    @Column(nullable = true, name = "fechamodi_car")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiCar;

    @Column(nullable = true, name = "modipor_car", length = 30)
    private String modiPorCar;

    @PrePersist
    public void prePersist() {
        this.fechaIngCar = new Date();
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

    public Integer getIdTipoGoCar() {
        return idTipoGoCar;
    }

    public void setIdTipoGoCar(Integer idTipoGoCar) {
        this.idTipoGoCar = idTipoGoCar;
    }

    private static final long serialVersionUID = 1L;
}
