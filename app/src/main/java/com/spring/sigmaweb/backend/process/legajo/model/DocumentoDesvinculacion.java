package com.spring.sigmaweb.backend.process.legajo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "mo_documentos_desv")
public class DocumentoDesvinculacion implements Serializable {
    @Id
    @Column(name = "id_docdesv",  nullable = false, unique = true)
    private Long idDocdesv;

    @Column(name = "id_obra_docdesv", nullable = false, length = 6)
    private String idObraDocdesv;

    @Column(name = "descripcion_docdesv", nullable = false, length = 200)
    private String descripcionDocdesv;

    @Column(name = "tipo_docdesv", nullable = false, length = 4)
    private String tipoDocdesv;

    @Column(name = "descripcion_grupo_docdesv", nullable = false, length = 200)
    private String descripcionGrupoDocdesv;

    @Column(nullable = false, name = "flginsertar_monto_docdesv", columnDefinition = "boolean default false")
    private Boolean flgInsertarMontoDocdesv;

    @Column(nullable = false, name = "flgadjuntar_file_docdesv", columnDefinition = "boolean default false")
    private Boolean flgAdjuntarFileDocdesv;

    public Long getIdDocdesv() {
        return idDocdesv;
    }

    public void setIdDocdesv(Long idDocdesv) {
        this.idDocdesv = idDocdesv;
    }

    public String getIdObraDocdesv() {
        return idObraDocdesv;
    }

    public void setIdObraDocdesv(String idObraDocdesv) {
        this.idObraDocdesv = idObraDocdesv;
    }

    public String getDescripcionDocdesv() {
        return descripcionDocdesv;
    }

    public void setDescripcionDocdesv(String descripcionDocdesv) {
        this.descripcionDocdesv = descripcionDocdesv;
    }

    public String getTipoDocdesv() {
        return tipoDocdesv;
    }

    public void setTipoDocdesv(String tipoDocdesv) {
        this.tipoDocdesv = tipoDocdesv;
    }

    public String getDescripcionGrupoDocdesv() {
        return descripcionGrupoDocdesv;
    }

    public void setDescripcionGrupoDocdesv(String descripcionGrupoDocdesv) {
        this.descripcionGrupoDocdesv = descripcionGrupoDocdesv;
    }

    public Boolean getFlgInsertarMontoDocdesv() {
        return flgInsertarMontoDocdesv;
    }

    public void setFlgInsertarMontoDocdesv(Boolean flgInsertarMontoDocdesv) {
        this.flgInsertarMontoDocdesv = flgInsertarMontoDocdesv;
    }

    public Boolean getFlgAdjuntarFileDocdesv() {
        return flgAdjuntarFileDocdesv;
    }

    public void setFlgAdjuntarFileDocdesv(Boolean flgAdjuntarFileDocdesv) {
        this.flgAdjuntarFileDocdesv = flgAdjuntarFileDocdesv;
    }

    private static final long serialVersionUID = 1L;
}
