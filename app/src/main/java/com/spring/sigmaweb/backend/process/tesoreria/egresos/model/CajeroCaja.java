package com.spring.sigmaweb.backend.process.tesoreria.egresos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mt_cajero_caja")
public class CajeroCaja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long idCajeroCaja ;

    private Long idCaja;
    private Long idUsuario;
    private String idObra;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    private Boolean flgEstado;
    private String creapor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaRegistro;
    private String modificadoPor;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaActualiza;

}
