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
@Table(name = "mt_plan_contable")
public class PlanContable {
    @Id
    private Long idPlanContable;
    private String nombrePlanContable;
    private Integer cuentaPlanContable;

    @ManyToOne
    @JoinColumn(name = "id_categoria_plan_contable")
    private CategoriaPlanContable categoriaPlanContable;

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
