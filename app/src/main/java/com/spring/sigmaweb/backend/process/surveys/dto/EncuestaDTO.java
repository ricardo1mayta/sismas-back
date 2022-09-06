package com.spring.sigmaweb.backend.process.surveys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class EncuestaDTO implements Serializable {
    private Long idEncuesta;
    private Long idMatrizevalEncuesta;
    private String estadoMaev;
    private Long idPeriodoMaev;
    private Integer anioPeri;
    private Long idEventoMaev;
    private String nombreEvent;

    private Long idEvaluadorMaev;
    private Long idPersonalEvaluador;
    private String apePaternoEvaluador;
    private String apeMaternoEvaluador;
    private String codigoPerEvaluador;
    private String nroDocEvaluador;
    private String nombreEvaluador;
    private Long idCargoPuestoEvaluador;
    private Long descripcionCargoPuestoEvaluador;
    private Boolean flgEsCargoprincipalEvaluador;
    private Boolean flgPrincipalEvalEvaluador;
    private Integer idGrupoOcupacionalEvaluador;
    private Integer descripcionGrupoOcupacionalEvaluador;

    private Long idEvaluadoMaev;
    private Long idPersonalEvaluado;
    private String apePaternoEvaluado;
    private String apeMaternoEvaluado;
    private String codigoPerEvaluado;
    private String nroDocEvaluado;
    private String nombreEvaluado;
    private Long idCargoPuestoEvaluado;
    private Long descripcionCargoPuestoEvaluado;
    private Boolean flgEsCargoprincipalEvaluado;
    private Boolean flgPrincipalEvalEvaluado;
    private Integer idGrupoOcupacionalEvaluado;
    private Integer descripcionGrupoOcupacionalEvaluado;

    private String idObraEncuesta;
    private Integer totalPreguntasEncuesta;
    private Boolean flg_activoEncuesta;
    private String flgEstadoEncuesta;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioEncuesta;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinEncuesta;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingEncuesta;

    private String creaporEncuesta;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodiEncuesta;

    private String modiporEncuesta;


    public EncuestaDTO() {
        super();
        // TODO Auto-generated constructor stub
    }


    public EncuestaDTO(Long idEncuesta, Long idMatrizevalEncuesta, String estadoMaev, Long idPeriodoMaev, Integer anioPeri, Long idEventoMaev, String nombreEvent, Long idEvaluadorMaev, Long idPersonalEvaluador, String apePaternoEvaluador, String apeMaternoEvaluador, String codigoPerEvaluador, String nroDocEvaluador, String nombreEvaluador, Long idCargoPuestoEvaluador, Long descripcionCargoPuestoEvaluador, Boolean flgEsCargoprincipalEvaluador, Boolean flgPrincipalEvalEvaluador, Integer idGrupoOcupacionalEvaluador, Integer descripcionGrupoOcupacionalEvaluador, Long idEvaluadoMaev, Long idPersonalEvaluado, String apePaternoEvaluado, String apeMaternoEvaluado, String codigoPerEvaluado, String nroDocEvaluado, String nombreEvaluado, Long idCargoPuestoEvaluado, Long descripcionCargoPuestoEvaluado, Boolean flgEsCargoprincipalEvaluado, Boolean flgPrincipalEvalEvaluado, Integer idGrupoOcupacionalEvaluado, Integer descripcionGrupoOcupacionalEvaluado, String idObraEncuesta, Integer totalPreguntasEncuesta, Boolean flg_activoEncuesta, String flgEstadoEncuesta, Date fechaInicioEncuesta, Date fechaFinEncuesta, Date fechaingEncuesta, String creaporEncuesta, Date fechamodiEncuesta, String modiporEncuesta) {
        this.idEncuesta = idEncuesta;
        this.idMatrizevalEncuesta = idMatrizevalEncuesta;
        this.estadoMaev = estadoMaev;
        this.idPeriodoMaev = idPeriodoMaev;
        this.anioPeri = anioPeri;
        this.idEventoMaev = idEventoMaev;
        this.nombreEvent = nombreEvent;
        this.idEvaluadorMaev = idEvaluadorMaev;
        this.idPersonalEvaluador = idPersonalEvaluador;
        this.apePaternoEvaluador = apePaternoEvaluador;
        this.apeMaternoEvaluador = apeMaternoEvaluador;
        this.codigoPerEvaluador = codigoPerEvaluador;
        this.nroDocEvaluador = nroDocEvaluador;
        this.nombreEvaluador = nombreEvaluador;
        this.idCargoPuestoEvaluador = idCargoPuestoEvaluador;
        this.descripcionCargoPuestoEvaluador = descripcionCargoPuestoEvaluador;
        this.flgEsCargoprincipalEvaluador = flgEsCargoprincipalEvaluador;
        this.flgPrincipalEvalEvaluador = flgPrincipalEvalEvaluador;
        this.idGrupoOcupacionalEvaluador = idGrupoOcupacionalEvaluador;
        this.descripcionGrupoOcupacionalEvaluador = descripcionGrupoOcupacionalEvaluador;
        this.idEvaluadoMaev = idEvaluadoMaev;
        this.idPersonalEvaluado = idPersonalEvaluado;
        this.apePaternoEvaluado = apePaternoEvaluado;
        this.apeMaternoEvaluado = apeMaternoEvaluado;
        this.codigoPerEvaluado = codigoPerEvaluado;
        this.nroDocEvaluado = nroDocEvaluado;
        this.nombreEvaluado = nombreEvaluado;
        this.idCargoPuestoEvaluado = idCargoPuestoEvaluado;
        this.descripcionCargoPuestoEvaluado = descripcionCargoPuestoEvaluado;
        this.flgEsCargoprincipalEvaluado = flgEsCargoprincipalEvaluado;
        this.flgPrincipalEvalEvaluado = flgPrincipalEvalEvaluado;
        this.idGrupoOcupacionalEvaluado = idGrupoOcupacionalEvaluado;
        this.descripcionGrupoOcupacionalEvaluado = descripcionGrupoOcupacionalEvaluado;
        this.idObraEncuesta = idObraEncuesta;
        this.totalPreguntasEncuesta = totalPreguntasEncuesta;
        this.flg_activoEncuesta = flg_activoEncuesta;
        this.flgEstadoEncuesta = flgEstadoEncuesta;
        this.fechaInicioEncuesta = fechaInicioEncuesta;
        this.fechaFinEncuesta = fechaFinEncuesta;
        this.fechaingEncuesta = fechaingEncuesta;
        this.creaporEncuesta = creaporEncuesta;
        this.fechamodiEncuesta = fechamodiEncuesta;
        this.modiporEncuesta = modiporEncuesta;
    }

    public Long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Long getIdMatrizevalEncuesta() {
        return idMatrizevalEncuesta;
    }

    public void setIdMatrizevalEncuesta(Long idMatrizevalEncuesta) {
        this.idMatrizevalEncuesta = idMatrizevalEncuesta;
    }

    public String getEstadoMaev() {
        return estadoMaev;
    }

    public void setEstadoMaev(String estadoMaev) {
        this.estadoMaev = estadoMaev;
    }

    public Long getIdPeriodoMaev() {
        return idPeriodoMaev;
    }

    public void setIdPeriodoMaev(Long idPeriodoMaev) {
        this.idPeriodoMaev = idPeriodoMaev;
    }

    public Integer getAnioPeri() {
        return anioPeri;
    }

    public void setAnioPeri(Integer anioPeri) {
        this.anioPeri = anioPeri;
    }

    public Long getIdEventoMaev() {
        return idEventoMaev;
    }

    public void setIdEventoMaev(Long idEventoMaev) {
        this.idEventoMaev = idEventoMaev;
    }

    public String getNombreEvent() {
        return nombreEvent;
    }

    public void setNombreEvent(String nombreEvent) {
        this.nombreEvent = nombreEvent;
    }

    public Long getIdEvaluadorMaev() {
        return idEvaluadorMaev;
    }

    public void setIdEvaluadorMaev(Long idEvaluadorMaev) {
        this.idEvaluadorMaev = idEvaluadorMaev;
    }

    public Long getIdPersonalEvaluador() {
        return idPersonalEvaluador;
    }

    public void setIdPersonalEvaluador(Long idPersonalEvaluador) {
        this.idPersonalEvaluador = idPersonalEvaluador;
    }

    public String getApePaternoEvaluador() {
        return apePaternoEvaluador;
    }

    public void setApePaternoEvaluador(String apePaternoEvaluador) {
        this.apePaternoEvaluador = apePaternoEvaluador;
    }

    public String getApeMaternoEvaluador() {
        return apeMaternoEvaluador;
    }

    public void setApeMaternoEvaluador(String apeMaternoEvaluador) {
        this.apeMaternoEvaluador = apeMaternoEvaluador;
    }

    public String getCodigoPerEvaluador() {
        return codigoPerEvaluador;
    }

    public void setCodigoPerEvaluador(String codigoPerEvaluador) {
        this.codigoPerEvaluador = codigoPerEvaluador;
    }

    public String getNroDocEvaluador() {
        return nroDocEvaluador;
    }

    public void setNroDocEvaluador(String nroDocEvaluador) {
        this.nroDocEvaluador = nroDocEvaluador;
    }

    public String getNombreEvaluador() {
        return nombreEvaluador;
    }

    public void setNombreEvaluador(String nombreEvaluador) {
        this.nombreEvaluador = nombreEvaluador;
    }

    public Long getIdCargoPuestoEvaluador() {
        return idCargoPuestoEvaluador;
    }

    public void setIdCargoPuestoEvaluador(Long idCargoPuestoEvaluador) {
        this.idCargoPuestoEvaluador = idCargoPuestoEvaluador;
    }

    public Long getDescripcionCargoPuestoEvaluador() {
        return descripcionCargoPuestoEvaluador;
    }

    public void setDescripcionCargoPuestoEvaluador(Long descripcionCargoPuestoEvaluador) {
        this.descripcionCargoPuestoEvaluador = descripcionCargoPuestoEvaluador;
    }

    public Boolean getFlgEsCargoprincipalEvaluador() {
        return flgEsCargoprincipalEvaluador;
    }

    public void setFlgEsCargoprincipalEvaluador(Boolean flgEsCargoprincipalEvaluador) {
        this.flgEsCargoprincipalEvaluador = flgEsCargoprincipalEvaluador;
    }

    public Boolean getFlgPrincipalEvalEvaluador() {
        return flgPrincipalEvalEvaluador;
    }

    public void setFlgPrincipalEvalEvaluador(Boolean flgPrincipalEvalEvaluador) {
        this.flgPrincipalEvalEvaluador = flgPrincipalEvalEvaluador;
    }

    public Integer getIdGrupoOcupacionalEvaluador() {
        return idGrupoOcupacionalEvaluador;
    }

    public void setIdGrupoOcupacionalEvaluador(Integer idGrupoOcupacionalEvaluador) {
        this.idGrupoOcupacionalEvaluador = idGrupoOcupacionalEvaluador;
    }

    public Integer getDescripcionGrupoOcupacionalEvaluador() {
        return descripcionGrupoOcupacionalEvaluador;
    }

    public void setDescripcionGrupoOcupacionalEvaluador(Integer descripcionGrupoOcupacionalEvaluador) {
        this.descripcionGrupoOcupacionalEvaluador = descripcionGrupoOcupacionalEvaluador;
    }

    public Long getIdEvaluadoMaev() {
        return idEvaluadoMaev;
    }

    public void setIdEvaluadoMaev(Long idEvaluadoMaev) {
        this.idEvaluadoMaev = idEvaluadoMaev;
    }

    public Long getIdPersonalEvaluado() {
        return idPersonalEvaluado;
    }

    public void setIdPersonalEvaluado(Long idPersonalEvaluado) {
        this.idPersonalEvaluado = idPersonalEvaluado;
    }

    public String getApePaternoEvaluado() {
        return apePaternoEvaluado;
    }

    public void setApePaternoEvaluado(String apePaternoEvaluado) {
        this.apePaternoEvaluado = apePaternoEvaluado;
    }

    public String getApeMaternoEvaluado() {
        return apeMaternoEvaluado;
    }

    public void setApeMaternoEvaluado(String apeMaternoEvaluado) {
        this.apeMaternoEvaluado = apeMaternoEvaluado;
    }

    public String getCodigoPerEvaluado() {
        return codigoPerEvaluado;
    }

    public void setCodigoPerEvaluado(String codigoPerEvaluado) {
        this.codigoPerEvaluado = codigoPerEvaluado;
    }

    public String getNroDocEvaluado() {
        return nroDocEvaluado;
    }

    public void setNroDocEvaluado(String nroDocEvaluado) {
        this.nroDocEvaluado = nroDocEvaluado;
    }

    public String getNombreEvaluado() {
        return nombreEvaluado;
    }

    public void setNombreEvaluado(String nombreEvaluado) {
        this.nombreEvaluado = nombreEvaluado;
    }

    public Long getIdCargoPuestoEvaluado() {
        return idCargoPuestoEvaluado;
    }

    public void setIdCargoPuestoEvaluado(Long idCargoPuestoEvaluado) {
        this.idCargoPuestoEvaluado = idCargoPuestoEvaluado;
    }

    public Long getDescripcionCargoPuestoEvaluado() {
        return descripcionCargoPuestoEvaluado;
    }

    public void setDescripcionCargoPuestoEvaluado(Long descripcionCargoPuestoEvaluado) {
        this.descripcionCargoPuestoEvaluado = descripcionCargoPuestoEvaluado;
    }

    public Boolean getFlgEsCargoprincipalEvaluado() {
        return flgEsCargoprincipalEvaluado;
    }

    public void setFlgEsCargoprincipalEvaluado(Boolean flgEsCargoprincipalEvaluado) {
        this.flgEsCargoprincipalEvaluado = flgEsCargoprincipalEvaluado;
    }

    public Boolean getFlgPrincipalEvalEvaluado() {
        return flgPrincipalEvalEvaluado;
    }

    public void setFlgPrincipalEvalEvaluado(Boolean flgPrincipalEvalEvaluado) {
        this.flgPrincipalEvalEvaluado = flgPrincipalEvalEvaluado;
    }

    public Integer getIdGrupoOcupacionalEvaluado() {
        return idGrupoOcupacionalEvaluado;
    }

    public void setIdGrupoOcupacionalEvaluado(Integer idGrupoOcupacionalEvaluado) {
        this.idGrupoOcupacionalEvaluado = idGrupoOcupacionalEvaluado;
    }

    public Integer getDescripcionGrupoOcupacionalEvaluado() {
        return descripcionGrupoOcupacionalEvaluado;
    }

    public void setDescripcionGrupoOcupacionalEvaluado(Integer descripcionGrupoOcupacionalEvaluado) {
        this.descripcionGrupoOcupacionalEvaluado = descripcionGrupoOcupacionalEvaluado;
    }

    public String getIdObraEncuesta() {
        return idObraEncuesta;
    }

    public void setIdObraEncuesta(String idObraEncuesta) {
        this.idObraEncuesta = idObraEncuesta;
    }

    public Integer getTotalPreguntasEncuesta() {
        return totalPreguntasEncuesta;
    }

    public void setTotalPreguntasEncuesta(Integer totalPreguntasEncuesta) {
        this.totalPreguntasEncuesta = totalPreguntasEncuesta;
    }

    public Boolean getFlg_activoEncuesta() {
        return flg_activoEncuesta;
    }

    public void setFlg_activoEncuesta(Boolean flg_activoEncuesta) {
        this.flg_activoEncuesta = flg_activoEncuesta;
    }

    public String getFlgEstadoEncuesta() {
        return flgEstadoEncuesta;
    }

    public void setFlgEstadoEncuesta(String flgEstadoEncuesta) {
        this.flgEstadoEncuesta = flgEstadoEncuesta;
    }

    public Date getFechaInicioEncuesta() {
        return fechaInicioEncuesta;
    }

    public void setFechaInicioEncuesta(Date fechaInicioEncuesta) {
        this.fechaInicioEncuesta = fechaInicioEncuesta;
    }

    public Date getFechaFinEncuesta() {
        return fechaFinEncuesta;
    }

    public void setFechaFinEncuesta(Date fechaFinEncuesta) {
        this.fechaFinEncuesta = fechaFinEncuesta;
    }

    public Date getFechaingEncuesta() {
        return fechaingEncuesta;
    }

    public void setFechaingEncuesta(Date fechaingEncuesta) {
        this.fechaingEncuesta = fechaingEncuesta;
    }

    public String getCreaporEncuesta() {
        return creaporEncuesta;
    }

    public void setCreaporEncuesta(String creaporEncuesta) {
        this.creaporEncuesta = creaporEncuesta;
    }

    public Date getFechamodiEncuesta() {
        return fechamodiEncuesta;
    }

    public void setFechamodiEncuesta(Date fechamodiEncuesta) {
        this.fechamodiEncuesta = fechamodiEncuesta;
    }

    public String getModiporEncuesta() {
        return modiporEncuesta;
    }

    public void setModiporEncuesta(String modiporEncuesta) {
        this.modiporEncuesta = modiporEncuesta;
    }
}
