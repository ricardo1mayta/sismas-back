package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "me_indicadores_logro")
public class IndicadoresLogro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indicadorlogro", nullable = false, unique = true)
    private Long idIndicadorLogro;

    @Column(nullable = false, length = 500,name = "descripcion_indic")
    private String descripcionIndic;

    @Column(nullable = false, name = "fechaing_indic")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingIndic;

    @Column(nullable = false, name = "creapor_indic", length = 100)
    private String creaporIndic;

    @Column(nullable = true, name = "fechamodi_indic")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiIndic;

    @Column(nullable = true, name = "modipor_indic", length = 100)
    private String modiporIndic;

    @PrePersist
    public void prePersist() {
        this.fechaingIndic = new Date();
    }

    public Long getIdIndicadorLogro() {
        return idIndicadorLogro;
    }

    public void setIdIndicadorLogro(Long idIndicadorLogro) {
        this.idIndicadorLogro = idIndicadorLogro;
    }

    public String getDescripcionIndic() {
        return descripcionIndic;
    }

    public void setDescripcionIndic(String descripcionIndic) {
        this.descripcionIndic = descripcionIndic;
    }

    public Date getFechaingIndic() {
        return fechaingIndic;
    }

    public void setFechaingIndic(Date fechaingIndic) {
        this.fechaingIndic = fechaingIndic;
    }

    public String getCreaporIndic() {
        return creaporIndic;
    }

    public void setCreaporIndic(String creaporIndic) {
        this.creaporIndic = creaporIndic;
    }

    public Date getFechamodiIndic() {
        return fechamodiIndic;
    }

    public void setFechamodiIndic(Date fechamodiIndic) {
        this.fechamodiIndic = fechamodiIndic;
    }

    public String getModiporIndic() {
        return modiporIndic;
    }

    public void setModiporIndic(String modiporIndic) {
        this.modiporIndic = modiporIndic;
    }
}
