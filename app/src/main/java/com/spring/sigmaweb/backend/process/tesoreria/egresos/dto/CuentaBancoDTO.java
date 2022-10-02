package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancoDTO {

    private Long idCuentaBanco;
    private EntidadDatosDTO entidadBanco;
    private String numeroCuenta;
    private Integer cuentaContableBanco;
    private Integer idTipoCuentaBanco;
    private Integer idTipoMoneda;
    private String descripcion;
    private Date fechaApertura;
    private String creaporPer;
    private Date fechaRegistro;
    private String modipoPer;
    private String fechaActualiza;
    private String idObra;
    private Boolean flgEstado;
    private Boolean flgEgreso;

    @JsonIgnoreProperties({"cuentaBanco","hibernateLazyInitializer", "handler" })
    private List<TarjetaCreditoDTO> tarjetaCredito;
}
