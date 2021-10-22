package com.spring.sigmaweb.backend.process.generic.dto;

import java.io.Serializable;

public class PersonaInfoDTO implements Serializable {
    private Long idPersona;
    private String obraPers;

    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private String nroDocPers;
    private Byte sexoPers;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getObraPers() {
        return obraPers;
    }

    public void setObraPers(String obraPers) {
        this.obraPers = obraPers;
    }

    public String getApePaternoPers() {
        return apePaternoPers;
    }

    public void setApePaternoPers(String apePaternoPers) {
        this.apePaternoPers = apePaternoPers;
    }

    public String getApeMaternoPers() {
        return apeMaternoPers;
    }

    public void setApeMaternoPers(String apeMaternoPers) {
        this.apeMaternoPers = apeMaternoPers;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
    }

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public Byte getSexoPers() {
        return sexoPers;
    }

    public void setSexoPers(Byte sexoPers) {
        this.sexoPers = sexoPers;
    }

    private static final long serialVersionUID = 1L;
}
