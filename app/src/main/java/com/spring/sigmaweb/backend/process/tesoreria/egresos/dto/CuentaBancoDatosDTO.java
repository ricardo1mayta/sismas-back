package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancoDatosDTO {
    private Long idCuentaBanco;
    private EntidadDatosDTO entidadBanco;
    private String numeroCuenta;
    private Integer cuentaContableBanco;
    private Integer idTipoCuentaBanco;
    private Integer idTipoMoneda;
    private String descripcion;
    private String idObra;
    private Boolean flgEstado;

    @JsonIgnoreProperties({"cuentaBanco","hibernateLazyInitializer", "handler" })
    private List<TarjetaCreditoDTO> tarjetaCredito;
}
