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
public class TipoConceptoDTO {
    private Long idTipoConcepto;
    private String nombreTipoConcepto;
    private Boolean flgIngreso;
    private String creaporPer;
    private LocalDateTime fechaRegistro;
}
