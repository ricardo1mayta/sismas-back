package com.spring.sigmaweb.backend.process.legajo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.Obra;
import com.spring.sigmaweb.backend.process.generic.model.Persona;

@Entity
@Table(name = "mo_personal")

public class Personal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal", nullable = false, unique = true)
    private Long idPersonal;

    @Column(name = "idper_sigma", nullable = false)
    private Long idPerSigma;

    @JsonIgnoreProperties(value = { "alumnos", "familia", "obradocumentos", "usuarios", "personal",
            "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_obra_per", foreignKey = @ForeignKey(name = "fk_personal_obra"))
    private Obra obraPer;

    @JsonIgnoreProperties(value = {"personal", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_pers_per", foreignKey = @ForeignKey(name = "fk_personal_persona"))
    private Persona idPersona;


    // ******* PERSONALES *******
    @Column(nullable = true, length = 100, name = "foto_per")
    private String fotoPer;

    @Column(nullable = true, length = 20, name = "codigo_per")
    private String codigoPer;

    @Column(nullable = false, name = "estado_per", columnDefinition = "boolean default false")
    private Boolean estadoPer;

    // ******* EMERGENCIA *******
    @Column(nullable = true, length = 200, name = "contacto_emer_per")
    private String contactoEmerPer;

    @Column(nullable = true, length = 200, name = "telefcont_emer_per")
    private String telefContEmerPer;

    @Column(nullable = true, name = "idparentcont_emer_per")
    private Integer idParentContEmerPer;

    @Column(nullable = false, length = 50, name = "nrodoc_per")
    private String nroDocPer;

    // ******* ASEGURADO *******
    @Column(nullable = true, length = 20, name = "numero_essalud_per")
    private String numeroEssaludPer;

    @Column(nullable = true, name = "identidad_eps_per")
    private Long idEntidadEpsPer;

    @Column(nullable = true, length = 20, name = "numero_eps_per")
    private String numeroEpsPer;

    @Column(nullable = true, name = "idtipo_pension_per")
    private Integer idTipoPensionPer;

    @Column(nullable = true, name = "identidad_pension_per")
    private Long idEntidadPensPer;

    @Column(nullable = true, length = 20, name = "numero_pension_per")
    private String numeroPensionPer;

    // ******* OTROS DATOS *******
    @Column(nullable = false, name = "flg_esdiscapacitado_per", columnDefinition = "boolean default false")
    private Boolean flgEsDiscapacitadoPer;

    @Column(nullable = true, name = "especDiscapacidad_per", length = 500)
    private String especDiscapacidadPer;

    // ******* GENERALES *******
    @Column(nullable = false, name = "fechaing_per")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPer;

    @Column(nullable = false, name = "creapor_per", length = 100)
    private String creaPorPer;

    @Column(nullable = true, name = "fecha_activo_per")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivoPer;

    @Column(nullable = true, name = "fecha_baja_per")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBajaPer;

    @Column(nullable = true, name = "fechamodi_per")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPer;

    @Column(nullable = true, name = "modipor_per", length = 100)
    private String modiPorPer;

    @Column(nullable = true, name = "fechaautoriza_per")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAutorizaPer;

    // ******* MEDICOS *******
    @Column(nullable = true, name = "factor_sang_per", length = 10)
    private String factorSangPer;

    @Column(nullable = true, name = "grupo_sang_per", length = 10)
    private String grupoSangPer;

    @Column(nullable = false, name = "flg_donasangre_per", columnDefinition = "boolean default false")
    private Boolean flgDonaSangrePer;

    @Column(nullable = false, name = "flg_eshipertenso_per", columnDefinition = "boolean default false")
    private Boolean flgEsHipertensoPer;

    @Column(nullable = false, name = "flg_esdiabetico_per", columnDefinition = "boolean default false")
    private Boolean flgEsDiabeticoPer;

    @Column(nullable = false, name = "flg_cancer_per", columnDefinition = "boolean default false")
    private Boolean flgcancerPer;

    @Column(nullable = false, name = "flg_enfercardio_per", columnDefinition = "boolean default false")
    private Boolean flgEnferCardioPer;

    @Column(nullable = false, name = "flg_enferpulmon_per", columnDefinition = "boolean default false")
    private Boolean flgEnferPulmonPer;

    @Column(nullable = false, name = "flg_esinmunosupresor_per", columnDefinition = "boolean default false")
    private Boolean flgEsInmunoSupresorPer;

    @Column(nullable = false, name = "flg_asma_per", columnDefinition = "boolean default false")
    private Boolean flgAsmaPer;

    // ******* ALTO RIESGO *******
    @Column(nullable = false, name = "flg_trabajoaltoriesgo_per", columnDefinition = "boolean default false")
    private Boolean flgTrabajoAltoRiesgoPer;

    @Column(nullable = true, name = "nropoliza_per", length = 20)
    private String nroPolizaPer;

    @Column(nullable = true, name = "nombre_compPoliza_per", length = 50)
    private String nombreCompPolizaPer;

    @Column(nullable = true, name = "beneficiario_Poliza_per", length = 150)
    private String beneficiarioPolizaPer;

    // ******* OTROS DATOS *******
    @Column(nullable = true, name = "idtipo_ocupacion_per")
    private Integer idtipoOcupacionPer;

    @Column(nullable = true, name = "uniorg_per")
    private Integer uniOrgPer;

    @Column(nullable = true, name = "ruc_per", length = 11)
    private String rucPer;

    @Column(nullable = true, name = "basico_per")
    private Double basicoPer;

    @Column(nullable = true, name = "nrohoras_per")
    private Double nroHorasPer;

    @Column(nullable = true, name = "nrodias_per")
    private Integer nroDiasPer;

    @Column(nullable = true, name = "tipoplanilla_colegio_per")
    private Integer tipoplanillacolegio;

    @Column(nullable = true, name = "basicoest_per")
    private Double basicoEstPer;

    @Column(nullable = true, name = "bonoCargoTotal_per")
    private Double bonifCargoTotalPer;

    //********************* datos contratos *********************
    @Column(nullable = true, name = "identidad_haberes_per")
    private Long idEntidadHaberesPer;

    @Column(nullable = true, name = "identidad_cts_per")
    private Long idEntidadCtsPer;

    @Column(nullable = true, name = "idtipomoneda_cts_per")
    private Integer idTipoMonedaCtsPer;

    @Column(nullable = true, length = 100, name = "nroctabac_haberes_per")
    private String nroCtabacHaberesper;

    @Column(nullable = true, length = 100, name = "nroctaintbac_haberes_per")
    private String nroCtaintbacHaberesper;

    @Column(nullable = true, length = 100, name = "nroctabac_cts_per")
    private String nroCtabacCtsper;

    @Column(nullable = true, length = 100, name = "nroctaintbac_cts_per")
    private String nroCtaintbacCtsper;

    @JsonIgnoreProperties({ "personalDep", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personalDep", cascade = CascadeType.ALL)
    private List<PersonalDependiente> personalDependiente;

    @JsonIgnoreProperties({ "personalHist", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personalHist", cascade = CascadeType.ALL)
    private List<PersonalHistorico> historico;

    @JsonIgnoreProperties({ "idPersonalPercont", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPersonalPercont", cascade = CascadeType.ALL)
    private List<PersonalContrato> personalContrato;

    @JsonIgnoreProperties({ "idPersonalPerconv", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPersonalPerconv", cascade = CascadeType.ALL)
    private List<PersonalConvenio> personalConvenio;

    @JsonIgnoreProperties({ "idPersonalFilePer", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPersonalFilePer", cascade = CascadeType.ALL)
    private List<DocumentEmployee> documentEmployee;

    @JsonIgnoreProperties({ "idPersonalPercargo", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPersonalPercargo", cascade = CascadeType.ALL)
    private List<PersonalCargo> personalCargo;

    @JsonIgnoreProperties({ "idPersonalPerdesv", "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPersonalPerdesv", cascade = CascadeType.ALL)
    private List<PersonalDesvinculacion> personalDesvinculacion;

    @PrePersist
    public void prePersist() {
        this.personalDependiente = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.fechaIngPer = new Date();

    }
    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Obra getObraPer() {
        return obraPer;
    }

    public void setObraPer(Obra obraPer) {
        this.obraPer = obraPer;
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

    public String getNumeroEssaludPer() {
        return numeroEssaludPer;
    }

    public void setNumeroEssaludPer(String numeroEssaludPer) {
        this.numeroEssaludPer = numeroEssaludPer;
    }

    public Long getIdEntidadEpsPer() {
        return idEntidadEpsPer;
    }

    public void setIdEntidadEpsPer(Long idEntidadEpsPer) {
        this.idEntidadEpsPer = idEntidadEpsPer;
    }

    public String getNumeroEpsPer() {
        return numeroEpsPer;
    }

    public void setNumeroEpsPer(String numeroEpsPer) {
        this.numeroEpsPer = numeroEpsPer;
    }

    public Integer getIdTipoPensionPer() {
        return idTipoPensionPer;
    }

    public void setIdTipoPensionPer(Integer idTipoPensionPer) {
        this.idTipoPensionPer = idTipoPensionPer;
    }

    public Long getIdEntidadPensPer() {
        return idEntidadPensPer;
    }

    public void setIdEntidadPensPer(Long idEntidadPensPer) {
        this.idEntidadPensPer = idEntidadPensPer;
    }

    public String getNumeroPensionPer() {
        return numeroPensionPer;
    }

    public void setNumeroPensionPer(String numeroPensionPer) {
        this.numeroPensionPer = numeroPensionPer;
    }

    public Boolean getFlgEsDiscapacitadoPer() {
        return flgEsDiscapacitadoPer;
    }

    public void setFlgEsDiscapacitadoPer(Boolean flgEsDiscapacitadoPer) {
        this.flgEsDiscapacitadoPer = flgEsDiscapacitadoPer;
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

    public Date getFechaModiPer() {
        return fechaModiPer;
    }

    public void setFechaModiPer(Date fechaModiPer) {
        this.fechaModiPer = fechaModiPer;
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

    public Integer getIdtipoOcupacionPer() {
        return idtipoOcupacionPer;
    }

    public void setIdtipoOcupacionPer(Integer idtipoOcupacionPer) {
        this.idtipoOcupacionPer = idtipoOcupacionPer;
    }

    public Integer getUniOrgPer() {
        return uniOrgPer;
    }

    public void setUniOrgPer(Integer uniOrgPer) {
        this.uniOrgPer = uniOrgPer;
    }

    public String getRucPer() {
        return rucPer;
    }

    public void setRucPer(String rucPer) {
        this.rucPer = rucPer;
    }

    public Double getBasicoPer() {
        return basicoPer;
    }

    public void setBasicoPer(Double basicoPer) {
        this.basicoPer = basicoPer;
    }

    public Double getNroHorasPer() {
        return nroHorasPer;
    }

    public void setNroHorasPer(Double nroHorasPer) {
        this.nroHorasPer = nroHorasPer;
    }

    public Integer getNroDiasPer() {
        return nroDiasPer;
    }

    public void setNroDiasPer(Integer nroDiasPer) {
        this.nroDiasPer = nroDiasPer;
    }

    public Integer getTipoplanillacolegio() {
        return tipoplanillacolegio;
    }

    public void setTipoplanillacolegio(Integer tipoplanillacolegio) {
        this.tipoplanillacolegio = tipoplanillacolegio;
    }

    public Double getBasicoEstPer() {
        return basicoEstPer;
    }

    public void setBasicoEstPer(Double basicoEstPer) {

        this.basicoEstPer = basicoEstPer;
    }

    public Double getBonifCargoTotalPer() {
        return bonifCargoTotalPer;
    }

    public void setBonifCargoTotalPer(Double bonifCargoTotalPer) {

        this.bonifCargoTotalPer = bonifCargoTotalPer;
    }

    public Long getIdPerSigma() {
        return idPerSigma;
    }

    public void setIdPerSigma(Long idPerSigma) {
        this.idPerSigma = idPerSigma;
    }

    public String getEspecDiscapacidadPer() {
        return especDiscapacidadPer;
    }

    public void setEspecDiscapacidadPer(String especDiscapacidadPer) {
        this.especDiscapacidadPer = especDiscapacidadPer;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public String getNroDocPer() {
        return nroDocPer;
    }

    public void setNroDocPer(String nroDocPer) {
        this.nroDocPer = nroDocPer;
    }

    public Long getIdEntidadHaberesPer() {
        return idEntidadHaberesPer;
    }

    public void setIdEntidadHaberesPer(Long idEntidadHaberesPer) {
        this.idEntidadHaberesPer = idEntidadHaberesPer;
    }

    public Long getIdEntidadCtsPer() {
        return idEntidadCtsPer;
    }

    public void setIdEntidadCtsPer(Long idEntidadCtsPer) {
        this.idEntidadCtsPer = idEntidadCtsPer;
    }

    public Integer getIdTipoMonedaCtsPer() {
        return idTipoMonedaCtsPer;
    }

    public void setIdTipoMonedaCtsPer(Integer idTipoMonedaCtsPer) {
        this.idTipoMonedaCtsPer = idTipoMonedaCtsPer;
    }

    public String getNroCtabacHaberesper() {
        return nroCtabacHaberesper;
    }

    public void setNroCtabacHaberesper(String nroCtabacHaberesper) {
        this.nroCtabacHaberesper = nroCtabacHaberesper;
    }

    public String getNroCtaintbacHaberesper() {
        return nroCtaintbacHaberesper;
    }

    public void setNroCtaintbacHaberesper(String nroCtaintbacHaberesper) {
        this.nroCtaintbacHaberesper = nroCtaintbacHaberesper;
    }

    public String getNroCtabacCtsper() {
        return nroCtabacCtsper;
    }

    public void setNroCtabacCtsper(String nroCtabacCtsper) {
        this.nroCtabacCtsper = nroCtabacCtsper;
    }

    public String getNroCtaintbacCtsper() {
        return nroCtaintbacCtsper;
    }

    public void setNroCtaintbacCtsper(String nroCtaintbacCtsper) {
        this.nroCtaintbacCtsper = nroCtaintbacCtsper;
    }

    private static final long serialVersionUID = 1L;

}
