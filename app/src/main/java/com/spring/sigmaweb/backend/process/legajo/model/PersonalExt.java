package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.model.Persona;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="mo_personal_ext")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
public class PersonalExt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personalext", nullable = false, unique = true)
    private Long idPersonalExt;

    @Column(nullable = true, name = "basicoest_perext")
    private Double basicoEstPerext;

    @Column(nullable = true, length = 20, name = "codigo_perext")
    private String codigoPerext;

    @Column(nullable = false, name = "estado_perext", columnDefinition = "boolean default false")
    private Boolean estadoPerext;


    @Column(name = "id_pers_perext", nullable = false)
    private Long idPersPerext;

    @Column(name = "id_obra_perext", nullable = false)
    private Obra idObraPerext;

    @Column(nullable = false, name = "fechaing_perext")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerExt;

    @Column(nullable = false, name = "creapor_perext", length = 100)
    private String creaPorPerext;

    @Column(nullable = true, name = "fecha_activo_perext")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivoPerext;

    @Column(nullable = true, name = "fecha_baja_perext")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBajaPerext;

    @Column(nullable = true, name = "fechamodi_perext")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerext;

    @Column(nullable = true, name = "modipor_perext", length = 100)
    private String modiPorPerext;

    public void prePersist() {
        this.fechaIngPerExt = new Date();
    }

    public Long getIdPersonalExt() {
        return idPersonalExt;
    }

    public void setIdPersonalExt(Long idPersonalExt) {
        this.idPersonalExt = idPersonalExt;
    }

    public Double getBasicoEstPerext() {
        return basicoEstPerext;
    }

    public void setBasicoEstPerext(Double basicoEstPerext) {
        this.basicoEstPerext = basicoEstPerext;
    }

    public String getCodigoPerext() {
        return codigoPerext;
    }

    public void setCodigoPerext(String codigoPerext) {
        this.codigoPerext = codigoPerext;
    }

    public Boolean getEstadoPerext() {
        return estadoPerext;
    }

    public void setEstadoPerext(Boolean estadoPerext) {
        this.estadoPerext = estadoPerext;
    }

    public Long getIdPersPerext() {
        return idPersPerext;
    }

    public void setIdPersPerext(Long idPersPerext) {
        this.idPersPerext = idPersPerext;
    }

    public Obra getIdObraPerext() {
        return idObraPerext;
    }

    public void setIdObraPerext(Obra idObraPerext) {
        this.idObraPerext = idObraPerext;
    }

    public Date getFechaIngPerExt() {
        return fechaIngPerExt;
    }

    public void setFechaIngPerExt(Date fechaIngPerExt) {
        this.fechaIngPerExt = fechaIngPerExt;
    }

    public String getCreaPorPerext() {
        return creaPorPerext;
    }

    public void setCreaPorPerext(String creaPorPerext) {
        this.creaPorPerext = creaPorPerext;
    }

    public Date getFechaActivoPerext() {
        return fechaActivoPerext;
    }

    public void setFechaActivoPerext(Date fechaActivoPerext) {
        this.fechaActivoPerext = fechaActivoPerext;
    }

    public Date getFechaBajaPerext() {
        return fechaBajaPerext;
    }

    public void setFechaBajaPerext(Date fechaBajaPerext) {
        this.fechaBajaPerext = fechaBajaPerext;
    }

    public Date getFechaModiPerext() {
        return fechaModiPerext;
    }

    public void setFechaModiPerext(Date fechaModiPerext) {
        this.fechaModiPerext = fechaModiPerext;
    }

    public String getModiPorPerext() {
        return modiPorPerext;
    }

    public void setModiPorPerext(String modiPorPerext) {
        this.modiPorPerext = modiPorPerext;
    }
}
