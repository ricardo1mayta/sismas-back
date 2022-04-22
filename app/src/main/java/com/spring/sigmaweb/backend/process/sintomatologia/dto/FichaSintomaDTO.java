package com.spring.sigmaweb.backend.process.sintomatologia.dto;

import com.spring.sigmaweb.backend.process.sintomatologia.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FichaSintomaDTO {
    public FichaSintomatologicaDTO ficha;
    public SintomaDTO sintoma;
}
