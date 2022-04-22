package com.spring.sigmaweb.backend.process.sintomatologia.dto;

import com.spring.sigmaweb.backend.process.sintomatologia.model.Enfermedad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FichaListEnfermedad {
    private  FichaSintomatologicaDTO ficha;
    private List<EnfermedadDTO> listEnfermedad;
}
