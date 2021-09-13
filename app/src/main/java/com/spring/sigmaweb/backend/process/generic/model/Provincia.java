package com.spring.sigmaweb.backend.process.generic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mg_provincias")
public class Provincia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prov", nullable = false, unique = true)
    private Long idProv;

    @JsonIgnoreProperties({"provinciasDepa","familiaDepart","padreDepart","madreDepart","alumnosDepa","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_depa",foreignKey = @ForeignKey(name="fk_provincia_departamento"))
    private Departamento departamento;

    @Column(name="nombre_prov", nullable = false, length = 50)
    private String nombreProv;

    @Column(name="creafecha_Prov", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaFechaProv;

    @PrePersist
    public void prePersist() {
        this.creaFechaProv = new Date();
    }

    @JsonIgnoreProperties({"provincia","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provincia", cascade = CascadeType.ALL)
    private List<Distrito> distritosProv;

    public Provincia() {
    /*this.alumnosProv=new ArrayList<>();
    this.familiaProvin=new ArrayList<>();
    this.padreProvi=new ArrayList<>();
    this.madreProvi=new ArrayList<>();
    this.otrosProv=new ArrayList<>();*/
        this.distritosProv =new ArrayList<>();
    }
    /*
        @JsonIgnoreProperties({"provincias","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "provincias", cascade = CascadeType.ALL)
        private List<Alumno> alumnosProv;

        @JsonIgnoreProperties({"provinciaFami","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "provinciaFami", cascade = CascadeType.ALL)
        private List<Familia> familiaProvin;

        @JsonIgnoreProperties({"idProvPadre","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProvPadre", cascade = CascadeType.ALL)
        private List<Familia> padreProvi;

        @JsonIgnoreProperties({"idDistMadre","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "idDistMadre", cascade = CascadeType.ALL)
        private List<Familia> madreProvi;

        @JsonIgnoreProperties({"idProvOtro","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "idProvOtro", cascade = CascadeType.ALL)
        private List<Familia_otros> otrosProv;
    */

    public Long getIdProv() {
        return idProv;
    }

    public void setIdProv(Long idProv) {
        this.idProv = idProv;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public Date getCreaFechaProv() {
        return creaFechaProv;
    }

    public void setCreaFechaProv(Date creaFechaProv) {
        this.creaFechaProv = creaFechaProv;
    }

    private static final long serialVersionUID = 1L;
}
