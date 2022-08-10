package com.spring.sigmaweb.backend.process.surveys.model.report;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportNoParticipan", entities = @EntityResult(
        entityClass = ReportNoParticipan.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "id_personal", column = "id_personal"),
        @FieldResult(name = "ape_paterno_pers", column = "ape_paterno_pers"),
        @FieldResult(name = "ape_materno_pers", column = "ape_materno_pers"),
        @FieldResult(name = "nombre_pers", column = "nombre_pers"),
        @FieldResult(name = "numprog", column = "numprog"),
        @FieldResult(name = "condicion", column = "condicion"),}
    )
)

@Entity
public class ReportNoParticipan implements Serializable {
    @Id
    private  Long id;

    private Long id_personal;
    private String ape_paterno_pers;
    private String ape_materno_pers;
    private String nombre_pers;
    private Integer numprog;
    private String condicion;

    public ReportNoParticipan(){
        super();
    }

    public ReportNoParticipan(Long id, Long id_personal, String ape_paterno_pers, String ape_materno_pers, String nombre_pers, Integer numprog, String condicion) {
        this.id = id;
        this.id_personal = id_personal;
        this.ape_paterno_pers = ape_paterno_pers;
        this.ape_materno_pers = ape_materno_pers;
        this.nombre_pers = nombre_pers;
        this.numprog = numprog;
        this.condicion = condicion;
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

    public Integer getNumprog() {
        return numprog;
    }

    public void setNumprog(Integer numprog) {
        this.numprog = numprog;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
}
