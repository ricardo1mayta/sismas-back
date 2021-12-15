package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mo_personalcontratos")
public class PersonalContrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_percont", nullable = false, unique = true)
    private Long idPerCont;

    @Column(name = "id_obra_percont", nullable = false, length = 6)
    private String idObraPercont;

    @JsonIgnoreProperties(value = { "PersonalContrato", "personalDependiente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal_percont", foreignKey = @ForeignKey(name = "fk_contrato_personal"))
    private Personal idPersonalPercont;

    @Column(nullable = true, name = "id_tipo_percont")
    private Integer idTipoPercont;

    @Column(nullable = true, length = 500, name = "url_documento_percont")
    private String urlDocumentoPercont;

    @Column(nullable = false, name = "fechaini_percont")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPercont;

    @Column(nullable = true, name = "fechafin_percont")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPercont;

    @Column(nullable = true, length = 500, name = "observacion_percont")
    private String observacionesPercont;

    @Column(nullable = false, length = 10, name = "estado_percont")
    private String estadoPercont;

    @Column(nullable = true, name = "fecha_termino_percont")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTerminoPercont;

    @Column(nullable = false, name = "fechaing_percont")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPercont;

    @Column(nullable = false, name = "creapor_percont", length = 100)
    private String creaPorPercont;

    @Column(nullable = true, name = "fechamodi_per")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPercont;

    @Column(nullable = true, name = "modipor_percont", length = 100)
    private String modiPorPercont;

    @JsonIgnoreProperties({ "idPersonalContPerjorn", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPersonalContPerjorn", cascade = CascadeType.ALL)
    private List<PersonalContratoJornada> personaljornada;

    @PrePersist
    public void prePersist() {
        this.fechaIngPercont = new Date();

    }

    public Long getIdPerCont() {
        return idPerCont;
    }

    public void setIdPerCont(Long idPerCont) {
        this.idPerCont = idPerCont;
    }

    public String getIdObraPercont() {
        return idObraPercont;
    }

    public void setIdObraPercont(String idObraPercont) {
        this.idObraPercont = idObraPercont;
    }

    public Personal getIdPersonalPercont() {
        return idPersonalPercont;
    }

    public void setIdPersonalPercont(Personal idPersonalPercont) {
        this.idPersonalPercont = idPersonalPercont;
    }

    public Integer getIdTipoPercont() {
        return idTipoPercont;
    }

    public void setIdTipoPercont(Integer idTipoPercont) {
        this.idTipoPercont = idTipoPercont;
    }

    public String getUrlDocumentoPercont() {
        return urlDocumentoPercont;
    }

    public void setUrlDocumentoPercont(String urlDocumentoPercont) {
        this.urlDocumentoPercont = urlDocumentoPercont;
    }

    public Date getFechaIniPercont() {
        return fechaIniPercont;
    }

    public void setFechaIniPercont(Date fechaIniPercont) {
        this.fechaIniPercont = fechaIniPercont;
    }

    public Date getFechaFinPercont() {
        return fechaFinPercont;
    }

    public void setFechaFinPercont(Date fechaFinPercont) {
        this.fechaFinPercont = fechaFinPercont;
    }

    public String getObservacionesPercont() {
        return observacionesPercont;
    }

    public void setObservacionesPercont(String observacionesPercont) {
        this.observacionesPercont = observacionesPercont;
    }

    public Date getFechaIngPercont() {
        return fechaIngPercont;
    }

    public void setFechaIngPercont(Date fechaIngPercont) {
        this.fechaIngPercont = fechaIngPercont;
    }

    public String getCreaPorPercont() {
        return creaPorPercont;
    }

    public void setCreaPorPercont(String creaPorPercont) {
        this.creaPorPercont = creaPorPercont;
    }

    public Date getFechaModiPercont() {
        return fechaModiPercont;
    }

    public void setFechaModiPercont(Date fechaModiPercont) {
        this.fechaModiPercont = fechaModiPercont;
    }

    public String getModiPorPercont() {
        return modiPorPercont;
    }

    public void setModiPorPercont(String modiPorPercont) {
        this.modiPorPercont = modiPorPercont;
    }

    public String getEstadoPercont() {
        return estadoPercont;
    }

    public void setEstadoPercont(String estadoPercont) {
        this.estadoPercont = estadoPercont;
    }

    public Date getFechaTerminoPercont() {
        return fechaTerminoPercont;
    }

    public void setFechaTerminoPercont(Date fechaTerminoPercont) {
        this.fechaTerminoPercont = fechaTerminoPercont;
    }

    private static final long serialVersionUID = 1L;
}
