package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaCreditoDTO {

    private Long idTarjetaCredito;
    @JsonIgnoreProperties(value = {"tarjetaCredito","hibernateLazyInitializer", "handler" }, allowSetters = true)
    private CuentaBancoDatosDTO cuentaBanco;
    private PersonalDatosListDTO personal;
    private String numeroTarjeta;
    private String idObra;
    private String fechaRegistro;
    private Boolean flgEstado;
}
