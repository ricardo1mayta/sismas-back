package com.spring.sigmaweb.backend.process.legajo.model;
import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.Obra;

@Entity
@Table(name = "mo_personal_historico")
public class PersonalHistorico implements Serializable {
    @Id
    @Column(name = "id_personal_hist", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonalHist;

    @JsonIgnoreProperties(value = {"obraHist","obraRolItem","alumnos","familia","obradocumentos","usuarios","personal","hibernateLazyInitializer","handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_obra", foreignKey = @ForeignKey(name = "fk_personal_hist_obra"))
    private Obra obraHist;

    @JsonIgnoreProperties(value = { "personalDependiente", "hibernateLazyInitializer",
            "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal", foreignKey = @ForeignKey(name = "fk_personal_hist_personal"))
    private Personal personalHist;

    @Column(name = "tipo_hist", nullable = false, length = 6)
    private String tipoHist;

    @Column(name = "direccion_hist", nullable = true, length = 150)
    private String direccionHist;

    @Column(name = "tipo_estcivil_hist", nullable = true)
    private Integer tipoEstCivilHist;

    @Column(nullable = true, name = "fechacamb_ec_hist")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambECHist;

    @Column(nullable = false, name = "creapor_hist", length = 30)
    private String creaPorHist;

    @Column(nullable = false, name = "fechaing_hist")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngHist;

    @Column(nullable = true, name = "fechamodi_hist")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiHist;

    @Column(nullable = true, name = "modipor_Hist", length = 30)
    private String modiPorHist;

    @PrePersist
    public void prePersist() {
        this.fechaIngHist= new Date();
    }

    private static final long serialVersionUID = 1L;

    public Long getIdPersonalHist() {
        return idPersonalHist;
    }

    public void setIdPersonalHist(Long idPersonalHist) {
        this.idPersonalHist = idPersonalHist;
    }

    public Obra getObraHist() {
        return obraHist;
    }

    public void setObraHist(Obra obraHist) {
        this.obraHist = obraHist;
    }

    public Personal getPersonalHist() {
        return personalHist;
    }

    public void setPersonalHist(Personal personalHist) {
        this.personalHist = personalHist;
    }

    public String getTipoHist() {
        return tipoHist;
    }

    public void setTipoHist(String tipoHist) {
        this.tipoHist = tipoHist;
    }

    public String getDireccionHist() {
        return direccionHist;
    }

    public void setDireccionHist(String direccionHist) {
        this.direccionHist = direccionHist;
    }

    public Integer getTipoEstCivilHist() {
        return tipoEstCivilHist;
    }

    public void setTipoEstCivilHist(Integer tipoEstCivilHist) {
        this.tipoEstCivilHist = tipoEstCivilHist;
    }

    public String getCreaPorHist() {
        return creaPorHist;
    }

    public void setCreaPorHist(String creaPorHist) {
        this.creaPorHist = creaPorHist;
    }

    public Date getFechaIngHist() {
        return fechaIngHist;
    }

    public void setFechaIngHist(Date fechaIngHist) {
        this.fechaIngHist = fechaIngHist;
    }

    public Date getFechaModiHist() {
        return fechaModiHist;
    }

    public void setFechaModiHist(Date fechaModiHist) {
        this.fechaModiHist = fechaModiHist;
    }

    public String getModiPorHist() {
        return modiPorHist;
    }

    public void setModiPorHist(String modiPorHist) {
        this.modiPorHist = modiPorHist;
    }

    public Date getFechaCambECHist() {
        return fechaCambECHist;
    }

    public void setFechaCambECHist(Date fechaCambECHist) {
        this.fechaCambECHist = fechaCambECHist;
    }
}
