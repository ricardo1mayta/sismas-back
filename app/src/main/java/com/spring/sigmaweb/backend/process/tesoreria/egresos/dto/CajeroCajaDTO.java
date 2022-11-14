package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CajeroCajaDTO {

    private String idCajero_caja ;
    private String idObra;

    private Long idCaja;
    private String nombreCaja;
    private Boolean flgEstadoCaja;

    private Long idUsuario;
    private String username;
    private String apePaternoUsuario;
    private String apeMaternoUsuario;
    private String apeNombresUsuario;
    private Boolean activoUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    private Boolean flgEstado;
    private String creapor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaRegistro;

    private String modificadoPor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaActualiza;

    public CajeroCajaDTO(String idCajero_caja, String idObra, Long idCaja, String nombreCaja, Boolean flgEstadoCaja, Long idUsuario, String username, String apePaternoUsuario, String apeMaternoUsuario, String apeNombresUsuario, Boolean activoUsuario, Date fechaInicio, Date fechaFin, Boolean flgEstado, String creapor, Date fechaRegistro, String modificadoPor, Date fechaActualiza) {
        this.idCajero_caja = idCajero_caja;
        this.idObra = idObra;
        this.idCaja = idCaja;
        this.nombreCaja = nombreCaja;
        this.flgEstadoCaja = flgEstadoCaja;
        this.idUsuario = idUsuario;
        this.username = username;
        this.apePaternoUsuario = apePaternoUsuario;
        this.apeMaternoUsuario = apeMaternoUsuario;
        this.apeNombresUsuario = apeNombresUsuario;
        this.activoUsuario = activoUsuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.flgEstado = flgEstado;
        this.creapor = creapor;
        this.fechaRegistro = fechaRegistro;
        this.modificadoPor = modificadoPor;
        this.fechaActualiza = fechaActualiza;
    }
}
