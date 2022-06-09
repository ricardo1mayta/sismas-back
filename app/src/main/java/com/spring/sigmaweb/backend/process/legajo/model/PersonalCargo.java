package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_personalcargo")
public class PersonalCargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_percargo", nullable = false, unique = true)
    private Long idPercargo;

    @Column(name = "id_obra_percargo", nullable = false, length = 6)
    private String idObraPercargo;

    @JsonIgnoreProperties(value = {"idPersonalPercargo", "idPersonalPerconv", "PersonalContrato", "personalDependiente", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal_percargo", foreignKey = @ForeignKey(name = "fk_cargo_x_personal"))
    private Personal idPersonalPercargo;

    @Column(nullable = false, name = "id_cargo_percargo")
    private Long idCargoPercargo;

    @JsonIgnoreProperties(value = {"idPervilaPercargo", "idPervilaPerconv","idPervilaPercont","idPervilaPerdesv", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_pervila_percargo", foreignKey = @ForeignKey(name = "fk_cargo_x_vidalaboral"))
    private PersonalVidaLaboral idPervilaPercargo;

    @Column(nullable = false, name = "id_area_percargo")
    private Integer idAreaPercargo; //private Integer idAreaPercont;

    @Column(nullable = true, name = "id_tiponivelplanilla_percargo")
    private Integer idTipoNivelPlanillaPercargo;

    @Column(nullable = true, name = "id_puesto_percargo")
    private Integer idPuestoPercargo;

    @Column(nullable = false, name = "flgcargodirec_percargo", columnDefinition = "boolean default false")
    private Boolean flgCargoDirePercargo;

    @Column(nullable = false, name = "flgcargoconfi_percargo", columnDefinition = "boolean default false")
    private Boolean flgCargoConfiPercargo;

    @Column(nullable = false, name = "flgcargonofiscal_percargo", columnDefinition = "boolean default false")
    private Boolean flgCargoNofilcalPercargo;

    @Column(nullable = false, name = "flgcargonoaplica_percargo", columnDefinition = "boolean default false")
    private Boolean flgCargoNoAplicaPercargo;

    @Column(name = "observaciones_percargo", nullable = true, length = 500)
    private String observacionesPercargo;

    @Column(nullable = true, name = "fechaini_percargo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIniPercargo;

    @Column(nullable = true, name = "fechafin_percargo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinPercargo;

    @Column(nullable = false, name = "estado_percargo", columnDefinition = "boolean default true")
    private Boolean estadoPercargo;

    @Column(nullable = true, name = "bonificacion_cargo_percargo")
    private Double bonifCargoPercargo;

    @Column(nullable = true, name = "bonificacion_cargoest_percargo")
    private Double bonifCargoEstPercargo;

    @Column(nullable = false, name = "fechaing_percargo")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPercargo;

    @Column(nullable = false, name = "creapor_percargo", length = 100)
    private String creaPorPercargo;

    @Column(nullable = true, name = "fechamodi_percargo")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPercargo;

    @Column(nullable = true, name = "modipor_percargo", length = 100)
    private String modiPorPercargo;

    @PrePersist
    public void prePersist() {
        this.fechaIngPercargo = new Date();
    }

    public Long getIdPercargo() {
        return idPercargo;
    }

    public void setIdPercargo(Long idPercargo) {
        this.idPercargo = idPercargo;
    }

    public String getIdObraPercargo() {
        return idObraPercargo;
    }

    public void setIdObraPercargo(String idObraPercargo) {
        this.idObraPercargo = idObraPercargo;
    }

    public Personal getIdPersonalPercargo() {
        return idPersonalPercargo;
    }

    public void setIdPersonalPercargo(Personal idPersonalPercargo) {
        this.idPersonalPercargo = idPersonalPercargo;
    }

    public Long getIdCargoPercargo() {
        return idCargoPercargo;
    }

    public void setIdCargoPercargo(Long idCargoPercargo) {
        this.idCargoPercargo = idCargoPercargo;
    }

    public Integer getIdAreaPercargo() {
        return idAreaPercargo;
    }

    public void setIdAreaPercargo(Integer idAreaPercargo) {
        this.idAreaPercargo = idAreaPercargo;
    }

    public Integer getIdTipoNivelPlanillaPercargo() {
        return idTipoNivelPlanillaPercargo;
    }

    public void setIdTipoNivelPlanillaPercargo(Integer idTipoNivelPlanillaPercargo) {
        this.idTipoNivelPlanillaPercargo = idTipoNivelPlanillaPercargo;
    }

    public Integer getIdPuestoPercargo() {
        return idPuestoPercargo;
    }

    public void setIdPuestoPercargo(Integer idPuestoPercargo) {
        this.idPuestoPercargo = idPuestoPercargo;
    }

    public Boolean getFlgCargoDirePercargo() {
        return flgCargoDirePercargo;
    }

    public void setFlgCargoDirePercargo(Boolean flgCargoDirePercargo) {
        this.flgCargoDirePercargo = flgCargoDirePercargo;
    }

    public Boolean getFlgCargoConfiPercargo() {
        return flgCargoConfiPercargo;
    }

    public void setFlgCargoConfiPercargo(Boolean flgCargoConfiPercargo) {
        this.flgCargoConfiPercargo = flgCargoConfiPercargo;
    }

    public Boolean getFlgCargoNofilcalPercargo() {
        return flgCargoNofilcalPercargo;
    }

    public void setFlgCargoNofilcalPercargo(Boolean flgCargoNofilcalPercargo) {
        this.flgCargoNofilcalPercargo = flgCargoNofilcalPercargo;
    }

    public Boolean getFlgCargoNoAplicaPercargo() {
        return flgCargoNoAplicaPercargo;
    }

    public void setFlgCargoNoAplicaPercargo(Boolean flgCargoNoAplicaPercargo) {
        this.flgCargoNoAplicaPercargo = flgCargoNoAplicaPercargo;
    }

    public String getObservacionesPercargo() {
        return observacionesPercargo;
    }

    public void setObservacionesPercargo(String observacionesPercargo) {
        this.observacionesPercargo = observacionesPercargo;
    }

    public Date getFechaIniPercargo() {
        return fechaIniPercargo;
    }

    public void setFechaIniPercargo(Date fechaIniPercargo) {
        this.fechaIniPercargo = fechaIniPercargo;
    }

    public Date getFechaFinPercargo() {
        return fechaFinPercargo;
    }

    public void setFechaFinPercargo(Date fechaFinPercargo) {
        this.fechaFinPercargo = fechaFinPercargo;
    }

    public Boolean getEstadoPercargo() {
        return estadoPercargo;
    }

    public void setEstadoPercargo(Boolean estadoPercargo) {
        this.estadoPercargo = estadoPercargo;
    }

    public Double getBonifCargoPercargo() {
        return bonifCargoPercargo;
    }

    public void setBonifCargoPercargo(Double bonifCargoPercargo) {
        this.bonifCargoPercargo = bonifCargoPercargo;
    }

    public Double getBonifCargoEstPercargo() {
        return bonifCargoEstPercargo;
    }

    public void setBonifCargoEstPercargo(Double bonifCargoEstPercargo) {
        this.bonifCargoEstPercargo = bonifCargoEstPercargo;
    }

    public Date getFechaIngPercargo() {
        return fechaIngPercargo;
    }

    public void setFechaIngPercargo(Date fechaIngPercargo) {
        this.fechaIngPercargo = fechaIngPercargo;
    }

    public String getCreaPorPercargo() {
        return creaPorPercargo;
    }

    public void setCreaPorPercargo(String creaPorPercargo) {
        this.creaPorPercargo = creaPorPercargo;
    }

    public Date getFechaModiPercargo() {
        return fechaModiPercargo;
    }

    public void setFechaModiPercargo(Date fechaModiPercargo) {
        this.fechaModiPercargo = fechaModiPercargo;
    }

    public String getModiPorPercargo() {
        return modiPorPercargo;
    }

    public void setModiPorPercargo(String modiPorPercargo) {
        this.modiPorPercargo = modiPorPercargo;
    }

    public PersonalVidaLaboral getIdPervilaPercargo() {
        return idPervilaPercargo;
    }

    public void setIdPervilaPercargo(PersonalVidaLaboral idPervilaPercargo) {
        this.idPervilaPercargo = idPervilaPercargo;
    }

    private static final long serialVersionUID = 1L;
}
