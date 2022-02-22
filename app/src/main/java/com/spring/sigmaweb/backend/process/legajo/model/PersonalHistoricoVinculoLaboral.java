package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_historico_vinculolaboral")
public class PersonalHistoricoVinculoLaboral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_histvila", nullable = false)
    private Long idHistvila;

    @Column(name = "id_obra_histvila", nullable = false, length = 6)
    private String idObraHistvila;

    @Column(name = "id_personal_histvila", nullable = false)
    private Long idPersonalHistvila;

    @Column(name = "id_percont_histvila", nullable = false)
    private Long idPercontHistvila;

    @Column(name = "id_pervila_histvila", nullable = false)
    private Long idPervilaHistvila;

    @Column(name = "id_tipo_histvila", nullable = false, length = 10)
    private String tipoHistvila;

    @Column(nullable = false, name = "fecha_cambio_histvila")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambioHistvila;

    @Column(nullable = true,  name = "jornadasema_old_histvila")
    private Double jornadaSemaOldHistvila;

    @Column(nullable = true,  name = "bonificacion_old_histvila")
    private Double bonificacionOldHistvila;

    @Column(nullable = true,  name = "remuneración_old_histvila")
    private Double remuneracionOldHistvila;

    @Column(nullable = true,  name = "jornadasema_new_histvila")
    private Double jornadaSemaNewHistvila;

    @Column(nullable = true,  name = "bonificacion_new_histvila")
    private Double bonificacionNewHistvila;

    @Column(nullable = true,  name = "remuneración_new_histvila")
    private Double remuneracionNewHistvila;


    @Column(nullable = false, name = "fechaing_histvila")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngHistvila;

    @Column(nullable = false, name = "creapor_histvila", length = 100)
    private String creaPorHistvila;

    @Column(nullable = true, name = "fechamodi_histvila")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiHistvila;

    @Column(nullable = true, name = "modipor_histvila", length = 100)
    private String modiPorHistvila;

    @Column(nullable = false, name = "estado_histvila", columnDefinition = "boolean default true")
    private Boolean estadoHistvila;

    public Long getIdHistvila() {
        return idHistvila;
    }

    public void setIdHistvila(Long idHistvila) {
        this.idHistvila = idHistvila;
    }

    public String getIdObraHistvila() {
        return idObraHistvila;
    }

    public void setIdObraHistvila(String idObraHistvila) {
        this.idObraHistvila = idObraHistvila;
    }

    public Long getIdPersonalHistvila() {
        return idPersonalHistvila;
    }

    public void setIdPersonalHistvila(Long idPersonalHistvila) {
        this.idPersonalHistvila = idPersonalHistvila;
    }

    public Long getIdPercontHistvila() {
        return idPercontHistvila;
    }

    public void setIdPercontHistvila(Long idPercontHistvila) {
        this.idPercontHistvila = idPercontHistvila;
    }

    public Long getIdPervilaHistvila() {
        return idPervilaHistvila;
    }

    public void setIdPervilaHistvila(Long idPervilaHistvila) {
        this.idPervilaHistvila = idPervilaHistvila;
    }

    public String getTipoHistvila() {
        return tipoHistvila;
    }

    public void setTipoHistvila(String tipoHistvila) {
        this.tipoHistvila = tipoHistvila;
    }

    public Date getFechaCambioHistvila() {
        return fechaCambioHistvila;
    }

    public void setFechaCambioHistvila(Date fechaCambioHistvila) {
        this.fechaCambioHistvila = fechaCambioHistvila;
    }

    public Double getJornadaSemaOldHistvila() {
        return jornadaSemaOldHistvila;
    }

    public void setJornadaSemaOldHistvila(Double jornadaSemaOldHistvila) {
        this.jornadaSemaOldHistvila = jornadaSemaOldHistvila;
    }

    public Double getBonificacionOldHistvila() {
        return bonificacionOldHistvila;
    }

    public void setBonificacionOldHistvila(Double bonificacionOldHistvila) {
        this.bonificacionOldHistvila = bonificacionOldHistvila;
    }

    public Double getRemuneracionOldHistvila() {
        return remuneracionOldHistvila;
    }

    public void setRemuneracionOldHistvila(Double remuneracionOldHistvila) {
        this.remuneracionOldHistvila = remuneracionOldHistvila;
    }

    public Double getJornadaSemaNewHistvila() {
        return jornadaSemaNewHistvila;
    }

    public void setJornadaSemaNewHistvila(Double jornadaSemaNewHistvila) {
        this.jornadaSemaNewHistvila = jornadaSemaNewHistvila;
    }

    public Double getBonificacionNewHistvila() {
        return bonificacionNewHistvila;
    }

    public void setBonificacionNewHistvila(Double bonificacionNewHistvila) {
        this.bonificacionNewHistvila = bonificacionNewHistvila;
    }

    public Double getRemuneracionNewHistvila() {
        return remuneracionNewHistvila;
    }

    public void setRemuneracionNewHistvila(Double remuneracionNewHistvila) {
        this.remuneracionNewHistvila = remuneracionNewHistvila;
    }

    public Date getFechaIngHistvila() {
        return fechaIngHistvila;
    }

    public void setFechaIngHistvila(Date fechaIngHistvila) {
        this.fechaIngHistvila = fechaIngHistvila;
    }

    public String getCreaPorHistvila() {
        return creaPorHistvila;
    }

    public void setCreaPorHistvila(String creaPorHistvila) {
        this.creaPorHistvila = creaPorHistvila;
    }

    public Date getFechaModiHistvila() {
        return fechaModiHistvila;
    }

    public void setFechaModiHistvila(Date fechaModiHistvila) {
        this.fechaModiHistvila = fechaModiHistvila;
    }

    public String getModiPorHistvila() {
        return modiPorHistvila;
    }

    public void setModiPorHistvila(String modiPorHistvila) {
        this.modiPorHistvila = modiPorHistvila;
    }

    public Boolean getEstadoHistvila() {
        return estadoHistvila;
    }

    public void setEstadoHistvila(Boolean estadoHistvila) {
        this.estadoHistvila = estadoHistvila;
    }

    private static final long serialVersionUID = 1L;
}
