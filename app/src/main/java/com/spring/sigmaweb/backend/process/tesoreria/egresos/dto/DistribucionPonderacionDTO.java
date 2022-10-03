package com.spring.sigmaweb.backend.process.tesoreria.egresos.dto;

import com.spring.sigmaweb.backend.process.tesoreria.egresos.model.DistribucionPonderacionDetalle;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DistribucionPonderacionDTO {

    private Long idDistribucionPonderacion;
    private Integer idTipoDistribucionPonderacion;
    private String nombreDistribucion;
    private String periodo;
    private String idObra;
    private Boolean flgCalculoAutomatico;
    private Boolean flgEstado;

    List<DistribucionPonderacionDetalle> distribucionPonderacionDetalle;
}
