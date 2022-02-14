package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class DocumentEmployeeDTO implements Serializable {
    private Long idFilePer;
    private String idObraFilePer;
    private Long idPersonal;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private String titleFilePer;
    private String fileNameFilePer;
    private String urlFilePer;
    private String tipoFilePer;
    private Long opcionFilePer;
    private Long idItemPadreFileper;
    private String descripcionFilePer;
    private String typeFilePer;
    private Long sizeFilePer;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date uploadDateFilePer;

    private String creaPorFilePer;

    public DocumentEmployeeDTO(Long idFilePer, String idObraFilePer, Long idPersonal, String apePaternoPers, String apeMaternoPers, String nombrePers, String titleFilePer, String fileNameFilePer, String urlFilePer, String tipoFilePer, Long opcionFilePer, Long idItemPadreFileper, String descripcionFilePer, String typeFilePer, Long sizeFilePer, Date uploadDateFilePer, String creaPorFilePer) {
        this.idFilePer = idFilePer;
        this.idObraFilePer = idObraFilePer;
        this.idPersonal = idPersonal;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.titleFilePer = titleFilePer;
        this.fileNameFilePer = fileNameFilePer;
        this.urlFilePer = urlFilePer;
        this.tipoFilePer = tipoFilePer;
        this.opcionFilePer = opcionFilePer;
        this.idItemPadreFileper = idItemPadreFileper;
        this.descripcionFilePer = descripcionFilePer;
        this.typeFilePer = typeFilePer;
        this.sizeFilePer = sizeFilePer;
        this.uploadDateFilePer = uploadDateFilePer;
        this.creaPorFilePer = creaPorFilePer;
    }

    public DocumentEmployeeDTO() {
        super();
        // TODO Auto-generated constructor stub
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

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getApePaternoPers() {
        return apePaternoPers;
    }

    public void setApePaternoPers(String apePaternoPers) {
        this.apePaternoPers = apePaternoPers;
    }

    public String getApeMaternoPers() {
        return apeMaternoPers;
    }

    public void setApeMaternoPers(String apeMaternoPers) {
        this.apeMaternoPers = apeMaternoPers;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
    }

    public String getTitleFilePer() {
        return titleFilePer;
    }

    public void setTitleFilePer(String titleFilePer) {
        this.titleFilePer = titleFilePer;
    }

    public String getTipoFilePer() {
        return tipoFilePer;
    }

    public void setTipoFilePer(String tipoFilePer) {
        this.tipoFilePer = tipoFilePer;
    }

    public Long getOpcionFilePer() {
        return opcionFilePer;
    }

    public void setOpcionFilePer(Long opcionFilePer) {
        this.opcionFilePer = opcionFilePer;
    }

    public Long getIdItemPadreFileper() {
        return idItemPadreFileper;
    }

    public void setIdItemPadreFileper(Long idItemPadreFileper) {
        this.idItemPadreFileper = idItemPadreFileper;
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

    public String getUrlFilePer() {
        return urlFilePer;
    }

    public void setUrlFilePer(String urlFilePer) {
        this.urlFilePer = urlFilePer;
    }

    public String getFileNameFilePer() {
        return fileNameFilePer;
    }

    public void setFileNameFilePer(String fileNameFilePer) {
        this.fileNameFilePer = fileNameFilePer;
    }

    private static final long serialVersionUID = 1L;
}
