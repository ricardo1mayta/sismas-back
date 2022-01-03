package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;

public class PersonalDatosBancariosDTO implements Serializable {
    private Long idpersonal;
    private String idobra;
    private String nombrePers;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String codigoPer;
    private Integer idTipoDocPer;
    private String descDocuPer;
    private String nroDocPers;

    private Long idEntidadHaberesPer;
    private String entidadHaberesPer;
    private Long idEntidadCtsPer;
    private String entidadCtsPer;
    private Integer idTipoMonedaCtsPer;
    private String tipoMonedaCtsPer;

    private String nroCtabacHaberesper;
    private String nroCtaintbacHaberesper;

    private String nroCtabacCtsper;
    private String nroCtaintbacCtsper;

    public PersonalDatosBancariosDTO(Long idpersonal, String idobra, String nombrePers, String apePaternoPers, String apeMaternoPers, String codigoPer,
                                  Integer idTipoDocPer, String descDocuPer, String nroDocPers, Long idEntidadHaberesPer, String entidadHaberesPer, Long idEntidadCtsPer, String entidadCtsPer,
                                  Integer idTipoMonedaCtsPer, String tipoMonedaCtsPer, String nroCtabacHaberesper, String nroCtaintbacHaberesper, String nroCtabacCtsper,
                                  String nroCtaintbacCtsper) {
        this.idpersonal = idpersonal;
        this.idobra = idobra;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.codigoPer = codigoPer;
        this.idTipoDocPer = idTipoDocPer;
        this.descDocuPer = descDocuPer;
        this.nroDocPers = nroDocPers;
        this.idEntidadHaberesPer = idEntidadHaberesPer;
        this.entidadHaberesPer = entidadHaberesPer;
        this.idEntidadCtsPer = idEntidadCtsPer;
        this.entidadCtsPer = entidadCtsPer;
        this.idTipoMonedaCtsPer = idTipoMonedaCtsPer;
        this.tipoMonedaCtsPer = tipoMonedaCtsPer;
        this.nroCtabacHaberesper = nroCtabacHaberesper;
        this.nroCtaintbacHaberesper = nroCtaintbacHaberesper;
        this.nroCtabacCtsper = nroCtabacCtsper;
        this.nroCtaintbacCtsper = nroCtaintbacCtsper;
    }
    public PersonalDatosBancariosDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Long idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        this.nombrePers = nombrePers;
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

    public String getCodigoPer() {
        return codigoPer;
    }

    public void setCodigoPer(String codigoPer) {
        this.codigoPer = codigoPer;
    }

    public Integer getIdTipoDocPer() {
        return idTipoDocPer;
    }

    public void setIdTipoDocPer(Integer idTipoDocPer) {
        this.idTipoDocPer = idTipoDocPer;
    }

    public String getDescDocuPer() {
        return descDocuPer;
    }

    public void setDescDocuPer(String descDocuPer) {
        this.descDocuPer = descDocuPer;
    }

    public String getNroDocPers() {
        return nroDocPers;
    }

    public void setNroDocPers(String nroDocPers) {
        this.nroDocPers = nroDocPers;
    }

    public Long getIdEntidadHaberesPer() {
        return idEntidadHaberesPer;
    }

    public void setIdEntidadHaberesPer(Long idEntidadHaberesPer) {
        this.idEntidadHaberesPer = idEntidadHaberesPer;
    }

    public String getEntidadHaberesPer() {
        return entidadHaberesPer;
    }

    public void setEntidadHaberesPer(String entidadHaberesPer) {
        this.entidadHaberesPer = entidadHaberesPer;
    }

    public Long getIdEntidadCtsPer() {
        return idEntidadCtsPer;
    }

    public void setIdEntidadCtsPer(Long idEntidadCtsPer) {
        this.idEntidadCtsPer = idEntidadCtsPer;
    }

    public String getEntidadCtsPer() {
        return entidadCtsPer;
    }

    public void setEntidadCtsPer(String entidadCtsPer) {
        this.entidadCtsPer = entidadCtsPer;
    }

    public Integer getIdTipoMonedaCtsPer() {
        return idTipoMonedaCtsPer;
    }

    public void setIdTipoMonedaCtsPer(Integer idTipoMonedaCtsPer) {
        this.idTipoMonedaCtsPer = idTipoMonedaCtsPer;
    }

    public String getTipoMonedaCtsPer() {
        return tipoMonedaCtsPer;
    }

    public void setTipoMonedaCtsPer(String tipoMonedaCtsPer) {
        this.tipoMonedaCtsPer = tipoMonedaCtsPer;
    }

    public String getNroCtabacHaberesper() {
        return nroCtabacHaberesper;
    }

    public void setNroCtabacHaberesper(String nroCtabacHaberesper) {
        this.nroCtabacHaberesper = nroCtabacHaberesper;
    }

    public String getNroCtaintbacHaberesper() {
        return nroCtaintbacHaberesper;
    }

    public void setNroCtaintbacHaberesper(String nroCtaintbacHaberesper) {
        this.nroCtaintbacHaberesper = nroCtaintbacHaberesper;
    }

    public String getNroCtabacCtsper() {
        return nroCtabacCtsper;
    }

    public void setNroCtabacCtsper(String nroCtabacCtsper) {
        this.nroCtabacCtsper = nroCtabacCtsper;
    }

    public String getNroCtaintbacCtsper() {
        return nroCtaintbacCtsper;
    }

    public void setNroCtaintbacCtsper(String nroCtaintbacCtsper) {
        this.nroCtaintbacCtsper = nroCtaintbacCtsper;
    }

    private static final long serialVersionUID = 1L;
}
