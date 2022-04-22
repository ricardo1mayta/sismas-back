package com.spring.sigmaweb.backend.process.sintomatologia.dto;

import com.spring.sigmaweb.backend.process.sintomatologia.model.Enfermedad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FichaEnfermedadDTO {
    private FichaSintomatologicaDTO ficha;
    private EnfermedadDTO enfermedad;

}
