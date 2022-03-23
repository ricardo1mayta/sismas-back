package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_personalpuesto")
public class PersonalPuesto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perpuest", nullable = false, unique = true)
    private Long idPerpuest;

    @Column(name = "id_obra_perpuest", nullable = false, length = 6)
    private String idObraPerpuest;

    @JsonIgnoreProperties(value = {"idPersonalPerpuest","idPersonalPercargo", "idPersonalPerconv", "PersonalContrato", "personalDependiente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal_perpuest", foreignKey = @ForeignKey(name = "fk_puesto_x_personal"))
    private Personal idPersonalPerpuest;

    @Column(nullable = false, name = "id_puesto_perpuest")
    private Long idPuestoPerpuest;

    @JsonIgnoreProperties(value = {"idPervilaPerpuest","idPervilaPercargo", "idPervilaPerconv","idPervilaPercont","idPervilaPerdesv", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_pervila_perpuest", foreignKey = @ForeignKey(name = "fk_puesto_x_vidalaboral"))
    private PersonalVidaLaboral idPervilaPerpuest;

    @Column(nullable = false, name = "id_area_perpuest")
    private Integer idAreaPerpuest;

    @Column(nullable = false, name = "id_tiponivelplanilla_perpuest")
    private Integer idTipoNivelPlanillaPerpuest;

    @Column(nullable = false, name = "id_puesto_t_perpuest")
    private Long idPuestoTPerpuest;

    @Column(nullable = false, name = "flgpuestodirec_perpuest", columnDefinition = "boolean default false")
    private Boolean flgPuestoDirePerpuest;

    @Column(nullable = false, name = "flgpuestoconfi_perpuest", columnDefinition = "boolean default false")
    private Boolean flgPuestoConfiPerpuest;

    @Column(nullable = false, name = "flgpuestonofiscal_perpuest", columnDefinition = "boolean default false")
    private Boolean flgPuestoNofilcalPerpuest;

    @Column(nullable = false, name = "flgpuestonoaplica_perpuest", columnDefinition = "boolean default false")
    private Boolean flgPuestoNoAplicaPerpuest;

    @Column(name = "observaciones_perpuest", nullable = true, length = 500)
    private String observacionesPerpuest;

    @Column(nullable = true, name = "fechaini_perpuest")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPerpuest;

    @Column(nullable = true, name = "fechafin_perpuest")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPerpuest;

    @Column(nullable = false, name = "estado_perpuest", columnDefinition = "boolean default true")
    private Boolean estadoPerpuest;

    @Column(nullable = true, name = "bonificacion_puesto_perpuest")
    private Double bonifCargoPerpuest;

    @Column(nullable = false, name = "fechaing_perpuest")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerpuest;

    @Column(nullable = false, name = "creapor_perpuest", length = 100)
    private String creaPorPerpuest;

    @Column(nullable = true, name = "fechamodi_perpuest")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerpuest;

    @Column(nullable = true, name = "modipor_perpuest", length = 100)
    private String modiPorPerpuest;

    @PrePersist
    public void prePersist() {
        this.fechaIngPerpuest = new Date();
    }




    public Long getIdPerpuest() {
        return idPerpuest;
    }

    public void setIdPerpuest(Long idPerpuest) {
        this.idPerpuest = idPerpuest;
    }

    public String getIdObraPerpuest() {
        return idObraPerpuest;
    }

    public void setIdObraPerpuest(String idObraPerpuest) {
        this.idObraPerpuest = idObraPerpuest;
    }

    public Personal getIdPersonalPerpuest() {
        return idPersonalPerpuest;
    }

    public void setIdPersonalPerpuest(Personal idPersonalPerpuest) {
        this.idPersonalPerpuest = idPersonalPerpuest;
    }

    public Long getIdPuestoPerpuest() {
        return idPuestoPerpuest;
    }

    public void setIdPuestoPerpuest(Long idPuestoPerpuest) {
        this.idPuestoPerpuest = idPuestoPerpuest;
    }

    public PersonalVidaLaboral getIdPervilaPerpuest() {
        return idPervilaPerpuest;
    }

    public void setIdPervilaPerpuest(PersonalVidaLaboral idPervilaPerpuest) {
        this.idPervilaPerpuest = idPervilaPerpuest;
    }

    public Integer getIdAreaPerpuest() {
        return idAreaPerpuest;
    }

    public void setIdAreaPerpuest(Integer idAreaPerpuest) {
        this.idAreaPerpuest = idAreaPerpuest;
    }

    public Integer getIdTipoNivelPlanillaPerpuest() {
        return idTipoNivelPlanillaPerpuest;
    }

    public void setIdTipoNivelPlanillaPerpuest(Integer idTipoNivelPlanillaPerpuest) {
        this.idTipoNivelPlanillaPerpuest = idTipoNivelPlanillaPerpuest;
    }

    public Long getIdPuestoTPerpuest() {
        return idPuestoTPerpuest;
    }

    public void setIdPuestoTPerpuest(Long idPuestoTPerpuest) {
        this.idPuestoTPerpuest = idPuestoTPerpuest;
    }

    public Boolean getFlgPuestoDirePerpuest() {
        return flgPuestoDirePerpuest;
    }

    public void setFlgPuestoDirePerpuest(Boolean flgPuestoDirePerpuest) {
        this.flgPuestoDirePerpuest = flgPuestoDirePerpuest;
    }

    public Boolean getFlgPuestoConfiPerpuest() {
        return flgPuestoConfiPerpuest;
    }

    public void setFlgPuestoConfiPerpuest(Boolean flgPuestoConfiPerpuest) {
        this.flgPuestoConfiPerpuest = flgPuestoConfiPerpuest;
    }

    public Boolean getFlgPuestoNofilcalPerpuest() {
        return flgPuestoNofilcalPerpuest;
    }

    public void setFlgPuestoNofilcalPerpuest(Boolean flgPuestoNofilcalPerpuest) {
        this.flgPuestoNofilcalPerpuest = flgPuestoNofilcalPerpuest;
    }

    public Boolean getFlgPuestoNoAplicaPerpuest() {
        return flgPuestoNoAplicaPerpuest;
    }

    public void setFlgPuestoNoAplicaPerpuest(Boolean flgPuestoNoAplicaPerpuest) {
        this.flgPuestoNoAplicaPerpuest = flgPuestoNoAplicaPerpuest;
    }

    public String getObservacionesPerpuest() {
        return observacionesPerpuest;
    }

    public void setObservacionesPerpuest(String observacionesPerpuest) {
        this.observacionesPerpuest = observacionesPerpuest;
    }

    public Date getFechaIniPerpuest() {
        return fechaIniPerpuest;
    }

    public void setFechaIniPerpuest(Date fechaIniPerpuest) {
        this.fechaIniPerpuest = fechaIniPerpuest;
    }

    public Date getFechaFinPerpuest() {
        return fechaFinPerpuest;
    }

    public void setFechaFinPerpuest(Date fechaFinPerpuest) {
        this.fechaFinPerpuest = fechaFinPerpuest;
    }

    public Boolean getEstadoPerpuest() {
        return estadoPerpuest;
    }

    public void setEstadoPerpuest(Boolean estadoPerpuest) {
        this.estadoPerpuest = estadoPerpuest;
    }

    public Double getBonifCargoPerpuest() {
        return bonifCargoPerpuest;
    }

    public void setBonifCargoPerpuest(Double bonifCargoPerpuest) {
        this.bonifCargoPerpuest = bonifCargoPerpuest;
    }

    public Date getFechaIngPerpuest() {
        return fechaIngPerpuest;
    }

    public void setFechaIngPerpuest(Date fechaIngPerpuest) {
        this.fechaIngPerpuest = fechaIngPerpuest;
    }

    public String getCreaPorPerpuest() {
        return creaPorPerpuest;
    }

    public void setCreaPorPerpuest(String creaPorPerpuest) {
        this.creaPorPerpuest = creaPorPerpuest;
    }

    public Date getFechaModiPerpuest() {
        return fechaModiPerpuest;
    }

    public void setFechaModiPerpuest(Date fechaModiPerpuest) {
        this.fechaModiPerpuest = fechaModiPerpuest;
    }

    public String getModiPorPerpuest() {
        return modiPorPerpuest;
    }

    public void setModiPorPerpuest(String modiPorPerpuest) {
        this.modiPorPerpuest = modiPorPerpuest;
    }

    private static final long serialVersionUID = 1L;



}
