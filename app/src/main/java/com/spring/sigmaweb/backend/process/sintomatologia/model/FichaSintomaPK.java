package com.spring.sigmaweb.backend.process.sintomatologia.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FichaSintomaPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private FichaSintomatologica ficha;

    @ManyToOne
    @JoinColumn(name = "id_sintoma")
    private Sintoma sintoma;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaSintomaPK that = (FichaSintomaPK) o;
        return Objects.equals(ficha, that.ficha) && Objects.equals(sintoma, that.sintoma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ficha, sintoma);
    }
}
