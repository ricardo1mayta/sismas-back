package com.spring.sigmaweb.backend.process.surveys.model.report;


import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportIndividualesEvaluacionDesemp", entities = @EntityResult(
        entityClass = ReportIndividualesEvaluacionDesemp.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "ape_paterno_pers", column = "ape_paterno_pers"),
        @FieldResult(name = "ape_materno_pers", column = "ape_materno_pers"),
        @FieldResult(name = "nombre_pers", column = "nombre_pers"),
        @FieldResult(name = "grupo_ocupacional", column = "grupo_ocupacional"),
        @FieldResult(name = "descCargo", column = "descCargo"),
        @FieldResult(name = "tipo_competencia_prome", column = "tipo_competencia_prome"),
        @FieldResult(name = "descripcion_compe", column = "descripcion_compe"),
        @FieldResult(name = "descripcion_preg", column = "descripcion_preg"),
        @FieldResult(name = "promedio", column = "promedio"),
        @FieldResult(name = "promedio_auto", column = "promedio_auto"),
}
)
)

@Entity
public class ReportIndividualesEvaluacionDesemp implements Serializable {
    @Id
    private Long id;

    private String ape_paterno_pers;
    private String ape_materno_pers;
    private String nombre_pers;
    private String grupo_ocupacional;
    private String descCargo;
    private String tipo_competencia_prome;
    private String descripcion_compe;
    private String descripcion_preg;
    private Double promedio;
    private Double promedio_auto;

    public ReportIndividualesEvaluacionDesemp(){
        super();
    }

    public ReportIndividualesEvaluacionDesemp(Long id, String ape_paterno_pers, String ape_materno_pers, String nombre_pers, String grupo_ocupacional, String descCargo, String tipo_competencia_prome, String descripcion_compe, String descripcion_preg, Double promedio, Double promedio_auto) {
        this.id = id;
        this.ape_paterno_pers = ape_paterno_pers;
        this.ape_materno_pers = ape_materno_pers;
        this.nombre_pers = nombre_pers;
        this.grupo_ocupacional = grupo_ocupacional;
        this.descCargo = descCargo;
        this.tipo_competencia_prome = tipo_competencia_prome;
        this.descripcion_compe = descripcion_compe;
        this.descripcion_preg = descripcion_preg;
        this.promedio = promedio;
        this.promedio_auto = promedio_auto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApe_paterno_pers() {
        return ape_paterno_pers;
    }

    public void setApe_paterno_pers(String ape_paterno_pers) {
        this.ape_paterno_pers = ape_paterno_pers;
    }

    public String getApe_materno_pers() {
        return ape_materno_pers;
    }

    public void setApe_materno_pers(String ape_materno_pers) {
        this.ape_materno_pers = ape_materno_pers;
    }

    public String getNombre_pers() {
        return nombre_pers;
    }

    public void setNombre_pers(String nombre_pers) {
        this.nombre_pers = nombre_pers;
    }

    public String getGrupo_ocupacional() {
        return grupo_ocupacional;
    }

    public void setGrupo_ocupacional(String grupo_ocupacional) {
        this.grupo_ocupacional = grupo_ocupacional;
    }

    public String getDescCargo() {
        return descCargo;
    }

    public void setDescCargo(String descCargo) {
        this.descCargo = descCargo;
    }

    public String getTipo_competencia_prome() {
        return tipo_competencia_prome;
    }

    public void setTipo_competencia_prome(String tipo_competencia_prome) {
        this.tipo_competencia_prome = tipo_competencia_prome;
    }

    public String getDescripcion_compe() {
        return descripcion_compe;
    }

    public void setDescripcion_compe(String descripcion_compe) {
        this.descripcion_compe = descripcion_compe;
    }

    public String getDescripcion_preg() {
        return descripcion_preg;
    }

    public void setDescripcion_preg(String descripcion_preg) {
        this.descripcion_preg = descripcion_preg;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Double getPromedio_auto() {
        return promedio_auto;
    }

    public void setPromedio_auto(Double promedio_auto) {
        this.promedio_auto = promedio_auto;
    }
}
