package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoSolicitudDTO {
    private Long idTipoSolicitud;
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
