package com.spring.sigmaweb.backend.process.matricula.model;

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
@Table(name = "mx_nivel_academico")
public class NivelAcademico implements Serializable {
    @Id
    @Column(name = "id_nivel", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNivel;

    @JsonIgnoreProperties({"gradoacademico","alumnos","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formacion",foreignKey = @ForeignKey(name="fk_nivel_formacion"))
    private Formacion formacionAcademico;

    @Column(name = "nombre_nivel", length = 30, nullable = false, unique = true)
    private String nombreNvel;

    @Column(nullable = false, name = "fechacrea_nivel")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreaNivel;

    @PrePersist
    public void prePersist() {
        this.fechaCreaNivel = new Date();
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nivelAcademico", cascade = CascadeType.ALL)
    private List<GradoAcademico> gradoacademico;
    /*
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "nivelAcademicoAlum", cascade = CascadeType.ALL)
        private List<Alumno> alumnos;
    */
    public NivelAcademico() {
        this.gradoacademico= new ArrayList<>();
        // this.alumnos=new ArrayList<>();
    }

    private static final long serialVersionUID = 1L;

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombreNvel() {
        return nombreNvel;
    }

    public void setNombreNvel(String nombreNvel) {
        this.nombreNvel = nombreNvel;
    }

    public Date getFechaCreaNivel() {
        return fechaCreaNivel;
    }

    public void setFechaCreaNivel(Date fechaCreaNivel) {
        this.fechaCreaNivel = fechaCreaNivel;
    }

    public List<GradoAcademico> getGradoacademico() {
        return gradoacademico;
    }

    public void setGradoacademico(List<GradoAcademico> gradoacademico) {
        this.gradoacademico = gradoacademico;
    }

    public Formacion getFormacionAcademico() {
        return formacionAcademico;
    }

    public void setFormacionAcademico(Formacion formacionAcademico) {
        this.formacionAcademico = formacionAcademico;
    }

}
