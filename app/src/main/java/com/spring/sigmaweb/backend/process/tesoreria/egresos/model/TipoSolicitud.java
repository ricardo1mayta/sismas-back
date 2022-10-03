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
@Table(name = "mm_tipo_solicitud")
public class TipoSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoSolicitud;
    private Integer idTipo;
    private String nombreTipoSolicitud;
    private Integer idTipoAmbitoSol;
    private String idTipoAutoriza1;
    private Long idAutoriza1;
    private Integer ans1;
    private Integer ans2;
    private Boolean flgAutoescala;
    private Boolean flgEstado;
    private String creaporPer;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaActualiza;
}
