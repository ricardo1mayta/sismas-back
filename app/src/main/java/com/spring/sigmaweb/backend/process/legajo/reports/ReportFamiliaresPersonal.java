package com.spring.sigmaweb.backend.process.legajo.reports;

import javax.persistence.*;
import java.io.Serializable;

@SqlResultSetMapping(name="ReportFamiliaresPersonal", entities = @EntityResult(
        entityClass = ReportFamiliaresPersonal.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "ape_Paterno", column = "ape_Paterno"),
        @FieldResult(name = "ape_Materno", column = "ape_Materno"),
        @FieldResult(name = "nombres", column = "nombres"),
        @FieldResult(name = "obra", column = "obra"),
        @FieldResult(name = "codigo_interno", column = "codigo_interno"),
        @FieldResult(name = "ape_Paterno_familiar", column = "ape_Paterno_familiar"),
        @FieldResult(name = "ape_Materno_familiar", column = "ape_Materno_familiar"),
        @FieldResult(name = "nombre_familiar", column = "nombre_familiar"),
        @FieldResult(name = "parentesco_familiar", column = "parentesco_familiar"),
        @FieldResult(name = "sexo_familiar", column = "sexo_familiar"),
        @FieldResult(name = "fecha_nacimiento_familiar", column = "fecha_nacimiento_familiar")}
    )
)

@Entity
public class ReportFamiliaresPersonal implements Serializable {
    @Id
    private Long id;

    private String ape_Paterno;
    private String ape_Materno;
    private String nombres;
    private String obra;
    private String codigo_interno;
    private String ape_Paterno_familiar;
    private String ape_Materno_familiar;
    private String nombre_familiar;
    private String parentesco_familiar;
    private String sexo_familiar;
    private String fecha_nacimiento_familiar;

    public ReportFamiliaresPersonal(){
        super();
    }

    public ReportFamiliaresPersonal(Long id, String ape_Paterno, String ape_Materno, String nombres, String obra, String codigo_interno, String ape_Paterno_familiar, String ape_Materno_familiar, String nombre_familiar, String parentesco_familiar, String sexo_familiar, String fecha_nacimiento_familiar) {
        this.id = id;
        this.ape_Paterno = ape_Paterno;
        this.ape_Materno = ape_Materno;
        this.nombres = nombres;
        this.obra = obra;
        this.codigo_interno = codigo_interno;
        this.ape_Paterno_familiar = ape_Paterno_familiar;
        this.ape_Materno_familiar = ape_Materno_familiar;
        this.nombre_familiar = nombre_familiar;
        this.parentesco_familiar = parentesco_familiar;
        this.sexo_familiar = sexo_familiar;
        this.fecha_nacimiento_familiar = fecha_nacimiento_familiar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApe_Paterno() {
        return ape_Paterno;
    }

    public void setApe_Paterno(String ape_Paterno) {
        this.ape_Paterno = ape_Paterno;
    }

    public String getApe_Materno() {
        return ape_Materno;
    }

    public void setApe_Materno(String ape_Materno) {
        this.ape_Materno = ape_Materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(String codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public String getApe_Paterno_familiar() {
        return ape_Paterno_familiar;
    }

    public void setApe_Paterno_familiar(String ape_Paterno_familiar) {
        this.ape_Paterno_familiar = ape_Paterno_familiar;
    }

    public String getApe_Materno_familiar() {
        return ape_Materno_familiar;
    }

    public void setApe_Materno_familiar(String ape_Materno_familiar) {
        this.ape_Materno_familiar = ape_Materno_familiar;
    }

    public String getNombre_familiar() {
        return nombre_familiar;
    }

    public void setNombre_familiar(String nombre_familiar) {
        this.nombre_familiar = nombre_familiar;
    }

    public String getParentesco_familiar() {
        return parentesco_familiar;
    }

    public void setParentesco_familiar(String parentesco_familiar) {
        this.parentesco_familiar = parentesco_familiar;
    }

    public String getSexo_familiar() {
        return sexo_familiar;
    }

    public void setSexo_familiar(String sexo_familiar) {
        this.sexo_familiar = sexo_familiar;
    }

    public String getFecha_nacimiento_familiar() {
        return fecha_nacimiento_familiar;
    }

    public void setFecha_nacimiento_familiar(String fecha_nacimiento_familiar) {
        this.fecha_nacimiento_familiar = fecha_nacimiento_familiar;
    }
}
