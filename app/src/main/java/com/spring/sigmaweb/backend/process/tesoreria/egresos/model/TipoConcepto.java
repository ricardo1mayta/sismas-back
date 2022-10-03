package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_tipo_concepto")
public class TipoConcepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoConcepto;
    private String nombreTipoConcepto;
    private Boolean flgIngreso;
    private String creaporPer;
    private LocalDateTime fechaRegistro;

}
