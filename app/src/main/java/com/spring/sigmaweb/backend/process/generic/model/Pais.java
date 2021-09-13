package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mg_paises")
public class Pais implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pais", nullable = false)
    private Long idpais;

    @Column(name="nombre_Pais", nullable = false, unique = true,length = 50)
    private String nombrePais;

    @Column(name="nacionalidad_Pais", nullable = false, unique = true,length = 80)
    private String nacionalidad;

    @Column(nullable = false, name = "fechacrea_pais")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreaPais;

    @PrePersist
    public void prePersist() {
        this.fechaCreaPais = new Date();
    }

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaCreaPais() {
        return fechaCreaPais;
    }

    public void setFechaCreaPais(Date fechaCreaPais) {
        this.fechaCreaPais = fechaCreaPais;
    }

    private static final long serialVersionUID = 1L;
}
