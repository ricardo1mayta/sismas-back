package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_categoria_plan_contable")
public class CategoriaPlanContable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoriaPlanContable;

    private String nombreCategoriaContable;
    private String observacion;
    private Boolean flgEstado;
    private Date fechaRegistro;
    private String creaporPer;
    private String grupo;
}
