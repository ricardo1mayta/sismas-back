package com.spring.sigmaweb.backend.process.generic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class TipoCambioDTO implements Serializable {
    private Long idTipoCambio;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date fecha;

    private Integer idTipoMoneda;
    private String tipoMoneda;
    private Float tipoCambioVenta;
    private Float tipoCambioCompra;
    private String creaporPer;
    private Date fechaRegistro;
    private String idObra;
    private Boolean flgEstado;


}
