package com.spring.sigmaweb.backend.process.surveys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class MatrizEvaluacionDTO implements Serializable {

    private Long idMatrizEval;
    private String idObraMaev;
    private Long idPeriodoMaev;
    private Integer anioPeriodoMaev;
    private Long idEventoMaev;
    private String descripcionEventoMaev;

    private Long idEvaluadorMaev;
    private Long idPersonalEvaluadorMaev;
    private String nombrePersEvaluador;
    private String apePaternoPersEvaluador;
    private String apeMaternoPersEvaluador;
    private String nomCompletoEvaluador;
    private Long idCargoEvaluadorMaevEvaluador;
    private String nombreCargoMaevEvaluador;
    private Boolean flgEsCargoprincipalEvaluador;
    private Boolean flgPrincipalEvalEvaluador;
    private Integer idTipoGoEvaluador;
    private String descripcionTipoGoEvaluador;

    private Long idEvaluadoMaev;
    private Long idPersonalEvaluadoMaev;
    private String nombrePersEvaluado;
    private String apePaternoPersEvaluado;
    private String apeMaternoPersEvaluado;
    private String nomCompletoEvaluado;
    private Long idCargoEvaluadoMaev;
    private String nombreCargoMaevEvaluado;
    private Boolean flgEsCargoprincipalEvaluado;
    private Boolean flgPrincipalEvalEvaluado;
    private Integer idTipoGoEvaluado;
    private String descripcionTipoGoEvaluado;

    private String estadoMaev;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingMaev;

    private String creaporMaev;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiMaev;
    private String modiporMaev;

    public MatrizEvaluacionDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MatrizEvaluacionDTO(Long idMatrizEval, String idObraMaev, Long idPeriodoMaev, Integer anioPeriodoMaev, Long idEventoMaev, String descripcionEventoMaev, Long idEvaluadorMaev, Long idPersonalEvaluadorMaev, String nombrePersEvaluador, String apePaternoPersEvaluador, String apeMaternoPersEvaluador, String nomCompletoEvaluador, Long idCargoEvaluadorMaevEvaluador, String nombreCargoMaevEvaluador, Boolean flgEsCargoprincipalEvaluador, Boolean flgPrincipalEvalEvaluador, Integer idTipoGoEvaluador, String descripcionTipoGoEvaluador, Long idEvaluadoMaev, Long idPersonalEvaluadoMaev, String nombrePersEvaluado, String apePaternoPersEvaluado, String apeMaternoPersEvaluado, String nomCompletoEvaluado, Long idCargoEvaluadoMaev, String nombreCargoMaevEvaluado, Boolean flgEsCargoprincipalEvaluado, Boolean flgPrincipalEvalEvaluado, Integer idTipoGoEvaluado, String descripcionTipoGoEvaluado, String estadoMaev, Date fechaingMaev, String creaporMaev, Date fechamodiMaev, String modiporMaev) {
        this.idMatrizEval = idMatrizEval;
        this.idObraMaev = idObraMaev;
        this.idPeriodoMaev = idPeriodoMaev;
        this.anioPeriodoMaev = anioPeriodoMaev;
        this.idEventoMaev = idEventoMaev;
        this.descripcionEventoMaev = descripcionEventoMaev;
        this.idEvaluadorMaev = idEvaluadorMaev;
        this.idPersonalEvaluadorMaev = idPersonalEvaluadorMaev;
        this.nombrePersEvaluador = nombrePersEvaluador;
        this.apePaternoPersEvaluador = apePaternoPersEvaluador;
        this.apeMaternoPersEvaluador = apeMaternoPersEvaluador;
        this.nomCompletoEvaluador = nomCompletoEvaluador;
        this.idCargoEvaluadorMaevEvaluador = idCargoEvaluadorMaevEvaluador;
        this.nombreCargoMaevEvaluador = nombreCargoMaevEvaluador;
        this.flgEsCargoprincipalEvaluador = flgEsCargoprincipalEvaluador;
        this.flgPrincipalEvalEvaluador = flgPrincipalEvalEvaluador;
        this.idTipoGoEvaluador = idTipoGoEvaluador;
        this.descripcionTipoGoEvaluador = descripcionTipoGoEvaluador;
        this.idEvaluadoMaev = idEvaluadoMaev;
        this.idPersonalEvaluadoMaev = idPersonalEvaluadoMaev;
        this.nombrePersEvaluado = nombrePersEvaluado;
        this.apePaternoPersEvaluado = apePaternoPersEvaluado;
        this.apeMaternoPersEvaluado = apeMaternoPersEvaluado;
        this.nomCompletoEvaluado = nomCompletoEvaluado;
        this.idCargoEvaluadoMaev = idCargoEvaluadoMaev;
        this.nombreCargoMaevEvaluado = nombreCargoMaevEvaluado;
        this.flgEsCargoprincipalEvaluado = flgEsCargoprincipalEvaluado;
        this.flgPrincipalEvalEvaluado = flgPrincipalEvalEvaluado;
        this.idTipoGoEvaluado = idTipoGoEvaluado;
        this.descripcionTipoGoEvaluado = descripcionTipoGoEvaluado;
        this.estadoMaev = estadoMaev;
        this.fechaingMaev = fechaingMaev;
        this.creaporMaev = creaporMaev;
        this.fechamodiMaev = fechamodiMaev;
        this.modiporMaev = modiporMaev;
    }

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

    public Integer getAnioPeriodoMaev() {
        return anioPeriodoMaev;
    }

    public void setAnioPeriodoMaev(Integer anioPeriodoMaev) {
        this.anioPeriodoMaev = anioPeriodoMaev;
    }

    public Long getIdEventoMaev() {
        return idEventoMaev;
    }

    public void setIdEventoMaev(Long idEventoMaev) {
        this.idEventoMaev = idEventoMaev;
    }

    public String getDescripcionEventoMaev() {
        return descripcionEventoMaev;
    }

    public void setDescripcionEventoMaev(String descripcionEventoMaev) {
        this.descripcionEventoMaev = descripcionEventoMaev;
    }

    public Long getIdEvaluadorMaev() {
        return idEvaluadorMaev;
    }

    public void setIdEvaluadorMaev(Long idEvaluadorMaev) {
        this.idEvaluadorMaev = idEvaluadorMaev;
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

    public String getNomCompletoEvaluador() {
        return nomCompletoEvaluador;
    }

    public void setNomCompletoEvaluador(String nomCompletoEvaluador) {
        this.nomCompletoEvaluador = nomCompletoEvaluador;
    }

    public Long getIdCargoEvaluadorMaevEvaluador() {
        return idCargoEvaluadorMaevEvaluador;
    }

    public void setIdCargoEvaluadorMaevEvaluador(Long idCargoEvaluadorMaevEvaluador) {
        this.idCargoEvaluadorMaevEvaluador = idCargoEvaluadorMaevEvaluador;
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

    public Long getIdEvaluadoMaev() {
        return idEvaluadoMaev;
    }

    public void setIdEvaluadoMaev(Long idEvaluadoMaev) {
        this.idEvaluadoMaev = idEvaluadoMaev;
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

    public String getNomCompletoEvaluado() {
        return nomCompletoEvaluado;
    }

    public void setNomCompletoEvaluado(String nomCompletoEvaluado) {
        this.nomCompletoEvaluado = nomCompletoEvaluado;
    }

    public Long getIdCargoEvaluadoMaev() {
        return idCargoEvaluadoMaev;
    }

    public void setIdCargoEvaluadoMaev(Long idCargoEvaluadoMaev) {
        this.idCargoEvaluadoMaev = idCargoEvaluadoMaev;
    }

    public String getNombreCargoMaevEvaluado() {
        return nombreCargoMaevEvaluado;
    }

    public void setNombreCargoMaevEvaluado(String nombreCargoMaevEvaluado) {
        this.nombreCargoMaevEvaluado = nombreCargoMaevEvaluado;
    }

    public Integer getIdTipoGoEvaluado() {
        return idTipoGoEvaluado;
    }

    public void setIdTipoGoEvaluado(Integer idTipoGoEvaluado) {
        this.idTipoGoEvaluado = idTipoGoEvaluado;
    }

    public String getDescripcionTipoGoEvaluado() {
        return descripcionTipoGoEvaluado;
    }

    public void setDescripcionTipoGoEvaluado(String descripcionTipoGoEvaluado) {
        this.descripcionTipoGoEvaluado = descripcionTipoGoEvaluado;
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

    public Boolean getFlgEsCargoprincipalEvaluador() {
        return flgEsCargoprincipalEvaluador;
    }

    public void setFlgEsCargoprincipalEvaluador(Boolean flgEsCargoprincipalEvaluador) {
        this.flgEsCargoprincipalEvaluador = flgEsCargoprincipalEvaluador;
    }

    public Boolean getFlgEsCargoprincipalEvaluado() {
        return flgEsCargoprincipalEvaluado;
    }

    public void setFlgEsCargoprincipalEvaluado(Boolean flgEsCargoprincipalEvaluado) {
        this.flgEsCargoprincipalEvaluado = flgEsCargoprincipalEvaluado;
    }

    public Long getIdPersonalEvaluadorMaev() {
        return idPersonalEvaluadorMaev;
    }

    public void setIdPersonalEvaluadorMaev(Long idPersonalEvaluadorMaev) {
        this.idPersonalEvaluadorMaev = idPersonalEvaluadorMaev;
    }

    public Long getIdPersonalEvaluadoMaev() {
        return idPersonalEvaluadoMaev;
    }

    public void setIdPersonalEvaluadoMaev(Long idPersonalEvaluadoMaev) {
        this.idPersonalEvaluadoMaev = idPersonalEvaluadoMaev;
    }

    public Boolean getFlgPrincipalEvalEvaluador() {
        return flgPrincipalEvalEvaluador;
    }

    public void setFlgPrincipalEvalEvaluador(Boolean flgPrincipalEvalEvaluador) {
        this.flgPrincipalEvalEvaluador = flgPrincipalEvalEvaluador;
    }

    public Boolean getFlgPrincipalEvalEvaluado() {
        return flgPrincipalEvalEvaluado;
    }

    public void setFlgPrincipalEvalEvaluado(Boolean flgPrincipalEvalEvaluado) {
        this.flgPrincipalEvalEvaluado = flgPrincipalEvalEvaluado;
    }

    private static final long serialVersionUID = 1L;
}
