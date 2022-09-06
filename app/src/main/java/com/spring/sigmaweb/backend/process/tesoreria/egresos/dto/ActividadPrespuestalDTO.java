package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;


import java.math.BigDecimal;

public  class ActividadPrespuestalDTO {
    private Long id;
    private String codigoActividad;
    private String nombreActividad;
    private BigDecimal importe;
    private Integer periodo;
    private String idObra;
}
