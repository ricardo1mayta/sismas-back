package com.spring.sigmaweb.backend.process.generic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mg_parameter")
public class Parametro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_para", nullable = false, unique = true)
    private Long idPara;

    @Column(name="descripcion_para", nullable = false, unique = true, length = 30)
    private String descripcionPara;

    @Column(name="tipo_para", nullable = false, length = 15)
    private String tipoPara;

    @Column(nullable = true, name = "fechaing_para")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPara;

    @Column(nullable = false, name = "creapor_para", length = 100)
    private String creaPorPara;

    @Column(nullable = false, name = "estado_para", columnDefinition = "boolean default true")
    private Boolean estadoPara;

    @PrePersist
    public void prePersist() {
        this.fechaIngPara = new Date();
    }

    public Long getIdPara() {
        return idPara;
    }

    public void setIdPara(Long idPara) {
        this.idPara = idPara;
    }

    public String getDescripcionPara() {
        return descripcionPara;
    }

    public void setDescripcionPara(String descripcionPara) {
        this.descripcionPara = descripcionPara;
    }

    public String getTipoPara() {
        return tipoPara;
    }

    public void setTipoPara(String tipoPara) {
        this.tipoPara = tipoPara;
    }

    public Date getFechaIngPara() {
        return fechaIngPara;
    }

    public void setFechaIngPara(Date fechaIngPara) {
        this.fechaIngPara = fechaIngPara;
    }

    public String getCreaPorPara() {
        return creaPorPara;
    }

    public void setCreaPorPara(String creaPorPara) {
        this.creaPorPara = creaPorPara;
    }

    public Boolean getEstadoPara() {
        return estadoPara;
    }

    public void setEstadoPara(Boolean estadoPara) {
        this.estadoPara = estadoPara;
    }

    private static final long serialVersionUID = 1L;
}
