package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mg_departamentos")
public class Departamento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_depa",nullable = false)
    private Long idDepa;

    @Column(name="nombre_depa", nullable = false, unique = true, length = 50)
    private String nombreDepa;

    @Column(name="creafecha_Depa", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaFechaDepa;

    @PrePersist
    public void prePersist() {
        this.creaFechaDepa = new Date();
    }

    @JsonIgnoreProperties({"departamento","departamentoFami","iddepaPadre","iddepaMadre","iddepaOtro","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Provincia> provinciasDepa;

    /*
    @JsonIgnoreProperties({"departamentos","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentos", cascade = CascadeType.ALL)
    private List<Alumno> alumnosDepa;

    @JsonIgnoreProperties({"departamento","iddepaPadre","iddepaMadre","iddepaOtro","departamentoFami","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentoFami", cascade = CascadeType.ALL)
    private List<Familia> familiaDepart;

    @JsonIgnoreProperties({"departamento","departamentoFami","iddepaPadre","iddepaMadre","iddepaOtro","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "iddepaPadre", cascade = CascadeType.ALL)
    private List<Familia> padreDepart;

    @JsonIgnoreProperties({"departamento","departamentoFami","iddepaPadre","iddepaMadre","iddepaOtro","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "iddepaMadre", cascade = CascadeType.ALL)
    private List<Familia> madreDepart;

    @JsonIgnoreProperties({"departamento","departamentoFami","iddepaPadre","iddepaMadre","iddepaOtro","hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "iddepaOtro", cascade = CascadeType.ALL)
    private List<Familia_otros> otroDepart;
*/

    public Departamento() {
        /*this.alumnosDepa = new ArrayList<>();
        this.familiaDepart = new ArrayList<>();
        this.padreDepart = new ArrayList<>();
        this.madreDepart = new ArrayList<>();
        this.otroDepart = new ArrayList<>();*/
        this.provinciasDepa = new ArrayList<>();
    }

    public Long getIdDepa() {
        return idDepa;
    }

    public void setIdDepa(Long idDepa) {
        this.idDepa = idDepa;
    }

    public String getNombreDepa() {
        return nombreDepa;
    }

    public void setNombreDepa(String nombreDepa) {
        this.nombreDepa = nombreDepa;
    }

    public Date getCreaFechaDepa() {
        return creaFechaDepa;
    }

    public void setCreaFechaDepa(Date creaFechaDepa) {
        this.creaFechaDepa = creaFechaDepa;
    }

    private static final long serialVersionUID = 1L;



}
