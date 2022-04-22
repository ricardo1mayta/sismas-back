package com.spring.sigmaweb.backend.process.sintomatologia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FichaSintomatologicaDTO implements Serializable {
    private Long idFicha;
    private Long idPersonal;
    private String nombrePers;
    private String nroDocPers;
    private String emailPers;
    private String telefono;
    private String edad;
    private String talla;
    private String peso;
    private String idObra;
    private Boolean flagContactoCovid;
    private String Observacion;
    private Date fechaRegistro;
    private Date fechaNacPers;

    public FichaSintomatologicaDTO(Long idPersonal, String nombrePers, String nroDocPers, String emailPers, String idObra,Date fechaNacPers) {
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.nroDocPers = nroDocPers;
        this.emailPers = emailPers;
        this.idObra =idObra;
        this.fechaNacPers=fechaNacPers;
    }

    private static final long serialVersionUID = 1L;
}

