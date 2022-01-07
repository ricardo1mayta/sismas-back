package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.Obra;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_entidades")
public class Entidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ent", nullable = false)
    private Long idEntidad;

    @JsonIgnoreProperties(value = { "alumnos", "familia", "obradocumentos", "usuarios", "personal",
            "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_obra", foreignKey = @ForeignKey(name = "fk_entidad_obra"))
    private Obra obraEnt;

    @Column(nullable = false, length = 12, name = "ruc_ent")
    private String rucEnt;

    @Column(nullable = false, length = 200, name = "nombre_ent")
    private String nombreEnt;

    @Column(nullable = true, length = 200, name = "nombrecomer_ent")
    private String nombreComerEnt;

    @Column(nullable = true, length = 50, name = "email_ent")
    private String emailEnt;

    @Column(nullable = true, length = 200, name = "url_ent")
    private String urlEnt;

    @Column(nullable = true, length = 50, name = "telefono_ent")
    private String telefonoEnt;

    @Column(nullable = true, length = 100, name = "contacto_ent")
    private String contactoEnt;

    @Column(nullable = true, length = 200, name = "partidaReg_ent")
    private String partidaRegEnt;

    @Column(nullable = true, length = 100, name = "representante_ent")
    private String representanteEnt;

    @Column(nullable = true, length = 20, name = "representante_nrodoc_ent")
    private String representanteNroDocEnt;

    @Column(nullable = true, length = 50, name = "detraccion_banco_ent")
    private String detraccionBancoEnt;

    @Column(nullable = true, length = 50, name = "detraccion_cta_ent")
    private String detraccionCtaEnt;

    @Column(nullable = true, name = "idpais_ent")
    private Integer idPaisEnt;

    @Column(nullable = true, name = "idDistrito_ent")
    private Integer idDistritoEnt;

    @Column(nullable = true, length = 200, name = "direccion_ent")
    private String direccionEnt;

    @Column(nullable = true, name = "tipo_ent")
    private Integer tipoEnt;

    @Column(nullable = true, name = "rublo_ent")
    private Integer rubroEnt;

    @Column(nullable = true, length = 40, name = "nrocta_soles_ent")
    private String nroCtaSolesEnt;

    @Column(nullable = true, length = 40, name = "ccisoles_ent")
    private String cciSolesEnt;

    @Column(nullable = true, length = 15, name = "rucBanco_soles_ent")
    private String rucBancoSolesEnt;

    @Column(nullable = true, length = 40, name = "nrocta_dolar_ent")
    private String nroCtaDolarEnt;

    @Column(nullable = true, length = 40, name = "ccidolar_ent")
    private String cciDolarEnt;

    @Column(nullable = true, length = 15, name = "rucbanco_dolar_ent")
    private String rucBancoDolarEnt;

    @Column(nullable = true, length = 15, name = "rucbanco_padre_ent")
    private String rucBancoPadreEnt;

    @Column(nullable = false, name = "flg_proveedor_ent", columnDefinition = "boolean default false")
    private Boolean flgProveedorEnt;

    @Column(nullable = false, name = "flg_previsional_ent", columnDefinition = "boolean default false")
    private Boolean flgPrevisionalEnt;

    @Column(nullable = false, name = "flg_salud_ent", columnDefinition = "boolean default false")
    private Boolean flgSaludEnt;

    @Column(nullable = false, name = "flg_edusup_ent", columnDefinition = "boolean default false")
    private Boolean flgEduSupEnt;

    @Column(nullable = false, name = "flg_financiera_ent", columnDefinition = "boolean default false")
    private Boolean flgFinacieraEnt;

    @Column(nullable = false, name = "fechaing_ent")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngEnt;

    @Column(nullable = false, name = "creapor_ent", length = 100)
    private String creaPorEnt;

    @Column(nullable = true, name = "fechamodi_ent")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiEnt;

    @Column(nullable = true, name = "modipor_ent", length = 100)
    private String modiPorEnt;

    @Column(nullable = false, name = "estado_ent", columnDefinition = "boolean default true")
    private Boolean estadoEnt;

    @PrePersist
    public void prePersist() {
        this.fechaIngEnt = new Date();
    }
    public Long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Obra getObraEnt() {
        return obraEnt;
    }

    public void setObraEnt(Obra obraEnt) {
        this.obraEnt = obraEnt;
    }

    public String getRucEnt() {
        return rucEnt;
    }

    public void setRucEnt(String rucEnt) {
        this.rucEnt = rucEnt;
    }

    public String getNombreEnt() {
        return nombreEnt;
    }

    public void setNombreEnt(String nombreEnt) {
        this.nombreEnt = nombreEnt;
    }

    public String getNombreComerEnt() {
        return nombreComerEnt;
    }

    public void setNombreComerEnt(String nombreComerEnt) {
        this.nombreComerEnt = nombreComerEnt;
    }

    public String getEmailEnt() {
        return emailEnt;
    }

    public void setEmailEnt(String emailEnt) {
        this.emailEnt = emailEnt;
    }

    public String getUrlEnt() {
        return urlEnt;
    }

    public void setUrlEnt(String urlEnt) {
        this.urlEnt = urlEnt;
    }

    public String getTelefonoEnt() {
        return telefonoEnt;
    }

    public void setTelefonoEnt(String telefonoEnt) {
        this.telefonoEnt = telefonoEnt;
    }

    public String getContactoEnt() {
        return contactoEnt;
    }

    public void setContactoEnt(String contactoEnt) {
        this.contactoEnt = contactoEnt;
    }

    public String getPartidaRegEnt() {
        return partidaRegEnt;
    }

    public void setPartidaRegEnt(String partidaRegEnt) {
        this.partidaRegEnt = partidaRegEnt;
    }

    public String getRepresentanteEnt() {
        return representanteEnt;
    }

    public void setRepresentanteEnt(String representanteEnt) {
        this.representanteEnt = representanteEnt;
    }

    public String getRepresentanteNroDocEnt() {
        return representanteNroDocEnt;
    }

    public void setRepresentanteNroDocEnt(String representanteNroDocEnt) {
        this.representanteNroDocEnt = representanteNroDocEnt;
    }

    public String getDetraccionBancoEnt() {
        return detraccionBancoEnt;
    }

    public void setDetraccionBancoEnt(String detraccionBancoEnt) {
        this.detraccionBancoEnt = detraccionBancoEnt;
    }

    public String getDetraccionCtaEnt() {
        return detraccionCtaEnt;
    }

    public void setDetraccionCtaEnt(String detraccionCtaEnt) {
        this.detraccionCtaEnt = detraccionCtaEnt;
    }

    public Integer getIdPaisEnt() {
        return idPaisEnt;
    }

    public void setIdPaisEnt(Integer idPaisEnt) {
        this.idPaisEnt = idPaisEnt;
    }

    public Integer getIdDistritoEnt() {
        return idDistritoEnt;
    }

    public void setIdDistritoEnt(Integer idDistritoEnt) {
        this.idDistritoEnt = idDistritoEnt;
    }

    public String getDireccionEnt() {
        return direccionEnt;
    }

    public void setDireccionEnt(String direccionEnt) {
        this.direccionEnt = direccionEnt;
    }

    public Integer getTipoEnt() {
        return tipoEnt;
    }

    public void setTipoEnt(Integer tipoEnt) {
        this.tipoEnt = tipoEnt;
    }

    public Integer getRubroEnt() {
        return rubroEnt;
    }

    public void setRubroEnt(Integer rubroEnt) {
        this.rubroEnt = rubroEnt;
    }

    public String getNroCtaSolesEnt() {
        return nroCtaSolesEnt;
    }

    public void setNroCtaSolesEnt(String nroCtaSolesEnt) {
        this.nroCtaSolesEnt = nroCtaSolesEnt;
    }

    public String getCciSolesEnt() {
        return cciSolesEnt;
    }

    public void setCciSolesEnt(String cciSolesEnt) {
        this.cciSolesEnt = cciSolesEnt;
    }

    public String getRucBancoSolesEnt() {
        return rucBancoSolesEnt;
    }

    public void setRucBancoSolesEnt(String rucBancoSolesEnt) {
        this.rucBancoSolesEnt = rucBancoSolesEnt;
    }

    public String getNroCtaDolarEnt() {
        return nroCtaDolarEnt;
    }

    public void setNroCtaDolarEnt(String nroCtaDolarEnt) {
        this.nroCtaDolarEnt = nroCtaDolarEnt;
    }

    public String getCciDolarEnt() {
        return cciDolarEnt;
    }

    public void setCciDolarEnt(String cciDolarEnt) {
        this.cciDolarEnt = cciDolarEnt;
    }

    public String getRucBancoDolarEnt() {
        return rucBancoDolarEnt;
    }

    public void setRucBancoDolarEnt(String rucBancoDolarEnt) {
        this.rucBancoDolarEnt = rucBancoDolarEnt;
    }

    public String getRucBancoPadreEnt() {
        return rucBancoPadreEnt;
    }

    public void setRucBancoPadreEnt(String rucBancoPadreEnt) {
        this.rucBancoPadreEnt = rucBancoPadreEnt;
    }

    public Boolean getFlgProveedorEnt() {
        return flgProveedorEnt;
    }

    public void setFlgProveedorEnt(Boolean flgProveedorEnt) {
        this.flgProveedorEnt = flgProveedorEnt;
    }

    public Boolean getFlgPrevisionalEnt() {
        return flgPrevisionalEnt;
    }

    public void setFlgPrevisionalEnt(Boolean flgPrevisionalEnt) {
        this.flgPrevisionalEnt = flgPrevisionalEnt;
    }

    public Boolean getFlgSaludEnt() {
        return flgSaludEnt;
    }

    public void setFlgSaludEnt(Boolean flgSaludEnt) {
        this.flgSaludEnt = flgSaludEnt;
    }

    public Boolean getFlgEduSupEnt() {
        return flgEduSupEnt;
    }

    public void setFlgEduSupEnt(Boolean flgEduSupEnt) {
        this.flgEduSupEnt = flgEduSupEnt;
    }

    public Boolean getFlgFinacieraEnt() {
        return flgFinacieraEnt;
    }

    public void setFlgFinacieraEnt(Boolean flgFinacieraEnt) {
        this.flgFinacieraEnt = flgFinacieraEnt;
    }

    public Date getFechaIngEnt() {
        return fechaIngEnt;
    }

    public void setFechaIngEnt(Date fechaIngEnt) {
        this.fechaIngEnt = fechaIngEnt;
    }

    public String getCreaPorEnt() {
        return creaPorEnt;
    }

    public void setCreaPorEnt(String creaPorEnt) {
        this.creaPorEnt = creaPorEnt;
    }

    public Date getFechaModiEnt() {
        return fechaModiEnt;
    }

    public void setFechaModiEnt(Date fechaModiEnt) {
        this.fechaModiEnt = fechaModiEnt;
    }

    public String getModiPorEnt() {
        return modiPorEnt;
    }

    public void setModiPorEnt(String modiPorEnt) {
        this.modiPorEnt = modiPorEnt;
    }

    public Boolean getEstadoEnt() {
        return estadoEnt;
    }

    public void setEstadoEnt(Boolean estadoEnt) {
        this.estadoEnt = estadoEnt;
    }

    private static final long serialVersionUID = 1L;
}
