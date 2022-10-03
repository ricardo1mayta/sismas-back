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
public class PlanContableDTO {

    private Long idPlanContable;
    private String nombrePlancontable;
    private Integer cuentaPlanContable;

    private CategoriaPlanContableDTO categoriaPlanContable;
    private Integer idTipoGrupoCuenta;
    private Integer idTipoCuenta;
    private Boolean nivel;
    private String anexoRef;
    private Boolean cencos;
    private Boolean docRef;
    private Boolean fecVen;
    private Boolean are;
    private String regCta;
    private Integer idTipoMoneda;
    private Boolean conban;
    private Integer idEstadoFin;
    private String creaporPer;
    private LocalDateTime fechaRegistro;
    private String modiporPer;
    private LocalDateTime fechaActualiza;
}

