package com.spring.sigmaweb.backend.process.surveys.model.report;

import javax.persistence.*;
import java.io.Serializable;
@SqlResultSetMapping(name="ReportEstadoEvaluacionEvaluadorEvaluado", entities = @EntityResult(
        entityClass = ReportEstadoEvaluacionEvaluadorEvaluado.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "idObra", column = "idObra"),
        @FieldResult(name = "idPerido", column = "idPerido"),
        @FieldResult(name = "anioPerido", column = "anioPerido"),
        @FieldResult(name = "idEvento", column = "idEvento"),
        @FieldResult(name = "idPersonalMaev", column = "idPersonalMaev"),
        @FieldResult(name = "nomCompletoEvaluador", column = "nomCompletoEvaluador"),
        @FieldResult(name = "nomCompletoEvaluado", column = "nomCompletoEvaluado"),
        @FieldResult(name = "codigoperPereval", column = "codigoperPereval"),
        @FieldResult(name = "nrodocPers", column = "nrodocPers"),
        @FieldResult(name = "idTipoGo", column = "idTipoGo"),
        @FieldResult(name = "descripcionTipoGo", column = "descripcionTipoGo"),
        @FieldResult(name = "idTipoNivelPlanilla", column = "idTipoNivelPlanilla"),
        @FieldResult(name = "descTipoNivelPlanilla", column = "descTipoNivelPlanilla"),
        @FieldResult(name = "programados", column = "programados"),
        @FieldResult(name = "completos", column = "completos"),
        @FieldResult(name = "pendientes", column = "pendientes"),}
    )
)

@Entity
public class ReportEstadoEvaluacionEvaluadorEvaluado implements Serializable {
    @Id
    private Long id;
    private String idObra;
    private Long idPerido;
    private Integer anioPerido;
    private Long idEvento;
    private Long idPersonalMaev;
    private String nomCompletoEvaluador;
    private String nomCompletoEvaluado;
    private String codigoperPereval;
    private String nrodocPers;
    private Integer idTipoGo;
    private String descripcionTipoGo;
    private Integer idTipoNivelPlanilla;
    private String descTipoNivelPlanilla;
    private Integer programados;
    private Integer completos;
    private Integer pendientes;

    public ReportEstadoEvaluacionEvaluadorEvaluado(){
        super();
    }

    public ReportEstadoEvaluacionEvaluadorEvaluado(Long id, String idObra, Long idPerido, Integer anioPerido, Long idEvento, Long idPersonalMaev, String nomCompletoEvaluador, String nomCompletoEvaluado, String codigoperPereval, String nrodocPers, Integer idTipoGo, String descripcionTipoGo, Integer idTipoNivelPlanilla, String descTipoNivelPlanilla, Integer programados, Integer completos, Integer pendientes) {
        this.id = id;
        this.idObra = idObra;
        this.idPerido = idPerido;
        this.anioPerido = anioPerido;
        this.idEvento = idEvento;
        this.idPersonalMaev = idPersonalMaev;
        this.nomCompletoEvaluador = nomCompletoEvaluador;
        this.nomCompletoEvaluado = nomCompletoEvaluado;
        this.codigoperPereval = codigoperPereval;
        this.nrodocPers = nrodocPers;
        this.idTipoGo = idTipoGo;
        this.descripcionTipoGo = descripcionTipoGo;
        this.idTipoNivelPlanilla = idTipoNivelPlanilla;
        this.descTipoNivelPlanilla = descTipoNivelPlanilla;
        this.programados = programados;
        this.completos = completos;
        this.pendientes = pendientes;
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

    public Long getIdPerido() {
        return idPerido;
    }

    public void setIdPerido(Long idPerido) {
        this.idPerido = idPerido;
    }

    public Integer getAnioPerido() {
        return anioPerido;
    }

    public void setAnioPerido(Integer anioPerido) {
        this.anioPerido = anioPerido;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdPersonalMaev() {
        return idPersonalMaev;
    }

    public void setIdPersonalMaev(Long idPersonalMaev) {
        this.idPersonalMaev = idPersonalMaev;
    }

    public String getNomCompletoEvaluador() {
        return nomCompletoEvaluador;
    }

    public void setNomCompletoEvaluador(String nomCompletoEvaluador) {
        this.nomCompletoEvaluador = nomCompletoEvaluador;
    }

    public String getNomCompletoEvaluado() {
        return nomCompletoEvaluado;
    }

    public void setNomCompletoEvaluado(String nomCompletoEvaluado) {
        this.nomCompletoEvaluado = nomCompletoEvaluado;
    }

    public Integer getIdTipoGo() {
        return idTipoGo;
    }

    public void setIdTipoGo(Integer idTipoGo) {
        this.idTipoGo = idTipoGo;
    }

    public String getDescripcionTipoGo() {
        return descripcionTipoGo;
    }

    public void setDescripcionTipoGo(String descripcionTipoGo) {
        this.descripcionTipoGo = descripcionTipoGo;
    }

    public Integer getIdTipoNivelPlanilla() {
        return idTipoNivelPlanilla;
    }

    public void setIdTipoNivelPlanilla(Integer idTipoNivelPlanilla) {
        this.idTipoNivelPlanilla = idTipoNivelPlanilla;
    }

    public String getDescTipoNivelPlanilla() {
        return descTipoNivelPlanilla;
    }

    public void setDescTipoNivelPlanilla(String descTipoNivelPlanilla) {
        this.descTipoNivelPlanilla = descTipoNivelPlanilla;
    }

    public Integer getProgramados() {
        return programados;
    }

    public void setProgramados(Integer programados) {
        this.programados = programados;
    }

    public Integer getCompletos() {
        return completos;
    }

    public void setCompletos(Integer completos) {
        this.completos = completos;
    }

    public Integer getPendientes() {
        return pendientes;
    }

    public void setPendientes(Integer pendientes) {
        this.pendientes = pendientes;
    }

    public String getCodigoperPereval() {
        return codigoperPereval;
    }

    public void setCodigoperPereval(String codigoperPereval) {
        this.codigoperPereval = codigoperPereval;
    }

    public String getNrodocPers() {
        return nrodocPers;
    }

    public void setNrodocPers(String nrodocPers) {
        this.nrodocPers = nrodocPers;
    }
}
