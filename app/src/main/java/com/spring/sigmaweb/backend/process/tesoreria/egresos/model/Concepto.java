package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_concepto")
public class Concepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConcepto;

    private String nombreConcepto;

    private String descConcepto;


    @ManyToOne()
    @JoinColumn(name = "id_tipo_concepto")
    private TipoConcepto tipoConcepto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_debe")
    private PlanContable cuentaDebe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_haber")
    private PlanContable cuentaHaber;

    private Boolean flgShowEstudiante;
    private Boolean flgShowExalumno;
    private Boolean flgShowExterno;
    private Boolean flgShowHijoExalumno;
    private Boolean flgShowHijoEmpleado;
    private Boolean flgProgramacion;
    private Boolean flgPrecio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_centro_responsabilidad")
    private CentroResponsabilidad centroResponsabilidad;

    private Boolean  flgEstado;
    private LocalDateTime fechaRegistro;
    private String modiporPer;
    private LocalDateTime fechaActualiza;
    private Long idGradoAcademico;
    private Boolean flgCentroResponsabilidad;
    private String creaporPer;

}
