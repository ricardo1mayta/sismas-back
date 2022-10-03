package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
public class SolicitudGeneralListaDTO  implements Serializable {
    private Long idSolicitudGeneral;
    private Long idPersonal;
    private String nombrePers;

    private Long idCargo;
    private String nombreCargo;
//    private Long idConcepto;
//    private String nombreConcepto;
//    private String descConcepto;
    private String detalle;
    private Integer idTipoMoneda;
    private String tipoMoneda;
    private String modoPago;
    private BigDecimal importeSolicitado;
    private BigDecimal importeAprobado;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaSolicitud;
    private Integer cuentaPlanContable;
    private String nombrePlanContable;
    private String estado;
    private Integer idestadoSolicitud;
    private Long idtipoSolicitud;
    private String nombreTipoSolicitud;

    public SolicitudGeneralListaDTO(Long idSolicitudGeneral, Long idPersonal, String nombrePers, Long idCargo, String nombreCargo, String detalle, Integer idTipoMoneda, String tipoMoneda, BigDecimal importeSolicitado, BigDecimal importeAprobado, Date fechaSolicitud, Integer cuentaPlanContable, String nombrePlanContable, String estado, Integer idestadoSolicitud, Long idtipoSolicitud, String nombreTipoSolicitud) {
        this.idSolicitudGeneral = idSolicitudGeneral;
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        this.detalle = detalle;
        this.idTipoMoneda = idTipoMoneda;
        this.tipoMoneda = tipoMoneda;
        this.importeSolicitado = importeSolicitado;
        this.importeAprobado = importeAprobado;
        this.fechaSolicitud = fechaSolicitud;
        this.cuentaPlanContable = cuentaPlanContable;
        this.nombrePlanContable = nombrePlanContable;
        this.estado = estado;
        this.idestadoSolicitud = idestadoSolicitud;
        this.idtipoSolicitud = idtipoSolicitud;
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }

    public SolicitudGeneralListaDTO(Long idSolicitudGeneral, Long idPersonal, String nombrePers, Long idCargo, String nombreCargo, String detalle, Integer idTipoMoneda, String tipoMoneda, String modoPago, BigDecimal importeSolicitado, BigDecimal importeAprobado, Date fechaSolicitud, String estado, Integer idestadoSolicitud, Long idtipoSolicitud, String nombreTipoSolicitud) {
        this.idSolicitudGeneral = idSolicitudGeneral;
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        this.detalle = detalle;
        this.idTipoMoneda = idTipoMoneda;
        this.tipoMoneda = tipoMoneda;
        this.modoPago = modoPago;
        this.importeSolicitado = importeSolicitado;
        this.importeAprobado = importeAprobado;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.idestadoSolicitud = idestadoSolicitud;
        this.idtipoSolicitud = idtipoSolicitud;
        this.nombreTipoSolicitud = nombreTipoSolicitud;
    }

    public SolicitudGeneralListaDTO(){}

    private static final long serialVersionUID = 1L;
}

