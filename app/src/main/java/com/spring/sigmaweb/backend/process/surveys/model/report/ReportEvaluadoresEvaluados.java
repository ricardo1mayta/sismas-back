package com.spring.sigmaweb.backend.process.surveys.model.report;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportEvaluadoresEvaluados", entities = @EntityResult(
        entityClass = ReportEvaluadoresEvaluados.class, fields = {
        @FieldResult(name = "idMatriz", column = "idMatriz"),
        @FieldResult(name = "idObra", column = "idObra"),
        @FieldResult(name = "idPerido", column = "idPerido"),
        @FieldResult(name = "anioPerido", column = "anioPerido"),
        @FieldResult(name = "idEvento", column = "idEvento"),
        @FieldResult(name = "idEvaluador", column = "idEvaluador"),
        @FieldResult(name = "idPersonalEvaluadorMaev", column = "idPersonalEvaluadorMaev"),
        @FieldResult(name = "nombrePersEvaluador", column = "nombrePersEvaluador"),
        @FieldResult(name = "apePaternoPersEvaluador", column = "apePaternoPersEvaluador"),
        @FieldResult(name = "apeMaternoPersEvaluador", column = "apeMaternoPersEvaluador"),
        @FieldResult(name = "nomCompletoEvaluador", column = "nomCompletoEvaluador"),
        @FieldResult(name = "nombreCargoMaevEvaluador", column = "nombreCargoMaevEvaluador"),
        @FieldResult(name = "idTipoGoEvaluador", column = "idTipoGoEvaluador"),
        @FieldResult(name = "descripcionTipoGoEvaluador", column = "descripcionTipoGoEvaluador"),
        @FieldResult(name = "idEvaluado", column = "idEvaluado"),
        @FieldResult(name = "idPersonalEvaluadoMaev", column = "idPersonalEvaluadoMaev"),
        @FieldResult(name = "nombrePersEvaluado", column = "nombrePersEvaluado"),
        @FieldResult(name = "apePaternoPersEvaluado", column = "apePaternoPersEvaluado"),
        @FieldResult(name = "apeMaternoPersEvaluado", column = "apeMaternoPersEvaluado"),
        @FieldResult(name = "nomCompletoEvaluado", column = "nomCompletoEvaluado"),
        @FieldResult(name = "nombreCargoMaevEvaluado", column = "nombreCargoMaevEvaluado"),
        @FieldResult(name = "idTipoGoEvaluado", column = "idTipoGoEvaluado"),
        @FieldResult(name = "descripcionTipoGoEvaluado", column = "descripcionTipoGoEvaluado"),
        @FieldResult(name = "estadoEncuesta", column = "estadoEncuesta"),}
    )
)

@Entity
public class ReportEvaluadoresEvaluados implements Serializable {
    @Id
    private Long idMatriz;
    private String idObra;
    private Long idPerido;
    private Integer anioPerido;
    private Long idEvento;

    private Long idEvaluador;
    private Long idPersonalEvaluadorMaev;
    private String nombrePersEvaluador;
    private String apePaternoPersEvaluador;
    private String apeMaternoPersEvaluador;
    private String nomCompletoEvaluador;
    private String nombreCargoMaevEvaluador;
    private Integer idTipoGoEvaluador;
    private String descripcionTipoGoEvaluador;

    private Long idEvaluado;
    private Long idPersonalEvaluadoMaev;
    private String nombrePersEvaluado;
    private String apePaternoPersEvaluado;
    private String apeMaternoPersEvaluado;
    private String nomCompletoEvaluado;
    private String nombreCargoMaevEvaluado;
    private Long idTipoGoEvaluado;
    private String descripcionTipoGoEvaluado;

    private String estadoEncuesta;

    public ReportEvaluadoresEvaluados(){
        super();
    }

    public ReportEvaluadoresEvaluados(Long idMatriz, String idObra, Long idPerido, Integer anioPerido, Long idEvento, Long idEvaluador, Long idPersonalEvaluadorMaev, String nombrePersEvaluador, String apePaternoPersEvaluador, String apeMaternoPersEvaluador, String nomCompletoEvaluador, String nombreCargoMaevEvaluador, Integer idTipoGoEvaluador, String descripcionTipoGoEvaluador, Long idEvaluado, Long idPersonalEvaluadoMaev, String nombrePersEvaluado, String apePaternoPersEvaluado, String apeMaternoPersEvaluado, String nomCompletoEvaluado, String nombreCargoMaevEvaluado, Long idTipoGoEvaluado, String descripcionTipoGoEvaluado, String estadoEncuesta) {
        this.idMatriz = idMatriz;
        this.idObra = idObra;
        this.idPerido = idPerido;
        this.anioPerido = anioPerido;
        this.idEvento = idEvento;
        this.idEvaluador = idEvaluador;
        this.idPersonalEvaluadorMaev = idPersonalEvaluadorMaev;
        this.nombrePersEvaluador = nombrePersEvaluador;
        this.apePaternoPersEvaluador = apePaternoPersEvaluador;
        this.apeMaternoPersEvaluador = apeMaternoPersEvaluador;
        this.nomCompletoEvaluador = nomCompletoEvaluador;
        this.nombreCargoMaevEvaluador = nombreCargoMaevEvaluador;
        this.idTipoGoEvaluador = idTipoGoEvaluador;
        this.descripcionTipoGoEvaluador = descripcionTipoGoEvaluador;
        this.idEvaluado = idEvaluado;
        this.idPersonalEvaluadoMaev = idPersonalEvaluadoMaev;
        this.nombrePersEvaluado = nombrePersEvaluado;
        this.apePaternoPersEvaluado = apePaternoPersEvaluado;
        this.apeMaternoPersEvaluado = apeMaternoPersEvaluado;
        this.nomCompletoEvaluado = nomCompletoEvaluado;
        this.nombreCargoMaevEvaluado = nombreCargoMaevEvaluado;
        this.idTipoGoEvaluado = idTipoGoEvaluado;
        this.descripcionTipoGoEvaluado = descripcionTipoGoEvaluado;
        this.estadoEncuesta = estadoEncuesta;
    }

    public Long getIdMatriz() {
        return idMatriz;
    }

    public void setIdMatriz(Long idMatriz) {
        this.idMatriz = idMatriz;
    }

    public String getIdObra() {
        return idObra;
    }

    public void setIdObra(String idObra) {
        this.idObra = idObra;
    }

    public Long getIdPerido() {
        return idPerido;
    }

    public void setIdPerido(Long idPerido) {
        this.idPerido = idPerido;
    }

    public Integer getAnioPerido() {
        return anioPerido;
    }

    public void setAnioPerido(Integer anioPerido) {
        this.anioPerido = anioPerido;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdEvaluador() {
        return idEvaluador;
    }

    public void setIdEvaluador(Long idEvaluador) {
        this.idEvaluador = idEvaluador;
    }

    public Long getIdPersonalEvaluadorMaev() {
        return idPersonalEvaluadorMaev;
    }

    public void setIdPersonalEvaluadorMaev(Long idPersonalEvaluadorMaev) {
        this.idPersonalEvaluadorMaev = idPersonalEvaluadorMaev;
    }

    public String getNombrePersEvaluador() {
        return nombrePersEvaluador;
    }

    public void setNombrePersEvaluador(String nombrePersEvaluador) {
        this.nombrePersEvaluador = nombrePersEvaluador;
    }

    public String getApePaternoPersEvaluador() {
        return apePaternoPersEvaluador;
    }

    public void setApePaternoPersEvaluador(String apePaternoPersEvaluador) {
        this.apePaternoPersEvaluador = apePaternoPersEvaluador;
    }

    public String getApeMaternoPersEvaluador() {
        return apeMaternoPersEvaluador;
    }

    public void setApeMaternoPersEvaluador(String apeMaternoPersEvaluador) {
        this.apeMaternoPersEvaluador = apeMaternoPersEvaluador;
    }

    public String getNombreCargoMaevEvaluador() {
        return nombreCargoMaevEvaluador;
    }

    public void setNombreCargoMaevEvaluador(String nombreCargoMaevEvaluador) {
        this.nombreCargoMaevEvaluador = nombreCargoMaevEvaluador;
    }

    public Integer getIdTipoGoEvaluador() {
        return idTipoGoEvaluador;
    }

    public void setIdTipoGoEvaluador(Integer idTipoGoEvaluador) {
        this.idTipoGoEvaluador = idTipoGoEvaluador;
    }

    public String getDescripcionTipoGoEvaluador() {
        return descripcionTipoGoEvaluador;
    }

    public void setDescripcionTipoGoEvaluador(String descripcionTipoGoEvaluador) {
        this.descripcionTipoGoEvaluador = descripcionTipoGoEvaluador;
    }

    public Long getIdEvaluado() {
        return idEvaluado;
    }

    public void setIdEvaluado(Long idEvaluado) {
        this.idEvaluado = idEvaluado;
    }

    public Long getIdPersonalEvaluadoMaev() {
        return idPersonalEvaluadoMaev;
    }

    public void setIdPersonalEvaluadoMaev(Long idPersonalEvaluadoMaev) {
        this.idPersonalEvaluadoMaev = idPersonalEvaluadoMaev;
    }

    public String getNombrePersEvaluado() {
        return nombrePersEvaluado;
    }

    public void setNombrePersEvaluado(String nombrePersEvaluado) {
        this.nombrePersEvaluado = nombrePersEvaluado;
    }

    public String getApePaternoPersEvaluado() {
        return apePaternoPersEvaluado;
    }

    public void setApePaternoPersEvaluado(String apePaternoPersEvaluado) {
        this.apePaternoPersEvaluado = apePaternoPersEvaluado;
    }

    public String getApeMaternoPersEvaluado() {
        return apeMaternoPersEvaluado;
    }

    public void setApeMaternoPersEvaluado(String apeMaternoPersEvaluado) {
        this.apeMaternoPersEvaluado = apeMaternoPersEvaluado;
    }

    public String getNombreCargoMaevEvaluado() {
        return nombreCargoMaevEvaluado;
    }

    public void setNombreCargoMaevEvaluado(String nombreCargoMaevEvaluado) {
        this.nombreCargoMaevEvaluado = nombreCargoMaevEvaluado;
    }

    public Long getIdTipoGoEvaluado() {
        return idTipoGoEvaluado;
    }

    public void setIdTipoGoEvaluado(Long idTipoGoEvaluado) {
        this.idTipoGoEvaluado = idTipoGoEvaluado;
    }

    public String getDescripcionTipoGoEvaluado() {
        return descripcionTipoGoEvaluado;
    }

    public void setDescripcionTipoGoEvaluado(String descripcionTipoGoEvaluado) {
        this.descripcionTipoGoEvaluado = descripcionTipoGoEvaluado;
    }

    public String getEstadoEncuesta() {
        return estadoEncuesta;
    }

    public void setEstadoEncuesta(String estadoEncuesta) {
        this.estadoEncuesta = estadoEncuesta;
    }

    public String getNomCompletoEvaluador() {
        return nomCompletoEvaluador;
    }

    public void setNomCompletoEvaluador(String nomCompletoEvaluador) {
        this.nomCompletoEvaluador = nomCompletoEvaluador;
    }

    public String getNomCompletoEvaluado() {
        return nomCompletoEvaluado;
    }

    public void setNomCompletoEvaluado(String nomCompletoEvaluado) {
        this.nomCompletoEvaluado = nomCompletoEvaluado;
    }
}
