package com.spring.sigmaweb.backend.process.surveys.model.report;


import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="GraficosDirectoresPromedio", entities = @EntityResult(
        entityClass = GraficosDirectoresPromedio.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "idObra", column = "idObra"),
        @FieldResult(name = "idPersonal", column = "idPersonal"),
        @FieldResult(name = "apepatPersona", column = "apepatPersona"),
        @FieldResult(name = "apematPersona", column = "apematPersona"),
        @FieldResult(name = "nombrePersona", column = "nombrePersona"),
        @FieldResult(name = "cargoPrincipal", column = "cargoPrincipal"),
        @FieldResult(name = "idCargoPuesto", column = "idCargoPuesto"),
        @FieldResult(name = "nombrePuesto", column = "nombrePuesto"),
        @FieldResult(name = "idGrupoOcupacional", column = "idGrupoOcupacional"),
       // @FieldResult(name = "id_cargopuesto_pereval", column = "id_cargopuesto_pereval"),
        @FieldResult(name = "idTipoCompetencia", column = "idTipoCompetencia"),
        @FieldResult(name = "promTipocomp", column = "promTipocomp"),}
    )
)

@Entity
public class GraficosDirectoresPromedio implements Serializable {

    @Id
    private Long id;

    private String idObra;
    private Long idPersonal;
    private String apepatPersona;
    private String apematPersona;
    private String nombrePersona;
    private Boolean cargoPrincipal;
    private Long idCargoPuesto;
    private String nombrePuesto;
    private Integer idGrupoOcupacional;
    private String idTipoCompetencia;
    private Double promTipocomp;

    public GraficosDirectoresPromedio(){
        super();
    }

    public GraficosDirectoresPromedio(Long id, String idObra, Long idPersonal, String apepatPersona, String apematPersona, String nombrePersona, Boolean cargoPrincipal, Long idCargoPuesto, String nombrePuesto, Integer idGrupoOcupacional, String idTipoCompetencia, Double promTipocomp) {
        this.id = id;
        this.idObra = idObra;
        this.idPersonal = idPersonal;
        this.apepatPersona = apepatPersona;
        this.apematPersona = apematPersona;
        this.nombrePersona = nombrePersona;
        this.cargoPrincipal = cargoPrincipal;
        this.idCargoPuesto = idCargoPuesto;
        this.nombrePuesto = nombrePuesto;
        this.idGrupoOcupacional = idGrupoOcupacional;
        this.idTipoCompetencia = idTipoCompetencia;
        this.promTipocomp = promTipocomp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdObra() {
        return idObra;
    }

    public void setIdObra(String idObra) {
        this.idObra = idObra;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getApepatPersona() {
        return apepatPersona;
    }

    public void setApepatPersona(String apepatPersona) {
        this.apepatPersona = apepatPersona;
    }

    public String getApematPersona() {
        return apematPersona;
    }

    public void setApematPersona(String apematPersona) {
        this.apematPersona = apematPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Boolean getCargoPrincipal() {
        return cargoPrincipal;
    }

    public void setCargoPrincipal(Boolean cargoPrincipal) {
        this.cargoPrincipal = cargoPrincipal;
    }

    public Long getIdCargoPuesto() {
        return idCargoPuesto;
    }

    public void setIdCargoPuesto(Long idCargoPuesto) {
        this.idCargoPuesto = idCargoPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public Integer getIdGrupoOcupacional() {
        return idGrupoOcupacional;
    }

    public void setIdGrupoOcupacional(Integer idGrupoOcupacional) {
        this.idGrupoOcupacional = idGrupoOcupacional;
    }

    public String getIdTipoCompetencia() {
        return idTipoCompetencia;
    }

    public void setIdTipoCompetencia(String idTipoCompetencia) {
        this.idTipoCompetencia = idTipoCompetencia;
    }

    public Double getPromTipocomp() {
        return promTipocomp;
    }

    public void setPromTipocomp(Double promTipocomp) {
        this.promTipocomp = promTipocomp;
    }
}
