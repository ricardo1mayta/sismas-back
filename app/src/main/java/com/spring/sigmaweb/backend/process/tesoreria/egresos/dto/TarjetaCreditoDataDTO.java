package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaCreditoDataDTO implements Serializable {

    private Long idTarjetaCredito;

    private Long idCuentaBanco;
    private String cuentaBanco;
    private String nroCuentaBanco;

    private Long idPersonal;
    private String apePaternoPersona;
    private String apeMaternoPersona;
    private String nombresPersona;
    private String nombreCompletoPersona;
    private String nroDocPersona;
    private String codigoPersonal;

    private String numeroTarjeta;
    private String idObra;
    private Date fechaRegistro;
    private Date fechaActualiza;
    private Boolean flgEstado;
/*
    public TarjetaCreditoDataDTO() {
        super();
    }

    public TarjetaCreditoDataDTO(Long idTarjetaCredito, Long idCuentaBanco, String cuentaBanco, String nroCuentaBanco, Long idPersonal, String apePaternoPersona, String apeMaternoPersona, String nombresPersona, String nombreCompletoPersona, String nroDocPersona, String codigoPersonal, String numeroTarjeta, String idObra, Date fechaRegistro, Date fechaActualiza, Boolean flgEstado) {
        this.idTarjetaCredito = idTarjetaCredito;
        this.idCuentaBanco = idCuentaBanco;
        this.cuentaBanco = cuentaBanco;
        this.nroCuentaBanco = nroCuentaBanco;
        this.idPersonal = idPersonal;
        this.apePaternoPersona = apePaternoPersona;
        this.apeMaternoPersona = apeMaternoPersona;
        this.nombresPersona = nombresPersona;
        this.nombreCompletoPersona = nombreCompletoPersona;
        this.nroDocPersona = nroDocPersona;
        this.codigoPersonal = codigoPersonal;
        this.numeroTarjeta = numeroTarjeta;
        this.idObra = idObra;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualiza = fechaActualiza;
        this.flgEstado = flgEstado;
    }*/

}
