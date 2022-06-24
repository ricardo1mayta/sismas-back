package com.spring.sigmaweb.backend.process.surveys.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_matriz_evaluacion")
public class MatrizEvaluacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matrizeval", nullable = false, unique = true)
    private Long idMatrizEval;

    @Column(nullable = false, length = 6, name = "id_obra_maev")
    private String idObraMaev;

    @Column(nullable = false, name = "id_periodo_maev")
    private Long idPeriodoMaev;

    @Column(nullable = false, name = "id_evento_maev")
    private Long idEventoMaev;

    @Column(nullable = false, name = "id_evaluador_maev")
    private Long idEvaluadorMaev;

    @Column(nullable = false, name = "id_cargo_evaluador_maev")
    private Long idCargoEvaluadorMaev;

    @Column(nullable = false, name = "id_evaluado_maev")
    private Long idEvaluadoMaev;

    @Column(nullable = false, name = "id_cargo_evaluado_maev")
    private Long idCargoEvaluadoMaev;

    @Column(nullable = false, length = 1, name = "estado_maev")
    private String estadoMaev;


    @Column(nullable = false, name = "fechaing_maev")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingMaev;

    @Column(nullable = false, name = "creapor_maev", length = 100)
    private String creaporMaev;

    @Column(nullable = true, name = "fechamodi_maev")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiMaev;

    @Column(nullable = true, name = "modipor_maev", length = 100)
    private String modiporMaev;

    public Long getIdMatrizEval() {
        return idMatrizEval;
    }

    public void setIdMatrizEval(Long idMatrizEval) {
        this.idMatrizEval = idMatrizEval;
    }

    public String getIdObraMaev() {
        return idObraMaev;
    }

    public void setIdObraMaev(String idObraMaev) {
        this.idObraMaev = idObraMaev;
    }

    public Long getIdPeriodoMaev() {
        return idPeriodoMaev;
    }

    public void setIdPeriodoMaev(Long idPeriodoMaev) {
        this.idPeriodoMaev = idPeriodoMaev;
    }

    public Long getIdEventoMaev() {
        return idEventoMaev;
    }

    public void setIdEventoMaev(Long idEventoMaev) {
        this.idEventoMaev = idEventoMaev;
    }

    public Long getIdEvaluadorMaev() {
        return idEvaluadorMaev;
    }

    public void setIdEvaluadorMaev(Long idEvaluadorMaev) {
        this.idEvaluadorMaev = idEvaluadorMaev;
    }

    public Long getIdCargoEvaluadorMaev() {
        return idCargoEvaluadorMaev;
    }

    public void setIdCargoEvaluadorMaev(Long idCargoEvaluadorMaev) {
        this.idCargoEvaluadorMaev = idCargoEvaluadorMaev;
    }

    public Long getIdEvaluadoMaev() {
        return idEvaluadoMaev;
    }

    public void setIdEvaluadoMaev(Long idEvaluadoMaev) {
        this.idEvaluadoMaev = idEvaluadoMaev;
    }

    public Long getIdCargoEvaluadoMaev() {
        return idCargoEvaluadoMaev;
    }

    public void setIdCargoEvaluadoMaev(Long idCargoEvaluadoMaev) {
        this.idCargoEvaluadoMaev = idCargoEvaluadoMaev;
    }

    public String getEstadoMaev() {
        return estadoMaev;
    }

    public void setEstadoMaev(String estadoMaev) {
        this.estadoMaev = estadoMaev;
    }

    public Date getFechaingMaev() {
        return fechaingMaev;
    }

    public void setFechaingMaev(Date fechaingMaev) {
        this.fechaingMaev = fechaingMaev;
    }

    public String getCreaporMaev() {
        return creaporMaev;
    }

    public void setCreaporMaev(String creaporMaev) {
        this.creaporMaev = creaporMaev;
    }

    public Date getFechamodiMaev() {
        return fechamodiMaev;
    }

    public void setFechamodiMaev(Date fechamodiMaev) {
        this.fechamodiMaev = fechamodiMaev;
    }

    public String getModiporMaev() {
        return modiporMaev;
    }

    public void setModiporMaev(String modiporMaev) {
        this.modiporMaev = modiporMaev;
    }

    private static final long serialVersionUID = 1L;
}
