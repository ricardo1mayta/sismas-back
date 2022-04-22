package com.spring.sigmaweb.backend.process.legajo.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.generic.model.TablasTabla;

@Entity
@Table(name = "mo_personaldependiente")
public class PersonalDependiente  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaldep", nullable = false)
    private Long idPersonalDep;

    @JsonIgnoreProperties(value = { "personalDependiente", "hibernateLazyInitializer",
            "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personal", foreignKey = @ForeignKey(name = "fk_personalexperiencia_personal"))
    private Personal personalDep;

    @JsonIgnoreProperties({"alumnoDocumento","padreDocumento","madreDocumento","otroFamiDocumento","personalDocumento","padreEstCivil","madreEstCivil","otroEstCivil","personalEstCivil","personalDepEstCivil","alumnosviveCom","otroFamiParentalumnosRespPago", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parentesco_perdep", foreignKey = @ForeignKey(name = "fk_personaldependiente_tipoParentes"))
    private TablasTabla parentescoPerDep;

    @Column(name = "flg_vive_perdep", nullable = false, columnDefinition = "boolean default true")
    private Boolean flgvive;

    @Column(name = "flg_discapacidad_perdep", nullable = false, columnDefinition = "boolean default false")
    private Boolean flgDiscapacidadPerdep;

    @Column(name = "nombre_perdep", nullable = false, length = 33)
    private String nombrePerDep;

    @Column(name = "appaterno_perdep", nullable = false, length = 33)
    private String apPaternoPerDep;

    @Column(name = "apmaterno_perdep", nullable = false, length = 33)
    private String apMaternoPerDep;

    @Column(nullable = false, name = "sexo_perdep", columnDefinition = "tinyint default 0")
    private Byte sexoAPerDep;

    @JsonIgnoreProperties({"alumnoDocumento","padreDocumento","madreDocumento","otroFamiDocumento","personalDocumento","padreEstCivil","madreEstCivil","otroEstCivil","personalEstCivil","personalDepEstCivil","alumnosviveCom","otroFamiParentalumnosRespPago", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estcivil_perdep", foreignKey = @ForeignKey(name = "fk_personaldependiente_estadoCivil"))
    private TablasTabla estCivilPerDep;

    @Column(nullable = false, name = "id_tipodoc_perdep")
    private Integer idTipoDocPerDep;

    @Column(nullable = false, length = 50, name = "nrodoc_perdep")
    private String nroDocPerDep;

    @Column(nullable = false, name = "fecha_nac_perdep")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacPerDep;

    @Column(nullable = true, length = 25, name = "telefono_perdep")
    private String telefonoPerDep;

    @Column(nullable = true, length = 100, name = "nacionalidad_perdep")
    private String nacionalidadPerDep;

    @Column(nullable = false, name = "gradoacademico_perdep")
    private Long gradoAcademicoPerDep;

    @Column(name = "flg_estudiaact_perdep", nullable = false, columnDefinition = "boolean default false")
    private Boolean flgEstudiaActPerDep;

    @Column(nullable = true, length = 100, name = "nombre_insteduc_perdep")
    private String nombreInstEducPerDep;

    @Column(nullable = false, name = "creapor_perdep", length = 100)
    private String creaPorPerDep;

    @Column(nullable = false, name = "fechaing_perdep")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngPerDep;

    @Column(nullable = true, name = "fechamodi_perdep")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModiPerDep;

    @Column(nullable = true, name = "modipor_perdep", length = 100)
    private String modiPorPerDep;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        this.fechaIngPerDep = new Date();
    }

    public Long getIdPersonalDep() {
        return idPersonalDep;
    }

    public void setIdPersonalDep(Long idPersonalDep) {
        this.idPersonalDep = idPersonalDep;
    }

    public Personal getPersonalDep() {
        return personalDep;
    }

    public void setPersonalDep(Personal personalDep) {
        this.personalDep = personalDep;
    }

    public TablasTabla getParentescoPerDep() {
        return parentescoPerDep;
    }

    public void setParentescoPerDep(TablasTabla parentescoPerDep) {
        this.parentescoPerDep = parentescoPerDep;
    }

    public Boolean getFlgvive() {
        return flgvive;
    }

    public void setFlgvive(Boolean flgvive) {
        this.flgvive = flgvive;
    }

    public String getNombrePerDep() {
        return nombrePerDep;
    }

    public void setNombrePerDep(String nombrePerDep) {
        this.nombrePerDep = nombrePerDep;
    }

    public String getApPaternoPerDep() {
        return apPaternoPerDep;
    }

    public void setApPaternoPerDep(String apPaternoPerDep) {
        this.apPaternoPerDep = apPaternoPerDep;
    }

    public String getApMaternoPerDep() {
        return apMaternoPerDep;
    }

    public void setApMaternoPerDep(String apMaternoPerDep) {
        this.apMaternoPerDep = apMaternoPerDep;
    }

    public Byte getSexoAPerDep() {
        return sexoAPerDep;
    }

    public void setSexoAPerDep(Byte sexoAPerDep) {
        this.sexoAPerDep = sexoAPerDep;
    }

    public TablasTabla getEstCivilPerDep() {
        return estCivilPerDep;
    }

    public void setEstCivilPerDep(TablasTabla estCivilPerDep) {
        this.estCivilPerDep = estCivilPerDep;
    }

    public Integer getIdTipoDocPerDep() {
        return idTipoDocPerDep;
    }

    public void setIdTipoDocPerDep(Integer idTipoDocPerDep) {
        this.idTipoDocPerDep = idTipoDocPerDep;
    }

    public String getNroDocPerDep() {
        return nroDocPerDep;
    }

    public void setNroDocPerDep(String nroDocPerDep) {
        this.nroDocPerDep = nroDocPerDep;
    }

    public Date getFechaNacPerDep() {
        return fechaNacPerDep;
    }

    public void setFechaNacPerDep(Date fechaNacPerDep) {
        this.fechaNacPerDep = fechaNacPerDep;
    }

    public String getTelefonoPerDep() {
        return telefonoPerDep;
    }

    public void setTelefonoPerDep(String telefonoPerDep) {
        this.telefonoPerDep = telefonoPerDep;
    }

    public String getNacionalidadPerDep() {
        return nacionalidadPerDep;
    }

    public void setNacionalidadPerDep(String nacionalidadPerDep) {
        this.nacionalidadPerDep = nacionalidadPerDep;
    }

    public Long getGradoAcademicoPerDep() {
        return gradoAcademicoPerDep;
    }

    public void setGradoAcademicoPerDep(Long gradoAcademicoPerDep) {
        this.gradoAcademicoPerDep = gradoAcademicoPerDep;
    }

    public Boolean getFlgEstudiaActPerDep() {
        return flgEstudiaActPerDep;
    }

    public void setFlgEstudiaActPerDep(Boolean flgEstudiaActPerDep) {
        this.flgEstudiaActPerDep = flgEstudiaActPerDep;
    }

    public String getNombreInstEducPerDep() {
        return nombreInstEducPerDep;
    }

    public void setNombreInstEducPerDep(String nombreInstEducPerDep) {
        this.nombreInstEducPerDep = nombreInstEducPerDep;
    }

    public String getCreaPorPerDep() {
        return creaPorPerDep;
    }

    public void setCreaPorPerDep(String creaPorPerDep) {
        this.creaPorPerDep = creaPorPerDep;
    }

    public Date getFechaIngPerDep() {
        return fechaIngPerDep;
    }

    public void setFechaIngPerDep(Date fechaIngPerDep) {
        this.fechaIngPerDep = fechaIngPerDep;
    }

    public Date getFechaModiPerDep() {
        return fechaModiPerDep;
    }

    public void setFechaModiPerDep(Date fechaModiPerDep) {
        this.fechaModiPerDep = fechaModiPerDep;
    }

    public String getModiPorPerDep() {
        return modiPorPerDep;
    }

    public Boolean getFlgDiscapacidadPerdep() {
        return flgDiscapacidadPerdep;
    }

    public void setFlgDiscapacidadPerdep(Boolean flgDiscapacidadPerdep) {
        this.flgDiscapacidadPerdep = flgDiscapacidadPerdep;
    }

    public void setModiPorPerDep(String modiPorPerDep) {
        this.modiPorPerDep = modiPorPerDep;
    }

}
