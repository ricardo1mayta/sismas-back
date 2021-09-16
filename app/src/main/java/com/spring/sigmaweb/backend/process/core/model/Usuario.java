package com.spring.sigmaweb.backend.process.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.spring.sigmaweb.backend.process.generic.model.Obra;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(nullable = false, length = 80, unique = true)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(name = "email_login", nullable = false, length = 100)
    private String emailUser;

    @Column(name = "activo_user")
    private Boolean Activo;

    @Column(name = "tipo_user", length = 5, nullable = false)
    private String tipoUser;

    @Column(name = "codi_user", nullable = true)
    private Long idcodTipoUser;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rol> roles;
    /*
        @JsonIgnoreProperties({"usuario","hibernateLazyInitializer", "handler"})
        @OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
        private Familia familia;
        */
    @JsonIgnoreProperties({"alumnos", "familia", "obradocumentos", "usuarios", "personal", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Obra obraUs;


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Obra getObraUs() {
        return obraUs;
    }

    public void setObraUs(Obra obraUs) {
        this.obraUs = obraUs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        Activo = activo;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public Long getIdcodTipoUser() {
        return idcodTipoUser;
    }

    public void setIdcodTipoUser(Long idcodTipoUser) {
        this.idcodTipoUser = idcodTipoUser;
    }

    private static final long serialVersionUID = 1L;
}
