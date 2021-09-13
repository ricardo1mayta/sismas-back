package com.spring.sigmaweb.backend.process.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private Long idRol;

    @Column(name = "nombre_rol", length = 20, nullable = false)
    private String nombreRol;


    @Column(name = "descripcion_rol", length = 50, nullable = false)
    private String descripcionRol;

    @Column(name = "idobra_rol", length = 6, nullable = false)
    private String idobraRol;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public String getIdobraRol() {
        return idobraRol;
    }

    public void setIdobraRol(String idobraRol) {
        this.idobraRol = idobraRol;
    }

    private static final long serialVersionUID = 1L;
}
