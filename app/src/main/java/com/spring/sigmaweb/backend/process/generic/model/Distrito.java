package com.spring.sigmaweb.backend.process.generic.model;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mg_distritos")
public class Distrito implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dist", nullable = false, unique = true)
    private Long idDist;
/*
    @JsonIgnoreProperties({ "distritosProv",
            "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prov", foreignKey = @ForeignKey(name = "fk_distrito_provincia"))
    */
    @Column(name = "id_prov", nullable = false)
    private Long provincia;

    @Column(name = "nombre_dist", nullable = false, length = 50)
    private String nombreDist;

    @Column(name = "creafecha_dist", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaFechaDist;

    public Long getIdDist() {
        return idDist;
    }

    public void setIdDist(Long idDist) {
        this.idDist = idDist;
    }

    public Long getProvincia() {
        return provincia;
    }

    public void setProvincia(Long provincia) {
        this.provincia = provincia;
    }

    public String getNombreDist() {
        return nombreDist;
    }

    public void setNombreDist(String nombreDist) {
        this.nombreDist = nombreDist;
    }

    public Date getCreaFechaDist() {
        return creaFechaDist;
    }

    public void setCreaFechaDist(Date creaFechaDist) {
        this.creaFechaDist = creaFechaDist;
    }

    private static final long serialVersionUID = 1L;
}
