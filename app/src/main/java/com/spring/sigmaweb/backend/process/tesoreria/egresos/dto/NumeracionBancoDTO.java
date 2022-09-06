package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class NumeracionBancoDTO {

    private Long idNumeracionDocumento;
    private Integer tipoDocumento;
    private Integer idTipoModoPago;

    @JsonIgnoreProperties(value = {"cuentaBanco","hibernateLazyInitializer", "handler" }, allowSetters = true)
    private EntidadDatosDTO entidadBanco;
    private CuentaBancoDatosDTO cuentaBanco;
    private String nombre;
    private String numeracionInicio;
    private String numeracionFin;
    private String numeracionActual;
    private String observacion;
    private Boolean flgEstado;
    private String idObra;
}
