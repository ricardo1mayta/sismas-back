package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.dto.PersonaInfoDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.EntidadDataSelectDTO;
import com.spring.sigmaweb.backend.process.legajo.dto.PersonalDatosListDTO;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.ActividadPresupuestal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudGeneralDTO {

    private Long idSolicitudGeneral;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private PersonalDatosListDTO personal;

    private String idObra;

//    private ConceptoDTO Concepto;

    private PlanContableDTO planContable;

    private TipoSolicitudDTO tipoSolicitud;

    private Integer idTipoMoneda;
    private BigDecimal importeSolicitado;
    private BigDecimal importeAprobado;

    private Date fechaSolicitud;

//    private CentroResponsabilidadDTO centroResponsabilidad;

    private String motivo;
    private String detalle;
    private Integer idEstado;
    private Long idUsuarioAutoriza;
    private String creaporPer;
    private Date fechaRegistro;
    private String modiporPer;
    private Date fechaActualiza;
    private String idResponsableCheque;
    private String idEstadoRendimiento;
    private String idTipoResponsableCheque;
    private Integer idTipoModoPago;
    private CuentaBancoDTO cuentaBanco;

    private TarjetaCreditoDTO tarjetaCredito;

    private Boolean flgCr;

    private ActividadPresupuestal actividadPresupuestal;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private PersonalDatosListDTO personalCargo;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private PersonaInfoDTO personaCargo;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private EntidadDataSelectDTO entidadCargo;

    @JsonIgnoreProperties({"solicitudGeneral","hibernateLazyInitializer", "handler" })
    private List<SolicitudGeneralDetalleDTO> solicitudGeneralDetalle;
}
