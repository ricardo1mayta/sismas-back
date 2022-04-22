package com.spring.sigmaweb.backend.process.sintomatologia.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FichaEnfermedadPK  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private FichaSintomatologica ficha;

    @ManyToOne
    @JoinColumn(name = "id_enfermedad")
    private Enfermedad enfermedad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaEnfermedadPK that = (FichaEnfermedadPK) o;
        return Objects.equals(ficha, that.ficha) && Objects.equals(enfermedad, that.enfermedad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ficha, enfermedad);
    }

}
