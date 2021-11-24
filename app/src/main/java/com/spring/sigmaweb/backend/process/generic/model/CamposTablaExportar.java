package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mg_campostablaexport")
public class CamposTablaExportar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_campo",nullable = false)
    private Long idCampo;

    @Column(name="nombre_vista_campo", nullable = false, unique = true, length = 100)
    private String nombreVistaCampo;

    @Column(name="nombre_column_campo", nullable = false, length = 500)
    private String nombreColumnCampo;

    @Column(name="inner_tabla_campo", nullable = false, length = 200)
    private String innerTablaCampo;

    @Column(name="id_grupo", nullable = false, length = 50)
    private String idGrupoCampo;

    @Column(name="flg_estado", nullable = false, columnDefinition = "boolean default true")
    private Boolean estadoCampo;

    @Column(name="fechaing_repo", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creafechaCampo;

    @Column(name="creapor_repo", nullable = false, length = 100)
    private String creaPorCampo;

    public CamposTablaExportar(){

    }

    @PrePersist
    public void prePersist() {
        this.creafechaCampo = new Date();
    }

    public Long getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(Long idCampo) {
        this.idCampo = idCampo;
    }

    public String getNombreVistaCampo() {
        return nombreVistaCampo;
    }

    public void setNombreVistaCampo(String nombreVistaCampo) {
        this.nombreVistaCampo = nombreVistaCampo;
    }

    public String getNombreColumnCampo() {
        return nombreColumnCampo;
    }

    public void setNombreColumnCampo(String nombreColumnCampo) {
        this.nombreColumnCampo = nombreColumnCampo;
    }

    public String getInnerTablaCampo() {
        return innerTablaCampo;
    }

    public void setInnerTablaCampo(String innerTablaCampo) {
        this.innerTablaCampo = innerTablaCampo;
    }

    public String getIdGrupoCampo() {
        return idGrupoCampo;
    }

    public void setIdGrupoCampo(String idGrupoCampo) {
        this.idGrupoCampo = idGrupoCampo;
    }

    public Boolean getEstadoCampo() {
        return estadoCampo;
    }

    public void setEstadoCampo(Boolean estadoCampo) {
        this.estadoCampo = estadoCampo;
    }

    public Date getCreafechaCampo() {
        return creafechaCampo;
    }

    public void setCreafechaCampo(Date creafechaCampo) {
        this.creafechaCampo = creafechaCampo;
    }

    public String getCreaPorCampo() {
        return creaPorCampo;
    }

    public void setCreaPorCampo(String creaPorCampo) {
        this.creaPorCampo = creaPorCampo;
    }
}
