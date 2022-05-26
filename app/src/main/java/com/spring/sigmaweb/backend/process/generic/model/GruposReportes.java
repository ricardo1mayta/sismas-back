package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mg_report_grupos")
public class GruposReportes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_gruprep", length = 50, nullable = false)
    private String idGrupRep;

    @Column(name="id_repo_grupr", nullable = false)
    private Long idRepoGrupr;

    @Column(name="id_gruporep_grupr", nullable = false)
    private Integer idGruporepGrupr;

    @Column(name = "id_obra_grupr", length = 6, nullable = false)
    private String idObraGrupr;

    @Column(nullable = true, name = "fechaing_grupr")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngGrupr;

    @Column(nullable = false, name = "creapor_grupr", length = 100)
    private String creaPorGrupr;

    @PrePersist
    public void prePersist() {
        this.fechaIngGrupr = new Date();
    }

    public String getIdGrupRep() {
        return idGrupRep;
    }

    public void setIdGrupRep(String idGrupRep) {
        this.idGrupRep = idGrupRep;
    }

    public Long getIdRepoGrupr() {
        return idRepoGrupr;
    }

    public void setIdRepoGrupr(Long idRepoGrupr) {
        this.idRepoGrupr = idRepoGrupr;
    }

    public Integer getIdGruporepGrupr() {
        return idGruporepGrupr;
    }

    public void setIdGruporepGrupr(Integer idGruporepGrupr) {
        this.idGruporepGrupr = idGruporepGrupr;
    }

    public String getIdObraGrupr() {
        return idObraGrupr;
    }

    public void setIdObraGrupr(String idObraGrupr) {
        this.idObraGrupr = idObraGrupr;
    }

    public Date getFechaIngGrupr() {
        return fechaIngGrupr;
    }

    public void setFechaIngGrupr(Date fechaIngGrupr) {
        this.fechaIngGrupr = fechaIngGrupr;
    }

    public String getCreaPorGrupr() {
        return creaPorGrupr;
    }

    public void setCreaPorGrupr(String creaPorGrupr) {
        this.creaPorGrupr = creaPorGrupr;
    }
}