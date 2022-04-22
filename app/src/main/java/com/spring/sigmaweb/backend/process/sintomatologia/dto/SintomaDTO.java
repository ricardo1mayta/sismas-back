package com.spring.sigmaweb.backend.process.sintomatologia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {
    private Long idSintoma;
    private String descripcion;
    private Boolean flag;
}
