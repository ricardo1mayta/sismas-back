package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ImpresoraCajaDTO implements Serializable {

    private String idImpresoraCaja;
    private String idObra;
    private Long idCaja;
    private String nombreCaja;
    private Boolean flgEstadoCaja;

    private Long idImpresora;
    private String nombreImpresora;
    private String serie;
    private Long inicio;
    private Long fin;
    private Long actual;
    private Integer idTipoDocumento;
    private String tipoDocumento;
    private Boolean flgEstadoImpresora;

    private Boolean flgEstadoIP;
    private String creapor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaRegistro;

    private String modificadoPor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaActualiza;

    public ImpresoraCajaDTO(String idImpresoraCaja, String idObra, Long idCaja, String nombreCaja, Boolean flgEstadoCaja, Long idImpresora, String nombreImpresora, String serie, Long inicio, Long fin, Long actual, Integer idTipoDocumento, String tipoDocumento, Boolean flgEstadoImpresora, Boolean flgEstadoIP, String creapor, Date fechaRegistro, String modificadoPor, Date fechaActualiza) {
        this.idImpresoraCaja = idImpresoraCaja;
        this.idObra = idObra;
        this.idCaja = idCaja;
        this.nombreCaja = nombreCaja;
        this.flgEstadoCaja = flgEstadoCaja;
        this.idImpresora = idImpresora;
        this.nombreImpresora = nombreImpresora;
        this.serie = serie;
        this.inicio = inicio;
        this.fin = fin;
        this.actual = actual;
        this.idTipoDocumento = idTipoDocumento;
        this.tipoDocumento = tipoDocumento;
        this.flgEstadoImpresora = flgEstadoImpresora;
        this.flgEstadoIP = flgEstadoIP;
        this.creapor = creapor;
        this.fechaRegistro = fechaRegistro;
        this.modificadoPor = modificadoPor;
        this.fechaActualiza = fechaActualiza;
    }
}
