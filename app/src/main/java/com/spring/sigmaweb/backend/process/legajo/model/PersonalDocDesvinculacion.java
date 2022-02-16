package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_personal_docdesv")
public class PersonalDocDesvinculacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_perentr", nullable = false)
    private String idPerentr;

    @Column(name = "id_perdesv_perentr", nullable = false)
    private Long idPerdesvPerentr;

    @Column(nullable = false, length = 6, name = "id_obra_perentr")
    private String idObraPerentr;

    @Column(nullable = false,  name = "id_tipodocudesv_perentr")
    private Long idTipoDocDesvPerentr;

    @Column(nullable = false, name = "flg_entrego_perentr", columnDefinition = "boolean default false")
    private Boolean flgEntregoPerentr;

    @Column(nullable = true,  name = "monto_perentr")
    private Double montoPerentr;

    @Column(nullable = true, name = "fechaejecucion_perentr")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEjecucionPerentr;

    @Column(nullable = true, length = 100, name = "id_responsable_perentr")
    private String idResponsablePerentr;

    @Column(nullable = true, length = 100, name = "idfile_upload_perentr")
    private String idfileUploadPerentr;


    public String getIdPerentr() {
        return idPerentr;
    }

    public void setIdPerentr(String idPerentr) {
        this.idPerentr = idPerentr;
    }

    public Long getIdPerdesvPerentr() {
        return idPerdesvPerentr;
    }

    public void setIdPerdesvPerentr(Long idPerdesvPerentr) {
        this.idPerdesvPerentr = idPerdesvPerentr;
    }

    public String getIdObraPerentr() {
        return idObraPerentr;
    }

    public void setIdObraPerentr(String idObraPerentr) {
        this.idObraPerentr = idObraPerentr;
    }

    public Long getIdTipoDocDesvPerentr() {
        return idTipoDocDesvPerentr;
    }

    public void setIdTipoDocDesvPerentr(Long idTipoDocDesvPerentr) {
        this.idTipoDocDesvPerentr = idTipoDocDesvPerentr;
    }

    public Boolean getFlgEntregoPerentr() {
        return flgEntregoPerentr;
    }

    public void setFlgEntregoPerentr(Boolean flgEntregoPerentr) {
        this.flgEntregoPerentr = flgEntregoPerentr;
    }

    public Date getFechaEjecucionPerentr() {
        return fechaEjecucionPerentr;
    }

    public void setFechaEjecucionPerentr(Date fechaEjecucionPerentr) {
        this.fechaEjecucionPerentr = fechaEjecucionPerentr;
    }

    public String getIdResponsablePerentr() {
        return idResponsablePerentr;
    }

    public void setIdResponsablePerentr(String idResponsablePerentr) {
        this.idResponsablePerentr = idResponsablePerentr;
    }

    public Double getMontoPerentr() {
        return montoPerentr;
    }

    public void setMontoPerentr(Double montoPerentr) {
        this.montoPerentr = montoPerentr;
    }

    public String getIdfileUploadPerentr() {
        return idfileUploadPerentr;
    }

    public void setIdfileUploadPerentr(String idfileUploadPerentr) {
        this.idfileUploadPerentr = idfileUploadPerentr;
    }

    private static final long serialVersionUID = 1L;
}
