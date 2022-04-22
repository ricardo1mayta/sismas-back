package com.spring.sigmaweb.backend.process.sintomatologia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ms_sintoma")
public class Sintoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSintoma;
    private String descripcion;
    private Boolean flag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sintoma sintoma = (Sintoma) o;
        return Objects.equals(idSintoma, sintoma.idSintoma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSintoma);
    }
}
