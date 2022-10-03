package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntidadDatosDTO {
    private Long idEntidad;
    private String obraEnt;
    private String rucEnt;
    private String nombreEnt;
    private String nombreComerEnt;
}
