package com.spring.sigmaweb.backend.process.sintomatologia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ms_ficha_enfermedad")
@IdClass(FichaEnfermedadPK.class)
public class FichaEnfermedad {

    @Id
   private FichaSintomatologica ficha;

    @Id
    private Enfermedad enfermedad;
}
