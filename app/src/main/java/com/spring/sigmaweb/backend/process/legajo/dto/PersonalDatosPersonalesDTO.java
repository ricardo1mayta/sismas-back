package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonalDatosPersonalesDTO implements Serializable {
    private Long idpersonal;
    private String idobra;
    private Long idPerSigma;
    private String nombrePers;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String fotoPer;
    private String codigoPer;
    private Integer idTipoDocPer;
    private String descDocuPer;
    private String nroDocPers;
    private Long idPaisDocPers;
    private String paisotorgadoc;
    private Integer estCivilPer;
    private String descEstCivilPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecCambioEstCivilPers;

    private Byte sexoPers;
    private String celularPers;
    private String celularBPers;
    private String telefonoFijoPers;
    private String emailPers;
    private String emailCorPers;
    private Boolean estadoPer;
    private String contactoEmerPer;
    private String telefContEmerPer;
    private Integer idParentContEmerPer;
    private String descContEmerPer;
    private String religionProfesaPers;
    private String numeroEssaludPer;
    private String numeroEpsPer;
    private String nomEntEPSM;
    private Long idEntEPS;
    private String numeroPensionPer;
    private Long idEntPen;
    private String nomEntPen;
    private Integer idTipoPensionPer;
    private String descPensionPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacPers;

    private Long idPaisNacPers;
    private String paisnac;
    private String nacionalidadPers;
    private Long idDistNacPers;
    private String nombreDistNacPer;

    private Long idprovNacPer;
    private String nomprovNacPer;
    private Long iddepaNacPer;
    private String nomdepaNacPer;
    private String observaNacPers;

    private Integer tipoViaDomiPers;
    private String descViaPer;
    private String domicilioPers;
    private String numeroDomiPers ;
    private String interiorDomiPers;
    private Integer tipoZonaDomiPers;
    private String desczonaPer;
    private String nombreZonaDomiPers;
    private Long idDistDomiPer;
    private String nomDistDomiPer;

    private Long idprovDomPer;
    private String nomprovDomPer;
    private Long iddepaDomPer;
    private String nomdepaDomPer;

    private String observacionDomiPers;
    private Boolean flgEsDiscapacitadoPer;
    private String especDiscapacidadPer;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSX")
    private Date fechaIngPer;

    private String creaPorPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaActivoPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private  Date fechaBajaPer;

    private String modiPorPer;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private  Date fechaAutorizaPer;

    public PersonalDatosPersonalesDTO(Long idpersonal, String idobra, Long idPerSigma, String nombrePers, String apePaternoPers, String apeMaternoPers,
                                      String fotoPer, String codigoPer, Integer idTipoDocPer, String descDocuPer, String nroDocPers, Long idPaisDocPers,
                                      String paisotorgadoc, Integer estCivilPer, String descEstCivilPer, Date fecCambioEstCivilPers, Byte sexoPers, String celularPers,
                                      String celularBPers, String telefonoFijoPers, String emailPers, String emailCorPers, Boolean estadoPer, String contactoEmerPer,
                                      String telefContEmerPer, Integer idParentContEmerPer, String descContEmerPer, String religionProfesaPers, String numeroEssaludPer,
                                      String numeroEpsPer, String nomEntEPSM, Long idEntEPS, String numeroPensionPer, Long idEntPen, String nomEntPen, Integer idTipoPensionPer,
                                      String descPensionPer, Date fechaNacPers, Long idPaisNacPers, String paisnac, String nacionalidadPers, Long idDistNacPers, String nombreDistNacPer,
                                      Long idprovNacPer, String nomprovNacPer, Long iddepaNacPer, String nomdepaNacPer, String observaNacPers, Integer tipoViaDomiPers, String descViaPer,
                                      String domicilioPers, String numeroDomiPers, String interiorDomiPers, Integer tipoZonaDomiPers, String desczonaPer, String nombreZonaDomiPers,
                                      Long idDistDomiPer, String nomDistDomiPer, Long idprovDomPer, String nomprovDomPer, Long iddepaDomPer, String nomdepaDomPer,
                                      String observacionDomiPers, Boolean flgEsDiscapacitadoPer, String especDiscapacidadPer, Date fechaIngPer, String creaPorPer, Date fechaActivoPer,
                                      Date fechaBajaPer, String modiPorPer, Date fechaAutorizaPer) {
        this.idpersonal = idpersonal;
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
        this.idPaisDocPers = idPaisDocPers;
        this.paisotorgadoc = paisotorgadoc;
        this.estCivilPer = estCivilPer;
        this.descEstCivilPer = descEstCivilPer;
        this.fecCambioEstCivilPers = fecCambioEstCivilPers;
        this.sexoPers = sexoPers;
        this.celularPers = celularPers;
        this.celularBPers = celularBPers;
        this.telefonoFijoPers = telefonoFijoPers;
        this.emailPers = emailPers;
        this.emailCorPers = emailCorPers;
        this.estadoPer = estadoPer;
        this.contactoEmerPer = contactoEmerPer;
        this.telefContEmerPer = telefContEmerPer;
        this.idParentContEmerPer = idParentContEmerPer;
        this.descContEmerPer = descContEmerPer;
        this.religionProfesaPers = religionProfesaPers;
        this.numeroEssaludPer = numeroEssaludPer;
        this.numeroEpsPer = numeroEpsPer;
        this.nomEntEPSM = nomEntEPSM;
        this.idEntEPS = idEntEPS;
        this.numeroPensionPer = numeroPensionPer;
        this.idEntPen = idEntPen;
        this.nomEntPen = nomEntPen;
        this.idTipoPensionPer = idTipoPensionPer;
        this.descPensionPer = descPensionPer;
        this.fechaNacPers = fechaNacPers;
        this.idPaisNacPers = idPaisNacPers;
        this.paisnac = paisnac;
        this.nacionalidadPers = nacionalidadPers;
        this.idDistNacPers = idDistNacPers;
        this.nombreDistNacPer = nombreDistNacPer;
        this.idprovNacPer = idprovNacPer;
        this.nomprovNacPer = nomprovNacPer;
        this.iddepaNacPer = iddepaNacPer;
        this.nomdepaNacPer = nomdepaNacPer;
        this.observaNacPers = observaNacPers;
        this.tipoViaDomiPers = tipoViaDomiPers;
        this.descViaPer = descViaPer;
        this.domicilioPers = domicilioPers;
        this.numeroDomiPers = numeroDomiPers;
        this.interiorDomiPers = interiorDomiPers;
        this.tipoZonaDomiPers = tipoZonaDomiPers;
        this.desczonaPer = desczonaPer;
        this.nombreZonaDomiPers = nombreZonaDomiPers;
        this.idDistDomiPer = idDistDomiPer;
        this.nomDistDomiPer = nomDistDomiPer;
        this.idprovDomPer = idprovDomPer;
        this.nomprovDomPer = nomprovDomPer;
        this.iddepaDomPer = iddepaDomPer;
        this.nomdepaDomPer = nomdepaDomPer;
        this.observacionDomiPers = observacionDomiPers;
        this.flgEsDiscapacitadoPer = flgEsDiscapacitadoPer;
        this.especDiscapacidadPer = especDiscapacidadPer;
        this.fechaIngPer = fechaIngPer;
        this.creaPorPer = creaPorPer;
        this.fechaActivoPer = fechaActivoPer;
        this.fechaBajaPer = fechaBajaPer;
        this.modiPorPer = modiPorPer;
        this.fechaAutorizaPer = fechaAutorizaPer;
    }

    public PersonalDatosPersonalesDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Long idpersonal) {
        this.idpersonal = idpersonal;
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

    public Long getIdPaisDocPers() {
        return idPaisDocPers;
    }

    public void setIdPaisDocPers(Long idPaisDocPers) {
        this.idPaisDocPers = idPaisDocPers;
    }

    public String getPaisotorgadoc() {
        return paisotorgadoc;
    }

    public void setPaisotorgadoc(String paisotorgadoc) {
        this.paisotorgadoc = paisotorgadoc;
    }

    public Integer getEstCivilPer() {
        return estCivilPer;
    }

    public void setEstCivilPer(Integer estCivilPer) {
        this.estCivilPer = estCivilPer;
    }

    public String getDescEstCivilPer() {
        return descEstCivilPer;
    }

    public void setDescEstCivilPer(String descEstCivilPer) {
        this.descEstCivilPer = descEstCivilPer;
    }

    public Date getFecCambioEstCivilPers() {
        return fecCambioEstCivilPers;
    }

    public void setFecCambioEstCivilPers(Date fecCambioEstCivilPers) {
        this.fecCambioEstCivilPers = fecCambioEstCivilPers;
    }

    public Byte getSexoPers() {
        return sexoPers;
    }

    public void setSexoPers(Byte sexoPers) {
        this.sexoPers = sexoPers;
    }

    public String getCelularPers() {
        return celularPers;
    }

    public void setCelularPers(String celularPers) {
        this.celularPers = celularPers;
    }

    public String getCelularBPers() {
        return celularBPers;
    }

    public void setCelularBPers(String celularBPers) {
        this.celularBPers = celularBPers;
    }

    public String getTelefonoFijoPers() {
        return telefonoFijoPers;
    }

    public void setTelefonoFijoPers(String telefonoFijoPers) {
        this.telefonoFijoPers = telefonoFijoPers;
    }

    public String getEmailPers() {
        return emailPers;
    }

    public void setEmailPers(String emailPers) {
        this.emailPers = emailPers;
    }

    public String getEmailCorPers() {
        return emailCorPers;
    }

    public void setEmailCorPers(String emailCorPers) {
        this.emailCorPers = emailCorPers;
    }

    public Boolean getEstadoPer() {
        return estadoPer;
    }

    public void setEstadoPer(Boolean estadoPer) {
        this.estadoPer = estadoPer;
    }

    public String getContactoEmerPer() {
        return contactoEmerPer;
    }

    public void setContactoEmerPer(String contactoEmerPer) {
        this.contactoEmerPer = contactoEmerPer;
    }

    public String getTelefContEmerPer() {
        return telefContEmerPer;
    }

    public void setTelefContEmerPer(String telefContEmerPer) {
        this.telefContEmerPer = telefContEmerPer;
    }

    public Integer getIdParentContEmerPer() {
        return idParentContEmerPer;
    }

    public void setIdParentContEmerPer(Integer idParentContEmerPer) {
        this.idParentContEmerPer = idParentContEmerPer;
    }

    public String getDescContEmerPer() {
        return descContEmerPer;
    }

    public void setDescContEmerPer(String descContEmerPer) {
        this.descContEmerPer = descContEmerPer;
    }

    public String getReligionProfesaPers() {
        return religionProfesaPers;
    }

    public void setReligionProfesaPers(String religionProfesaPers) {
        this.religionProfesaPers = religionProfesaPers;
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

    public String getNomEntEPSM() {
        return nomEntEPSM;
    }

    public void setNomEntEPSM(String nomEntEPSM) {
        this.nomEntEPSM = nomEntEPSM;
    }

    public Long getIdEntEPS() {
        return idEntEPS;
    }

    public void setIdEntEPS(Long idEntEPS) {
        this.idEntEPS = idEntEPS;
    }

    public String getNumeroPensionPer() {
        return numeroPensionPer;
    }

    public void setNumeroPensionPer(String numeroPensionPer) {
        this.numeroPensionPer = numeroPensionPer;
    }

    public Long getIdEntPen() {
        return idEntPen;
    }

    public void setIdEntPen(Long idEntPen) {
        this.idEntPen = idEntPen;
    }

    public String getNomEntPen() {
        return nomEntPen;
    }

    public void setNomEntPen(String nomEntPen) {
        this.nomEntPen = nomEntPen;
    }

    public Integer getIdTipoPensionPer() {
        return idTipoPensionPer;
    }

    public void setIdTipoPensionPer(Integer idTipoPensionPer) {
        this.idTipoPensionPer = idTipoPensionPer;
    }

    public String getDescPensionPer() {
        return descPensionPer;
    }

    public void setDescPensionPer(String descPensionPer) {
        this.descPensionPer = descPensionPer;
    }

    public Date getFechaNacPers() {
        return fechaNacPers;
    }

    public void setFechaNacPers(Date fechaNacPers) {
        this.fechaNacPers = fechaNacPers;
    }

    public Long getIdPaisNacPers() {
        return idPaisNacPers;
    }

    public void setIdPaisNacPers(Long idPaisNacPers) {
        this.idPaisNacPers = idPaisNacPers;
    }

    public String getPaisnac() {
        return paisnac;
    }

    public void setPaisnac(String paisnac) {
        this.paisnac = paisnac;
    }

    public String getNacionalidadPers() {
        return nacionalidadPers;
    }

    public void setNacionalidadPers(String nacionalidadPers) {
        this.nacionalidadPers = nacionalidadPers;
    }

    public Long getIdDistNacPers() {
        return idDistNacPers;
    }

    public void setIdDistNacPers(Long idDistNacPers) {
        this.idDistNacPers = idDistNacPers;
    }

    public String getNombreDistNacPer() {
        return nombreDistNacPer;
    }

    public void setNombreDistNacPer(String nombreDistNacPer) {
        this.nombreDistNacPer = nombreDistNacPer;
    }

    public Long getIdprovNacPer() {
        return idprovNacPer;
    }

    public void setIdprovNacPer(Long idprovNacPer) {
        this.idprovNacPer = idprovNacPer;
    }

    public String getNomprovNacPer() {
        return nomprovNacPer;
    }

    public void setNomprovNacPer(String nomprovNacPer) {
        this.nomprovNacPer = nomprovNacPer;
    }

    public Long getIddepaNacPer() {
        return iddepaNacPer;
    }

    public void setIddepaNacPer(Long iddepaNacPer) {
        this.iddepaNacPer = iddepaNacPer;
    }

    public String getNomdepaNacPer() {
        return nomdepaNacPer;
    }

    public void setNomdepaNacPer(String nomdepaNacPer) {
        this.nomdepaNacPer = nomdepaNacPer;
    }

    public String getObservaNacPers() {
        return observaNacPers;
    }

    public void setObservaNacPers(String observaNacPers) {
        this.observaNacPers = observaNacPers;
    }

    public Integer getTipoViaDomiPers() {
        return tipoViaDomiPers;
    }

    public void setTipoViaDomiPers(Integer tipoViaDomiPers) {
        this.tipoViaDomiPers = tipoViaDomiPers;
    }

    public String getDescViaPer() {
        return descViaPer;
    }

    public void setDescViaPer(String descViaPer) {
        this.descViaPer = descViaPer;
    }

    public String getDomicilioPers() {
        return domicilioPers;
    }

    public void setDomicilioPers(String domicilioPers) {
        this.domicilioPers = domicilioPers;
    }

    public String getNumeroDomiPers() {
        return numeroDomiPers;
    }

    public void setNumeroDomiPers(String numeroDomiPers) {
        this.numeroDomiPers = numeroDomiPers;
    }

    public String getInteriorDomiPers() {
        return interiorDomiPers;
    }

    public void setInteriorDomiPers(String interiorDomiPers) {
        this.interiorDomiPers = interiorDomiPers;
    }

    public Integer getTipoZonaDomiPers() {
        return tipoZonaDomiPers;
    }

    public void setTipoZonaDomiPers(Integer tipoZonaDomiPers) {
        this.tipoZonaDomiPers = tipoZonaDomiPers;
    }

    public String getDesczonaPer() {
        return desczonaPer;
    }

    public void setDesczonaPer(String desczonaPer) {
        this.desczonaPer = desczonaPer;
    }

    public String getNombreZonaDomiPers() {
        return nombreZonaDomiPers;
    }

    public void setNombreZonaDomiPers(String nombreZonaDomiPers) {
        this.nombreZonaDomiPers = nombreZonaDomiPers;
    }

    public Long getIdDistDomiPer() {
        return idDistDomiPer;
    }

    public void setIdDistDomiPer(Long idDistDomiPer) {
        this.idDistDomiPer = idDistDomiPer;
    }

    public String getNomDistDomiPer() {
        return nomDistDomiPer;
    }

    public void setNomDistDomiPer(String nomDistDomiPer) {
        this.nomDistDomiPer = nomDistDomiPer;
    }

    public Long getIdprovDomPer() {
        return idprovDomPer;
    }

    public void setIdprovDomPer(Long idprovDomPer) {
        this.idprovDomPer = idprovDomPer;
    }

    public String getNomprovDomPer() {
        return nomprovDomPer;
    }

    public void setNomprovDomPer(String nomprovDomPer) {
        this.nomprovDomPer = nomprovDomPer;
    }

    public Long getIddepaDomPer() {
        return iddepaDomPer;
    }

    public void setIddepaDomPer(Long iddepaDomPer) {
        this.iddepaDomPer = iddepaDomPer;
    }

    public String getNomdepaDomPer() {
        return nomdepaDomPer;
    }

    public void setNomdepaDomPer(String nomdepaDomPer) {
        this.nomdepaDomPer = nomdepaDomPer;
    }

    public String getObservacionDomiPers() {
        return observacionDomiPers;
    }

    public void setObservacionDomiPers(String observacionDomiPers) {
        this.observacionDomiPers = observacionDomiPers;
    }

    public Boolean getFlgEsDiscapacitadoPer() {
        return flgEsDiscapacitadoPer;
    }

    public void setFlgEsDiscapacitadoPer(Boolean flgEsDiscapacitadoPer) {
        this.flgEsDiscapacitadoPer = flgEsDiscapacitadoPer;
    }

    public String getEspecDiscapacidadPer() {
        return especDiscapacidadPer;
    }

    public void setEspecDiscapacidadPer(String especDiscapacidadPer) {
        this.especDiscapacidadPer = especDiscapacidadPer;
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

    public String getModiPorPer() {
        return modiPorPer;
    }

    public void setModiPorPer(String modiPorPer) {
        this.modiPorPer = modiPorPer;
    }

    public Date getFechaAutorizaPer() {
        return fechaAutorizaPer;
    }

    public void setFechaAutorizaPer(Date fechaAutorizaPer) {
        this.fechaAutorizaPer = fechaAutorizaPer;
    }

    private static final long serialVersionUID = 1L;
}
