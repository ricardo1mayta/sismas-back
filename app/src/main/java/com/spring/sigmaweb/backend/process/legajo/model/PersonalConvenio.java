package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_personalconvenios")
public class PersonalConvenio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perconv", nullable = false, unique = true)
    private Long idPerConv;

    @Column(name = "id_obra_perconv", nullable = false, length = 6)
    private String idObraPerconv;

    @JsonIgnoreProperties(value = { "idPersonalPerconv", "PersonalContrato", "personalDependiente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal_perconv", foreignKey = @ForeignKey(name = "fk_convenio_personal"))
    private Personal idPersonalPerconv;

    @JsonIgnoreProperties(value = {"idPervilaPercargo", "idPervilaPerconv","idPervilaPercont","idPervilaPerdesv", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_pervila_perconv", foreignKey = @ForeignKey(name = "fk_convenio_vidalaboral"))
    private PersonalVidaLaboral idPervilaPerconv;

    @Column(nullable = true, name = "id_tipo_perconv")
    private Integer idTipoPerconv;

    @Column(nullable = false, name = "fechaini_perconv")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPerconv;

    @Column(nullable = true, name = "fechafin_perconv")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPerconv;

    @Column(nullable = true, length = 500, name = "observacion_perconv")
    private String observacionesPerconv;

    @Column(nullable = false, length = 10, name = "estado_perconv")
    private String estadoPerconv;

    @Column(nullable = true, name = "fecha_termino_perconv")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminoPerconv;

    @Column(nullable = false, name = "fechaing_perconv")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerconv;

    @Column(nullable = false, name = "creapor_perconv", length = 100)
    private String creaPorPerconv;

    @Column(nullable = true, name = "fechamodi_perconv")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerconv;

    @Column(nullable = true, name = "modipor_perconv", length = 100)
    private String modiPorPerconv;

    @PrePersist
    public void prePersist() {
        this.fechaIngPerconv = new Date();
    }

    public Long getIdPerConv() {
        return idPerConv;
    }

    public void setIdPerConv(Long idPerConv) {
        this.idPerConv = idPerConv;
    }

    public String getIdObraPerconv() {
        return idObraPerconv;
    }

    public void setIdObraPerconv(String idObraPerconv) {
        this.idObraPerconv = idObraPerconv;
    }

    public Personal getIdPersonalPerconv() {
        return idPersonalPerconv;
    }

    public void setIdPersonalPerconv(Personal idPersonalPerconv) {
        this.idPersonalPerconv = idPersonalPerconv;
    }

    public Integer getIdTipoPerconv() {
        return idTipoPerconv;
    }

    public void setIdTipoPerconv(Integer idTipoPerconv) {
        this.idTipoPerconv = idTipoPerconv;
    }

    public Date getFechaIniPerconv() {
        return fechaIniPerconv;
    }

    public void setFechaIniPerconv(Date fechaIniPerconv) {
        this.fechaIniPerconv = fechaIniPerconv;
    }

    public Date getFechaFinPerconv() {
        return fechaFinPerconv;
    }

    public void setFechaFinPerconv(Date fechaFinPerconv) {
        this.fechaFinPerconv = fechaFinPerconv;
    }

    public String getObservacionesPerconv() {
        return observacionesPerconv;
    }

    public void setObservacionesPerconv(String observacionesPerconv) {
        this.observacionesPerconv = observacionesPerconv;
    }

    public String getEstadoPerconv() {
        return estadoPerconv;
    }

    public void setEstadoPerconv(String estadoPerconv) {
        this.estadoPerconv = estadoPerconv;
    }

    public Date getFechaTerminoPerconv() {
        return fechaTerminoPerconv;
    }

    public void setFechaTerminoPerconv(Date fechaTerminoPerconv) {
        this.fechaTerminoPerconv = fechaTerminoPerconv;
    }

    public Date getFechaIngPerconv() {
        return fechaIngPerconv;
    }

    public void setFechaIngPerconv(Date fechaIngPerconv) {
        this.fechaIngPerconv = fechaIngPerconv;
    }

    public String getCreaPorPerconv() {
        return creaPorPerconv;
    }

    public void setCreaPorPerconv(String creaPorPerconv) {
        this.creaPorPerconv = creaPorPerconv;
    }

    public Date getFechaModiPerconv() {
        return fechaModiPerconv;
    }

    public void setFechaModiPerconv(Date fechaModiPerconv) {
        this.fechaModiPerconv = fechaModiPerconv;
    }

    public String getModiPorPerconv() {
        return modiPorPerconv;
    }

    public void setModiPorPerconv(String modiPorPerconv) {
        this.modiPorPerconv = modiPorPerconv;
    }

    public PersonalVidaLaboral getIdPervilaPerconv() {
        return idPervilaPerconv;
    }

    public void setIdPervilaPerconv(PersonalVidaLaboral idPervilaPerconv) {
        this.idPervilaPerconv = idPervilaPerconv;
    }

    private static final long serialVersionUID = 1L;
}


