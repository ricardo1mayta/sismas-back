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
public class CentroResponsabilidadDTO {

    private Long idCentroResponsabilidad;
    private String nombreCentroResponsabilidad;
    private String descCentroResponsabilidad;
    private Long idNivel1;
    private Long idNivel2;
    private Long idNivel3;
    private Long idNivel4;
    private Long idNivel5;
    private Integer codigoCentroResponsabilidad;
    private String creaporPer;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaActualiza;
    private Boolean flgObra;
    private Long idPadre;
    private Boolean flgOut;
    private Integer tipo;
    private Boolean flgEstado;
}
