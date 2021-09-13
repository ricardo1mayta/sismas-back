package com.spring.sigmaweb.backend.process.generic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.sigmaweb.backend.process.core.model.Usuario;
import com.spring.sigmaweb.backend.process.legajo.model.Entidad;

@Entity
@Table(name = "mg_obras")
public class Obra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idObra", length = 6, nullable = false)
    private String idobra;

    @Column(name = "orden_obra", nullable = false, unique = true)
    private Long orden;

    @Column(nullable = false, length = 60, name = "nombreObra", unique = true)
    private String nombreobra;

    @Column(name = "imgLogoURL")
    private String imglogourl;

    @Column(nullable = false, name = "flgPagoRequeObra")
    private Boolean flgpagorequeobra;

    @Column(nullable = false, name = "flgCursoRequeObra")
    private Boolean flgcursorequeobra;

    @Column(name = "nomCompDirectObra")
    private String nomcompdirectobra;

    @Column(name = "direcObra")
    private String direcobra;

    @Column(name = "nrodocobra")
    private String nroDocObra;

    @Column(name = "idDepartObra")
    private Integer iddepartobra;

    @Column(name = "idProvinObra")
    private Integer idprovinobra;

    @Column(name = "idDistriObra")
    private Integer iddistriobra;

    @Column(name = "id_activoApp", nullable = true)
    private Integer idActivoApp;

    @Column(name = "access_ip_obra", nullable = true, length = 150)
    private String accessIpObra;

    @Column(name = "url_obra", nullable = true, length = 150)
    private String urlObra;

    @Column(name = "estado_obra", nullable = false, columnDefinition = "boolean default false")
    private Long estadoObra;

    @Column(nullable = false, name = "fechaIngObra")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.DATE)
    private Date fechaingobra;
    /*
        @JsonIgnoreProperties({"obra","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "obra", cascade = CascadeType.ALL)
        private List<Alumno> alumnos;

        @JsonIgnoreProperties({"obrasFami","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "obrasFami", cascade = CascadeType.ALL)
        private List<Familia> familia;

        @JsonIgnoreProperties({"obraDoc"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraDoc", cascade = CascadeType.ALL)
        private List<DocumentoObra> obradocumentos;
    */
    @JsonIgnoreProperties({"obraUs", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraUs", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;
    /*
        @JsonIgnoreProperties({"obraPer","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraPer", cascade = CascadeType.ALL)
        private List<Personal> personal;

        @JsonIgnoreProperties({"obraRolItem","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraRolItem", cascade = CascadeType.ALL)
        private List<Mm_rolSideNavItem> sideNavItemRolObra;

        @JsonIgnoreProperties({"obraHist","hibernateLazyInitializer", "handler"})
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraHist", cascade = CascadeType.ALL)
        private List<mo_personalHistorico> obraHistorico;
    */
    @JsonIgnoreProperties({"obraEnt", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "obraEnt", cascade = CascadeType.ALL)
    private List<Entidad> obraEntidad;

    public Obra() {
       /* this.alumnos = new ArrayList<>();
        this.familia = new ArrayList<>();
        this.obradocumentos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.personal = new ArrayList<>();
        //this.sideNavItem = new ArrayList<>();
        this.sideNavItemRolObra = new ArrayList<>();
        this.obraHistorico = new ArrayList<>();*/
    }

    @PrePersist
    public void prePersist() {
        this.fechaingobra = new Date();
    }

    private static final long serialVersionUID = 1L;

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    public String getNombreobra() {
        return nombreobra;
    }

    public void setNombreobra(String nombreobra) {
        this.nombreobra = nombreobra;
    }

    public String getImglogourl() {
        return imglogourl;
    }

    public void setImglogourl(String imglogourl) {
        this.imglogourl = imglogourl;
    }

    public Boolean getFlgpagorequeobra() {
        return flgpagorequeobra;
    }

    public void setFlgpagorequeobra(Boolean flgpagorequeobra) {
        this.flgpagorequeobra = flgpagorequeobra;
    }

    public Boolean getFlgcursorequeobra() {
        return flgcursorequeobra;
    }

    public void setFlgcursorequeobra(Boolean flgcursorequeobra) {
        this.flgcursorequeobra = flgcursorequeobra;
    }

    public String getNomcompdirectobra() {
        return nomcompdirectobra;
    }

    public void setNomcompdirectobra(String nomcompdirectobra) {
        this.nomcompdirectobra = nomcompdirectobra;
    }

    public String getDirecobra() {
        return direcobra;
    }

    public void setDirecobra(String direcobra) {
        this.direcobra = direcobra;
    }

    public Integer getIddepartobra() {
        return iddepartobra;
    }

    public void setIddepartobra(Integer iddepartobra) {
        this.iddepartobra = iddepartobra;
    }

    public Integer getIdprovinobra() {
        return idprovinobra;
    }

    public void setIdprovinobra(Integer idprovinobra) {
        this.idprovinobra = idprovinobra;
    }

    public Integer getIddistriobra() {
        return iddistriobra;
    }

    public void setIddistriobra(Integer iddistriobra) {
        this.iddistriobra = iddistriobra;
    }

    public Date getFechaingobra() {
        return fechaingobra;
    }

    public void setFechaingobra(Date fechaingobra) {
        this.fechaingobra = fechaingobra;
    }

    public String getNroDocObra() {
        return nroDocObra;
    }

    public void setNroDocObra(String nroDocObra) {
        this.nroDocObra = nroDocObra;
    }

    public Integer getIdActivoApp() {
        return idActivoApp;
    }

    public void setIdActivoApp(Integer idActivoApp) {
        this.idActivoApp = idActivoApp;
    }

    public String getAccessIpObra() {
        return accessIpObra;
    }

    public void setAccessIpObra(String accessIpObra) {
        this.accessIpObra = accessIpObra;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public String getUrlObra() {
        return urlObra;
    }

    public void setUrlObra(String urlObra) {
        this.urlObra = urlObra;
    }

    public Long getEstadoObra() {
        return estadoObra;
    }

    public void setEstadoObra(Long estadoObra) {
        this.estadoObra = estadoObra;
    }
}
