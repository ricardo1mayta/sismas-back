package com.spring.sigmaweb.backend.process.sintomatologia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ms_personal_ficha_sintomatologica")
public class FichaSintomatologica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFicha;

    @JsonIgnoreProperties(value = {"personal", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "id_personal")
    Personal personal;

    String telefono;
    String edad;
    String peso;
    String talla;
    Date fechaRegistro;
    String observacion;
    Boolean flagContactoCovid;
    String email;
    String idObra;
    Date fechaActualizacion;
}
