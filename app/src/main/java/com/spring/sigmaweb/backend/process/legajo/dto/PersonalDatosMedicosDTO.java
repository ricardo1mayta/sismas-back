package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalDatosMedicosDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long idPersonal;
    private String idobra ;
    private Long idPerSigma ;
    private String nombrePers ;
    private String apePaternoPers ;
    private String apeMaternoPers ;
    private String fotoPer ;
    private String codigoPer ;
    private Integer idTipoDocPer ;
    private String descDocuPer ;
    private String nroDocPers ;
    private Byte sexoPers ;
    private String numeroEssaludPer ;
    private String numeroEpsPer ;
    private String nomEntEPS ;
    private Long idEntEPS ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacPer ;

    private Boolean flgEsDiscapacitadoPer ;
    //private Boolean flgEsVoluntariadoPer ;
    //private String especVoluntariadoPer ;

    private String factorSangPer ;
    private String grupoSangPer ;
    private Boolean flgDonaSangrePer ;
    private Boolean flgEsHipertensoPer ;
    private Boolean flgEsDiabeticoPer ;
    private Boolean flgcancerPer ;
    private Boolean flgEnferCardioPer ;
    private Boolean flgEnferPulmonPer ;
    private Boolean flgEsInmunoSupresorPer ;
    private Boolean flgAsmaPer ;
    private Boolean flgTrabajoAltoRiesgoPer ;
    private String nroPolizaPer ;
    private String nombreCompPolizaPer ;
    private String beneficiarioPolizaPer ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngPer;

    private String creaPorPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaActivoPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaBajaPer;

    public PersonalDatosMedicosDTO(Long idPersonal, String idobra, Long idPerSigma, String nombrePers, String apePaternoPers, String apeMaternoPers, String fotoPer, String codigoPer, Integer idTipoDocPer, String descDocuPer, String nroDocPers, Byte sexoPers, String numeroEssaludPer, String numeroEpsPer, String nomEntEPS, Long idEntEPS, Date fechaNacPer, Boolean flgEsDiscapacitadoPer, String factorSangPer, String grupoSangPer, Boolean flgDonaSangrePer, Boolean flgEsHipertensoPer, Boolean flgEsDiabeticoPer, Boolean flgcancerPer, Boolean flgEnferCardioPer, Boolean flgEnferPulmonPer, Boolean flgEsInmunoSupresorPer, Boolean flgAsmaPer, Boolean flgTrabajoAltoRiesgoPer, String nroPolizaPer, String nombreCompPolizaPer, String beneficiarioPolizaPer, Date fechaIngPer, String creaPorPer, Date fechaActivoPer, Date fechaBajaPer) {
        this.idPersonal = idPersonal;
        this.idobra = idobra;
        this.idPerSigma = idPerSigma;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.fotoPer = fotoPer;
        this.codigoPer = codigoPer;
        this.idTipoDocPer = idTipoDocPer;
        this.descDocuPer = descDocuPer;
        this.nroDocPers = nroDocPers;
        this.sexoPers = sexoPers;
        this.numeroEssaludPer = numeroEssaludPer;
        this.numeroEpsPer = numeroEpsPer;
        this.nomEntEPS = nomEntEPS;
        this.idEntEPS = idEntEPS;
        this.fechaNacPer = fechaNacPer;
        this.flgEsDiscapacitadoPer = flgEsDiscapacitadoPer;
        this.factorSangPer = factorSangPer;
        this.grupoSangPer = grupoSangPer;
        this.flgDonaSangrePer = flgDonaSangrePer;
        this.flgEsHipertensoPer = flgEsHipertensoPer;
        this.flgEsDiabeticoPer = flgEsDiabeticoPer;
        this.flgcancerPer = flgcancerPer;
        this.flgEnferCardioPer = flgEnferCardioPer;
        this.flgEnferPulmonPer = flgEnferPulmonPer;
        this.flgEsInmunoSupresorPer = flgEsInmunoSupresorPer;
        this.flgAsmaPer = flgAsmaPer;
        this.flgTrabajoAltoRiesgoPer = flgTrabajoAltoRiesgoPer;
        this.nroPolizaPer = nroPolizaPer;
        this.nombreCompPolizaPer = nombreCompPolizaPer;
        this.beneficiarioPolizaPer = beneficiarioPolizaPer;
        this.fechaIngPer = fechaIngPer;
        this.creaPorPer = creaPorPer;
        this.fechaActivoPer = fechaActivoPer;
        this.fechaBajaPer = fechaBajaPer;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    public Long getIdPerSigma() {
        return idPerSigma;
    }

    public void setIdPerSigma(Long idPerSigma) {
        this.idPerSigma = idPerSigma;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
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

    public String getFotoPer() {
        return fotoPer;
    }

    public void setFotoPer(String fotoPer) {
        this.fotoPer = fotoPer;
    }

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public Integer getIdTipoDocPer() {
        return idTipoDocPer;
    }

    public void setIdTipoDocPer(Integer idTipoDocPer) {
        this.idTipoDocPer = idTipoDocPer;
    }

    public String getDescDocuPer() {
        return descDocuPer;
    }

    public void setDescDocuPer(String descDocuPer) {
        this.descDocuPer = descDocuPer;
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

    public String getNumeroEssaludPer() {
        return numeroEssaludPer;
    }

    public void setNumeroEssaludPer(String numeroEssaludPer) {
        this.numeroEssaludPer = numeroEssaludPer;
    }

    public String getNumeroEpsPer() {
        return numeroEpsPer;
    }

    public void setNumeroEpsPer(String numeroEpsPer) {
        this.numeroEpsPer = numeroEpsPer;
    }

    public String getNomEntEPS() {
        return nomEntEPS;
    }

    public void setNomEntEPS(String nomEntEPS) {
        this.nomEntEPS = nomEntEPS;
    }

    public Long getIdEntEPS() {
        return idEntEPS;
    }

    public void setIdEntEPS(Long idEntEPS) {
        this.idEntEPS = idEntEPS;
    }

    public Date getFechaNacPer() {
        return fechaNacPer;
    }

    public void setFechaNacPer(Date fechaNacPer) {
        this.fechaNacPer = fechaNacPer;
    }

    public Boolean getFlgEsDiscapacitadoPer() {
        return flgEsDiscapacitadoPer;
    }

    public void setFlgEsDiscapacitadoPer(Boolean flgEsDiscapacitadoPer) {
        this.flgEsDiscapacitadoPer = flgEsDiscapacitadoPer;
    }

    public String getFactorSangPer() {
        return factorSangPer;
    }

    public void setFactorSangPer(String factorSangPer) {
        this.factorSangPer = factorSangPer;
    }

    public String getGrupoSangPer() {
        return grupoSangPer;
    }

    public void setGrupoSangPer(String grupoSangPer) {
        this.grupoSangPer = grupoSangPer;
    }

    public Boolean getFlgDonaSangrePer() {
        return flgDonaSangrePer;
    }

    public void setFlgDonaSangrePer(Boolean flgDonaSangrePer) {
        this.flgDonaSangrePer = flgDonaSangrePer;
    }

    public Boolean getFlgEsHipertensoPer() {
        return flgEsHipertensoPer;
    }

    public void setFlgEsHipertensoPer(Boolean flgEsHipertensoPer) {
        this.flgEsHipertensoPer = flgEsHipertensoPer;
    }

    public Boolean getFlgEsDiabeticoPer() {
        return flgEsDiabeticoPer;
    }

    public void setFlgEsDiabeticoPer(Boolean flgEsDiabeticoPer) {
        this.flgEsDiabeticoPer = flgEsDiabeticoPer;
    }

    public Boolean getFlgcancerPer() {
        return flgcancerPer;
    }

    public void setFlgcancerPer(Boolean flgcancerPer) {
        this.flgcancerPer = flgcancerPer;
    }

    public Boolean getFlgEnferCardioPer() {
        return flgEnferCardioPer;
    }

    public void setFlgEnferCardioPer(Boolean flgEnferCardioPer) {
        this.flgEnferCardioPer = flgEnferCardioPer;
    }

    public Boolean getFlgEnferPulmonPer() {
        return flgEnferPulmonPer;
    }

    public void setFlgEnferPulmonPer(Boolean flgEnferPulmonPer) {
        this.flgEnferPulmonPer = flgEnferPulmonPer;
    }

    public Boolean getFlgEsInmunoSupresorPer() {
        return flgEsInmunoSupresorPer;
    }

    public void setFlgEsInmunoSupresorPer(Boolean flgEsInmunoSupresorPer) {
        this.flgEsInmunoSupresorPer = flgEsInmunoSupresorPer;
    }

    public Boolean getFlgAsmaPer() {
        return flgAsmaPer;
    }

    public void setFlgAsmaPer(Boolean flgAsmaPer) {
        this.flgAsmaPer = flgAsmaPer;
    }

    public Boolean getFlgTrabajoAltoRiesgoPer() {
        return flgTrabajoAltoRiesgoPer;
    }

    public void setFlgTrabajoAltoRiesgoPer(Boolean flgTrabajoAltoRiesgoPer) {
        this.flgTrabajoAltoRiesgoPer = flgTrabajoAltoRiesgoPer;
    }

    public String getNroPolizaPer() {
        return nroPolizaPer;
    }

    public void setNroPolizaPer(String nroPolizaPer) {
        this.nroPolizaPer = nroPolizaPer;
    }

    public String getNombreCompPolizaPer() {
        return nombreCompPolizaPer;
    }

    public void setNombreCompPolizaPer(String nombreCompPolizaPer) {
        this.nombreCompPolizaPer = nombreCompPolizaPer;
    }

    public String getBeneficiarioPolizaPer() {
        return beneficiarioPolizaPer;
    }

    public void setBeneficiarioPolizaPer(String beneficiarioPolizaPer) {
        this.beneficiarioPolizaPer = beneficiarioPolizaPer;
    }

    public Date getFechaIngPer() {
        return fechaIngPer;
    }

    public void setFechaIngPer(Date fechaIngPer) {
        this.fechaIngPer = fechaIngPer;
    }

    public String getCreaPorPer() {
        return creaPorPer;
    }

    public void setCreaPorPer(String creaPorPer) {
        this.creaPorPer = creaPorPer;
    }

    public Date getFechaActivoPer() {
        return fechaActivoPer;
    }

    public void setFechaActivoPer(Date fechaActivoPer) {
        this.fechaActivoPer = fechaActivoPer;
    }

    public Date getFechaBajaPer() {
        return fechaBajaPer;
    }

    public void setFechaBajaPer(Date fechaBajaPer) {
        this.fechaBajaPer = fechaBajaPer;
    }
}
