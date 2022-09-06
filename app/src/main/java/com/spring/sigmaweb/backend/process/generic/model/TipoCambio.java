package com.spring.sigmaweb.backend.process.generic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="mt_tipo_cambio")
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoCambio;
    private Date fecha;
    private Integer idTipoMoneda;
    private Float tipoCambioVenta;
    private Float tipoCambioCompra;
    private String creaporPer;
    private Date fechaRegistro;
    private String idObra;
    private Boolean flgEstado;
}
