package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "mg_reports")
public class Reporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_repo", nullable = false)
    private Long idRepo;

    @Column(name="descripcion_repo", nullable = false, unique = true, length = 200)
    private String descripcionRepo;

    @Column(name="idmodulo_repo", nullable = false, length = 3)
    private String idModuloRepo;

    @Column(name="tipo_repo", nullable = false, unique = true, length = 10)
    private String tipoRepo;

    @Column(nullable = true, name = "fechaing_repo")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngRepo;

    @Column(nullable = false, name = "creapor_repo", length = 100)
    private String creaPorRepo;

    @Column(nullable = false, name = "estado_repo", columnDefinition = "boolean default true")
    private Boolean estadoRepo;

    @PrePersist
    public void prePersist() {
        this.fechaIngRepo = new Date();
    }

    public Long getIdRepo() {
        return idRepo;
    }

    public void setIdRepo(Long idRepo) {
        this.idRepo = idRepo;
    }

    public String getDescripcionRepo() {
        return descripcionRepo;
    }

    public void setDescripcionRepo(String descripcionRepo) {
        this.descripcionRepo = descripcionRepo;
    }

    public String getIdModuloRepo() {
        return idModuloRepo;
    }

    public void setIdModuloRepo(String idModuloRepo) {
        this.idModuloRepo = idModuloRepo;
    }

    public String getTipoRepo() {
        return tipoRepo;
    }

    public void setTipoRepo(String tipoRepo) {
        this.tipoRepo = tipoRepo;
    }

    public Date getFechaIngRepo() {
        return fechaIngRepo;
    }

    public void setFechaIngRepo(Date fechaIngRepo) {
        this.fechaIngRepo = fechaIngRepo;
    }

    public String getCreaPorRepo() {
        return creaPorRepo;
    }

    public void setCreaPorRepo(String creaPorRepo) {
        this.creaPorRepo = creaPorRepo;
    }

    public Boolean getEstadoRepo() {
        return estadoRepo;
    }

    public void setEstadoRepo(Boolean estadoRepo) {
        this.estadoRepo = estadoRepo;
    }

    private static final long serialVersionUID = 1L;
}
