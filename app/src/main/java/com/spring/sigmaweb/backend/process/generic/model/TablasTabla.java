package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="mg_codigos")
public class TablasTabla implements Serializable{
    @Id
    @Column(name="codigo_tab", nullable = false, unique = true)
    private Integer codigoTab;

    @Column(name="nombre_tipo_tab", nullable = false, length = 50)
    private String nombreTipoTab;

    @Column(name="tipo_tab", nullable = false)
    private Integer tipoTab;

    @Column(name="descrip_tab",length = 80, nullable = false)
    private String descripTab;

    @Column(name="descrip2_tab",length = 80, nullable = true)
    private String descrip2Tab;
/*
    @JsonIgnoreProperties({"estCivilPers","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estCivilPers", cascade = CascadeType.ALL)
    private List<Persona> personaEstCivil;

    @JsonIgnoreProperties({"estCivilPerDep","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estCivilPerDep", cascade = CascadeType.ALL)
    private List<PersonalDependiente> personalDepEstCivil;

    public TablasTabla() {
        this.personaEstCivil = new ArrayList<>();
        this.personalDepEstCivil = new ArrayList<>();
    }
*/
    public Integer getCodigoTab() {
        return codigoTab;
    }

    public void setCodigoTab(Integer codigoTab) {
        this.codigoTab = codigoTab;
    }

    public String getNombreTipoTab() {
        return nombreTipoTab;
    }

    public void setNombreTipoTab(String nombreTipoTab) {
        this.nombreTipoTab = nombreTipoTab;
    }

    public Integer getTipoTab() {
        return tipoTab;
    }

    public void setTipoTab(Integer tipoTab) {
        this.tipoTab = tipoTab;
    }

    public String getDescripTab() {
        return descripTab;
    }

    public void setDescripTab(String descripTab) {
        this.descripTab = descripTab;
    }

    public String getDescrip2Tab() {
        return descrip2Tab;
    }

    public void setDescrip2Tab(String descrip2Tab) {
        this.descrip2Tab = descrip2Tab;
    }

    private static final long serialVersionUID = 1L;
}
