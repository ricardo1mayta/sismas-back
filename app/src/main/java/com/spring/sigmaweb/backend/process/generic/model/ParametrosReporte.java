package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mg_ParamReports")
public class ParametrosReporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pararepo", nullable = false)
    private Long idParaRepo;

    @Column(nullable = true, name = "orden_pararepo")
    private Integer ordenParaRepo;

    @Column(nullable = true, length = 30, name = "descalter_pararepo")
    private String descAlterParaRepo;

    @Column(name="id_repo_pararepo", nullable = false)
    private long idrepoParaRepo;

    @Column(name="id_para_pararepo", nullable = false)
    private long idparaParaRepo;

    @Column(name="valorminimo_pararepo", nullable = true)
    private Integer valorMinParaRepo;

    @Column(name="valormaximo_pararepo", nullable = true)
    private Integer valorMaximoParaRepo;

    @Column(nullable = true, length = 100, name = "valordefault_pararepo")
    private String valorDefaultParaRepo;

    @Column(nullable = true, length = 100, name = "tablaselect_pararepo")
    private String tablaSelectParaRepo;

    @Column(nullable = true, name = "fechaing_pararepo")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngParaRepo;

    @Column(nullable = false, name = "creapor_pararepo", length = 100)
    private String creaPorParaRepo;

    @Column(nullable = false, name = "estado_pararepo", columnDefinition = "boolean default true")
    private Boolean estadoParaRepo;

    @PrePersist
    public void prePersist() {
        this.fechaIngParaRepo = new Date();
    }

    public Long getIdParaRepo() {
        return idParaRepo;
    }

    public void setIdParaRepo(Long idParaRepo) {
        this.idParaRepo = idParaRepo;
    }

    public Integer getOrdenParaRepo() {
        return ordenParaRepo;
    }

    public void setOrdenParaRepo(Integer ordenParaRepo) {
        this.ordenParaRepo = ordenParaRepo;
    }

    public String getDescAlterParaRepo() {
        return descAlterParaRepo;
    }

    public void setDescAlterParaRepo(String descAlterParaRepo) {
        this.descAlterParaRepo = descAlterParaRepo;
    }

    public long getIdrepoParaRepo() {
        return idrepoParaRepo;
    }

    public void setIdrepoParaRepo(long idrepoParaRepo) {
        this.idrepoParaRepo = idrepoParaRepo;
    }

    public long getIdparaParaRepo() {
        return idparaParaRepo;
    }

    public void setIdparaParaRepo(long idparaParaRepo) {
        this.idparaParaRepo = idparaParaRepo;
    }

    public Date getFechaIngParaRepo() {
        return fechaIngParaRepo;
    }

    public void setFechaIngParaRepo(Date fechaIngParaRepo) {
        this.fechaIngParaRepo = fechaIngParaRepo;
    }

    public String getCreaPorParaRepo() {
        return creaPorParaRepo;
    }

    public void setCreaPorParaRepo(String creaPorParaRepo) {
        this.creaPorParaRepo = creaPorParaRepo;
    }

    public Boolean getEstadoParaRepo() {
        return estadoParaRepo;
    }

    public void setEstadoParaRepo(Boolean estadoParaRepo) {
        this.estadoParaRepo = estadoParaRepo;
    }

    private static final long serialVersionUID = 1L;
}
