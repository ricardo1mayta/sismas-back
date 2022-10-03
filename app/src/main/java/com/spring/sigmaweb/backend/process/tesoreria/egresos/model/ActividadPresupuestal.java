package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_actividad_presupuestal")
public class ActividadPresupuestal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividadPresupuestal;
    private String codigoActividad;
    private String nombreActividad;
    private BigDecimal importe;
    private Integer periodo;
    private String idObra;
}
