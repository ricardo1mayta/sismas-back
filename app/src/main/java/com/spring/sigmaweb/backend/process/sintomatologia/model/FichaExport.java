package com.spring.sigmaweb.backend.process.sintomatologia.model;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.EnfermedadDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.dto.SintomaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FichaExport {

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
    private String observacion;
    private Date fechaRegistro;
    private Date fechaNacPers;

    List<EnfermedadDTO> enfermedadList;
    List<SintomaDTO> sintomaList;

    public FichaExport(Long idFicha, Long idPersonal, String nombrePers, String nroDocPers, String emailPers, String telefono, String edad, String talla, String peso, String idObra, Boolean flagContactoCovid, String observacion, Date fechaRegistro, Date fechaNacPers) {
        this.idFicha = idFicha;
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.nroDocPers = nroDocPers;
        this.emailPers = emailPers;
        this.telefono = telefono;
        this.edad = edad;
        this.talla = talla;
        this.peso = peso;
        this.idObra = idObra;
        this.flagContactoCovid = flagContactoCovid;
        this.observacion = observacion;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacPers = fechaNacPers;
    }

    public FichaExport(Long idPersonal, String nombrePers, String nroDocPers, String emailPers, String idObra, Date fechaNacPers) {
        this.idPersonal = idPersonal;
        this.nombrePers = nombrePers;
        this.nroDocPers = nroDocPers;
        this.emailPers = emailPers;
        this.idObra = idObra;
        this.fechaNacPers = fechaNacPers;
    }
}
