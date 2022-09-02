package com.spring.sigmaweb.backend.process.surveys.model.report;


import javax.persistence.*;

@SqlResultSetMapping(name="ReportGeneralEvaluacionDesemp", entities = @EntityResult(
        entityClass = ReportGeneralEvaluacionDesemp.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "id_personal", column = "id_personal"),
        @FieldResult(name = "grupo_ocupacional", column = "grupo_ocupacional"),
        @FieldResult(name = "tipo_competencia_prome", column = "tipo_competencia_prome"),
        @FieldResult(name = "id_competencia", column = "id_competencia"),
        @FieldResult(name = "descripcion_compe", column = "descripcion_compe"),
        @FieldResult(name = "promedioCompe", column = "promedioCompe"),
        @FieldResult(name = "promedioAuto", column = "promedioAuto"),
        @FieldResult(name = "promedio", column = "promedio"),
        @FieldResult(name = "promedio_ponderado", column = "promedio_ponderado"), }
    )
)

@Entity
public class ReportGeneralEvaluacionDesemp {
    @Id
    private Long id;

    private Long id_personal;
    private String grupo_ocupacional;
    private String tipo_competencia_prome;
    private Long id_competencia;
    private String descripcion_compe;
    private Double promedioCompe;
    private Double promedioAuto;
    private Double promedio;
    private Double promedio_ponderado;

    public ReportGeneralEvaluacionDesemp(){
        super();
    }

    public ReportGeneralEvaluacionDesemp(Long id, Long id_personal, String grupo_ocupacional, String tipo_competencia_prome, Long id_competencia, String descripcion_compe, Double promedioCompe, Double promedioAuto, Double promedio, Double promedio_ponderado) {
        this.id = id;
        this.id_personal = id_personal;
        this.grupo_ocupacional = grupo_ocupacional;
        this.tipo_competencia_prome = tipo_competencia_prome;
        this.id_competencia = id_competencia;
        this.descripcion_compe = descripcion_compe;
        this.promedioCompe = promedioCompe;
        this.promedioAuto = promedioAuto;
        this.promedio = promedio;
        this.promedio_ponderado = promedio_ponderado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_personal() {
        return id_personal;
    }

    public void setId_personal(Long id_personal) {
        this.id_personal = id_personal;
    }

    public String getGrupo_ocupacional() {
        return grupo_ocupacional;
    }

    public void setGrupo_ocupacional(String grupo_ocupacional) {
        this.grupo_ocupacional = grupo_ocupacional;
    }

    public String getTipo_competencia_prome() {
        return tipo_competencia_prome;
    }

    public void setTipo_competencia_prome(String tipo_competencia_prome) {
        this.tipo_competencia_prome = tipo_competencia_prome;
    }

    public Long getId_competencia() {
        return id_competencia;
    }

    public void setId_competencia(Long id_competencia) {
        this.id_competencia = id_competencia;
    }

    public String getDescripcion_compe() {
        return descripcion_compe;
    }

    public void setDescripcion_compe(String descripcion_compe) {
        this.descripcion_compe = descripcion_compe;
    }

    public Double getPromedioCompe() {
        return promedioCompe;
    }

    public void setPromedioCompe(Double promedioCompe) {
        this.promedioCompe = promedioCompe;
    }

    public Double getPromedioAuto() {
        return promedioAuto;
    }

    public void setPromedioAuto(Double promedioAuto) {
        this.promedioAuto = promedioAuto;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Double getPromedio_ponderado() {
        return promedio_ponderado;
    }

    public void setPromedio_ponderado(Double promedio_ponderado) {
        this.promedio_ponderado = promedio_ponderado;
    }
}
