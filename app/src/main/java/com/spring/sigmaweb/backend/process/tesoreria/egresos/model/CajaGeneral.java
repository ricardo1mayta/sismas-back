package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mt_caja_general")
public class CajaGeneral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , unique = true)
    private Long idCajaGeneral;
    private String idObra;
    private Long idCaja;
    private Long idUsuario;
    private Long idPeriodo;
    private Long idSupervizor;
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
}
