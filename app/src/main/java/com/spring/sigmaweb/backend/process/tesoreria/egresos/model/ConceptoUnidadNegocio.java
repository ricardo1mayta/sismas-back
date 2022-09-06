package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_concepto_unidad_negocio")
public class ConceptoUnidadNegocio {
    @Id
    private Long idconceptoUnidad;

    @ManyToOne
    @JoinColumn(name = "id_concepto_id_solicitud_egreso")
    private Concepto idConcepto;

    private BigDecimal importe;
    private Boolean flgDsctoEstudiante;
    private Boolean flgDsctoExterno;
    private Boolean flgDsctoExalumno;
    private Boolean flDsctogHijoExalumno;
    private Boolean flgDsctoHijoEmpleado;
    private Boolean flgDsctoBeca;
    private BigDecimal dsctoAlumno;
    private BigDecimal dsctoEmpleado;
    private BigDecimal dsctoExalumno;
    private BigDecimal desctoExterno;
    private Boolean flgEstado;
    private String creaporPer;
    private LocalDateTime fechaRegistro;
    private String modiporPer;
    private LocalDateTime fechaActualiza;
    private Integer idTipoMoneda;



}
