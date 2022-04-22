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
@Table(name = "ms_ficha_sintoma")
@IdClass(FichaSintomaPK.class)
public class FichaSintoma {

    @Id
    FichaSintomatologica ficha;

    @Id
    Sintoma sintoma;

}
