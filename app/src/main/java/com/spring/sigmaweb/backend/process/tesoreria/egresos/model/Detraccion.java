package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mt_detraccion")
public class Detraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetraccion;
    private String descripcion;
    private BigDecimal valorPorcentual;
    private String idObra;
    private Date creaporPer;
    private Date fechaRegistro;
    private String modiporPer;
    private Date fechaActualiza;
    private Boolean flgEstado;

}
