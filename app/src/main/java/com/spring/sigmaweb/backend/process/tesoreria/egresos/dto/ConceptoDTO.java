package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConceptoDTO {

    private Long idConcepto;
    private String nombreConcepto;
    private String descConcepto;
    private TipoConceptoDTO tipoConcepto;
    private PlanContableDTO cuentaDebe;
    private PlanContableDTO cuentaHaber;
    private Boolean flgShowEstudiante;
    private Boolean flgShowExalumno;
    private Boolean flgShowExterno;
    private Boolean flgShowHijoExalumno;
    private Boolean flgShowHijoEmpleado;
    private Boolean flgProgramacion;
    private Boolean flgPrecio;
    private CentroResponsabilidadDTO centroResponsabilidad;
    private Boolean  flgEstado;



    private LocalDateTime fechaRegistro;
    private String modiporPer;

    private LocalDateTime fechaActualiza;
    private Long idGradoAcademico;
    private Boolean flgCentroResponsabilidad;
    private String creaporPer;
}
