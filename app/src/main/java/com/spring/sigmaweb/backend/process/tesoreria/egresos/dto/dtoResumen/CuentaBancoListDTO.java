package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.dtoResumen;

import com.spring.sigmaweb.backend.process.legajo.model.Entidad;
import com.spring.sigmaweb.backend.process.tesoreria.egresos.dto.EntidadDatosDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBancoListDTO {

    private Long idCuentaBanco;
    private String numeroCuenta;
    private String nombreEntidadBanco;
    private String rucBanco;
    private Integer idTipoCuentaBanco;
    private String tipoCuentaBanco;
    private Integer idTipoMoneda;
    private String tipoMoneda;
    private String descripcion;
    private Date fechaApertura;
    private Date fechaCierre;
    private Boolean flgEstado;
}
