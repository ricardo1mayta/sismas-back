package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "mt_distribucion_ponderacion")
public class DistribucionPonderacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistribucionPonderacion;
    private Integer idTipoDistribucionPonderacion;
    private String nombreDistribucion;
    private String periodo;
    private String idObra;
    private Date fechaRegistro;
    private Boolean flgCalculoAutomatico;

    private Boolean flgEstado;

    @JsonIgnoreProperties({"distribucionPonderacion","hibernateLazyInitializer", "handler" })
    @OneToMany(mappedBy = "distribucionPonderacion",cascade = { CascadeType.ALL})
    List<DistribucionPonderacionDetalle> distribucionPonderacionDetalle;

}
