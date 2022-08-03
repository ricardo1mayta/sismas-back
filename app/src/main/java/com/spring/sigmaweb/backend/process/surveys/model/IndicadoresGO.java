package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "me_indicadores_grupo_ocupacional")
public class IndicadoresGO implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indicgo", nullable = false, unique = true)
    private Long idIndicgo;

    @Column(nullable = false, name = "id_indicador_indicgo")
    private Long idIndicadorIndicgo;

    @Column(nullable = false, name = "id_grupoocupacional_indicgo")
    private Integer idGrupoocupacionalIndicgo;

    @Column(nullable = false, name = "id_puesto_indicgo")
    private Long idPuestoIndicgo;

    @Column(nullable = false, name = "id_evento_indicgo")
    private Long idEventoIndicgo;

    @Column(nullable = false, name = "flg_activo_indicgo", columnDefinition = "boolean default true")
    private Boolean flgActivoIndicgo;


    @Column(nullable = false, name = "fechaing_indicgo")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingIndicgo;

    @Column(nullable = false, name = "creapor_indicgo", length = 100)
    private String creaporIndicgo;

    @Column(nullable = true, name = "fechamodi_indicgo")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiIndicgo;

    @Column(nullable = true, name = "modipor_indicgo", length = 100)
    private String modiporIndicgo;

    @PrePersist
    public void prePersist() {
        this.fechaingIndicgo = new Date();
    }

    public Long getIdIndicgo() {
        return idIndicgo;
    }

    public void setIdIndicgo(Long idIndicgo) {
        this.idIndicgo = idIndicgo;
    }

    public Long getIdIndicadorIndicgo() {
        return idIndicadorIndicgo;
    }

    public void setIdIndicadorIndicgo(Long idIndicadorIndicgo) {
        this.idIndicadorIndicgo = idIndicadorIndicgo;
    }

    public Integer getIdGrupoocupacionalIndicgo() {
        return idGrupoocupacionalIndicgo;
    }

    public void setIdGrupoocupacionalIndicgo(Integer idGrupoocupacionalIndicgo) {
        this.idGrupoocupacionalIndicgo = idGrupoocupacionalIndicgo;
    }

    public Long getIdPuestoIndicgo() {
        return idPuestoIndicgo;
    }

    public void setIdPuestoIndicgo(Long idPuestoIndicgo) {
        this.idPuestoIndicgo = idPuestoIndicgo;
    }

    public Long getIdEventoIndicgo() {
        return idEventoIndicgo;
    }

    public void setIdEventoIndicgo(Long idEventoIndicgo) {
        this.idEventoIndicgo = idEventoIndicgo;
    }

    public Boolean getFlgActivoIndicgo() {
        return flgActivoIndicgo;
    }

    public void setFlgActivoIndicgo(Boolean flgActivoIndicgo) {
        this.flgActivoIndicgo = flgActivoIndicgo;
    }

    public Date getFechaingIndicgo() {
        return fechaingIndicgo;
    }

    public void setFechaingIndicgo(Date fechaingIndicgo) {
        this.fechaingIndicgo = fechaingIndicgo;
    }

    public String getCreaporIndicgo() {
        return creaporIndicgo;
    }

    public void setCreaporIndicgo(String creaporIndicgo) {
        this.creaporIndicgo = creaporIndicgo;
    }

    public Date getFechamodiIndicgo() {
        return fechamodiIndicgo;
    }

    public void setFechamodiIndicgo(Date fechamodiIndicgo) {
        this.fechamodiIndicgo = fechamodiIndicgo;
    }

    public String getModiporIndicgo() {
        return modiporIndicgo;
    }

    public void setModiporIndicgo(String modiporIndicgo) {
        this.modiporIndicgo = modiporIndicgo;
    }
}
