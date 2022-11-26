package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.Caja;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CajaGeneralDTO implements Serializable {
    private Long idCajaGeneral;
    private String idObra;
    private Caja idCaja;
    private String nombreCaja;
    private Long idUsuario;
    private String nomCompletoUsuario;

    private Long idPeriodo;
    private Integer anioPeri;
    private Long idSupervizor;
    private String nomCompletoSupervizor;

    private Double aperturaSol;
    private Double aperturaDolar;
    private Double ingresoSol;
    private Double ingresoDolar;
    private Double ingresoPos1;
    private Double ingresoPos2;
    private Double engresoSol;
    private Double engresoDolar;
    private Double saldoSol;
    private Double saldoDolar;
    private Double diferenciaSol;
    private Double diferenciaDolar;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaApertura;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaCierre;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaDeposito;

    private String rucBanco;
    private String numCuentaSol;
    private String numCuentaDolar;
    private String numOperacionSol;
    private String numOperacionDolar;
    private Double montoDepositoSol;
    private Double montoDepositoDolar;

    private Boolean flgTipoCajageneral;
    private Integer idTipoCajageneral;

    private String creapor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaRegistro;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private String modificadoPor;

    private Date fechaActualiza;

    public CajaGeneralDTO(Long idCajaGeneral, String idObra, Caja idCaja, String nombreCaja, Long idUsuario, String nomCompletoUsuario, Long idPeriodo, Integer anioPeri, Long idSupervizor, String nomCompletoSupervizor, Double aperturaSol, Double aperturaDolar, Double ingresoSol, Double ingresoDolar, Double ingresoPos1, Double ingresoPos2, Double engresoSol, Double engresoDolar, Double saldoSol, Double saldoDolar, Double diferenciaSol, Double diferenciaDolar, Date fechaApertura, Date fechaCierre, Date fechaDeposito, String rucBanco, String numCuentaSol, String numCuentaDolar, String numOperacionSol, String numOperacionDolar, Double montoDepositoSol, Double montoDepositoDolar, Boolean flgTipoCajageneral, Integer idTipoCajageneral, String creapor, Date fechaRegistro, String modificadoPor, Date fechaActualiza) {
        this.idCajaGeneral = idCajaGeneral;
        this.idObra = idObra;
        this.idCaja = idCaja;
        this.nombreCaja = nombreCaja;
        this.idUsuario = idUsuario;
        this.nomCompletoUsuario = nomCompletoUsuario;
        this.idPeriodo = idPeriodo;
        this.anioPeri = anioPeri;
        this.idSupervizor = idSupervizor;
        this.nomCompletoSupervizor = nomCompletoSupervizor;
        this.aperturaSol = aperturaSol;
        this.aperturaDolar = aperturaDolar;
        this.ingresoSol = ingresoSol;
        this.ingresoDolar = ingresoDolar;
        this.ingresoPos1 = ingresoPos1;
        this.ingresoPos2 = ingresoPos2;
        this.engresoSol = engresoSol;
        this.engresoDolar = engresoDolar;
        this.saldoSol = saldoSol;
        this.saldoDolar = saldoDolar;
        this.diferenciaSol = diferenciaSol;
        this.diferenciaDolar = diferenciaDolar;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.fechaDeposito = fechaDeposito;
        this.rucBanco = rucBanco;
        this.numCuentaSol = numCuentaSol;
        this.numCuentaDolar = numCuentaDolar;
        this.numOperacionSol = numOperacionSol;
        this.numOperacionDolar = numOperacionDolar;
        this.montoDepositoSol = montoDepositoSol;
        this.montoDepositoDolar = montoDepositoDolar;
        this.flgTipoCajageneral = flgTipoCajageneral;
        this.idTipoCajageneral = idTipoCajageneral;
        this.creapor = creapor;
        this.fechaRegistro = fechaRegistro;
        this.modificadoPor = modificadoPor;
        this.fechaActualiza = fechaActualiza;
    }
}
