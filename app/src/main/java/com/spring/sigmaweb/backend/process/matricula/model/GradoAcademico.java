package com.spring.sigmaweb.backend.process.matricula.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mx_grado_academico")
public class GradoAcademico implements Serializable {
    @Id
    @Column(name = "id_grado", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrado;

    @JsonIgnoreProperties({"gradoacademico","alumnos","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nivel",foreignKey = @ForeignKey(name="fk_grado_nivel"))
    private NivelAcademico nivelAcademico;

    @Column(name = "nombre_grado", length = 30, nullable = false, unique = true)
    private String nombreGrado;

    @Column(name = "orden_grado", nullable = false, unique = true)
    private Integer ordenGrado;

    @Column(nullable = false, name = "fechacrea_grado")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreaNivel;

    @PrePersist
    public void prePersist() {
        this.fechaCreaNivel = new Date();
    }
    /*
        @JsonIgnoreProperties({"gradoAcademicoAlum","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "gradoAcademicoAlum", cascade = CascadeType.ALL)
        private List<Alumno> alumnos;

        public GradoAcademico() {
            this.alumnos=new ArrayList<>();
        }
    */
    private static final long serialVersionUID = 1L;

    public Long getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Long idGrado) {
        this.idGrado = idGrado;
    }

    public NivelAcademico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(NivelAcademico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public Integer getOrdenGrado() {
        return ordenGrado;
    }

    public void setOrdenGrado(Integer ordenGrado) {
        this.ordenGrado = ordenGrado;
    }

    public Date getFechaCreaNivel() {
        return fechaCreaNivel;
    }

    public void setFechaCreaNivel(Date fechaCreaNivel) {
        this.fechaCreaNivel = fechaCreaNivel;
    }
}
