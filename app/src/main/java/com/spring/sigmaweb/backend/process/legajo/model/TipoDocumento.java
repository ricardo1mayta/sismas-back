package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_tipodocument")
public class TipoDocumento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipofile", nullable = false)
    private Long idTipoFile;

    @Column(nullable = false, length = 100, name = "descrip_tipofile")
    private String descripTipoFile;

    @Column(nullable = false, length = 100, name = "codigo_tipofile")
    private String codigoTipoFile;

    @Column(nullable = false, length = 6, name = "id_obra_tipofile")
    private String idObraTipoFile;

    @Column(nullable = false, length = 50, name = "tipofile")
    private String tipoFile;

    @Column(nullable = true, length = 50, name = "num_repeat_tipofile")
    private Integer numRepeatTipoFile;

    @Column(nullable = false, name = "estado_tipofile", columnDefinition = "boolean default true")
    private Boolean estadoTipoFile;

    @Column(nullable = false, name = "fechaing_fileper")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngTipoFile;

    public Long getIdTipoFile() {
        return idTipoFile;
    }

    public void setIdTipoFile(Long idTipoFile) {
        this.idTipoFile = idTipoFile;
    }

    public String getDescripTipoFile() {
        return descripTipoFile;
    }

    public void setDescripTipoFile(String descripTipoFile) {
        this.descripTipoFile = descripTipoFile;
    }

    public String getCodigoTipoFile() {
        return codigoTipoFile;
    }

    public void setCodigoTipoFile(String codigoTipoFile) {
        this.codigoTipoFile = codigoTipoFile;
    }

    public String getTipoFile() {
        return tipoFile;
    }

    public void setTipoFile(String tipoFile) {
        this.tipoFile = tipoFile;
    }

    public Boolean getEstadoTipoFile() {
        return estadoTipoFile;
    }

    public void setEstadoTipoFile(Boolean estadoTipoFile) {
        this.estadoTipoFile = estadoTipoFile;
    }

    public Date getFechaIngTipoFile() {
        return fechaIngTipoFile;
    }

    public void setFechaIngTipoFile(Date fechaIngTipoFile) {
        this.fechaIngTipoFile = fechaIngTipoFile;
    }

    public String getIdObraTipoFile() {
        return idObraTipoFile;
    }

    public void setIdObraTipoFile(String idObraTipoFile) {
        this.idObraTipoFile = idObraTipoFile;
    }

    public Integer getNumRepeatTipoFile() {
        return numRepeatTipoFile;
    }

    public void setNumRepeatTipoFile(Integer numRepeatTipoFile) {
        this.numRepeatTipoFile = numRepeatTipoFile;
    }

    private static final long serialVersionUID = 1L;
}
