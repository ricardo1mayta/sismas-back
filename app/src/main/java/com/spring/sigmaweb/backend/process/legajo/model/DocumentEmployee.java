package com.spring.sigmaweb.backend.process.legajo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "mo_document_uploaded_employee")
public class DocumentEmployee implements Serializable  {
    @Id
    @Column(name = "id_fileper",  nullable = false, unique = true)
    private Long idFilePer;

    @Column(name = "id_obrafileper", nullable = false, length = 6)
    private String idObraFilePer;

    @JsonIgnoreProperties(value = {"id_personalfile", "idPersonalContPerjorn", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_personalfile", foreignKey = @ForeignKey(name = "fk_file_x_personal"))
    private Personal idPersonalFilePer;

    @Column(name = "title_fileper", nullable = false, length = 500)
    private String titleFilePer;

    @Column(name = "description_fileper", nullable = false, length = 500)
    private String descripcionFilePer;

    @Column(name = "type_fileper", nullable = false, length = 10)
    private String typeFilePer;

    @Column(name = "size_fileper", nullable = false)
    private Long sizeFilePer;

    @Column(nullable = false, name = "upload_date_fileper")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDateFilePer;

    @Column(nullable = false, name = "creapor_fileper", length = 100)
    private String creaPorFilePer;

    @PrePersist
    public void prePersist() {
        this.uploadDateFilePer= new Date();
    }

    public Long getIdFilePer() {
        return idFilePer;
    }

    public void setIdFilePer(Long idFilePer) {
        this.idFilePer = idFilePer;
    }

    public String getIdObraFilePer() {
        return idObraFilePer;
    }

    public void setIdObraFilePer(String idObraFilePer) {
        this.idObraFilePer = idObraFilePer;
    }

    public Personal getIdPersonalFilePer() {
        return idPersonalFilePer;
    }

    public void setIdPersonalFilePer(Personal idPersonalFilePer) {
        this.idPersonalFilePer = idPersonalFilePer;
    }

    public String getTitleFilePer() {
        return titleFilePer;
    }

    public void setTitleFilePer(String titleFilePer) {
        this.titleFilePer = titleFilePer;
    }

    public String getDescripcionFilePer() {
        return descripcionFilePer;
    }

    public void setDescripcionFilePer(String descripcionFilePer) {
        this.descripcionFilePer = descripcionFilePer;
    }

    public String getTypeFilePer() {
        return typeFilePer;
    }

    public void setTypeFilePer(String typeFilePer) {
        this.typeFilePer = typeFilePer;
    }

    public Long getSizeFilePer() {
        return sizeFilePer;
    }

    public void setSizeFilePer(Long sizeFilePer) {
        this.sizeFilePer = sizeFilePer;
    }

    public Date getUploadDateFilePer() {
        return uploadDateFilePer;
    }

    public void setUploadDateFilePer(Date uploadDateFilePer) {
        this.uploadDateFilePer = uploadDateFilePer;
    }

    public String getCreaPorFilePer() {
        return creaPorFilePer;
    }

    public void setCreaPorFilePer(String creaPorFilePer) {
        this.creaPorFilePer = creaPorFilePer;
    }
}
