package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaPlanContableDTO {

    private Long idCategoriaPlanContable;
    private String nombreCategoriaContable;
    private String observacion;
    private Boolean flgEstado;
    private Date fechaRegistro;
    private String creaporPer;
    private String grupo;
}
