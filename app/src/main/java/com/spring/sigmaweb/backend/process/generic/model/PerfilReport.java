package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mg_perfil_report")
public class PerfilReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_perfilrep", length = 50, nullable = false)
    private String idPerfilRep;

    @Column(name="id_rol_perr", nullable = false)
    private Long idRolPerr;

    @Column(name="id_repo_perr", nullable = false)
    private Long idRepoPerr;

    @Column(name = "id_obra_perr", length = 6, nullable = false)
    private String idObraPerr;

    @Column(nullable = true, name = "fechaing_perr")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerr;

    @Column(nullable = false, name = "creapor_perr", length = 100)
    private String creaPorPerr;

    @PrePersist
    public void prePersist() {
        this.fechaIngPerr = new Date();
    }

    public String getIdPerfilRep() {
        return idPerfilRep;
    }

    public void setIdPerfilRep(String idPerfilRep) {
        this.idPerfilRep = idPerfilRep;
    }

    public Long getIdRolPerr() {
        return idRolPerr;
    }

    public void setIdRolPerr(Long idRolPerr) {
        this.idRolPerr = idRolPerr;
    }

    public Long getIdRepoPerr() {
        return idRepoPerr;
    }

    public void setIdRepoPerr(Long idRepoPerr) {
        this.idRepoPerr = idRepoPerr;
    }

    public String getIdObraPerr() {
        return idObraPerr;
    }

    public void setIdObraPerr(String idObraPerr) {
        this.idObraPerr = idObraPerr;
    }

    public Date getFechaIngPerr() {
        return fechaIngPerr;
    }

    public void setFechaIngPerr(Date fechaIngPerr) {
        this.fechaIngPerr = fechaIngPerr;
    }

    public String getCreaPorPerr() {
        return creaPorPerr;
    }

    public void setCreaPorPerr(String creaPorPerr) {
        this.creaPorPerr = creaPorPerr;
    }
}