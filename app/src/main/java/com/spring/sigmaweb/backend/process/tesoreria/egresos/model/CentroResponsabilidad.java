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
@Table(name = "mt_centro_responsabilidad")
public class CentroResponsabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCentroResponsabilidad;
    private String nombreCentroResponsabilidad;
    private String descCentroResponsabilidad;
    private Long idNivel1;
    private Long idNivel2;
    private Long idNivel3;
    private Long idNivel4;
    private Long idNivel5;
    private Integer codigoCentroResponsabilidad;
    private String creaporPer;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaActualiza;
    private Boolean flgObra;
    private Long idPadre;
//    @ManyToOne
//    @JoinColumn(name="id_padre", insertable=false, updatable=false)
//    private CentroResponsabilidad idPadre;
    private Boolean flgOut;
    private Integer tipo;
    private Boolean flgEstado;
}
