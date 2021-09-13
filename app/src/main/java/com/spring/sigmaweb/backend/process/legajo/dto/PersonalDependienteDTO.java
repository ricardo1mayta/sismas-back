package com.spring.sigmaweb.backend.process.legajo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PersonalDependienteDTO implements Serializable {
    private Long idPersonalDep ;
    private Long idPersonal ;
    private String idobra;
    private Integer idparentPerDep ;
    private String descparentPerDep ;
    private Boolean flgvive ;
    private String nombrePerDep ;
    private String apPaternoPerDep ;
    private String apMaternoPerDep ;
    private Byte sexoAPerDep ;
    private Integer idEstcivPerDep ;
    private String descEstcivPerDep ;
    private Integer idTipodocPerDep ;
    private String descTipodocPerDep ;
    private String nroDocPerDep ;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacPerDep ;

    private String telefonoPerDep ;
    private String nacionalidadPerDep;
    private Long gradoAcademicoPerDep ;
    private String nombreGrado;
    private Long idNivel;
    private String nombreNvel;
    private Long idFormacion;
    private String nombreFormacion;

    private Boolean flgEstudiaActPerDep ;
    private String nombreInstEducPerDep ;
    private String creaPorPerDep ;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaIngPerDep ;

    private String modiPorPerDep;

    public PersonalDependienteDTO(Long idPersonalDep, Long idPersonal, String idobra, Integer idparentPerDep,
                                  String descparentPerDep, Boolean flgvive, String nombrePerDep, String apPaternoPerDep,
                                  String apMaternoPerDep, Byte sexoAPerDep, Integer idEstcivPerDep, String descEstcivPerDep,
                                  Integer idTipodocPerDep, String descTipodocPerDep, String nroDocPerDep, Date fechaNacPerDep,
                                  String telefonoPerDep, String nacionalidadPerDep, Long gradoAcademicoPerDep, String nombreGrado,
                                  Long idNivel, String nombreNvel, Long idFormacion, String nombreFormacion, Boolean flgEstudiaActPerDep,
                                  String nombreInstEducPerDep, String creaPorPerDep, Date fechaIngPerDep, String modiPorPerDep) {
        super();
        this.idPersonalDep = idPersonalDep;
        this.idPersonal = idPersonal;
        this.idobra = idobra;
        this.idparentPerDep = idparentPerDep;
        this.descparentPerDep = descparentPerDep;
        this.flgvive = flgvive;
        this.nombrePerDep = nombrePerDep;
        this.apPaternoPerDep = apPaternoPerDep;
        this.apMaternoPerDep = apMaternoPerDep;
        this.sexoAPerDep = sexoAPerDep;
        this.idEstcivPerDep = idEstcivPerDep;
        this.descEstcivPerDep = descEstcivPerDep;
        this.idTipodocPerDep = idTipodocPerDep;
        this.descTipodocPerDep = descTipodocPerDep;
        this.nroDocPerDep = nroDocPerDep;
        this.fechaNacPerDep = fechaNacPerDep;
        this.telefonoPerDep = telefonoPerDep;
        this.nacionalidadPerDep = nacionalidadPerDep;
        this.gradoAcademicoPerDep = gradoAcademicoPerDep;
        this.nombreGrado = nombreGrado;
        this.idNivel = idNivel;
        this.nombreNvel = nombreNvel;
        this.idFormacion = idFormacion;
        this.nombreFormacion = nombreFormacion;
        this.flgEstudiaActPerDep = flgEstudiaActPerDep;
        this.nombreInstEducPerDep = nombreInstEducPerDep;
        this.creaPorPerDep = creaPorPerDep;
        this.fechaIngPerDep = fechaIngPerDep;
        this.modiPorPerDep = modiPorPerDep;
    }

    public PersonalDependienteDTO() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Long getIdPersonalDep() {
        return idPersonalDep;
    }


    public void setIdPersonalDep(Long idPersonalDep) {
        this.idPersonalDep = idPersonalDep;
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


    public Integer getIdparentPerDep() {
        return idparentPerDep;
    }


    public void setIdparentPerDep(Integer idparentPerDep) {
        this.idparentPerDep = idparentPerDep;
    }


    public String getDescparentPerDep() {
        return descparentPerDep;
    }


    public void setDescparentPerDep(String descparentPerDep) {
        this.descparentPerDep = descparentPerDep;
    }


    public Boolean getFlgvive() {
        return flgvive;
    }


    public void setFlgvive(Boolean flgvive) {
        this.flgvive = flgvive;
    }


    public String getNombrePerDep() {
        return nombrePerDep;
    }


    public void setNombrePerDep(String nombrePerDep) {
        this.nombrePerDep = nombrePerDep;
    }


    public String getApPaternoPerDep() {
        return apPaternoPerDep;
    }


    public void setApPaternoPerDep(String apPaternoPerDep) {
        this.apPaternoPerDep = apPaternoPerDep;
    }


    public String getApMaternoPerDep() {
        return apMaternoPerDep;
    }


    public void setApMaternoPerDep(String apMaternoPerDep) {
        this.apMaternoPerDep = apMaternoPerDep;
    }


    public Byte getSexoAPerDep() {
        return sexoAPerDep;
    }


    public void setSexoAPerDep(Byte sexoAPerDep) {
        this.sexoAPerDep = sexoAPerDep;
    }


    public Integer getIdEstcivPerDep() {
        return idEstcivPerDep;
    }


    public void setIdEstcivPerDep(Integer idEstcivPerDep) {
        this.idEstcivPerDep = idEstcivPerDep;
    }


    public String getDescEstcivPerDep() {
        return descEstcivPerDep;
    }


    public void setDescEstcivPerDep(String descEstcivPerDep) {
        this.descEstcivPerDep = descEstcivPerDep;
    }


    public Integer getIdTipodocPerDep() {
        return idTipodocPerDep;
    }


    public void setIdTipodocPerDep(Integer idTipodocPerDep) {
        this.idTipodocPerDep = idTipodocPerDep;
    }


    public String getDescTipodocPerDep() {
        return descTipodocPerDep;
    }

    public void setDescTipodocPerDep(String descTipodocPerDep) {
        this.descTipodocPerDep = descTipodocPerDep;
    }

    public String getNroDocPerDep() {
        return nroDocPerDep;
    }

    public void setNroDocPerDep(String nroDocPerDep) {
        this.nroDocPerDep = nroDocPerDep;
    }

    public Date getFechaNacPerDep() {
        return fechaNacPerDep;
    }

    public void setFechaNacPerDep(Date fechaNacPerDep) {
        this.fechaNacPerDep = fechaNacPerDep;
    }

    public String getTelefonoPerDep() {
        return telefonoPerDep;
    }

    public void setTelefonoPerDep(String telefonoPerDep) {
        this.telefonoPerDep = telefonoPerDep;
    }

    public String getNacionalidadPerDep() {
        return nacionalidadPerDep;
    }

    public void setNacionalidadPerDep(String nacionalidadPerDep) {
        this.nacionalidadPerDep = nacionalidadPerDep;
    }

    public Long getGradoAcademicoPerDep() {
        return gradoAcademicoPerDep;
    }

    public void setGradoAcademicoPerDep(Long gradoAcademicoPerDep) {
        this.gradoAcademicoPerDep = gradoAcademicoPerDep;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombreNvel() {
        return nombreNvel;
    }

    public void setNombreNvel(String nombreNvel) {
        this.nombreNvel = nombreNvel;
    }

    public Long getIdFormacion() {
        return idFormacion;
    }

    public void setIdFormacion(Long idFormacion) {
        this.idFormacion = idFormacion;
    }

    public String getNombreFormacion() {
        return nombreFormacion;
    }

    public void setNombreFormacion(String nombreFormacion) {
        this.nombreFormacion = nombreFormacion;
    }

    public Boolean getFlgEstudiaActPerDep() {
        return flgEstudiaActPerDep;
    }

    public void setFlgEstudiaActPerDep(Boolean flgEstudiaActPerDep) {
        this.flgEstudiaActPerDep = flgEstudiaActPerDep;
    }

    public String getNombreInstEducPerDep() {
        return nombreInstEducPerDep;
    }

    public void setNombreInstEducPerDep(String nombreInstEducPerDep) {
        this.nombreInstEducPerDep = nombreInstEducPerDep;
    }

    public String getCreaPorPerDep() {
        return creaPorPerDep;
    }

    public void setCreaPorPerDep(String creaPorPerDep) {
        this.creaPorPerDep = creaPorPerDep;
    }

    public Date getFechaIngPerDep() {
        return fechaIngPerDep;
    }

    public void setFechaIngPerDep(Date fechaIngPerDep) {
        this.fechaIngPerDep = fechaIngPerDep;
    }

    public String getModiPorPerDep() {
        return modiPorPerDep;
    }

    public void setModiPorPerDep(String modiPorPerDep) {
        this.modiPorPerDep = modiPorPerDep;
    }

    private static final long serialVersionUID = 1L;
}
