package com.spring.sigmaweb.backend.process.matricula.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mx_formacion_academica")
public class Formacion implements Serializable {
    @Id
    @Column(name = "id_formacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idFormacion;

    @Column(name = "nombre_formacion", length = 30, nullable = false, unique = true)
    private String nombreFormacion;

    @Column(nullable = false, name = "fechacrea_formacion")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreaFormacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "formacionAcademico", cascade = CascadeType.ALL)
    private List<NivelAcademico> nivelAcademico;

    @PrePersist
    public void prePersist() {
        this.fechaCreaFormacion = new Date();
    }

    public Long getIdFormacion() {
        return idFormacion;
    }

    public void setIdFormacion(Long idFormacion) {
        this.idFormacion = idFormacion;
    }

    public String getNombreFormacion() {
        return nombreFormacion;
    }

    public void setNombreFormacion(String nombreFormacion) {
        this.nombreFormacion = nombreFormacion;
    }

    public Date getFechaCreaFormacion() {
        return fechaCreaFormacion;
    }

    public void setFechaCreaFormacion(Date fechaCreaFormacion) {
        this.fechaCreaFormacion = fechaCreaFormacion;
    }

    private static final long serialVersionUID = 1L;
}
