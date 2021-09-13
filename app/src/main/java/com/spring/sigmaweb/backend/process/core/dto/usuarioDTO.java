package com.spring.sigmaweb.backend.process.core.dto;

import java.io.Serializable;

public class usuarioDTO implements Serializable {
    private Long idUser;
    private String username;
    private String password;
    private String emailUser;
    private Boolean Activo;
    private String tipoUser;
    private Long idcodTipoUser;
    private String roles;
    private String apePaternoUser;
    private String apeMaternoUser;
    private String nombresUser;
    private String nomComplUser;

    public usuarioDTO(Long idUser, String username, String password, String emailUser, Boolean activo, String tipoUser, Long idcodTipoUser, String roles, String apePaternoUser, String apeMaternoUser, String nombresUser, String nomComplUser) {
        super();
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.emailUser = emailUser;
        Activo = activo;
        this.tipoUser = tipoUser;
        this.idcodTipoUser = idcodTipoUser;
        this.roles = roles;
        this.apePaternoUser = apePaternoUser;
        this.apeMaternoUser = apeMaternoUser;
        this.nombresUser = nombresUser;
        this.nomComplUser = nomComplUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Boolean getActivo() {
        return Activo;
    }

    public void setActivo(Boolean activo) {
        Activo = activo;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getApePaternoUser() {
        return apePaternoUser;
    }

    public void setApePaternoUser(String apePaternoUser) {
        this.apePaternoUser = apePaternoUser;
    }

    public String getApeMaternoUser() {
        return apeMaternoUser;
    }

    public void setApeMaternoUser(String apeMaternoUser) {
        this.apeMaternoUser = apeMaternoUser;
    }

    public String getNombresUser() {
        return nombresUser;
    }

    public void setNombresUser(String nombresUser) {
        this.nombresUser = nombresUser;
    }

    public String getNomComplUser() {
        return nomComplUser;
    }

    public void setNomComplUser(String nomComplUser) {
        this.nomComplUser = nomComplUser;
    }

    private static final long serialVersionUID = 1L;
}
