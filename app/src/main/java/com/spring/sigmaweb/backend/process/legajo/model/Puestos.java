package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mo_puestos")
public class Puestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto", nullable = false, unique = true)
    private Long idPuesto;

    @Column(nullable = false, length = 100, name = "nombre_pues")
    private String nombrePues;

    @Column(nullable = false, length = 10, name = "abreviado_pues")
    private String abreviadoPues;

    @Column(nullable = false, length = 100, name = "codigo_pues")
    private String codigoPues;

    @Column(nullable = false, length = 6, name = "id_obra_pues")
    private String idObraPues;

    @Column(nullable = false, name = "estado_pues", columnDefinition = "boolean default true")
    private Boolean estadoPues;

    @Column(nullable = true, name = "id_tipo_go_pues")
    private Integer idTipoGoPues;

    @Column(nullable = false, name = "fechaing_pues")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPues;

    @Column(nullable = false, name = "creapor_pues", length = 30)
    private String creaPorPues;

    @Column(nullable = true, name = "fechamodi_pues")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPues;

    @Column(nullable = true, name = "modipor_pues", length = 30)
    private String modiPorPues;

    @PrePersist
    public void prePersist() {
        this.fechaIngPues = new Date();
    }

    public Long getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Long idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombrePues() {
        return nombrePues;
    }

    public void setNombrePues(String nombrePues) {
        this.nombrePues = nombrePues;
    }

    public String getAbreviadoPues() {
        return abreviadoPues;
    }

    public void setAbreviadoPues(String abreviadoPues) {
        this.abreviadoPues = abreviadoPues;
    }

    public String getCodigoPues() {
        return codigoPues;
    }

    public void setCodigoPues(String codigoPues) {
        this.codigoPues = codigoPues;
    }

    public String getIdObraPues() {
        return idObraPues;
    }

    public void setIdObraPues(String idObraPues) {
        this.idObraPues = idObraPues;
    }

    public Boolean getEstadoPues() {
        return estadoPues;
    }

    public void setEstadoPues(Boolean estadoPues) {
        this.estadoPues = estadoPues;
    }

    public Integer getIdTipoGoPues() {
        return idTipoGoPues;
    }

    public void setIdTipoGoPues(Integer idTipoGoPues) {
        this.idTipoGoPues = idTipoGoPues;
    }

    public Date getFechaIngPues() {
        return fechaIngPues;
    }

    public void setFechaIngPues(Date fechaIngPues) {
        this.fechaIngPues = fechaIngPues;
    }

    public String getCreaPorPues() {
        return creaPorPues;
    }

    public void setCreaPorPues(String creaPorPues) {
        this.creaPorPues = creaPorPues;
    }

    public Date getFechaModiPues() {
        return fechaModiPues;
    }

    public void setFechaModiPues(Date fechaModiPues) {
        this.fechaModiPues = fechaModiPues;
    }

    public String getModiPorPues() {
        return modiPorPues;
    }

    public void setModiPorPues(String modiPorPues) {
        this.modiPorPues = modiPorPues;
    }
}
