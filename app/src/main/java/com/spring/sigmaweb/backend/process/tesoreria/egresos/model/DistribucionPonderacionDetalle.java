package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_distribucion_ponderacion_detalle")
public class DistribucionPonderacionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistribucionPonderacionDetalle;

    @JsonIgnoreProperties(value = {"distribucionPonderacionDetalle","hibernateLazyInitializer", "handler" })
    @ManyToOne
    @JoinColumn(name = "id_distribucion_ponderacion")
    private DistribucionPonderacion distribucionPonderacion;
    private String nombreDistribucionDetalle;

    @ManyToOne
    @JoinColumn(name = "id_centro_responsabilidad")
    private CentroResponsabilidad centroResponsabilidad;

    private Integer medidaNumerico;
    private BigDecimal medidaPorcentual;
    private Boolean flgCalculo;
    private String periodo;
    private Boolean flgEstado;

}

