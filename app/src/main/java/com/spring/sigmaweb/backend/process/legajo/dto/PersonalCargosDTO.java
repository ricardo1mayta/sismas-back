package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PersonalCargosDTO implements Serializable {
    private Long idPercargo;
    private String idObraPercargo;
    private Long idPersonal;
    private String apePaternoPers;
    private String apeMaternoPers;
    private String nombrePers;

    private Long idCargoPercargo;
    private String cargoPercargo;

    private Integer idAreaPercont;
    private String areaPercont;

    private Integer idTipoNivelPlanillaPercargo;
    private String tipoNivelPlanillaPercargo;

    private Integer idPuestoPercargo;
    private String puestoPercargo;

    private Boolean flgCargoPrincipalPercargo;
    private Boolean flgCargoDirectivoPercargo;
    private Boolean flgCargoConfianzaPercargo;

    private String observacionesPercargo;
    private Boolean estadoPercargo;
    private Double bonifCargoPercargo;
    private Double bonifCargoEstPercargo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaIniPercargo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinPercargo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngPercargo;

    private String creaPorPercargo;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaModiPercargo;

    private String modiPorPercargo;

    public PersonalCargosDTO(Long idPercargo, String idObraPercargo, Long idPersonal, String apePaternoPers, String apeMaternoPers, String nombrePers, Long idCargoPercargo, String cargoPercargo, Integer idAreaPercont, String areaPercont, Integer idTipoNivelPlanillaPercargo, String tipoNivelPlanillaPercargo, Integer idPuestoPercargo, String puestoPercargo, Boolean flgCargoPrincipalPercargo, Boolean flgCargoDirectivoPercargo, Boolean flgCargoConfianzaPercargo, String observacionesPercargo, Boolean estadoPercargo, Double bonifCargoPercargo, Double bonifCargoEstPercargo, Date fechaIniPercargo, Date fechaFinPercargo, Date fechaIngPercargo, String creaPorPercargo, Date fechaModiPercargo, String modiPorPercargo) {
        this.idPercargo = idPercargo;
        this.idObraPercargo = idObraPercargo;
        this.idPersonal = idPersonal;
        this.apePaternoPers = apePaternoPers;
        this.apeMaternoPers = apeMaternoPers;
        this.nombrePers = nombrePers;
        this.idCargoPercargo = idCargoPercargo;
        this.cargoPercargo = cargoPercargo;
        this.idAreaPercont = idAreaPercont;
        this.areaPercont = areaPercont;
        this.idTipoNivelPlanillaPercargo = idTipoNivelPlanillaPercargo;
        this.tipoNivelPlanillaPercargo = tipoNivelPlanillaPercargo;
        this.idPuestoPercargo = idPuestoPercargo;
        this.puestoPercargo = puestoPercargo;
        this.flgCargoPrincipalPercargo = flgCargoPrincipalPercargo;
        this.flgCargoDirectivoPercargo = flgCargoDirectivoPercargo;
        this.flgCargoConfianzaPercargo = flgCargoConfianzaPercargo;
        this.observacionesPercargo = observacionesPercargo;
        this.estadoPercargo = estadoPercargo;
        this.bonifCargoPercargo = bonifCargoPercargo;
        this.bonifCargoEstPercargo = bonifCargoEstPercargo;
        this.fechaIniPercargo = fechaIniPercargo;
        this.fechaFinPercargo = fechaFinPercargo;
        this.fechaIngPercargo = fechaIngPercargo;
        this.creaPorPercargo = creaPorPercargo;
        this.fechaModiPercargo = fechaModiPercargo;
        this.modiPorPercargo = modiPorPercargo;
    }

    public PersonalCargosDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getIdPercargo() {
        return idPercargo;
    }

    public void setIdPercargo(Long idPercargo) {
        this.idPercargo = idPercargo;
    }

    public String getIdObraPercargo() {
        return idObraPercargo;
    }

    public void setIdObraPercargo(String idObraPercargo) {
        this.idObraPercargo = idObraPercargo;
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

    public Long getIdCargoPercargo() {
        return idCargoPercargo;
    }

    public void setIdCargoPercargo(Long idCargoPercargo) {
        this.idCargoPercargo = idCargoPercargo;
    }

    public String getCargoPercargo() {
        return cargoPercargo;
    }

    public void setCargoPercargo(String cargoPercargo) {
        this.cargoPercargo = cargoPercargo;
    }

    public Integer getIdAreaPercont() {
        return idAreaPercont;
    }

    public void setIdAreaPercont(Integer idAreaPercont) {
        this.idAreaPercont = idAreaPercont;
    }

    public String getAreaPercont() {
        return areaPercont;
    }

    public void setAreaPercont(String areaPercont) {
        this.areaPercont = areaPercont;
    }

    public Integer getIdTipoNivelPlanillaPercargo() {
        return idTipoNivelPlanillaPercargo;
    }

    public void setIdTipoNivelPlanillaPercargo(Integer idTipoNivelPlanillaPercargo) {
        this.idTipoNivelPlanillaPercargo = idTipoNivelPlanillaPercargo;
    }

    public String getTipoNivelPlanillaPercargo() {
        return tipoNivelPlanillaPercargo;
    }

    public void setTipoNivelPlanillaPercargo(String tipoNivelPlanillaPercargo) {
        this.tipoNivelPlanillaPercargo = tipoNivelPlanillaPercargo;
    }

    public Integer getIdPuestoPercargo() {
        return idPuestoPercargo;
    }

    public void setIdPuestoPercargo(Integer idPuestoPercargo) {
        this.idPuestoPercargo = idPuestoPercargo;
    }

    public String getPuestoPercargo() {
        return puestoPercargo;
    }

    public void setPuestoPercargo(String puestoPercargo) {
        this.puestoPercargo = puestoPercargo;
    }

    public Boolean getFlgCargoPrincipalPercargo() {
        return flgCargoPrincipalPercargo;
    }

    public void setFlgCargoPrincipalPercargo(Boolean flgCargoPrincipalPercargo) {
        this.flgCargoPrincipalPercargo = flgCargoPrincipalPercargo;
    }

    public Boolean getFlgCargoDirectivoPercargo() {
        return flgCargoDirectivoPercargo;
    }

    public void setFlgCargoDirectivoPercargo(Boolean flgCargoDirectivoPercargo) {
        this.flgCargoDirectivoPercargo = flgCargoDirectivoPercargo;
    }

    public Boolean getFlgCargoConfianzaPercargo() {
        return flgCargoConfianzaPercargo;
    }

    public void setFlgCargoConfianzaPercargo(Boolean flgCargoConfianzaPercargo) {
        this.flgCargoConfianzaPercargo = flgCargoConfianzaPercargo;
    }

    public String getObservacionesPercargo() {
        return observacionesPercargo;
    }

    public void setObservacionesPercargo(String observacionesPercargo) {
        this.observacionesPercargo = observacionesPercargo;
    }

    public Boolean getEstadoPercargo() {
        return estadoPercargo;
    }

    public void setEstadoPercargo(Boolean estadoPercargo) {
        this.estadoPercargo = estadoPercargo;
    }

    public Double getBonifCargoPercargo() {
        return bonifCargoPercargo;
    }

    public void setBonifCargoPercargo(Double bonifCargoPercargo) {
        this.bonifCargoPercargo = bonifCargoPercargo;
    }

    public Double getBonifCargoEstPercargo() {
        return bonifCargoEstPercargo;
    }

    public void setBonifCargoEstPercargo(Double bonifCargoEstPercargo) {
        this.bonifCargoEstPercargo = bonifCargoEstPercargo;
    }

    public Date getFechaIniPercargo() {
        return fechaIniPercargo;
    }

    public void setFechaIniPercargo(Date fechaIniPercargo) {
        this.fechaIniPercargo = fechaIniPercargo;
    }

    public Date getFechaFinPercargo() {
        return fechaFinPercargo;
    }

    public void setFechaFinPercargo(Date fechaFinPercargo) {
        this.fechaFinPercargo = fechaFinPercargo;
    }

    public Date getFechaIngPercargo() {
        return fechaIngPercargo;
    }

    public void setFechaIngPercargo(Date fechaIngPercargo) {
        this.fechaIngPercargo = fechaIngPercargo;
    }

    public String getCreaPorPercargo() {
        return creaPorPercargo;
    }

    public void setCreaPorPercargo(String creaPorPercargo) {
        this.creaPorPercargo = creaPorPercargo;
    }

    public Date getFechaModiPercargo() {
        return fechaModiPercargo;
    }

    public void setFechaModiPercargo(Date fechaModiPercargo) {
        this.fechaModiPercargo = fechaModiPercargo;
    }

    public String getModiPorPercargo() {
        return modiPorPercargo;
    }

    public void setModiPorPercargo(String modiPorPercargo) {
        this.modiPorPercargo = modiPorPercargo;
    }

    private static final long serialVersionUID = 1L;
}
