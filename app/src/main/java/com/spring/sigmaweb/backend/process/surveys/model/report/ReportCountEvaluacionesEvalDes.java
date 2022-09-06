package com.spring.sigmaweb.backend.process.surveys.model.report;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportCountEvaluacionesEvalDes", entities = @EntityResult(
    entityClass = ReportCountEvaluacionesEvalDes.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "apellido_paterno", column = "apellido_paterno"),
        @FieldResult(name = "apellido_materno", column = "apellido_materno"),
        @FieldResult(name = "nombres", column = "nombres"),
        @FieldResult(name = "id_go", column = "id_go"),
        @FieldResult(name = "descripcion_go", column = "descripcion_go"),
        @FieldResult(name = "num_evaluaciones", column = "num_evaluaciones"),
        @FieldResult(name = "num_evaluadores", column = "num_evaluadores")}
    )
)

@Entity
public class ReportCountEvaluacionesEvalDes implements Serializable {
    @Id
    private Long id;

    private String apellido_paterno;
    private String apellido_materno;
    private String nombres;
    private Long id_go;
    private String descripcion_go;
    private Integer num_evaluaciones;
    private Integer num_evaluadores;

    public ReportCountEvaluacionesEvalDes(){
        super();
    }

    public ReportCountEvaluacionesEvalDes(Long id, String apellido_paterno, String apellido_materno, String nombres, Long id_go, String descripcion_go, Integer num_evaluaciones, Integer num_evaluadores) {
        this.id = id;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nombres = nombres;
        this.id_go = id_go;
        this.descripcion_go = descripcion_go;
        this.num_evaluaciones = num_evaluaciones;
        this.num_evaluadores = num_evaluadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Long getId_go() {
        return id_go;
    }

    public void setId_go(Long id_go) {
        this.id_go = id_go;
    }

    public String getDescripcion_go() {
        return descripcion_go;
    }

    public void setDescripcion_go(String descripcion_go) {
        this.descripcion_go = descripcion_go;
    }

    public Integer getNum_evaluaciones() {
        return num_evaluaciones;
    }

    public void setNum_evaluaciones(Integer num_evaluaciones) {
        this.num_evaluaciones = num_evaluaciones;
    }

    public Integer getNum_evaluadores() {
        return num_evaluadores;
    }

    public void setNum_evaluadores(Integer num_evaluadores) {
        this.num_evaluadores = num_evaluadores;
    }
}
