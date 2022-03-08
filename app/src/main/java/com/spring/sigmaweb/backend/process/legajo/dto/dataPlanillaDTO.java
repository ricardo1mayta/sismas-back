package com.spring.sigmaweb.backend.process.legajo.dto;

import java.io.Serializable;
import java.util.Date;

public class dataPlanillaDTO implements Serializable {
    private Long idPersonal;
    private String idobra;
    private Long idPerSigma;
    private String nombrePers;
    private String apePaternoPers;
    private String apeMaternoPers;

    private String codigoPer;
    private Byte sexoPers;
    private Boolean estadoPer;

    private Integer idtipoContrato;
    private String tipoContrato;

    private Date fec_ingreso_pl;
    private String numeroEssaludPer;// nro_ipss_pl,
    private String numeroPensionPer; //cuispp_pl,

    private Long idAfp;
    private String afp_pl;

    public dataPlanillaDTO(Long idPersonal, String idobra, Long idPerSigma, String nombrePers, String apePaternoPers, String apeMaternoPers, String codigoPer, Byte sexoPers, Boolean estadoPer, Integer idtipoContrato, String tipoContrato, Date fec_ingreso_pl, String numeroEssaludPer, String numeroPensionPer, Long idAfp, String afp_pl) {
        this.idPersonal = idPersonal;
        this.idobra = idobra;
        this.idPerSigma = idPerSigma;
        this.nombrePers = nombrePers;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.codigoPer = codigoPer;
        this.sexoPers = sexoPers;
        this.estadoPer = estadoPer;
        this.idtipoContrato = idtipoContrato;
        this.tipoContrato = tipoContrato;

        this.fec_ingreso_pl = fec_ingreso_pl;
        this.numeroEssaludPer = numeroEssaludPer;
        this.numeroPensionPer = numeroPensionPer;
        this.idAfp = idAfp;
        this.afp_pl = afp_pl;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdobra() {
        return idobra;
    }

    public void setIdobra(String idobra) {
        this.idobra = idobra;
    }

    public Long getIdPerSigma() {
        return idPerSigma;
    }

    public void setIdPerSigma(Long idPerSigma) {
        this.idPerSigma = idPerSigma;
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

    public Byte getSexoPers() {
        return sexoPers;
    }

    public void setSexoPers(Byte sexoPers) {
        this.sexoPers = sexoPers;
    }

    public Boolean getEstadoPer() {
        return estadoPer;
    }

    public void setEstadoPer(Boolean estadoPer) {
        this.estadoPer = estadoPer;
    }

    public Integer getIdtipoContrato() {
        return idtipoContrato;
    }

    public void setIdtipoContrato(Integer idtipoContrato) {
        this.idtipoContrato = idtipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getFec_ingreso_pl() {
        return fec_ingreso_pl;
    }

    public void setFec_ingreso_pl(Date fec_ingreso_pl) {
        this.fec_ingreso_pl = fec_ingreso_pl;
    }

    public String getNumeroEssaludPer() {
        return numeroEssaludPer;
    }

    public void setNumeroEssaludPer(String numeroEssaludPer) {
        this.numeroEssaludPer = numeroEssaludPer;
    }

    public String getNumeroPensionPer() {
        return numeroPensionPer;
    }

    public void setNumeroPensionPer(String numeroPensionPer) {
        this.numeroPensionPer = numeroPensionPer;
    }

    public Long getIdAfp() {
        return idAfp;
    }

    public void setIdAfp(Long idAfp) {
        this.idAfp = idAfp;
    }

    public String getAfp_pl() {
        return afp_pl;
    }

    public void setAfp_pl(String afp_pl) {
        this.afp_pl = afp_pl;
    }

    private static final long serialVersionUID = 1L;
}
