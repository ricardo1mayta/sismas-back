package com.spring.sigmaweb.backend.process.generic.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.legajo.model.Personal;

@Entity
@Table(name = "mg_persona")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false, unique = true)
    private Long idPersona;

    @Column(nullable = true, length = 6, name = "idobra_pers")
    private String obraPers;

    // ******* PERSONALES *******
    @Column(nullable = false, length = 33, name = "ape_paterno_Pers")
    private String apePaternoPers;

    @Column(nullable = false, length = 33, name = "ape_materno_Pers")
    private String apeMaternoPers;

    @Column(nullable = false, length = 33, name = "nombre_Pers")
    private String nombrePers;

    @JsonIgnoreProperties({"alumnoDocumento", "padreDocumento", "madreDocumento", "otroFamiDocumento",
            "personalDocumento", "padreEstCivil", "madreEstCivil", "otroEstCivil", "personalEstCivil",
            "personalDepEstCivil", "alumnosviveCom", "otroFamiParentalumnosRespPago", "hibernateLazyInitializer",
            "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipodoc_Pers", foreignKey = @ForeignKey(name = "fk_personal_tipodocPer"))
    private TablasTabla idTipoDocPers;

    @Column(nullable = false, length = 50, name = "nrodoc_Pers")
    private String nroDocPers;

    @Column(nullable = false, name = "idpaisdoc_Pers")
    private Long idPaisDocPers;

    @JsonIgnoreProperties({"alumnoDocumento", "padreDocumento", "madreDocumento", "otroFamiDocumento",
            "personalDocumento", "padreEstCivil", "madreEstCivil", "otroEstCivil", "personalEstCivil",
            "personalDepEstCivil", "alumnosviveCom", "otroFamiParentalumnosRespPago", "hibernateLazyInitializer",
            "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estcivil_Pers", foreignKey = @ForeignKey(name = "fk_persona_estCivilPersonal"))
    private TablasTabla estCivilPers;

    @Column(nullable = true, name = "feccambio_estcivil_Pers")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCambioEstCivilPers;

    @Column(nullable = false, name = "sexo_Pers")
    private Byte sexoPers;

    @Column(nullable = true, length = 25, name = "celular_Pers")
    private String celularPers;

    @Column(nullable = true, length = 25, name = "celularb_Pers")
    private String celularBPers;

    @Column(nullable = true, length = 25, name = "telefonofijo_Pers")
    private String telefonoFijoPers;

    @Column(nullable = true, length = 200, name = "email_Pers")
    private String emailPers;

    @Column(nullable = true, length = 200, name = "emailcor_Pers")
    private String emailCorPers;

    // ******* RELIGIOSO *******
    @Column(nullable = false, name = "religion_profesa_Pers", length = 20)
    private String religionProfesaPers;

    // ******* NACIMIENTO *******
    @Column(nullable = false, name = "fecha_nac_Pers")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacPers;

    @Column(nullable = true, name = "idpaisnac_Pers")
    private Long idPaisNacPers;

    @Column(nullable = true, length = 100, name = "nacionalidad_Pers")
    private String nacionalidadPers;

    @Column(nullable = true, name = "iddistnac_Pers")
    private Long idDistNacPers;

    @Column(nullable = true, length = 100, name = "observanac_Pers")
    private String observaNacPers;

    // ******* DOMICILIO *******
    @Column(nullable = false, name = "tipoviadomi_Pers")
    private Integer tipoViaDomiPers;

    @Column(nullable = true, length = 150, name = "domicilio_Pers")
    private String domicilioPers;

    @Column(nullable = true, length = 50, name = "numerodomi_Pers")
    private String numeroDomiPers;

    @Column(nullable = true, length = 10, name = "interiordomi_Pers")
    private String interiorDomiPers;

    @Column(nullable = false, name = "tipozonadomi_Pers")
    private Integer tipoZonaDomiPers;

    @Column(nullable = true, length = 50, name = "nombrezona_domi_Pers")
    private String nombreZonaDomiPers;

    @JsonIgnoreProperties({"alumnosDist", "familiaDistr", "padreDistr", "madreDistr", "otrosDistr", "personalDistr",
            "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddistdomi_pers", foreignKey = @ForeignKey(name = "fk_persona_distrPersonal"))
    private Distrito idDistDomiPers;

    @Column(nullable = true, length = 200, name = "observaciondomi_pers")
    private String observacionDomiPers;

    // ******* GENERALES *******
    @Column(nullable = false, name = "fechaing_pers")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPers;

    @Column(nullable = false, name = "creapor_pers", length = 100)
    private String creaPorPers;

    @Column(nullable = true, name = "fechamodi_pers")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPers;

    @Column(nullable = true, name = "modipor_pers", length = 100)
    private String modiPorPers;

    @Column(nullable = true, name = "cod_inter_pers")
    private Long codInterPers;

    @Column(nullable = true, name = "estado_pers")
    private Boolean estadoPers;

    @Column(nullable = true, name = "referencia_contacto_pers")
    private String referenciaContactoPers;
    //---------------------------- * ----------------------------

    @JsonIgnoreProperties({"idPersona", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPersona", cascade = CascadeType.ALL)
    private List<Personal> personal;

    public Persona() {
        this.personal = new ArrayList<>();
    }

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

    public TablasTabla getIdTipoDocPers() {
        return idTipoDocPers;
    }

    public void setIdTipoDocPers(TablasTabla idTipoDocPers) {
        this.idTipoDocPers = idTipoDocPers;
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

    public TablasTabla getEstCivilPers() {
        return estCivilPers;
    }

    public void setEstCivilPers(TablasTabla estCivilPers) {
        this.estCivilPers = estCivilPers;
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

    public String getReligionProfesaPers() {
        return religionProfesaPers;
    }

    public void setReligionProfesaPers(String religionProfesaPers) {
        this.religionProfesaPers = religionProfesaPers;
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

    public String getNombreZonaDomiPers() {
        return nombreZonaDomiPers;
    }

    public void setNombreZonaDomiPers(String nombreZonaDomiPers) {
        this.nombreZonaDomiPers = nombreZonaDomiPers;
    }

    public Distrito getIdDistDomiPers() {
        return idDistDomiPers;
    }

    public void setIdDistDomiPers(Distrito idDistDomiPers) {
        this.idDistDomiPers = idDistDomiPers;
    }

    public String getObservacionDomiPers() {
        return observacionDomiPers;
    }

    public void setObservacionDomiPers(String observacionDomiPers) {
        this.observacionDomiPers = observacionDomiPers;
    }

    public Date getFechaIngPers() {
        return fechaIngPers;
    }

    public void setFechaIngPers(Date fechaIngPers) {
        this.fechaIngPers = fechaIngPers;
    }

    public String getCreaPorPers() {
        return creaPorPers;
    }

    public void setCreaPorPers(String creaPorPers) {
        this.creaPorPers = creaPorPers;
    }

    public Date getFechaModiPers() {
        return fechaModiPers;
    }

    public void setFechaModiPers(Date fechaModiPers) {
        this.fechaModiPers = fechaModiPers;
    }

    public String getModiPorPers() {
        return modiPorPers;
    }

    public void setModiPorPers(String modiPorPers) {
        this.modiPorPers = modiPorPers;
    }

    public Long getCodInterPers() {
        return codInterPers;
    }

    public void setCodInterPers(Long codInterPers) {
        this.codInterPers = codInterPers;
    }

    public Boolean getEstadoPers() {
        return estadoPers;
    }

    public void setEstadoPers(Boolean estadoPers) {
        this.estadoPers = estadoPers;
    }

    public String getReferenciaContactoPers() {
        return referenciaContactoPers;
    }

    public void setReferenciaContactoPers(String referenciaContactoPers) {
        this.referenciaContactoPers = referenciaContactoPers;
    }
}
